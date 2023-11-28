package controlador;

import javax.swing.SwingUtilities;

import vista.Menu;
import vista.VentanaAdd;
import vista.VentanaEdit;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		Controlador controlador = new Controlador(menu);
		menu.setControlador(controlador);
		/*VentanaPrincipal ventana1 = new VentanaPrincipal();
		Controlador controlador = new Controlador(ventana1);
		ventana1.setControlador(controlador);*/
		//VentanaAdd ventanaAdd = new VentanaAdd();
		//VentanaEdit ventanaEdit = new VentanaEdit();
		
	}

}
