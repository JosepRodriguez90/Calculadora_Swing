import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JPanel implements ActionListener {

	JButton sumar;
	JButton restar;
	JButton multiplicar;
	JButton dividir;
	JButton igual;
	JButton salir;
	JButton reset;
	JButton generarResultado;
	JTextField pantallainput;
	JLabel pantallaresultado;
	
	Calculadora(){
		//Layouts con diferentes estilos buscar en google para mas informacion
		setLayout(new FlowLayout());
		
		//Crea un boton que muestra como simbolo lo que le pasas por parametro
		
		pantallainput = new JTextField(20);
				
		pantallaresultado = new JLabel();
		pantallaresultado.setText(String.valueOf(Datos.resultat)); //sempre esta mostrant per pantalla el valor de la variable.
		
		sumar = new JButton("+");
		restar = new JButton("-");
		multiplicar = new JButton("*");
		dividir = new JButton("/");
		igual = new JButton("=");
		reset = new JButton("reset");
		salir = new JButton("salir");
		generarResultado = new JButton("Generar resultado");
		
		
	
		/*reset.setBounds(10,10,300,25);
		salir.setBounds(10,10,300,50);*/
		
		
		sumar.addActionListener(this);
		restar.addActionListener(this);
		multiplicar.addActionListener(this);
		dividir.addActionListener(this);
		igual.addActionListener(this);
		pantallainput.addActionListener(this);
		reset.addActionListener(this);
		salir.addActionListener(this);
		generarResultado.addActionListener(this);
		
		
		add(pantallaresultado);
		add(pantallainput);
		add(sumar);
		add(restar);
		add(multiplicar);
		add(dividir);
		add(igual);
		add(reset);
		add(generarResultado);
		add(salir);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		if(e.getSource() == sumar) {
			
			Datos.numero1string = (String)pantallainput.getText();
			Datos.numero1 = Integer.parseInt(Datos.numero1string);
			Datos.calcul = "sumar";
			
			//cojemos el marco y lo vaciamos para anyadir una nueva lamina
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
		if(e.getSource() == restar) {
			
			Datos.numero1string = (String)pantallainput.getText();
			Datos.numero1 = Integer.parseInt(Datos.numero1string);
			Datos.calcul = "restar";
			
			//cojemos el marco y lo vaciamos para anyadir una nueva lamina
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
		if(e.getSource() == multiplicar) {
			
			Datos.numero1string = (String)pantallainput.getText();
			Datos.numero1 = Integer.parseInt(Datos.numero1string);
			Datos.calcul = "multiplicar";
			
			//cojemos el marco y lo vaciamos para anyadir una nueva lamina
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
		if(e.getSource() == dividir) {
			
			Datos.numero1string = (String)pantallainput.getText();
			Datos.numero1 = Integer.parseInt(Datos.numero1string);
			Datos.calcul = "dividir";
			
			//cojemos el marco y lo vaciamos para anyadir una nueva lamina
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
		if(e.getSource() == igual) {
			
			if(Datos.calcul.equals("sumar")) {
				Datos.numero2string = (String)pantallainput.getText();
				Datos.numero2 = Integer.parseInt(Datos.numero2string);
				
				Datos.resultat=Datos.numero1+Datos.numero2;
			}else if(Datos.calcul.equals("restar")) {
				Datos.numero2string = (String)pantallainput.getText();
				Datos.numero2 = Integer.parseInt(Datos.numero2string);
				
				Datos.resultat=Datos.numero1-Datos.numero2;
			}else if(Datos.calcul.equals("multiplicar")) {
				Datos.numero2string = (String)pantallainput.getText();
				Datos.numero2 = Integer.parseInt(Datos.numero2string);
				
				Datos.resultat=Datos.numero1*Datos.numero2;
			}else if(Datos.calcul.equals("dividir")) {
				Datos.numero2string = (String)pantallainput.getText();
				Datos.numero2 = Integer.parseInt(Datos.numero2string);
				
				Datos.resultat=Datos.numero1/Datos.numero2;
			}
			
			
			//cojemos el marco y lo vaciamos para anyadir una nueva lamina
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
		if(e.getSource() == salir) {
			CerrarPrograma();
		}
		
		if(e.getSource() == reset) {
			reset();
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
	
		if(e.getSource() == generarResultado) {

			
			Datos.resultadoString = Integer.toString(Datos.resultat);
			//Obliga ha hacer try catch por las excepciones de los metodos
			try {
				GenerarDOM generar = new GenerarDOM();
				generar.generarDocument();
				generar.generarXML();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.add(new Calculadora());
			marco.setVisible(true);
		}
		
	}
	
	public void CerrarPrograma(){
		MarcoCalculadora marco = (MarcoCalculadora) SwingUtilities.getWindowAncestor(this);
		marco.dispose();
	}
	
	public void reset(){
		Datos.calcul=null;
		Datos.numero1=0;
		Datos.numero1string=null;
		Datos.numero2=0;
		Datos.numero2string=null;
		Datos.resultadoString=null;
		Datos.resultat=0;

		
	}
	

}
