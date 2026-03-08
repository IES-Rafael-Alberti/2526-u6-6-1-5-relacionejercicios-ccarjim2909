package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Interfaz que representa la capacidad de buscar personas.
 */
interface RepositorioLectura {
    fun buscar(nombre: String): Persona?
}

/**
 * Interfaz que representa la capacidad de guardar personas.
 */
interface RepositorioEscritura {
    fun guardar(persona: Persona)
}

/**
 * Implementación completa del repositorio que permite guardar y buscar personas.
 */
class RepositorioPersonas :
    RepositorioLectura,
    RepositorioEscritura {

    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]
}

/**
 * Repositorio que solo permite lectura.
 * No implementa escritura porque no puede cumplir ese contrato.
 */
class RepositorioSoloLectura(
    private val datos: Map<String, Persona>
) : RepositorioLectura {

    override fun buscar(nombre: String): Persona? = datos[nombre]
}

/**
 * Cliente que solo necesita buscar personas.
 * Depende únicamente de la capacidad de lectura.
 */
fun cliente(repo: RepositorioLectura) {
    println("Buscar Ana -> ${repo.buscar("Ana")?.resumen()}")
}

fun main() {

    println("[LSP] Repositorio completo")

    val repo = RepositorioPersonas()
    repo.guardar(Persona("Ana", 20))

    cliente(repo)

    println("\n[LSP] Repositorio solo lectura")

    val repoLectura = RepositorioSoloLectura(
        mapOf("Ana" to Persona("Ana", 20))
    )

    cliente(repoLectura)
}

