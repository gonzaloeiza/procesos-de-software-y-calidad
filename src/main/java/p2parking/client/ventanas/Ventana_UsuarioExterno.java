package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.Remote;
import p2parking.jdo.Plaza;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_UsuarioExterno extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private int valorevaluacion;
	
	public Ventana_UsuarioExterno(Plaza a) {
		
		System.out.println(a.getPropietario().getCorreo());
	
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 428);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_bajo = new JPanel();
		panelPricipal.add(panel_bajo, BorderLayout.SOUTH);
		panel_bajo.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel_bajo.add(panel);
		
		JButton btnvolver = new JButton("Volver a ventana principal");
		panel_bajo.add(btnvolver);
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_alquiler_principal.main(null);
				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_bajo.add(panel_1);
		
		JPanel panel_medio = new JPanel();
		panelPricipal.add(panel_medio, BorderLayout.CENTER);
		panel_medio.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_medio.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Numero de telefono:");
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16);
		
		JLabel lblNewLabel_3 = new JLabel();
		panel_3.add(lblNewLabel_3);
		if(a.getPropietario().getTelefono()==null) {
			lblNewLabel_3.setText("No tenemos su numero");
		}else {
			lblNewLabel_3.setText(a.getPropietario().getTelefono());
		}
		
		
		JPanel panel_18 = new JPanel();
		panel_3.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel puntuacion = new JLabel("Puntuacion");
		puntuacion.setBounds(0, 0, 214, 57);
		panel_18.add(puntuacion);
		
		JPanel panel_19 = new JPanel();
		panel_3.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_3.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setBounds(0, 0, 214, 57);
		panel_20.add(lblNewLabel_7);
		if(a.getPropietario().getPuntuacion()==-1) {
			lblNewLabel_7.setText("No tenemos su puntuacion");
		}else {
			lblNewLabel_7.setText(String.valueOf(a.getPropietario().getPuntuacion()));
		}
		
		
		JLabel lblNewLabel_4 = new JLabel("Correo de contacto:");
		panel_3.add(lblNewLabel_4);
		
		
		JPanel panel_22 = new JPanel();
		panel_3.add(panel_22);
		
		
		JLabel lblNewLabel_5 = new JLabel();
		panel_3.add(lblNewLabel_5);
		if(a.getPropietario().getCorreo()==null) {
			lblNewLabel_5.setText("No tenemos su correo");
		}else {
			lblNewLabel_5.setText(a.getPropietario().getCorreo());
		}
		
		
		JPanel panel_5 = new JPanel();
		panel_medio.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		
		JButton btnEvaluar = new JButton("Evaluame");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String valorevaluacion = JOptionPane.showInputDialog(panelPricipal,"Que nota le pones a este usuario?(1-5)", "Evaluacion", 1);
				 if(Integer.parseInt(valorevaluacion)>5) {
					 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),5)); 
				 }else if(Integer.parseInt(valorevaluacion)<=0) {
					 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),1)); 
				 }else{
					 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),
							 Integer.parseInt(valorevaluacion))); 
				 }
				 
			}
		});
		panel_5.add(btnEvaluar);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		
		
		JPanel panel_arriba = new JPanel();
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);
		panel_arriba.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_arriba.add(lblNewLabel);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_arriba.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_arriba.add(lblNewLabel_1);
		if(a.getPropietario().getNombre()==null) {
			lblNewLabel_1.setText("No tenemos su nombre");
		}else {
			lblNewLabel_1.setText(a.getPropietario().getNombre());
		}
		
		
		JPanel panel_4 = new JPanel();
		panel_arriba.add(panel_4);
	}
public static void main(String[] args,Plaza a) {
		
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println(a.getPropietario());
				System.out.println(a.getPropietario().getNombre());
				try {
					Ventana_UsuarioExterno frame = new Ventana_UsuarioExterno(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
