package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.Inicio_sesion;
import p2parking.client.ventanas.VentanaAdminLogIn;
import p2parking.client.ventanas.Ventana_CopiarUbicacion;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_registro;
/**
 * 
 * @author lander
 *
 */
public class Inicio_sesion_funcionalidad {
	/**
	 * 
	 * @param vent La ventana de la que vine
	 * @param a El usuario 
	 * @param password la constraseña
	 */
	public static void botonInicioSesion(Inicio_sesion vent, String a, String password) {
	Remote.getInstance().logIn(Remote.constructorRequest(a, password));
		if (a.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");

		} else {
			long temp = Remote.getInstance().logIn(Remote.constructorRequest(a, password));
			if (temp == 0 || temp == 401) {
				JOptionPane.showMessageDialog(null, "No se ha podido realizar el inicio de sesion");
			} else if (temp == 403) {
				JOptionPane.showMessageDialog(null, "Estás baneado. No puedes iniciar sesión");
			} else {
				Remote.getInstance().setToken(temp);
				Ventana_alquiler_principal.main(null);
				vent.dispose();
			}
		}
	}
	
	/**
	 * Metodo que hace que salte la ventana para copiar el correo
	 */
	public static void botonContacto() {
		Ventana_CopiarUbicacion.main(null, "p2parkingCliente@gmail.com");
		
	}
	
	/**
	 * 
	 * @param vent La ventana de la que proviene 
	 */
	public static void botonRegistro(Inicio_sesion vent) {
		Ventana_registro.main(null);
		vent.dispose();
		
		
	}
	
	/**
	 * Metodo para compartir el github dle proyecto
	 */
	public static void botonCompartir() {
		Ventana_CopiarUbicacion.main(null,"https://github.com/gonzaloeiza/procesos-de-software-y-calidad/releases/tag/sprint-2");
		
	}

	/**
	   * Metodo para que el boton te lleve a la ventana de admin
	   * 
	   * @param vent La ventana de la que proviene 
	   */
	public static void botonAdministrador(Inicio_sesion vent) {
        VentanaAdminLogIn.main(null);
        vent.dispose();
    }
	

}
