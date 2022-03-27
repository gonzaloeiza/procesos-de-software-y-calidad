package p2parking.jdo;

import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class PlazaJDO {
	
	private float precio;
	private String localizacion;
	private ArrayList<String> fotos;
	private int idPropietario;
	
	public PlazaJDO(float precio, String localizacion, ArrayList<String> fotos, int idPropietario) {
		this.precio = precio;
		this.localizacion = localizacion;
		this.fotos = fotos;
		this.idPropietario = idPropietario;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
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
