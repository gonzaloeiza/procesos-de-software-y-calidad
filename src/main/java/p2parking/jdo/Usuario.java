package p2parking.jdo;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	@PrimaryKey
	private String correo;
	private String nombre;
	private String contrasena;
	private String foto;
	@Element(column="PLAZA_ID")
	private ArrayList<Plaza> plazas;
	
	
	public Usuario(String correo, String nombre, String contrasena, String foto, ArrayList<Plaza> plazas) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.foto = foto;
		this.plazas = plazas;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public ArrayList<Plaza> getPlazas() {
		return plazas;
	}


	public void ArrayList(ArrayList<Plaza> plazas) {
		this.plazas = plazas;
	}	
}
