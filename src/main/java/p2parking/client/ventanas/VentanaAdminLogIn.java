package p2parking.client.ventanas;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import p2parking.client.ventanas.funcionalidad.VentanaAdminLogInFuncionalidad;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaAdminLogIn extends JFrame {

	private static VentanaAdminLogIn frame;
	private JPasswordField passwordField;

	
	
	/**
	 *Constructor de la ventana
	 * @param args No usado
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
					frame = new VentanaAdminLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAdminLogIn() {
		getContentPane().setLayout(null);
		setTitle("P2Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(78, 69, 85, 16);
		getContentPane().add(lblPassword);

		JLabel lblBienvenidoAlModo = new JLabel("Bienvenido al modo Administrador");
		lblBienvenidoAlModo.setBounds(113, 13, 206, 16);
		getContentPane().add(lblBienvenidoAlModo);

		passwordField = new JPasswordField();
		passwordField.setBounds(192, 67, 127, 20);
		getContentPane().add(passwordField);

		JButton btnInicioSesion = new JButton("Iniciar sesión");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdminLogInFuncionalidad.botonInicioSesion(frame, passwordField.getText());
			}
		});
		btnInicioSesion.setBounds(203, 248, 116, 23);
		getContentPane().add(btnInicioSesion);

	}
}