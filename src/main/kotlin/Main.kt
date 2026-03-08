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


    println("---- Rectangulo usando constructor secundario (ancho, alto) ----")
    val r1 = Rectangulo(4, 5)

    println("\n---- Rectangulo usando constructor secundario (lado) ----")
    val r2 = Rectangulo(3)

    println("\n---- Circulo usando constructor secundario ----")
    val c1 = Circulo(10)

    println("\n---- Triangulo (subclase sin constructor primario) ----")
    val t1 = Triangulo(6, 7)

    println("\n---- Triangulo usando constructor que delega con this ----")
    val t2 = Triangulo(5)



    println("\nUnidad 6 — Ejercicio 6.4")

    // nada


    println("\nUnidad 6 — Ejercicio 6.5")



}

