/**
 * AdivinaNumero.java
 *
 * En este archivo se encuentra la clase con la lógica del juego "Adivina Número".
 *
 * Diagrama UML:
 *
 * |----------------------------------|
 * |          AdivinaNumero           |
 * |----------------------------------|
 * | int numero                       |
 * | int intentos                     |
 * | boolean hayGanador               |
 * |----------------------------------|
 * | int realizarIntento(int valor)   |
 * | int obtenerIntentosDisponibles() |
 * | boolean hayGanador()             |
 * | int obtenerNumeroSecreto()       |
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


public class AdivinaNumero {
  private int numero; // Variable de instancia para almacenar el número secreto.
  private int intentos;  // Variable de instancia para almacenar el número de intentos restantes.
  private boolean hayGanador; // Variable de instancia para almacenar una bandera que indique si se ha ganado.

  // Constructor de la clase.
  public AdivinaNumero() {
    int limiteSuperior = 100; // Variable para determinar el límite superior para el número aleatorio a generar.
    int limiteInferior = 1; // Variable para determinar el límite inferior para el número aleatorio a generar.
    this.numero = (int)(Math.random() * (limiteSuperior - limiteInferior + 1) + limiteInferior); // Generamos y asignamos un número aleatorio en el rango [limiteInferior - limiteSuperior]

    this.intentos = 6; // 6 intentos al inicio.
    this.hayGanador = false; // Iniciamos sin ganador.
  }

  //  Método para realizar un intento en el juego.
  public int realizarIntento(int valor) {
    // Únicamente se permite que se hagan intentos si no ha ganado el usuario
    // y si tiene más de 0 intentos disponibles.
    if (!this.hayGanador && this.intentos > 0) {
      if (valor == this.numero) {
        this.hayGanador = true; // Colocamos la bandera en verdadero.
      } else {
        // Restamos un intento ya que no fue igual.
        this.intentos--;

        // Regresamos un valor dependiendo si es menor o mayor al número.
        if (valor < this.numero) {
          return -1; // El valor es menor.
        } else {
          return 1; // El valor es mayor.
        }
      }
    }

    // Regresamos un 0 si ya ganó o si ya no tiene intentos disponibles.
    return 0;
  }

  // Método para obtener el número de intentos disponibles.
  public int obtenerIntentosDisponibles() {
    return this.intentos;
  }

  // Método para obtener la bandera si hay ganador.
  public boolean hayGanador() {
    return this.hayGanador;
  }

  // Método para obtener el número generado aleatoriamente.
  public int obtenerNumeroSecreto() {
    return this.numero;
  }
}