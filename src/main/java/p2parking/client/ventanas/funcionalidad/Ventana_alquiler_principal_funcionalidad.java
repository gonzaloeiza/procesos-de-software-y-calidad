package p2parking.client.ventanas.funcionalidad;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p2parking.client.ventanas.Ventana_Incidencia;
import p2parking.client.ventanas.Ventana_UsuarioExterno;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.jdo.Plaza;

public class Ventana_alquiler_principal_funcionalidad {
	
	public static void botonFavoritos(JPanel panel1, JPanel panel2, JPanel panel3) {
		boolean temp = false;//Remote.getInstance().addPlazaFav(Remote.getInstance().getToken(), plazas.get(indice));
		if(temp) {
			JOptionPane.showMessageDialog(panel1, "Plaza añadida a favoritos");
			panel2.setBackground(Color.green);
			panel3.setBackground(Color.green);

		}
		else {
			
		}
		
	}
	
	public static void botonReportar(Ventana_alquiler_principal vent){
		
		Ventana_Incidencia.main(null);
		vent.dispose();
		
	}
	
	public static void botonEvaluar(Ventana_alquiler_principal vent, ArrayList<Plaza> plazas, int indice) {
		
		Ventana_UsuarioExterno.main(null,plazas.get(indice));
		vent.dispose();
	}
	
	public static void botonOrdenar(boolean ordenado, JButton btnOrden, ArrayList<Plaza> plazasOrdenadas, int indice, JLabel titulo_parking, JLabel descripcion_parking, JLabel Precio, JLabel lblSeguro, JLabel lblPuntuacion, ArrayList<Plaza> plazas) {
		
		ordenado=!ordenado;
		if(ordenado) {
			btnOrden.setText("Desordenar Plazas");
		}else {
			btnOrden.setText("Ordenar Plazas");
		}
		
		
		if(plazasOrdenadas.get(indice).getTitulo()==null) {
			titulo_parking.setText("No hay titulo");
		}else {
			titulo_parking.setText(plazasOrdenadas.get(indice).getTitulo());
		}
		
		if(plazasOrdenadas.get(indice).getDescripcion()==null) {
			descripcion_parking.setText("No hay descripcion");
		}else {
			descripcion_parking.setText(plazasOrdenadas.get(indice).getDescripcion());
		}
		
		if(String.valueOf(plazasOrdenadas.get(indice).getPrecio())==null) {
			Precio.setText("No hay precio");
		}else {
			Precio.setText("El precio es de:" + String.valueOf(plazasOrdenadas.get(indice).getPrecio()));
		}
		//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
		
		if(plazasOrdenadas.get(indice).isSeguro()==true) {
			lblSeguro.setText("La plaza tiene seguro");
		}else if(plazasOrdenadas.get(indice).isSeguro()==false) {
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
	
	public static void botonSiguiente(boolean ordenado, ArrayList<Plaza> plazasOrdenadas, int indice, JLabel titulo_parking, JLabel descripcion_parking, JLabel Precio, JLabel lblSeguro, JLabel lblPuntuacion, ArrayList<Plaza> plazas) {
		
		indice+=1;
		
		if(indice>=plazas.size()) {
			indice=plazas.size()-1;
		}
	
		if(ordenado) {
			if(plazasOrdenadas.get(indice).getTitulo()==null) {
				titulo_parking.setText("No hay titulo");
			}else {
				titulo_parking.setText(plazasOrdenadas.get(indice).getTitulo());
			}
			
			if(plazasOrdenadas.get(indice).getDescripcion()==null) {
				descripcion_parking.setText("No hay descripcion");
			}else {
				descripcion_parking.setText(plazasOrdenadas.get(indice).getDescripcion());
			}
			
			if(String.valueOf(plazasOrdenadas.get(indice).getPrecio())==null) {
				Precio.setText("No hay precio");
			}else {
				Precio.setText("El precio es de:" + String.valueOf(plazasOrdenadas.get(indice).getPrecio()));
			}
			//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
			
			if(plazasOrdenadas.get(indice).isSeguro()==true) {
				lblSeguro.setText("La plaza tiene seguro");
			}else if(plazasOrdenadas.get(indice).isSeguro()==false) {
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
		}else {
			
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
		
	}
	
	public static void botonAnterior(boolean ordenado, ArrayList<Plaza> plazasOrdenadas, int indice, JLabel titulo_parking, JLabel descripcion_parking, JLabel Precio, JLabel lblSeguro, JLabel lblPuntuacion, ArrayList<Plaza> plazas) {
		
		indice-=1;
		if(indice<=0) {
			indice=0;
		}
		
		if(ordenado) {
			if(plazasOrdenadas.get(indice).getTitulo()==null) {
				titulo_parking.setText("No hay titulo");
			}else {
				titulo_parking.setText(plazasOrdenadas.get(indice).getTitulo());
			}
			
			if(plazasOrdenadas.get(indice).getDescripcion()==null) {
				descripcion_parking.setText("No hay descripcion");
			}else {
				descripcion_parking.setText(plazasOrdenadas.get(indice).getDescripcion());
			}
			
			if(String.valueOf(plazasOrdenadas.get(indice).getPrecio())==null) {
				Precio.setText("No hay precio");
			}else {
				Precio.setText("El precio es de:" + String.valueOf(plazasOrdenadas.get(indice).getPrecio()));
			}
			//lblPuntuacion.setText(Integer.toString(plazas.get(indice).getPropietario().getPuntuacion()));
			
			if(plazasOrdenadas.get(indice).isSeguro()==true) {
				lblSeguro.setText("La plaza tiene seguro");
			}else if(plazasOrdenadas.get(indice).isSeguro()==false) {
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
		}else {
			
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
		
	}

}
