package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import p2parking.client.Remote;
import p2parking.jdo.Usuario;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;


public class VentanaAdminPrincipal extends JFrame {
	
	private static VentanaAdminPrincipal frame;
	private static List<Usuario> listaUsuarios = Remote.getInstance().adminGetAllUsers();
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
		lblListadoDeUsuarios.setBounds(243, 30, 165, 16);
		getContentPane().add(lblListadoDeUsuarios);
		
		setTitle("P2Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
		
		  JPanel panel = new JPanel(new BorderLayout());
		  panel.setLocation(99, 81);
		  panel.setSize(382, 238);
		  
	      List<String> myList = new ArrayList<>(10);
	      for (int i = 0; i < listaUsuarios.size(); i++) {
	    	  myList.add(listaUsuarios.get(i).getCorreo() + ": " + listaUsuarios.get(i).getNombre());
	      }
	      JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
//	      JList<String> list = new JList<String>();
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setViewportView(list);
	      list.setLayoutOrientation(JList.VERTICAL);
	      panel.add(scrollPane);
	      
	      getContentPane().add(panel);
		
	}
}
