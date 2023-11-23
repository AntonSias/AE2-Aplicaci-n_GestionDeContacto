package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import vista.VentanaAdd;
import vista.VentanaEdit;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener{

		private VentanaPrincipal ventanaPrincipal;
		private VentanaAdd ventanaAdd;
		private VentanaEdit ventanaEdit;
		
		public Controlador(VentanaPrincipal ventanaPrincipal) {
			this.ventanaPrincipal = ventanaPrincipal;
			this.ventanaAdd = new VentanaAdd();
		    this.ventanaEdit = new VentanaEdit(); 
		    
		    ventanaAdd.setVisible(false);
		    ventanaEdit.setVisible(false);
		}
		
		public Controlador (VentanaAdd ventanaAdd) {
			this.ventanaAdd = ventanaAdd;
			this.ventanaEdit = new VentanaEdit();
			this.ventanaPrincipal = new VentanaPrincipal();
			
			ventanaPrincipal.setVisible(false);
			ventanaEdit.setVisible(false);
		}
		
		public Controlador (VentanaEdit ventanaEdit) {
			this.ventanaEdit = ventanaEdit;
			this.ventanaAdd = new VentanaAdd();
			this.ventanaPrincipal = new VentanaPrincipal();
			
			ventanaPrincipal.setVisible(false);
			ventanaAdd.setVisible(false);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			//VENTANA PRINCIPAL
			//Boton add
			if(e.getSource() == ventanaPrincipal.getButtonAdd()) {
				
				ventanaAdd.setVisible(true);
				Controlador controlador = new Controlador(ventanaAdd);
				ventanaAdd.setControlador(controlador);
				ventanaPrincipal.setVisible(false);
			}
			
			//Boton edit
			if(e.getSource() == ventanaPrincipal.getButtonEdit()) {
				
				int fila_selec = ventanaPrincipal.getIndexTable();
				String valorNombreString = (String) ventanaPrincipal.getContacTable().getValueAt(fila_selec, 0);
				String valorTelefonoString =(String) ventanaPrincipal.getContacTable().getValueAt(fila_selec, 1);
				
				ventanaEdit.setVisible(true);
				Controlador controlador = new Controlador(ventanaEdit);
				ventanaEdit.setControlador(controlador);
				ventanaEdit.getNomnJTextArea().setText(valorNombreString);
				ventanaEdit.getTelefonoJTextArea().setText(valorTelefonoString);
				ventanaPrincipal.setVisible(false);
			}
			
			//Botton delete
			if(e.getSource() == ventanaPrincipal.getButtonDelete()) {
				int fila_selec = ventanaPrincipal.getIndexTable();
				
				DefaultTableModel modelo = (DefaultTableModel)ventanaPrincipal.getContacTable().getModel();
				modelo.removeRow(fila_selec);
			}
			
			//VENTANA ADD
			//boton ok
			if(e.getSource() == ventanaAdd.getOkButton()) {
				if(ventanaAdd.getNomnJTextArea().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El nombre del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
				} else if (ventanaAdd.getTelefonoJTextArea().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El teléfono del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Contacto añadido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					ventanaPrincipal.getTableModel().addRow(new String[] {ventanaAdd.getNomnJTextArea().getText(), ventanaAdd.getTelefonoJTextArea().getText()});
					ventanaPrincipal.setVisible(true);
					Controlador controlador = new Controlador(ventanaPrincipal);
					ventanaPrincipal.setControlador(controlador);
					ventanaAdd.setVisible(false);
				}
			}
			
			//boton cancel
			if(e.getSource() == ventanaAdd.getCancelButton()) {
				ventanaPrincipal.setVisible(true);
				ventanaAdd.setVisible(false);
			}
			
			//VENTANA EDIT
			//boton ok
			if(e.getSource() == ventanaEdit.getOkButton()) {
				if(ventanaEdit.getNomnJTextArea().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El nombre del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
				}else if(ventanaEdit.getTelefonoJTextArea().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El teléfono del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Contacto modificado con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					ventanaPrincipal.getTableModel().addRow(new String[] {ventanaEdit.getNomnJTextArea().getText(), ventanaEdit.getTelefonoJTextArea().getText()});
					ventanaPrincipal.setVisible(true);
					Controlador controlador = new Controlador(ventanaPrincipal);
					ventanaPrincipal.setControlador(controlador);
					ventanaEdit.setVisible(false);
				}
				
			}
			
			//boton cancel
			if(e.getSource() == ventanaEdit.getCancelButton()) {
				ventanaPrincipal.setVisible(true);
				ventanaEdit.setVisible(false);
			}
			
		}
		
		
}
