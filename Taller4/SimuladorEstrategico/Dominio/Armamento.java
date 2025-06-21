package Dominio;

public class Armamento {
	private int id;
	private String nombre;
	private String tipo;
	private boolean completo;
	
	public Armamento(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equalsIgnoreCase("completo")) {
			this.completo = true;
		} else this.completo = false;
	}


	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String tipo() {
		return tipo;
	}
	
	public boolean estaCompleto() {
		return completo;
	}
	
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
