package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.Inicio_sesion;
import p2parking.client.ventanas.VentanaAdminLogIn;
import p2parking.client.ventanas.VentanaAdminPrincipal;

public class VentanaAdminLogInFuncionalidad {

	/**
	 * Boton para inciar sesion
	 * 
	 * @param vent La ventana en la que se muestra
	 * @param password la contrasena que se utiliza
	 */
	 public static void botonInicioSesion(VentanaAdminLogIn vent, String password) {
         if (Remote.getInstance().adminLogin(Remote.constructorRequest(password))) {
             VentanaAdminPrincipal.main(null);
             vent.dispose();
         } else {
             JOptionPane.showMessageDialog(null, "No se ha podido realizar el inicio de sesion");
         }
     }
    
    
}