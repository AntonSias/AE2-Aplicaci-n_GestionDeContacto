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
           ventanaContacto=new NewContac(this);
            ventanaContacto.setVisible(true);
            ventanaContacto.getCajaNombre().requestFocus();
        }
    


        if (e.getSource() == Ventana.getBotonUpdate()) {
            ventanaEditar = new Editar(this);
            ventanaEditar.setVisible(true);
        }{

        if(e.getSource()==ventanaContacto.getB1()){
        	if(ventanaContacto.getCajaNombre().getText().isEmpty()) {// para obtener el contenido getTex
			       JOptionPane.showMessageDialog(null, "Escriba  su nombre" , "Aviso", JOptionPane.INFORMATION_MESSAGE );                                            
		}else if(ventanaContacto.getCajaPhone().getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Escriba su teléfono" , "Aviso", JOptionPane.INFORMATION_MESSAGE );
		}else {
		
			Ventana.getTableModel().addRow(new  String[] {ventanaContacto.getCajaNombre().getText(), ventanaContacto.getCajaPhone().getText()});
			ventanaContacto.dispose();
		}
		
        }

        
    }
}
}