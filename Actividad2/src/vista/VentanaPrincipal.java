package vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame {

    JLabel icono;
    JButton botonAdd;
    JButton botonUpdate;
    JButton botonDelete;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    ImageIcon imgAdd, imgUpdate, imgDelete;


    public VentanaPrincipal() {
        setTitle("Contactos");
        ImageIcon icon = new ImageIcon("SADAM1.jpeg");
        setBounds(100, 100, 790, 707);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        inicializarVariables();
        setVisible(true);
    
    }

    private void inicializarVariables() {
        botonAdd = new JButton();
        botonAdd.setBounds(225, 500, 50, 50);
        botonAdd.setText("Añadir");
        imgAdd = new ImageIcon("BotonAnadir.jpeg");
        Image imgAddScaled = imgAdd.getImage().getScaledInstance(botonAdd.getWidth(), botonAdd.getHeight(), Image.SCALE_SMOOTH);
        botonAdd.setIcon(new ImageIcon(imgAddScaled));
        add(botonAdd);

        botonUpdate = new JButton();
        botonUpdate.setBounds(580, 300, 150, 40);
        botonUpdate.setText("Editar");
        add(botonUpdate);

        botonDelete = new JButton();
        botonDelete.setBounds(580, 380, 150, 40);
        botonDelete.setText("Eliminar");
        add(botonDelete);

        String[] nombreColumnas = {"Nombre", "Teléfono"};
        tableModel = new DefaultTableModel(nombreColumnas, 0);
        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(125, 75, 450, 400);
        add(scrollPane);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void establecerManejador(ManejadorEventos manejador) {
        botonAdd.addActionListener(manejador);
        botonUpdate.addActionListener(manejador);
        botonDelete.addActionListener(manejador);
    }

    public JButton getBotonAdd() {
        return botonAdd;
    }

    public void setBotonAdd(JButton botonAdd) {
        this.botonAdd = botonAdd;
    }

    public JButton getBotonUpdate() {
        return botonUpdate;
    }

    public void setBotonUpdate(JButton botonUpdate) {
        this.botonUpdate = botonUpdate;
    }

    public JButton getBotonDelete() {
        return botonDelete;
    }

    public void setBotonDelete(JButton botonDelete) {
        this.botonDelete = botonDelete;
    }
}
