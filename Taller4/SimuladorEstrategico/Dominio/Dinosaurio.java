package Dominio;

public class Dinosaurio {
	private int id;
	private String nombre;
	private String tipo;
	private boolean estaExtinto ;
	
	public Dinosaurio(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equals("extinto")) {
			this.estaExtinto = true;
		} else this.estaExtinto = false;
	}

}
