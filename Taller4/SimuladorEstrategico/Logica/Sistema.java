package Logica;

import Dominio.*;
import java.util.*;

/**
 * La interfaz define el contrato que se encarga de la gestión del sistema del simulador estratégico.
 * Las clases que implementen esta interfaz deberán implementar todos los métodos definidos aquí, los cuales 
 * se encargan de la gestión de los datos.
 * 
 * @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public interface Sistema {

	/**
	 * Crea una nueva instancia de {@code Armamento}
	 * 
	 * @param id El identificador único del armamento.
	 * @param nombre El nombre del armamento.
	 * @param tipo El tipo de armamento (pistola, tanque, subfusil, etc)
	 * @param estado Identifica si el armamento está completo o incompleto.
	 */
	void crearArmamento(int id, String nombre, String tipo, String estado);

	/**
	 * Crea una nueva instancia de {@code Dinosaurio}.
	 * 
	 * @param id El identificador único del dinosaurio.
	 * @param nombre El nombre del dinosaurio.
	 * @param tipo El tipo del dinosaurio,
	 * @param estado Identifica si el dinosaurio está extinto o no extinto.
	 */
	void crearDino(int id, String nombre, String tipo, String estado);

	/**
	 * Crea una nueva instancia de {@code Usuario}.
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

	/**
	 * Busca un <code>Dinosaurio</code> en una lista y retorna el nombre del dinosaurio.
	 * 
	 * @param id La id del dinosurio del cual se quiere obtener el nombre.
	 * @return El nombre del dinosaurio, si no encuentra ningún dinosaurio con esa id retorna nulo.
	 */
	String getDinosaurioName(int id);

	/**
	 * Busca un <code>Armamento</code> en una lista y retorna el tipo del Armamento.
	 * 
	 * @param id La id del armamento del cual se quiere obtener el tipo.
	 * @return El tipo del armamento, si no encuentra ningún armamento con esa id retorna nulo. 
	 */
	String getArmaTipo(int id);

	/**
	 * Verifica si el <code>Usuario</code> con el nombre ingresado como parámetro existe y si la contraseña 
	 * ingresada es la misma que la del atributo del usuario. Finalmente retorna el nombre de usuario.
	 * 
	 * @param usuario El nombre de usuario que se quiere validar.
	 * @param contraseña La contraseña del usuario que se quiere validar.
	 * @return El nombre de usuario, siempre y cuando se haya validado su identidad, de lo contrario se retorna nulo.
	 */
	String validar(String usuario, String contraseña);

	/**
	 * Encuentra al <code>Usuario</code> con el nombre ingresado y retorna su rol.
	 * 
	 * @param userName El nombre de usuario a analizar.
	 * @return <code>"general"</code> si el usuario tiene como <code>true</code> el atributo <code>esGeneral</code>
	 * <code>"arqueologo"</code> si el usuario tiene como <code>false</code> el atributo <code>esGeneral</code>.
	 * Si el usuario no existe retorna nulo.
	 */
	String getRol(String userName);

}
