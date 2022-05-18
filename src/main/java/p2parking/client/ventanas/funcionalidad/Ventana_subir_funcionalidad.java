package p2parking.client.ventanas.funcionalidad;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_subir;
import p2parking.jdo.Plaza;

public class Ventana_subir_funcionalidad {
	
	public static void botonVolver(Ventana_subir vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
		
	}
	
	public static void botonSubir(String elm1, String elm2, String elm3, String elm4, String elm5,String elm7,String titulo,
			String descripcion,boolean seguro,String precio,Ventana_subir vent) {
		String cordenada1= elm1+"º"+elm2+"'"+elm1+"\"N";
		String cordenada2=elm4+"º"+elm5+"'"+elm7+"\"W";
		String cordenadaT=cordenada1+" "+cordenada2;
		if(seguro==false) {
			int input=JOptionPane.showConfirmDialog(vent, "Quieres contratar un seguro automatico?", "Seguro", JOptionPane.YES_NO_OPTION);
			if(input==0) {
				seguro=true;
			}else if(input==1) {
				seguro=false;
			}
		}
		
		boolean temp = Remote.getInstance().addPlaza(Remote.constructorRequest(Remote.getInstance().getToken(), new Plaza( Float.valueOf(precio), cordenadaT, new ArrayList<>(),
				(new Date()).getTime(),titulo,descripcion,seguro)));
		if(temp) {
			Ventana_alquiler_principal.main(null);
			vent.dispose();
		}
		else {
			
		}
	
		
	}
	
	public static boolean checkBoxSeguro(boolean seguro) {
		if(seguro==true) {
			seguro=false;
		}else {
			seguro=true;
		}
		return seguro;
	}
	
}
