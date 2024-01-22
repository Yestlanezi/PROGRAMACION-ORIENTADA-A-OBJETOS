
/**
 * ConvertidorPesosDolares.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 5
 * Planteamiento: Codificar un applet que tenga dos botones y dos campos de entrada como se muestra en la figura.
 *                Si el usuario presiona el primer botón la cantidad en el primer campo de entradas se convertirá a dolares y si se
 *                presiona el segundo dicha cantidad se convierte a pesos. El segundo campo se usa para meter el factor de
 *                conversión.
 *
 * Modelado:
 *
 * |-----------------------------------------------------------------|
 * |                     ConvertidorPesosDolares                     |
 * |-----------------------------------------------------------------|
 * | botonConvertirPesosADolares                                     |
 * | botonConvertirDolaresAPesos                                     |
 * | campoMoneda                                                     |
 * | campoFactorConversion                                           |
 * | etiquetaResultado                                               |
 * | ventana                                                         |
 * | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - --|
 * | convertirPesosADolares(double moneda, double factorConversion)  |
 * | convertirDolaresAPesos(double moneda, double factorConversion)  |
 * |-----------------------------------------------------------------|
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * ConvertidorPesosDolares
 */
public class ConvertidorPesosDolares extends JApplet implements ActionListener {
  private JButton botonConvertirPesosADolares; // Variable de instancia para el botón de conversión de pesos a dólares.
  private JButton botonConvertirDolaresAPesos; // Variable de instancia para el botón de conversión de dólares a pesos.
  private JTextField campoMoneda; // Variable de instancia con el campo para la moneda.
  private JTextField campoFactorConversion; // Variable de instancia con el campo para el factor de conversión.
  private JFrame ventana; // Variable de instancia para la ventana del Applet.

  // Constructor de la clase.
  public ConvertidorPesosDolares() {
    // Configuración inicial de la ventana.
    this.ventana = new JFrame("Convertidor Pesos - Dólares"); // El título de la ventana será "Convertidor Pesos -
                                                              // Dólares".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que los elemento estén alineados horizontalmente.

    // Instanciación de elementos.
    this.botonConvertirPesosADolares = new JButton("Pesos a Dólares");
    this.botonConvertirDolaresAPesos = new JButton("Dólares a Pesos");
    this.campoMoneda = new JTextField("Cantidad a convertir...");
    this.campoFactorConversion = new JTextField("Factor de conversión...");

    // Subscribimos nuestra clase a los eventos de ambos botones.
    this.botonConvertirDolaresAPesos.addActionListener(this);
    this.botonConvertirPesosADolares.addActionListener(this);

    // Añadimos los elementos a la ventana en el orden que queremos mostrarlos.
    this.ventana.getContentPane().add(this.campoMoneda);
    this.ventana.getContentPane().add(this.botonConvertirPesosADolares);
    this.ventana.getContentPane().add(this.botonConvertirDolaresAPesos);
    this.ventana.getContentPane().add(this.campoFactorConversion);

    // Configuración final de la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Al cerrar la ventana finaliza el programa.
    this.ventana.pack(); // Ajustamos el tamaño automáticamente para los elementos en la ventana.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos el botón orígen del evento.
    JButton botonOrigen = (JButton) evento.getSource();
    // Extraemos los datos en los campos de entrada.
    double valorMoneda = Double.parseDouble(this.campoMoneda.getText());
    double factorConversion = Double.parseDouble((this.campoFactorConversion.getText()));

    // Creamos la variable resultado.
    double resultado = 0;

    // Calculamos el resultado en función del botón empleado.
    if (botonOrigen == this.botonConvertirDolaresAPesos) {
      resultado = this.convertirDolaresAPesos(valorMoneda, factorConversion);
    } else if (botonOrigen == this.botonConvertirPesosADolares) {
      resultado = this.convertirPesosADolares(valorMoneda, factorConversion);
    }

    // Mostramos el resultado en el campo de moneda y en la terminal.
    System.out.println(valorMoneda
        + (botonOrigen == this.botonConvertirDolaresAPesos ? " dólares en pesos son: " : " pesos en dólares son: ")
        + resultado);
    this.campoMoneda.setText(resultado + "");
  }

  // Método para convertir dólares a pesos en función del factor de conversión.
  private double convertirDolaresAPesos(double valor, double factorConversion) {
    return valor * factorConversion;
  }

  // Método para convertir pesos a dólares en función del factor de conversión.
  private double convertirPesosADolares(double valor, double factorConversion) {
    return valor * (1 / factorConversion);
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para probar de
   * forma eficiente y rápida el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new ConvertidorPesosDolares(); // Al instanciar la clase se muestra la ventana.
  }
}