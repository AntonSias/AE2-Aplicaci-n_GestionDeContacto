package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.Controlador;

public class VentanaEdit extends JFrame{
	private JLabel lbNombre, lbTelefono;
	private JTextArea nombrJTextArea, telfJTextArea;
	private RoundButton okButton, cancelButton;
	private Color color1 = new Color(0xFFFFF); 
	private Color color2 = new Color(0x106AB6);
	
	
	
	public VentanaEdit() {
		
		setSize(400,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null); 
		setTitle("Modificar contacto");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagen1.png"));
		inicializarComponentes();
		setVisible(true);
		setLayout(new BorderLayout());
		final JPanel panelPersonalizado = new JPanel() {
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Graphics2D g2 = (Graphics2D) g.create();
		        Rectangle clip = g2.getClipBounds();
		        float x = getWidth();
		        float y = getHeight();
		        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1.darker(), 0.0f, (float) getHeight(), color2.darker()));
		        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
		        g2.dispose();
		    }
		};

        panelPersonalizado.setLayout(null);  // Usa un diseño nulo para el panel personalizado
        panelPersonalizado.setBounds(0, 0, getWidth(), getHeight());

        

        add(panelPersonalizado);
	}
	
	public void inicializarComponentes() {
		//label nombre
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(75, 145, 100, 30);
		lbNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		add(lbNombre);
				
		//label telefono
		lbTelefono = new JLabel("Teléfono");
		lbTelefono.setBounds(75, 195, 100, 30);
		lbTelefono.setFont(new Font("Dialog", Font.BOLD, 14));
		add(lbTelefono);
				
		//textArea nombre
		nombrJTextArea = new JTextArea();
		nombrJTextArea.setBounds(145, 150, 160, 25);
		nombrJTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(nombrJTextArea);
				
		//txtArea telefono
		telfJTextArea = new JTextArea();
		telfJTextArea.setBounds(145, 200, 160, 25);
		telfJTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(telfJTextArea);
				
		//boton ok
		okButton = new RoundButton("OK");
		okButton.setBounds(100,290,200,50);
		okButton.setFont(new Font("Dialog", Font.BOLD, 14));
		okButton.setForeground(Color.black);
		okButton.setBackground(new Color(0x32C4C0));
		add(okButton);
				
		//boton cancel
		cancelButton = new RoundButton("Cancel");
		cancelButton.setBounds(100,370,200,50);
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 14));
		cancelButton.setForeground(Color.black);
		cancelButton.setBackground(new Color(0x32C4C0));
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

	public void setOkButton(RoundButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(RoundButton cancelButton) {
		this.cancelButton = cancelButton;
	}
}
