package p2parking.ventanas;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Ventana_principal_alquiler extends JFrame {
	private JPanel panelPricipal;
	
	public Ventana_principal_alquiler() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/p2parking/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 810);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton perfil = new JButton("");
		perfil.setBounds(new Rectangle(2, 2, 1, 1));
		perfil.setBackground(SystemColor.activeCaptionBorder);
		perfil.setIcon(new ImageIcon("H:\\Universidad_Local\\4\\2º Semestre\\Procesos de Software\\MaterialProyecto\\usuario3.jpg"));
		panel_arriba.add(perfil);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("H:\\Universidad_Local\\4\\2º Semestre\\Procesos de Software\\MaterialProyecto\\p2larfo.jpg"));
		panel_arriba.add(logo);
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnlogout = new JButton("Log Out");
		panel_arribaderecha.add(btnlogout);
		
		JLabel lblhora_fecha = new JLabel("Hora/Fecha");
		panel_arribaderecha.add(lblhora_fecha);
		
		JPanel panel_medio = new JPanel();
		panelPricipal.add(panel_medio, BorderLayout.SOUTH);
		
		JList list = new JList();
		panel_medio.add(list);
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
					Ventana_principal_alquiler frame = new Ventana_principal_alquiler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	

	}

}
