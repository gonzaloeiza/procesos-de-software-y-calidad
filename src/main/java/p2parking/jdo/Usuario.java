package p2parking.jdo;


import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {

	private String nombre;
	private String correo;
	private String contrasena;
	private String foto;
	
	
	
	public Usuario(String nombre, String correo, String contrasena, String foto) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
//		this.favoritos = new ArrayList<>();
	}
	
//	public ArrayList<Favoritos> getFav(){
//		return this.favoritos;
//	}
//	public void addFav(Plaza plaza) {
//		Favoritos fav = new Favoritos(this, plaza);
//		this.favoritos.add(fav);
//	}
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
