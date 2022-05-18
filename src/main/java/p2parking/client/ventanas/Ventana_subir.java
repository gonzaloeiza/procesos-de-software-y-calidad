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

/**
 * Ventana para subir una nueva plaza
 */
public class Ventana_subir extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelPricipal;	
	private TextPrompt panelHolderUsuario;
	private JTextField txtTitulo;
	private boolean seguro;
	private JTextField txtDescipcion;
	private JTextField txtPrecio;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String cordenada1;
	private String cordenada2;
	private String cordenadaT;
	
	/**
	 * Constructor de la parte visual de la ventana
	 */
	public Ventana_subir() {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
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
		panel_arriba.add(perfil);
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel logo = new JLabel("");
		panel_arriba.add(logo);
		

		
		JPanel panel_abajo = new JPanel();
		panelPricipal.add(panel_abajo, BorderLayout.SOUTH);
		
	
		
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
		panelHolderUsuario = new TextPrompt("Titulo", txtTitulo);
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
		panel_9_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUbi = new JLabel("Ubicacion");
		lblUbi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9_1.add(lblUbi);
		

		
	
		
	
		JPanel panel_10_1 = new JPanel();
		panle_medio_arriba.add(panel_10_1);
		panel_10_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblC1 = new JLabel("Cordenada 1");
		lblC1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10_1.add(lblC1);
		
		JPanel panel_11_1 = new JPanel();
		panle_medio_arriba.add(panel_11_1);
		panel_11_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblC2 = new JLabel("Cordenada 2");
		lblC2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11_1.add(lblC2);
		
		
		JPanel panel_13_1 = new JPanel();
		panle_medio_arriba.add(panel_13_1);
		panel_13_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panle_medio_arriba.add(panel);
		panel.setLayout(new GridLayout(1, 7, 0, 0));
		
		textField = new JTextField();
		panelHolderUsuario = new TextPrompt("X", textField);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		panelHolderUsuario = new TextPrompt("X", textField_3);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		
		JLabel lblNewLabel = new JLabel("º");
		panel.add(lblNewLabel);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panelHolderUsuario = new TextPrompt("   ", textField_4);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		
		JLabel lblNewLabel_1 = new JLabel("'");
		panel.add(lblNewLabel_1);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblN = new JLabel("N");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblN);
		
		
		
		JPanel panel_2 = new JPanel();
		panle_medio_arriba.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 7, 0, 0));
		
		textField_5 = new JTextField();
		panelHolderUsuario = new TextPrompt("X", textField_5);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		panelHolderUsuario = new TextPrompt("X", textField_7);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		
		JLabel lblNewLabel_2 = new JLabel("º");
		panel_2.add(lblNewLabel_2);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		textField_6 = new JTextField();
		panelHolderUsuario = new TextPrompt("", textField_6);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		
		JLabel lblNewLabel_3 = new JLabel("'");
		panel_2.add(lblNewLabel_3);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblW = new JLabel("W");
		lblW.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblW);
		
	
		
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
		
		JPanel panel_3 = new JPanel();
		panle_medio_arriba.add(panel_3);
		
		JPanel panel_medio_abajo = new JPanel();
		panel_central.add(panel_medio_abajo);
		panel_medio_abajo.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtDescipcion = new JTextField();
		panelHolderUsuario = new TextPrompt("Descipcion", txtDescipcion);
		panelHolderUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelHolderUsuario.changeAlpha(0.75f);
		panel_medio_abajo.add(txtDescipcion);
		txtDescipcion.setColumns(10);
		
		JButton btnSubir = new JButton("Subir");
		panel_abajo.add(btnSubir);
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cordenada1=textField.getText()+"º"+textField_3.getText()+"'"+textField_4.getText()+"\"N";
				cordenada2=textField_5.getText()+"º"+textField_7.getText()+"'"+textField_6.getText()+"\"W";
				cordenadaT=cordenada1+" "+cordenada2;
				
				
				boolean temp = Remote.getInstance().addPlaza(Remote.constructorRequest(Remote.getInstance().getToken(), new Plaza( Float.valueOf(txtPrecio.getText()), cordenadaT, new ArrayList<>(),
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
		
	}
	
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
					Ventana_subir frame = new Ventana_subir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }


}