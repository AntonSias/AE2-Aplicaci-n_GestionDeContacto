package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		    
		    ventanaPrincipal.setControlador(this);//
		    ventanaAdd.setControlador(this);
		    ventanaEdit.setControlador(this);
		    
		    ventanaAdd.setVisible(false);
		    ventanaEdit.setVisible(false);
		    
		    
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//VENTANA PRINCIPAL
			//Boton add
			if(e.getSource() == ventanaPrincipal.getButtonAdd()) {
				
				// Mostrar la ventana de añadir desde el controlador principal
		        mostrarVentanaAdd();
		        // Ocultar la ventana principal
		        ventanaPrincipal.setVisible(false);
				
			}
			
			//Boton edit
			if(e.getSource() == ventanaPrincipal.getButtonEdit()) {
				System.out.println("boton edit presionado");
				try {
					int fila_selec = ventanaPrincipal.getIndexTable();
					String valorNombreString = (String) ventanaPrincipal.getContacTable().getValueAt(fila_selec, 0);
					String valorTelefonoString =(String) ventanaPrincipal.getContacTable().getValueAt(fila_selec, 1);
					
					ventanaEdit.setVisible(true);
					
					ventanaEdit.getNomnJTextArea().setText(valorNombreString);
					ventanaEdit.getTelefonoJTextArea().setText(valorTelefonoString);
					ventanaPrincipal.setVisible(false);
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Seleccione un contacto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			//Botton delete
				if (e.getSource() == ventanaPrincipal.getButtonDelete()) {
				System.out.println("Boton borrar presionado");
				ventanaPrincipal.getButtonDelete().removeActionListener(this);
				    int fila_selec = ventanaPrincipal.getIndexTable();
				    
				    // Imprimir valores de diagnóstico
				    System.out.println("Fila seleccionada: " + fila_selec);
				    System.out.println("Tamaño de listaContactos: " + ventanaPrincipal.getListaContactos().size());

				    if (fila_selec >= 0 && fila_selec < ventanaPrincipal.getListaContactos().size()) {
				        Contacto contactoABorrar = ventanaPrincipal.getListaContactos().get(fila_selec);

				        // Borrar el contacto de la lista
						ventanaPrincipal.getListaContactos().remove(contactoABorrar);

			            // Borrar la fila correspondiente en el modelo de la tabla
			            ventanaPrincipal.getTableModel().removeRow(fila_selec);

			            // Escribir la estructura de datos actualizada en el archivo
			            escribirContactoEnArchivo();
			            
			            
				    } else {
				        JOptionPane.showMessageDialog(null, "Contacto borrado con éxito");
				    }
				}
				
				
			
			//VENTANA ADD
			//boton ok
			
			
			if (e.getSource() == ventanaAdd.getOkButton()) {
				
				String nombreString = ventanaAdd.getNomnJTextArea().getText();
				String telefonoString = ventanaAdd.getTelefonoJTextArea().getText();
						
		        if (ventanaAdd.getNomnJTextArea().getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El nombre del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else if (ventanaAdd.getTelefonoJTextArea().getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El teléfono del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		        	
		        	 Contacto nuevoContacto = new Contacto(nombreString, Integer.parseInt(telefonoString));
		             ventanaPrincipal.getListaContactos().add(nuevoContacto);
		            // Obtener el modelo de la tabla
		            DefaultTableModel modelo = ventanaPrincipal.getTableModel();
		            
		            // Añadir una nueva fila al final
		            modelo.addRow(new String[]{nombreString, telefonoString});
		            //Escribimos en el archivo
		            escribirContactoEnArchivo();
		            // Limpiar campos de la ventana de añadir
		            ventanaAdd.getNomnJTextArea().setText("");
		            ventanaAdd.getTelefonoJTextArea().setText("");
		            // Mostrar mensaje de éxito
		            JOptionPane.showMessageDialog(null, "Contacto añadido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		            
		            // Hacer visible la ventana principal y ocultar la de añadir
		            ventanaPrincipal.setVisible(true);
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
					
					
					//borramos el contacto anterior
					int fila_selec = ventanaPrincipal.getIndexTable();
					
					ventanaPrincipal.getListaContactos().get(fila_selec).setNombre(ventanaEdit.getNomnJTextArea().getText());
					ventanaPrincipal.getListaContactos().get(fila_selec).setTelefono(Integer.parseInt(ventanaEdit.getTelefonoJTextArea().getText()) );
	                

	                // Actualizar la fila en el modelo de la tabla
	                ventanaPrincipal.getTableModel().setValueAt(ventanaEdit.getNomnJTextArea().getText(), fila_selec, 0);
	                ventanaPrincipal.getTableModel().setValueAt(ventanaEdit.getTelefonoJTextArea().getText(), fila_selec, 1);
	                

	                // Escribir la estructura de datos actualizada en el archivo
	                escribirContactoEnArchivo();
					
					/*DefaultTableModel modelo = (DefaultTableModel)ventanaPrincipal.getContacTable().getModel();
					modelo.removeRow(fila_selec);*/
					
					ventanaPrincipal.setVisible(true);
					ventanaEdit.setVisible(false);
				}
				
			}
			
			//boton cancel
			if(e.getSource() == ventanaEdit.getCancelButton()) {
				ventanaPrincipal.setVisible(true);
				ventanaEdit.setVisible(false);
			}
			
		}
		
		public void mostrarVentanaAdd() {
	        ventanaAdd.setVisible(true);
	    }
		
		 private void escribirContactoEnArchivo() {
			// Ruta del archivo de texto
		        String rutaArchivo = "contactos.txt";

		        try {
		            // Crear un BufferedWriter para escribir en el archivo
		            // El segundo parámetro (false) indica que se sobrescribirá el archivo
		            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(rutaArchivo), false));

		            // Escribir cada contacto en una nueva línea del archivo
		            for (Contacto contacto : ventanaPrincipal.getListaContactos()) {
		                writer.write(contacto.getNombre() + "," + Long.toString(contacto.getTelefono()) );
		                writer.newLine();
		            }

		            // Cerrar el BufferedWriter
		            writer.close();

		        } catch (IOException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo.");
		        }
		    }
		 
		 
		
}
