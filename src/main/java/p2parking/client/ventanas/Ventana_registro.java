package p2parking.client.ventanas;

import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.Remote;
import p2parking.client.ventanas.funcionalidad.Ventana_registro_funcionalidad;
//import p2parking.client.ventanas.funcionalidad.Ventana_registro_funcionalidad;
import p2parking.jdo.Usuario;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *Ventana para registrarse
 */
public class Ventana_registro extends JFrame {
	private JPanel panelPricipal;
	private JTextField txtnombre;
	private JTextField txtcontrasena;
	private JTextField txtcorreo;
	private TextPrompt panelHolderUsuario;
	private static Ventana_registro frame;
	
	/**
	 * Constructor de la parte visual de la ventana
	 */
	public Ventana_registro() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
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
		
		JButton inicio_sesion = new JButton("Registrar");
		inicio_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_registro_funcionalidad.botonRegistro(frame, txtnombre.getText(),  txtcorreo.getText(), txtcontrasena.getText());
				
			}
		});
		panelabajo.add(inicio_sesion);
		
		JPanel panel_inutil_2 = new JPanel();
		panelabajo.add(panel_inutil_2);
		
		JPanel panel_inutil3 = new JPanel();
		panelabajo.add(panel_inutil3);
		
		JPanel panle_inutil4 = new JPanel();
		panelabajo.add(panle_inutil4);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_registro_funcionalidad.botonAtras(frame);
			}
		});
		panelabajo.add(btnAtras);
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 4, 5, 25));
		
		
		
		JPanel panel_central = new JPanel();
		panelPricipal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(8,3 , 0, 0));
		
		JPanel panel = new JPanel();
		panel_central.add(panel);
		
		txtnombre = new JTextField();
		panel_central.add(txtnombre);
		panelHolderUsuario = new TextPrompt("Usuario", txtnombre);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
    	txtnombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_central.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_central.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_central.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_central.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_central.add(panel_5);
		
		txtcorreo = new JTextField();
		panel_central.add(txtcorreo);
		panelHolderUsuario = new TextPrompt("Email", txtcorreo);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		txtcorreo.setHorizontalAlignment(SwingConstants.CENTER);
    	txtcorreo.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_central.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_central.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_central.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_central.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_central.add(panel_10);
		
		
		txtcontrasena = new JTextField();
		panel_central.add(txtcontrasena);
		panelHolderUsuario = new TextPrompt("Contrase??a", txtcontrasena);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		txtcontrasena.setHorizontalAlignment(SwingConstants.CENTER);
    	txtcontrasena.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_central.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_central.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_central.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_central.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_central.add(panel_15);	
		
		JPanel panel_16 = new JPanel();
		panel_central.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_central.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_central.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_central.add(panel_19);
	}

	/**
	 * Constructor de la ventana
	 * @param args No usado
	 */
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
					frame = new Ventana_registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
