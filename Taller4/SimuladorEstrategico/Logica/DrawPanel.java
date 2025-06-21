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
	    	g.setColor(new Color(0, 153, 33)); //Cabeza
	    	g.fillOval(width / 2, height / 2 - 175, 100, 100);
	    	g.fillOval(width / 2, height / 2 - 150, 150, 100);
	    	
	    	int[] cuelloX = { width / 2 + 10,  width / 2,  width / 2 + 50,  width / 2 + 50}; //Cuello
	    	int[] cuelloY = { height / 2 - 125, height / 2, height / 2, height / 2 - 75};
	    	g.fillPolygon(cuelloX, cuelloY, 4);
	    	
	    	g.fillOval(width / 2 - 40, height / 2 - 75, 100, 200); //Cuerpo
	    	
	    	int[] colaX = { width / 2 + 10, width / 8,  width / 2 + 30 }; //Cola
	        int[] colaY = { height * 7 / 8 - 55, height * 7 / 8 - 25, height * 7 / 8 - 35 };
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(0, 110, 24)); //Pierna
	        g.fillRect(width / 2, height * 7 / 8 - 55, 20, 100);
	        g.fillRect(width / 2, height * 7 / 8 + 25, 70, 20);
	        
	        g.fillRect(width / 2, height / 2 + 10, 70, 20); //Brazo
	        g.fillRect(width / 2 + 10, height / 2 + 10, 70, 5);
	        g.fillRect(width / 2 + 10, height / 2 + 17, 70, 5);
	        g.fillRect(width / 2 + 10, height / 2 + 23, 70, 5);
	        
	        g.setColor(Color.BLACK); //Ojos
	        g.fillOval(width / 2 + 40, height / 2 - 130, 10, 10);
	        g.fillOval(width / 2 + 80, height / 2 - 130, 10, 10);
	        
	        g.drawLine(width / 2 + 40, height / 2 - 90, width / 2 + 120, height / 2 - 90); //Boca
	    }
	    if (dibujo.equals("Brachiosaurus")) {
	    	g.setColor(new Color(81, 105, 178)); //Cabeza
	    	g.fillOval(width / 2 + 100, height / 2 - 190, 75, 50);
	    	
	    	g.fillRect(width / 2 + 100, height / 2 - 170, 30, 200); //Cuello
	    	
	    	g.fillOval(width / 5, height / 3 + 20, 250, 150); //Cuerpo
	    	
	    	int[] colaX = { width / 5 + 10, width / 10 - 40,  width / 2 + 10 }; //Cola
	        int[] colaY = { height / 2, height * 7 / 8 - 25, height / 2 + 10};
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(59, 76, 128)); //Piernas
	        g.fillRect(width / 4, height / 2 + 50, 50, 100);
	        g.fillRect(width / 2 + 75, height / 2 + 50, 50, 100);
	        
	        g.setColor(Color.BLACK); //Ojos
	        g.fillOval(width / 2 + 120, height / 2 - 175, 10, 10);
	        g.fillOval(width / 2 + 150, height / 2 - 175, 10, 10);
	        
	        g.drawLine(width / 2 + 120, height / 2 - 150, width / 2 + 160, height / 2 - 150); //Boca	
	    }
	    if (dibujo.equals("Spinosaurus")) {
	    	g.setColor(new Color(175, 50, 25)); //Cabeza
	    	g.fillOval(width / 2 + 40, height / 2 - 125, 80, 80);
	    	g.fillOval(width / 2 + 40, height / 2 - 100, 150, 60);
	    	
	    	int[] cuelloX = { width / 2 + 50,  width / 2 + 30,  width / 2 + 80,  width / 2 + 80}; //Cuello
	    	int[] cuelloY = { height / 2 - 75, height / 2 - 25, height / 2 - 20, height / 2 - 70};
	    	g.fillPolygon(cuelloX, cuelloY, 4);
	    	
	    	g.setColor(new Color(135, 38, 19)); //Espina
	    	g.fillOval(width / 4, height / 3 - 10, 150, 100);
	    	
	    	g.setColor(new Color(175, 50, 25));
	    	g.fillOval(width / 2 - 100, height / 2 - 50, 200, 100); //Cuerpo
	    	
	    	int[] colaX = { width / 5 + 30, width / 10 - 40,  width / 2 + 10 }; //Cola
	        int[] colaY = { height / 2, height * 7 / 8 - 25, height / 2 + 10};
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(135, 38, 19)); //Pierna
	        g.fillRect(width / 4 + 20, height / 2 + 30, 30, 100);
	        g.fillRect(width / 4 + 20, height / 2 + 110, 50, 20);
	        
	        
	        g.setColor(new Color(135, 38, 19)); //Brazo
	        g.fillRect(width / 2 + 20, height / 2 + 30, 21, 60);
	        g.fillRect(width / 2 + 20, height / 2 + 85, 5, 10);
	        g.fillRect(width / 2 + 27, height / 2 + 85, 5, 10);
	        g.fillRect(width / 2 + 34, height / 2 + 85, 5, 10);
	        
	        g.setColor(Color.BLACK); //Ojos
	        g.fillOval(width / 2 + 60, height / 2 - 90, 10, 10);
	        g.fillOval(width / 2 + 95, height / 2 - 90, 10, 10);
	        
	        g.drawLine(width / 2 + 70, height / 2 - 55, width / 2 + 180, height / 2 - 55); //Boca
	    }
	    
	    if (dibujo.equals("Tanque")) {
	    	g.setColor(new Color(0, 105, 92)); // parte superior
	    	g.fillOval(width / 2 + 40, height / 2 - 125, 80, 80);
	    	g.fillOval(width / 2 + 40, height / 2 - 100, 150, 60);
	    }
	    
	    if (dibujo.equals("Granada")) {
	    	g.setColor(new Color(27, 94, 32)); // cuerpo
	    	g.fillOval(width / 2 + 40, height / 2 - 100, 150, 60);
	    }
	    if (dibujo.equals("Pistola")) {
	    	g.setColor(new Color(158, 158, 158)); // boca de la pistola
	    	g.fillRect(50, 80, 240, 60);
	    	
	    	g.setColor(new Color(117, 117, 117));
	    	g.drawLine(60, 120, 290, 120);
	    	g.drawLine(70, 110, 80,80);
	    	g.drawLine(80, 110,90,80);
	    	g.drawLine(90, 110, 100,80);
	    	g.drawLine(100, 110, 110,80);
	    	
	    	g.setColor(new Color(117, 117, 117));
	    	g.fillRect(290, 95, 10, 35);
	    	
	    	g.setColor(new Color(117, 117, 117));
	    	g.fillRect(60, 140, 60, 110);
	    	
	    	g.setColor(new Color(78, 52, 46));
	    	g.fillRect(70, 150, 40,80);
	    }
	    
    }
    
}
