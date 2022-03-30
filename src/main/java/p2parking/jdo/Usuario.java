package p2parking.jdo;

import java.util.Set;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	private String nombre;
	@PrimaryKey
	private String correo;
	private String contrasena;
	private String foto;
	@Join
	@Persistent(mappedBy="usuario", dependentElement="true")
	private Set<Plaza> plazas;
	
	public Usuario(String nombre, String correo, String contrasena, String foto, Set<Plaza> set) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = set;
	}
	
	public Usuario(String nombre, String correo, String contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
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


	public Set<Plaza> getPlazas() {
		return plazas;
	}


	public void setPlazas(Set<Plaza> plazas) {
		this.plazas = plazas;
	}

}
