package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ManejadorEventos;



public class Editar extends JFrame {

    JButton B1E, B2E;
    JTextField cajaNombre, cajaPhone;
    JLabel nombre, phone;
	private ManejadorEventos manejador;
    

    public Editar(ManejadorEventos manejador) {
    	this.manejador=manejador;
        setTitle("Editar contacto");
        ImageIcon icon = new ImageIcon("SADAM1.jpeg");
        setBounds(900, 80, 450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
        iniciarVariables();
        setLayout(null);
        setVisible(true);
    }

    public void iniciarVariables() {
        B1E = new JButton();
        B1E.setBounds(270, 270, 65, 20);
        B1E.setText("OK");
        add(B1E);

        B2E = new JButton();
        B2E.setBounds(340, 270, 85, 20);
        B2E.setText("Cancel");
        add(B2E);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(153, 100, 190, 30);
        cajaNombre.setFont(new Font("Dialog", Font.BOLD, 14));
        cajaNombre.setForeground(new Color(102, 0, 153));
        add(cajaNombre);

        nombre = new JLabel("Nombre");
        nombre.setBounds(80, 68, 100, 100);
        nombre.setFont(new Font("Arial", Font.BOLD, 14));
        add(nombre);

        cajaPhone = new JTextField();
        cajaPhone.setBounds(153, 170, 190, 30);
        cajaPhone.setFont(new Font("Dialog", Font.BOLD, 14));
        cajaPhone.setForeground(new Color(102, 0, 153));
        add(cajaPhone);

        phone = new JLabel("Teléfono");
        phone.setBounds(80, 135, 100, 100);
        phone.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public JButton getB1E() {
        return B1E;
    }

    public void setB1E(JButton b1e) {
        B1E = b1e;
    }

    public JButton getB2E() {
        return B2E;
    }

    public void setB2E(JButton b2e) {
        B2E = b2e;
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

   
}