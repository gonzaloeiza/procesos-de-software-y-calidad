package p2parking.server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import p2parking.dao.UsuariosDAO;
import p2parking.jdo.Usuario;


@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)//TODO: Añadir metodos de BD
public class MainServer {
	
	
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
		if(UsuariosDAO.getInstance().find(usr.getCorreo()) == null){
			Date token = new Date();
			tokenUsuarios.put(token, usr);
			UsuariosDAO.getInstance().save(usr);
			return Response.ok().build();
		}		
		return Response.notModified().build();
	}
	
	
	@POST
    @Path("/login")
    public Response login(List<Object> requestBody) {
        String correo = (String) requestBody.get(0);
        String contrasena = (String) requestBody.get(1);
        try {
            Usuario u = UsuariosDAO.getInstance().find(correo);
            if (u != null) {
                if (u.getContrasena().equals(contrasena)) {
                    Date token = new Date();
                    tokenUsuarios.put(token, u);
                    return Response.ok(token).build();
                }
            }
        } catch (Exception e) {

        }
        return Response.status(401, "Correo/Contraseña incorrectos").build();
       }
	
	@POST
	@Path("/updateUser")
	public Response updateUser(List<Object> requestBody) {
		if (requestBody.size() == 2 && requestBody.get(0) instanceof Date && requestBody.get(0) instanceof Usuario) {			
			Date token = (Date) requestBody.get(0);
			Usuario usuario = (Usuario) requestBody.get(1);
			if(tokenUsuarios.containsKey(token)) {
				tokenUsuarios.put(token, usuario);
				UsuariosDAO.getInstance().save(tokenUsuarios.get(token));
				return Response.ok(true).build();
			} else {
				return Response.ok(false).build();
			}
		} else {
			return Response.ok(false).build();
		}
		
	}
	
	/*IMPORTANTE:   Nombre de usuario: "p2parkingCliente@gmail.com"; contrasena: "Q1w2E3r4" */
	@GET
	@Path("/servicioCliente")
	public Response getServCliente() {
		String resultado = "Si tienes algun problema contacta con: p2parkingCliente@gmail.com";// TODO: definir servicio al cliente
		return Response.ok(resultado).build();
	}

	
	/*IMPORTANTE:   Nombre de usuario: "p2parkingCliente@gmail.com"; contrasena: "Q1w2E3r4" */
	@POST
	@Path("/alquiler")
	public Response crearAlquiler() {
		String resultado = "Si tienes algun problema contacta con: p2parkingCliente@gmail.com";// TODO: definir servicio al cliente
		return Response.ok(resultado).build();
	}
	
/* NO HACEN FALTA ESTOS METODOS, SI CREAS, ACTUALIZAS O BORRAS LAS PLAZAS USANDO LOS GETTERS Y SETTERS DE LA CLASE USUARIO
 * Y LLAMAS A /API/PRUEBA/UPDATEUSER (YA PROGRAMADO ARRIBA) SE ACTUALIZAN LA LISTA DE PLAZAS DEL USUARIO EN LA BD
 * 
 * usuario u = new Usuario(...);
 * u.setPlazas(new ArrayList<Plaza>();
 * UsuariosDAO.getInstance().save(u);
 *
 * En este ejemplo estarias sustituyendo todas las plazas del usuario por un arraylist vacio (borrarias todas las plazas),
 * y los cambios se actualizarian en la BD
*/

	
	
/////*Metodos gestion Plaza*/
//@POST
//@Path("/addPlaza")
//public Response addPlaza(List<Object> requestBody) {
//	if (requestBody.size() == 2 && requestBody.get(0) instanceof Date && requestBody.get(0) instanceof Plaza) {			
//		Date token = (Date) requestBody.get(0);
//		Plaza plaza = (Plaza) requestBody.get(1);
//		if(tokenUsuarios.containsKey(token)) {
//			tokenUsuarios.get(token).getPlazas().add(plaza);
//			UsuariosDAO.getInstance().save(tokenUsuarios.get(token));
//			return Response.ok("Plaza añadida correctamente").build();
//		} else {
//			return Response.status(401, "No estas autenticado").build();
//		}
//	} else {
//		return Response.status(400, "Ha ocurrido un error").build();
//	}
//}
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