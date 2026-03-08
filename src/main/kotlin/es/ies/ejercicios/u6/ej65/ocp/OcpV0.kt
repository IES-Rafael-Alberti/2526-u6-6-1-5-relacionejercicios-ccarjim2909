package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible



/**
 * Abstracción para generar informes en distintos formatos.
 */
interface GeneradorInforme {

    fun generar(titulo: String, items: List<Resumible>): String
}

class GeneradorCsv : GeneradorInforme {

    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")

            for (item in items) {
                appendLine(item.resumen().replace(",", ";"))
            }
        }
}

class GeneradorMarkdown : GeneradorInforme {

    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("# $titulo")

            for (item in items) {
                appendLine("- ${item.resumen()}")
            }
        }
}

class GeneradorHtml : GeneradorInforme {

    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("<h1>$titulo</h1>")
            appendLine("<ul>")

            for (item in items) {
                appendLine("<li>${item.resumen()}</li>")
            }

            appendLine("</ul>")
        }
}


fun main() {

    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        }
    )

    val generador: GeneradorInforme = GeneradorMarkdown()

    println(generador.generar("Demo OCP", items))
}

