package p2parking.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Ventana_subir_plaza extends JFrame {
	private JPanel panelPricipal;
	private JTextField txtInicioAlquiler;
	private JTextField textFinAlquiler;
	public Ventana_subir_plaza() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 435);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton perfil = new JButton("");
		perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		perfil.setIcon(null);
		perfil.setBounds(new Rectangle(2, 2, 1, 1));
		perfil.setBackground(SystemColor.activeCaptionBorder);
		panel_arriba.add(perfil);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Ventana_subir_plaza.class.getResource("/p2parking/ventanas/p2larfo.jpg")));
		panel_arriba.add(logo);
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnlogout = new JButton("Log Out");
		panel_arribaderecha.add(btnlogout);
		
		JLabel lblhora_fecha = new JLabel("Hora/Fecha");
		panel_arribaderecha.add(lblhora_fecha);
		
		JPanel panel_abajo = new JPanel();
		panelPricipal.add(panel_abajo, BorderLayout.SOUTH);
		panel_abajo.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_abajo.add(panel_1);
		
		JButton btnSubir = new JButton("Subir");
		panel_abajo.add(btnSubir);
		
		
		JPanel panel_abajo2 = new JPanel();
		panel_abajo.add(panel_abajo2);
		panel_abajo2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_abajo2.add(panel);
		panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JButton btnSalir = new JButton("Volver");
		panel.add(btnSalir);
		
		
		
		JPanel panel_medio = new JPanel();
		panelPricipal.add(panel_medio, BorderLayout.CENTER);
		panel_medio.setLayout(new GridLayout(7, 3, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_medio.add(panel_8);
		
		JPanel panel_10 = new JPanel();
		panel_medio.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_medio.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_medio.add(panel_12);
		
		txtInicioAlquiler = new JTextField();
		panel_medio.add(txtInicioAlquiler);
		txtInicioAlquiler.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_medio.add(panel_7);
		
		JPanel panel_13 = new JPanel();
		panel_medio.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_medio.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_medio.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_medio.add(panel_16);
		
		textFinAlquiler = new JTextField();
		panel_medio.add(textFinAlquiler);
		textFinAlquiler.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_medio.add(panel_9);
		
		JPanel panel_17 = new JPanel();
		panel_medio.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_medio.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_medio.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_medio.add(panel_20);
		
		JComboBox cboPlazasUsuario = new JComboBox();
		panel_medio.add(cboPlazasUsuario);
		
		JPanel panel_21 = new JPanel();
		panel_medio.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_medio.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_medio.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_medio.add(panel_24);
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
					Ventana_subir_plaza frame = new Ventana_subir_plaza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
