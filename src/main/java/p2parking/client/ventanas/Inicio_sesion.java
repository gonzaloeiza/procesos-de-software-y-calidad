package p2parking.client.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import p2parking.client.Remote;

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
 *
 * @author lander
 */
public class Inicio_sesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private JTextField user;
	private JPasswordField password;

	private TextPrompt panelHolderUsuario;
	/**
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
					Inicio_sesion frame = new Inicio_sesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Inicio_sesion cerarventana() {
		Inicio_sesion frame = new Inicio_sesion();
		frame.setVisible(true);
		return frame;
	}

	public Inicio_sesion() {
		setTitle("P2Parking");
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/client/ventanas/P2.jpg")));
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
//    			Remote.getInstance().logIn(user.getText(), password.getText());
				long temp = Remote.getInstance().logIn(Remote.constructorRequest(user.getText(), password.getText()));
				if (user.getText().equals("") || password.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");

				} else {
					if (temp == 0) {
						JOptionPane.showMessageDialog(null, "No se ha podido realizar el inicio de sesion");
					} else if (temp == 403) {
						JOptionPane.showMessageDialog(null, "Estás baneado. No puedes iniciar sesión");
					}
					else {
						Remote.getInstance().setToken(temp);
						Ventana_alquiler_principal.main(null);
						dispose();
					}
				}
			}
		});
		panelabajo.add(inicio_sesion);

		JPanel panel_inutil_2 = new JPanel();
		panelabajo.add(panel_inutil_2);

		JPanel panel_inutil3 = new JPanel();
		panelabajo.add(panel_inutil3);

		JButton registro = new JButton("Registrarse");
		panelabajo.add(registro);
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_registro.main(null);
				dispose();
			}
		});

		JPanel panle_inutil4 = new JPanel();
		panelabajo.add(panle_inutil4);

		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 4, 5, 25));

		JLabel imagen = new JLabel("");
    	//imagen.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/p2parking/client/ventanas/P2.jpg")));
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
		panelHolderUsuario = new TextPrompt("Contraseña", password);
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
