/**
 * ConvertidorDiasHoras.java
 * 
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 4
 * Planteamiento: Codificar un applet (o aplicación) que tenga un campo de entrada y un botón. En el campo de
 *                entrada el usuario escribe una cantidad de minutos y cuando presione el botón deben mostrarse el numero de
 *                días (que hay en esos minutos) en una etiqueta y en otra etiqueta el numero de horas (que hay en esos minutos). 
 *
 * Modelado:
 *
 * |------------------------------|
 * |    ConvertidorDiasHoras      |
 * |------------------------------|
 * | botonConvertir               |
 * | campoMinutos                 |
 * | etiquetaResultadoDias        |
 * | etiquetaResultadoHoras       |
 * | ventana                      |
 * | - - - - - - - - - - - - - - -|
 * | convertirADias(int minutos)  |
 * | convertirAHoras(int minutos) |
 * |------------------------------|
 *
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: 28 de Octubre de 2020.
 *
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * ConvertidorDiasHoras
 */
public class ConvertidorDiasHoras extends JApplet implements ActionListener {
  private JButton botonConvertir;                                // Variable de instancia del botón para realizar la conversión.
  private JTextField campoMinutos;                               // Variables de instancia con los campos de entradas.
  private JLabel etiquetaResultadoDias, etiquetaResultadoHoras;  // Variable de instancia con la etiqueta para el resultado.
  private JFrame ventana;                                        // Variable de instancia con la ventana de nuestro programa.
  
  // Constructor de la clase.
  public ConvertidorDiasHoras() {
    // Configuración inicial de la ventana.
    this.ventana = new JFrame("Convertidor Minutos a Días y Horas"); // El título de la ventana es: "Convertidor Minutos a Días y Horas".
    this.ventana.getContentPane().setLayout(new FlowLayout()); // Usamos FlowLayout para que todo esté alineado.
    
    // Instanciamos los elementos.
    this.botonConvertir = new JButton("Convertir");
    this.campoMinutos = new JTextField("Minutos...", 10);
    this.etiquetaResultadoDias = new JLabel("Días:    ");
    this.etiquetaResultadoHoras = new JLabel("Horas:    ");
    
    // Subscribimos nuestra clase a los eventos de nuestro botón.
    this.botonConvertir.addActionListener(this);
    
    // Añadimos los elementos a la ventana en el orden que queremos que se vean.
    this.ventana.getContentPane().add(this.campoMinutos);
    this.ventana.getContentPane().add(this.botonConvertir);
    this.ventana.getContentPane().add(this.etiquetaResultadoDias);
    this.ventana.getContentPane().add(this.etiquetaResultadoHoras);

    // Configuración final de la ventana.
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.ventana.pack();
    this.ventana.setVisible(true);
  }

  // Método que convierte un número de minutos a días.
  private int convertirADias(int minutos) {
    return minutos / 1440; // Un día (24 horas) tiene 1440 minutos.
  }
  
  // Método que convierte un número de minutos a horas.
  private int convertirAHoras(int minutos) {
    return minutos / 60; // Una hora tiene 60 minutos.
  }
  
  // Listener para los eventos a los que está suscrita la clase.
  public void actionPerformed(ActionEvent e) {
    // Extraemos los minutos de la entrada.
    int minutosEntrada = Integer.parseInt(this.campoMinutos.getText());

    // Calculamos los resultados
    int resultadoEnDias = this.convertirADias(minutosEntrada);
    int resultadoEnHoras = this.convertirAHoras(minutosEntrada);

    // Mostramos el resultado en las etiquetas y en la terminal.
    System.out.println(minutosEntrada + " minutos son " + resultadoEnHoras + " horas, o " + resultadoEnDias + " días.");
    this.etiquetaResultadoDias.setText("Días: " + resultadoEnDias);
    this.etiquetaResultadoHoras.setText("Horas: " + resultadoEnHoras);
  }
  
  /**
   * Método principal para probar la clase.
   * Se incluye únicamente para probar de forma eficiente y rápida el código de la clase, por lo general
   * este método deberá vivir en una clase aparte.
   */
  public static void main(String[] args) {
    new ConvertidorDiasHoras(); // Al instanciar la clase se muestra la ventana.
  }
}
