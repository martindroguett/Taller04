package Logica;

import Dominio.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class SistemaImpl implements Sistema {
	
	private static SistemaImpl instance;
	private static Gui gui = new Gui();
	private static List<Armamento> armamentos = new ArrayList<>();
	private static List <Dinosaurio> dinosaurios = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstance() {
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
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	@Override
	public List<Dinosaurio> getDinos(){
		return dinosaurios;
	}
	
	@Override
	public List<Armamento> getArmas(){
		return armamentos;
	}

	@Override
	public void iniciar() {
		gui.iniciar();
	}


	// MÉTODO PARA ELIMINAR EL ARMEMENTO DE LA LISTA DE ARMAMENTOS
	@Override
	public boolean removeArmamento(int id) {
		Armamento eliminar = buscarAmamento(id);
		if (eliminar != null) {
			armamentos.remove(eliminar);
			return true; // SI SE ENCUENTRA RETORNA VERDADERO
		} 
		return false; 
	}

	// MÉTODO PARA BUSCAR EL ARMAMENTO SEGÚN EL ID 
	private Armamento buscarAmamento(int id) {
		for (Armamento a: armamentos) {
			if(a.getId() == id) return a;
		}
		// SI ES QUE NO LO ENCUENTRA RETORNA NULO
		return null;
	}

	@Override
	public String getArmamento(int i, Boolean incompleto) {
		if (incompleto == null) return armamentos.get(i).toString();
		if(armamentos.get(i).estaIncompleto() && incompleto) return armamentos.get(i).toString();
		if (!armamentos.get(i).estaIncompleto() && !incompleto) return  armamentos.get(i).toString();
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
	
	private Dinosaurio buscarDinosaurio(int id) {
		for (Dinosaurio d: dinosaurios) {
			if(d.getId() == id) return d;
		}
		// SI ES QUE NO LO ENCUENTRA RETORNA NULOs
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

}
