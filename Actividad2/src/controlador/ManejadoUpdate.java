package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Editar;
import vista.VentanaPrincipal;

public class ManejadoUpdate implements ActionListener {
    VentanaPrincipal ventanaPrincipal;
    Editar ventanaEditar;

    public ManejadoUpdate(VentanaPrincipal ventanaPrincipal, Editar ventanaEditar) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaEditar = ventanaEditar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaEditar.getBEO()) {
           
            String nuevoNombre = ventanaEditar.getNombre();
            String nuevoTelefono = ventanaEditar.getTelefono();

           
            int selectedRow = ventanaPrincipal.getTable().getSelectedRow();
            ventanaPrincipal.getTableModel().setValueAt(nuevoNombre, selectedRow, 0);
            ventanaPrincipal.getTableModel().setValueAt(nuevoTelefono, selectedRow, 1);

          
            ventanaEditar.dispose();
        }
        if(e.getSource() == ventanaEditar.getBEC()) {
            
            ventanaEditar.getCajaNombre().setText("");
            ventanaEditar.getCajaPhone().setText("");
        }
    }
}
