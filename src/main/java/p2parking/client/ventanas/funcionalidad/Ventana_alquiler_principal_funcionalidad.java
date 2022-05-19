package p2parking.client.ventanas.funcionalidad;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p2parking.client.Remote;
import p2parking.client.ventanas.VentanaUsuario;
import p2parking.client.ventanas.Ventana_CopiarUbicacion;
import p2parking.client.ventanas.Ventana_Incidencia;
import p2parking.client.ventanas.Ventana_UsuarioExterno;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_subir;
import p2parking.jdo.Plaza;
/**
 * 
 * @author lander
 *
 */
public class Ventana_alquiler_principal_funcionalidad {
	/**
	 * 
	 * @param panel1 Panel principal de la ventana
	 * @param panel2 Panel de la izquierda
	 * @param panel3 Panel de la derecha
	 * @param plazas Array de las plazas que añades a favoritos
	 * @param indice Para seleccionar que plaza
	 */
	public static void botonFavoritos(JPanel panel1, JPanel panel2, JPanel panel3,ArrayList<Plaza> plazas,int indice) {
		boolean temp = false;//Remote.getInstance().addPlazaFav(Remote.getInstance().getToken(), plazas.get(indice));
		if(temp) {
			JOptionPane.showMessageDialog(panel1, "Plaza añadida a favoritos");
			panel2.setBackground(Color.green);
			panel3.setBackground(Color.green);

		}
		else {
			System.out.println("No se ha añadido a favoritos");
		}
		
	}
	/**
	 * 
	 * @param vent Ventana de la que vienen
	 */
	public static void botonReportar(Ventana_alquiler_principal vent){
		Ventana_Incidencia.main(null);
		vent.dispose();
		
	}
	/**
	 * 
	 * @param vent Ventana de la que vienen
	 * @param indice Indice del array para saber en que plaza esta
	 */
	public static void botonUbi(Ventana_alquiler_principal vent,int indice) {
		String ubi=Remote.getInstance().getAllPlazas(Remote.getInstance().getToken()).get(indice).getLocalizacion();
		Ventana_CopiarUbicacion.main(null, ubi);
	}
	
	/**
	 * 
	 * @param vent Ventana de la que vienen
	 * @param plazas Array de las plazas
	 * @param indice Indice del array para saber en que plaza esta
	 */
	public static void botonEvaluar(Ventana_alquiler_principal vent, ArrayList<Plaza> plazas, int indice) {
		Ventana_UsuarioExterno.main(null,plazas.get(indice));
		vent.dispose();
	}
	
	/**
	 * 
	 * @param ordenado Si est ardenado o no
	 * @param btnOrden El boton que clickado
	 * @param plazasOrdenadas Arryde la plazas ordenadas
	 * @param indice Indice de la plaza
	 * @param titulo_parking El label del titulo
	 * @param descripcion_parking El label de la descripcion
	 * @param Precio El label del precio
	 * @param lblSeguro el label del seguro
	 * @param lblPuntuacion el label de la puntuacion
	 * @param plazas Arraylist de todas las plazas
	 */
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
	
	/**
	 * 
	 * @param ordenado Si esta ordenada o no
	 * @param plazasOrdenadas Array de plazas ordenadas
	 * @param indice Indice del array de plazas
	 * @param titulo_parking label de titulo
	 * @param descripcion_parking label de descripcion
	 * @param Precio label de precio 
	 * @param lblSeguro label de seguro 
	 * @param lblPuntuacion label de puntuacion 
	 * @param plazas array de plazas sin ordenar
	 */
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
	 /**
	  * 
	 * @param ordenado Si esta ordenada o no
	 * @param plazasOrdenadas Array de plazas ordenadas
	 * @param indice Indice del array de plazas
	 * @param titulo_parking label de titulo
	 * @param descripcion_parking label de descripcion
	 * @param Precio label de precio 
	 * @param lblSeguro label de seguro 
	 * @param lblPuntuacion label de puntuacion 
	 * @param plazas array de plazas sin ordenar
	  */
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
	 /**
	  * 
	  * @param frame La ventana de la que viene
	  */
	public static void ir_usuario(Ventana_alquiler_principal frame) {
		VentanaUsuario.main(null);
		frame.dispose();
	}
	/**
	 * 
	 * @param frame La ventana de la que viene
	 */
	public static void subir(Ventana_alquiler_principal frame) {
		Ventana_subir.main(null);
		frame.dispose();
	}
	

}
