package Dominio;

/**
 * La clase {@code Armamento} define un objeto Armamento con los atributos id, nombre, tipo
 * y completo, el cual se determina dependiendo de su estado inicial. Esta clase permite la obtención 
 * de información específica sobre sus instancias.
 * 
 * @author Martín Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */
public class Armamento {
	
	/**
	 * El identificador único del armamento, es un valor entero.
	 * 
	 */
	private int id;
	
	/**
	 * El nombre del armamento.
	 *
	 */
	
	private String nombre;
	
	/**
	 * El tipo de armamento (Por ejemplo pistola, subfusil, tanque, etc).
	 * 
	 */
	private String tipo;
	
	/**
	 * Determina si el armamento está completo o no.
	 * {@code true} por si está completo, de lo contrario {@code false}.
	 * 
	 */
	private boolean completo;
	
	/**
	 * Constructor público de la clase {@code Armamento}.
	 * 
	 * @param id El identificador único del armamento, es un valor entero.
	 * @param nombre El nombre del armamento, es un String.
	 * @param tipo El tipo de armamento, es un String.
	 * @param estado El estado del armamento, es un String el cual determina al
	 * atributo {@code completo}. Si es {@code "completo"} el atributo sera {@code true}, de lo
	 * contrario será {@code false}.
	 */
	public Armamento(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equalsIgnoreCase("completo")) {
			this.completo = true;
		} else this.completo = false;
	}

	/**
	 * Retorna el id de una instancia {@code Armamento}
	 * 
	 * @return El valor entero que representa al identificador único de la instancia.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Retorna el nombre de una instancia {@code Armamento}
	 * 
	 * @return El valor String que representa al nombre de la instancia.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el tipo de una instancia {@code Armamento}
	 * 
	 * @return El valor String que representa tipo de la instancia.
	 */
	public String tipo() {
		return tipo;
	}
	
	/**
	 * Retorna el estado de una instancia {@code Armamento}
	 * 
	 * @return El valor booleano que representa si el estado de la instancia es completo 
	 * o incompleto. Puede ser {@code true} o {@code false}
	 */
	public boolean estaCompleto() {
		return completo;
	}
	
	/**
	 * Crea un mensaje de tipo String que representa todos los nombres de los atributos de la instacia
	 * junto a sus estados.
	 * 
	 * @return El String con los datos de una instancia de {@code Armamento}
	 */
	public String toString() {
		String estado;
		if (estaCompleto()) estado = "Completo";
		else estado = "Incompleto";
		return	"id: " + id +
				"\n; nombre: " + nombre+
				"\n; tipo: " + tipo + 
				"\n; estado: " + estado;
	}
}
