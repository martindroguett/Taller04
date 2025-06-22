package Logica;

import Dominio.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;

/**
 * La clase {@code Gui} se encarga de gestionar la interfaz gráfica del
 * simulador estratégico. 
 * <p>
 * Esta interfaz permite a los usuarios iniciar sesión y navegar por los distintos
 * menús según su rol (general o arqueólogo).
 * 
 * <p>Incluye métodos para generar la ventana principal, el panel de inicio de sesión
 * y los menús correspondientes al rol del usuario.
 * 
 *  @author Martin Ignacio Droguett Robledo, Catalina Andrea Galleguillos Carvajal.
 */

public class Gui {
	/**
	 * Instancia única del sistema que gestiona la lógica del simulador estratégico.
	 */
	private static Sistema sistema = SistemaImpl.getInstance();

	/**
	 * Ventana principal de la interfaz gráfica del simulador.
	 */
	private static JFrame ventana = new JFrame("Simulador estratégico");

	/**
	 * Ancho de la ventana de la interfaz gráfica.
	 */
	private int x = 900;

	/**
	 * Alto de la ventana de la interfaz gráfica.
	 */
	private int y = 600;

	/**
     * Inicia la interfaz gráfica creando y mostrando la ventana principal
     * del simulador con el panel de inicio de sesión.
     */
	
	public void iniciar() {
			generarFrame();
			ventana.getContentPane().add(panelInicioSesion());
			ventana.setVisible(true);
			ventana.setResizable(true);
	}
	/**
	 * Crea y devuelve el panel de inicio de sesión en el cual se agregan las componentes necesarias
	 * para que el usuario ingrese su nombre de usuario y contraseña. Igualmente muestra el título del programa.
	 * 
	 * @return El panel de inicio de sesión con las componentes necesarias.
	 */
	
	private JPanel panelInicioSesion() {
		JPanel inicioSesion = new JPanel();
		inicioSesion.setLayout(null);
		inicioSesion.setBackground(new Color(174, 182, 191));
		
		JLabel titulo = new JLabel("Simulador Estratégico Post Guerra!!"); 
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		titulo.setSize(titulo.getPreferredSize());
		titulo.setLocation((x - titulo.getWidth()) / 2 , (y - titulo.getHeight()) / 8);
		

		JLabel login = new JLabel("INICIO DE SESIÓN"); 
		login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		login.setSize(200,60);
		login.setLocation((x - login.getWidth()) / 2, (y - login.getHeight()) / 6);
	
			
		JLabel username = new JLabel("Username:"); 
		username.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		username.setSize(100,50);
		username.setLocation((x - 300) / 2, ((y - username.getHeight()) / 4)-6);
		
	
		JTextField usuario = new JTextField(); 
		int largo = 300;
		int ancho = 30;
		usuario.setBounds((x - largo) / 2, (y + 2 * ancho) / 4, largo, ancho);
		usuario.setBackground(Color.WHITE);
		usuario.setBorder(new LineBorder(Color.DARK_GRAY));
				
		JLabel password = new JLabel("Password:"); 
		password.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		password.setSize(100,50);
		password.setLocation((x - 300) / 2, (y - password.getHeight()) / 3);
				
		JPasswordField contraseña = new JPasswordField(); 
		contraseña.setEchoChar('*');
		largo = 300;
		ancho = 30;

		contraseña.setBounds((x - largo) / 2, (y + 2 * ancho) / 3 - 6, largo, ancho);
		contraseña.setBackground(Color.WHITE);
		contraseña.setBorder(new LineBorder(Color.DARK_GRAY));
		
	
		JButton entrar = new JButton("Sign in"); 
		largo = 80;
		ancho = 30;
		
		entrar.setBounds( (x - largo) / 2, (y + 6 * ancho) / 3, largo, ancho);
		entrar.setBackground(Color.gray);
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
     * Crea y devuelve el panel del menú principal para un usuario cuyo rol
     * es <code>"arqueólogo"</code>. 
     * <p>
     * Este panel contiene opciones para la gestión y representación
     * de dinosaurios, además de un botón para cerrar sesión.
     * 
     * @param u el nombre del usuario que inició sesión con rol arqueólogo.
     * @return el panel de menú principal de arqueólogo.
     */
	
	private JPanel panelMenuPrincipalArqueologo(String u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ arqueólogo");
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		bienvenida.setSize(300,50);
		bienvenida.setLocation(((x - bienvenida.getWidth()) / 2)+50, (y - bienvenida.getHeight()) / 8);
		
		
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
	 * Crea y devuelve el panel donde se ven los dinosaurios extintos y no extintos.
	 * Se agregan los botones, paneles y etiquetas junto a botones para cerrar sesión, 
	 * regresar, etc.
	 * 
	 * @param u El nombre del usuario que inicio sesión con rol arqueólogo.
	 * @return El panel donde se representan los dinosaurios.
	 */
	
	private JPanel panelRepresentacionDinos(String u) {
		JPanel menu = new JPanel();
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
		retornar.setBounds((x - altoL -20), 50,  altoL, anchoL);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalArqueologo(u));
			ventana.revalidate();
			ventana.repaint();
		});
	
