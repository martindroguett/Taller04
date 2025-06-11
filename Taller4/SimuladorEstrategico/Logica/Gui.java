package Logica;

import Dominio.*;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;

public class Gui {
	private static Sistema sistema = SistemaImpl.getInstance();
	private static JFrame ventana = new JFrame("Taller 4");
	private int x = 1000;
	private int y = 800;
	private boolean acceso = false;

	public void iniciar() {
			generarFrame();
		
			ventana.getContentPane().add(panelInicioSesion());
		
			ventana.setVisible(true);
			
			System.out.println("salió");
	}
	
	private JPanel panelInicioSesion() {
		
		JPanel inicioSesion = new JPanel();
		inicioSesion.setLayout(null);
		inicioSesion.setBackground(new Color(203, 255, 248));
		
		JLabel titulo = new JLabel("Bienvenido al Simulador Estratégico Post Guerra!!"); //Creación del título
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		titulo.setSize(titulo.getPreferredSize());
		titulo.setLocation((x - titulo.getWidth()) / 2 , (y - titulo.getHeight()) / 8);
		
//=============================================================================================================
		
		JLabel login = new JLabel("INICIO DE SESIÓN"); //Creación palabra inicio sesión
		login.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		login.setSize(login.getPreferredSize());
		login.setLocation((x - login.getWidth()) / 2, (y - login.getHeight()) / 6);
	
//=============================================================================================================
				
		JLabel username = new JLabel("Username"); //Creación palabra username
		username.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		username.setSize(username.getPreferredSize());
		username.setLocation((x - 300) / 2, (y - username.getHeight()) / 4);
		
//=============================================================================================================
		
		JTextField usuario = new JTextField(); //Creación campo de texto usuario
		int largo = 300;
		int ancho = 30;
		
		usuario.setBounds((x - largo) / 2, (y + 2 * ancho) / 4, largo, ancho);
		usuario.setBackground(Color.WHITE);
		usuario.setBorder(new LineBorder(Color.GREEN));
		
//=============================================================================================================
		
		JLabel password = new JLabel("Password"); //Creación palabra password
		password.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		password.setSize(password.getPreferredSize());
		password.setLocation((x - 300) / 2, (y - password.getHeight()) / 3);
		
//=============================================================================================================
		
		JPasswordField contraseña = new JPasswordField(); //Creación campo de texto contraseña
		contraseña.setEchoChar('*');
		largo = 300;
		ancho = 30;

		contraseña.setBounds((x - largo) / 2, (y + 2 * ancho) / 3 - 6, largo, ancho);
		contraseña.setBackground(Color.WHITE);
		contraseña.setBorder(new LineBorder(Color.GREEN));
		
//=============================================================================================================
		
		JButton entrar = new JButton("Sign in"); //Creación botón inicio de sesión
		largo = 80;
		ancho = 30;
		
		entrar.setBounds( (x - largo) / 2, (y + 6 * ancho) / 3, largo, ancho);
		entrar.setBackground(Color.CYAN);
		entrar.addActionListener(e -> {
			System.out.println("Tienen que pasar cosas");
			Usuario user = validar(usuario.getText(), new String(contraseña.getPassword()));
			
			if(user != null) {
				JOptionPane.showMessageDialog(null, "Acceso Correcto!", "Aceptar!", JOptionPane.INFORMATION_MESSAGE);
				ventana.getContentPane().removeAll();
				ventana.getContentPane().add(panelMenuPrincipalGeneral(user));
				ventana.revalidate();
				ventana.repaint();
				}
			
			else {
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña inválidos! 🖕🖕🖕🖕🖕🖕");
			}
		});
	    
//=============================================================================================================
		
		inicioSesion.add(titulo);
		inicioSesion.add(login);
		inicioSesion.add(username);
		inicioSesion.add(usuario);
		inicioSesion.add(password);
		inicioSesion.add(contraseña);
		inicioSesion.add(entrar);
		
		return inicioSesion;
	} //Fin inicio de sesión
	
//-------------------------------------------------------------------------------------------------------------
	
	
	private JPanel panelMenuPrincipalGeneral(Usuario u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ general " + u.getNombre());
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		bienvenida.setSize(bienvenida.getPreferredSize());
		bienvenida.setLocation((x - bienvenida.getWidth()) / 2, (y - bienvenida.getHeight()) / 8);
	
//=============================================================================================================
		
		
		menuPrincipal.add(bienvenida);
		
		return menuPrincipal;
	}

	private Usuario validar(String usuario, String contraseña) {
		for (Usuario u: sistema.getUsuarios()) {
			if (u.getNombre().equals(usuario)) {
				if (u.getContraseña().equals(contraseña)) {
					return u;
				}
			}
		}
		return null;
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
