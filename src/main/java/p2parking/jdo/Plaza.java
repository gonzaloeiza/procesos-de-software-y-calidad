package p2parking.jdo;

import java.util.ArrayList;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Plaza {
	
	private float precio;
	private String localizacion;
	private ArrayList<String> fotos;
	@ForeignKey
	private Usuario propietario;
	
	
	public Plaza(float precio, String localizacion, ArrayList<String> fotos, Usuario propietario) {
		this.precio = precio;
		this.localizacion = localizacion;
		this.fotos = fotos;
		this.propietario = propietario;
	}
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
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
