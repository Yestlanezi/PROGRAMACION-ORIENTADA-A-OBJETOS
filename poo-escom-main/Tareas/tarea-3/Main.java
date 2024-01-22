/**
 * Tarea: 3
 * Tema: Suma y Resta de dos números racionales en Java.
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
    Racional r1 = new Racional(2,3);
    System.out.println("Primer número racional:");
    r1.imprime();

    Racional r2 = new Racional(3,2);
    System.out.println("Segundo número racional:");
    r2.imprime();

    Racional suma = r1.suma(r2);
    System.out.println("Resultado de la suma:");
    suma.imprime();

    Racional resta = r1.resta(r2);
    System.out.println("Resultado de la resta:");
    resta.imprime();
  }
}
