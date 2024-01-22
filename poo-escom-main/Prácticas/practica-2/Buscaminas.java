
/**
 * Buscaminas.java
 *
 * En este archivo se incluye la implementación de la lógica del juego Buscaminas, así como el
 * control de la interfaz gráfica de usuario general.
 *
 * Diagrama UML:
 *
 * |---------------------------------------------|
 * |                  Buscaminas                 |
 * |---------------------------------------------|
 * | JFrame ventana                              |
 * | Celda[][] celdas                            |
 * | int filas                                   |
 * | int columnas                                |
 * | int numeroMinas                             |
 * |- - - - - - - - - - - - - - - - - - - - - - -|
 * | void revelarTablero()                       |
 * | int contarMinasAlrededorDePosicion(int,int) |
 * |---------------------------------------------|
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
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

// Clase Buscaminas.
public class Buscaminas implements ActionListener {
  // Variables de instancia.
  private JFrame ventana; // La ventana del juego.
  private Celda[][] celdas; // Una matriz con las celdas del juego.
  private int filas; // El número de filas para el juego.
  private int columnas; // El número de columnas para el juego.
  private int numeroMinas; // El número de minas a colocar en el juego.

  // Constructor de la clase Buscaminas.
  public Buscaminas(int filasTablero, int columnasTablero, int minasTablero) {
    this.filas = filasTablero;
    this.columnas = columnasTablero;
    this.numeroMinas = minasTablero;

    // Operaciones para la interfaz gráfica de usuario.
    this.ventana = new JFrame(
        "Buscaminas " + this.filas + "x" + this.columnas + " con " + this.numeroMinas + " minas."); // El título de la
                                                                                                    // ventana es
                                                                                                    // "Buscaminas 10x10
                                                                                                    // con 5 minas.".
    this.ventana.getContentPane().setLayout(new GridLayout(this.filas, this.columnas)); // Usamos un GridLayout para que
                                                                                        // nos permita mostrar la matriz
                                                                                        // de celdas.
    this.ventana.setSize(500, 500); // El tamaño de la ventana lo dejamos fijo en 500x500.

    // Inicializamos nuestra matriz de celdas.
    this.celdas = new Celda[this.filas][this.columnas];

    // Inicializamos cada celda individualmente y la añadimos a nuestra ventana.
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        this.celdas[fila][columna] = new Celda(fila, columna, this);
        this.ventana.getContentPane().add(this.celdas[fila][columna]);
      }
    }

    // Colocamos las minas.
    Random rand = new Random();
    int filaRandom, columnaRandom;
    for (int minasRandom = 0; minasRandom < this.numeroMinas; minasRandom++) {
      // Generamos nuevas coordenadas hasta que sea en un lugar dónde no haya una mina
      // previamente.
      do {
        filaRandom = rand.nextInt(this.filas);
        columnaRandom = rand.nextInt(this.columnas);
      } while (this.celdas[filaRandom][columnaRandom].esMina());

      // Hacemos la celda una mina.
      this.celdas[filaRandom][columnaRandom].ajustarValor(Celda.MINA);
    }

    // Calculamos los números para todas las celdas restantes.
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        // Verificamos si la celda NO es una mina.
        if (!this.celdas[fila][columna].esMina()) {
          // Asignamos la cuenta de minas alrededor de la celda al valor de la celda.
          this.celdas[fila][columna].ajustarValor(this.contarMinasAlrededorDePosicion(fila, columna));
        }
      }
    }

    // Tareas finales para la ventana.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Si cerramos la ventana finaliza el
                                                                          // programa.
  }

  // Listener para los eventos de a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos la celda origen del evento.
    Celda celdaOrigen = (Celda) evento.getSource();

    // Descubrimos la celda (sea cual sea el caso).
    celdaOrigen.descubrir();

    // La volvemos opaca para poder pintarla de un color.
    celdaOrigen.setOpaque(true);

    // Si es una mina, pintamos la celda de rojo y revelamos todo el tablero, en
    // caso contrario, pintamos la
    // celda en verde.
    if (celdaOrigen.esMina()) {
      this.revelarTablero();
      celdaOrigen.setBackground(Color.red);
    } else {
      celdaOrigen.setBackground(Color.lightGray);
    }
  }

  // Método que "descubre" todas las celdas del tablero.
  private void revelarTablero() {
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        this.celdas[fila][columna].descubrir();
      }
    }
  }

  // Método que cuenta las minas alrededor de una posición determinada en nuestro
  // tablero.
  private int contarMinasAlrededorDePosicion(int posFila, int posColumna) {
    // Inicializamos nuestro contador en 0.
    int contadorMinas = 0;

    // Iteramos desde la fila superior hasta la fila inferior a la celda actual
    // respetando límites, lo mismo para columnas.
    for (int filaARevisar = (posFila - 1) >= 0 ? (posFila - 1) : 0; filaARevisar < this.filas
        && filaARevisar <= (posFila + 1); filaARevisar++) {
      for (int columnaARevisar = (posColumna - 1) >= 0 ? (posColumna - 1) : 0; columnaARevisar < this.columnas
          && columnaARevisar <= (posColumna + 1); columnaARevisar++) {
        // Verificamos que no sea la celda que estamos revisando.
        if (filaARevisar != posFila || columnaARevisar != posColumna) {
          // Si la celda es una mina, aumentamos el contador.
          if (this.celdas[filaARevisar][columnaARevisar].esMina()) {
            contadorMinas++;
          }
        }
      }
    }

    // Regresamos el valor que contenga nuestro contador.
    return contadorMinas;
  }

  /**
   * Método principal. Este método crea una instancia de Buscaminas con lo cual se
   * ejecuta el juego.
   */
  public static void main(String[] args) {
    // 10 filas y 10 columnas.
    int filasBuscaminas = 10;
    int columnasBuscaminas = 10;
    int minas = 10;

    // Al instanciar la clase, se inicia la ventana.
    new Buscaminas(filasBuscaminas, columnasBuscaminas, minas);
  }
}
