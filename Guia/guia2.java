


//			*************GUIA 2 POO*************
//			************************************

/*
			************************************
			**BOCANEGRA HEZIQUIO YESTLANEZI*****
  			**14 DE JUNIO DE 2021****************
  			**2CM13*****************************
  			**PROGRAMACIÓN ORIENTADA A OBJETOS** 
			************************************

*/
/*
			****************
				HILOS
			****************
*/
/* 
	Problema 1.-Codificar una clase llamada CuentaSegundos que implemente la interfaz Runnable: 
-Que cada segundo incremente en una unidad  un contador y muestre el valor de dicho contador en una etiqueta.
-Que cuando llegue a un valor limite (que se establece cuando se crea un objeto) deje de incrementar el contador y de actualizar el valor mostrado.
Sugerencia extienda la clase Label y asigne cero al contador en el constructor.
*/

import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 

public classCuentaSegundos extends Applet implement ActionListener, Runnable{
	Label etiqueta; 
	private int contador; 
	Thread hilo; 
	public CuentaSegundos{
		hilo = new Theread(this);
		hilo.star();
	}

	public void run(){
		try{
			contador = 0; 
			for(int i=0; i< 60; i++){
				contador = i;
				Thread.sleep(1000);
			}
		}
		catch(Exception e){
			...
		}
	}
	public interface Runnable{
		void run();
	}

	public void int(){
		etiqueta = new Label(Value0f(contador)); add(etiqueta);
	}
	public static void main(String [] args){
		Frame f = new ("CuentaSegundos");
		add("center", new CuentaSegundos ()); f.setSize(250,250);)
	}
}


/*
			****************
				RMI
			****************
*/


/* 
En cada problema codificar la interfaz remota, la clase del objeto remoto (servidor),  
la clase del cliente y en los métodos remotos poner los parámetros que se necesiten.
*/

//Problema 1.-Escribir el código de  un método remoto que calcule el área de un triangulo.

import java.rmi.*; 
public interface AreaTriangulo extends Remote{
	public int CalcularArea(int base, int altura) throws RemoteException;
}

//Servidor 
import java.rmi.*; 
import java.rmi.server.*;
import java.net.*; 

public class AreaTrianguloImpl UnicastRemoteObject implements AreaTriangulo{
	public AreaTrianguloImpl() throws RemoteException{
		super();
	}
	public int CalcularArea(int base, int altura) throws RemoteException{
		int a; 
		return (a=(base*altura)/2);
	}
	public static void main(String[] s){
		String ip; 
		String puerto = "1406";
		try{
			ip = InetAddress.getlocalHost().getHostAddress(); 
			Sistem.out.println("Ejectundo servicio en 192.168.0.19:" +puerto);
			AreaTrianguloImpl area = nex AreaTrianguloImpl();
			Naming.rebind("//Localhost:"+puerto6"/AreaTraingulo",area);
		}
		catch(RemoteException e){
			....
		}
		catch(MalformedURLException e){
			...
		}
		}
	}
}

//Cliente 

import java.rmi.*; 
import java.swing.*;
import java.awt.event.*; 

