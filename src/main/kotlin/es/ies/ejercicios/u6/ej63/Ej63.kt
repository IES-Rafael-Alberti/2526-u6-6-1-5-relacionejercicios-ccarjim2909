package es.ies.ejercicios.u6.ej63




/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {
    println("Ejercicio 6.3 (plantilla)")
    println("- Completa la jerarquía y los constructores en `es.ies.ejercicios.u6.ej63`")
    println("- Añade logs en init/constructores para ver el orden de inicialización")
    println("- Actualiza este main para instanciar usando distintos constructores\n")



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
    

}
