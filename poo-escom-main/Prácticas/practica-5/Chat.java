
/**
 * Chat.java
 *
 * En este archivo se implementa la lógica y la interfaz gráfica principal de nuestro chat.
 *
 * Diagrama UML:
 *
 * |--------------------------------------------------|
 * |                       Chat                       |
 * |--------------------------------------------------|
 * | JButton conectarse                               |
 * | JButton enviarMensaje                            |
 * | JTextArea areaMensajes                           |
 * | JTextField entradaMensaje                        |
 * | JTextField entradaUsuario                        |
 * | JLabel etiquetaUsuario                           |
 * | JFrame ventana                                   |
 * | String usuario                                   |
 * | Hashtable<String, String> inteligenciaArtificial |
 * | private Red red                                  |
 * |- - - - - - - - - - - - - - - - - - - - - - - - - |
 * | void leerRed(Object)                             |
 * | void actionPerformed(ActionEvent)                |
 * | void contectar()                                 |
 * |--------------------------------------------------|
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
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

/**
 * Chat
 */
public class Chat implements LeeRed, ActionListener {
  JButton conectarse; // Botón para conectarse al servidor.
  JButton enviarMensaje; // Botón para enviar un mensaje.
  JTextArea areaMensajes; // Area de Mensajes del chat.
  JTextField entradaMensaje; // Campo de entrada para el manesaje.
  JTextField entradaUsuario; // Campo de entrada para el nombre de usuario.
  JLabel etiquetaUsuario; // Etiqueta para mostrar el texto indicativo del nombre de usuario.
  JFrame ventana; // La ventana del chat.
  String usuario; // El nombre de usuario.
  Hashtable<String, String> inteligenciaArtificial; // Nuestra I.A. súper avanzada.
  private Red red; // Nuestro objeto de Red.

  // Constructor de la clase Chat.
  public Chat() {
    // Creamos la ventana.
    this.ventana = new JFrame("Chat - Práctica 5 - POO ESCOM");
    this.ventana.getContentPane().setLayout(new BorderLayout());

    // Creamos los páneles para maquetar la interfaz.
    JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel();
    p1.setLayout(new BorderLayout());
    p2.setLayout(new BorderLayout());
    p3.setLayout(new BorderLayout());

    // Creamos los componentes de la interfaz.

    this.areaMensajes = new JTextArea("Presiona \"Conectarse\" para iniciar...", 10, 40);
    this.areaMensajes.setEditable(false);

    // Creamos un JScrollPane para que se vean los mensajes de forma infinita.
    JScrollPane scroll = new JScrollPane(this.areaMensajes);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    this.conectarse = new JButton("Conectarse");
    this.conectarse.addActionListener(this);

    this.entradaMensaje = new JTextField(20);
    this.entradaMensaje.setEnabled(false);

    this.entradaUsuario = new JTextField("Octavio Paz");

    this.etiquetaUsuario = new JLabel("Usuario: ");

    this.enviarMensaje = new JButton("Enviar mensaje");
    this.enviarMensaje.addActionListener(this);
    this.enviarMensaje.setEnabled(false);

    // Agrupamos nuestra interfaz.
    p1.add(this.etiquetaUsuario, BorderLayout.WEST);
    p1.add(this.entradaUsuario, BorderLayout.CENTER);
    p1.add(this.conectarse, BorderLayout.EAST);

    p2.add(scroll, BorderLayout.CENTER);

    p3.add(this.entradaMensaje, BorderLayout.WEST);
    p3.add(this.enviarMensaje, BorderLayout.EAST);

    // Añadimos nuestros páneles a la ventana.
    this.ventana.add(p1, BorderLayout.NORTH);
    this.ventana.add(p2, BorderLayout.CENTER);
    this.ventana.add(p3, BorderLayout.SOUTH);

    // Ajustamos operación de ventana.
    this.ventana.pack();
    this.ventana.setVisible(true);
    this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Inicializamos nuestra "inteligencia artifical".
    this.inteligenciaArtificial = new Hashtable<String, String>();

    // Añadimos...inteligencia artificial.
    this.inteligenciaArtificial.put("¿en qué ciudad vives?", "Ciudad de México");
    this.inteligenciaArtificial.put("¿cuántos años tienes?", "23");
    this.inteligenciaArtificial.put("¿en qué escuela estudias?", "ESCOM");
    this.inteligenciaArtificial.put("¿cómo se llama tu perro?", "Maddie");
    this.inteligenciaArtificial.put("¿qué materia no quieres reprobar?", "POO, de entrada");
    this.inteligenciaArtificial.put("¿cuál es tu película favorita?", "El Padrino I");
    this.inteligenciaArtificial.put("¿qué música te gusta?", "Reggaetón no");
    this.inteligenciaArtificial.put("¿cómo se llama tu hermano?", "Gerardo");
    this.inteligenciaArtificial.put("cuenta un chiste",
        "Había una vez un perro de goma que cuando se rascaba se borraba :(");
    this.inteligenciaArtificial.put("otro chiste", "¿Los hacendados hacen dados?");
  }

