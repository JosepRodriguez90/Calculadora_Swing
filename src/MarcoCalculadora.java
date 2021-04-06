import javax.swing.*;

public class MarcoCalculadora extends JFrame {

	MarcoCalculadora(){
		//Los dos primeros parametros son para indicar donde empieza la ventana, los dos otros el tamanyo de ancho y alto
		setBounds(300, 10, 805, 700);
		//Quando pulse la cruz de salir se cierra el programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creamos la lamina para que ejecute el constructor y anyadimos la lamina
		add(new Calculadora());
		//El marco se hace visible
		setVisible(true);
	}

	
}
