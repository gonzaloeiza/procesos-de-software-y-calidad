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


public class Remote {

	private Client client;
	private static String path = "prueba";
	private static Remote instance = null;
	private static Usuario yoMismo;
	private static long token;
	
	private WebTarget donationsWebTarget;
	private WebTarget webTarget;
	private Invocation.Builder invocationBuilder;
	
	public void setWebTarget(WebTarget wt) {
		this.webTarget = wt;
	}
	public void setDonationWebTarget(WebTarget wt) {
		this.donationsWebTarget = wt;
	}
	public void setInvocationBuilder(Invocation.Builder iB) {
		this.invocationBuilder = iB;
	}
	
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
	public static void setInstance(Remote rem) {
		instance = rem;
	}

	public Remote(String hostname, String port) {
		this.client = ClientBuilder.newClient();
		this.webTarget = client.target(String.format("http://%s:%s/api", hostname, port));
		instance = this;
	}
	
	/*Metodos gestion Usuario*/
	//Post
	public boolean registro(Usuario temp) {//Ejmplo metodo POST
        donationsWebTarget = webTarget.path(path +  "/registro");
        invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(temp, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) {
        	
            yoMismo = temp;
            return true;
        }
        return false;
    }
	//Post
	public long logIn(List<String> requestBody) {
		donationsWebTarget = webTarget.path("prueba/login");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() == 200) {
        	Gson gson = new Gson();
        	ArrayList<String> temp = response.readEntity(ArrayList.class);
        	Long token = gson.fromJson(temp.get(0), Long.class);
        	Usuario usr = gson.fromJson(temp.get(1), Usuario.class);
            Remote.getInstance().setToken(token);
            Remote.getInstance().setUser(usr);
            return token;
        } else {
        	return response.getStatus();
        }
    }
	//Post
	public boolean updateUser(ArrayList<Object> requestBody) {
		donationsWebTarget = webTarget.path(path +  "/updateUser");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
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
		donationsWebTarget = webTarget.path(path + "/servicioCliente");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
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
	public boolean addPlaza(ArrayList<String> requestBody) {
		donationsWebTarget = webTarget.path("prueba/addPlaza");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	
	//Post
	public String getLocalizacion(ArrayList<String> requestBody) {
		donationsWebTarget = webTarget.path("prueba/getLocalizacion");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		return response.readEntity(String.class);
	}
	
	
	//Post para crear incidencia
	public boolean crearincidencia(ArrayList<String> requestBody) {
		donationsWebTarget = webTarget.path(path + "/createIncidencia");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	/*
	public boolean updatePlaza(long token, Plaza plaza, float precio, String localizacion, ArrayList<String> fotos, long fecha) {
		donatio/*nsWebTarget = webTarget.path(path +  "/updatePlaza");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
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
		donationsWebTarget = webTarget.path(path +  "/borrarPlaza");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
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
		donationsWebTarget = webTarget.path(path +  "/getMisPlazas");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
		return resultado;
	}*/
	//Post
	public boolean addPlazaFav(ArrayList<String> requestBody) {
		donationsWebTarget = webTarget.path(path +  "/addPlazaFav");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
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
		donationsWebTarget = webTarget.path(path +  "/getMisFab");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			//TODO:Añadir gestion de errores
			return null;
		}
		ArrayList<Plaza> resultado = response.readEntity(ArrayList.class);
		return resultado;
	}
	//Post
	public ArrayList<Alquiler> getAlquilados(ArrayList<String> requestBody){
		donationsWebTarget = webTarget.path(path +  "/getAlquilados");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: Añadir gestion de errores
			return null;
		}
		ArrayList<Alquiler> ret = response.readEntity(ArrayList.class);
		return ret;
	}
	//Post
	public Usuario getTlf(ArrayList<String> requestBody){
		donationsWebTarget = webTarget.path(path +  "/getTlf");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: Añadir gestion de errores
			return null;
		}
		Usuario ret = response.readEntity(Usuario.class);
		return ret;
	}
	//Post
	public boolean setPuntuacion(ArrayList<String> requestBody){
		donationsWebTarget = webTarget.path(path +  "/setPuntuacion");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: añadir gestion de errores
			return false;
		}
		return true;
	}
	//Post
	public ArrayList<Plaza> getAllPlazas(long token){
		System.out.println("en remote: " + token);
		donationsWebTarget = webTarget.path(path +  "/getAllPlazas");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(token, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()) {
			//TODO: añadir gestion de errores
			System.out.println(response.getStatus());
			return new ArrayList<Plaza>();
		}
		Gson gson = new Gson();
		String r = response.readEntity(String.class);
		ArrayList<Plaza> ret = gson.fromJson(r, new TypeToken<List<Plaza>>(){}.getType());
		return ret;
	}
		
	public boolean adminLogin(ArrayList<String> requestBody) {
        donationsWebTarget = webTarget.path(path +  "/adminLogin");
        invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
        if(response.getStatus() != Status.OK.getStatusCode()) {
            return false;
        }
        return true;
    }
	
	public List<Usuario> adminGetAllUsers() {
		donationsWebTarget = webTarget.path(path + "/adminGetAllUser");
		invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
        if(response.getStatus() != Status.OK.getStatusCode()) {
    		return new ArrayList<Usuario>();
        }
        Gson gson = new Gson();
        String r = response.readEntity(String.class);
        ArrayList<Usuario> ret = gson.fromJson(r, new TypeToken<List<Usuario>>(){}.getType());
        return ret;
	}
	
	public List<Plaza> adminGetPlazasUsuario(ArrayList<String> requestBody) {
		donationsWebTarget = webTarget.path(path +  "/adminGetPlazasUsuario");
        invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
        if(response.getStatus() != Status.OK.getStatusCode()) {
            return null;
        }
        Gson gson = new Gson();
        String r = response.readEntity(String.class);
        ArrayList<Plaza> ret = gson.fromJson(r, new TypeToken<List<Plaza>>(){}.getType());
        return ret;
	}
	 
	public static ArrayList<String> constructorRequest(Object... args){
		ArrayList<String> ret = new ArrayList<>();
		Gson gson = new Gson();
		for(Object obj: args) {
			ret.add(gson.toJson(obj));
		}
		return ret;
	}
	
	/**/
	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		new Remote(hostname, port);
	}
}

