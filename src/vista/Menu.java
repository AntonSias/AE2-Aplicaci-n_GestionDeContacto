package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class Menu extends JFrame{
	
	private JLabel etiqueta,logo;
	private RoundButton menuButton;
	//private JButton menuButton;
	private Color color1 = new Color(0xFFFFF); 
	private Color color2 = new Color(0x106AB6);
	
	
	
	
	public Menu()  {
		setSize(400, 600);//IMPORTANTE
		setLocationRelativeTo(null); //setBounds(x,y,w,h)   IMPORTANTE
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("INICIO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagen1.png"));
		setLayout(null); // Para poder poner los elementos donde queramos
		inicializarComponentes();
		setVisible(true);// IMPORTANTE
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

        

        add(panelPersonalizado);  // Agrega el panel personalizado al marco*/
	}
	
	public void inicializarComponentes(){
		Image img = new ImageIcon("imagen2.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(150,150,Image.SCALE_SMOOTH)));
		logo.setBounds(115,100,150,150);
		add(logo);
		
		
		menuButton = new RoundButton("INICIO");
        menuButton.setBounds(90, 350, 200, 60);
        menuButton.setFont(new Font("Dialog", Font.BOLD, 14));
        menuButton.setForeground(Color.black);
        menuButton.setBackground(new Color(0x32C4C0));
        add(menuButton);
	};
	
	public void setControlador(Controlador controlador) {
		menuButton.addActionListener(controlador);
		
	}
	public JLabel getImagenJLabel() {
		return etiqueta;
	}
	public void setImagenJLabel(JLabel imagenJLabel) {
		this.etiqueta = imagenJLabel;
	}

	public JLabel getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public RoundButton getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(RoundButton menuButton) {
		this.menuButton = menuButton;
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	
	
	

	
	
}
