package p2parking.client.ventanas.funcionalidad;

import java.util.List;

import javax.swing.JOptionPane;

import p2parking.client.ventanas.VentanaAdminPlazasUsuario;
import p2parking.client.ventanas.VentanaAdminPrincipal;
import p2parking.jdo.Usuario;

public class VentanaAdminPrincipalFuncionalidad {

	public static void verPlazasDeUsuario(VentanaAdminPrincipal vent, List<Usuario> listaUsuarios, int index) {
		if (index < 0) {
            JOptionPane.showMessageDialog(null, "Error, debes seleccionar un usuario");
		} else {
			System.out.println("obtener plazas del usuario: "+ listaUsuarios.get(index).getCorreo());
			vent.dispose();
			VentanaAdminPlazasUsuario.main(listaUsuarios.get(index).getCorreo());
		}
	}
	
}
