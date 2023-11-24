package controlador;

import vista.Editar;
import vista.NewContac;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
VentanaPrincipal VP = new VentanaPrincipal();

ManejadorEventos manejador = new ManejadorEventos(VP);
VP.establecerManejador(manejador);



	}

}
