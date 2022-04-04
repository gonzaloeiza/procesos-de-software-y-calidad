package p2parking.jdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Plaza {

	private float precioDia;
	private String localizacion;
	private ArrayList<String> fotos; // guardamos solo los links para no tener que crear una nueva tabla en la base
										// de datos
	private Date fechaPublicacion;
	private Usuario propietario;
    @Persistent(table="favoritos")
    @Join(column="PLAZA_ID")
    @Element(column="correo")
	private List<Usuario> usuariosFavoritos;
	
	public Plaza(float precio, String localizacion, ArrayList<String> fotos, Date fechaPublicacion) {
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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public float getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(float precioDia) {
		this.precioDia = precioDia;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public List<Usuario> getUsuariosFavoritos() {
		return usuariosFavoritos;
	}

	public void setUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		this.usuariosFavoritos = usuariosFavoritos;
	}

}
