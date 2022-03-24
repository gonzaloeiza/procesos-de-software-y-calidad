package p2parking.server;

public class Usuario {

	public String nombre;
	public String correo;
	public String contrsena;
	public String foto;
	
	public Usuario(String nombre, String correo, String contrsena, String foto) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrsena = contrsena;
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
