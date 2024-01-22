
/*
            ************************************
            **BOCANEGRA HEZIQUIO YESTLANEZI*****
            **PRACTICA 4************************
            **1. Insertar perros en la base*****
            **11 de junio de 2021***************
            **2CM13*****************************
            **PROGRAMACIÓN ORIENTADA A OBJETOS** 
            ************************************

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.* ;
import java.math.* ; 

public class InsertarPerros implements ActionListener{
    JFrame principal;
    JLabel LNombre;
    JLabel LRaza;
    JLabel LEdad;
    JLabel LGenero;
    JTextField TNombre;
    JTextField TRaza;
    JTextField TEdad;
    JTextField TGenero;
    JButton insertar;
    JButton conect;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "perro";
    static final String USER = "root";
    static final String PASS = "Alonsormm2";
    public InsertarPerros(){
        principal = new JFrame("Perros");
        LNombre = new JLabel("Nombre: ");
        LRaza = new JLabel("Raza: ");
        LEdad = new JLabel("Edad: ");
        LGenero = new JLabel("Genero: ");
        TNombre = new JTextField();
        TRaza = new JTextField();
        TEdad = new JTextField();
        TGenero = new JTextField();
        insertar = new JButton("Insertar");
        insertar.addActionListener(this);
        conect = new JButton("Conectar");
        conect.addActionListener(this);
        principal.setLayout(new GridLayout(5,2));
        principal.add(LNombre);
        principal.add(TNombre);
        principal.add(LRaza);
        principal.add(TRaza);
        principal.add(LEdad);
        principal.add(TEdad);
        principal.add(LGenero);
        principal.add(TGenero);
        principal.add(conect);
        principal.add(insertar);
        principal.setSize(400, 400);
        principal.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Connection conn = null;
        Statement stmt = null;
        JButton b = (JButton) e.getSource();
        
        if(b == conect){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL+DB_NAME,USER,PASS);
                stmt = conn.createStatement();
                System.out.println("Se conecto con exito");
                stmt.close();
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception a){
                a.printStackTrace();
            }
        }
        else{
            String nombre = (String) TNombre.getText();
            String raza = (String) TRaza.getText();
            int edad = Integer.parseInt(TEdad.getText());
            String genero = (String) TGenero.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL+DB_NAME,USER,PASS);
                stmt = conn.createStatement();
                String sql = "INSERT INTO datos VALUES (\""+ nombre +"\", \"" + raza +"\","+ edad +",\""+ genero +"\");";
                System.out.println(sql);
                stmt.execute(sql);
                stmt.close();
            }catch(SQLException a){

            }catch(Exception a){
                a.printStackTrace();
            };
        }

    }

    public static void main(String[] args) {
        new InsertarPerros();
    }
}