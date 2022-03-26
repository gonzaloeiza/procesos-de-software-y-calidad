package p2parking.serialization;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String correo;
	private String contrsena;
	private String foto;
	private ArrayList<Plaza> favoritos;
	
	public Usuario(String nombre, String correo, String contrsena, String foto) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrsena = contrsena;
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
	public String getContrsena() {
		return contrsena;
	}
	public void setContrsena(String contrsena) {
		this.contrsena = contrsena;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
