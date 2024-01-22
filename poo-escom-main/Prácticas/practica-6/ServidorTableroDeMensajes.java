import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ServidorTableroDeMensajes {
  ArrayList<Mensaje> mensajesEnElTablero;

  // Constructor de la clase Servidor Tablero de Mensajes.
  public ServidorTableroDeMensajes() {
    // Inicializamos el arreglo con los mensajes.
    mensajesEnElTablero = new ArrayList<Mensaje>();
  }

  /**
   * Clase para el manejo individual de cada uno de los clientes.
   */
  public class ClientHandler implements Runnable {
    ObjectInputStream reader;
    ObjectOutputStream writer;
    Socket sock;

    // Constructor de la clase.
    public ClientHandler(Socket clientSocket) {
      try {
        sock = clientSocket;
        reader = new ObjectInputStream(sock.getInputStream());
        writer = new ObjectOutputStream(sock.getOutputStream());
      } catch (Exception ex) {
        System.out.println("Excepción creando ClientHandler:");
        ex.printStackTrace();
      }
    }

    // Método que escucha y procesa los comandos entrantes.
    public void run() {
      // El comando que recibimos del cliente.
      Comando comando;

      // Ejecutamos el ciclo infinito dentro de un try/catch.
      try {
        // Leemos el comando recibido.
        comando = (Comando) reader.readObject();

        // Verificamos el tipo de comando a procesar.
        switch (comando.getComando()) {
          case "AGREGAR":
            // En caso de que sea el comando "AGREGAR", añadimos el mensaje al tablero.
            mensajesEnElTablero.add(comando.getMensaje());
            System.out.println("Se añadió el mensaje: " + comando.getMensaje().getTitulo() + " ~ "
                + comando.getMensaje().getMensaje());
            break;
          case "BUSCAR":
            // En caso de que sea el comando "BUSCAR", buscamos el mensaje con el título
            // proporcionado y lo enviamos de vuelta.
            Mensaje mensajeABuscar = comando.getMensaje();

            // Realizamos la búsqueda.
            Mensaje mensajeEncontrado = buscarPorTitulo(mensajeABuscar.getTitulo());
            ArrayList<Mensaje> temporal = new ArrayList<Mensaje>();
            temporal.add(mensajeEncontrado);

            // Enviamos el mensaje encontrado (aunque sea un vacío).
            try {
              this.writer.writeObject(new ConjuntoMensajes(temporal));
              this.writer.flush();

              System.out.println("Se ha enviado el mensaje que hizo match con \"" + mensajeABuscar.getTitulo() + "\": "
                  + mensajeEncontrado.getTitulo() + " ~ " + mensajeEncontrado.getMensaje());
            } catch (Exception e) {
              System.out.println("Excepción enviando el mensaje encontrado:");
              e.printStackTrace();
            }
            break;
          case "TODOS":
          default:
            // En caso de que sea el comando "TODOS" o sea un comando no reconocido
            // enviamos todos los mensajes en el tablero.
            try {
              this.writer.writeObject(new ConjuntoMensajes(mensajesEnElTablero));
              this.writer.flush();

              System.out.println("Se enviaron todos los mensajes correctamente.");
            } catch (Exception e) {
              System.out.println("Excepción enviando todos los mensajes:");
              e.printStackTrace();
            }
            break;
        }

        // Cerramos el socket.
        sock.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  // Función principal del programa.
  public static void main(String[] args) {
    // Creamos una instancia de nuestra clase e inmediatamente llamamos a la función
    // que ejecuta el servidor.
    new ServidorTableroDeMensajes().ejecutarServidor();
  }

  /**
   * Función que inicializa el servidor.
   */
  public void ejecutarServidor() {
    // Ejecutamos el servidor dentro de un try/catch.
    try {
      // El servidor escucha en el puerto 5000.
      ServerSocket serverSock = new ServerSocket(5000);

      // Mensajes de inicio.
      System.out.println("¡Servidor inicializado correctamente!");
      System.out.println("Esperando conexiones entrantes en el puerto 5000...");

      // Ciclo infinito para aceptar conexiones.
      while (true) {
        // Aceptamos la conexión.
        Socket clientSocket = serverSock.accept();

        // Creamos un thread que escucha en este socket.
        Thread t = new Thread(new ClientHandler(clientSocket));
        t.start();

        // Mensaje de confirmación.
        System.out.println("Se ha aceptado una conexión entrante.");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // Método privado para buscar mensajes por título.
  private Mensaje buscarPorTitulo(String titulo) {
    // Obtenemos un iterador de nuestros mensajes.
    Iterator<Mensaje> iterador = mensajesEnElTablero.iterator();

    // Iteramos hasta obtener un match del título.
    while (iterador.hasNext()) {
      // Obtenemos el mensaje.
      Mensaje mensajeActual = iterador.next();

      // Verificamos si el título es igual.
      if (mensajeActual.getTitulo().equals(titulo)) {
        // Regresamos el mensaje.
        return mensajeActual;
      }
    }

    // En este punto, ningún mensaje hizo match, así que regresamos un mensaje
    // vacío.
    return new Mensaje("", "");
  }

}
