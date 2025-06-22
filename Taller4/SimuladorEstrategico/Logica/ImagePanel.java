package Logica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * La clase {@code ImagePanel} se encarga de crear un panel donde se muestra
 * una imagen.
 * Contiene los métodos necesarios para definir el tamaño del panel y la imagen específica.
 * 
 * @author Martin Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class ImagePanel extends JPanel{
/**
 * Atributo que contiene la imagen a mostrar en el panel.
 */
	private BufferedImage image;
	
/**
 * El ancho del panel donde se mostrará la imagen.
 */
    private int width;
   
/**
 * El largo o altura del panel donde se mostrará la imagen.
 */
    private int height;

/**
 * Constructor publico del panel donde se muestra la imagen.
 * 
 * @param imagePath Un String que representa la dirección donde está almacenada la imagen a mostrar.
 * @param width El ancho del panel, es un número entero.
 * @param height El largo o altura del panel, es un número entero.
 * @throws IOException Si la dirección de la imagen no existe lanza una excepción del tipo {@code IOException}.
 */
    public ImagePanel(String imagePath, int width, int height) throws IOException {
        this.width = width;
        this.height = height;

        image = ImageIO.read(new File(imagePath));
    }

/**
 * Se encarga de "dibujar" en el panel la imagen, siempre y cuando exista.
 * 
 * @param g Realiza las operaciones gráficas del método.
 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, this);

        }
    }
}
