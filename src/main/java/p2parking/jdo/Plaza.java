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
	private long fechaPublicacion;
	private Usuario propietario;
    @Persistent(table="favoritos")
    @Join(column="PLAZA_ID")
    @Element(column="correo")
	private List<Usuario> usuariosFavoritos;
    private String titulo;
    private String descripcion;
    private boolean seguro;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

}
