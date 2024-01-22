
/**
 * Mensaje.java
 *
 * En este archivo se encuentra la clase que representa un mensaje dentro del tablero de avisos.
 *
 * Diagrama UML:
 *
 * |----------------|
 * |     Mensaje    |
 * |----------------|
 * | String titulo  |
 * | String mensaje |
 * |- - - - - - - - |
 * | getMensaje()   |
 * | getTitulo()    |
 * |----------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 6
 * ~ Tema: Sockets Servidor.
 * ~ Opción: 3 "Tablero de Avisos Electrónico"
 * ~ Fecha: 13 de Enero de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.io.Serializable;

public class Mensaje implements Serializable {
  String titulo;
  String mensaje;

  // Constructor de la clase Mensaje.
  public Mensaje(String titulo, String mensaje) {
    this.titulo = titulo;
    this.mensaje = mensaje;
  }

  // Método para obtener el cuerpo de un mensaje.
  public String getMensaje() {
    return this.mensaje;
  }

  // Método para obtener el título de un mensaje.
  public String getTitulo() {
    return this.titulo;
  }
}
