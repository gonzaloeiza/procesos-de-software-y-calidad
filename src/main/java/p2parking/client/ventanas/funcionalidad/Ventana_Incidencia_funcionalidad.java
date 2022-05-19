package p2parking.client.ventanas.funcionalidad;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_Incidencia;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.jdo.Incidencia;
/**
 * 
 * @author lander
 *
 */
public class Ventana_Incidencia_funcionalidad {
	
	/**
	 * 
	 * @param vent La ventana en la que se muestra
	 */
	public static void botonVolver(Ventana_Incidencia vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
	}
	
	/**
	 * 
	 * @param frame La ventana en la que se muestra
	 * @param a Titulo de la incidencia 
	 * @param b Descripcion de la incidencia
	 */
	public static void botonIncidencia(Ventana_Incidencia frame, String a, String b) {

		Remote.getInstance().crearincidencia(Remote.constructorRequest(Remote.getInstance().getToken(), new Incidencia(a, b)));
		botonVolver(frame);
	}

}
