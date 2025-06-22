package Logica;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * La clase <code>DrawPanel</code> se encarga de crear un panel donde se muestran
 * los dibujos.
 * Contiene los métodos necesarios para definir el tamaño del panel y el dibujo específico.
 * 
 * @author Martin Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class DrawPanel extends JPanel{
	/**
	 * El ancho del panel donde se mostrará la imagen.
	 */
    private int width;
   
    /**
	 * El largo o altura del panel donde se mostrará la imagen.
	 */
    private int height;
    
    /**
	 * Atributo que contiene el nombre del dibujo que se quiere mostrar en el panel.
	 */
	private String dibujo;

	/**
	 * Constructor público del panel donde se muestran los dibujos a realizar.
	 * 
	 * @param dibujo El nombre del objeto que se quiere dibujar.
	 * @param width El ancho del panel, es un número entero.
     * @param height El largo o altura del panel, es un número entero.
	 */
    public DrawPanel(String dibujo, int width, int height) {
    	this.dibujo = dibujo;
        this.width = width;
        this.height = height;
    }

    /**
     * Se encarga de dibujar en el panel según el nombre, puede tomar los valores de 
     * cualquier <code>Dinosaurio</code> extinto o <code>Armamento</code> incompleto.
     * 
     * @param g Realiza las operaciones gráficas del método.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
	    if (dibujo.equals("Tyrannosaurus Rex")) {
	    	g.setColor(new Color(0, 153, 33)); 
	    	g.fillOval(width / 2, height / 2 - 175, 100, 100);
	    	g.fillOval(width / 2, height / 2 - 150, 150, 100);
	    	
	    	int[] cuelloX = { width / 2 + 10,  width / 2,  width / 2 + 50,  width / 2 + 50}; 
	    	int[] cuelloY = { height / 2 - 125, height / 2, height / 2, height / 2 - 75};
	    	g.fillPolygon(cuelloX, cuelloY, 4);
	    	
	    	g.fillOval(width / 2 - 40, height / 2 - 75, 100, 200); 
	    	
	    	int[] colaX = { width / 2 + 10, width / 8,  width / 2 + 30 }; 
	        int[] colaY = { height * 7 / 8 - 55, height * 7 / 8 - 25, height * 7 / 8 - 35 };
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(0, 110, 24)); 
	        g.fillRect(width / 2, height * 7 / 8 - 55, 20, 100);
	        g.fillRect(width / 2, height * 7 / 8 + 25, 70, 20);
	        
	        g.fillRect(width / 2, height / 2 + 10, 70, 20); 
	        g.fillRect(width / 2 + 10, height / 2 + 10, 70, 5);
	        g.fillRect(width / 2 + 10, height / 2 + 17, 70, 5);
	        g.fillRect(width / 2 + 10, height / 2 + 23, 70, 5);
	        
	        g.setColor(Color.BLACK); 
	        g.fillOval(width / 2 + 40, height / 2 - 130, 10, 10);
	        g.fillOval(width / 2 + 80, height / 2 - 130, 10, 10);
	        
	        g.drawLine(width / 2 + 40, height / 2 - 90, width / 2 + 120, height / 2 - 90); 
	    }
	    if (dibujo.equals("Brachiosaurus")) {
	    	g.setColor(new Color(81, 105, 178)); 
	    	g.fillOval(width / 2 + 100, height / 2 - 190, 75, 50);
	    	
	    	g.fillRect(width / 2 + 100, height / 2 - 170, 30, 200); 
	    	
	    	g.fillOval(width / 5, height / 3 + 20, 250, 150); 
	    	
	    	int[] colaX = { width / 5 + 10, width / 10 - 40,  width / 2 + 10 }; 
	        int[] colaY = { height / 2, height * 7 / 8 - 25, height / 2 + 10};
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(59, 76, 128)); 
	        g.fillRect(width / 4, height / 2 + 50, 50, 100);
	        g.fillRect(width / 2 + 75, height / 2 + 50, 50, 100);
	        
	        g.setColor(Color.BLACK); 
	        g.fillOval(width / 2 + 120, height / 2 - 175, 10, 10);
	        g.fillOval(width / 2 + 150, height / 2 - 175, 10, 10);
	        
	        g.drawLine(width / 2 + 120, height / 2 - 150, width / 2 + 160, height / 2 - 150); 	
	    }
	    if (dibujo.equals("Spinosaurus")) {
	    	g.setColor(new Color(175, 50, 25)); 
	    	g.fillOval(width / 2 + 40, height / 2 - 125, 80, 80);
	    	g.fillOval(width / 2 + 40, height / 2 - 100, 150, 60);
	    	
	    	int[] cuelloX = { width / 2 + 50,  width / 2 + 30,  width / 2 + 80,  width / 2 + 80}; 
	    	int[] cuelloY = { height / 2 - 75, height / 2 - 25, height / 2 - 20, height / 2 - 70};
	    	g.fillPolygon(cuelloX, cuelloY, 4);
	    	
	    	g.setColor(new Color(135, 38, 19));
	    	g.fillOval(width / 4, height / 3 - 10, 150, 100);
	    	
	    	g.setColor(new Color(175, 50, 25));
	    	g.fillOval(width / 2 - 100, height / 2 - 50, 200, 100); 
	    	
	    	int[] colaX = { width / 5 + 30, width / 10 - 40,  width / 2 + 10 }; 
	        int[] colaY = { height / 2, height * 7 / 8 - 25, height / 2 + 10};
	        g.fillPolygon(colaX, colaY, 3);
	        
	        g.setColor(new Color(135, 38, 19));
	        g.fillRect(width / 4 + 20, height / 2 + 30, 30, 100);
	        g.fillRect(width / 4 + 20, height / 2 + 110, 50, 20);
	        
	        
	        g.setColor(new Color(135, 38, 19)); 
	        g.fillRect(width / 2 + 20, height / 2 + 30, 21, 60);
	        g.fillRect(width / 2 + 20, height / 2 + 85, 5, 10);
	        g.fillRect(width / 2 + 27, height / 2 + 85, 5, 10);
	        g.fillRect(width / 2 + 34, height / 2 + 85, 5, 10);
	        
	        g.setColor(Color.BLACK);
	        g.fillOval(width / 2 + 60, height / 2 - 90, 10, 10);
	        g.fillOval(width / 2 + 95, height / 2 - 90, 10, 10);
	        
	        g.drawLine(width / 2 + 70, height / 2 - 55, width / 2 + 180, height / 2 - 55); 		
	    }
	    
	    if (dibujo.equals("Tanque")) {
	    	g.setColor(new Color(0, 105, 92)); 
	    	int centroX = width / 2;
            int centroY = height / 2;

            
            g.setColor(new Color(46, 125, 50)); 
            g.fillRoundRect(centroX - 120, centroY, 240, 60, 20, 20);

            g.setColor(new Color(56, 142, 60));
            g.fillRoundRect(centroX - 60, centroY - 50, 120, 50, 20, 20);

         
            g.setColor(new Color(0, 77, 64)); 
            int diametro = 40;
            int yRuedas = centroY + 50;
            g.fillOval(centroX - 90, yRuedas, diametro, diametro);
            g.fillOval(centroX - 40, yRuedas, diametro, diametro);
            g.fillOval(centroX + 10, yRuedas, diametro, diametro);
            g.fillOval(centroX + 60, yRuedas, diametro, diametro);
            
            g.setColor(Color.BLACK);
            g.drawRoundRect(centroX - 120, centroY, 240, 60, 20, 20);
            g.drawRoundRect(centroX - 60, centroY - 50, 120, 50, 20, 20);
           
            g.drawOval(centroX - 90, yRuedas, diametro, diametro);
            g.drawOval(centroX - 40, yRuedas, diametro, diametro);
            g.drawOval(centroX + 10, yRuedas, diametro, diametro);
            g.drawOval(centroX + 60, yRuedas, diametro, diametro);

	    	
	    }
	    
	    if (dibujo.equals("Granada")) {
	    	g.setColor(new Color(17, 122, 101)); 
	    	int centroX = width / 2;
	    	int centroY = height / 2; 
	    	int diametro = 200;
	    	
	    	int x = centroX - (diametro/2);
	    	int y = centroY -(diametro/2);
	    	
	    	g.fillOval(x,y,diametro,diametro+20);
	    	
	    	g.setColor(new Color(189, 195, 199));
	    	g.drawOval(x+40, y+5,80,80);
	    	
	    	g.setColor(new Color(144, 148, 151));
	    	g.fillRect(centroX-35, y-15, 70, 20);
	    	g.setColor(new Color(121, 125, 127));
	    	g.fillRect(centroX-60, y-65, 120, 50);
	    	
	    	g.setColor(new Color(11, 83, 69));
	    	g.drawLine(x, centroY, diametro+100, centroY);
	    	g.drawLine(x+10, centroY+50, diametro+90, centroY+50);
	    	g.drawLine(x+20, centroY-50, diametro+80, centroY-50);
	    	g.drawLine(centroX-30, y+5, centroX-30, diametro+110);
	    	g.drawLine(centroX+30, y+5, centroX+30, diametro+110);
	    	
	    }
	    if (dibujo.equals("Pistola")) {
	    	g.setColor(new Color(158, 158, 158)); 
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
