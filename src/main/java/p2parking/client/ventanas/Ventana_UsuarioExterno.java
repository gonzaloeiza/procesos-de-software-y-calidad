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
import p2parking.client.ventanas.funcionalidad.Ventana_UsuarioExterno_funcionalidad;
//import p2parking.client.ventanas.funcionalidad.Ventana_UsuarioExterno_funcionalidad;
import p2parking.jdo.Plaza;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

/**
 * 
 * @author lande
 *
 */
public class Ventana_UsuarioExterno extends JFrame {
	private static final long serialVersionUID = 1L;	// - el seria de la ventana
	private JPanel panelPricipal;	// - panel pricnipal
	private int valorevaluacion;	// - valor de evaluar
	private static Ventana_UsuarioExterno frame;	// - la ventana creada
	
	/**
	 * 
	 * @param a	La plaza que esta mirando el clinete en el momento de llamar a esta ventana
	 */
	public Ventana_UsuarioExterno(Plaza a) {
		setTitle("P2Parking");	// - Establece el titulo de la ventana
    	setForeground(SystemColor.windowBorder);	// - 
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// - Operacion de cerar ventana
		setBounds(100, 100, 666, 428);	// - el tamano de la ventana
		panelPricipal = new JPanel();	// - Crea el contenedor principal
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));	// - establecee los rangos del contenedor
		setContentPane(panelPricipal);	// - anade el contenedor principal
		panelPricipal.setLayout(new BorderLayout(0, 0));	// - layput del panelprincipal
		
		JPanel panel_bajo = new JPanel();	// - crear panel abajo
		panelPricipal.add(panel_bajo, BorderLayout.SOUTH);	// - colocar panel abajo
		panel_bajo.setLayout(new GridLayout(1, 3, 0, 0));	// - layout panle abajo
		
		JPanel panel = new JPanel();	// - crear panel vacio
		panel_bajo.add(panel);	// - colocar panel
		
		JButton btnvolver = new JButton("Volver a ventana principal");	// -  crear y poner el nombre del boton
		panel_bajo.add(btnvolver);	// - colocar panel
		btnvolver.addActionListener(new ActionListener() {	// - crear la accion del boton
			/**
			 * 
			 * @param e El evento que crea
			 */
			public void actionPerformed(ActionEvent e) {
				Ventana_UsuarioExterno_funcionalidad.botonVolver(frame); // - funcion externa
			}
		});
		
		JPanel panel_1 = new JPanel();	// - crear panel vacio
		panel_bajo.add(panel_1);	// - colocar panel
		
		JPanel panel_medio = new JPanel();	// - crear panel del medio
		panelPricipal.add(panel_medio, BorderLayout.CENTER);	// - colocar panel
		panel_medio.setLayout(new GridLayout(2, 1, 0, 0));	// - establecer el layput del panl
		
		JPanel panel_3 = new JPanel();	// - crear panel 3
		panel_medio.add(panel_3);	// - colocar panel
		panel_3.setLayout(new GridLayout(3, 3, 0, 0));	// - establecer el laypurt del panel
		
		JLabel lblNewLabel_2 = new JLabel("Numero de telefono:");	// - crear y poner el nombre del label
		panel_3.add(lblNewLabel_2);	// - colocar panel
		
		JPanel panel_16 = new JPanel();	// - crear panel vacio
		panel_3.add(panel_16);	// - colocar panel
		
		JLabel lblNewLabel_3 = new JLabel();	// - crear label del numero
		panel_3.add(lblNewLabel_3);	// - colocar panel
		if(a.getPropietario().getTelefono()==null) {	// - comprobar si hay error en telefono
			lblNewLabel_3.setText("No tenemos su numero");	// - establecer texto por defecto 
		}else {
			lblNewLabel_3.setText(a.getPropietario().getTelefono());	// - establecer el numeor de telefono cuando no tengamos error
		}
		
		
		JPanel panel_18 = new JPanel();	// - crear panel vacio
		panel_3.add(panel_18);	// - colocar panel

		
		JLabel puntuacion = new JLabel("Puntuacion");	// - crar el label puntuacion 
		puntuacion.setBounds(0, 0, 214, 57);	// - estabelcer tamaño del label puntuacion
		panel_18.add(puntuacion);	// - colocar panel
		
		JPanel panel_19 = new JPanel();	// - crear panel vacio
		panel_3.add(panel_19);	// - colocar panel
		
		JPanel panel_20 = new JPanel();	// - crear panel vacio
		panel_3.add(panel_20);	// - colocar panel

		
		JLabel lblNewLabel_7 = new JLabel();	// - crear label de puntuacion
		lblNewLabel_7.setBounds(0, 0, 214, 57);	// - tamaño del label
		panel_20.add(lblNewLabel_7);	// - colocar panel
		if(a.getPropietario().getPuntuacion()==-1) {	// - comprobar si hay error
			lblNewLabel_7.setText("No tenemos su puntuacion");	// - Establecer el texto por defecto
		}else {
			lblNewLabel_7.setText(String.valueOf(a.getPropietario().getPuntuacion()));	// - establecer el texto del label puntuacion con la puntuacion del cliente
		}
		
		
		JLabel lblNewLabel_4 = new JLabel("Correo de contacto:");	// - crear el label y ponerl el texto
		panel_3.add(lblNewLabel_4);	// - colocar panel
		
		
		JPanel panel_22 = new JPanel();	// - crear panel vacio
		panel_3.add(panel_22);	// - colocar panel
		
		
		JLabel lblNewLabel_5 = new JLabel();	// - crear el label
		panel_3.add(lblNewLabel_5);	// - colocar panel
		if(a.getPropietario().getCorreo()==null) {	// - comprobar si hay correo
			lblNewLabel_5.setText("No tenemos su correo");	// - ponerl el texto pre definido
		}else {
			lblNewLabel_5.setText(a.getPropietario().getCorreo());	// - poner el texto del label que sea el correo 
		}
		
		
		JPanel panel_5 = new JPanel();	// - crear panel vacio
		panel_medio.add(panel_5);	// - colocar panel
		panel_5.setLayout(new GridLayout(3, 3, 0, 0));	// - establecer el layout el panel
		
		JPanel panel_6 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_6);	// - colocar panel
		
		JPanel panel_7 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_7);	// - colocar panel
		
		JPanel panel_8 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_8);	// - colocar panel
		
		JPanel panel_9 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_9);	// - colocar panel
		
		JButton btnEvaluar = new JButton("Evaluame");	// - crear el boton evaluar
		btnEvaluar.addActionListener(new ActionListener() {
			/**
			 * Llama a la funcion para evaluar a los usuarios
			 */
			public void actionPerformed(ActionEvent e) {
				 Ventana_UsuarioExterno_funcionalidad.botonEvaluar(panelPricipal, a);	// - llama a al funcion extern
				 
			}
		});
		panel_5.add(btnEvaluar);	// - añadir el boton al panel
		
		JPanel panel_10 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_10);	// - colocar panel
		
		JPanel panel_11 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_11);	// - colocar panel
		
		JPanel panel_12 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_12);	// - colocar panel
		
		JPanel panel_13 = new JPanel();	// - crear panel vacio
		panel_5.add(panel_13);	// - colocar panel
		
		
		
		JPanel panel_arriba = new JPanel();	// - crear panel arriba
		panelPricipal.add(panel_arriba, BorderLayout.NORTH);	// - añadir el panel arriba al contenedor principal
		panel_arriba.setLayout(new GridLayout(1, 2, 0, 0));	// - establecer el layput del panel
		
		JLabel lblNewLabel = new JLabel("Usuario:");	// - crear y poner nombre al label nombre
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);	// - poner el texto en el medio
		panel_arriba.add(lblNewLabel);	// - colocar panel
		
		
		
		JPanel panel_2 = new JPanel();	// - crear panel vacio
		panel_arriba.add(panel_2);	// - colocar panel
		
		JLabel lblNewLabel_1 = new JLabel();	// - crear label nuevo
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);	// - poner el texto en el medio 
		panel_arriba.add(lblNewLabel_1);	// - colocar panel
		if(a.getPropietario().getNombre()==null) {	// - comprueba que tenga nombre
			lblNewLabel_1.setText("No tenemos su nombre");	// - establece el texto predeterminado 
		}else {
			lblNewLabel_1.setText(a.getPropietario().getNombre());	// - establece ele texto como el nombre dle cliente
		}

		JPanel panel_4 = new JPanel();	// - crear panel vacio
		panel_arriba.add(panel_4);	// - colocar panel
	}
	
	/**
	 * 
	 * @param args No usado
	 * @param a	La plaza que esta mirando el clinete en el momento de llamar a esta ventana
	 */
public static void main(String[] args,Plaza a) {
		
		try {			
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");	// - Establecemos el look and feel de las ventanas
		} catch (UnsupportedLookAndFeelException e) {	// - 
			// handle exception
		} catch (ClassNotFoundException e) {	// - excepcion de class not found
			// handle exception
		} catch (InstantiationException e) {	// - excepcion de inicializacion
			// handle exception
		} catch (IllegalAccessException e) {	// - excepcion de acceso ilegal
			// handle exception
		}
		
		EventQueue.invokeLater(new Runnable() {
			/**
			 * 
			 */
			public void run() {
				try {
					frame = new Ventana_UsuarioExterno(a);	// - crea el objeto ventana
					frame.setVisible(true);	// - establec el objeto ventana a visible
				} catch (Exception e) {	// - por si hay cualquier error
					e.printStackTrace();	// - printea el error
				}
			}
		});
	}

}
