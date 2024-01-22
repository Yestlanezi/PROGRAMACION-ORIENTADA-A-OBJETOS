
/**
 * CamposIguales.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 6
 * Planteamiento: Escriba un applet que tenga dos campos de entrada y un botón que al ser presionado muestre en
 *                una etiqueta un mensaje que diga si los contenidos de los 2 campos son iguales o no lo son.
 *
 * Modelado:
 *
 * |---------------------------------------------|
 * |               CamposIguales                 |
 * |---------------------------------------------|
 * | botonComprobar                              |
 * | campo1                                      |
 * | campo2                                      |
 * | campoSegundos                               |
 * | etiquetaResultado                           |
 * | ventana                                     |
 * | - - - - - - - -- - - - - - - - - - - - - - -|
 * | textosIguales(String texto1, String texto2) |
 * |---------------------------------------------|
 *
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: 28 de Octubre de 2020.
 *
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CamposIguales extends JApplet implements ActionListener {
  private JFrame ventana; // Variable de instancia para la ventana.
  private JTextField campo1; // Variable de instancia para el campo 1.
  private JTextField campo2; // Variable de instancia para el campo 2.
  private JButton botonComprobar; // Variable de instancia con el botón para realizar la comprobación.
  private JLabel etiquetaResultado; // Variable de instancia para la etiqueta con el resultado de la comprobación.

  // Constructor de la clase CamposIguales.
  public CamposIguales() {
    // Creamos la ventana.
    this.ventana = new JFrame("Campos Iguales"); // El título de la ventana es "Campos Iguales".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que todo esté alineado.

    // Creamos los elementos del GUI.
    this.campo1 = new JTextField("Campo 1");
    this.campo2 = new JTextField("Campo 2");
    this.botonComprobar = new JButton("Comprobar si son iguales");
    this.etiquetaResultado = new JLabel("Haz click en el botón para realizar la comprobación.");

    // Subscribimos nuestra clase a los eventos del botón de comprobación.
    this.botonComprobar.addActionListener(this);

    // Añadimos los elementos a la ventana en el orden que queremos que aparezcan.
    this.ventana.getContentPane().add(this.campo1);
    this.ventana.getContentPane().add(this.campo2);
    this.ventana.getContentPane().add(this.botonComprobar);
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Configuración final de la ventana.
    this.ventana.pack(); // Determinamos el tamaño automáticamente a partir de los elementos.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // El programa finaliza cuando la ventana es
                                                                          // cerrada.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos los datos de las entradas.
    String texto1 = this.campo1.getText();
    String texto2 = this.campo2.getText();

    // Realizamos la verificación.
    if (this.textosIguales(texto1, texto2)) {
      this.etiquetaResultado.setText("¡Los campos son iguales!");
    } else {
      this.etiquetaResultado.setText("Los campos son distintos");
    }
  }

  // Método para comprobar si dos textos son iguales.
  private boolean textosIguales(String texto1, String texto2) {
    return texto1.equals(texto2);
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para probar de
   * forma eficiente y rápida el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new CamposIguales(); // Al instanciar la clase se muestra la ventana.
  }
}
