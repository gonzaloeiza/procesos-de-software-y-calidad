package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.Remote;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana_subir extends JFrame {
	private JPanel panelPricipal;	
	private JTextField textPrecio;
	private JTextField textUbicacion;
	private TextPrompt panelHolderUsuario;
	
	
	public Ventana_subir() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 481);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton perfil = new JButton("Volver");
		perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		perfil.setBounds(new Rectangle(2, 2, 1, 1));
		perfil.setBackground(SystemColor.activeCaptionBorder);
		//perfil.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/usuario3.jpg")));
		panel_arriba.add(perfil);
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/p2larfo.jpg")));
		panel_arriba.add(logo);
		

		
		JPanel panel_abajo = new JPanel();
		panelPricipal.add(panel_abajo, BorderLayout.SOUTH);
		
		JButton btnSubir = new JButton("Subir");
		panel_abajo.add(btnSubir);
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean temp = Remote.getInstance().addPlaza(Remote.getInstance().getToken(), Float.valueOf(textPrecio.getText()), textUbicacion.getText(),
						new ArrayList<>(), (new Date()).getTime());//TODO: cambiar null por las imagenes
				if(temp) {
					Ventana_alquiler_principal.main(null);
					dispose();
				}
				else {
					//TODO: popUp de error
				}
			}
		});
		
		JPanel panel_central = new JPanel();
		panelPricipal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(7, 4, 0, 0));
		
		
	
		JPanel panel = new JPanel();
		panel_central.add(panel);
		
	
		
		JPanel panel_1 = new JPanel();
		panel_central.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_central.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_central.add(panel_3);
		
		textUbicacion = new JTextField();
		panelHolderUsuario = new TextPrompt("Usuario", textUbicacion);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);

		panel_central.add(textUbicacion);
		textUbicacion.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_central.add(panel_4);
		
		
		JPanel panel_5 = new JPanel();
		panel_central.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_central.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_central.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_central.add(panel_8);
		
		textPrecio = new JTextField();
		panelHolderUsuario = new TextPrompt("Usuario", textPrecio);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);

		panel_central.add(textPrecio);
		textPrecio.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_central.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_central.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_central.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_central.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_central.add(panel_13);
		
		JButton btnNewButton = new JButton("Fotos de la Plaza");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechoser=new JFileChooser();
				filechoser.showOpenDialog(panel_central);
			}
		});
		panel_central.add(btnNewButton);
		
		JPanel panel_14 = new JPanel();
		panel_central.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_central.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_central.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_central.add(panel_17);
		
		
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
					Ventana_subir frame = new Ventana_subir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }


}