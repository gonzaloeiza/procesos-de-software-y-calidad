package p2parking.client.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import p2parking.client.ventanas.funcionalidad.Ventana_Copiar_Funcionalidad;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_CopiarUbicacion extends JFrame implements ClipboardOwner {
	private static Ventana_CopiarUbicacion frame;
	private JPanel panelPricipal;
	private JTextField textField;
	
	
	public Ventana_CopiarUbicacion(String texto) {
		setTitle("P2Parking");
    	setForeground(SystemColor.windowBorder);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 428);
		panelPricipal = new JPanel();
		panelPricipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPricipal);
		panelPricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelPricipal.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 3, 0, 0));
		
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
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(texto);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JPanel panel_1 = new JPanel();
		panelPricipal.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_1.add(panel_15);
		
		JButton btnCopia = new JButton("Copiar en Portapapeles");
		btnCopia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClipboard(textField.getText());
				Ventana_Copiar_Funcionalidad.copia(frame);
			}
		});
		panel_1.add(btnCopia);
		
		JPanel panel_16 = new JPanel();
		panel_1.add(panel_16);
		
		
		
	}
	
	
	public static void main(String[] args,String ubi) {
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
					frame = new Ventana_CopiarUbicacion(ubi);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void setClipboard(String texto) {
		StringSelection txt = new StringSelection(texto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt,this);
	}


	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}



}
