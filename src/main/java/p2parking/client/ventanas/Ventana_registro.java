package p2parking.client.ventanas;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_registro extends JFrame {
	private JPanel panelPricipal;
	private JTextField txtnombre;
	private JTextField txtcontrasena;
	private JTextField txtcorreo;
	private TextPrompt panelHoldercontrasenia;
	private TextPrompt panelHolderusuario;
	private TextPrompt panelHoldercorreo;
	
	
	public Ventana_registro() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_registro.class.getResource("/p2parking/client/ventanas/P2.jpg")));
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
		panelabajo.add(inicio_sesion);
		
		JPanel panel_inutil_2 = new JPanel();
		panelabajo.add(panel_inutil_2);
		
		JPanel panel_inutil3 = new JPanel();
		panelabajo.add(panel_inutil3);
		
		JPanel panle_inutil4 = new JPanel();
		panelabajo.add(panle_inutil4);
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 4, 5, 25));
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Ventana_registro.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		panel_arriba.add(imagen);
		
		JPanel panel_central = new JPanel();
		panelPricipal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(8,3 , 0, 0));
		
		JPanel panel = new JPanel();
		panel_central.add(panel);
		
		txtnombre = new JTextField();
		panel_central.add(txtnombre);
		txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHolderusuario = new TextPrompt("Usuario", txtnombre);
    	panelHolderusuario.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHolderusuario.changeAlpha(0.75f);
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
		txtcorreo.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHoldercorreo = new TextPrompt("Correo", txtcorreo);
    	panelHoldercorreo.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHoldercorreo.changeAlpha(0.75f);
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
		txtcontrasena.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHoldercontrasenia = new TextPrompt("Contraseña", txtcontrasena);
    	panelHoldercontrasenia.setHorizontalAlignment(SwingConstants.CENTER);
    	panelHoldercontrasenia.changeAlpha(0.75f);
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
		
		JButton btnNewButton = new JButton("Foto de Perfil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechoser=new JFileChooser();
				filechoser.showOpenDialog(panel_central);
			}
		});
		panel_central.add(btnNewButton);
	
		
		JPanel panel_16 = new JPanel();
		panel_central.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_central.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_central.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_central.add(panel_19);
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
					Ventana_registro frame = new Ventana_registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
