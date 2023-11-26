package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ManejadorEAdd;

public class NewContac extends JFrame {
    JTextField cajaNombre, cajaPhone;
    JLabel nombre, phone;
    JButton BADD, BCancel;

    public NewContac(ActionListener actionListener) {
        setTitle("Nuevo Contacto");
        setBounds(900, 450, 450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciarVariables();
        setLayout(null);
        setVisible(false);

        
        establecerListeners(actionListener);
    }

    public void iniciarVariables() {
        BADD = new JButton();
        BADD.setBounds(270, 270, 65, 20);
        BADD.setText("OK");
        add(BADD);

        BCancel = new JButton("Borrar");
        BCancel.setBounds(340, 270, 85, 20);
        add(BCancel);

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
        add(phone);
    }

    public void establecerListeners(ActionListener actionListener) {
        BADD.addActionListener(actionListener);
       BCancel.addActionListener(actionListener);
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

    public JButton getBADD() {
        return BADD;
    }

    public void setBADD(JButton bADD) {
        BADD = bADD;
    }

    public JButton getBCancel() {
        return BCancel;
    }

    public void setBCancel(JButton bCancel) {
        BCancel = bCancel;
    }

    public JLabel getNombre() {
        return nombre;
    }

    public void setNombre(JLabel nombre) {
        this.nombre = nombre;
    }

    public JLabel getPhone() {
        return phone;
    }

    public void setPhone(JLabel phone) {
        this.phone = phone;
    }
}
