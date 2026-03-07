package es.ies.ejercicios.u6.ej64

// Este fichero contiene ejemplos de:
// - herencia (6.1)
// - clase abstracta e interfaces (6.2)
// - constructores e init en herencia (6.3)
//
// Tu tarea (6.4) es:
// - Entender el código y su relación entre clases e interfaces.
// - Mejorar la documentación KDoc donde sea necesario.
// - Añadir comentarios solo cuando aporten valor.
// - Eliminar comentarios innecesarios o redundantes.

/**
 * Representa un elemento que puede generar un resumen en texto.
 */
interface Resumible {
    fun resumen(): String
}

/**
 * Clase abstracta que implementa el patrón plantilla para generar informes.
 *
 * Define el flujo general de generación de un informe y permite que
 * las subclases personalicen únicamente las partes variables
 * (cabecera, formato de los elementos y pie).
 *
 * Las subclases como [InformeMarkdown] e [InformeCsv] solo deben
 * implementar cómo se formatea cada elemento.
 */
abstract class PlantillaInforme : Resumible {
    /**
     * Genera un informe en formato texto con un título y una lista de elementos.
     *
     * El método sigue un flujo fijo:
     * 1. Cabecera
     * 2. Elementos formateados
     * 3. Pie del informe
     *
     * @param titulo título del informe
     * @param items lista de elementos que implementan [Resumible]
     * @return informe generado como cadena de texto
     */
    fun generar(titulo: String, items: List<Resumible>): String {
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    /**
     * Genera la cabecera del informe.
     *
     * Puede ser redefinida por las subclases para cambiar el formato.
     */
    protected open fun cabecera(titulo: String): String = titulo

    /**
     * Formatea un elemento individual del informe.
     *
     * Este método debe ser implementado por cada formato de informe.
     */
    protected abstract fun formatearItem(item: Resumible): String

    /**
     * Genera el pie del informe.
     */
    protected open fun pie(): String = "-- fin --"

    override fun resumen(): String = "PlantillaInforme"
}

class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}


/**
 * Representa una persona con nombre y edad.
 *
 * Implementa la interfaz [Resumible] para poder aparecer en informes.
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {

    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    /**
     * Constructor secundario que permite crear una persona sin especificar edad.
     */
    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    /**
     * Devuelve un resumen de la persona.
     */
    override fun resumen(): String = "$nombre ($edad)"
}

/**
 * Representa un alumno, que es un tipo de [Persona] con un curso asociado.
 */
class Alumno : Persona {

    val curso: String

    /**
     * Constructor que crea un alumno indicando nombre, edad y curso.
     */
    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    /**
     * Constructor que crea un alumno sin especificar edad.
     */
    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String =
        "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Registro sencillo de personas basado en un mapa indexado por nombre.
 *
 * Se utiliza una normalización del nombre para evitar duplicados
 * provocados por diferencias en espacios o mayúsculas/minúsculas.
 */
class RegistroPersonas {

    private val personasPorNombre = mutableMapOf<String, Persona>()

    /**
     * Registra una persona en el sistema usando su nombre normalizado como clave.
     */
    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    /**
     * Busca una persona por nombre.
     *
     * @return la persona encontrada o `null` si no existe.
     */
    fun buscar(nombre: String): Persona? =
        personasPorNombre[normalizarNombre(nombre)]

    /**
     * Normaliza un nombre eliminando espacios sobrantes y convirtiéndolo a minúsculas.
     *
     * Regla de negocio importante: evita duplicados por diferencias
     * en formato del nombre.
     */
    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