public class AreaTrianguloClient implements ActionListener{
	private JFrame f; 
	private JButton boton; 
	private JTextFleld campo1, campo2; 
	private JLable e1, e2, resp; 
	private int result; 
	private AreaTrianguloClient(){
		CrearVentana();
	}
	public void CrearVentana(){
		f = new JFrame("Area Triangulo");
		f.setLayout(null);
		f.setSize(300,200);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		boton = new JButton("LISTO");
		boton.addActionListener(this);
		campo1 = net JTextField(20);
		campo2 = new JTextField(20);
		e1 = new JLabel("ALTO");
		e2 = new JLabel("ANCHO");
		resp = new JLabel("");
		resp.setFront(new java.awt.Front("Arial", 0,20));
		f.add(boton);
		f.add(campo1);
		f.add(campo2);
		f.add(e1);
		f.add(e2);
		f.add(resp);
		e1.setBounds(10,10,80,20);
		campo1.setBounds(100,10,80,20);
		e2.setBounds(10,40,80,20);
		campo2.setBounds(100,40,80,20);

		boton.setBounds(40,70,80,20);
		resp.setBounds(20,80,200,200);
		f.SetVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		int x,y; 
		try{//obtener los datos de los campos
			x = Integer.parseInt(campo1.getText());
			y = Integer.parseInt(campo2.getText());

		try{ //calcular el area del triangulo
			AreaTriangulo 
			remoto = (AreaTriangulo)Naming.lookup("//192.168.0.19:1486//AreaTriangulo");
			result = remoto.CalcularArea(y,x);
			resp.setText("Respuesta: " +result);
		}
		catch(Exception EX){
			JOptionPane.showMessageDialog(null, "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		}
		catch(NumberFormatExceptio ex){
			JOptionPane.showMessageDialog(null, "Se genero un error en la conversion", "ERROR DE EINTERO", JOptionPane.ERRPR_MESSAGE);
		}
	}
}


/*
Problema 2.-Escribir el código de  un método remoto que 
retorne una cadena indicando si un punto esta dentro 
o fuera de un circulo de radio 100 con centro en el origen.
*/

//interfaz 
import java.rmi.*; 

public iterface Circulo extends Remote{
	public String coordenadaValida(int, int y) throws RemoteException;

}

//Servidor 
import java.rmi.*; 
import java.rmi.server.*;
import java.net.*;
import java.lang.Math.*;

public class CirculoImpl extends UnicastRemoteObject implements Circulo{
	public CirculoImpl() throws RemoteExceptio{
		super();
	}

	public String Circulo(int x , int y) throws RemoteException{
		String cadena; 
		if ((Math.pow(x,2)) + (Math.pow(y,2))<100){
			Cadena = new String("El punto ingresado se encuentra dentro del circulo (centro 0,0 y radio 100) ");
		}
		return cadena; 
	}
}

public static void main(String []args ){
	try {
		Circulo circulo = new CirculoImpl();
		java.rmi.Naming.rebind("rmi://" + java.net.IntAddress.getLocalHost().getHostAddress()+ ":" + args[0] + "/PruebaRMI", cir);
	}
	catch (Exceptio e){
		e.printStackTrace();
	}
}

//Cliente 

import java.rmi.*;

public class CirculoCliente{
	private CirculoCliente(){};
}

public static void main(String[] args){
	String cade;
	try{
		Circulo cir = (Circulo)java.rmi.Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/PruebaRMI");
		System.out.println(""+cir.coordenadaValida(10,40));
	}
	catch(Exceptio.e){
		e.printStackTrace();
	}
}

/*
Problema 3.-Escribir el código de  un método remoto que 
calcule el salario semanal de un trabajador que gana el 
salario mínimo en base a los horas trabajadas por dicho 
trabajador durante la semana. Considere 40 horas normales 
de trabajo a la semana y que las horas extras 
(las que se trabajan después de transcurridas las 40) 
se pagan dobles.
*/

//Interfaz 

import java.rmi,*; 

public interface Salario extends Remote{
	public float calcularSalario(int h, float salariomen) throws
}

//Servidor 

import java.rmi.*;
import java.rmi.server.*;
import java.net.*; 

public class SalarioImpl extends UnicastReomteObject implements Salario{
	public SalarioImpl() throws RemoteExceptio{
		super();
	}
	public float calcularSalrio(int h, float salariomen) {
		float h_n=0, h_e=0;
		if(h<40){
			h_n(n*salario_m);
		}
		else {
			h_n=(40*salario_m);
			h = 40; 
			h_e=h*2salario_m;
		}
		return h_n + h_e;
	}

	public static void main(String[] 1){
		try {
			SalarioImp s = new SalarioImp();
			Naming.rebind("//localhost:1486/Salario", s);
			//Asignamos url a objeto remoto
			System.out.println("\nServidor Ejecutandose...");
		}
		catch(RemoteException e){}
		//se pueden generar errors con ek servidor, al haber problemas con la url
		catch(MalformedURLExceptio){}	
	}
}

//Cliente 

import java.rmi.*; 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;

public class SalarioCliente implements ActionListener{
	private JFram f; 
	private JButton boton; 
	private JTextField t1, t2; 
	private JLabel e1,e2,resp; 
	private String cadena; 
	public void CrearV(){
		f = new Jframe("Salario"); 
		//Creamos marco y definimos sus caracteristicas: 
		f.setlLayout(null);
		f.SetSize(450,150);
		f.SetDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		boton = new.JButton("Aceptar");
		boton.addActionListener(this);
		t1 = new JTextField(20); 
		e1 = new JLabel("Horas");
		e2 = new JLabel("Salario Min"); 
		resp = new JLabel("");
		f.add(boton); 
		f.add(t1);
		f.add(t2);
		f.add(e1);
		f.add(e2);
		f.add(resp); 
		e1.setBounds(10,10,80,20);
		e2.setBounds(100,10,80,20);
		t1.setBounds(100,10,80,20);
		t2.setBounds(200,10,80,20);
		boton.setBounds(100,70,80,20); 
		f.setVisible(true);
		public void actionPerformed(ActionEvent e){
			int horas;
			try{
				horas = Integer.parseInt(t1.getText());
				salario_min = Float.parseFloat(t2.getText());
				try{
					i = (Salario)Naming.lookup("//localhost:1406/Salario");
					resp.setText{
						"total a cobrarse:" + i.calcularSalario(horas.salario_min)));
					}
					catch(Exceptio EX){
						Joption.pane.whowMessageDialog(null, "ERROR:"+ Ex, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(NumberFormatExceptio ex){
					JOptionPane.MessageDialog(null, "Se genero un error en la convrsion", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				}
				public static void main(String[] s){
					new SalarioCliente();
				}
			}
		}


/*
Problema 4.-Escribir el código de  un método remoto que 
convierta una cadena a mayúsculas y  otro método remoto 
que obtenga la longitud de  una cadena.
*/

import java.rmi.*; 
import java.rmi.server.*; 

class cadenitaImpl extends UnicasRemoteObject implements ServicioEco{
	public String cadenitaImpl() throws RemoteException{
		super(); 
	}
	public String CadenaToM(String s) throws RemoteException{
		return s.toUpperCase();
	}
	public int CadenaLeng(String s) throws RemoteExceptio{
		return s.length();
	};
}

	public int CadenaLeng(String s) throws RemoteExceptio { 
		return s.legth();
	static public void main (String args[]){ 
		try { 
			cadenitaImpl srv = new cadenitaImpl(); 
			Naming.rebind("rmi://localhost:" + args[0] + "/Cadena", srv);
		}
	catch (RemoteExceptio e){
		System.err.println("Error de comunicacion:" + e.toString());
		System.exit(1);
	}
	catch(Exceptio e){
		System.err.println("Excepcion en servidor:");
		e.printStackTrace(); 
		System.exit(1);
	}
	}

/*
Problema 5.- Escribir el código de los siguientes métodos 
remotos: el que calcula el máximo de un arreglo de enteros, 
el que calcula el mínimo de un arreglo de enteros y el que 
calcula el promedio de un arreglo de enteros 
*/

//Interfaz 

import java.rmi.*; 
import java.util.*; 

public interface ArregloI extends Remote{
	public int mayor(ArrayList<Integer> a )
	throws RemoteExceptio; 
	public int menor(ArrayList<Integer> a)
	throws RemoteExceptio; 
	public int promedio(ArrayLis<Integer> a)
	throws RemoteExceptio;
}

//Servidor 

import java.rmi.*; 
import java.rmi.sever.*;
import java.util.*; 
import javax.swing.*; 

class ArregloImp extends UnicasRemoteObject implements Arreglo{
	public ArregloImp() 
	throws RemoteExceptio{
		super();
	}

public int mayor(Array<Integer> a)
	throws RemoteException{
		int mayor = 0, i = 0; 
		if(a.size()! = 0){
			mayor = a.get(0);
			for(i = 1; i<a,size(); i++){
				if(a.get(i)>mayor)
					mayor = a.get(i);
			}
		} 
		return mayor; 
	}
	public int menor(ArrayList<Integer>a)
	throws RemoteException{
		int menor = mayor (a); 
		int i = 0; 
		for(i = 0; i<a.size(); i++){
			if(a.get(i)<menor){
				menor = a.get(i);
			}
		}
		return menor; 
	}

	public int promedio(ArrayList<Integer>a) 
	throws RemoteException{
		int i = 0; 
		prom = 0; 
		for(i=0; i<a.size(); i++){
			prom+= a.get(i);
		}
		if(a.size()!=0);
		prom/=a.size();
		return prom;
	}
	public static void main(String[] s){
		try{
			Arreglo obj = new ArregloImp(); 
			Naming.bind("//localhost:1406/Arreglo", obj);
			System.out.println("Servicio en ejecucion");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR:" +e, "ERROR CON SERVIDOR", JOptionPane.ERROR_MESSAGE);
		}
	}
}

//Cliente 

import java.rmi.*; 
import java.awt.event.*;
import javax.swing.*; 
import java.util.*;
import java.awt.*; 
public class ArregloCli{
	private JLabel jlNuevo, ljMenor, jlMayor, jlprom;
	private JButton boton; 
	private JTextField campo;
	private JComboBox<Integer> combo;
	private Thread hilo;
	private JPanel jp1, jp2; 
	private JFrame f; 
	private ArrayList<Integer> enteros; 
public ArregloCli(){
	hilo = new Thread(ne Runnable){
		public void run(){
			int tam = 0; 
			while(true){
				try{
					ArregloI obj(ArregloI)Naming.lookup("//local.host:1406/Arreglo");
					jlMenor.setText("Menor:" + obj.menor(enteros));
					jlMayor.setText("Mayor:" +obj.mayor(enteros));

				}
				catch(Exception ex){
					System.out.println("Fallo"+ex);
				}
			}
		}; 
		hilo.start();
		enteros = new ArrayList<Integer>();
		CrearVentana();
	}

	public void CrearVentada(){
		jlNuevo = new JLabel("Nuevo numero:");
		jlMenor = new JLabel("Menor:");
		jlMayor = new JLabel("Mayor:");
		jlProm = new JLabel("Promedio:");
		campo.new JTextField(30);
		campo.setFront(new Front("Arial", 0,20));
		cambo = new JComboBox<Integer>();
		combo.setFront(mew Front("Arial", 0,20));
		boton = new JButton("Añadir");
		boton.addActionListener(new ActionListener()){
			public void actionPerformed(ActionEvent evento){
				try{
					int n = Integer.parseInt(campo.getText());
					campo.setText("");
					enteros.add(n); 
					enteros.addItem(n);
					JOptionPane.showMessageDialog(F,"Se agrego  correctamente nuevo Elemento", JOptionPane.INFORMATIO_MESSAGE);
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(F, "Error al convertir:" "fallo en la conversion", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,2,2,2));
		jp1.add(jlNuevo);
		jp1.add(campo);
		jp1.add(boton); 
		jp1.add(combo);
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3,1,2,2));
		jp2.add(jlMenor);
		jp2.add(jlMayor);
		jp2.add(jlprom);
		F = new JFrame("Arreglo"); 
		F.setLayout(null);
		F.setSize(500,600);
		F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		F.add(jp1);
		jp1.setBounds(10,10,400,140);
		jp2.setBounds(10,150,400,140);
		F.SetVisible(true);
 		}
 		public static void main(String[] c){
 			new ArregloCli();
	}

}

/*
			****************
				JAVABEANS
			****************
*/
/* 
Para resolver los problemas de abajo tenga en cuenta lo siguiente:
-Un Javabean tiene que tener un constructor por defecto (sin argumentos)
-Un Javabean tiene que tener persistencia, es decir, debe implementar la interfaz Serializable
*/ 

/*Problema 1-Codificar un JavaBean llamado Viaje que tenga las siguientes propiedades:
Origen ( lectura/escritura), Destino ( lectura/escritura), y Costo ( lectura/escritura)
*/

import java.io.Serializable;

public class viaje implements Serializable{ 
	this.origen = origen; 
	this.destino = destino; 
	this.costo = costo; 
}

public String getOrigen(){
	return origen;
}

public String getCosto(){
	return costo;
}

public void setOrigen(String origen){
	this.origen = origen;
}

public void setDestino(String destino){
	this.destino = destino; 
}

public void setCosto(String costo){
	this.costo = costo;
}

}

/*
Problema 2-Codificar un JavaBean llamado Pelicula que tenga las siguientes propiedades:
Titulo ( lectura/escritura), Director ( lectura/escritura), y Año ( lectura/escritura)
*/ 

import java.io.SeriaLizable;

public class Pelicula implements Serializable{
	private String titulo; 
	private String directo; 
	private int año; 
	public Pelicula(){
	public Pelicula(String titulo, String directo, int año){
		this.titulo = titulo; 
		this.directo = directo; 
		this.año = año; 
	}
	public String getTitulo(){
		return titulo;
	}
	public String getDirector(){
		return director;
	}
	public int getAño(){
		return año;
	}
	public void setTitulo(String director){
		this.director = director;
	}
	public void setAño(int año){
		this.año = año;
	}
} 

/*
Problema 3.-Codificar un JavaBean llamado Perro que tenga las siguientes propiedades:
Nombre ( lectura/escritura), Raza ( lectura/escritura), Edad ( lectura/escritura), Dueño ( lectura/escritura) , Genero  ( lectura/escritura), y AñosRestantesDeVida ( solo lectura). Suponga que si la raza es:
*/

import java.io.Serializable; 
public class Perro implements Serializable{
	private String nombre; 
	private String raza; 
	private int edad; 
	private String dueño; 
	private String genero; 
	public Perro(){}
	public Perro(String nombre, raza, int edad, String dueño, String genero){
		this.nombre = nombre; 
		this.raza = raza;
		this.edad=edad;
		this.dueño=dueño;
		this.genero=genero;
	}
public String getNombre(){
	return nombre; 
}
public String getRaza(){
	return raza;
}
public String getEdad(){
	return edad;
}
public String getDueño(){
	return dueño;
}
public String getGenero(){
	return genero;
}
public int getAñosRestantesDeVida(){
	if(raza == "Pastor Aleman")
		return 15-edad; 
	else if(raza == "boxer")
		return 11-edad; 
	else if (raza == "Terrier")
		return 8-edad;
	else if (raza == "Doberman")
		return 13-edad; 
	else 
		return 14-edad; 
	}
}

/*
Problema 4.-En el siguiente JavaBean (Car) determinar cuales son sus propiedades y si son de lectura o escritura o ambas cosas.
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Car implements Serializable{
	private String make, model; 
	double price; setMake (){
		return make;
	}
public void setMake (String m) {
	make = m; 
}
public void setModel(String mo){
	model = mo;
}

}


/*
			****************
				SERVLETS
			****************
*/

/*
1.-Codificar un Servlet que calcule el área de un circulo a partir de los datos de un formulario enviados por el navegador y envié el resultado de dicho calculo al cliente como texto plano o HTML. Escribir el código HTML del formulario con un campo de entrada para el radio y el botón de enviar.
*/

<HTML>
	<HEAD>
	<TITLE>Formulario<TITLE>
	</HEAD>
	<BODY>

	<form method = "POST" action ="/servlets/Area> radio=<type = "text" name = "radio"> <input type = "submit" value = "enviar"> 
	</form>
	</body>
	</html>

	public class Area extends HttpServlet{
		public void init(ServletConfig config) throws ServletsExceptio{
			System.out.println("init");
		}
		public void dePost(HttpServletRequest req, HttpServletResponse res)
		throws ServletsException, IOException{
			res.setContentType("text/html");
			PrintfWrinter out = res.getWriter();
			String n = req.getParameter("radio");
			float rad = Float.parseFloat(n);
			float area = 3.1416*rad*rad;
			out.println("<HTML>");
			out.println("<HEAD> <TITLE> Area Circulo </TITLE><HEAD>");
			out.println("<BODY>");
			out.println("<H1> eL AREA DEL CIRCULO DE RARIO %d ES %f</H1>", rad,area);
			out.println("</BODY></HTML>");
		}
		public void destroy(){
			System.out.println("destroy");
		}
		public String getServletInfo(){
			return null;
		}
		public ServletConfig getServletConfig(){
			return null; 
		}
	}


	/*
	2.-Codificar un Servlet que calcule el perímetro de un pentágono no regular  a partir de los datos de un formulario  enviados por el navegador y envié el resultado de dicho calculo al cliente como texto plano o HTML Escribir el código HTML del formulario con un campo de entrada para cada lado del  pentágono no regular y el botón de enviar.
	*/
	<html>
	<body>
	<form method = "POST" action =" /servlets/Perimetro"> lado1<input type = "text" name="lado1"> lado2=<input type="text" name ="lado2"> lado3=<input type="text" name ="lado3"> lado4 =<input type"text" name ="lado4"> lado5 =< input type = "text" name = "lado5"> input type="submit" value="enviar">
	</form>
	</body>
	</html>
	public class Perimetro extends HttpServlet{
		public void init(ServletConfig config) throw ServletsException{
			System.out.println("init");
		}

		public void doPost(HttpServletRequest req, HttpServletResponde res)
		throws ServletsException, IOException{
			res.setConentType("text/html");
			PrintWrinter out = res.getWriter();
			String n1 = req.getParameter("lado1");
			String n2 = req.getParameter("lado2");
			String n3 = req.getParameter("lado3");
			String n4 = req.getParameter("lado4");
			String n5 = req.getParameter("lado5");
			int l1 = Integer.parseInt(n1);
			int l2 = Integer.parseInt(n2);
			int l3 = Integer.parseInt(n3);
			int l4 = Integer.parseInt(n4);
			int l5 = Integer.parseInt(n5);
			int perimetro = l1+l2+l3+l4+l5;
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Perimetro pentagono</TITLE></HEAD>");
			out.println("<BODY>");
		}
		public void destroy(){
			System.out.println("destroy");
		}
		public String getServletInfo(){
			return null;
		}
		public ServletConfig getServletConfig(){
			return null;
		}
	}


	/*
4.-Codificar un Servlet que calcule el promedio  de las calificaciones de un alumno en las siguientes materias: física,  matemáticas ,   química , y español  a partir de los datos de un formulario enviados por el navegador y envié el resultado de dicho calculo al cliente como texto plano o HTML. Escribir el código HTML del formulario con un campo de entrada para cada materia y el botón de enviar.
*5.-Codificar un Servlet que dibuje una imagen en memoria y luego la envié a un cliente
*/

<html>
	<body>
	<form method = "POST" action =" /servlets/Promedioo"> fisica<input type = "text" name="fisica"> matematicas=<input type="text" name ="matematicas"> quimica=<input type="text" name ="quimica"> español =<input type"text" name ="español">  input type="submit" value="enviar">
	</form>
	</body>
	</html>
public class Pormedio extends HttpServlet{
		public void init(ServletConfig config) throw ServletsException{
			System.out.println("init");
}

public void doPost(HttpServletRequest req, HttpServletResponde res)
		throws ServletsException, IOException{
			PrintWrinter out = res.getWriter();
			float c1 = Float.parseFloat(req.getParameter("fisica"));
			float c2 = Float.parseFloat(req.getParameter("matematicas"));
			float c3 = Float.parseFloat(req.getParameter("quimica"));
			float c4 = Float.parseFloat(req.getParameter("español"));
			float promedio = (c1+c2+c3+c4)/4; 
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Promedio alumnos</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>El promedio del alumno es %f </H1>", promedio);
			out.println("</BODY></HTML>");
}

public void destroy(){
			System.out.println("destroy");
		}
		public String getServletInfo(){
			return null;
		}
		public ServletConfig getServletConfig(){
			return null;
		}
	}
