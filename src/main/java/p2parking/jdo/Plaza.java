package p2parking.jdo;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Plaza {
	
	private float precio;
	private String localizacion;
	private ArrayList<String> fotos;	// guardamos solo los links para no tener que crear una nueva tabla en la base de datos
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Plaza(float precio, String localizacion, ArrayList<String> fotos) {
		this.precio = precio;
		this.localizacion = localizacion;
		this.fotos = fotos;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public ArrayList<String> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}

}
