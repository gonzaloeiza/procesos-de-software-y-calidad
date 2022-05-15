package p2parking.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * Clase de una plaza de parking
 * @author imanol
 *
 */
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
	
    /**
     * Constructor de la clase plaza
     * @param precio precio de alquiler por hora
     * @param localizacion localización de la plaza
     * @param fotos foto de la plaza
     * @param fechaPublicacion fecha en la que se ha publicado la plaza
     */
	public Plaza(float precio, String localizacion, ArrayList<String> fotos, long fechaPublicacion) {
		this.precioDia = precio;
		this.localizacion = localizacion;
		this.fotos = fotos;
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * Constructor de la plaza 
	 * @param precioDia precio de alquiler de la plaza por dia
	 * @param localizacion localizacion de la plaza
	 * @param fotos fotos de la plaza
	 * @param fechaPublicacion fecha de publicación de la plaza
	 * @param titulo titulo de la plaza
	 * @param descripcion texto explicativo de la plaza
	 * @param seguro identificador de si la plaza cuenta con seguro o no
	 */
	public Plaza(float precioDia, String localizacion, ArrayList<String> fotos, long fechaPublicacion,
			 String titulo, String descripcion, boolean seguro) {
		super();
		this.precioDia = precioDia;
		this.localizacion = localizacion;
		this.fotos = fotos;
		this.fechaPublicacion = fechaPublicacion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.seguro = seguro;
	}

	/**
	 * Geter del precio de alquiler
	 * @return
	 */
	public float getPrecio() {
		return precioDia;
	}

	/**
	 * Seter del precio por hora de la plaza
	 * @param precio cantidad que cuesta la plaza por hora
	 */
	public void setPrecio(float precio) {
		this.precioDia = precio;
	}

	/**
	 * Geter de la localización de la plaza
	 * @return localización de la plaza
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Seter de la localizacion de la plaza
	 * @param localizacion nueva localizacion de la plaza
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Geter de las fotos de la plaza
	 * @return arraylist de fotos de las plazas
	 */
	public ArrayList<String> getFotos() {
		return fotos;
	}

	/**
	 * Seter de las fotos de la plaza
	 * @param fotos lista de las fotos de las plzas
	 */
	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}

	/**
	 * Geter de la fecha de publicación de la plaza
	 * @return fecha de publicación de la plaza
	 */
	public long getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * Seter de la fecha de publicación de la plaza
	 * @param fechaPublicacion nueva fecha de publicacion
	 */
	public void setFechaPublicacion(long fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * Usuairo propietario de la plaza
	 * @return usuario propietario
	 */
	public Usuario getPropietario() {
		return propietario;
	}

	/**
	 * Seter del usuario propietario de la plaza
	 * @param propietario nuevo propietario de la plaza
	 */
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	/**
	 * Geter de los usuarios que tienen esta plaza como favorita
	 * @return lista de usuarios favoritos
	 */
	public List<Usuario> getUsuariosFavoritos() {
		return usuariosFavoritos;
	}

	/**
	 * Seter de los usuarios favoritos de la plaza
	 * @param usuariosFavoritos nueva lista de los usuarios favoritos
	 */
	public void setUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		this.usuariosFavoritos = usuariosFavoritos;
	}

	/**
	 * Geter de la descipcion de la plaza
	 * @return texto descriptivo de la plaza
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Seter de la nueva descripcion de la plaza
	 * @param descripcion de la plaza
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Geter del titulo de la plaza
	 * @return texto del titulo de la plaza
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Seter del nuevo titulo de la plaza
	 * @param titulo nuevo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Geter de la variable seguro de la plaza
	 * @return devuelve true si tiene seguro y false si no tiene seguro
	 */
	public boolean isSeguro() {
		return seguro;
	}

	/**
	 * Seter de si tiene seguro la plaza
	 * @param seguro estado de si tiene seguro la plaza
	 */
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

}
