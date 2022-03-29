package p2parking.jdo;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Favoritos {
	private Usuario usuario;
	private Plaza plaza;
	
	public Favoritos(Usuario usuario, Plaza plaza) {
		super();
		this.usuario = usuario;
		this.plaza = plaza;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Plaza getPlaza() {
		return plaza;
	}
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
	
	
}
