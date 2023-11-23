package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controlador.Controlador;

public class VentanaAdd extends JFrame{

	private JLabel lbNombre, lbTelefono;
	private JTextArea nombrJTextArea, telfJTextArea;
	private JButton okButton, cancelButton;
	
	
	
	public VentanaAdd() {
		
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null); 
		setTitle("Añadir contacto");
		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		//label nombre
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(70, 60, 100, 30);
		add(lbNombre);
		
		//label telefono
		lbTelefono = new JLabel("Teléfono");
		lbTelefono.setBounds(70, 110, 100, 30);
		add(lbTelefono);
		
		//textArea nombre
		nombrJTextArea = new JTextArea();
		nombrJTextArea.setBounds(160, 60, 160, 30);
		add(nombrJTextArea);
		
		//txtArea telefono
		telfJTextArea = new JTextArea();
		telfJTextArea.setBounds(160, 110, 160, 30);
		add(telfJTextArea);
		
		//boton ok
		okButton = new JButton("OK");
		okButton.setBounds(100,190,90,30);
		add(okButton);
		
		//boton cancel
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(200,190,90,30);
		add(cancelButton);
		
	}
	
	public void setControlador(Controlador controlador) {
		okButton.addActionListener(controlador);
		cancelButton.addActionListener(controlador);
	}
	
	public JLabel getLbNombre() {
		return lbNombre;
	}

	public void setLbNombre(JLabel lbNombre) {
		this.lbNombre = lbNombre;
	}

	public JLabel getLbTelefono() {
		return lbTelefono;
	}

	public void setLbTelefono(JLabel lbTelefono) {
		this.lbTelefono = lbTelefono;
	}

	public JTextArea getNomnJTextArea() {
		return nombrJTextArea;
	}

	public void setNomnJTextArea(JTextArea nomnJTextArea) {
		this.nombrJTextArea = nomnJTextArea;
	}

	public JTextArea getTelefonoJTextArea() {
		return telfJTextArea;
	}

	public void setTelefonoJTextArea(JTextArea telefonoJTextArea) {
		this.telfJTextArea = telefonoJTextArea;
	}
	
	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}


	
}
