package Dominio;

public class Usuario {
	private int id;
	private String nombre;
	private String contraseña;
	private boolean general;


	public Usuario(int id, String nombre, String contraseña, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		if (rol.equals("general")) {
			this.general = true;
		} else this.general = false;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getContraseña() {
		return contraseña;
	}


	public boolean esGeneral() {
		return general;
	}
	
	
}
