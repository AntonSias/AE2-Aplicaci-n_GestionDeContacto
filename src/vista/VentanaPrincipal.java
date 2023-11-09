package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {
	
	private JButton buttonAdd, buttonDelete, buttonEdit;
	private JTable contacTable;
	private String [] rowName = {"Nombre", "Teléfono"};
	private Object [][] dataRowObjects = {
			{"Antón","697861309"},
			{"Antón","697861309"},
			{"Antón","697861309"},
			{"Antón","697861309"},
			{"Antón","697861309"}
	};
	
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
	
	public void inicializarComponentes() {
		
		contacTable = new JTable(dataRowObjects,rowName);
		JScrollPane scrollPane = new JScrollPane(contacTable);
		scrollPane.setBounds(40, 40, 400, 300);
		add(scrollPane);
		
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
	
	
}
