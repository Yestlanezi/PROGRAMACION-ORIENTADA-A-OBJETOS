
/**
 * TresBotones.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 10
 * Planteamiento: Codificar un applet que tenga tres botones y una etiqueta, y que si se presiona un botón entonces
 *                se muestre el texto que esta dentro del botón (Manzana, Limón o Naranja) en la etiqueta.
 *
 * Modelado:
 *
 * |-------------------|
 * |    TresBotones    |
 * |-------------------|
 * | botonManzana      |
 * | botonLimon        |
 * | botonNaranja      |
 * | etiquetaResultado |
 * | ventana           |
 * | - - - - - - - - - |
 * |-------------------|
 *
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: Miércoles 11 de Noviembre de 2020.
 *
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * MayorDeTres
 */
public class TresBotones extends JApplet implements ActionListener {
  private JButton botonManzana; // Variable de instancia para el botón con el texto "Manzana".
  private JButton botonLimon; // Variable de instancia para el botón con el texto "Limón".
  private JButton botonNaranja; // Variable de instancia para el botón con el texto "Naranja".
  private JFrame ventana; // Variable de instancia para la ventana del Applet.
  private JLabel etiquetaResultado; // Variable de instancia con la etiqueta para mostrar el resultado de la
                                    // operación.

  // Constructor de la clase.
  public TresBotones() {
    // Configuración inicial de la ventana.
    this.ventana = new JFrame("Tres Botones"); // El título de la ventana será "Tres Botones".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que los elemento estén alineados horizontalmente.

    // Instanciación de elementos.
    this.botonManzana = new JButton("Manzana");
    this.botonLimon = new JButton("Limón");
    this.botonNaranja = new JButton("Naranja");
    this.etiquetaResultado = new JLabel("El botón presionado fue: (esperando click)");

    // Subscribimos nuestra clase a los eventos de los botones.
    this.botonManzana.addActionListener(this);
    this.botonLimon.addActionListener(this);
    this.botonNaranja.addActionListener(this);

    // Añadimos los elementos a la ventana en el orden que queremos mostrarlos.
    this.ventana.getContentPane().add(this.botonManzana);
    this.ventana.getContentPane().add(this.botonLimon);
    this.ventana.getContentPane().add(this.botonNaranja);
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Configuración final de la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Al cerrar la ventana finaliza el programa.
    this.ventana.pack(); // Ajustamos el tamaño automáticamente para los elementos en la ventana.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos el botón que generó el evento.
    JButton botonOrigen = (JButton) evento.getSource();

    // Mostramos los datos del botón corresopndiente.
    if (botonOrigen == this.botonManzana) {
      this.etiquetaResultado.setText("El botón presionado fue: Manzana");
    } else if (botonOrigen == this.botonLimon) {
      this.etiquetaResultado.setText("El botón presionado fue: Limón");
    } else if (botonOrigen == this.botonNaranja) {
      this.etiquetaResultado.setText("El botón presionado fue: Naranja");
    }
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para probar de
   * forma eficiente y rápida el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new TresBotones(); // Al instanciar la clase se muestra la ventana.
  }
}