package p2parking.client.ventanas.funcionalidad;

import p2parking.client.ventanas.VentanaAdminPlazasUsuario;
import p2parking.client.ventanas.VentanaAdminPrincipal;

public class VentanaAdminPlazasUsuarioFuncionalidad {
	public static void botonVolver(VentanaAdminPlazasUsuario vent) {
		vent.dispose();
		VentanaAdminPrincipal.main(null);
	}
	
}
