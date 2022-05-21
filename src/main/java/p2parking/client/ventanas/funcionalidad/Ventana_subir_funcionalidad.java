package p2parking.client.ventanas.funcionalidad;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.Ventana_alquiler_principal;
import p2parking.client.ventanas.Ventana_subir;
import p2parking.jdo.Plaza;

/**
 * 
 * @author lander
 *
 */
public class Ventana_subir_funcionalidad {
	
	/**
	 * 
	 * @param vent La ventana en la que se muestra
	 */
	public static void botonVolver(Ventana_subir vent) {
		Ventana_alquiler_principal.main(null);
		vent.dispose();
		
	}
	
	/**
	 * 
	 * @param elm1 Grados c1
	 * @param elm2 Minutois C1
	 * @param elm3 segundos C1
	 * @param elm4 Grados c2
	 * @param elm5 minutos C2
	 * @param elm7 segundos c2
	 * @param titulo Titulo de la plaza
	 * @param descripcion Descripcion de la plaza
	 * @param seguro True or false si tiene seguro
	 * @param precio Precion de la plaza
	 * @param vent La ventana en la que se muestra
	 */
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
			JOptionPane.showMessageDialog(null, "Se ha publicado tu plaza!");
			vent.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Ha habido un error al prublicar la plaza. Por favor inténtalo más tarde");
		}
	
		
	}
	
	/**
	 * 
	 * @param seguro Variable si tiene seguro o no
	 * @return Valor si tiene seguro o no
	 */
	public static boolean checkBoxSeguro(boolean seguro) {
		if(seguro==true) {
			seguro=false;
		}else {
			seguro=true;
		}
		return seguro;
	}
	
}
