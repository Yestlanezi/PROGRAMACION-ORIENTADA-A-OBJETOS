
/**
 * ConjuntoMensajes.java
 *
 * En este archivo se incluye la clase ConjuntoMensajes que contiene un array con los mensajes.
 *
 * Diagrama UML:
 *
 * |-----------------------------|
 * |      ConjuntoMensajes       |
 * |-----------------------------|
 * | ArrayList<Mensaje> mensajes |
 * |- - - - - - - - - - - - - - -|
 * | getMensajes()               |
 * |-----------------------------|
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
import java.util.ArrayList;

public class ConjuntoMensajes implements Serializable {
  ArrayList<Mensaje> mensajes;

  public ConjuntoMensajes(ArrayList<Mensaje> msjs) {
    this.mensajes = msjs;
  }

  public ArrayList<Mensaje> getMensajes() {
    return this.mensajes;
  }
}
