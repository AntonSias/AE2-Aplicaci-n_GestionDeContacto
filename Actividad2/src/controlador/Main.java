package controlador;

import vista.VentanaPrincipal;
import vista.NewContac;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        // Crear el manejador de eventos para la ventana principal
        ManejadorEventos manejadorEventos = new ManejadorEventos(ventanaPrincipal);

        // Establecer el manejador en la ventana principal
        ventanaPrincipal.establecerManejador(manejadorEventos);
    }
}
