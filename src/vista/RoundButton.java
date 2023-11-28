package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        //setPreferredSize(new Dimension(100, 30));
        
     // Añadir un borde
        //int borderThickness = 1; // Puedes ajustar este valor según tus preferencias
        //setBorder(new LineBorder(Color.BLACK, borderThickness));

        setPreferredSize(new Dimension(100, 30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color bgColor = getBackground();
        g2d.setColor(bgColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g);
        g2d.dispose();
    }
}