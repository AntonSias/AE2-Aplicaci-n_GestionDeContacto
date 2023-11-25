package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.Editar;
import vista.NewContac;
import vista.VentanaPrincipal;

public class ManejadorEventos implements ActionListener {
    VentanaPrincipal Ventana;
    NewContac ventanaContacto;
    Editar ventanaEditar;

    public ManejadorEventos(VentanaPrincipal Ventana) {
        this.Ventana = Ventana;
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Ventana.getBotonAdd()) {
           

            ventanaContacto = new NewContac();
            ventanaContacto.setVisible(true);
            ventanaContacto.getCajaNombre().requestFocus();
        }

        if (e.getSource() == Ventana.getBotonUpdate()) {
            System.out.println("Botón Editar presionado");
            ventanaEditar = new Editar(this);
            ventanaEditar.setVisible(true);
        }

          }
}
