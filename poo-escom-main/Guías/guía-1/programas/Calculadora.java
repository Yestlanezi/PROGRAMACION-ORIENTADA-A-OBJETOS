import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculadora.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 8
 * Planteamiento: Codificar un applet que tenga dos campos de entrada y cuatro botones. Los campos de entrada se
 *                usaran para escribir dos números, el primer botón, para sumar, el segundo para restar, el tercero para multiplicar
 *                y el cuarto para dividir (ver figura). El resultado se imprimirá en la zona de status o una etiqueta (no mostrada
 *                aquí).
 *
 * Modelado:
 *
 * |-------------------|
 * |    Calculadora    |
 * |-------------------|
 * | botonSumar        |
 * | botonRestar       |
 * | botonDividir      |
 * | botonMultiplicar  |
 * | campoIzquierdo    |
 * | campoDerecho      |
 * | etiquetaResultado |
 * | ventana           |
 * | - - - - - - - - - |
 * |-------------------|
 *
 * Nota: Se pudieron implementar funciones para cada operación, pero las consideré inecesarias y la
 *       operación la realizo directamente en el método `actionPerformed`.
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: 28 de Octubre de 2020.
 *
 */
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// Clase Calculadora.
public class Calculadora extends JApplet implements ActionListener {
  private JFrame ventana; // Variable de instancia con la ventana de la aplicación.
  private JButton botonSumar; // Variable de instancia para el botón con la operación de suma.
  private JButton botonRestar; // Variable de instancia para el botón con la operación de resta.
  private JButton botonDividir; // Variable de instancia para el botón con la operación de división.
  private JButton botonMultiplicar; // Variable de instancia para el botón con la operación de multiplicar.
  private JTextField campoIzquierdo; // Variable de instancia para el campo de entrada del miembro izquierdo de la
                                     // operación.
  private JTextField campoDerecho; // Variable de instancia para el campo de entrada del miembro derecho de la
                                   // operación.
  private JLabel etiquetaResultado; // Variable de instancia para la etiqueta donde se mostrará el resultado.

  public Calculadora() {
    // Creamos la ventana.
    this.ventana = new JFrame("Calculadora"); // El título de la ventana es "Calculadora".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que todo esté alineado.

    // Creamos los elementos.
    this.campoIzquierdo = new JTextField("Valor izquierdo");
    this.campoDerecho = new JTextField("Valor derecho");
    this.botonSumar = new JButton("+");
    this.botonRestar = new JButton("-");
    this.botonDividir = new JButton("%");
    this.botonMultiplicar = new JButton("x");
    this.etiquetaResultado = new JLabel("Resultado: x");

    // Añadimos los elementos a la ventana en el orden en que se quieren presentar.
    this.ventana.getContentPane().add(this.campoIzquierdo);
    this.ventana.getContentPane().add(this.campoDerecho);
    this.ventana.getContentPane().add(this.botonSumar);
    this.ventana.getContentPane().add(this.botonRestar);
    this.ventana.getContentPane().add(this.botonDividir);
    this.ventana.getContentPane().add(this.botonMultiplicar);
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Subscribimos la clase a los eventos de los botones.
    this.botonSumar.addActionListener(this);
    this.botonRestar.addActionListener(this);
    this.botonDividir.addActionListener(this);
    this.botonMultiplicar.addActionListener(this);

    // Configuración final de la ventana.
    this.ventana.pack(); // Determinamos el tamaño automáticamente a partir de los elementos.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // El programa finaliza cuando la ventana es
                                                                          // cerrada.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos el botón que fue utilizado.
    JButton botonOrigen = (JButton) evento.getSource();

    // Extramos los datos de las entradas.
    double valorIzquierdo = Double.parseDouble(this.campoIzquierdo.getText());
    double valorDerecho = Double.parseDouble(this.campoDerecho.getText());

    // Realizamos la operación apropiada y mostramos el resultado en la etiqueta.
    if (botonOrigen == this.botonSumar) {
      this.etiquetaResultado
          .setText("Resultado: " + valorIzquierdo + " + " + valorDerecho + " = " + (valorIzquierdo + valorDerecho));
    } else if (botonOrigen == this.botonRestar) {
      this.etiquetaResultado
          .setText("Resultado: " + valorIzquierdo + " - " + valorDerecho + " = " + (valorIzquierdo - valorDerecho));
    } else if (botonOrigen == this.botonDividir) {
      this.etiquetaResultado
          .setText("Resultado: " + valorIzquierdo + " % " + valorDerecho + " = " + (valorIzquierdo / valorDerecho));
    } else if (botonOrigen == this.botonMultiplicar) {
      this.etiquetaResultado
          .setText("Resultado: " + valorIzquierdo + " * " + valorDerecho + " = " + (valorIzquierdo % valorDerecho));
    }
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para probar de
   * forma eficiente y rápida el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new Calculadora(); // Al instanciar la clase se muestra la ventana.
  }
}
