package p2parking.server;

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
@Produces(MediaType.APPLICATION_JSON)
public class MainServer {
	
// localhost:8080/api/prueba/test
// POST y GET funcionan igual pero con o sin param	
// no puede haber dos metodos GET o POST en la misma URL
	
	HashMap<Date, Usuario> tokenUsuario = new HashMap<>(); //mapa de usuarios logeados
	
	@GET
	@Path("/test")
	public Response addDonation() {
		return Response.ok("funcionando").build();
	}
	/*Metodos gestion cuenta*/
	@POST
	@Path("/registro")
	public Response registro(String nombre, String correo, String contrsena, String foto) {
		boolean resultado = true;// funacionalidad registro
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/logIn")
	public Response logIn(String correo, String contrsena) {
		boolean resultado = true;// funacionalidad logIn
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/updateUser")
	public Response updateUser(Date token, String nombre, String correo, String contrsena, String foto) {
		boolean resultado = true;// funacionalidad updateUser
		return Response.ok(resultado).build();
	}
	@GET
	@Path("servicioCliente")
	public Response getServCliente() {
		boolean resultado = true;// funacionalidad getServCliente
		return Response.ok(resultado).build();
	}
	
	/*Metodos gestion Plaza*/
	@POST
	@Path("/addPlaza")
	public Response addPlaza(Date token, Plaza plaza) {
		boolean resultado = true;// funacionalidad addPlaza
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/updatePlaza")
	public Response updatePlaza(Date token, Plaza plazaOld, Plaza plazaNew) {
		boolean resultado = true;// funacionalidad updatePlaza
		return Response.ok(resultado).build();
	}
	@POST
	@Path("/borrarPlaza")
	public Response borrarPlaza(Date token, Plaza plaza) {
		boolean resultado = true;// funacionalidad borrarPlaza
		return Response.ok(resultado).build();
	}
	@POST
	@Path("getMisPlazas")
	public Response getMisPlazas(Date token) {
		boolean resultado = true;// funacionalidad getMisPlazas
		return Response.ok(resultado).build();
	}
	@POST
	@Path("addPlazaFav")
	public Response addPlazaFab(Date token, Plaza plaza) {
		boolean resultado = true;// funacionalidad addPlazaFab
		return Response.ok(resultado).build();
	}
	
	
}