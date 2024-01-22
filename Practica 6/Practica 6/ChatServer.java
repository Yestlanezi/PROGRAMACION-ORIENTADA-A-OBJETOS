
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Date;
import javax.swing.*;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;

/*
            ************************************
            **BOCANEGRA HEZIQUIO YESTLANEZI*****
            **PRACTICA 6************************
            **ChatBot Basico********************
            **11 de junio de 2021***************
            **2CM13*****************************
            **PROGRAMACIÓN ORIENTADA A OBJETOS** 
            ************************************

*/



public class ChatServer {

    ServerSocket ss;
    Socket c;
    PrintStream writer;
    Date fecha = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    HashMap<String, String> lista;
    String chistes[] = {
        "Que se necesita para encender una vela? ... Que este apagada",
        "Que le dice una taza a otra taza? ... Que taza ciendo?",
        "Que le dice el mar a la ola? ... ola",
        "Que esta al final del todo? ... La O",
        "Que le dice un cero a otro cero? ... No somos nada"
    };

    public ChatServer() {
        lista = new HashMap<>();
        lista.put("Dame la Fecha y Hora", "Hora y fecha: " + hourdateFormat.format(fecha));
        lista.put("Dime un Chiste", "");
        lista.put("Como te Llamas?", "Mi humana me llama Stormy");
        lista.put("Que Edad Tienes?", "Mi humana dice que tengo 2 años, pero en gatuno no lo se ");
        lista.put("Cual es tu color favorito?", "soy un gato, no lo se");
        lista.put("Cual es tu deporte preferido?", "cazar ratones y rasguñar a mi humana mientras duerme");
        lista.put("En donde Vives?", "mi humana vive en mi casa");
        lista.put("En donde Estudias?", "por que estudiaria, soy solo un gato");
        lista.put("Eres inteligente?", "no lo se, tu dime");
        lista.put("Cuentame una historia", "Una vez casi muero despues de ser desparacitado, espera fueron dos");
        lista.put("Cuanto es 2 + 2?", "mi humana no sabe sumar, asi que no tengo a quien preguntarle");
        lista.put("De que trata tu pelicula favorita?", "No lo se, no puedo ver peliculas");
        try {
            ss = new ServerSocket(5000);
            try {
                //System.out.print("Conexion Establecida ");
                while (true) {
                    String respuesta;
					//Font fuente = new Font("Calibri", 0, 20);
					//respuesta.setFont(fuente);
                    c = ss.accept();
                    //System.out.print("Conexion Establecida ");
                    InputStreamReader in = new InputStreamReader(c.getInputStream());
                    BufferedReader bf = new BufferedReader(in);
                    String preguntac = bf.readLine();
                    if ("Dime un Chiste".equals(preguntac)) {
                        int random = (int) (Math.random() * 4);
                        respuesta = chistes[random];
                        writer = new PrintStream(c.getOutputStream());
                        writer.println(respuesta);
                    } else {
                        respuesta = lista.get(preguntac);
                        writer = new PrintStream(c.getOutputStream());
                        writer.println(respuesta);
                    }
                }
            } catch (IOException e) {
                ss.close();
                System.err.println(e);
            }
            ss.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        ChatServer s = new ChatServer();
    }
}