  // Método que es llamado cada vez que recibamos un mensaje nuevo.
  public void leeRed(Object objeto) {
    // Extraemos el objeto deserializado.
    Mensaje mensaje = (Mensaje) objeto;

    // Verificamos que no sea un mensaje emitido por nosotros mismos.
    if (!mensaje.getUsuario().equalsIgnoreCase(this.usuario + " (I.A.)")
        && !mensaje.getUsuario().equalsIgnoreCase(this.usuario)) {
      // Añadimos el mensaje a nuestra área de mensajes.
      this.areaMensajes.append("\n" + mensaje.getUsuario() + ": " + mensaje.getMensaje());

      // Hacemos un log en la terminal de la ocurrencia.
      System.out.println("Mensaje recibido de " + mensaje.getUsuario() + ": " + mensaje.getMensaje());

      // Verificamos si el mensaje es uno reconocido por nuestra IA.
      if (this.inteligenciaArtificial.containsKey(mensaje.getMensaje().toLowerCase())) {
        // Obtenemos nuestra respuesta del hashtable.
        String respuesta = this.inteligenciaArtificial.get(mensaje.getMensaje());

        // Mandamos la respuesta en red.
        red.escribeRed(new Mensaje(this.usuario + " (I.A.)", respuesta));

        // Añadimos la respuesta a nuestra área de mensajes.
        this.areaMensajes.append("\n" + this.usuario + " (I.A.): " + respuesta);

        // Hacemos un log del mensaje respondido.
        System.out.println("Mensaje respondido por I.A.: " + respuesta);
      }
    }
  }

  // Método que es llamado cada que se haga click en un botón.
  public void actionPerformed(ActionEvent evento) {
    // Extraemos el botón de orígen.
    JButton botonSeleccionado = (JButton) evento.getSource();

    // Determinamos el flujo a seguir.
    if (botonSeleccionado == conectarse) {
      // Si es el botón conectar, primero nos conectamos al servidor.
      this.conectar();

      // Mostramos confirmación en nuestra área de mensajes.
      this.areaMensajes.append("\n" + "¡Conectado correctamente! Ya puedes chatear.");

      // Obtenemos el nombre de usuario seleccionado.
      this.usuario = this.entradaUsuario.getText();

      // Desactivamos la entrada del usuario.
      this.entradaUsuario.setEnabled(false);

      // Desactivamos el botón de conectarse.
      this.conectarse.setEnabled(false);

      // Activamos la entrada para escribir mensaje y el botón enviar.
      this.entradaMensaje.setEnabled(true);
      this.enviarMensaje.setEnabled(true);
    } else {
      // Si es el botón enviar, mandamos el mensaje en red.
      red.escribeRed(new Mensaje(this.usuario, this.entradaMensaje.getText()));

      // Añadimos el mensaje a nuestro cuadro de texto.
      this.areaMensajes.append("\n" + this.usuario + " (Yo): " + this.entradaMensaje.getText());

      // Limpiamos el campo.
      this.entradaMensaje.setText("");
    }
  }

  // Método para realizar la conexión de red.
  void conectar() {
    red = new Red(this);
  }

  /**
   * Método principal para probar la clase. Se incluye únicamente para poder
   * probar de forma eficiente el código de la clase, por lo general este método
   * deberá vivir en una clase aparte.
   */
  public static void main(String args[]) {
    new Chat();
  }
}
