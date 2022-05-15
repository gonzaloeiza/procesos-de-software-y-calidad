package p2parking.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase de un usuario de la aplicacion
 * @author imanol
 *
 */
@PersistenceCapable
public class Usuario {
	/**
	 * Nombre del usuario
	 */
	private String nombre;

	/**
	 * Correo del usuario
	 */
	@PrimaryKey
	private String correo;
	
	/**
	 * Puntuacion del usuario
	 */
	private int puntuacion;
	
	/**
	 * Contraseña del usuario
	 */
	private String contrasena;
	
	/**
	 * Foto del usuario
	 */
	private String foto;
	
	/**
	 * Mapa de las plaza que tiene el usuario. Como en la base de datos es una relación de uno a muchos se utiliza un mapa para que funcione con datanucleus
	 */
	@Persistent(mappedBy="propietario")
	private List<Plaza> plazas;
	
	/**
	 * Mapa de las plazas favoritas. En la base de datos hay una relación de uno a muchos por lo que datanucleus exige usar un mapa
	 */
    @Persistent(mappedBy="usuariosFavoritos")
	private List<Plaza> plazasFavoritos;

    /**
     * Telefono de contacto con el usuario
     */
	private String telefono;
    @Persistent(mappedBy="usuario")

    /**
     * Mapa de las inicidencias del usuario
     */
	private List<Incidencia> incidencias;

    /**
     * Estado de baneo del usuario. El usuario se puede banear y esta variable lleva el registro de baneo
     */
    private boolean baneado;
   
    
    /**
     * Constructor del Usuario
     * @param nombre nombre del usuario
     * @param correo correo electrónico
     * @param contrasena contraseña de acceso
     * @param foto foto de perfil
     * @param set plazas del usuario
     * @param tlf telefono del usuario
     * @param punt puntuacion del usuario
     * @param plazasFav plazas favoritas del usuario
     * @param inc incidencias del usuario
     */
	public Usuario(String nombre, String correo, String contrasena, String foto, List<Plaza> set, String tlf, int punt, List<Plaza> plazasFav, List<Incidencia> inc) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.puntuacion = punt;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = set;
		this.telefono = tlf;
		this.plazasFavoritos = plazasFav;
		this.incidencias = inc;
		this.baneado = false;
	}
	
	/**
	 * Constructor adicional del usuario
	 * @param nombre nombre del usuario
	 * @param correo correo del usuario
	 * @param contrasena contraseña del usuario
	 * @param foto foto de perfil del usuario
	 */
	public Usuario(String nombre, String correo, String contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = new ArrayList<Plaza>();
		this.telefono = null;
		this.incidencias = new ArrayList<Incidencia>();
		this.puntuacion = 0;
		this.plazasFavoritos = new ArrayList<Plaza>();
		this.baneado = false;
	}

	/**
	 * Geter del nombre del usuario
	 * @return nombre de usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Seter del nombre de usuario
	 * @param nombre nombre de usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Geter del correo de usuario
	 * @return correo del usuario
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Seter del correo de usuario
	 * @param correo correo del usuario
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Geter de la contraseña del usuario
	 * @return contraseña del usuario
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Seter de contraseña de usuario
	 * @param contrasena nueva contraseña de usuario
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Get foto de usuario
	 * @return foto de usuario
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * Seter de foto de usuario
	 * @param foto foto de usuario
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Geter de las plazas que pertenecen al usuario
	 * @return lista de plazas del usuario
	 */
	public List<Plaza> getPlazas() {
		return plazas;
	}

	/**
	 * Seter de plazas de usuario
	 * @param plazas lista de plazas de usuario
	 */
	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}
	
	/**
	 * Seter de plazas de usuario
	 * @param plaza lista de plazas de usuario
	 */
	public void addPlaza(Plaza plaza) {
		this.plazas.add(plaza);
	}

	/**
	 * Geter de las plazas favoritas del usuario
	 * @return lista de las plazas favoritas
	 */
	public List<Plaza> getPlazasFavoritos() {
		return plazasFavoritos;
	}

	/**
	 * Seter de las plazas favoritas de usuario
	 * @param plazasFavoritos lista de las plazas de usuario
	 */
	public void setPlazasFavoritos(List<Plaza> plazasFavoritos) {
		this.plazasFavoritos = plazasFavoritos;
	}

	/**
	 * Geter de la puntuacion del usuario
	 * @return puntuacion del usuario
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	
	/**
	 * Seter de la puntuacion del usuario
	 * @param p nueva puntuación del usuario
	 */
	public void newPuntuacion(int p) {
		this.puntuacion = (this.puntuacion + p)/2;
	}
	
	/**
	 * Seter de la puntuacion del usuario
	 * @param puntuacion nueva puntuacion del usuario
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Añadir una incidencia a la lista de incidencias del usuario
	 * @param incidencia nueva incidencia a añadir
	 */
	public void createIncidencia(Incidencia incidencia) {
		this.incidencias.add(incidencia);
	}

	/**
	 * Geter del telefono del usuario
	 * @return numero de telefono del usuario
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Seter del telefono del usuario
	 * @param telefono nuevo telefono del usuario
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Geter de la lista de inicidencias del usuario
	 * @return lista de inicidencias del usuario
	 */
	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	/**
	 * Seter de las incidencias del usuario
	 * @param incidencia lista de incidencias de la plaza
	 */
	public void setIncidencias(List<Incidencia> incidencia) {
		this.incidencias = incidencia;
	}
	
	/**
	 * Geter de la variable de baneo del usuario
	 * @return variable de baneo del usuario
	 */
	public boolean isBanned() {
		return(this.baneado);
	}
	
	/**
	 * Seter de la variable baneo del usuario
	 * @param baneado valor del baneo de usuario
	 */
	public void setBanned(boolean baneado) {
		this.baneado = baneado;
	}
	
}
