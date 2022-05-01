
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
import p2parking.jdo.Plaza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.InputMethodEvent;

public class Ventana_alquiler_principal extends JFrame {
	private JPanel panelPricipal;
	private ArrayList<Plaza> plazas;
	private ArrayList<Plaza> plazasFav;
	private int indice=0;

	
	public Ventana_alquiler_principal() {
		plazas= Remote.getInstance().getAllPlazas(Remote.getInstance().getToken());
		plazasFav=Remote.getInstance().getMisFav(Remote.getInstance().getToken());
		
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
		
		JButton perfil = new JButton("Usuario");
		perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		perfil.setBounds(new Rectangle(2, 2, 1, 1));
		perfil.setBackground(SystemColor.activeCaptionBorder);
		
		panel_arriba.add(perfil);
		
		
		
		JPanel panel_arribaderecha = new JPanel();
		panel_arriba.add(panel_arribaderecha);
		panel_arribaderecha.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Ventana_alquiler_principal.class.getResource("/p2parking/client/ventanas/p2larfo.jpg")));
		panel_arriba.add(logo);
		/*
		 * 
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
		panelPricipal.add(panel_medio, BorderLayout.CENTER);
		panel_medio.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_medio_medio = new JPanel();
		panel_medio.add(panel_medio_medio, BorderLayout.CENTER);
		panel_medio_medio.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_actualizar = new JPanel();
		panel_medio_medio.add(panel_actualizar);
		panel_actualizar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_izquierda = new JPanel();
		panel_actualizar.add(panel_izquierda, BorderLayout.CENTER);
		panel_izquierda.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel titulo_parking = new JLabel();
		panel_izquierda.add(titulo_parking);
		
		
		JLabel descripcion_parking = new JLabel();
		panel_izquierda.add(descripcion_parking);
		
		JPanel panel_derecha = new JPanel();
		panel_actualizar.add(panel_derecha, BorderLayout.EAST);
		panel_derecha.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton btnFavoritos = new JButton("Favoritos");
		btnFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean temp = Remote.getInstance().addPlazaFav(Remote.getInstance().getToken(), null);
				if(temp) {
					JOptionPane.showConfirmDialog(panelPricipal, "Plaza añadida a favoritos");
					panel_izquierda.setBackground(Color.green);
					panel_derecha.setBackground(Color.green);
					
				}
				else {
					JOptionPane.showConfirmDialog(panelPricipal, "Plaza añadida a favoritos");
				}
			}
		});
		
		panel_derecha.add(btnFavoritos);
		
		JButton btnReportar = new JButton("Reportar usuario");
		btnReportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Incidencia.main(null);
				dispose();
			}
		});
		panel_derecha.add(btnReportar);
		
		JLabel Precio = new JLabel();
		panel_derecha.add(Precio);
		
		JButton btnEvaluarUsuario = new JButton("Evaluar/Info Usuario");
		btnEvaluarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(plazas.get(indice).getPropietario().getNombre());
				System.out.println(plazas.get(indice).getPropietario());
				Ventana_UsuarioExterno.main(null,plazas.get(indice));
				dispose();
			}
		});
		panel_derecha.add(btnEvaluarUsuario);
		
		JLabel lblPuntuacion = new JLabel();
		panel_derecha.add(lblPuntuacion);
		
		JLabel lblSeguro = new JLabel();
		panel_derecha.add(lblSeguro);
		
		JLabel imagen = new JLabel("No hay imagen");
		panel_actualizar.add(imagen, BorderLayout.WEST);
		
		JPanel panel_top = new JPanel();
		panel_actualizar.add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new GridLayout(1, 6, 0, 0));
		
		JButton btnOrden = new JButton("Ordenar Plazas");
		panel_top.add(btnOrden);
		
		JPanel panel_4 = new JPanel();
		panel_top.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_top.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_top.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_top.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_top.add(panel_8);
		
		
		JPanel panel_medio_abajo = new JPanel();
		panel_medio.add(panel_medio_abajo, BorderLayout.SOUTH);
		panel_medio_abajo.setLayout(new GridLayout(1, 6, 0, 0));
		
		JButton btnPlaza_Anterior = new JButton("Anterior");
		btnPlaza_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice-=1;
				if(indice<=0) {
					indice=0;
				}
				if(plazas.get(indice).getTitulo()==null) {
					titulo_parking.setText("No hay titulo");
				}else {
					titulo_parking.setText(plazas.get(indice).getTitulo());
				}
				
				if(plazas.get(indice).getDescripcion()==null) {
					descripcion_parking.setText("No hay descripcion");
				}else {
					descripcion_parking.setText(plazas.get(indice).getDescripcion());
				}
				
				if(String.valueOf(plazas.get(indice).getPrecio())==null) {
					Precio.setText("No hay precio");
				}else {
					Precio.setText("El precio es de:" + String.valueOf(plazas.get(indice).getPrecio()));
				}
				//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
				
				if(plazas.get(indice).isSeguro()==true) {
					lblSeguro.setText("La plaza tiene seguro");
				}else {
					lblSeguro.setText("La plaza tiene seguro");
				}
				/*
				lblSeguro.setText("No hay seguro");
				for(int u=0;u<plazasFav.size();u++) {
					if(plazas.get(indice)==plazasFav.get(u)) {
						panel_izquierda.setBackground(Color.green);
						panel_derecha.setBackground(Color.green);
					}
				}
				*/
				titulo_parking.repaint();
				descripcion_parking.repaint();
				Precio.repaint();
				lblPuntuacion.repaint();
				lblSeguro.repaint();
				
				
			}
		});
		panel_medio_abajo.add(btnPlaza_Anterior);
		
		JPanel panel = new JPanel();
		panel_medio_abajo.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_medio_abajo.add(panel_1);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_medio_abajo.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_medio_abajo.add(panel_3);
		
		JButton btnPlazaSiguiente = new JButton("Siguiente");
		btnPlazaSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				indice+=1;
			
				if(indice>=plazas.size()) {
					indice=plazas.size()-1;
				}
			
				if(plazas.get(indice).getTitulo()==null) {
					titulo_parking.setText("No hay titulo");
				}else {
					titulo_parking.setText(plazas.get(indice).getTitulo());
				}
				if(plazas.get(indice).getDescripcion()==null) {
					descripcion_parking.setText("No hay descripcion");
				}else {
					descripcion_parking.setText(plazas.get(indice).getDescripcion());
				}
				
				if(String.valueOf(plazas.get(indice).getPrecio())==null) {
					Precio.setText("No hay precio");
				}else {
					Precio.setText("El precio es de:" + String.valueOf(plazas.get(indice).getPrecio()));
				}
				
				//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
				
				if(plazas.get(indice).isSeguro()==true) {
					lblSeguro.setText("La plaza tiene seguro");
				}else if(plazas.get(indice).isSeguro()==false) {
					lblSeguro.setText("La plaza tiene seguro");
				}else {
					lblSeguro.setText("No tenemos informacion");
				}
				/*
				for(int u=0;u<plazasFav.size();u++) {
					if(plazas.get(indice)==plazasFav.get(u)) {
						panel_izquierda.setBackground(Color.green);
						panel_derecha.setBackground(Color.green);
					}
				}
				*/
				titulo_parking.repaint();
				descripcion_parking.repaint();
				Precio.repaint();
				lblPuntuacion.repaint();
				lblSeguro.repaint();
			}
		});
		panel_medio_abajo.add(btnPlazaSiguiente);
		
		
		if(plazas.get(indice).getTitulo()==null) {
			titulo_parking.setText("No hay titulo");
		}else {
			titulo_parking.setText(plazas.get(indice).getTitulo());
		}
		if(plazas.get(indice).getDescripcion()==null) {
			descripcion_parking.setText("No hay descripcion");
		}else {
			descripcion_parking.setText(plazas.get(indice).getDescripcion());
		}
		
		if(String.valueOf(plazas.get(indice).getPrecio())==null) {
			Precio.setText("No hay precio");
		}else {
			Precio.setText("El precio es de:" + String.valueOf(plazas.get(indice).getPrecio()));
		}
		
		//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
		if(plazas.get(indice).isSeguro()==true) {
			lblSeguro.setText("La plaza tiene seguro");
		}else if(plazas.get(indice).isSeguro()==false) {
			lblSeguro.setText("La plaza tiene seguro");
		}else {
			lblSeguro.setText("No tenemos informacion");
		}
		/*
		for(int u=0;u<plazasFav.size();u++) {
			if(plazas.get(indice)==plazasFav.get(u)) {
				panel_izquierda.setBackground(Color.green);
				panel_derecha.setBackground(Color.green);
			}
		}
		*/
		
		
		
		JPanel panel_abjo = new JPanel();
		panelPricipal.add(panel_abjo, BorderLayout.SOUTH);
		
		JButton btnsubir = new JButton("Publicar Anuncio");
		btnsubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_subir.main(null);
				dispose();
				/*ArrayList<Plaza> plazas = Remote.getInstance().getAllPlazas(Remote.getInstance().getToken());
				for (Plaza plaza : plazas) {
					System.out.println(plaza);
				}*/
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
	
	private void ordenarPlaza() {
		int indexAtras;
		
		if (plazas.size() < 2)
			return;
		
		for (int index=1; index<plazas.size(); index++) {
			indexAtras = index;
			if (plazas.get(index).getPrecio() < plazas.get(index - 1).getPrecio()) {
				while (plazas.get(index).getPrecio() <  plazas.get(indexAtras).getPrecio()) {
					indexAtras = indexAtras - 1;
				}
				plazas.add(indexAtras, plazas.get(index));
				plazas.remove(index+1);
			}
		}
	}

}


