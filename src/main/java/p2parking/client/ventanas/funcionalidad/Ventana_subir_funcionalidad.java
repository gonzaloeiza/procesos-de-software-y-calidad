package p2parking.client.ventanas.funcionalidad;

import java.util.ArrayList;
import java.util.Date;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_subir;
import p2parking.jdo.Plaza;

public class Ventana_subir_funcionalidad {
	
	public static void botonVolver(Ventana_subir vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
		
	}
	
	public static void botonSubir(Ventana_subir vent, String a, String b, String c, String d, boolean e) {
		
		boolean temp = Remote.getInstance().addPlaza(Remote.constructorRequest(Remote.getInstance().getToken(), new Plaza( Float.valueOf(a), b, new ArrayList<>(),
				(new Date()).getTime(),c,d,e)));//TODO: cambiar null por las imagenes
		if(temp) {
			Ventana_alquiler_principal.main(null);
			vent.dispose();
		}
		else {
			//TODO: popUp de error
		}
		
	}
}
