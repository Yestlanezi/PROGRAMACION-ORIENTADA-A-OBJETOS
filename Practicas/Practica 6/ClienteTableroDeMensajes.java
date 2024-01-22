
/**
 * ClienteTableroDeMensajes.java
 *
 * En este archivo se incluye la implementación de la clase ClienteTableroDeMensajes.java
 *
 * Diagrama UML:
 *
 * |---------------------------|
 * |  ClienteTableroDeMensajes |
 * |---------------------------|
 * | Red red                   |
 * |- - - - - - - - - - - - - -|
 * | leeRed()                  |
 * | obtenerTodosLosMensajes() |
 * | agregarMensaje()          |
 * | buscarMensaje()           |
 * |---------------------------|
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
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteTableroDeMensajes implements LeeRed {
  private Red red;

  public ClienteTableroDeMensajes() {
    red = new Red(this);
  }

  public void leeRed(Object objeto) {
    // Extraemos el objeto.
    ConjuntoMensajes conjuntoMensajes = (ConjuntoMensajes) objeto;
    ArrayList<Mensaje> mensajes = conjuntoMensajes.getMensajes();

    // Imprimimos los mensajes.
    Iterator<Mensaje> iterador = mensajes.iterator();

    while (iterador.hasNext()) {
      Mensaje mensajeActual = iterador.next();

      if (mensajeActual.getTitulo().length() > 0 && mensajeActual.getMensaje().length() > 0) {
        System.out.println(mensajeActual.getTitulo() + " ~ " + mensajeActual.getMensaje());
      }
    }

    // Cerramos la red.
    this.red.cerrarRed();
  }

  // Método principal.
  public static void main(String args[]) {
    // Creamos una instancia del cliente.
    ClienteTableroDeMensajes cliente = new ClienteTableroDeMensajes();

    // Verificamos el comando proporcionado.
    if (args.length > 0) {
      if (args[0].equals("setInfo")) {
        // Obtenemos los datos de los argumentos.
        String titulo = args[1];
        String mensaje = args[2];

        // Enviamos el comando.
        cliente.agregarMensaje(titulo, mensaje);
      } else {
        // El comando es "getInfo"
        if (args[1].equals("alltags")) {
          // Todos los mensajes.
          cliente.obtenerTodosLosMensajes();
        } else {
          // Buscar un mensaje particular.
          cliente.buscarMensaje(args[1]);
        }
      }
    } else {
      cliente.obtenerTodosLosMensajes();
    }

    // Finalizamos la ejecución.
    return;
  }

  // Método para obtener todos los mensajes en el servidor.
  public void obtenerTodosLosMensajes() {
    this.red.escribeRed(new Comando("TODOS", new Mensaje("", "")));
  }

  // Método para agregar un mensaje al servidor.
  public void agregarMensaje(String titulo, String msj) {
    this.red.escribeRed(new Comando("AGREGAR", new Mensaje(titulo, msj)));

    this.red.cerrarRed();
  }

  // Método para buscar un mensaje en el servidor.
  public void buscarMensaje(String titulo) {
    this.red.escribeRed(new Comando("BUSCAR", new Mensaje(titulo, "")));
  }
}
