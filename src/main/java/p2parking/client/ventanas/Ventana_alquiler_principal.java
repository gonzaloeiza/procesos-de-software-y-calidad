
package p2parking.client.ventanas;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.Remote;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Ventana_alquiler_principal extends JFrame {
	private JPanel panelPricipal;
	
	public Ventana_alquiler_principal() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 428);
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
		//perfil.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/usuario3.jpg")));
		panel_arriba.add(perfil);
		
		JLabel logo = new JLabel("");
		//logo.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/p2larfo.jpg")));
		panel_arriba.add(logo);
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		/*
		JButton btnlogout = new JButton("Log Out");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_arribaderecha.add(btnlogout);
		
		JLabel lblhora_fecha = new JLabel("Hora/Fecha");
		panel_arribaderecha.add(lblhora_fecha);
		*/
		JPanel panel_medio = new JPanel();
		panelPricipal.add(panel_medio, BorderLayout.SOUTH);
		
		JList list = new JList();
		list.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		panel_medio.add(list);
		
		JPanel panel_actualizar = new JPanel();
		list.add(panel_actualizar);
		panel_actualizar.setLayout(new GridLayout(1,3 , 0, 0));
		
		JPanel panel_izquierda = new JPanel();
		panel_actualizar.add(panel_izquierda);
		panel_izquierda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titulo_parking = new JLabel("New label");
		panel_izquierda.add(titulo_parking);
		
		JLabel descripcion_parking = new JLabel("New label");
		panel_izquierda.add(descripcion_parking);
		
		JPanel panel_centro = new JPanel();
		panel_actualizar.add(panel_centro);
		
		JButton btnFavoritos = new JButton("New button");
		panel_centro.add(btnFavoritos);
		
		JLabel Precio = new JLabel("New label");
		panel_centro.add(Precio);
		
		JLabel imagen = new JLabel("New label");
		panel_actualizar.add(imagen);
		
		
		JPanel panel_abjo = new JPanel();
		panelPricipal.add(panel_abjo, BorderLayout.SOUTH);
		
		JButton btnsubir = new JButton("Publicar Anuncio");
		btnsubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_subir.main(null);
			}
		});
		panel_abjo.add(btnsubir);
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
					Ventana_alquiler_principal frame = new Ventana_alquiler_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	

	}

}


