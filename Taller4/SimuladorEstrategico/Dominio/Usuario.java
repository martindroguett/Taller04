package Dominio;

/**
 * La clase {@code Usuario} define un objeto Usuario con los atributos id, nombre, contraseña
 * y general, el cual se determina dependiendo de su estado inicial. Esta clase permite la obtención 
 * de información específica sobre sus instancias.
 * 
 * @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class Usuario {
/**
 * El identificador único del usuario, es un valor entero.
 * 
 */
	private int id;
	
/**
 * El nombre de usuario.
 *
 */
	
	private String nombre;
	
/**
 * La contraseña del usuario.
 * 
 */
	private String contraseña;
	
/**
 * Determina si el el usuario tiene como rol general o no.
 * {@code true} por si es es un general, de lo contrario {@code false}.
 * 
 */
	private boolean general;

/**
 * Constructor público de la clase {@code Usuario}.
 * 
 * @param id El identificador único del usuario, es un valor entero.
 * @param nombre El nombre del usuario, es un String.
 * @param contraseña La contraseña del usuario, es un String.
 * @param rol El rol del usuario, es un String el cual determina al
 * atributo {@code general}. Si es {@code "general"} el atributo sera {@code true}, de lo
 * contrario será {@code false}.
 */
	public Usuario(int id, String nombre, String contraseña, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		if (rol.equals("general")) {
			this.general = true;
		} else this.general = false;
	}

/**
 * Retorna el id de una instancia {@code Usuario}
 * 
 * @return El valor entero que representa al identificador único de la instancia.
 */
	public int getId() {
		return id;
	}

/**
 * Retorna el nombre del usuario una instancia {@code Usuario}
 * 
 * @return El valor String que representa al nombre de la instancia.
 */
	public String getNombre() {
		return nombre;
	}

/**
 * Retorna la contraseña de un usuario de una instancia {@code Usuario}
 * 
 * @return El valor String que representa la contraseña de la instancia.
 */
	public String getContraseña() {
		return contraseña;
	}

/**
 * Retorna el rol del usuario de una instancia {@code Armamento}
 * 
 * @return El valor booleano que representa si el usuario de la instancia es general o arqueólogo.
 * puede ser {@code true} si el rol es "general", o {@code false} si el rol es "arqueologo"
 * 
 */
	public boolean esGeneral() {
		return general;
	}
	
	
}
