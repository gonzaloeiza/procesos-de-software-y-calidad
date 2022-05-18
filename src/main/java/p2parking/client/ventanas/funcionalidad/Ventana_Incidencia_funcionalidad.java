package p2parking.client.ventanas.funcionalidad;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_Incidencia;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.jdo.Incidencia;

public class Ventana_Incidencia_funcionalidad {
	
	public static void botonVolver(Ventana_Incidencia vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
	}
	
	public static void botonIncidencia(Ventana_Incidencia frame, String a, String b) {
		System.out.println(Remote.getInstance().getToken());
		Remote.getInstance().crearincidencia(Remote.constructorRequest(Remote.getInstance().getToken(), new Incidencia(a, b)));
		botonVolver(frame);
	}

}
