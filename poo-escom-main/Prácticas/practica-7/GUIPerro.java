/**
 * GUIPerro.java
 *
 * En este archivo se encuentra la definición e implementación de la interfaz gráfica de usuario
 * así como la lógica para la práctica.
 *
 * Diagrama UML:
 *
 * |------------------------------|
 * |           GUIPerro           |
 * |------------------------------|
 * | JLabel labelNombre           |
 * | JLabel labelRaza             |
 * | JLabel labelEdad             |
 * | JLabel labelGenero           |
 * | JTextField campoNombre       |
 * | JTextField campoRaza         |
 * | JTextField campoEdad         |
 * | JTextField campoGenero       |
 * | JButton botonConectar        |
 * | JButton botonEnviar          |
 * | BaseDeDatos baseDeDatos      |
 * |- - - - - - - - - - - - - - - |
 * | actionPerformed(ActionEvent) |
 * |------------------------------|
 *
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 7
 * ~ Tema: JDBC.
 * ~ Opción: 1 "Insertar Perros en una Base de Datos"
 * ~ Fecha: 14 de Enero de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUIPerro extends JFrame implements ActionListener {
  JLabel labelNombre;
  JLabel labelRaza;
  JLabel labelEdad;
  JLabel labelGenero;
  JTextField campoNombre;
  JTextField campoRaza;
  JTextField campoEdad;
  JTextField campoGenero;
  JButton botonConectar;
  JButton botonEnviar;
  BaseDeDatos baseDeDatos;

  // Constructor de la clase.
  public GUIPerro() {
    // Configuración general de la ventana.
    super("Práctica 7 - GUI Perro");
    Container contenedor = this.getContentPane();
    contenedor.setLayout(new FlowLayout());

    // Nombre.
    this.labelNombre = new JLabel("Nombre:");
    this.campoNombre = new JTextField(20);
    this.campoNombre.setEnabled(false);
    contenedor.add(this.labelNombre);
    contenedor.add(this.campoNombre);

    // Raza
    this.labelRaza = new JLabel("Raza:");
    this.campoRaza = new JTextField(20);
    this.campoRaza.setEnabled(false);
    contenedor.add(this.labelRaza);
    contenedor.add(this.campoRaza);

    // Edad
    this.labelEdad = new JLabel("Edad:");
    this.campoEdad = new JTextField(20);
    this.campoEdad.setEnabled(false);
    contenedor.add(this.labelEdad);
    contenedor.add(this.campoEdad);

    // Género
    this.labelGenero = new JLabel("Género:");
    this.campoGenero = new JTextField(20);
    this.campoGenero.setEnabled(false);
    contenedor.add(this.labelGenero);
    contenedor.add(this.campoGenero);

    // Botón para enviar.
    this.botonEnviar = new JButton("Enviar");
    botonEnviar.addActionListener(this);
    botonEnviar.setEnabled(false);
    this.add(this.botonEnviar);

    // Botón para conectar.
    this.botonConectar = new JButton("Conectar");
    this.botonConectar.addActionListener(this);
    this.add(this.botonConectar);

    // Configuración final de la ventana.
    this.setSize(250, 300);
    this.setVisible(true);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  // Método principal.
  public static void main(String[] args) {
    new GUIPerro();
  }

  public void actionPerformed(ActionEvent evento) {
    // Obtenemos el origen del evento.
    JButton botonOrigen = (JButton) evento.getSource();

    // Verificamos el botón que fue presionado.
    if (botonOrigen == this.botonConectar) {
      // Realizamos la conexión.
      this.baseDeDatos = new BaseDeDatos();

      // Cambiamos el estado del GUI.
      this.botonConectar.setEnabled(false);
      this.botonEnviar.setEnabled(true);
      this.campoNombre.setEnabled(true);
      this.campoEdad.setEnabled(true);
      this.campoRaza.setEnabled(true);
      this.campoGenero.setEnabled(true);

      // Mostramos un mensaje de confirmación.
      JOptionPane.showMessageDialog(null, "¡Conexión con la Base de Datos realizada exitosamente!");
    } else {
      // Realizamos la operación en la base de datos.
      boolean operacionExitosa = this.baseDeDatos.insertarPerro(new Perro(this.campoNombre.getText(),
          this.campoRaza.getText(), Integer.parseInt(this.campoEdad.getText()), this.campoGenero.getText()));

      // Verificamos si la operción fue exitosa.
      if (operacionExitosa) {
        JOptionPane.showMessageDialog(null, "¡Perro registrado exitosamente!");
      } else {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar el registro, intente de nuevo más tarde.");
      }
    }
  }
}
