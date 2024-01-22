
/**
 * topo.java
 *
 * En este archivo se implementa la lógica y el control de la interfaz gráfica de usuario para
 * el juego de "pégale al topo" utilizando una arquitectura multi-hilos.
 *
 * Diagrama UML:
 *
 * |--------------------------------------|
 * |               Topo                   |
 * |--------------------------------------|
 * | JButton botones[]                    |
 * | JLabel punt                          |
 * | double r                             |
 * | int m[]                              |
 * | int cta                              |
 * |- - - - - - - - - - - - - - - - - - - |
 * | void actionPerformed(ActionEvent e)  |
 * |--------------------------------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 4
 * ~ Tema: Hilos.
 * ~ Opción: 2 "Pégale al Topo (continuación)".
 * ~ Fecha: 3 de Diciembre del 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class topo extends JFrame implements ActionListener {
  JButton botones[];
  JLabel punt;
  double r;
  int m[];
  int cta = 0;

  public topo() {
    super("topo");
    botones = new JButton[20];
    m = new int[20];
    punt = new JLabel("Puntuación: 0");
    setLayout(new GridLayout(5, 5));
    for (int i = 0; i < botones.length; i++) {
      r = Math.random();
      if (r < 0.5) {
        m[i] = 1;
        add(botones[i] = new JButton(new ImageIcon("tapa.jpg")));
        botones[i].addActionListener(this);
        botones[i].setEnabled(true);
      }
      if (r >= 0.5) {
        m[i] = 0;
        add(botones[i] = new JButton(new ImageIcon("topo.jpg")));
        botones[i].addActionListener(this);
        botones[i].setEnabled(true);
      }
    }
    add(punt);
    hilo TOPO = new hilo();
    TOPO.start();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(600, 600);
    setVisible(true);
  }

  public class hilo extends Thread {
    public void run() {
      while (true) {
        try {
          Thread.sleep(3000);
          for (int i = 0; i < botones.length; i++) {
            r = Math.random();
            if (r < 0.5) {
              m[i] = 1;
              botones[i].setIcon(new ImageIcon("tapa.jpg"));
              botones[i].setEnabled(true);
            }
            if (r >= 0.5) {
              m[i] = 0;
              botones[i].setIcon(new ImageIcon("topo.jpg"));
              botones[i].setEnabled(true);
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void actionPerformed(ActionEvent e) {
    JButton btn = (JButton) e.getSource();
    for (int j = 0; j < botones.length; j++) {
      if (btn == botones[j]) {
        if (m[j] == 0) {
          botones[j].setIcon(new ImageIcon("pegatopo.jpg"));
          botones[j].setEnabled(false);
          cta++;
          punt.setText("Puntuación: " + cta);
        }
      }
    }
  }

  public static void main(String s[]) {
    new topo();
  }
}