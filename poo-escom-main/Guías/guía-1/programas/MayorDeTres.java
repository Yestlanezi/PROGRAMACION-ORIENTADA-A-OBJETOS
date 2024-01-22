
/**
 * MayorDeTres.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 9
 * Planteamiento: Codificar un applet que tenga tres campos de entrada y un botón. Los campos de entrada se
 *                usaran para escribir tres números y cuando se presione el botón se mostrara el mayor de los 3 números en una
 *                etiqueta.
 *
 * Modelado:
 *
 * |-----------------------------------------------------|
 * |                     MayorDeTres                     |
 * |-----------------------------------------------------|
 * | botonComprobar                                      |
 * | campo1                                              |
 * | campo2                                              |
 * | campo3                                              |
 * | etiquetaResultado                                   |
 * | ventana                                             |
 * | - - - - - - - - - - - - - - - - - - - - - -  - - - -|
 * | mayorDeTres(double num1, double num2, double num3)  |
 * |-----------------------------------------------------|
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * MayorDeTres
 */
public class MayorDeTres extends JApplet implements ActionListener {
  private JButton botonComprobar; // Variable de instancia para el botón de conversión de pesos a dólares.
  private JTextField campo1; // Variable de instancia con el campo para el primer valor.
  private JTextField campo2; // Variable de instancia con el campo para el segundo valor.
  private JTextField campo3; // Variable de instancia con el campo para el tercer valor.
  private JFrame ventana; // Variable de instancia para la ventana del Applet.
  private JLabel etiquetaResultado; // Variable de instancia con la etiqueta para mostrar el resultado de la
                                    // operación.

  // Constructor de la clase.
  public MayorDeTres() {
    // Configuración inicial de la ventana.
    this.ventana = new JFrame("Mayor de tres números"); // El título de la ventana será "Mayor de tres números".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que los elemento estén alineados horizontalmente.

    // Instanciación de elementos.
    this.botonComprobar = new JButton("Obtener mayor de los 3");
    this.campo1 = new JTextField("Valor 1");
    this.campo2 = new JTextField("Valor 2");
    this.campo3 = new JTextField("Valor 3");
    this.etiquetaResultado = new JLabel("El mayor es: ");

    // Subscribimos nuestra clase a los eventos del botón.
    this.botonComprobar.addActionListener(this);

    // Añadimos los elementos a la ventana en el orden que queremos mostrarlos.
    this.ventana.getContentPane().add(this.campo1);
    this.ventana.getContentPane().add(this.campo2);
    this.ventana.getContentPane().add(this.campo3);
    this.ventana.getContentPane().add(this.botonComprobar);
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Configuración final de la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Al cerrar la ventana finaliza el programa.
    this.ventana.pack(); // Ajustamos el tamaño automáticamente para los elementos en la ventana.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos los datos en los campos de entrada.
    double valor1 = Double.parseDouble(this.campo1.getText());
    double valor2 = Double.parseDouble(this.campo2.getText());
    double valor3 = Double.parseDouble(this.campo3.getText());

    // Calculamos el mayor de los 3.
    double mayor = this.mayorDeTres(valor1, valor2, valor3);

    // Colocamos el resultado en la etiqueta.
    this.etiquetaResultado.setText("El mayor es: " + mayor);
  }

  // Método para calcular el mayor de tres números.
  private double mayorDeTres(double num1, double num2, double num3) {
    // Asumimos que el mayor es el num 1.
    double mayor = num1;

    // Verificamos el mayor contra el número dos.
    if (num2 > mayor) {
      mayor = num2;
    }

    // Verificamos el mayor contra el número tres.
    if (num3 > mayor) {
      mayor = num3;
    }

    // Regresamos el valor mayor de los tres.
    return mayor;
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para probar de
   * forma eficiente y rápida el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new MayorDeTres(); // Al instanciar la clase se muestra la ventana.
  }
}