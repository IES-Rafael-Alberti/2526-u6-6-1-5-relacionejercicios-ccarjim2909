package es.ies.ejercicios.u6.ej61

/**
 * Ejercicio 6.1 — Tipos de herencia, clases y subclases (RA7.a).
 *
 * TODO: Implementa aquí las clases del ejercicio.
 * Recomendación: crea subpaquetes (p. ej. `especializacion`, `extension`, etc.)
 * y añade un `main` de ejemplo que muestre polimorfismo.
 */


open class Animal(val nombre: String, val tipo: String, val sonido: String) {
    open fun onomatopeya(): String {
        return ("El animal es $tipo y hace $sonido")
    }
}



/* Extension */
class Perro(nombre: String, tipo: String, sonido: String, val raza: String) : Animal(nombre, "perro", sonido) {
    fun nombre() : String {
        return ("El perro se llama $nombre")
    }

    fun tipoRaza() : String {
        return ("La raza de $nombre es $raza")
    }
}

class Zarigüeya(nombre: String, tipo: String, sonido: String) : Animal(nombre, "zarigüeya", sonido) {
    fun nombre(): String {
        return ("La zarigüeya se llama $nombre")
    }
}




/* Especializacion */
class Gato(nombre: String, sonido: String) : Animal(nombre, "gato", sonido) {

    override fun onomatopeya(): String {
        return "El gato $nombre maulla: $sonido"
    }
}

class Leon(nombre: String,sonido: String): Animal(nombre, "leon", sonido) {

    override fun onomatopeya(): String {
        return "El leon $nombre ruge: $sonido"
    }
}
