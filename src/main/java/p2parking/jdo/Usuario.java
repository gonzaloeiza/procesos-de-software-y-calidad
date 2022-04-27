package p2parking.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	private String nombre;
	@PrimaryKey
	private String correo;
	private int puntuacion;
	private String contrasena;
	private String foto;
	@Persistent(mappedBy="propietario")
	private List<Plaza> plazas;
    @Persistent(mappedBy="usuariosFavoritos")
	private List<Plaza> plazasFavoritos;

	private String telefono;
    @Persistent(mappedBy="usuario")
	private List<Incidencia> incidencias;
   
    
	public Usuario(String nombre, String correo, String contrasena, String foto, List<Plaza> set, String tlf, int punt) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.puntuacion = punt;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = set;
		this.telefono = tlf;
	}
	
	public Usuario(String nombre, String correo, String contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = new ArrayList<Plaza>();
		this.telefono = null;
		this.incidencias = new ArrayList<Incidencia>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public List<Plaza> getPlazas() {
		return plazas;
	}


	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}
	
	public void addPlaza(Plaza plaza) {
		this.plazas.add(plaza);
	}

	public List<Plaza> getPlazasFavoritos() {
		return plazasFavoritos;
	}

	public void setPlazasFavoritos(List<Plaza> plazasFavoritos) {
		this.plazasFavoritos = plazasFavoritos;
	}

	public int getPuntuacion() {
		return puntuacion;
	}
	public void newPuntuacion(int p) {
		this.puntuacion = (this.puntuacion + p)/2;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public void createIncidencia(Incidencia incidencia) {
		this.incidencias.add(incidencia);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<Incidencia> incidencia) {
		this.incidencias = incidencia;
	}
	
	
}
