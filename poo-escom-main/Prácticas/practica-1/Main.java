/**
 * Main.java
 *
 * En este archivo se declara una clase principal con el método principal
 * de la aplicación.
 *
 * Diagrama UML:
 *
 * |----------------------------------|
 * |               Main               |
 * |----------------------------------|
 * |----------------------------------|
 * | static void main(String[] args)  |
 * |----------------------------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Práctica Número: 1
 * ~ Tema: Interfaces Gráficas de Usuario (GUIs) simples.
 * ~ Opción: 9 "Juego de Adivinar un número", inciso b.
 * ~ Fecha: 6 de Noviembre de 2020
 * ~ Materia: Programación Orientada a Objetos.
 */


// Clase principal.
public class Main {
  public static void main(String[] args) {
    AdivinaNumeroGUI interfaz = new AdivinaNumeroGUI(); // Al instanciar la clase se genera la ventana.
  }
}