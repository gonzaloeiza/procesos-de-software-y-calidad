package p2parking.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import p2parking.serialization.Plaza;
import p2parking.serialization.Usuario;

@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)//TODO: Añadir metodos de BD
public class MainServer {
	
// localhost:8080/api/prueba/test
// POST y GET funcionan igual pero con o sin param	
// no puede haber dos metodos GET o POST en la misma URL
	
	HashMap<Date, Usuario> tokenUsuarios = new HashMap<>(); //mapa de usuarios logeados
	
	@GET
	@Path("/test")
	public Response addDonation() {
		return Response.ok("funcionando").build();
	}
	/*Metodos gestion cuenta*/
	@POST
	@Path("/registro")
	public Response registro(Usuario usr) {
		boolean resultado = true;// TODO:funacionalidad registro
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/logIn")
	public Response logIn(String correo, String contrsena) {
		Date token = new Date();// TODO:funacionalidad logIn
		return Response.ok(token).build();
	}
	@POST
	@Path("/updateUser")
	public Response updateUser(Date token, Usuario usr) {
		boolean resultado = true;// TODO:funacionalidad updateUser
		return Response.ok(resultado).build();
	}
	@GET
	@Path("servicioCliente")
	public Response getServCliente() {
		String resultado = "servivio";// TODO: definir servicio al cliente
		return Response.ok(resultado).build();
	}
	
	/*Metodos gestion Plaza*/
	@POST
	@Path("/addPlaza")
	public Response addPlaza(Date token, Plaza plaza) {
		if(tokenUsuarios.containsKey(token)) {
			Usuario usr = tokenUsuarios.get(token);
			usr.addFav(plaza);
			tokenUsuarios.replace(token, usr);
			return Response.ok(true).build();
		}
		return Response.ok(false).build();
	}
	@POST
	@Path("/updatePlaza")
	public Response updatePlaza(Date token, Plaza plazaOld, Plaza plazaNew) {
		boolean resultado = true;// TODO:funacionalidad updatePlaza
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/borrarPlaza")
	public Response borrarPlaza(Date token, Plaza plaza) {
		boolean resultado = true;// TODO:funacionalidad borrarPlaza
		return Response.ok(resultado).build();
	}
	@POST
	@Path("getMisPlazas")
	public Response getMisPlazas(Date token) {
		ArrayList<Plaza> resultado = new ArrayList<>();// TODO:funacionalidad getMisPlazas
		return Response.ok(resultado).build();
	}
	@POST
	@Path("addPlazaFav")
	public Response addPlazaFav(Date token, Plaza plaza) {
		if(tokenUsuarios.containsKey(token)) {
			Usuario usr = tokenUsuarios.get(token);
			usr.addFav(plaza);
			tokenUsuarios.replace(token, usr);
			return Response.ok(true).build();
		}
		return Response.ok(false).build();
	}
	@POST
	@Path("getMisFav")
	public Response getMisFav(Date token) {
		if(tokenUsuarios.containsKey(token)) {
			ArrayList<Plaza> resultado = tokenUsuarios.get(token).getFav();
			return Response.ok(resultado).build();
		}
		return Response.ok(null).build();
	}
}