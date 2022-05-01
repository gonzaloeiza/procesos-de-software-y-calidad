package p2parking.server;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import p2parking.dao.AlquilerDAO;
import p2parking.dao.UsuariosDAO;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;


public class MainServerTest {

	MainServer server = new MainServer();

	UsuariosDAO usuariosDAO;
	AlquilerDAO alqDAO;
	
	MainServer mainServer;

	HashMap<Long, Usuario> t;
	
	Usuario u1;
	Plaza p1;
	Incidencia i1;
	
	@Before
	public void setUp() {
		usuariosDAO = org.mockito.Mockito.mock(UsuariosDAO.class);
		t = org.mockito.Mockito.mock(HashMap.class);
		alqDAO = org.mockito.Mockito.mock(AlquilerDAO.class);
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		i1 = new Incidencia("No hay luz", "En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
	    
		
		
		mainServer = new MainServer();
		mainServer.setUsuarioDAO(usuariosDAO);
		mainServer.serAlquilerDAO(alqDAO);
		mainServer.setMap(t);
		
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		
		when(t.containsKey((long)1234)).thenReturn(true);
		when(t.put((long) 1234, u1)).thenReturn(u1);
		when(t.replace((long)1234, u1)).thenReturn(u1);
		when(t.get((long)1234)).thenReturn(u1);

		when(usuariosDAO.save(u1)).thenReturn(true);
		
		when(alqDAO.findAll(null)).thenReturn(null);
	}

	
	@Test
	public void testLogin() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
		
		List<String> requestBody = new ArrayList<String>();
		requestBody.add("gonzaloeizaguirre@opendeusto.es");
		requestBody.add("1234");
		
		assertEquals(mainServer.login(requestBody).getStatus(), 200);
		List<String> requestBody2 = new ArrayList<String>();
		requestBody2.add("a");
		requestBody2.add("1234");
		
		assertEquals(mainServer.login(requestBody2).getStatus(), 401);
	}
	
	@Test
	public void testRegistro() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(null);
		when(usuariosDAO.find("a")).thenReturn(u1);
		
		assertEquals(mainServer.registro(u1).getStatus(), 200);
		
		Usuario a = new Usuario("a", "a", "a", "a");
		assertEquals(mainServer.registro(a).getStatus(), Status.NOT_MODIFIED.getStatusCode());
	}
	
	@Test
	public void testupdateUser() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
		Gson gson = new Gson();
		
		List<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(u1));
		
		when(t.containsKey((long)1234)).thenReturn(true);
		assertEquals(mainServer.updateUser(requestBody).getStatus(), 200);
		
		when(t.containsKey((long)1234)).thenReturn(false);
		assertEquals(mainServer.updateUser(requestBody).getStatus(), 401);
				
	}
	@Test
	public void testgetServCliente() {
		assertEquals(mainServer.getServCliente().getStatus(), 200);
	}
	@Test
	public void testaddPlaza() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
		Gson gson = new Gson();
		
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(p1));

		when(t.containsKey((long)1234)).thenReturn(true);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 200);
		
		when(t.containsKey((long)1234)).thenReturn(false);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 401);
	}
	@Test
	public void testcreateIncidencia() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
		Gson gson = new Gson();
		
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(i1));

		when(t.containsKey((long)1234)).thenReturn(true);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 200);
		
		when(t.containsKey((long)1234)).thenReturn(false);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 401);
	}
	@Test
	public void testgetAlquilados() {//TODO: terminar
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
		Gson gson = new Gson();
		
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(p1));

		when(t.containsKey((long)1234)).thenReturn(true);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 200);
		
		when(t.containsKey((long)1234)).thenReturn(false);
		assertEquals(mainServer.addPlaza(requestBody).getStatus(), 401);
	}
	@Test
	public void testgetTlf() {
		
	}
	@Test
	public void testsetPuntuacion() {
		
	}
	@Test
	public void testsetgetAllPlazas() {
		
	}
}