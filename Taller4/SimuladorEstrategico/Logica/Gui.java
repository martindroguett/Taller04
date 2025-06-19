package Logica;

import Dominio.*;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;

public class Gui {
	private static Sistema sistema = SistemaImpl.getInstance();
	private static JFrame ventana = new JFrame("Simulador estratégico");
	private int x = 900;
	private int y = 700;
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
		
		JLabel titulo = new JLabel("Simulador Estratégico Post Guerra!!"); //Creación del título
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		titulo.setSize(titulo.getPreferredSize());
		titulo.setLocation((x - titulo.getWidth()) / 2 , (y - titulo.getHeight()) / 8);
		
//=============================================================================================================
		
		JLabel login = new JLabel("INICIO DE SESIÓN"); //Creación palabra inicio sesión
		login.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		login.setSize(login.getPreferredSize());
		login.setLocation((x - login.getWidth()) / 2, (y - login.getHeight()) / 5);
	
//=============================================================================================================
				
		JLabel username = new JLabel("Username:"); //Creación palabra username
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
		
		JLabel password = new JLabel("Password:"); //Creación palabra password
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
			Usuario user = validar(usuario.getText(), new String(contraseña.getPassword()));
			
			if(user != null) {
				JOptionPane.showMessageDialog(null, "Acceso Correcto!", "Aceptar!", JOptionPane.INFORMATION_MESSAGE);
				ventana.getContentPane().removeAll();
				
				if (user.esGeneral()) {
					ventana.getContentPane().add(panelMenuPrincipalGeneral(user));
					ventana.revalidate();
					ventana.repaint();
				} else {
					ventana.getContentPane().add(panelMenuPrincipalArqueologo(user));
					ventana.revalidate();
					ventana.repaint();
				}
			
			} else {
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
	
		private Component panelMenuPrincipalArqueologo(Usuario u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ arqueólogo " + u.getNombre());
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		bienvenida.setSize(bienvenida.getPreferredSize());
		bienvenida.setLocation((x - bienvenida.getWidth()) / 2, (y - bienvenida.getHeight()) / 8);
		
		//=============================================================================================================
		JButton logOut = new JButton("Log Out");
		int  altoL= 100;
		int anchoL = 40;
		logOut.setBounds((x - altoL -20), 10,  altoL, anchoL);
		logOut.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelInicioSesion());
			ventana.revalidate();
			ventana.repaint();
		});
				
		
		//=============================================================================================================
		JButton gestion = new JButton("Gestionar Dinosaurios");
		int largo = 300;
		int ancho = 50;
		
		gestion.setBounds((x - largo) / 2, (y - ancho) / 5, largo, ancho);
		gestion.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelGestionDinos(u));
			ventana.revalidate();
			ventana.repaint();
		});
		
		//=======================================================================		
		JButton mostrar = new JButton("Representación Morfológica de Especies");
		
		mostrar.setBounds((x - largo) / 2, (y - (ancho)) / 5+ancho+10, largo, ancho);
		mostrar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane(); //PENDIENTE
			ventana.revalidate();
			ventana.repaint();
		});
		menuPrincipal.add(bienvenida);
		menuPrincipal.add(gestion);
		menuPrincipal.add(mostrar);
		menuPrincipal.add(logOut);
		return menuPrincipal;
	}

private JPanel panelGestionDinos(Usuario u) {
	JPanel menu = new JPanel(); //Panel menu
	menu.setLayout(null);
	menu.setBackground(new Color(120, 120, 100));
//=============================================================================================================
	JButton logOut = new JButton("Log Out");
	int  altoL= 100;
	int anchoL = 40;
	logOut.setBounds((x - altoL -20), 10,  altoL, anchoL);
	logOut.addActionListener(e -> {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelInicioSesion());
		ventana.revalidate();
		ventana.repaint();
	});
	
//============================================================================================================= //NUEVOOOO
	JButton retornar = new JButton("Return");
	int altoR= 100;
	int anchoR = 40;
	retornar.setSize(altoR, anchoR);
	retornar.setLocation((x / 8) - (200) / 4, (y / 4) + 200);
	retornar.addActionListener(e -> {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelMenuPrincipalArqueologo(u));
		ventana.revalidate();
		ventana.repaint();
	});
//=============================================================================================================
	
	JPanel listado = new JPanel(); //Panel donde se muestran los dinosaurios
	listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
	listado.setBackground(Color.WHITE);
	
	listado.setSize(400, 600);
	listado.setLocation((x - 450), (y - 350) / 2);
	
//=============================================================================================================
	
	JButton mostrar = new JButton("Mostrar Dinosaurios"); //Botón mostrar dinosaurios
	mostrar.setSize(200, 50);
	mostrar.setLocation((x - 450), (y / 8) - 25);
	listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
	
	mostrar.addActionListener(e->{
		listado.removeAll();
		for (int i = 0; i< sistema.getDinos().size();i++) {
			String dino = sistema.getDinosaurio(i) + "\n";
			JLabel dinoLabel = new JLabel(dino);
			listado.add(dinoLabel);
		}
		listado.revalidate();
		listado.repaint();
	});
	
