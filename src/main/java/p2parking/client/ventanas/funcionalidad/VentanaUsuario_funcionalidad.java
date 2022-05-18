package p2parking.client.ventanas.funcionalidad;

import p2parking.client.ventanas.VentanaUsuario;
import p2parking.client.ventanas.Ventana_alquiler_principal;

public class VentanaUsuario_funcionalidad {
	public static void botonVolver(VentanaUsuario vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
		
	}
}
