package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Editar;
import vista.VentanaPrincipal;

public class ManejadoUpdate implements ActionListener {
VentanaPrincipal Ventana;
Editar VentanaUpdate;
 
public ManejadoUpdate (VentanaPrincipal Ventana, Editar VentanaUpdate) {
	this.Ventana=Ventana;
	this.VentanaUpdate= VentanaUpdate;
}


	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
