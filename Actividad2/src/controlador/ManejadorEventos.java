package controlador;

import vista.Editar;
import vista.NewContac;
import vista.VentanaPrincipal;
import controlador.ManejadoUpdate;
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
            int selectedRow = Ventana.getTable().getSelectedRow();

            if (selectedRow != -1) {
                String nombre = (String) Ventana.getTableModel().getValueAt(selectedRow, 0);
                String telefono = (String) Ventana.getTableModel().getValueAt(selectedRow, 1);

                ventanaEditar = new Editar(this);
                ventanaEditar.getCajaNombre().setText(nombre);
                ventanaEditar.getCajaPhone().setText(telefono);

                ManejadoUpdate manejadorUpdate = new ManejadoUpdate(Ventana, ventanaEditar);
                ventanaEditar.establecerListeners(manejadorUpdate);

                ventanaEditar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para editar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        
        
        
        
        if (e.getSource() == Ventana.getBotonDelete()) {
            DefaultTableModel modelo = Ventana.getTableModel();
            modelo.setRowCount(0);  
        }
    }

		
	}
    
    

