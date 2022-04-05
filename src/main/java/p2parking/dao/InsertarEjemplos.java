package p2parking.dao;

import java.util.Date;
import java.util.ArrayList;
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
	    
	    
	    
	    Plaza miCasa = new Plaza(87, "tebfdvs", new ArrayList<>(), (new Date()).getTime());
	    
	     
	    UsuariosDAO.getInstance().save(u1);
	    UsuariosDAO.getInstance().save(u2);
	    UsuariosDAO.getInstance().save(u3);
	    UsuariosDAO.getInstance().save(u4);
	    UsuariosDAO.getInstance().save(u5); 

//	    //añadir favoritos
	    Usuario u = UsuariosDAO.getInstance().find("gonzaloeizaguirre@opendeusto.es");
	    Usuario uu = UsuariosDAO.getInstance().find("javier@opendeusto.es");
	    
	    u.addPlaza(miCasa);
	    
	   // uu.getPlazas().get(0).getUsuariosFavoritos().add(u);
	    UsuariosDAO.getInstance().save(u);
	    
	}
}
