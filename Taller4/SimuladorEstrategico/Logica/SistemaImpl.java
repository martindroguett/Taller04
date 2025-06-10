package Logica;

import Dominio.*;
import java.util.*;

public class SistemaImpl implements Sistema {
	
	private static SistemaImpl instance;
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

}
