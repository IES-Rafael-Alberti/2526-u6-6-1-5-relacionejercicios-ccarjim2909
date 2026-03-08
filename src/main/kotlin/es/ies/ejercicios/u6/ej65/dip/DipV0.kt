package es.ies.ejercicios.u6.ej65.dip

import es.ies.ejercicios.u6.ej64.InformeCsv
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.Resumible

/**
 * Abstracción que define cómo generar informes.
 * El módulo de alto nivel dependerá de esta interfaz.
 */
interface GeneradorInforme {
    fun generar(titulo: String, items: List<Resumible>): String
}

/**
 * Implementación concreta que usa CSV.
 */
class GeneradorInformeCsv : GeneradorInforme {
    private val generador = InformeCsv()

    override fun generar(titulo: String, items: List<Resumible>): String {
        return generador.generar(titulo, items)
    }
}

/**
 * Módulo de alto nivel que ahora depende de una abstracción
 * y recibe la implementación por constructor (inyección de dependencias).
 */
class ControladorInformes(private val generador: GeneradorInforme) {

    fun imprimirListado(items: List<Resumible>) {
        val salida = generador.generar("Listado DIP", items)
        println(salida)
    }
}

fun main() {

    // Se inyecta la implementación concreta
    val generador = GeneradorInformeCsv()
    val controller = ControladorInformes(generador)

    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        ),
    )
}