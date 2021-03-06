package p2parking.client.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import p2parking.client.Remote;
//import p2parking.client.ventanas.funcionalidad.Inicio_sesion_funcionalidad;
import p2parking.client.ventanas.funcionalidad.Inicio_sesion_funcionalidad;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;

/**
 * Ventana para inicio de sesion
 *
 */
public class Inicio_sesion extends JFrame {

	/**
	 * Atributos de la ventana
	 */
	private static Inicio_sesion frame;
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private JTextField user;
	private JPasswordField password;
	private TextPrompt panelHolderUsuario;

	/**
	 * Constructor de la ventana
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
// handle exception
		} catch (ClassNotFoundException e) {
// handle exception
		} catch (InstantiationException e) {
// handle exception
		} catch (IllegalAccessException e) {
// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Inicio_sesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Funcion para cerrar la ventana
	 *
	 * @return No usado
	 */
	public static Inicio_sesion cerarventana() {
		frame = new Inicio_sesion();
		frame.setVisible(true);
		return frame;
	}

	/**
	 * Creador de la parte visual de la ventana
	 */
	public Inicio_sesion() {
		setTitle("P2Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));

		JPanel panelabajo = new JPanel();
		panelPricipal.add(panelabajo, BorderLayout.SOUTH);
		panelabajo.setLayout(new GridLayout(2, 3, 10, 10));

		JPanel panel_inutil_1 = new JPanel();
		panelabajo.add(panel_inutil_1);

		JButton inicio_sesion = new JButton("Iniciar Sesion");
		inicio_sesion.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion_funcionalidad.botonInicioSesion(frame, user.getText(), password.getText());
			}
		});
		panelabajo.add(inicio_sesion);

		JPanel panel_inutil3 = new JPanel();
		panelabajo.add(panel_inutil3);
		panel_inutil3.setLayout(new BorderLayout(0, 0));

		JButton contacto = new JButton("Contacto");
		panel_inutil3.add(contacto);
		contacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion_funcionalidad.botonContacto();
			}
		});

		JButton registro = new JButton("Registrarse");
		panelabajo.add(registro);
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion_funcionalidad.botonRegistro(frame);
			}
		});

		JPanel panle_inutil4 = new JPanel();
		panelabajo.add(panle_inutil4);
		panle_inutil4.setLayout(new BorderLayout(0, 0));

		JButton compartir = new JButton("Compartir");
		panle_inutil4.add(compartir);

		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion_funcionalidad.botonAdministrador(frame);
			}
		});
		panelabajo.add(btnAdministrador);
		compartir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion_funcionalidad.botonCompartir();
			}
		});

		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 4, 5, 25));

		JLabel imagen = new JLabel("");
		panel_arriba.add(imagen);

		JPanel panel_central = new JPanel();
		panelPricipal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_central_arriba = new JPanel();
		panel_central.add(panel_central_arriba);
		panel_central_arriba.setLayout(new GridLayout(3, 3, 0, 0));

		JPanel panel_inutil_5 = new JPanel();
		panel_central_arriba.add(panel_inutil_5);

		JPanel panel__inutil_6 = new JPanel();
		panel_central_arriba.add(panel__inutil_6);

		JPanel panel_inutil7 = new JPanel();
		panel_central_arriba.add(panel_inutil7);

		JPanel panel_inutil_8 = new JPanel();
		panel_central_arriba.add(panel_inutil_8);

		user = new JTextField();
		panel_central_arriba.add(user);
		user.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario = new TextPrompt("Usuario", user);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		user.setColumns(10);

		JPanel panel_inutil_9 = new JPanel();
		panel_central_arriba.add(panel_inutil_9);

		JPanel panel_inutil_10 = new JPanel();
		panel_central_arriba.add(panel_inutil_10);

		JPanel panel_inutil_11 = new JPanel();
		panel_central_arriba.add(panel_inutil_11);

		JPanel panel_inutil_12 = new JPanel();
		panel_central_arriba.add(panel_inutil_12);

		JPanel panel_central_abajo = new JPanel();
		panel_central.add(panel_central_abajo);
		panel_central_abajo.setLayout(new GridLayout(3, 5, 0, 0));

		JPanel panel = new JPanel();
		panel_central_abajo.add(panel);

		JPanel panel_1 = new JPanel();
		panel_central_abajo.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_central_abajo.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_central_abajo.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_central_abajo.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_central_abajo.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_central_abajo.add(panel_6);

		password = new JPasswordField();
		panelHolderUsuario = new TextPrompt("Contrase??a", password);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		panel_central_abajo.add(password);
		JPanel panel_7 = new JPanel();
		panel_central_abajo.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_central_abajo.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_central_abajo.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_central_abajo.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_central_abajo.add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_central_abajo.add(panel_12);

		JPanel panel_13 = new JPanel();
		panel_central_abajo.add(panel_13);

	}

}