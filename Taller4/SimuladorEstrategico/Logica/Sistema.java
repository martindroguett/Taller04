package Logica;

import Dominio.*;
import java.util.*;

public interface Sistema {

	void crearArmamento(int id, String nombre, String tipo, String estado);

	void crearDino(int id, String nombre, String tipo, String estado);

	void crearUsuario(int id, String nombre, String contraseña, String rol);

	void iniciar();
	
<<<<<<< HEAD
	boolean removeArmamento(int id);
=======
	List<Usuario> getUsuarios();
	
	List<Dinosaurio> getDinos();
	
	List<Armamento> getArmas();
>>>>>>> branch 'master' of https://github.com/martindroguett/Taller04.git

}
