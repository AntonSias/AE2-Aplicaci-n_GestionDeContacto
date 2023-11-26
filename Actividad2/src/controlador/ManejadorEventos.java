package controlador;

import vista.Editar;
import vista.NewContac;
import vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
            ventanaContacto = new NewContac(null);
            ventanaContacto.establecerListeners(new ManejadorEAdd(Ventana, ventanaContacto));
            ventanaContacto.setVisible(true);
            ventanaContacto.getCajaNombre().requestFocus();
        }

        if (e.getSource() == Ventana.getBotonUpdate()) {
            System.out.println("Botón Editar presionado");
            ventanaEditar = new Editar(this);
            ventanaEditar.setVisible(true);
        }
        
        if (e.getSource() == Ventana.getBotonDelete()) {
            DefaultTableModel modelo = Ventana.getTableModel();
            modelo.setRowCount(0);  
        }
    }
    
    
}
