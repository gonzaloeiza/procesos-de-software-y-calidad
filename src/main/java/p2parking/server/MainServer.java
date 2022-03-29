package p2parking.server;

import java.util.Date;
import java.util.HashMap;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import p2parking.jdo.Usuario;


@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)//TODO: Añadir metodos de BD
public class MainServer {
	
	
	HashMap<Date, Usuario> tokenUsuarios = new HashMap<>(); //mapa de usuarios logeados
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	Transaction tx = pm.currentTransaction();
	
	@GET
	@Path("/test")
	public Response addDonation() {
		return Response.ok("funcionando").build();
	}
	
	
//	/*Metodos gestion cuenta*/
//	@POST
//	@Path("/registro")
//	public Response registro(Usuario usr) {
//		boolean resultado = true;// TODO:funacionalidad registro
//		return Response.ok(resultado).build();
//	}
//	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena) {
		pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try {
            tx.begin();
            Query<Usuario> q = pm.newQuery(Usuario.class);
            q.filter("this.correo == '" + correo + "'");
            
            Usuario u = q.executeUnique();
            
            if (u.getContrasena().equals(contrasena)) {
            	Date token = new Date();
            	tokenUsuarios.put(token, new Usuario(u.getNombre(), u.getCorreo(), u.getContrasena(), u.getFoto(), u.getPlazas()));
            	return Response.ok(token).build();
            } else {
            	return Response.status(401, "Correo/contraseña incorrectos").build();
            }
            

        }catch(Exception e) {
        	return Response.status(400, "Error, intentalo de nuevo mas tarde").build();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
//	@POST
//	@Path("/updateUser")
//	public Response updateUser(Date token, Usuario usr) {
//		boolean resultado = true;// TODO:funacionalidad updateUser
//		return Response.ok(resultado).build();
//	}
	/*IMPORTANTE:   Nombre de usuario: "p2parkingCliente@gmail.com"; contrasena: "Q1w2E3r4" */
	@GET
	@Path("servicioCliente")
	public Response getServCliente() {
		String resultado = "Si tienes algun problema contacta con: p2parkingCliente@gmail.com";// TODO: definir servicio al cliente
		return Response.ok(resultado).build();
	}
//	
//	/*Metodos gestion Plaza*/
//	@POST
//	@Path("/addPlaza")
//	public Response addPlaza(Date token, Plaza plaza) {
////		if(tokenUsuarios.containsKey(token)) {
////			Usuario u = tokenUsuarios.get(token);
////			System.out.println(u.getNombre());
////			Usuario usr = tokenUsuarios.get(token);
////			usr.addFav(plaza);
////			tokenUsuarios.replace(token, usr);
////			return Response.ok(true).build();
////		}
//		return Response.ok(false).build();
//	}
//	@POST
//	@Path("/updatePlaza")
//	public Response updatePlaza(Date token, Plaza plazaOld, Plaza plazaNew) {
//		boolean resultado = true;// TODO:funacionalidad updatePlaza
//		return Response.ok(resultado).build();
//	}
//	@POST
//	@Path("/borrarPlaza")
//	public Response borrarPlaza(Date token, Plaza plaza) {
//		boolean resultado = true;// TODO:funacionalidad borrarPlaza
//		return Response.ok(resultado).build();
//	}
//	@POST
//	@Path("getMisPlazas")
//	public Response getMisPlazas(Date token) {
//		ArrayList<Plaza> resultado = new ArrayList<>();// TODO:funacionalidad getMisPlazas
//		return Response.ok(resultado).build();
//	}
//	@POST
//	@Path("addPlazaFav")
//	public Response addPlazaFav(Date token, Plaza plaza) {
//		if(tokenUsuarios.containsKey(token)) {
//			Usuario usr = tokenUsuarios.get(token);
//			usr.addFav(plaza);
//			tokenUsuarios.replace(token, usr);
//			return Response.ok(true).build();
//		}
//		return Response.ok(false).build();
//	}
//	@POST
//	@Path("getMisFav")
//	public Response getMisFav(Date token) {
//		if(tokenUsuarios.containsKey(token)) {
//			ArrayList<Plaza> resultado = tokenUsuarios.get(token).getFav();
//			return Response.ok(resultado).build();
//		}
//		return Response.ok(null).build();
//	}
}