		JPanel listado = new JPanel(); 
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 300) / 2);
		
	
		JButton mostrarE = new JButton("Mostrar Extintos"); 
		mostrarE.setSize(300, 40);
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
		
		JButton mostrarNE = new JButton("Mostrar No Extintos"); 
		mostrarNE.setSize(300, 40);
		mostrarNE.setLocation((x - 450), (y / 8) + 20);
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
		JLabel idDino = new JLabel("ID Dinosaurio: "); 
		idDino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idDino.setSize(200,40);
		idDino.setLocation(25, 50);
		
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idDino.getSize());
		pedirId.setLocation(140, 40);
			
		JButton ver = new JButton("Ver Dinosaurio");
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
					} catch (IOException er) { 
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
		JPanel menu = new JPanel(); 
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
		retornar.setBounds((x - altoL -20), 50,  altoL, anchoL);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalArqueologo(u));
			ventana.revalidate();
			ventana.repaint();
		});
	
		JPanel listado = new JPanel(); 
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 350) / 2);
		
	
		JButton mostrar = new JButton("Mostrar Dinosaurios");
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
			
		JLabel idDino = new JLabel("ID Dinosaurio: "); 
		idDino.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idDino.setSize(200,40);
		idDino.setLocation((x / 8) + 25, (y / 4));
		
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idDino.getWidth(), idDino.getHeight());
		pedirId.setLocation((x / 8), (y / 4) + idDino.getHeight());
			
		JButton eliminar = new JButton("Eliminar Dinosaurio"); 
		eliminar.setSize(200, 50);
		eliminar.setLocation((x / 8) - (200 - pedirId.getWidth()) / 4, (y / 4) + 100);
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

	 /**
     * Crea y devuelve el panel del menú principal para un usuario cuyo rol
     * es <code>"general"</code>. 
     * <p>
     * Este panel contiene opciones para la gestión y representación
     * de armamentos y un botón para cerrar sesión.
     * 
     * @param u el nombre del usuario que inició sesión don rol de arqueólogo.
     * @return el panel de menú principal correspondiente al arqueólogo.
     */
	
	private JPanel panelMenuPrincipalGeneral(String u) {
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(new Color(63, 80, 122));
		
		JLabel bienvenida = new JLabel("Bienvenid@ general");
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		bienvenida.setSize(300,50);
		bienvenida.setLocation(((x - bienvenida.getWidth()) / 2)+50, (y - bienvenida.getHeight()) / 8);
		

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
	
	/**
	 * Crea y devuelve un panel que permite al usuario ver los prototipos 
	 * visuales de armamentos completos o incompletos, también permite generar 
	 * imagenes o dibujos de un armamento específico.
	 * 
	 * <p>Incluye botón para cerrar sesión, retornar al menú principal, 
	 * mostrar lista de armas y generar visualizaciones basadas en el ID de un armamento.
	 * 
	 * @param u el nombre del usuario que ha iniciado sesión con rol general.
	 * @return el panel para la visualización de prototipos de armamentos.
	 */

	private JPanel prototiposVisualesArmas(String u) {
		JPanel menu = new JPanel(); 
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
		retornar.setBounds((x - altoL -20), 50,  altoL, anchoL);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalGeneral(u));
			ventana.revalidate();
			ventana.repaint();
		});

		JLabel idArmamento = new JLabel("ID Armamento: "); 
		idArmamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idArmamento.setSize(200,40);
		idArmamento.setLocation(25, 50);
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idArmamento.getSize());
		pedirId.setLocation(140,40);
		
		JPanel listado = new JPanel(); 
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 350) / 2);
		
		
		JButton mostrarC = new JButton("Generar prototipos completos"); 
		mostrarC.setSize(300,30);
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
		
		JButton mostrarI = new JButton("Generar prototipos incompletos"); 
		mostrarI.setSize(300,30);
		mostrarI.setLocation((x - 450), (y / 8) + 10);
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
		
		JButton generar = new JButton("Generar"); 
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
	/**
	 * Crea y devuelve un panel que permite al usuario gestionar los armamentos
	 * almacenados en el sistema.
	 * 
	 * <p>Incluye opciones para mostrar una lista de los armamentos existentes y eliminar un armamento 
	 * específico mediante su ID. También posee un botón para cerrar sesión 
	 * o regresar al menú principal.
	 * 
	 * @param u el nombre del usuario que ha iniciado sesión con rol general.
	 * @return el panel para la gestión de armamentos.
	 */
	
	private JPanel panelGestionArmamento(String u) {
		JPanel menu = new JPanel(); 
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
		
		retornar.setBounds((x - altoL -20), 50,  altoL, anchoL);
		retornar.addActionListener(e -> {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelMenuPrincipalArqueologo(u));
			ventana.revalidate();
			ventana.repaint();
		});

		JPanel listado = new JPanel(); 
		listado.setLayout(new BoxLayout(listado, BoxLayout.Y_AXIS)); 
		listado.setBackground(Color.WHITE);
		
		listado.setSize(400, 600);
		listado.setLocation((x - 450), (y - 350) / 2);
			
		JButton mostrar = new JButton("Mostrar Armamento"); 
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
		
		
		JLabel idArmamento = new JLabel("ID Armamento: "); 
		idArmamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idArmamento.setSize(idArmamento.getPreferredSize());
		idArmamento.setLocation((x / 8) + 25, (y / 4));
		
		JTextField pedirId = new JTextField();
		pedirId.setSize(idArmamento.getWidth(), idArmamento.getHeight() + 5);
		pedirId.setLocation((x / 8) + 23, (y / 4) + idArmamento.getHeight());
		
		JButton eliminar = new JButton("Eliminar Armamento"); 
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

	/**
     * Valida los datos de acceso ingresadas por el usuario con
     * los datos almacenados en la clase App.
     * 
     * @param usuario el nombre de usuario ingresado.
     * @param password la contraseña ingresada.
     * @return el nombre de usuario validado si los datos son correctos;
     *         {@code null} en caso contrario.
     */
	
	private String validar(String usuario, String contraseña) {
		for (int i = 0; i < sistema.getUsuariosSize(); i++) {
			String u = sistema.validar(usuario, contraseña);
					if (u != null) {
						return u;   
					}
		}
		return null;
	}
	
	/**
     * Crea y configura el {@code JFrame} principal de la aplicación, estableciendo
     * su tamaño, comportamiento de cierre y otras propiedades.
     * Este método es invocado por {@link #iniciar()} para generar la ventana.
     */
	private void generarFrame() {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(x, y);
		ventana.setLocationRelativeTo(null);
		
		Color color = new Color(203, 255, 248);
	
		ventana.setBackground(color);
		
	}
}
