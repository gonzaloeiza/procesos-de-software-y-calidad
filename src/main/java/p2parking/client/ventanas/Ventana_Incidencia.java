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

import com.google.gson.Gson;

import p2parking.client.Remote;
import p2parking.client.ventanas.funcionalidad.Ventana_Incidencia_funcionalidad;
import p2parking.jdo.Incidencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

/**
 * Ventanapara la publicacion de una incidencia
 */
public class Ventana_Incidencia extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;
	private JTextField txtTitulo;
	private JTextField txtMensaje;
	private TextPrompt panelHolderUsuario;
	private JPanel panel;
	private JButton btnSunir;
	private JButton btnCancel;
	private static Ventana_Incidencia frame;
	
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
					frame = new Ventana_Incidencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la parte visual de la ventana
	 */
	public Ventana_Incidencia() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 428);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		txtTitulo = new JTextField();
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelPricipal.add(txtTitulo, BorderLayout.NORTH);
		panelHolderUsuario = new TextPrompt("Titulo", txtTitulo);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		txtTitulo.setColumns(10);
		
		txtMensaje = new JTextField();
		txtMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensaje.setDropMode(DropMode.INSERT);
		panelHolderUsuario = new TextPrompt("Mensaje", txtMensaje);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panelPricipal.add(txtMensaje, BorderLayout.CENTER);
		txtMensaje.setColumns(10);
		
		panel = new JPanel();
		panelPricipal.add(panel, BorderLayout.SOUTH);
		
		btnSunir = new JButton("Crear incidencia");
		btnSunir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtTitulo.getText() == null || txtTitulo.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Error. No has escrito ning??n t??tulo");
					return;
				}
				
				if (txtMensaje.getText() == null || txtMensaje.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Error. No has escrito ninguna explicaci??n");
					return;
				}
				
				Ventana_Incidencia_funcionalidad.botonIncidencia(frame, txtTitulo.getText(), txtMensaje.getText());
			}
		});
		panel.add(btnSunir);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Incidencia_funcionalidad.botonVolver(frame);
			}
		});
		panel.add(btnCancel);
		
		
		
		
	}

}
