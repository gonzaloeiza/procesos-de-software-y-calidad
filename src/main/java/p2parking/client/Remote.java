package p2parking.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;


public class Remote {//TODO: buscar unasolucion para enviar mas de un parametro por funcion

	private Client client;
	private WebTarget webTarget;
	private static String path = "prueba";
	private static Remote instance;
	private static Usuario yoMismo;
	private static long token;
	
	public long getToken() {
		return token;
	}
	public void setToken(long toke) {
		token = toke;
	}
	public Usuario getUser() {
		return yoMismo;
	}
	public void setUser(Usuario usr) {
		yoMismo = usr;
	}
	
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
	public boolean registro(String nombre, String correo, String contrsena, String foto) {//Ejmplo metodo POST
        WebTarget donationsWebTarget = webTarget.path(path +  "/registro");
        Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);

        Usuario temp = new Usuario(nombre, correo, contrsena, foto);
        Response response = invocationBuilder.post(Entity.entity(temp, MediaType.APPLICATION_JSON));
        if (response.getStatus() == 200) {
            yoMismo = temp;
            return response.readEntity(Boolean.class);
        }
        return false;
    }
	//Post
	public long logIn(String email, String contrasena) {
        WebTarget donationsWebTarget = webTarget.path("prueba/login");
        Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
        List<Object> requestBody = new ArrayList<Object>();
        requestBody.add(email);
        requestBody.add(contrasena);
        Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
        if (response.getStatus() == 200) {
        	Gson gson = new Gson();
        	ArrayList<String> temp = response.readEntity(ArrayList.class);
        	Long token = gson.fromJson(temp.get(0), Long.class);
        	Usuario usr = gson.fromJson(temp.get(1), Usuario.class);
            Remote.getInstance().setToken(token);
            Remote.getInstance().setUser(usr);
            return token;
        }
        return 0;
    }
	//Post
	public boolean updateUser(long token, Usuario usuario) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/updateUser");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		List<Object> requestBody = new ArrayList<Object>(); 
		requestBody.add(token);
		requestBody.add(usuario);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() == 200) {
	           return true;
	        }
		else {
			return false;
		}		
	}
	//Get
	public String getServCliente() {//Ejemplo metodo GET
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
	public boolean addPlaza(long token, float precio, String localizacion, ArrayList<String> fotos, long fecha) {
		WebTarget donationsWebTarget = webTarget.path("prueba/addPlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Plaza plaza = new Plaza(precio, localizacion, fotos, fecha);
		List<String> requestBody = new ArrayList<String>();
        
        Gson gson = new Gson();
        requestBody.add(gson.toJson(token));
        String tem = gson.toJson(plaza);
        requestBody.add(tem);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	
	
	//Post para crear incidencia
	public boolean crearincidencia(String titulo, String cuerpo) {
		WebTarget donationsWebTarget = webTarget.path("prueba/addPlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Incidencia incidencia = new Incidencia(titulo, cuerpo);
		List<String> requestBody = new ArrayList<String>();
        
        Gson gson = new Gson();
        requestBody.add(gson.toJson(getToken()));
        String tem = gson.toJson(incidencia);
        requestBody.add(tem);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post

	public boolean updatePlaza(long token, Plaza plaza, float precio, String localizacion, ArrayList<String> fotos, long fecha) {
		WebTarget donationsWebTarget = webTarget.path(path +  "/updatePlaza");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Plaza plazanew = new Plaza(precio, localizacion, fotos, fecha);		
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
	public boolean borrarPlaza(long token, Plaza plaza) {
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
	public ArrayList<Plaza> getMisPlazas(long token) {
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
	public boolean addPlazaFav(long token, Plaza plaza) {
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
	public ArrayList<Plaza> getMisFav(long token){
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
	//Post
	public ArrayList<Alquiler> getAlquilados(long token, Plaza plaza){
		WebTarget donationsWebTarget = webTarget.path(path +  "/getAlquilados");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Gson gson = new Gson();
		List<Object> requestBody = new ArrayList<Object>(); 
		requestBody.add(token);
		requestBody.add(plaza);
		Response response = invocationBuilder.post(Entity.entity(gson.toJson(requestBody), MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: Añadir gestion de errores
			return null;
		}
		ArrayList<Alquiler> ret = response.readEntity(ArrayList.class);
		return ret;
	}
	//Post
	public Usuario getTlf(long token, Usuario usr){
		WebTarget donationsWebTarget = webTarget.path(path +  "/getTlf");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Gson gson = new Gson();
		List<Object> requestBody = new ArrayList<Object>(); 
		requestBody.add(token);
		requestBody.add(usr);
		Response response = invocationBuilder.post(Entity.entity(gson.toJson(requestBody), MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: Añadir gestion de errores
			return null;
		}
		Usuario ret = response.readEntity(Usuario.class);
		return ret;
	}
	//Post
	public boolean setPuntuacion(long token, Usuario usr, int punt){
		WebTarget donationsWebTarget = webTarget.path(path +  "/setPuntuacion");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Gson gson = new Gson();
		List<Object> requestBody = new ArrayList<Object>(); 
		requestBody.add(token);
		requestBody.add(punt);
		requestBody.add(usr.getCorreo());
		Response response = invocationBuilder.post(Entity.entity(gson.toJson(requestBody), MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	public ArrayList<Plaza> getAllPlazas(long token){
		WebTarget donationsWebTarget = webTarget.path(path +  "/getAllPlazas");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: añadir gestion de errores
			//System.out.println(response.getStatus());
			return null;
		}
		Gson gson = new Gson();
		String r = response.readEntity(String.class);
		ArrayList<Plaza> ret = gson.fromJson(r, new TypeToken<List<Plaza>>(){}.getType());
		return ret;
	}
			
	
	
	/**/
	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		Remote rem = new Remote(hostname, port);
	}
}

