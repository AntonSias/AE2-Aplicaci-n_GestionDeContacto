package controlador;

import vista.NewContac;
import vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManejadorEAdd implements ActionListener {
    VentanaPrincipal ventanaPrincipal;
    NewContac ventanaContacto;

    public ManejadorEAdd(VentanaPrincipal ventanaPrincipal, NewContac ventanaContacto) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaContacto = ventanaContacto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ingresando al método actionPerformed en ManejadorEAdd");
        System.out.println("Botón OK presionado en NewContac");
        if (e.getSource() == ventanaContacto.getBADD()) {
            if (ventanaContacto.getCajaNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escriba su nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (ventanaContacto.getCajaPhone().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escriba su teléfono", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DefaultTableModel modelo = ventanaPrincipal.getTableModel();
                modelo.addRow(new String[] {
                        ventanaContacto.getCajaNombre().getText(),
                        ventanaContacto.getCajaPhone().getText()
                });
                ventanaContacto.dispose();
            }
        }
        
        if(e.getSource() == ventanaContacto.getBCancel()) {
           
            ventanaContacto.getCajaNombre().setText("");
            ventanaContacto.getCajaPhone().setText("");
        }
}
}
