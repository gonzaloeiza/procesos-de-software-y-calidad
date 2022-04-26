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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class Ventana_Incidencia extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private JTextField txtTitulo;
	private JTextField txtMensaje;
	
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
					Ventana_Incidencia frame = new Ventana_Incidencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	

	}

	public Ventana_Incidencia() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/P2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 428);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		txtTitulo = new JTextField();
		panelPricipal.add(txtTitulo, BorderLayout.NORTH);
		txtTitulo.setColumns(10);
		
		txtMensaje = new JTextField();
		txtMensaje.setDropMode(DropMode.INSERT);
		panelPricipal.add(txtMensaje, BorderLayout.CENTER);
		txtMensaje.setColumns(10);
		
		JButton btnSunir = new JButton("Establecer incidencia");
		btnSunir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean temp = Remote.getInstance().crearincidencia(txtTitulo.getText(),txtMensaje.getText());

				if(temp) {
			
					dispose();
				}
				else {
					//TODO: popUp de error
				}
			
			}
		});
		panelPricipal.add(btnSunir, BorderLayout.SOUTH);
		
		
		
		
	}

}
