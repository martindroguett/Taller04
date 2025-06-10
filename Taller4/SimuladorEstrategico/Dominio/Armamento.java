package Dominio;

public class Armamento {
	private int id;
	private String nombre;
	private String tipo;
	private boolean incompleto;
	
	public Armamento(int id, String nombre, String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		if (estado.equals("incompleto")) {
			this.incompleto = true;
		} else this.incompleto = false;
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
	
	public boolean estaIncompleto() {
		return incompleto;
	}
}
