package p2parking.jdo;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase de dominio de incidencia. Contiene la informacion acerca de una incidencia
 * @author Endika
 *
 */

@PersistenceCapable
public class Incidencia {
	
	/**
	 * Usuario que crea la incidencia
	 */
	private Usuario usuario;
	/**
	 * Titulo de la incicendia
	 */
	private String titulo;
	/**
	 * Mensaje que explica la incidencia
	 */
	private String mensaje;
	/**
	 * Booleano que indica si la incidencia esta o no resuelta
	 */
	private boolean resuelto;
	
	/**
	 * Constructor de un objeto Incidencia
	 * @param usr Usuario que crea la incidencia
	 * @param titulo Titulo de la incidencia
	 * @param men Mensaje en el que se explica la incidencia
	 * @param res Booleano que indica si la incidencia esta o no resuelta
	 */
	public Incidencia(Usuario usr, String titulo, String men, boolean res) {
		this.usuario = usr;
		this.titulo = titulo;
		this.mensaje = men;
		this.resuelto = res;
	}
	
	/**
	 * Segundo constructor de un objeto Incidencia
	 * @param titulo Titulo de la incidencia
	 * @param mensaje Mensaje en el que se explica la incidencia
	 */
	public Incidencia(String titulo, String mensaje){
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.resuelto = false;
	}
	
	/**
	 * Geter del usuario que crea la incidencia
	 * @return Usuario que ha creado la incidencia
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Seter del usuario que ha creado la incidencia
	 * @param usuario Objeto usuario que ha creado la incidencia
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Geter del titulo de la incidencia
	 * @return Titulo de la incidencia
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Seter del titulo de la incidencia
	 * @param titulo String del titulo de la incidencia
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Geter del menaje de explicacion de la incidencia
	 * @return Mensaje de explicacion de la incidencia
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * Seter del mensaje de explicacion de la incidencia
	 * @param mensaje String del mensaje de explicacion de la incidencia
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Metodo para ver si la incidencia esta o no resulta
	 * @return Booleano que indica si la incidencia esta  no resuelta
	 */
	public boolean isResuelto() {
		return resuelto;
	}

	/**
	 * Seter del parametro que indica si esta o no resuelta la incidencia
	 * @param resuelto Booleano que indica si esta o n o resuelta la indicendcia
	 */
	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

}
