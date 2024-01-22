
/**
 * Comando.java
 *
 * Este archivo contiene la implementación de la clase Comando que representa un comando enviado
 * desde el cliente al servidor.
 *
 * Diagrama UML:
 *
 * |-----------------|
 * |     Comando     |
 * |-----------------|
 * | String comando  |
 * | Mensaje mensaje |
 * |- - - - - - - - -|
 * | getComando()    |
 * | getMensaje()    |
 * |-----------------|
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

public class Comando implements Serializable {
  String comando;
  Mensaje mensaje;

  public Comando(String comando, Mensaje msj) {
    this.comando = comando;
    this.mensaje = msj;
  }

  public String getComando() {
    return this.comando;
  }

  public Mensaje getMensaje() {
    return this.mensaje;
  }
}
