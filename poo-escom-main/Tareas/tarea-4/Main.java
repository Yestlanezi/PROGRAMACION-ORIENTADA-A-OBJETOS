/**
 * Tarea: 4
 * Tema: TAD número complejo en Java.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */

// Clase principal.
public class Main {
  // Función principal.
  public static void main(String[] args) {
    // Números complejos iniciales.
    Complejo c1 = new Complejo(4,8),
             c2 = new Complejo(3, -2);

    System.out.println("Número complejo 1:");
    c1.imprimir();

    System.out.println("Número complejo 2:");
    c2.imprimir();

    Complejo resSuma = c1.sumar(c2);
    System.out.println("Suma:");
    resSuma.imprimir();

    Complejo resResta = c1.restar(c2);
    System.out.println("Resta:");
    resResta.imprimir();

    Complejo resMultiplicacion = c1.multiplicar(c2);
    System.out.println("Multiplicación:");
    resMultiplicacion.imprimir();

    Complejo resDivicion = c1.dividir(c2);
    System.out.println("División:");
    resDivicion.imprimir();

    double modulo1 = c1.modulo();
    System.out.println("\nPrimer número complejo:");
    c1.imprimir();
    System.out.println("Valor del módulo para el primer número complejo: " + modulo1);

    double modulo2 = c2.modulo();
    System.out.println("\nSegundo número complejo:");
    c2.imprimir();
    System.out.println("Valor del módulo para el segundo número complejo: " + modulo2);
  }
}
