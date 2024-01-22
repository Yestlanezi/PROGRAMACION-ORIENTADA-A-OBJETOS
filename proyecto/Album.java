import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Album extends JFrame implements ActionListener,Runnable{
	
	private JPanel Superior, Inferior, Botonera;
	//private JPanel panel;
	private JButton botones[], iniciar, atras, adelante, zoom, comentar;
	private ImageIcon imagenes [];
	private Thread cambio;
	Container c = getContentPane();
	Icon icono;
	JLabel foto,comentario;
	int i, x, t, convertido, res;
	boolean it;
	String test;
	JTextField texto, come;
	
	public Album(){
	
	texto = new JTextField(); come = new JTextField(); 
	zoom = new JButton("Zoom"); comentar = new JButton("Comentar");
	comentario = new JLabel();
	
	c.setLayout(new  FlowLayout(FlowLayout.CENTER));	
	Superior = new JPanel();
    Superior.setLayout(new GridLayout(4,7));
	
	cambio = new Thread(this);
	
	botones=new JButton[28];
	imagenes = new ImageIcon[28];
	imagenes[0]= new ImageIcon("1.jpg");
	imagenes[1]= new ImageIcon("2.jpg");
	imagenes[2]= new ImageIcon("3.jpg");
	imagenes[3]= new ImageIcon("4.jpg");
	imagenes[4]= new ImageIcon("5.jpg");
	imagenes[5]= new ImageIcon("6.jpg");
	imagenes[6]= new ImageIcon("7.jpg");
	imagenes[7]= new ImageIcon("8.jpg");
	imagenes[8]= new ImageIcon("9.jpg");
	imagenes[9]= new ImageIcon("10.jpg");
	imagenes[10]= new ImageIcon("11.jpg");
	imagenes[11]= new ImageIcon("12.jpg");
	imagenes[12]= new ImageIcon("13.jpg");
	imagenes[13]=new ImageIcon("14.jpg");
	imagenes[14]= new ImageIcon("15.jpg");
	imagenes[15]= new ImageIcon("16.jpg");
	imagenes[16]= new ImageIcon("17.jpg");
	imagenes[17]= new ImageIcon("18.jpg");
	imagenes[18]= new ImageIcon("19.jpg");
	imagenes[19]= new ImageIcon("20.jpg");
	imagenes[20]= new ImageIcon("21.jpg");
	imagenes[21]= new ImageIcon("22.jpg");
	imagenes[22]= new ImageIcon("23.jpg");
	imagenes[23]= new ImageIcon("24.jpg");
	imagenes[24]= new ImageIcon("25.jpg");
	imagenes[25]= new ImageIcon("26.jpg");
	imagenes[26]= new ImageIcon("27.jpg");
	imagenes[27]= new ImageIcon("28.jpg");
	
	iniciar = new JButton ("Presentacion");
	atras = new JButton ("Anterior");
	adelante = new JButton ("Siguiente");
	
	for(i=0; i<28; i++){
			botones[i]= new JButton(""+(i+1));
			botones[i].setBounds(0,0,75,60);
			icono = new ImageIcon(imagenes[i].getImage().getScaledInstance(botones[i].getWidth(), botones[i].getHeight(), Image.SCALE_DEFAULT));
			botones[i].setIcon(icono);
			botones[i].setBackground(java.awt.Color.white);
			Superior.add(botones[i]);
			botones[i].addActionListener(this);
			
		}
	
	//crear();
	
	Inferior = new JPanel();
	Inferior.setLayout(new FlowLayout(FlowLayout.LEFT));
	Inferior.setVisible(true);
	i = 0; x = 0;
	icono = new ImageIcon(imagenes[i].getImage().getScaledInstance(550, 340,0));
	foto = new JLabel();	
	foto.setIcon(icono);
	Inferior.add(foto);
	Inferior.add(comentario);
	
	Botonera = new JPanel();
    Botonera.setLayout(new GridLayout(7,1));
	
	Botonera.add(atras);
	Botonera.add(adelante);
	Botonera.add(iniciar);
	atras.addActionListener(this);
	adelante.addActionListener(this);
	iniciar.addActionListener(this);
	Botonera.add(texto);
	Botonera.add(zoom);
	zoom.addActionListener(this);
	Botonera.add(come);
	Botonera.add(comentar);
	comentar.addActionListener(this);
	
	//Superior.setSize(900,300);
	Inferior.setSize(900,500);	
		
	c.add(Superior); c.add(Inferior);c.add(Botonera);
		
	setSize(900, 720); setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		
		if(btn==zoom)
		{
			test = texto.getText().toString();
			convertido = Integer.parseInt(test);
			if(convertido>130)
				convertido=130;
			zoomcito();
		}
		if(btn==comentar)
		{
			comentario.setText(come.getText());
		}
		if (btn==adelante)
		{
			adelantarfoto();
		}
		if (btn==atras)
		{
			atrasarfoto();
		}
		if (btn==iniciar)
		{
			x++;
			if(x%2==0)
			{
				t = 10000;
			}
			else
			{
				t = 1;
				if(x==1)
					cambio.start();
			}
			
		}
		else
		{
      		for(res=0;res<28;res++)
			{
				test = btn.getText().toString();
				convertido = Integer.parseInt(test);
				convertido--;
				if(convertido==res)
				{
					i=res;
					icono = new ImageIcon(imagenes[i].getImage().getScaledInstance(550, 340,0));
					foto.setIcon(icono);
				}
			}
    	}		
	}
	
	void adelantarfoto()
	{
		i++;
		if(i==29)
			i=0;
		icono = new ImageIcon(imagenes[i].getImage().getScaledInstance(550, 340,0));
		foto.setIcon(icono);
	}
	
	void atrasarfoto()
	{
		i--;
		if(i==-1)
			i=28;
		icono = new ImageIcon(imagenes[i].getImage().getScaledInstance(550, 340,0));
		foto.setIcon(icono);
	}
	
	public void run ()
	{
		while (true){
			
			try 
			{
				adelantarfoto();
				cambio.sleep(t * 1500);
			}catch (Exception e){e.getMessage();}
		
		
		}
	}
	
	void zoomcito()
	{
		foto.setBounds(0,0,550,340);
		icono = new ImageIcon(imagenes[i].getImage().getScaledInstance((550*convertido)/100, (340*convertido)/100,0));
		foto.setIcon(icono);
	}
	
	public static void main (String argv [])
	{
		new Album();
	}
}