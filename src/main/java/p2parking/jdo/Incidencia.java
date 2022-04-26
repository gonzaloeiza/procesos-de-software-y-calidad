package p2parking.jdo;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Incidencia {
	
	private Usuario usuario;
	private String titulo;
	private String mensaje;
	private boolean resuelto;
	
	public Incidencia(String titulo, String mensaje){
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.resuelto = false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

}
