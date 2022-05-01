package p2parking.server;

import java.util.ArrayList;
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

import com.google.gson.Gson;

import p2parking.dao.AlquilerDAO;
import p2parking.dao.PlazasDAO;
import p2parking.dao.UsuariosDAO;
import p2parking.dao.iAccesoObjeto;
import p2parking.jdo.Alquiler;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;


@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)//TODO: Añadir metodos de BD
public class MainServer {
	
	private static HashMap<Long, Usuario> tokenUsuarios = new HashMap<>(); //mapa de usuarios logeados
	
	UsuariosDAO usuarioDAO = UsuariosDAO.getInstance();

	
	public void setUsuarioDAO(UsuariosDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	
	
	/*Metodos gestion cuenta*/
	@POST
	@Path("/registro")
	public Response registro(Usuario usr) {
		if(usuarioDAO.find(usr.getCorreo()) == null){
			//long token = (new Date()).getTime();
			//tokenUsuarios.put(token, usr);
			usuarioDAO.save(usr);
			return Response.ok(true).build();
		}		
		return Response.notModified().build();
	}
	
	
	@POST
    @Path("/login")
    public Response login(List<String> requestBody) {
        String correo = (String) requestBody.get(0);
        String contrasena = (String) requestBody.get(1);
        try {
            Usuario u = usuarioDAO.find(correo);
            if (u != null) {
            	System.out.println(u.isBanned());
            	if (!u.isBanned()) {
	                if (u.getContrasena().equals(contrasena)) {
	                	Gson gson = new Gson();
	                    long token = (new Date()).getTime();
	                    tokenUsuarios.put(token, u);
	                    ArrayList<String> temp = new ArrayList<>();
	                    temp.add(gson.toJson(token)); temp.add(gson.toJson(u));
	                    return Response.ok(temp).build();
	                }
            	} else {
            		return Response.status(403).build();
            	}
            }
        } catch (Exception e) {

        }
        return Response.status(401, "Correo/Contraseña incorrectos").build();
       }
	
	@POST
	@Path("/updateUser")
	public Response updateUser(List<String> requestBody) {
		if (requestBody.size() == 2) {
			Gson gson = new Gson();
			long token = gson.fromJson(requestBody.get(0), Long.class);
			Usuario usuario = gson.fromJson(requestBody.get(1), Usuario.class);
			if(tokenUsuarios.containsKey(token)) {
				tokenUsuarios.replace(token, usuario);
				UsuariosDAO.getInstance().save(usuario);
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
	
	/*Metodos gestion Plaza*/
	@POST
	@Path("/addPlaza")
	public Response addPlaza(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		Plaza plaza = gson.fromJson(requestBody.get(1), Plaza.class);
		if(tokenUsuarios.containsKey(token)) {
			Usuario temp = UsuariosDAO.getInstance().find(tokenUsuarios.get(token).getCorreo());
			temp.addPlaza(plaza);
			tokenUsuarios.replace(token, temp);
			UsuariosDAO.getInstance().save(temp);
			return Response.ok("Plaza añadida correctamente").build();	
		} else {
			return Response.status(401, "No estas autenticado").build();
		}
	}
	
	/*Metodo para crear una nueva incidencia*/
	@POST
	@Path("/createIncidencia")
	public Response createIncidencia(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		Incidencia incidencia = gson.fromJson(requestBody.get(1), Incidencia.class);
		if(tokenUsuarios.containsKey(token)) {
			Usuario temp = UsuariosDAO.getInstance().find(tokenUsuarios.get(token).getCorreo());
			if (temp != null) {
				temp.createIncidencia(incidencia);
				UsuariosDAO.getInstance().save(temp);
				tokenUsuarios.replace(token, temp);
			}
			return Response.ok("Incidencia creada correctamente").build();	
		} else {
			return Response.status(401, "No estas autenticado").build();
		}
	}
	@POST
	@Path("/getAlquilados")
	public Response getAlquilados(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			Plaza plaza = gson.fromJson(requestBody.get(1), Plaza.class);
			Usuario usr = tokenUsuarios.get(token);	
			ArrayList<Alquiler> temp = AlquilerDAO.getInstance().findAll(usr.getCorreo());
			ArrayList<Alquiler> dev = new ArrayList<>();
			for(Alquiler a: temp) {
				if(a.getPlaza().equals(plaza)) {
					dev.add(a);
				}
			}
			return Response.ok(dev).build();	
		}
		return Response.status(401, "No estas autenticado").build();			
	}
	
	@POST
	@Path("/getTlf")
	public Response getTlf(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			String emial = requestBody.get(1);
			Usuario usr = UsuariosDAO.getInstance().find(emial);
			return Response.ok(usr).build();
		}
		return Response.status(401, "No estas autenticado").build();	
	}
	
	@POST
	@Path("/setPuntuacion")
	public Response setPuntuacion(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			int puntuacion = gson.fromJson(requestBody.get(1), Integer.class);
			String email = requestBody.get(2);
			Usuario usr = UsuariosDAO.getInstance().find(email);
			usr.newPuntuacion(puntuacion);
			UsuariosDAO.getInstance().save(usr);
			return Response.ok().build();
		}
		return Response.status(401, "No estas autenticado").build();	
	}
	
	@POST
	@Path("/getAllPlazas")
	public Response setgetAllPlazas(long token) {
		if(tokenUsuarios.containsKey(token)) {
			ArrayList<Plaza> ret = PlazasDAO.getInstance().getAll();
			Gson gson = new Gson();
			return Response.ok(gson.toJson(ret)).build();
		}
		return Response.status(401, "No estas autenticado").build();	
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