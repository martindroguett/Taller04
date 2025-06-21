package Logica;

import Dominio.*;
import java.util.*;

public interface Sistema {

	/**
	 * Crea una nueva instancia de <code>Armamento</code>.
	 * 
	 * @param id El identificador único del armamento.
	 * @param nombre El nombre del armamento.
	 * @param tipo El tipo de armamento (pistola, tanque, subfusil, etc)
	 * @param estado Identifica si el armamento está completo o incompleto.
	 */
	void crearArmamento(int id, String nombre, String tipo, String estado);

	/**
	 * Crea una nueva instancia de <code>Dinosaurio</code>.
	 * 
	 * @param id El identificador único del dinosaurio.
	 * @param nombre El nombre del dinosaurio.
	 * @param tipo El tipo del dinosaurio,
	 * @param estado Identifica si el dinosaurio está extinto o no extinto.
	 */
	void crearDino(int id, String nombre, String tipo, String estado);

	/**
	 * Crea una nueva instancia de <code>Usuario</code>.
	 * 
	 * @param id El identificador único del usuario.
	 * @param nombre El nombre del usuario.
	 * @param contraseña La contraseña del usuario.
	 * @param rol Indica si el usuario es arqueólogo o general.
	 */
	void crearUsuario(int id, String nombre, String contraseña, String rol);

	/**
	 * Inicia la interfaz gráfica de usuario (GUI).
	 */
	void iniciar();
	
	/**
	 * Encuentra y elimina, de una lista de <code>Armamento</code>, un armamento específico, a partir
	 * de su id, retornando si fue exitosa o no la acción.
	 * 
	 * @param id El identificador único del armamento a eliminar.
	 * @return Un valor booleano. <code>true</code> si el armamento fue eliminado, <code>false</code> si el armamento
	 * no existe dentro de la lista, y por lo tanto, no fue eliminado.
	 */
	boolean removeArmamento(int id);

	/**
	 * Retorna el largo de una lista de <code>Usuario</code>.
	 * 
	 * @return Un valor entero, que representa la cantidad de elementos de la lista.
	 */
	int getUsuariosSize();
	
	/**
	 * Retorna el largo de una lista de <code>Dinosaurio</code>.
	 * 
	 * @return Un valor entero, que representa la cantidad de elementos de la lista.
	 */
	int getDinosSize();

	/**
	 * Retorna el largo de una lista de <code>Armamento</code>.
	 * 
	 * @return Un valor entero, que representa la cantidad de elementos de la lista.
	 */
	int getArmasSize();
	
	/**
	 * Encuentra un <code>Armamento</code> en específico a partir de su indice en una lista y retorna sus datos, cumpliendo ciertas condiciones.
	 * Si el parámetro <code>completo</code> del armamento y el parametro <code>completo</code> del método 
	 * coindiden, se retornará el <code>toString</code> del armamento.
	 * Si el parámetro <code>completo</code> del método es nulo, retornará el <code>toString</code> del armamento sin importar su estado.
	 * Si el parámetro <code>completo</code> del armamento y el parametro <code>completo</code> del método no
	 * coindiden y son distintos de nulo, se retornará nulo.
	 * 
	 * @param i El indice del armamento en la lista del sistema.
	 * @param completo El estado del armamento que se está buscando, siendo null si puede ser cualquiera, es un Objeto <code>Boolean</code>.
	 * @return El toString del armamento correspondiente o <code>null</code> si no cumple con las condiciones.
	 */
	String getArmamento(int i, Boolean completo);
	
	boolean removeDino(int id);
	
	/**
	 * Encuentra un <code>Dinosaurio</code> en específico a partir de su indice en una lista y retorna su nombre, cumpliendo ciertas condiciones.
	 * Si el parámetro <code>extinto</code> del dinosaurio y el parametro <code>extinto</code> del método 
	 * coindiden, se retornará el <code>toString</code> del dinosaurio.
	 * Si el parámetro <code>extinto</code> del método es nulo, retornará el <code>toString</code> del dinosaurio sin importar su estado.
	 * Si el parámetro <code>extinto</code> del dinosaurio y el parametro <code>extinto</code> del método no
	 * coindiden y son distintos de nulo, se retornará nulo.
	 * 
	 * @param i El indice del dinosaurio en la lista del sistema.
	 * @param extnto El estado del dinosaurio que se está buscando, siendo null si puede ser cualquiera, es un Objeto <code>Boolean</code>.
	 * @return El toString del dinosaurio correspondiente o null si no cumple con las condiciones.
	 */
	String getDinosaurio(int id, Boolean extinto);

	String getDinosaurioName(int id);

	String getArmaTipo(int id);

	String validar(String usuario, String contraseña);

	String getRol(String userName);

}
