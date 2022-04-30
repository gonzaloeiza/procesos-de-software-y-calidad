package p2parking.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import p2parking.jdo.Usuario;
import p2parking.server.MainServer;



public class ServerMock extends MainServer {
	
	
	public static void main(String[] args) {}
		
	@Override
	public Response addDonation() {
		return Response.ok("funcionando").build();
	}
	
	@Override
	public Response registro(Usuario usr) {
		if(usr != null){
			return Response.ok(true).build();
		}		
		return Response.notModified().build();
	}
	
	
	
}
