/**
 * AdivinaNumeroGUI.java
 *
 * En este archivo se encuentra la clase con la implementación de la interfaz gráfica de
 * usuario para el juego de "Adivina el Número".
 *
 * Diagrama UML:
 *
 * |-------------------------------------------|
 * |              AdivinaNumeroGUI             |
 * |-------------------------------------------|
 * | JButton botonIntento                      |
 * | JTextField campoIntento                   |
 * | JLabel etiquetaEstado                     |
 * | JLabel etiquetaNumeroIntento              |
 * | JFrame ventana                            |
 * | AdivinaNumero juego                       |
 * |-------------------------------------------|
 * | void actionPerformed(ActionEvent evento)  |
 * |-------------------------------------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Práctica Número: 1
 * ~ Tema: Interfaces Gráficas de Usuario (GUIs) simples.
 * ~ Opción: 9 "Juego de Adivinar un número", inciso b.
 * ~ Fecha: 6 de Noviembre de 2020
 * ~ Materia: Programación Orientada a Objetos.
 */
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AdivinaNumeroGUI extends JApplet implements ActionListener {
  private JButton botonIntento;
  private JTextField campoIntento;
  private JLabel etiquetaEstado, etiquetaNumeroIntento;
  private JFrame ventana;
  private AdivinaNumero juego;

  // Constructor de la clase AdivinaNumeroGUI.
  public AdivinaNumeroGUI() {
    // Creamos una instancia del juego.
    this.juego = new AdivinaNumero();

    // Opciones para la interfaz gráfica de usuario.
    this.ventana = new JFrame("Adivina el Número"); // Creamos la ventana con el título "Adivina el Número"
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Establecemos FlowLayout para que todo esté alineado.

    this.botonIntento = new JButton("Probar número");
    this.botonIntento.addActionListener(this);

    this.campoIntento = new JTextField("Número...",7);

    this.etiquetaEstado = new JLabel("Realiza tu primer intento...");

    this.etiquetaNumeroIntento = new JLabel("Intentos disponibles: " + this.juego.obtenerIntentosDisponibles());

    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Acomodamos los elementos en el orden que deben aparecer en la ventana.
    this.ventana.getContentPane().add(this.etiquetaEstado);
    this.ventana.getContentPane().add(this.campoIntento);
    this.ventana.getContentPane().add(this.botonIntento);
    this.ventana.getContentPane().add(this.etiquetaNumeroIntento);

    // Determinamos el tamaño de la ventana automáticamente a partir de los elementos.
    this.ventana.pack();

    // Se hace visible la ventana.
    this.ventana.setVisible(true);
  }

  // Método de escucha de eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Revisamos si el usuario no ha adivinado el número y tiene intentos disponibles.
    if (!this.juego.hayGanador() && this.juego.obtenerIntentosDisponibles() > 0) {
      // Extrear el valor de la entrada.
      int valor = Integer.parseInt(this.campoIntento.getText());

      // Realizamos el intento con el valor de la entrada y almacenamos el valor de retorno.
      int resultadoIntento = this.juego.realizarIntento(valor);

      // Si el valor de retorno es 0, el usuario ya ganó (porque verificamos previamente los intentos disponibles).
      if (resultadoIntento == 0) {
        this.etiquetaEstado.setText("¡Has adivinado el número " + valor + "!");
        this.etiquetaNumeroIntento.setText("Intentos disponibles: -");
      } else if (resultadoIntento == -1) {
        // Si el valor de retorno es -1, quiere decir que el usuario ingresó un número menor al secreto.
        this.etiquetaEstado.setText("¡El número " + valor + " es menor!");
        this.etiquetaNumeroIntento.setText("Intentos disponibles: " + this.juego.obtenerIntentosDisponibles());
      } else {
        // Si el valor de retorno es  1, quiere decir que el usuario ingresó un número mayor al secreto.
        this.etiquetaEstado.setText("¡El número " + valor + " es mayor!");
        this.etiquetaNumeroIntento.setText("Intentos disponibles: " + this.juego.obtenerIntentosDisponibles());
      }
    }

    // Verificamos si el usuario ya perdió para mostrar mensaje.
    if (this.juego.obtenerIntentosDisponibles() <= 0 && !this.juego.hayGanador()) {
      this.etiquetaEstado.setText("El número era: " + this.juego.obtenerNumeroSecreto() + ", lástima.");
    }
  }
}
