package controlador;

import vista.VentanaAdd;
import vista.VentanaEdit;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal ventana1 = new VentanaPrincipal();
		Controlador controlador = new Controlador(ventana1);
		ventana1.setControlador(controlador);
		//VentanaAdd ventana2 = new VentanaAdd();
		//VentanaEdit ventana3 = new VentanaEdit();
	}

}
