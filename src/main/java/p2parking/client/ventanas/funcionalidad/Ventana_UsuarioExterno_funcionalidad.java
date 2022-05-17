package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_UsuarioExterno;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.jdo.Plaza;

public class Ventana_UsuarioExterno_funcionalidad {
	
	public static void botonEvaluar(JPanel panel, Plaza a) {
		
		 String valorevaluacion = JOptionPane.showInputDialog(panel,"Que nota le pones a este usuario?(1-5)", "Evaluacion", 1);
		 if (valorevaluacion.matches("-?\\d+")) {
			 if(Integer.parseInt(valorevaluacion)>5) {
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),5)); 
			 }else if(Integer.parseInt(valorevaluacion)<=0) {
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),1)); 
			 }else{
				 Remote.getInstance().setPuntuacion(Remote.constructorRequest(Remote.getInstance().getToken(), a.getPropietario(),
						 Integer.parseInt(valorevaluacion))); 
			 }
		 } else {
			 JOptionPane.showMessageDialog(panel, "Introduce un número correcto");
		 }
	}
	
	public static void botonVolver(Ventana_UsuarioExterno vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
	}

}
