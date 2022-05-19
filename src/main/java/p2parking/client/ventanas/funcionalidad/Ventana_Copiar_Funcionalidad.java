package p2parking.client.ventanas.funcionalidad;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;

import p2parking.client.ventanas.Ventana_CopiarUbicacion;
/**
 * 
 * @author lander
 *
 */
public class Ventana_Copiar_Funcionalidad  {

	/**
	 * 
	 * @param frame La ventana en la que se muestra
	 */
	public static void copia(Ventana_CopiarUbicacion frame) {
		frame.dispose();
	}
}
