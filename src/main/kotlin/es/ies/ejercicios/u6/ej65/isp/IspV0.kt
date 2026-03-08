package es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Interfaz para la capacidad de guardar personas.
 */
interface RepositorioEscritura {
    fun guardar(persona: Persona)
}

/**
 * Interfaz para la capacidad de buscar personas.
 */
interface RepositorioLectura {
    fun buscar(nombre: String): Persona?
}

/**
 * Interfaz para exportar datos en CSV.
 */
interface RepositorioExportador {
    fun exportarCsv(): String
}

/**
 * Interfaz para tareas de mantenimiento del repositorio.
 */
interface RepositorioMantenimiento {
    fun borrarTodo()
}

/**
 * Implementación en memoria que soporta todas las capacidades.
 */
class RepositorioMemoria :
    RepositorioEscritura,
    RepositorioLectura,
    RepositorioExportador,
    RepositorioMantenimiento {

    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]

    override fun exportarCsv(): String =
        buildString {
            appendLine("nombre,edad")
            for (p in map.values) {
                appendLine("${p.nombre},${p.edad}")
            }
        }

    override fun borrarTodo() {
        map.clear()
    }
}

/**
 * Cliente que solo necesita buscar personas.
 * Ahora depende únicamente de la interfaz de lectura.
 */
class BuscadorPersonas(private val repo: RepositorioLectura) {

    fun buscar(nombre: String): Persona? =
        repo.buscar(nombre)
}

fun main() {

    val repo = RepositorioMemoria()

    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonas(repo)

    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}