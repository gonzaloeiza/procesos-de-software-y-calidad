package p2parking.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	 protected String email=null;
	 protected String contrasena=null;
	 
	 protected Usuario() {
        super();
    }
	 
	 public Usuario(String email, String contrasena) {
        super();
        this.email = email;
        this.contrasena = contrasena;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	 
}
