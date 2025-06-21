package Logica;

import Dominio.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;

public class Gui {
	private static Sistema sistema = SistemaImpl.getInstance();
	private static JFrame ventana = new JFrame("Simulador estratégico");
	private int x = 900;
	private int y = 700;
	private boolean acceso = false;

	/**
	 * Crea la ventana principal de la interfaz gráfica.
	 */
	public void iniciar() {
			generarFrame();
		
			ventana.getContentPane().add(panelInicioSesion());
		
			ventana.setVisible(true);
	}
	/**
	 * Crea y devuelve el panel de inicio de sesión en el cual se agregan las componentes necesarias
	 * para que el usuario ingrese su nombre de usuario y contraseña, además de mostrar el título del programa.
	 * 
	 * @return El panel de inicio de sesión con las componentes necesarias.
	 */
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
			String userName = validar(usuario.getText(), new String(contraseña.getPassword()));
			String rol = sistema.getRol(userName);
			
			if(userName != null) {
				JOptionPane.showMessageDialog(null, "Acceso Correcto!", "Aceptar!", JOptionPane.INFORMATION_MESSAGE);
				ventana.getContentPane().removeAll();
				
				if (rol.equals("general")) {
					ventana.getContentPane().add(panelMenuPrincipalGeneral(userName));
					ventana.revalidate();
					ventana.repaint();
				} else {
					ventana.getContentPane().add(panelMenuPrincipalArqueologo(userName));
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
	} 
	
	/**
	 * Crea y devuelve el panel de menú principal cuando el rol del usuario ingresado sea igual a <code>"Arqueólogo"</code>.
	 * 
	 * @param u El nombre del usuario que inicio sesión y cuyo rol es arqueólogo.
	 * @return El panel de menú principal para el rol de arqueólogo.
	 */
	private JPanel panelMenuPrincipalArqueologo(String u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ arqueólogo " + u);
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
			ventana.getContentPane().add(panelRepresentacionDinos(u));
			ventana.revalidate();
			ventana.repaint();
		});
		menuPrincipal.add(bienvenida);
		menuPrincipal.add(gestion);
		menuPrincipal.add(mostrar);
		menuPrincipal.add(logOut);
		return menuPrincipal;
	}

	/**
	 * Crea y devuelve el panel donde se representan gráficamente los dinosaurios extintos y no extintos.
	 * Se agregan los botones, paneles y etiquetas necesarios para su funcionamiento además de botones para cerrar sesión, 
	 * regresar, entre otros.
	 * 
	 * @param u El nombre del usuario que inicio sesión y cuyo rol es arqueólogo.
	 * @return El panel donde se representan gráficamente los dinosaurios.
	 */
	private JPanel panelRepresentacionDinos(String u) {
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
		retornar.setLocation((x / 8) - (325) / 4, y - 75);
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
		JButton mostrarE = new JButton("Mostrar Extintos"); //Botón mostrar dinosaurios extintos
		mostrarE.setSize(200, 50);
		mostrarE.setLocation((x - 450), (y / 8) - 25);
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		
		mostrarE.addActionListener(e->{
			listado.removeAll();
			for (int i = 0; i< sistema.getDinosSize();i++) {
				String dino = sistema.getDinosaurio(i, true);
				if (dino != null) {
					dino += "\n";
					JLabel dinoLabel = new JLabel(dino);
					listado.add(dinoLabel);
				}
			}
			listado.revalidate();
			listado.repaint();
		});
		
		JButton mostrarNE = new JButton("Mostrar No Extintos"); //Botón mostrar dinosaurios no extintos
		mostrarNE.setSize(200, 50);
		mostrarNE.setLocation((x - 450), (y / 8) + 25);
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		
		mostrarNE.addActionListener(e->{
			listado.removeAll();
			for (int i = 0; i< sistema.getDinosSize();i++) {
				String dino = sistema.getDinosaurio(i, false);
				if (dino != null) {
					dino += "\n";
					JLabel dinoLabel = new JLabel(dino);
					listado.add(dinoLabel);
				}
			}
			listado.revalidate();
			listado.repaint();
		});
		JLabel idDino = new JLabel("ID Dinosaurio: "); //Label Id Dinosaurio
		idDino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idDino.setSize(idDino.getPreferredSize());
		idDino.setLocation(25, 50);
		
	//=============================================================================================================
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idDino.getWidth(), idDino.getHeight() + 5);
		pedirId.setLocation(23, 50 + idDino.getHeight());
		
	//=============================================================================================================
		
		JButton ver = new JButton("Ver Dinosaurio"); //Botón ver Dinosaurio
		ver.setSize(150, 40);
		ver.setLocation(23, 100);
		ver.addActionListener(e -> {
			if (pedirId.getText() == null) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese una id!");
			} else { 
				try {
					Integer.parseInt(pedirId.getText());
				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "La id que ingresaste no es un numero!");
					return;
				}
				String dinoNombre = sistema.getDinosaurioName(Integer.parseInt(pedirId.getText()));
				if (dinoNombre != null) {
					try {
						ImagePanel image = new ImagePanel("images/" + dinoNombre + ".png", 400, 400);
						image.setBounds(25, 150, 400, 400);
						menu.add(image, 0);
						menu.revalidate();
						menu.repaint();
					} catch (IOException er) { //Si llega aca no existe la imagen del dino, pero si el dino
						DrawPanel dibujo = new DrawPanel(dinoNombre, 400, 400);
						dibujo.setBounds(25, 150, 400, 400);
						menu.add(dibujo, 0);
						menu.revalidate();
						menu.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe un dinosaurio con esa id!");
				}
			}
		});

		menu.add(logOut);
		menu.add(retornar);
		menu.add(listado);
		menu.add(mostrarE);
		menu.add(mostrarNE);
		menu.add(idDino);
		menu.add(pedirId);
		menu.add(ver);
		return menu;
	}

	/**
	 * Crea y devuelve el panel donde se gestionan todos los dinosaurios, es decir, donde se pueden eliminar 
	 * de la lista.
	 * 
	 * @param u El nombre del usuario que inicio sesión y cuyo rol ese arqueólogo.
	 * @return El panel de gestión de los dinosaurios.
	 */
	private JPanel panelGestionDinos(String u) {
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
			for (int i = 0; i< sistema.getDinosSize();i++) {
				String dino = sistema.getDinosaurio(i, null) + "\n";
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
					for (int i = 0; i< sistema.getDinosSize();i++) {
						String dino = sistema.getDinosaurio(i, null) + "\n";
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
	
	
	private JPanel panelMenuPrincipalGeneral(String u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ general " + u);
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
	private JPanel prototiposVisualesArmas(String u) {
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
		idArmamento.setLocation(25, 50);
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idArmamento.getWidth(), idArmamento.getHeight() + 5);
		pedirId.setLocation(23, 50 + idArmamento.getHeight());
		
// ================================================================================================================
		JPanel listado = new JPanel(); //Panel donde se muestra la lista de armamentos
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 350) / 2);
		
		JButton mostrarC = new JButton("Generar prototipos completos"); //Botón mostrar prototipos completos
		mostrarC.setSize(mostrarC.getPreferredSize());
		mostrarC.setLocation((x - 450), (y / 8) - 25);
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		
		mostrarC.addActionListener(e->{
			listado.removeAll();
			for (int i = 0; i< sistema.getArmasSize();i++) {
				String arma = sistema.getArmamento(i, true);
				if (arma != null) {
					arma += "\n";
					JLabel armaLabel = new JLabel(arma);
					listado.add(armaLabel);
				}
			}
			listado.revalidate();
			listado.repaint();
		});
		
		JButton mostrarI = new JButton("Generar prototipos incompletos"); //Botón mostrar prototipos incompletos
		mostrarI.setSize(mostrarI.getPreferredSize());
		mostrarI.setLocation((x - 450), (y / 8) + 25);
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		
		mostrarI.addActionListener(e->{
			listado.removeAll();
			for (int i = 0; i< sistema.getArmasSize();i++) {
				String arma = sistema.getArmamento(i, false);
				if (arma != null) {
					arma += "\n";
					JLabel armaLabel = new JLabel(arma);
					listado.add(armaLabel);
				}
			}
			listado.revalidate();
			listado.repaint();
		});
		
		JButton generar = new JButton("Generar"); //Botón para generar el armamento
		generar.setSize(150, 40);
		generar.setLocation(23, 100);
		generar.addActionListener(e -> {
			if (pedirId.getText() == null) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese una id!");
			} else { 
				try {
					Integer.parseInt(pedirId.getText());
				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "La id que ingresaste no es un numero!");
					return;
				}
				String armaTipo = sistema.getArmaTipo(Integer.parseInt(pedirId.getText()));
				if (armaTipo != null) {
					try {
						ImagePanel image = new ImagePanel("images/" + armaTipo + ".png", 400, 400);
						image.setBounds(25, 150, 400, 400);
						menu.add(image, 0);
						menu.revalidate();
						menu.repaint();
					} catch (IOException er) { 
						DrawPanel dibujo = new DrawPanel(armaTipo, 400, 400);
						dibujo.setBounds(25, 150, 400, 400);
						menu.add(dibujo, 0);
						menu.revalidate();
						menu.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe un armamento con esa id!");
				}
			}
		});
		
		menu.add(logOut);
		menu.add(retornar);
		menu.add(idArmamento);
		menu.add(generar);
		menu.add(pedirId);
		menu.add(listado);
		menu.add(mostrarI);
		menu.add(mostrarC);
		return menu;
}

	// GESTION DE ARMAMENTOS
	private JPanel panelGestionArmamento(String u) {
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
			for (int i = 0; i< sistema.getArmasSize();i++) {
				String arma = sistema.getArmamento(i, null) + "\n";
				System.out.println(arma);
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
					for (int i = 0; i< sistema.getArmasSize();i++) {
						String arma = sistema.getArmamento(i, null) + "\n";
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

// Método para validar el ingreso de los usuarios con los datos guardados
	private String validar(String usuario, String contraseña) {
		for (int i = 0; i < sistema.getUsuariosSize(); i++) {
			String u = sistema.validar(usuario, contraseña);
					if (u != null) {
						return u;   //revisarrrrrrrrr
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
