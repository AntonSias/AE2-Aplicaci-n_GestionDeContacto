package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.*;
import controlador.Controlador;

public class VentanaPrincipal extends JFrame {
	
	private JButton buttonAdd, buttonDelete, buttonEdit;
	private JTable contacTable;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private String [] rowName = {"Nombre", "Teléfono"};
	private String rutaArchivoString = "contactos.txt";
	private List<Contacto> listaContactos = cargarContactosDesdeArchivo();
	
	public VentanaPrincipal() {
		
		setSize(700,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null); 
		setTitle("CONTACTOS");
		inicializarComponentes();
		setVisible(true);
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void inicializarComponentes() {
		
		
		
		tableModel = new DefaultTableModel(rowName,0);
		contacTable = new JTable(tableModel);
		scrollPane = new JScrollPane(contacTable);
		scrollPane.setBounds(40, 40, 400, 300);
		add(scrollPane);
		
		//Introducimos los contactos desde el archivo
		for (Contacto contacto : listaContactos) {
            tableModel.addRow(new String[]{contacto.getNombre(), Long.toString(contacto.getTelefono()) });
        }
		
		buttonAdd = new JButton("Añadir contacto");
		buttonAdd.setBounds(30,400,150,30);
		add(buttonAdd);
		
		buttonDelete = new JButton("Borrar contacto");
		buttonDelete.setBounds(370,400,150,30);
		add(buttonDelete);
		
		buttonEdit = new JButton("Editar contacto");
		buttonEdit.setBounds(450,100,200,60);
		add(buttonEdit);
		
	}
	
	public void setControlador(Controlador controlador) {
		buttonAdd.addActionListener(controlador);
		buttonDelete.addActionListener(controlador);
		buttonEdit.addActionListener(controlador);
	}
	
	public int getIndexTable() {
		return contacTable.getSelectedRow();
	}
	
	public int getSelectedRowIndex() {
        return contacTable.getSelectedRow();
    }

	public JButton getButtonAdd() {
		return buttonAdd;
	}

	public void setButtonAdd(JButton buttonAdd) {
		this.buttonAdd = buttonAdd;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}

	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}

	public JButton getButtonEdit() {
		return buttonEdit;
	}

	public void setButtonEdit(JButton buttonEdit) {
		this.buttonEdit = buttonEdit;
	}

	public JTable getContacTable() {
		return contacTable;
	}

	public void setContacTable(JTable contacTable) {
		this.contacTable = contacTable;
	}
	
	public List<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(List<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}
	
	private List<Contacto> cargarContactosDesdeArchivo() {
        // Ruta del archivo de texto
        String rutaArchivo = "contactos.txt";
        List<Contacto> contactos = new ArrayList<>();

        try {
            // Crear un BufferedReader para leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(new File(rutaArchivo)));

            // Leer cada línea del archivo y agregar un nuevo contacto a la lista
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 2) {
                    contactos.add(new Contacto(campos[0], Integer.parseInt(campos[1])));
                }
            }

            // Cerrar el BufferedReader
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
        }

        return contactos;
    }
}
