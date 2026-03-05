import es.ies.ejercicios.u6.ej61.*
import es.ies.ejercicios.u6.ej62.*
import es.ies.ejercicios.u6.ej63.*
import es.ies.ejercicios.u6.ej64.*
import es.ies.ejercicios.u6.ej65.*


fun main() {
    println("Unidad 6 — Ejercicios 6.1 a 6.5")
    println("Implementa cada ejercicio en su paquete y documenta en docs/ejercicios/6.x.md")



    println("\nUnidad 6 — Ejercicio 6.1")

    val perro = Perro("Lia", "perro", "guau", "Labrador")
    val zarigueya = Zarigüeya("Zari", "zarigüeya", "chilla")
    val gato = Gato("Persephone", "miau")
    val leon = Leon("Simba", "grrr")

    println("\nExtension:\n")
    println(perro.nombre())
    println(perro.tipoRaza())
    println(zarigueya.nombre())

    println("\nEspecializacion:\n")
    println(perro.onomatopeya())
    println(zarigueya.onomatopeya())
    println(gato.onomatopeya())
    println(leon.onomatopeya())


    println("\nUnidad 6 — Ejercicio 6.2")





    println("\nUnidad 6 — Ejercicio 6.3")

    val rectangulo1 = Rectangulo("rojo","rectangulo especial", 10, 5)

    println(rectangulo1)
}

