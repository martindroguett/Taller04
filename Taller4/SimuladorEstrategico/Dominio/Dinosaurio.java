package Dominio;

/**
 * La clase {@code Dinosaurio} define un objeto Dinosaurio con los atributos id, nombre, tipo
 * y extinto, el cual se determina dependiendo de su estado inicial. Esta clase permite la obtención 
 * de información específica sobre sus instancias.
 * 
 * @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class Dinosaurio {
/**
 * El identificador único del dinosaurio, es un valor entero.
 * 
 */
	private int id;

/**
 * El nombre del dinosaurio.
 *
 */
	
	private String nombre;
	
/**
 * El tipo de dinosaurio.
 * 
 */
	private String tipo;
	
/**
 * Determina si el dinosaurio está extinto o no.
 * {@code true} por si está extinto, de lo contrario {@code false}.
 * 
 */
	private boolean extinto;
	
/**
 * Constructor público de la clase {@code Dinosaurio}.
 * 
 * @param id El identificador único del dinosaurio, es un valor entero.
 * @param nombre El nombre del dinosaurio, es un String.
 * @param tipo El tipo de dinosaurio, es un String.
 * @param estado El estado del dinosaurio, es un String el cual determina al
 * atributo {@code extinto}. Si es {@code "extinto"} el atributo sera {@code true}, de lo
 * contrario será {@code false}.
 */
	public Dinosaurio(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equals("extinto")) {
			this.extinto = true;
		} else this.extinto = false;
	}

/**
 * Retorna el id de una instancia {@code Dinosaurio}
 * 
 * @return El valor entero que representa al identificador único de la instancia.
 */
	public int getId() {
		return id;
	}

/**
 * Retorna el nombre de una instancia {@code Dinosaurio}
 * 
 * @return El valor String que representa al nombre de la instancia.
 */
	public String getNombre() {
		return nombre;
	}

/**
 * Retorna el tipo de una instancia {@code Dinosaurio}
 * 
 * @return El valor String que representa tipo de la instancia.
 */
	public String tipo() {
		return tipo;
	}

/**
 * Retorna el estado de una instancia {@code Dinosaurio}
 * 
 * @return El valor booleano que representa si el estado de la instancia es extinto 
 * o no extinto. Puede ser {@code true} o {@code false}
 */
	public boolean estaExtinto() {
		return extinto;
	}
	
/**
 * Crea un mensaje de tipo String que representa todos los nombres de los atributos de la instacia
 * junto a sus estados.
 * 
 * @return El String con los datos de una instancia de {@code Dinosaurio}
 */
	public String toString() {
		String estado;
		if (estaExtinto()) estado = "Extinto";
		else estado = "No extinto";
		return "id: " + id +
				"\n; nombre: " + nombre +
				"\n; tipo: " + tipo + 
				"\n; estado: " + estado;
	}
}
