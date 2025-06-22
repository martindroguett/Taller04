package Logica;

// Martin Ignacio Droguett Robledo 21.919.910-4, ICCI
// Catalina Andrea Galleguillos Carvajal 21.702.133-2, ICCI

import Dominio.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * La clase {@code App} representa el punto de entrada principal del simulador estratégico.
 * Se encarga de inicializar el sistema, cargar los datos desde archivos de texto
 * y lanzar el simulador.
 * 
 * <p>Los datos cargados corresponden a usuarios, dinosaurios y armamentos.
 *  @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */

public class App {
/**
 * Sistema de simulación utilizado por la aplicación.
 */

private static Sistema sistema = SistemaImpl.getInstance();
/**
 * Scanner utilizado para leer la entrada estándar (por consola).
 */
	
	private static Scanner scanner = new Scanner(System.in);
	
/**
 * Método principal que inicia la ejecución del programa.
 * <p>
 * Este método carga los datos iniciales desde archivos de texto y,
 * si la carga es exitosa, inicia el simulador mediante el sistema.
 * s
 * @param args Los argumentos de línea de comandos (no utilizados en esta implementación).
 */
	
	public static void main(String[] args) {
		
		try {
			cargarUsuarios("txts/usuarios.txt");
			cargarDinos("txts/dinosaurios.txt");
			cargarArmamentos("txts/armamentos.txt");
			
		} catch(Exception e) {
			
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return;
		}
		
		sistema.iniciar();
		
	}


/**
 * Carga los datos de armamentos desde un archivo de texto y los registra en el sistema.
 * 
 * @param file el nombre o ruta del archivo que contiene los datos de los armamentos.
 * @throws FileNotFoundException si el archivo especificado no se encuentra.
 */

	private static void cargarArmamentos(String file) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(file));
		while(lector.hasNextLine()) {
			String [] partes = lector.nextLine().split(",");
			int id = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String tipo = partes[2];
			String estado = partes[3];
			
			sistema.crearArmamento(id, nombre, tipo, estado);
		}
		
		lector.close();
		
	}
	
/**
 * Carga los datos de dinosaurios desde un archivo de texto y los registra en el sistema.
 * 
 * @param file el nombre o ruta del archivo que contiene los datos de los dinosaurios.
 * @throws FileNotFoundException si el archivo especificado no se encuentra.
 */
	
	private static void cargarDinos(String file) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(file));
		while(lector.hasNextLine()) {
			String [] partes = lector.nextLine().split(",");
			int id = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String tipo = partes[2];
			String estado = partes[3];
			
			sistema.crearDino(id, nombre, tipo, estado);
		}
		lector.close();
	}

 /**
 * Carga los datos de usuarios desde un archivo de texto y los registra en el sistema.
 * 
 * @param file el nombre o ruta del archivo que contiene los datos de los usuarios.
 * @throws FileNotFoundException si el archivo especificado no se encuentra.
 */
	private static void cargarUsuarios(String file) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(file));
		while(lector.hasNextLine()) {
			String [] partes = lector.nextLine().split(",");
			int id = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String contraseña = partes[2];
			String rol = partes[3];
			
			sistema.crearUsuario(id, nombre, contraseña, rol);
			
		}
		lector.close();
	}

}
