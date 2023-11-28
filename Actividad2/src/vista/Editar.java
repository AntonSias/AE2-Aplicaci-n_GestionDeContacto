package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;



public class Editar extends JFrame {

    JButton BEO, BEC;
    JTextField cajaNombre, cajaPhone;
    JLabel nombre, phone;
	private ManejadorEventos manejador;
    

    public Editar(ActionListener actionListener) {
    	this.manejador=manejador;
        setTitle("Editar contacto");
        ImageIcon icon = new ImageIcon("SADAM1.jpeg");
        setBounds(900, 80, 450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(238, 209, 69));
     
        iniciarVariables();
        setLayout(null);
        setVisible(true);
    }

    public void iniciarVariables() {
        BEO = new JButton();
        BEO.setBounds(270, 270, 65, 20);
        BEO.setText("OK");
        add(BEO);

        BEC = new JButton();
        BEC.setBounds(340, 270, 85, 20);
        BEC.setText("Cancel");
        add(BEC);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(153, 100, 190, 30);
        cajaNombre.setFont(new Font("Dialog", Font.BOLD, 14));
        cajaNombre.setForeground(new Color(169, 30, 0 ));
        add(cajaNombre);

      
        try {
        	nombre = new JLabel("Nombre");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("Signatra.otf"));
            nombre.setHorizontalAlignment(SwingConstants.CENTER);
		    nombre.setFont(font.deriveFont(Font.HANGING_BASELINE, 40f));
		    nombre.setBounds(80, 68, 100, 100);
		    nombre.setForeground(Color.black);
            font = font.deriveFont(Font.PLAIN, 25);
            nombre.setFont(font);
            add(nombre);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
           
        }
      
      

        cajaPhone = new JTextField();
        cajaPhone.setBounds(153, 170, 190, 30);
        cajaPhone.setFont(new Font("Dialog", Font.BOLD, 14));
        cajaPhone.setForeground(new Color(169, 30, 0 ));
        add(cajaPhone);

        phone = new JLabel("Teléfono");
        phone.setBounds(80, 135, 100, 100);
        phone.setFont(new Font("Arial", Font.BOLD, 14));
    }
  
    public void establecerListeners(ActionListener actionListener) {
    	BEO.addActionListener(actionListener);
    	BEC.addActionListener(actionListener);
    }

	public JButton getBEO() {
		return BEO;
	}

	public void setBEO(JButton bEO) {
		BEO = bEO;
	}

	public JButton getBEC() {
		return BEC;
	}

	public void setBEC(JButton bEC) {
		BEC = bEC;
	}

	public JTextField getCajaNombre() {
		return cajaNombre;
	}

	public void setCajaNombre(JTextField cajaNombre) {
		this.cajaNombre = cajaNombre;
	}

	public JTextField getCajaPhone() {
		return cajaPhone;
	}

	public void setCajaPhone(JTextField cajaPhone) {
		this.cajaPhone = cajaPhone;
	}
	 public String getNombre() {
	        return cajaNombre.getText();
	    }

	    public String getTelefono() {
	        return cajaPhone.getText();
	    }
}