package p2parking.jdo;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Plaza {

	private float precioDia;
	private String localizacion;
	private ArrayList<String> fotos; // guardamos solo los links para no tener que crear una nueva tabla en la base
										// de datos
	private long fechaPublicacion;

	public Plaza(float precio, String localizacion, ArrayList<String> fotos, long fechaPublicacion) {
		this.precioDia = precio;
		this.localizacion = localizacion;
		this.fotos = fotos;
		this.fechaPublicacion = fechaPublicacion;
	}

	public float getPrecio() {
		return precioDia;
	}

	public void setPrecio(float precio) {
		this.precioDia = precio;
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

	public long getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(long fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

}
