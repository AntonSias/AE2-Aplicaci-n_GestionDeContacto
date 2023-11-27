package controlador;

import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;

import vista.NewContac;

public class Main {
    public static void main(String[] args) {
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

     
        ManejadorEventos manejadorEventos = new ManejadorEventos(ventanaPrincipal);

        ventanaPrincipal.establecerManejador(manejadorEventos);
   
      
    }
}
