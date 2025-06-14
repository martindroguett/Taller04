package Logica;

// Martin Ignacio Droguett Robledo 21.919.910-4
// Catalina Andrea Galleguillos Carvajal 21.702.133-2

import Dominio.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
	private static Sistema sistema = SistemaImpl.getInstance();
	private static Scanner scanner = new Scanner(System.in);
	
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
		metodosBorradores();
		
	}
// MÉTODOS Q HAY QUE IMPLEMENTAR EN LA GUI
	private static void metodosBorradores() {
		// método para imprimir el listado de armamentos y que el usuario ingrese uno según el id
		System.out.println("----Armamentos disponibles----");
		int armamentos = sistema.getArmas().size();
		for (int i = 0; i<armamentos; i++) {
			System.out.println(sistema.getArmamento(i));
		}
		boolean encontrado = false;
		do {
			System.out.print("Ingrese armamento a eliminar: ");
			encontrado = sistema.removeArmamento(Integer.parseInt(scanner.nextLine()));
		}while (!encontrado);
		System.out.println("Armamento eliminado!");
		
		// método para imprimir los armamentos completos 
		int cantArmas = sistema.getArmas().size();
			for (int i = 0; i<cantArmas; i++) {
				if (sistema.getArmas().get(i).estaIncompleto() == true) {
					System.out.println(sistema.getArmamento(i));
				}
			}
		 
		// método para imprimir las armas incompletas
		int cantArmasIncompletas = sistema.getArmas().size();
		for (int i = 0; i<cantArmasIncompletas; i++) {
			if (!sistema.getArmas().get(i).estaIncompleto()) {
				System.out.println(sistema.getArmamento(i));
			}
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
			int id = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String contraseña = partes[2];
			String rol = partes[3];
			
			sistema.crearUsuario(id, nombre, contraseña, rol);
			
		}
		lector.close();
	}

}
