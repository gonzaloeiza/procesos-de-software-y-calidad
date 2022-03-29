<<<<<<< HEAD
//package p2parking.client;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//
//import p2parking.jdo.Plaza;
//import p2parking.jdo.Usuario;
//
//
//public class Remote {//TODO: buscar unasolucion para enviar mas de un parametro por funcion
//
//	private Client client;
//	private WebTarget webTarget;
//	private static String path = "prueba";
//
//	public Remote(String hostname, String port) {
//		client = ClientBuilder.newClient();
//		webTarget = client.target(String.format("http://%s:%s/api", hostname, port));
//	}
//	
//	/*Metodos gestion Usuario*/
//	//Post
//	protected boolean registro(String nombre, String correo, String contrsena, String foto) {//Ejmplo metodo POST
//		WebTarget donationsWebTarget = webTarget.path(path +  "/registro");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Usuario usr = new Usuario(nombre, correo, contrsena, foto);
//		Response response = invocationBuilder.post(Entity.entity(usr, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Post
//	protected Date logIn(String email, String contrasena) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/logIn");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Response response = invocationBuilder.post(Entity.entity(email, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(email, MediaType.APPLICATION_JSON), Entity.entity(contrasena, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return null;
//		}
//		Date token = response.readEntity(Date.class);
//		return token;
//	}
//	//Post
//	protected boolean updateUser(Date token, String nombre, String correo, String contrsena, String foto) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/updateUser");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Usuario usrNew = new Usuario(nombre, correo, contrsena, foto);
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(usrNew, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Get
//	protected String getServCliente() {//Ejemplo metodo GET
//		WebTarget donationsWebTarget = webTarget.path(path + "/servicioCliente");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		if (response.getStatus() == Status.OK.getStatusCode()) {
//			String servicio = response.readEntity(String.class);
//			return servicio;
//		} else {
//			//TODO:Añadir gestion de errores
//			return null;
//		}
//	}
//	
//	/*Metodos gestion Plaza*/
//	//Post
//	protected boolean addPlaza(Date token, float precio, String localizacion, ArrayList<String> fotos, Usuario propietario) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/addPlaza");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Plaza plaza = new Plaza(precio, localizacion, fotos, propietario);
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Post
//	protected boolean updatePlaza(Date token, Plaza plaza, float precio, String localizacion, ArrayList<String> fotos, Usuario propietario) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/updatePlaza");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Plaza plazanew = new Plaza(precio, localizacion, fotos, propietario);
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON), Entity.entity(plazaNew, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Post
//	protected boolean borrarPlaza(Date token, Plaza plaza) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/borrarPlaza");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Post
//	protected ArrayList<Plaza> getMisPlazas(Date token) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/getMisPlazas");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return null;
//		}
//		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
//		return resultado;
//	}
//	//Post
//	protected boolean addPlazaFav(Date token, Plaza plaza) {
//		WebTarget donationsWebTarget = webTarget.path(path +  "/addPlazaFav");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//				//TODO:No se como meter varios parametros. Estono funciona:
//				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return false;
//		}
//		return true;
//	}
//	//Post
//	protected ArrayList<Plaza> getMisFav(Date token){
//		WebTarget donationsWebTarget = webTarget.path(path +  "/getMisFab");
//		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
//		
//		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			//TODO:Añadir gestion de errores
//			return null;
//		}
//		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
//		return resultado;
//	}
//	
//	/**/
//	public static void main(String[] args) {
//		String hostname = args[0];
//		String port = args[1];
//
//		Remote rem = new Remote(hostname, port);
//	}
//}
//
=======
package p2parking.client;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;


public class Remote {//TODO: buscar unasolucion para enviar mas de un parametro por funcion

	private Client client;
	private WebTarget webTarget;
	private static String path = "prueba";
	
	private static Remote instance;
	
	public static Remote getInstance(){
		if (instance == null){
			instance = new Remote("0.0.0.0", "8080");
		}
		return instance;
	}

	public Remote(String hostname, String port) {
		this.client = ClientBuilder.newClient();
		this.webTarget = client.target(String.format("http://%s:%s/api", hostname, port));
		instance = this;
	}
	
	/*Metodos gestion Usuario*/
	//Post
	protected boolean registro(String nombre, String correo, String contrsena, String foto) {//Ejmplo metodo POST
		WebTarget donationsWebTarget = webTarget.path(path +  "/registro");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Usuario usr = new Usuario(nombre, correo, contrsena, foto);
		Response response = invocationBuilder.post(Entity.entity(usr, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	protected Date logIn(String email, String contrasena) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/logIn");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(email, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(email, MediaType.APPLICATION_JSON), Entity.entity(contrasena, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		Date token = response.readEntity(Date.class);
		return token;
	}
	//Post
	protected boolean updateUser(Date token, String nombre, String correo, String contrsena, String foto) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/updateUser");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Usuario usrNew = new Usuario(nombre, correo, contrsena, foto);
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(usrNew, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Get
	protected String getServCliente() {//Ejemplo metodo GET
		WebTarget donationsWebTarget = webTarget.path(path + "/servicioCliente");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			String servicio = response.readEntity(String.class);
			return servicio;
		} else {
			//TODO:Añadir gestion de errores
			return null;
		}
	}
	
	/*Metodos gestion Plaza*/
	//Post
	protected boolean addPlaza(Date token, float precio, String localizacion, ArrayList<String> fotos, Usuario propietario) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/addPlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Plaza plaza = new Plaza(precio, localizacion, fotos, propietario);
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	protected boolean updatePlaza(Date token, Plaza plaza, float precio, String localizacion, ArrayList<String> fotos, Usuario propietario) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/updatePlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Plaza plazanew = new Plaza(precio, localizacion, fotos, propietario);
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON), Entity.entity(plazaNew, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	protected boolean borrarPlaza(Date token, Plaza plaza) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/borrarPlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	protected ArrayList<Plaza> getMisPlazas(Date token) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/getMisPlazas");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
		return resultado;
	}
	//Post
	protected boolean addPlazaFav(Date token, Plaza plaza) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/addPlazaFav");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
				//TODO:No se como meter varios parametros. Estono funciona:
				//invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON), Entity.entity(plaza, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	protected ArrayList<Plaza> getMisFav(Date token){
		WebTarget donationsWebTarget = webTarget.path(path +  "/getMisFab");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
		return resultado;
	}
	
	/**/
	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		Remote rem = new Remote(hostname, port);
	}
}

>>>>>>> 9688bfbdce67374dab80e50a3d3f0192efabb2f8
