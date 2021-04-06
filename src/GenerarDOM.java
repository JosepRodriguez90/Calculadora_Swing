import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//https://www.youtube.com/watch?v=aD7BLolmNNY
public class GenerarDOM{
	
	private Document document;
	
	//Metodo para crear una variable de tipo archivo
	GenerarDOM() throws ParserConfigurationException{
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		document = builder.newDocument();
	}
	
	//Metodo para generar el interior de este documento, elementos, hijos etc
	public void generarDocument() {
		Element ganadores = document.createElement("Resultats");
		document.appendChild(ganadores);
		
		Element ganador = document.createElement("Resultat");
		ganadores.appendChild(ganador);
		ganador.setAttribute("vegadesResultats", "1");
		
		Element nombre = document.createElement("nombre");
		nombre.appendChild(document.createTextNode(Datos.resultadoString));
		ganador.appendChild(nombre);
		
	}
	
	//Metodo para transformar el documento en un archivo XML con nombre 
	public void generarXML() throws IOException, TransformerException {
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transformer = factoria.newTransformer();
		
		Source source = new DOMSource(document);
		File file = new File("Resultats.xml");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		Result result = new StreamResult(pw);
		
		transformer.transform(source, result);
	}
}