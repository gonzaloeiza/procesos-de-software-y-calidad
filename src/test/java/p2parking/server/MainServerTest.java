package p2parking.server;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.jdo.JDOException;
import javax.ws.rs.core.Response.Status;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.google.gson.Gson;

import p2parking.dao.AlquilerDAO;
import p2parking.dao.PlazasDAO;
import p2parking.dao.UsuariosDAO;
import p2parking.jdo.Alquiler;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;
import p2parking.testCategories.IntegrationTest;
import p2parking.testCategories.UnitTest;

@Category(IntegrationTest.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class MainServerTest {

	MainServer server = new MainServer();

	UsuariosDAO usuariosDAO;
	AlquilerDAO alqDAO;
	PlazasDAO plazasDAO;
	
	MainServer mainServer;

	HashMap<Long, Usuario> t;
	
	Usuario u1;
	Usuario u2;
	Plaza p1;
	Incidencia i1;
	
	// If you use the EmptyReportModule, the report is not generated
	//@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp() {
		usuariosDAO = org.mockito.Mockito.mock(UsuariosDAO.class);
		t = org.mockito.Mockito.mock(HashMap.class);
		alqDAO = org.mockito.Mockito.mock(AlquilerDAO.class);
		plazasDAO = org.mockito.Mockito.mock(PlazasDAO.class);
		
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		i1 = new Incidencia("No hay luz", "En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
		
		mainServer = new MainServer();
		mainServer.setUsuarioDAO(usuariosDAO);
		mainServer.setAlquilerDAO(alqDAO);
		mainServer.setPlazaDAO(plazasDAO);
		mainServer.setAdminLoggedIn(false);
		mainServer.setMap(t);
		
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		u2 = new Usuario("javier", "javier@gmail.com", "1234", "ss");
		
		when(t.containsKey((long)1234)).thenReturn(true);
		when(t.put((long) 1234, u1)).thenReturn(u1);
		when(t.replace((long)1234, u1)).thenReturn(u1);
		when(t.get((long)1234)).thenReturn(u1);

		when(usuariosDAO.save(u1)).thenReturn(true);
		when(usuariosDAO.save(u2)).thenReturn(true);

		when(alqDAO.findAll(null)).thenReturn(null);
	}

	
	@Test
	public void testLogin() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		when(usuariosDAO.find("a")).thenReturn(null);
//		when(usuariosDAO.find("b")).thenThrow(JDOException.class);
		
		u2.setBanned(true);
		when(usuariosDAO.find("javier@gmail.com")).thenReturn(u2);
		
		List<String> requestBody = new ArrayList<String>();
		requestBody.add("gonzaloeizaguirre@opendeusto.es");
		requestBody.add("1234");
		
		assertEquals(mainServer.login(requestBody).getStatus(), 200);
		List<String> requestBody2 = new ArrayList<String>();
		requestBody2.add("a");
		requestBody2.add("1234");
		
		assertEquals(mainServer.login(requestBody2).getStatus(), 401);
		
//		List<String> requestBody3 = new ArrayList<String>();
//		requestBody3.add("b");
//		requestBody3.add("1234");
//		assertEquals(mainServer.login(requestBody3).getStatus(), 401);
		
		List<String> requestBody4 = new ArrayList<String>();
		requestBody4.add("javier@gmail.com");
		requestBody4.add("1234");
		assertEquals(403, mainServer.login(requestBody4).getStatus());
	
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
		
		requestBody.remove(1);
		assertEquals(401, mainServer.updateUser(requestBody).getStatus());
				
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
		assertEquals(200, mainServer.createIncidencia(requestBody).getStatus());
	
		ArrayList<String> requestBody2 = new ArrayList<String>();
		requestBody2.add(gson.toJson((long)12345));
		requestBody2.add(gson.toJson(i1));
		
		assertEquals(401, mainServer.createIncidencia(requestBody2).getStatus());
	}
	
	@Test
	public void testgetAlquilados() {
		when(t.containsKey((long)1234)).thenReturn(true);
	
		Gson gson = new Gson();
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(p1));

		assertEquals(200, mainServer.getAlquilados(requestBody).getStatus());

		ArrayList<String> requestBody2 = new ArrayList<String>();
		requestBody2.add(gson.toJson((long)12345));
		requestBody2.add(gson.toJson(i1));
		
		assertEquals(401, mainServer.getAlquilados(requestBody2).getStatus());

		ArrayList<Alquiler> listaAlquilar = new ArrayList<>();
		Alquiler a = new Alquiler(null, null, 0, u1, p1);
		a.setPlaza(p1);
		listaAlquilar.add(a);
		when(alqDAO.findAll(u1.getCorreo())).thenReturn(listaAlquilar);
		
		assertEquals(200, mainServer.getAlquilados(requestBody).getStatus());
	}
	
	@Test
	public void testgetTlf() {
		when(t.containsKey((long)1234)).thenReturn(true);
		when(usuariosDAO.find("javier@gmail.com")).thenReturn(u2);
		
		Gson gson = new Gson();
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson("javier@gmail.com"));
		
		assertEquals(200, mainServer.getTlf(requestBody).getStatus());
		
		ArrayList<String> requestBody2 = new ArrayList<String>();
		requestBody2.add(gson.toJson((long)12345));
		requestBody2.add(gson.toJson(i1));
		
		assertEquals(401, mainServer.getTlf(requestBody2).getStatus());
	}
	
	
	@Test
	public void testsetPuntuacion() {
		when(t.containsKey((long)1234)).thenReturn(true);
		when(usuariosDAO.find(u2.getCorreo())).thenReturn(u2);
		
		Gson gson = new Gson();
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(5));
		requestBody.add(gson.toJson(u2));
		
		assertEquals(200, mainServer.setPuntuacion(requestBody).getStatus());
		
		ArrayList<String> requestBody2 = new ArrayList<String>();
		requestBody2.add(gson.toJson((long)12345));
		requestBody2.add(gson.toJson(5));
		requestBody2.add(gson.toJson(u2));
		
		assertEquals(401, mainServer.setPuntuacion(requestBody2).getStatus());
	}
	
	@Test
	public void testgetAllPlazas() {
		when(t.containsKey((long)1234)).thenReturn(true);
		ArrayList<Plaza> listaPlazas = new ArrayList<Plaza>();
		listaPlazas.add(p1);
		when(plazasDAO.getAll()).thenReturn(listaPlazas);
		
		assertEquals(200, mainServer.getAllPlazas(1234).getStatus());
		assertEquals(401, mainServer.getAllPlazas(12345).getStatus());
		
	}
	@Test
	public void testgetLocalizacion() {
		when(t.containsKey((long)1234)).thenReturn(true);
		Plaza plaza = new Plaza(12.2f, "43°15'53.7\"N 2°56'37.1\"W", new ArrayList<String>(), new Date(2000, 03, 15).getTime());		
		
		Gson gson = new Gson();
		ArrayList<String> requestBody = new ArrayList<String>();
		requestBody.add(gson.toJson((long)1234));
		requestBody.add(gson.toJson(plaza));
		assertEquals(200, mainServer.getLocalizacion(requestBody).getStatus());
		when(t.containsKey((long)1234)).thenReturn(false);
		assertEquals(401, mainServer.getLocalizacion(requestBody).getStatus());
		
	}
	
	@Test
    public void testAdminLogin() {
        Gson gson = new Gson();
        ArrayList<String> requestBody = new ArrayList<String>();
        requestBody.add(gson.toJson("12345"));

        assertEquals(200, mainServer.adminLogin(requestBody).getStatus());

        ArrayList<String> requestBody2 = new ArrayList<String>();
        requestBody2.add(gson.toJson("1234"));

        assertEquals(401, mainServer.adminLogin(requestBody2).getStatus());
    }
	
	@Test
    public void testAdminGetAllUsers() {
		 mainServer.setAdminLoggedIn(false);
        assertEquals(401, mainServer.adminGetAllUsers().getStatus());
        mainServer.setAdminLoggedIn(true);
        assertEquals(200, mainServer.adminGetAllUsers().getStatus());
	}
	
	
}