package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.Inicio_sesion;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_registro;

public class Inicio_sesion_funcionalidad {

	public static void botonInicioSesion(String a, String password) {
//	Remote.getInstance().logIn(user.getText(), password.getText());
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
				
			}
		}
	}
	
	public static void botonContacto() {
		JOptionPane.showMessageDialog(null, "Correo de contacto: p2parkingCliente@gmail.com");
	}
	
	public static void botonRegistro() {
		Ventana_registro.main(null);
		
		
	}
	
	public static void botonCompartir() {
		JOptionPane.showMessageDialog(null, "Enlace de github: https://github.com/gonzaloeiza/procesos-de-software-y-calidad/releases/tag/sprint-2");
		
	}

	

}
