
/**
 * Celda.java
 *
 * En este archivo se incluye la implementación de la clase Celda, con la cual se abstrae
 * un JButton y se permiten realizar operaciones con las celdas del tablero del juego de
 * Buscaminas de forma mucho más simple.
 *
 * Diagrama UML:
 *
 * |-------------------------------------------------------------------|
 * |                                Celda                              |
 * |-------------------------------------------------------------------|
 * | static final int MINA = 10                                        |
 * | static final ImageIcon ICONO_MINA = new ImageIcon("mina.png")     |
 * | int fila                                                          |
 * | int columna                                                       |
 * | int valor                                                         |
 * |- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|
 * | int obtenerValor()                                                |
 * | void ajustarValor(int)                                            |
 * | boolean esMina()                                                  |
 * | void descubrir()                                                  |
 * | int obtenerFila()                                                 |
 * | int obtenerColumna()                                              |
 * | static Icon cambiarDimensionesIconoMina(int longitud, int altura) |
 * |-------------------------------------------------------------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 2
 * ~ Tema: Arreglos de Objetos.
 * ~ Opción: 7 "Buscaminas".
 * ~ Fecha: 12 de Noviembre de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// Clase Celda.
public class Celda extends JButton {
  // Constantes de clase.
  public static final int MINA = 10; // Dado que el valor más alto para una celda puede ser de 8, 10 es un número
                                     // razonable para marcar las que son minas.
  private static final ImageIcon ICONO_MINA = new ImageIcon("mina.png"); // El ícono de "mina".

  // Variables de instancia.
  private int fila; // Para almacenar la fila de la celda actual.
  private int columna; // Para almacenar la columna de la celda actual.
  private int valor; // Para almacenar el valor de la celda actual.

  // Constructor de la clase Celda.
  public Celda(int filaI, int colI, ActionListener actionListener) {
    this.fila = filaI;
    this.columna = colI;
    this.addActionListener(actionListener);
    this.setText("");
  }

  // Método para obtener el valor de una celda.
  public int obtenerValor() {
    return this.valor;
  }

  // Método para cambiar el valor de una celda.
  public void ajustarValor(int nuevoValor) {
    this.valor = nuevoValor;
  }

  // Método para verificar si una celda es una mina.
  public boolean esMina() {
    return this.valor == MINA;
  }

  // Método que descubre una celda y muestra su contenido.
  public void descubrir() {
    // Desactivamos el botón para que no sea click-eable.
    this.setEnabled(false);

    // Verificamos si es mina o número para añadir el ícono apropiadamente.
    if (this.esMina()) {
      this.setIcon(cambiarDimensionesIconoMina(this.getWidth(), this.getHeight())); // Ícono de mina.
    } else {
      this.setText(String.valueOf(this.valor)); // Número con valor de minas alrededor.
    }
  }

  // Método para obtener la fila de la celda.
  public int obtenerFila() {
    return this.fila;
  }

  // Método para obtener la columna de la celda.
  public int obtenerColumna() {
    return this.columna;
  }

  // Método para cambiar las dimensiones del ícono de la mina dinámicamente.
  private static Icon cambiarDimensionesIconoMina(int longitud, int altura) {
    Image imagen = Celda.ICONO_MINA.getImage(); // Extraemos la imagen.
    Image imagenConNuevasDimensiones = imagen.getScaledInstance(longitud, altura, Image.SCALE_SMOOTH); // La
                                                                                                       // escalamos.
    return new ImageIcon(imagenConNuevasDimensiones); // Regresamos la imagen escalada como un ícono.
  }
}
