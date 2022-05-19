package p2parking.client.ventanas.funcionalidad;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p2parking.client.Remote;
import p2parking.client.ventanas.Inicio_sesion;
import p2parking.client.ventanas.Ventana_registro;
import p2parking.jdo.Usuario;
/**
 * 
 * @author lander
 *
 */
public class Ventana_registro_funcionalidad {

	/**
	 * 
	 * @param frame La ventana en la que se muestra
	 */
	public static void botonAtras(Ventana_registro frame) {
		Inicio_sesion.main(null);
		frame.dispose();
	}
	
	/**
	 * 
	 * @param ventana La ventana en la que se muestra
	 * @param a Nombre usuario 
	 * @param b Correo de usuario
	 * @param c Contraseña de usuario
	 */
	public static void botonRegistro(Ventana_registro ventana, String a, String b, String c) {
		if (a.equals("") || b.equals("")||c.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			
		}else {
			try {
			boolean temp = Remote.getInstance().registro(new Usuario(a, b, c, "foto"));
			if(temp) {
				Inicio_sesion.main(null);
				JOptionPane.showMessageDialog(null, "Registro correcto");
				ventana.dispose();
			}
			else {
				  JOptionPane.showMessageDialog(null, "No se ha podido realizar el registro");
			}
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "No se ha podido conectar con el servidor");
			}
		}
	}
	
	/**
	 * 
	 * @param panel La ventana en la que se muestra
	 */
	public static void botonFotoPerfil(JPanel panel) {
		JFileChooser filechoser=new JFileChooser();
		filechoser.showOpenDialog(panel);
	}
}

