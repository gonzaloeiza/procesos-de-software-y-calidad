package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.Remote;
import p2parking.client.ventanas.funcionalidad.VentanaUsuario_funcionalidad;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private int punt;
	private static VentanaUsuario frame;

	
	
	public VentanaUsuario() {
		
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
//    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelPricipal.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario_funcionalidad.botonVolver(frame);
			}
		});
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panelPricipal.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(9, 3, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		
		JLabel lblNewLabel = new JLabel("Tu Nombre:");
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		lblNewLabel_5.setText(Remote.getInstance().getUser().getNombre());
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JLabel lblNewLabel_1 = new JLabel("Tu correo:");
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_5.add(lblNewLabel_6);
		lblNewLabel_6.setText(Remote.getInstance().getUser().getCorreo());
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JPanel panel_18 = new JPanel();
		panel_5.add(panel_18);
		
		JLabel lblNewLabel_2 = new JLabel("Tu Puntuacion:");
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_5.add(lblNewLabel_7);
		try {
			punt=Remote.getInstance().getUser().getPuntuacion();
			if(punt>=0) {
				lblNewLabel_7.setText(Integer.toString(punt));
			}else {
				lblNewLabel_7.setText("No tienes puntuacion");
			}
			
		}catch(Exception e){
			lblNewLabel_7.setText("No tienes puntuacion");
		}
		
		
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		JPanel panel_20 = new JPanel();
		panel_5.add(panel_20);
		
		JPanel panel_19 = new JPanel();
		panel_5.add(panel_19);
		
		JLabel lblNewLabel_3 = new JLabel("Tu Telefono:");
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		panel_5.add(lblNewLabel_4);
		lblNewLabel_4.setText(Remote.getInstance().getUser().getTelefono());
	
		
		JPanel panel_21 = new JPanel();
		panel_5.add(panel_21);
	}
	
	
	public static void main(String[] args) {
		try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	    	

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

	

}
