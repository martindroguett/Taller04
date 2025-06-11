package Logica;

public interface Sistema {

	void crearArmamento(int id, String nombre, String tipo, String estado);

	void crearDino(int id, String nombre, String tipo, String estado);

	void crearUsuario(int id, String nombre, String contraseña, String rol);

	void iniciar();

}
