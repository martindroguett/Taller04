package Dominio;

public class Dinosaurio {
	private int id;
	private String nombre;
	private String tipo;
	private boolean extinto ;
	
	public Dinosaurio(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equals("extinto")) {
			this.extinto = true;
		} else this.extinto = false;
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
	
	public boolean estaExtinto() {
		return extinto;
	}
	
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