//=============================================================================================================
	
	JLabel idDino = new JLabel("ID Dinosaurio: "); //Label Id Dinosaurio
	idDino.setFont(new Font("Times New Roman", Font.BOLD, 15));
	idDino.setSize(idDino.getPreferredSize());
	idDino.setLocation((x / 8) + 25, (y / 4));
	
//=============================================================================================================
	
	JTextField pedirId = new JTextField();
	pedirId.setSize(idDino.getWidth(), idDino.getHeight() + 5);
	pedirId.setLocation((x / 8) + 23, (y / 4) + idDino.getHeight());
	
//=============================================================================================================
	
	JButton eliminar = new JButton("Eliminar Dinosaurio"); //Botón Eliminar Dinosaurio
	eliminar.setSize(200, 50);
	eliminar.setLocation((x / 8) - (200 - pedirId.getWidth()) / 4, (y / 4) + 50);
	eliminar.addActionListener(e -> {
		if (pedirId.getText() == null) {
			JOptionPane.showMessageDialog(null, "Por favor ingrese una id!");
		} else { 
			try {
				Integer.parseInt(pedirId.getText());
			} catch (NumberFormatException er) {
				JOptionPane.showMessageDialog(null, "La id que ingresaste no es un numero!");
				return;
			}
			
			if (sistema.removeDino(Integer.parseInt(pedirId.getText()))){
				listado.removeAll();
				for (int i = 0; i< sistema.getDinos().size();i++) {
					String dino = sistema.getDinosaurio(i) + "\n";
					JLabel dinoLabel = new JLabel(dino);
					listado.add(dinoLabel);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe un dinosaurio con esa id!");
			}
			listado.revalidate();
			listado.repaint();
			
		}
	});
	
	menu.add(logOut);
	menu.add(listado);
	menu.add(mostrar);
	menu.add(idDino);
	menu.add(pedirId);
	menu.add(eliminar);
	menu.add(retornar);
	
	return menu;
	}

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
		JButton logOut = new JButton("Log Out");
		int  altoL= 100;
		int anchoL = 40;
		logOut.setBounds((x - altoL -20), 10,  altoL, anchoL);
		logOut.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelInicioSesion());
			ventana.revalidate();
			ventana.repaint();
		});
				
	
//=============================================================================================================
		JButton gestion = new JButton("Gestionar Armamento");
		int largo = 300;
		int ancho = 50;

		gestion.setBounds((x - largo) / 2, (y - ancho) / 5, largo, ancho);
		gestion.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelGestionArmamento(u));
			ventana.revalidate();
			ventana.repaint();
		});
		
//=======================================================================		
		JButton mostrar = new JButton("Mostrar prototipos visuales");
		
		mostrar.setBounds((x - largo) / 2, (y - (ancho)) / 5+ancho+10, largo, ancho);
		mostrar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(prototiposVisualesArmas(u));
			ventana.revalidate();
			ventana.repaint();
		});
		menuPrincipal.add(bienvenida);
		menuPrincipal.add(gestion);
		menuPrincipal.add(mostrar);
		menuPrincipal.add(logOut);
		return menuPrincipal;
	}
	
//MÉTODO PARA MOSTRAR LOS PROTOTIPOS VISUALES DE TECNOLOGÍA BÉLICA
	private Component prototiposVisualesArmas(Usuario u) {
		JPanel menu = new JPanel(); //Panel menu
		menu.setLayout(null);
		menu.setBackground(new Color(120, 120, 100));
		
		JButton logOut = new JButton("Log Out");
		int  altoL= 100;
		int anchoL = 40;
		logOut.setBounds((x - altoL -20), 10,  altoL, anchoL);
		logOut.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelInicioSesion());
			ventana.revalidate();
			ventana.repaint();
		});
		
		JButton retornar = new JButton("Return");
		int altoR= 100;
		int anchoR = 40;
		retornar.setSize(altoR, anchoR);
		retornar.setLocation(20, 600);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalGeneral(u));
			ventana.revalidate();
			ventana.repaint();
		});
