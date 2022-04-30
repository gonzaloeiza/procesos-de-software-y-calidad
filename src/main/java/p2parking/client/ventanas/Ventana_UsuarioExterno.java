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
	public static void main(String[] args) {
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
				try {
					Ventana_UsuarioExterno frame = new Ventana_UsuarioExterno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana_UsuarioExterno() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/P2.jpg")));
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
		
		JLabel lblNewLabel_3 = new JLabel("el numero");
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_18 = new JPanel();
		panel_3.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_3.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_3.add(panel_20);
		
		JLabel lblNewLabel_4 = new JLabel("Correo de contacto:");
		panel_3.add(lblNewLabel_4);
		
		
		JPanel panel_22 = new JPanel();
		panel_3.add(panel_22);
		
	
		
	

		JLabel lblNewLabel_5 = new JLabel("el correo");
		panel_3.add(lblNewLabel_5);
		
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
				 System.out.println(valorevaluacion);
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
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del usuario a evaluar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_arriba.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_arriba.add(panel_4);
	}

}
