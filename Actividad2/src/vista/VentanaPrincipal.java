package vista;


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
        inicializarVariables();
        setVisible(true);
    }

    private void inicializarVariables() {
        botonAdd = new JButton();
        botonAdd.setBounds(225, 500, 50, 50);
        botonAdd.setText("Añadir");
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
