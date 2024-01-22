/**
 * FechaDeMuerte.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 7
 * Planteamiento: Escriba un applet que tenga un campo de entrada donde el usuario escribirá una edad y un botón
 *                que al ser presionado muestre en una etiqueta el año en que morirá dicha persona. Suponga que la esperanza de
 *                vida es de 77 años.
 *
 * Modelado:
 *
 * |------------------------------|
 * |         FechaDeMuerte        |
 * |------------------------------|
 * | ventana                      |
 * | campoEdad                    |
 * | botonCalcular                |
 * | etiquetaResultado            |
 * |------------------------------|
 * | FechaDeMuerte()              |
 * | actionPerformed(ActionEvent) |
 * | calcularFechaMuerte(int)     |
 * |------------------------------|
 *
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Materia: Programación Orientada a Objetos
 * Profesor: Roberto Tecla
 * Fecha: Miércoles 11 de Noviembre de 2020.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * FechaDeMuerte
 */
public class FechaDeMuerte extends JApplet implements ActionListener
{
  private JFrame ventana;           // Variable de instancia con la ventana.
  private JTextField campoEdad;     // Variable de instancia con el campo para introducir la edad del usuario.
  private JButton botonCalcular;    // Variable de instancia con el botón para realizar el cálculo.
  private JLabel etiquetaResultado; // Variable de instancia con la etiqueta para mostrar el resultado.

  // Constructor de la clase FechaDeMuerte.
  public FechaDeMuerte()
  {
    // Creamos la ventana.
    this.ventana = new JFrame("Problema 7 - Fecha de Muerte"); // El título de la ventana es "Problema 7 - Fecha de Muerte".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Para que todo esté alineado.

    // Creamos el botón para calcular la fecha de muerte.
    this.botonCalcular = new JButton("Calcular fecha de muerte");
    
    // Subscribimos nuestra clase a los eventos que emita el botón.
    this.botonCalcular.addActionListener(this);

    // Creamos el campo para leer la edad del usuario.
    this.campoEdad = new JTextField("Ingresa tu edad...");
    
    // Creamos la etiqueta para mostrar el resultado.
    this.etiquetaResultado = new JLabel("Fecha de Muerte: ");

    // Añadimos los elementos a la ventana en el orden en que se quieren presentar.
    this.ventana.getContentPane().add(this.campoEdad);
    this.ventana.getContentPane().add(this.botonCalcular);
    this.ventana.getContentPane().add(this.etiquetaResultado);

    // Configuración final de la ventana.
    this.ventana.pack(); // Determinamos el tamaño automáticamente a partir de los elementos.
    this.ventana.setVisible(true); // Hacemos visible la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // El programa finaliza cuando la ventana es cerrada.
  }

  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent e) {
    // Extraemos el valor de la entrada.
    int edad = Integer.parseInt(this.campoEdad.getText());

    // Calculamos el resultado.
    int fechaMuerte = this.calcularFechaMuerte(edad);

    // Mostramos el resultado.
    this.etiquetaResultado.setText("Fecha de Muerte: " + fechaMuerte);
    System.out.println("El año de muerte calculado para una persona de " + edad + " años de edad en el 2020 es: " + fechaMuerte);
  }

  // Método para calcular el año de muerte a partir de una edad.
  private int calcularFechaMuerte(int edad) {
    // Verificamos si la edad ingresada es menor a la esperanza de vida para no arrojar resultados en el pasado.
    if (edad < 77) {
      return 2020 + (77 - edad); // Asumimos el año actual 2020 y la esperanza de vida en 77 años.
    } else {
      return 2020; // Si la persona pasa de la experanza de vida, la fecha de muerte calculada será este año.
    }
  }

  /**
   * Método principal para probar la clase.
   * Se incluye únicamente para poder probar de forma eficiente el código de la clase, por lo general
   * este método deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new FechaDeMuerte(); // Al instanciar la clase se muestra la ventana.
  }
}

