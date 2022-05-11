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

import com.google.gson.Gson;

import p2parking.client.Remote;
import p2parking.jdo.Plaza;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Ventana_subir extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;	
	private TextPrompt panelHolderUsuario;
	private JTextField txtTitulo;
	private boolean seguro;
	private JTextField txtUbi;
	private JTextField txtDescipcion;
	private JTextField txtPrecio;
	
	
	public Ventana_subir() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
//    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/client/ventanas/P2.jpg")));
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
				Ventana_alquiler_principal.main(null);
				dispose();
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
//		logo.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/p2larfo.jpg")));
		panel_arriba.add(logo);
		

		
		JPanel panel_abajo = new JPanel();
		panelPricipal.add(panel_abajo, BorderLayout.SOUTH);
		
		JButton btnSubir = new JButton("Subir");
		panel_abajo.add(btnSubir);
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean temp = Remote.getInstance().addPlaza(Remote.constructorRequest(Remote.getInstance().getToken(), new Plaza( Float.valueOf(txtPrecio.getText()), txtUbi.getText(), new ArrayList<>(),
						(new Date()).getTime(),txtTitulo.getText(),txtDescipcion.getText(),seguro)));//TODO: cambiar null por las imagenes
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
		panel_central.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panle_medio_arriba = new JPanel();
		panel_central.add(panle_medio_arriba);
		panle_medio_arriba.setLayout(new GridLayout(5, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panle_medio_arriba.add(panel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		panelHolderUsuario = new TextPrompt("Tirulo", txtTitulo);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panle_medio_arriba.add(txtTitulo);
		
		
		JPanel panel_2_1 = new JPanel();
		panle_medio_arriba.add(panel_2_1);
		
		JPanel panel_6_1 = new JPanel();
		panle_medio_arriba.add(panel_6_1);
		
		txtPrecio = new JTextField();
		panle_medio_arriba.add(txtPrecio);
		panelHolderUsuario = new TextPrompt("Precio", txtPrecio);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		txtPrecio.setColumns(10);

		JPanel panel_8_1 = new JPanel();
		panle_medio_arriba.add(panel_8_1);
		
		JPanel panel_9_1 = new JPanel();
		panle_medio_arriba.add(panel_9_1);
		

		
		txtUbi = new JTextField();
		txtUbi.setColumns(10);
		panle_medio_arriba.add(txtUbi);
		panelHolderUsuario = new TextPrompt("Ubicacion", txtUbi);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		
	
		JPanel panel_10_1 = new JPanel();
		panle_medio_arriba.add(panel_10_1);
		
		JPanel panel_11_1 = new JPanel();
		panle_medio_arriba.add(panel_11_1);
		
		JCheckBox chckbxseguro = new JCheckBox("Tienes Seguro");
		chckbxseguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seguro==true) {
					seguro=false;
				}else
					seguro=true;
			}
		});
		panle_medio_arriba.add(chckbxseguro);
		
		
		JPanel panel_13_1 = new JPanel();
		panle_medio_arriba.add(panel_13_1);
		
		JPanel panel = new JPanel();
		panle_medio_arriba.add(panel);
		
		JButton btnNewButton_1 = new JButton("Fotos de la Plaza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panle_medio_arriba.add(btnNewButton_1);
		
		
		
		
	

	
		
		
		JPanel panel_medio_abajo = new JPanel();
		panel_central.add(panel_medio_abajo);
		panel_medio_abajo.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtDescipcion = new JTextField();
		panelHolderUsuario = new TextPrompt("Descipcion", txtDescipcion);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panel_medio_abajo.add(txtDescipcion);
		txtDescipcion.setColumns(10);
		

		
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