//=============================================================================================================
		JLabel idArmamento = new JLabel("ID Armamento: "); //Label Id Armamento
		idArmamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idArmamento.setSize(idArmamento.getPreferredSize());
		idArmamento.setLocation(20, 40);
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idArmamento.getWidth(), idArmamento.getHeight() + 5);
		pedirId.setLocation((x / 8) + 23, (y / 4) + idArmamento.getHeight());
		
		JButton generar = new JButton("Generar"); //Botón para generar el armamento
		generar.setSize(200, 50);
		generar.setLocation(50,40);
		JPanel imagenLayout = new JPanel(); //Panel donde se muestran los armamentos
		imagenLayout.setLayout(new BoxLayout(imagenLayout, BoxLayout.Y_AXIS)); 
		imagenLayout.setBackground(Color.WHITE);
		
		imagenLayout.setSize(400, 600);
		imagenLayout.setLocation((x - 450), (y - 350) / 2);
		
		
		
		imagenLayout.setLayout(new BoxLayout(imagenLayout, BoxLayout.Y_AXIS)); 
		
		generar.addActionListener(e->{
			imagenLayout.removeAll();
			for (int i = 0; i< sistema.getArmas().size();i++) {
				String arma = sistema.getArmamento(i) + "\n";
				JLabel armaLabel = new JLabel(arma);
				imagenLayout.add(armaLabel);
			}
			imagenLayout.revalidate();
			imagenLayout.repaint();
		});
		
		
		menu.add(logOut);
		menu.add(retornar);
		menu.add(idArmamento);
		menu.add(generar);
		menu.add(pedirId);
		menu.add(imagenLayout);
		
	return menu;
}

	// GESTION DE ARMAMENTOS
	private JPanel panelGestionArmamento(Usuario u) {
		JPanel menu = new JPanel(); //Panel menu
		menu.setLayout(null);
		menu.setBackground(new Color(120, 120, 100));
//=============================================================================================================
		JButton logOut = new JButton("Log Out");
		int  altoL= 100;
		int anchoL = 40;
		logOut.setBounds((x - altoL -20), 10,  altoL, anchoL);
		logOut.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelInicioSesion());
			ventana.revalidate();
			ventana.repaint();
		});
		
		JButton retornar = new JButton("Return");
		int altoR= 100;
		int anchoR = 40;
		retornar.setSize(altoR, anchoR);
		retornar.setLocation((x / 8) - (200) / 4, (y / 4) + 200);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalGeneral(u));
			ventana.revalidate();
			ventana.repaint();
		});
//=============================================================================================================
		
		JPanel listado = new JPanel(); //Panel donde se muestran los armamentos
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 350) / 2);
		
//=============================================================================================================
		
		JButton mostrar = new JButton("Mostrar Armamento"); //Botón mostrar armamento
		mostrar.setSize(200, 50);
		mostrar.setLocation((x - 450), (y / 8) - 25);
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		
		mostrar.addActionListener(e->{
			listado.removeAll();
			for (int i = 0; i< sistema.getArmas().size();i++) {
				String arma = sistema.getArmamento(i) + "\n";
				JLabel armaLabel = new JLabel(arma);
				listado.add(armaLabel);
			}
			listado.revalidate();
			listado.repaint();
		});
		
//=============================================================================================================
		
		JLabel idArmamento = new JLabel("ID Armamento: "); //Label Id Armamento
		idArmamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idArmamento.setSize(idArmamento.getPreferredSize());
		idArmamento.setLocation((x / 8) + 25, (y / 4));
		
//=============================================================================================================
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idArmamento.getWidth(), idArmamento.getHeight() + 5);
		pedirId.setLocation((x / 8) + 23, (y / 4) + idArmamento.getHeight());
		
//=============================================================================================================
		
		JButton eliminar = new JButton("Eliminar Armamento"); //Botón Eliminar armamento
		eliminar.setSize(200, 50);
		eliminar.setLocation((x / 8) - (200 - pedirId.getWidth()) / 4, (y / 4) + 50);
		eliminar.addActionListener(e -> {
			if (pedirId.getText() == null) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese una id!");
			} else { 
				try {
					Integer.parseInt(pedirId.getText());
				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "La id que ingresaste no es un numero!");
					return;
				}
				
				if (sistema.removeArmamento(Integer.parseInt(pedirId.getText()))){
					listado.removeAll();
					for (int i = 0; i< sistema.getArmas().size();i++) {
						String arma = sistema.getArmamento(i) + "\n";
						JLabel armaLabel = new JLabel(arma);
						listado.add(armaLabel);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe un armamento con esa id!");
				}
				listado.revalidate();
				listado.repaint();
				
			}
		});
		
		
		menu.add(logOut);
		menu.add(listado);
		menu.add(mostrar);
		menu.add(idArmamento);
		menu.add(pedirId);
		menu.add(eliminar);
		menu.add(retornar);
		
		return menu;
	}
	
	private JLabel mostrarArmas() {
		int cantArmas = sistema.getArmas().size();
		String lista = "";
		for (int i = 0; i<cantArmas; i++) {
			lista += sistema.getArmamento(i);
			lista += "\n";
		}
		JLabel listaArmas = new JLabel(lista);
		
		return listaArmas;
	}

// Método para validar el ingreso de los usuarios con los datos guardados
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
	// Método para generar la ventana general
	private void generarFrame() {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(x, y);
		ventana.setLocationRelativeTo(null);
		
		Color color = new Color(203, 255, 248);
	
		ventana.setBackground(color);
		
	}
}
