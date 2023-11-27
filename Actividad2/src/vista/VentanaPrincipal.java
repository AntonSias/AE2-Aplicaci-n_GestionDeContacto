package vista;


import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame {

    JButton botonAdd;
    JButton botonUpdate;
    JButton botonDelete;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    ManejadorEventos manejador;

    public VentanaPrincipal() {
        setTitle("Contactos");
        setBounds(100, 100, 790, 707);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new java.awt.Color(238, 209, 69));
        ImageIcon icono = new ImageIcon("iconoSADAM.jpeg");
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
        setIconImage(iconoRedimensionado.getImage());
        inicializarVariables();
        setVisible(true);
    }

    private void inicializarVariables() {
        botonAdd = new JButton();
        botonAdd.setBounds(225, 500, 125, 125);
        ImageIcon icono = new ImageIcon("Add.jpg"); 
        Image imagen = icono.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        botonAdd.setIcon(new ImageIcon(imagen));
        add(botonAdd);

        botonUpdate = new JButton();
        botonUpdate.setBounds(590, 200, 100, 100);
        botonUpdate.setText("Editar");
        ImageIcon icono2 = new ImageIcon("Editar.png"); 
        Image imagen2 = icono2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
        botonUpdate.setIcon(new ImageIcon(imagen2));
        add(botonUpdate);

        botonDelete = new JButton();
        botonDelete.setBounds(590, 350, 100, 100);
       // botonDelete.setText("Eliminar");
        ImageIcon icono1 = new ImageIcon("eliminar.png"); 
        Image imagen1 = icono1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); 
        botonDelete.setIcon(new ImageIcon(imagen1));

        add(botonDelete);

        String[] nombreColumnas = {"Nombre", "Teléfono"};
        tableModel = new DefaultTableModel(nombreColumnas, 0);
        table = new JTable(tableModel);
        table.setBackground(new java.awt.Color(255, 255, 102));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(125, 75, 450, 400);
        add(scrollPane);

       
    }
    
    public void establecerManejador(ManejadorEventos manejador) {
        botonAdd.addActionListener(manejador);
        botonUpdate.addActionListener(manejador);
        botonDelete.addActionListener(manejador);
    }


    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

  

    public JButton getBotonAdd() {
        return botonAdd;
    }

    public JButton getBotonUpdate() {
        return botonUpdate;
    }

    public JButton getBotonDelete() {
        return botonDelete;
    }
}
