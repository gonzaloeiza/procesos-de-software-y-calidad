package p2parking.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

public abstract class InsertarEjemplos {
	
	public static void main(String args[]) {
		insertar();
	}
	
	public static void insertar() {
		
		System.out.println("Starting ....");
	    // Create a PersistenceManagerFactory for this datastore
	    
	
	    System.out.println("DataNucleus AccessPlatform with JDO");
	    System.out.println("===================================");
	
	    Usuario u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
	    Usuario u2 = new Usuario("javier", "javier@opendeusto.es", "1234", "ss");
	    Usuario u3 = new Usuario("endika", "endika@opendeusto.es", "1234", "ss");
	    Usuario u4 = new Usuario("oier", "oier@opendeusto.es", "1234", "ss");
	    Usuario u5 = new Usuario("imanol", "imanol.gutierrez@opendeusto.es", "1234", "ss");
	    
	    Plaza p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
	    Plaza p2 = new Plaza(12.2f, "", new ArrayList<String>(),  new Date(2000, 03, 15).getTime());
	    Plaza p3 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());  
	    
	    u1.getPlazas().add(p1);
	    u1.getPlazas().add(p2);
	    u2.getPlazas().add(p3);
	   	    
	    UsuariosDAO.getInstance().save(u1);
	    UsuariosDAO.getInstance().save(u2);
	    UsuariosDAO.getInstance().save(u3);
	    UsuariosDAO.getInstance().save(u4);
	    UsuariosDAO.getInstance().save(u5); 
    
	}

    
    

}
