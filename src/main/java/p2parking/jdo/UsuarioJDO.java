package p2parking.jdo;


import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import p2parking.serialization.Plaza;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class UsuarioJDO {

	private String nombre;
	private String correo;
	private String contrasena;
	private String foto;
	private ArrayList<Plaza> favoritos;
	
	public UsuarioJDO(String nombre, String correo, String contrasena, String foto) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.favoritos = new ArrayList<>();
	}
	
	public ArrayList<Plaza> getFav(){
		return this.favoritos;
	}
	public void addFav(Plaza plaza) {
		this.favoritos.add(plaza);
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
}
