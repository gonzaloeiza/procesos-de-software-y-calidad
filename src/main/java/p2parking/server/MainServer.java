package p2parking.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import p2parking.jdo.Alquiler;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;


@Path("/prueba")
@Produces(MediaType.APPLICATION_JSON)//TODO: Añadir metodos de BD
public class MainServer {
	
	private static HashMap<Long, Usuario> tokenUsuarios = new HashMap<>(); //mapa de usuarios logeados
	
	UsuariosDAO usuarioDAO = UsuariosDAO.getInstance();
	AlquilerDAO alquilerDAO = AlquilerDAO.getInstance();
	PlazasDAO plazaDAO = PlazasDAO.getInstance();
	
	/**
	 * Seter para el usuario. Se utiliza para los teses
	 * @param usuarioDAO Objeto usuario de la clase DAO
	 */
	public void setUsuarioDAO(UsuariosDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * Seter para el hashmap de los tokens de usuario. Se utiliza para los teses
	 * @param tokens HashMap de tokens
	 */
	public void setMap(HashMap<Long, Usuario> tokens) {
		tokenUsuarios = tokens;
	}
	
	/**
	 * Seter para el objeto alquiler. Se utiliza para los teses
	 * @param alq Clase de alquilerDao
	 */
	public void setAlquilerDAO(AlquilerDAO alq) {
		this.alquilerDAO = alq;
	}
	
	/**
	 * Seter para la plazas. Se utiliza para los teses
	 * @param plazasDAO Objeto de plazas DAO para los teses
	 */
	public void setPlazaDAO(PlazasDAO plazasDAO) {
		this.plazaDAO = plazasDAO;
	}
	
	/*Metodos gestion cuenta*/
	
	  /**
	   * Ruta POST para realizar el registro de un usuario
	   * 
	   * @param usr	es el objeto Usuario que se quiere registrar
	   * @return devuelve true si se realiza el registro correctamente
	   */
	@POST
	@Path("/registro")
	public Response registro(Usuario usr) {
		System.out.println("entra");
		if(usuarioDAO.find(usr.getCorreo()) == null){
			//long token = (new Date()).getTime();
			//tokenUsuarios.put(token, usr);
			usuarioDAO.save(usr);
			return Response.ok(true).build();
		}
		System.out.println("llega");
		return Response.notModified().build();
	}
	
	  /**
	   * Ruta POST para realizar el login de un usuario
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve una lista con un token deserializado y un objeto usuario deserializados
	   */
	@POST
    @Path("/login")
    public Response login(List<String> requestBody) {
		Gson gson = new Gson();
        String correo = gson.fromJson(requestBody.get(0), String.class);
        String contrasena = gson.fromJson(requestBody.get(1), String.class);
         try {
            Usuario u = usuarioDAO.find(correo);
           if (u != null) {
            	if (!u.isBanned()) {
	                if (u.getContrasena().equals(contrasena)) {
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
	
	/**
	   * Ruta POST para actualizar los datos de un usuario
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve true si se actualizan los datos correctamente 
	   */
	@POST
	@Path("/updateUser")
	public Response updateUser(List<String> requestBody) {
		if (requestBody.size() == 2) {
			Gson gson = new Gson();
			long token = gson.fromJson(requestBody.get(0), Long.class);
			Usuario usuario = gson.fromJson(requestBody.get(1), Usuario.class);
			if(tokenUsuarios.containsKey(token)) {
				tokenUsuarios.replace(token, usuario);
				usuarioDAO.save(usuario);
				return Response.ok(true).build();
			} else {
				return Response.status(401).build();
			}
		} else {
			return Response.status(401).build();
		}
		
	}
	
	/*IMPORTANTE:   Nombre de usuario: "p2parkingCliente@gmail.com"; contrasena: "Q1w2E3r4" */
		
	/**
	   * Ruta GET para obtener la informacion de atención al cliente
	   * 
	   * @return devuelve la informacion de atencion al cliente
	   */
	@GET
	@Path("/servicioCliente")
	public Response getServCliente() {
		String resultado = "Si tienes algun problema contacta con: p2parkingCliente@gmail.com";// TODO: definir servicio al cliente
		return Response.ok(resultado).build();
	}
	
	/*Metodos gestion Plaza*/
	
	/**
	   * Ruta POST para que un usuario añada una nueva plaza
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un string "Plaza añadida correctamente" si todo ha ido bien
	   */
	@POST
	@Path("/addPlaza")
	public Response addPlaza(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		Plaza plaza = gson.fromJson(requestBody.get(1), Plaza.class);
		if(tokenUsuarios.containsKey(token)) {
			Usuario temp = usuarioDAO.find(tokenUsuarios.get(token).getCorreo());
			temp.addPlaza(plaza);
			tokenUsuarios.replace(token, temp);
			usuarioDAO.save(temp);
			return Response.ok("Plaza añadida correctamente").build();	
		} else {
			return Response.status(401, "No estas autenticado").build();
		}
	}
	
	/*Metodo para crear una nueva incidencia*/
	
	/**
	   * Ruta POST para crear una nueva incidencia
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un string "Incidencia creada correctamente" si todo ha ido bien
	   */
	@POST
	@Path("/createIncidencia")
	public Response createIncidencia(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		Incidencia incidencia = gson.fromJson(requestBody.get(1), Incidencia.class);
		if(tokenUsuarios.containsKey(token)) {
			Usuario temp = usuarioDAO.find(tokenUsuarios.get(token).getCorreo());
			temp.createIncidencia(incidencia);
			tokenUsuarios.replace(token, temp);
			usuarioDAO.save(temp);
			if (temp != null) {
				temp.createIncidencia(incidencia);
				usuarioDAO.save(temp);
				tokenUsuarios.replace(token, temp);
			}
			return Response.ok("Incidencia creada correctamente").build();	
		} else {
			return Response.status(401, "No estas autenticado").build();
		}
	}
	
	/**
	   * Ruta POST para obtener las plazas alquiladas de un usuario
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve una lista con las plazas alquiladas del usuario
	   */
	@POST
	@Path("/getAlquilados")
	public Response getAlquilados(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			Plaza plaza = gson.fromJson(requestBody.get(1), Plaza.class);
			Usuario usr = tokenUsuarios.get(token);	
			ArrayList<Alquiler> temp = alquilerDAO.findAll(usr.getCorreo());
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
	
	/**
	   * Ruta POST para obtener datos de un usuario
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un objeto usuario
	   */
	@POST
	@Path("/getTlf")
	public Response getTlf(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			String emial = requestBody.get(1);
			Usuario usr = usuarioDAO.find(emial);
			return Response.ok(usr).build();
		}
		return Response.status(401, "No estas autenticado").build();	
	}
	
	/**
	   * Ruta POST para poner una puntuacion a un usuario
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un estado 200 si todo ha ido bien
	   */
	@POST
	@Path("/setPuntuacion")
	public Response setPuntuacion(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			int puntuacion = gson.fromJson(requestBody.get(1), Integer.class);
			String email = gson.fromJson(requestBody.get(2), Usuario.class).getCorreo();
			Usuario usr = usuarioDAO.find(email);
			usr.newPuntuacion(puntuacion);
			usuarioDAO.save(usr);
			return Response.ok().build();
		}
		return Response.status(401, "No estas autenticado").build();
	}
	
	/**
	   * Ruta POST para obtener todas las plazas de la base de datos
	   * 
	   * @param token una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un lista con todas las plazas de la base de datos
	   */
	@POST
	@Path("/getAllPlazas")
	public Response getAllPlazas(long token) {
		System.out.println("en server: "+ token);
		System.out.println(tokenUsuarios.containsKey(token));
		if(tokenUsuarios.containsKey(token)) {
			System.out.println("entra");
			ArrayList<Plaza> ret = plazaDAO.getAll();
			for (int i = 0; i < ret.size(); i++) {
				ret.get(i).getPropietario();
			}
			Gson gson = new Gson();
			return Response.ok(gson.toJson(ret)).build();
		}
		return Response.status(401, "No estas autenticado").build();	
	}
	
	/**
	   * Ruta POST para obtener la localizacion de una plaza
	   * 
	   * @param requestBody una lista con objetos deserializados necesarios para tramitar la peticion
	   * @return devuelve un string con la url de la localizacion
	   */
	@POST
	@Path("/getLocalizacion")
	public Response getLocalizacion(ArrayList<String> requestBody) {
		Gson gson = new Gson();
		long token = gson.fromJson(requestBody.get(0), Long.class);
		if(tokenUsuarios.containsKey(token)) {
			Plaza plaza = gson.fromJson(requestBody.get(1), Plaza.class);
			String loc = plaza.getLocalizacion();
			String url = "https://www.google.com/maps/place/" + loc;
			return Response.ok(url).build();
		}
		return Response.status(401, "No estas autenticado").build();
		
	}
}
