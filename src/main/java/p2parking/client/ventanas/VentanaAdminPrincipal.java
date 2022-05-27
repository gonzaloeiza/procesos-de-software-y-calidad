package p2parking.client.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaAdminPrincipal extends JFrame {
	
	private static VentanaAdminPrincipal frame;

	/**
	 *Constructor de la ventana

	 * @param args No usado
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaAdminPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	
	public VentanaAdminPrincipal() {
		getContentPane().setLayout(null);
		
		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		lblListadoDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoDeUsuarios.setBounds(250, 74, 165, 16);
		getContentPane().add(lblListadoDeUsuarios);
		setTitle("P2Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
	}
	
	
}
