package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.funcionalidad.VentanaAdminPlazasUsuarioFuncionalidad;
import p2parking.client.ventanas.funcionalidad.VentanaAdminPrincipalFuncionalidad;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaAdminPlazasUsuario extends JFrame {
	
	private static VentanaAdminPlazasUsuario frame;
	/**
	 *Constructor de la ventana

	 * @param args No usado
	 */
	public static void main(String correoUsuario) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaAdminPlazasUsuario(correoUsuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	
	public VentanaAdminPlazasUsuario(String correoUsuario) {
		System.out.println(correoUsuario);
		List<Plaza> listaPlazas = Remote.getInstance().adminGetPlazasUsuario(Remote.constructorRequest(correoUsuario));
		System.out.println(listaPlazas);
		
		getContentPane().setLayout(null);
		
		setTitle("P2Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setLocation(99, 81);
		panel.setSize(382, 238);

		List<String> myList = new ArrayList<>(10);
		for (int i = 0; i < listaPlazas.size(); i++) {
			myList.add(listaPlazas.get(i).getTitulo() + ": " + listaPlazas.get(i).getPrecio() + "$");
		}
		
		JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
//		 JList<String> list = new JList<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		panel.add(scrollPane);

		getContentPane().add(panel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdminPlazasUsuarioFuncionalidad.botonVolver(frame);
			}
		});
		btnVolver.setBounds(99, 382, 89, 23);
		getContentPane().add(btnVolver);
		
	}
}
