package Logica;

import Dominio.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

/**
 * Una implementación concreta de la interfaz {@code Sistema}.
 * 
 * <p> Esta clase se encarga del manejo de todas las operaciones y cálculos relacionados al sistema, 
 * el acceso a los datos, además de la implementación de la interfaz gráfica de usuario {@code Gui}.
 * 
 * @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class SistemaImpl implements Sistema {
	
	/**
	 * La unica instancia de {@code SistemaImpl}, sigue el patrón de diseño Singleton.
	 */
	private static SistemaImpl instance;
	
	/**
	 * Instancia de la interfaz gráfica de usuario.
	 */
	private static Gui gui = new Gui();
	
	/**
	 * Lista de armamentos registrados en el sistema.
	 * Se utiliza para obtener datos de un armamento en específico y para la validación de este.
	 */
	private static List<Armamento> armamentos = new ArrayList<>();
	
	/**
	 * Lista de dinosaurios registrados en el sistema.
	 * Se utiliza para obtener datos de un dinosaurio en específico y para la validación de este.
	 */
	private static List <Dinosaurio> dinosaurios = new ArrayList<>();
	
	/**
	 * Lista de usuario registrados en el sistema.
	 * Se utiliza para obtener datos de un usuario en específico y para la validación de este.
	 */
	private static List<Usuario> usuarios = new ArrayList<>();
	
	/**
	 * Constructor privado para evitar que se cree una nueva instancia de este desde la app.
	 * El constructor es privado porque el patrón Singleton asegura que haya una única instancia.
	 */
	private SistemaImpl() {}
	
	/**
	 * Devuelve la unica instancia de la clase {@code SistemaImpl}.
	 * Si la instancia no ha sido creada aún, se crea una nueva.
	 * 
	 * @return La única instancia de {@code SistemaImpl}.
	 */
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new SistemaImpl();
		}
		return instance;
	}

	@Override
	public void crearArmamento(int id, String nombre, String tipo, String estado) {
		armamentos.add(new Armamento(id, nombre, tipo, estado));
		
	}

	@Override
	public void crearDino(int id, String nombre, String tipo, String estado) {
		dinosaurios.add(new Dinosaurio(id, nombre, tipo, estado));
		
	}

	@Override
	public void crearUsuario(int id, String nombre, String contraseña, String rol) {
		usuarios.add(new Usuario(id, nombre, contraseña, rol));
		
	}
	
	@Override
	public int getUsuariosSize(){
		return usuarios.size();
	}
	
	@Override
	public int getDinosSize(){
		return dinosaurios.size();
	}
	
	@Override
	public int getArmasSize(){
		return armamentos.size();
	}

	@Override
	public void iniciar() {
		gui.iniciar();
	}

	@Override
	public boolean removeArmamento(int id) {
		Armamento eliminar = buscarArmamento(id);
		if (eliminar != null) {
			armamentos.remove(eliminar);
			return true; 
		} 
		return false; 
	}

	/**
	 * Método privado que busca un armamento en específico a partir de su id y lo retorna.
	 * Privado debido a que el sistema no puede retornar objetos a través de un método público.
	 * 
	 * @param id La id única de la instancia de {@code Armamento} que se está buscando.
	 * @return La instancia de {@code Armamento} a la cual pertenece la id. 
	 */
	private Armamento buscarArmamento(int id) {
		for (Armamento a: armamentos) {
			if(a.getId() == id) return a;
		}
		return null;
	}

	@Override
	public String getArmamento(int i, Boolean completo) {
		if (completo == null) return armamentos.get(i).toString();
		if(armamentos.get(i).estaCompleto() && completo) return armamentos.get(i).toString();
		if (!armamentos.get(i).estaCompleto() && !completo) return  armamentos.get(i).toString();
		else return null;
	}

	@Override
	public boolean removeDino(int id) {
		Dinosaurio eliminar = buscarDinosaurio(id);
		if (eliminar != null) {
			dinosaurios.remove(eliminar);
			return true; // SI SE ENCUENTRA RETORNA VERDADERO
		} 
		return false; 
	}
	
	/**
	 * Método privado que busca un dinosaurio en específico a partir de su id y lo retorna.
	 * Privado debido a que el sistema no puede retornar objetos a través de un método público.
	 * 
	 * @param id La id única de la instancia de {@code Dinosaurio} que se está buscando.
	 * @return La instancia de {@code Dinosaurio} a la cual pertenece la id. 
	 */
	private Dinosaurio buscarDinosaurio(int id) {
		for (Dinosaurio d: dinosaurios) {
			if(d.getId() == id) return d;
		}
		return null;
	}

	@Override
	public String getDinosaurio(int i, Boolean extinto) {
		if (extinto == null) return dinosaurios.get(i).toString();
		if(dinosaurios.get(i).estaExtinto() && extinto) return dinosaurios.get(i).toString();
		if (!dinosaurios.get(i).estaExtinto() && !extinto) return  dinosaurios.get(i).toString();
		else return null;
	}

	@Override
	public String getDinosaurioName(int id) {
		Dinosaurio dino = buscarDinosaurio(id);
		if (dino != null) {
			return dino.getNombre();
		} return null;
	}

	@Override
	public String getArmaTipo(int id) {
		Armamento arma = buscarArmamento(id);
		if (arma != null) {
			return arma.tipo();
		} return null;
		
	}

	@Override
	public String validar(String usuario, String contraseña) {
		for (Usuario u: usuarios) {
			if (u.getNombre().equals(usuario) && u.getContraseña().equals(contraseña)) return u.getNombre();
		}
		return null;
	}

	@Override
	public String getRol(String userName) {
		for (Usuario u: usuarios) {
			if (u.getNombre().equals(userName)) {
				if (u.esGeneral()) {
					return "general";
				} else {
					return "arqueologo";
				}
			}
		}
		return null;
	}	

}
