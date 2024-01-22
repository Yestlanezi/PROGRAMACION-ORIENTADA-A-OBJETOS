
/**
 * Mensaje.java
 *
 * En este archivo se define el objeto que será serializado, transmitido, deserializado e interpretado
 * por el programa.
 *
 * Diagrama UML:
 *
 * |---------------------|
 * |       Mensaje       |
 * |---------------------|
 * | String usuario      |
 * | String mensaje      |
 * |- - - - - - - - - - -|
 * | String getUsuario() |
 * | String getMensaje() |
 * |---------------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 5
 * ~ Tema: Sockets Clientes.
 * ~ Opción: 5 "ChatBot Básico o Nano Alexa"
 * ~ Fecha: 14 de Diciembre de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.io.Serializable;

/**
 * Mensaje.
 */
public class Mensaje implements Serializable {
  String usuario; // Para almacenar el usuario del mensaje
  String mensaje; // Para almacenar el mensjae en sí

  // Constructor de la clase Mensaje.
  public Mensaje(String usuario, String mensaje) {
    this.usuario = usuario;
    this.mensaje = mensaje;
  }

  // Método para obtener el nombre de usuario de un mensaje.
  public String getUsuario() {
    return usuario;
  }

  // Método para obtener el mensaje en sí.
  public String getMensaje() {
    return mensaje;
  }
}
