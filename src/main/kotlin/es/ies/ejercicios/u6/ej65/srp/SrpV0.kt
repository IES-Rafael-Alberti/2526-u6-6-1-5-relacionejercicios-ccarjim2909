package es.ies.ejercicios.u6.ej65.srp

import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.InformeMarkdown
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.RegistroPersonas
import es.ies.ejercicios.u6.ej64.Resumible




class PreparadorDatos {

    fun obtenerItems(): List<Resumible> {
        println("[SRP] Preparando datos...")

        return listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18)
        )
    }
}

class ServicioRegistro {

    private val registro = RegistroPersonas()

    fun registrar(items: List<Resumible>) {
        println("[SRP] Registrando personas...")

        for (item in items) {
            if (item is Persona) {
                registro.registrar(item)
            }
        }
    }

    fun buscar(nombre: String): Persona? {
        return registro.buscar(nombre)
    }
}

class ServicioInforme {

    fun generar(items: List<Resumible>): String {
        println("[SRP] Generando informe Markdown...")

        val informe = InformeMarkdown()

        return informe.generar("Listado", items)
    }
}

class InformeAppService {

    private val preparador = PreparadorDatos()
    private val registro = ServicioRegistro()
    private val informe = ServicioInforme()

    fun ejecutar() {

        val items = preparador.obtenerItems()

        registro.registrar(items)

        val salida = informe.generar(items)

        println("[SRP] Resultado:")
        println(salida)

        println("[SRP] Buscar 'ana' -> ${registro.buscar("ana")?.resumen()}")
    }
}


fun main() {
    InformeAppService().ejecutar()
}

