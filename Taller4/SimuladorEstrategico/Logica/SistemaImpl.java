package Logica;

import Dominio.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class SistemaImpl implements Sistema {
	
	private static SistemaImpl instance;
	private static List<Armamento> armamentos = new ArrayList<>();
	private static List <Dinosaurio> dinosaurios = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static JFrame ventana = new JFrame("Taller 4");
	private int x = 1000;
	private int y = 800;
	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstance() {
		if (instance == null) {
			instance = new SistemaImpl();
		}
		return instance;
	}

	@Override
	public void crearArmamento(int id, String nombre, String tipo, String estado) {
		armamentos.add(new Armamento(id, nombre, tipo, estado));
		
	}

	@Override
	public void crearDino(int id, String nombre, String tipo, String estado) {
		dinosaurios.add(new Dinosaurio(id, nombre, tipo, estado));
		
	}

	@Override
	public void crearUsuario(int id, String nombre, String contraseña, String rol) {
		usuarios.add(new Usuario(id, nombre, contraseña, rol));
		
	}

	@Override
	public void iniciar() {

		generarFrame();
		
		ventana.getContentPane().add(panelInicioSesion());
		
		ventana.setVisible(true);
	}

	private JPanel panelInicioSesion() {
		JPanel inicioSesion = new JPanel();
		inicioSesion.setLayout(null);
		inicioSesion.setBackground(new Color(203, 255, 248));
		
		JLabel titulo = new JLabel("Bienvenido al Simulador Estratégico Post Guerra!!"); //Creación del título
		int largo = 700;
		int ancho = 50;
		
		titulo.setBounds((x - largo) / 2, (y - ancho) / 8, largo, ancho);
		titulo.setForeground(Color.BLACK);
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
// =============================================================================================================
		
		JLabel login = new JLabel("INICIO DE SESIÓN"); //Creación palabra inicio sesión
		largo = 250;
		ancho = 50;
		
		login.setBounds((x - largo) / 2, (y - ancho) / 6, largo, ancho);
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Times New Roman", Font.BOLD, 25));

// =============================================================================================================
				
		JLabel username = new JLabel("Username"); //Creación palabra username
		largo = 150;
		ancho = 30;
		
		username.setBounds((x/2 - largo), (y - ancho) / 4, largo, ancho);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
// =============================================================================================================
		
		JTextField usuario = new JTextField(); //Creación campo de texto usuario
		largo = 300;
		ancho = 30;
		
		usuario.setBounds((x - largo) / 2, (y + 2 * ancho) / 4, largo, ancho);
		usuario.setBackground(Color.WHITE);
		usuario.setBorder(new LineBorder(Color.GREEN));
		usuario.setForeground(Color.BLACK);
		
// =============================================================================================================
		
		JLabel password = new JLabel("Password"); //Creación palabra password
		largo = 150;
		ancho = 30;
		
		password.setBounds((x/2 - largo), (y - ancho) / 3, largo, ancho);
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
// =============================================================================================================
		
		JPasswordField contraseña = new JPasswordField(); //Creación campo de texto contraseña
		largo = 300;
		ancho = 30;
		
		contraseña.setBounds((x - largo) / 2, (y + 2 * ancho) / 3, largo, ancho);
		contraseña.setBackground(Color.WHITE);
		contraseña.setBorder(new LineBorder(Color.GREEN));
		
// =============================================================================================================
		
		JButton entrar = new JButton("Sign in");
		largo = 80;
		ancho = 30;
		
		entrar.setBounds( (x - largo) / 2, (y + 6 *  ancho) / 3, largo, ancho);
		entrar.setBackground(Color.CYAN);
		entrar.addActionListener(e -> {
			System.out.println("Tienen que pasar cosas");
			validar(usuario.getText(), contraseña.getName());
		});
		
		inicioSesion.add(titulo);
		inicioSesion.add(login);
		inicioSesion.add(username);
		inicioSesion.add(usuario);
		inicioSesion.add(password);
		inicioSesion.add(contraseña);
		inicioSesion.add(entrar);
		
		return inicioSesion;
	}

	private void validar(String text, String text2) {
		boolean esta = false;
		System.out.println(text);
		for (Usuario u: usuarios) {
			if (u.getNombre().equals(text)) {
				esta = true;
			}
		}
		
		if(esta) {
			System.out.println("Si");
		}
		else {
		System.out.println("No");
		}	
		
	}

	private void generarFrame() {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(x, y);
		ventana.setLocationRelativeTo(null);
		
		Color color = new Color(203, 255, 248);
	
		ventana.setBackground(color);
		
	}

}
