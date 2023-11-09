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
		setTitle("CONTACTOS");
		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		contacTable = new JTable(dataRowObjects,rowName);
		JScrollPane scrollPane = new JScrollPane(contacTable);
		add(scrollPane);
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
