package Logica;

// Martin Ignacio Droguett Robledo 21.919.910-4
// Catalina Andrea Galleguillos Carvajal 21.702.133-2

import Dominio.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
	//TESTTTTTT
	private static Sistema sistema = SistemaImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			cargarUsuarios("usuarios.txt");
			cargarDinos("dinosaurios.txt");
			cargarArmamentos("armamentos.txt");
		} catch(Exception e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return;
		}
	}

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

	private static void cargarUsuarios(String file) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(file));
		while(lector.hasNextLine()) {
			String [] partes = lector.nextLine().split(",");
			
		}
		lector.close();
	}

}
