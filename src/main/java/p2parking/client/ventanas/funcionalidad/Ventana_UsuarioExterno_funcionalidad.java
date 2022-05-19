package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_UsuarioExterno;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.jdo.Plaza;
/**
 * 
 * @author lander
 * 
 *
 */
public class Ventana_UsuarioExterno_funcionalidad {
	
	/**
	 * 
	 * @param vent La ventana en la que se muestra
	 * @param panel Panel Principal del que viene
	 * @param a La plaza que estas evaluando
	 */
	public static void botonEvaluar(Ventana_UsuarioExterno vent, JPanel panel, Plaza a) {
		
		 String valorevaluacion = JOptionPane.showInputDialog(panel,"Que nota le pones a este usuario?(1-5)", "Evaluacion", 1);
		 if (valorevaluacion.matches("-?\\d+")) {
			 if(Integer.parseInt(valorevaluacion)>5) {
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), 5, a.getPropietario())); 
			 }else if(Integer.parseInt(valorevaluacion)<=0) {
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), 1, a.getPropietario())); 
			 }else{
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), Integer.parseInt(valorevaluacion),
						 a.getPropietario())); 
			 }
		 } else {
			 JOptionPane.showMessageDialog(panel, "Introduce un número correcto");
		 }
		 Ventana_alquiler_principal temp = Ventana_alquiler_principal.main(null);
		 temp.btnPlaza_Anterior.doClick();
		 vent.dispose();
	}
	
	/**
	 * 
	 * @param vent La ventana en la que se muestra
	 */
	public static void botonVolver(Ventana_UsuarioExterno vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
	}

}
