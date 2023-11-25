package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.NewContac;
import vista.VentanaPrincipal;

public class ManejadorEAdd implements ActionListener {
    VentanaPrincipal Ventana;
    NewContac ventanaContacto;

    public ManejadorEAdd(VentanaPrincipal ventanaPrincipal, NewContac ventanaContacto) {
        this.Ventana = ventanaPrincipal;
        this.ventanaContacto = ventanaContacto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ventanaContacto.getCajaNombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba su nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else if (ventanaContacto.getCajaPhone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba su teléfono", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Ventana.getTableModel().addRow(new String[] { ventanaContacto.getCajaNombre().getText(),
                    ventanaContacto.getCajaPhone().getText() });
            ventanaContacto.dispose();
        }
    }
}
