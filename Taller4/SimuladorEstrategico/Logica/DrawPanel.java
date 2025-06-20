package Logica;

import java.awt.*;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	private int width;
    private int height;
    private String dibujo;

    public DrawPanel(String dibujo, int width, int height) {
    	this.dibujo = dibujo;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
	    if (dibujo.equals("Tyrannosaurus Rex")) {

	         
	    }
    }
}
