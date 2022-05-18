package p2parking.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.google.gson.Gson;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;
import p2parking.testCategories.UnitTest;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
@Category(UnitTest.class)
public class RemoteTest {
	Remote rem;
	long token;
	Usuario usr;
	Plaza p1;
	Incidencia i1;
	
	Invocation.Builder iB;
	WebTarget wT, dWT;	
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp() {
		iB = org.mockito.Mockito.mock(Invocation.Builder.class);
		wT = org.mockito.Mockito.mock(WebTarget.class);
		dWT = org.mockito.Mockito.mock(WebTarget.class);
		
		rem = Remote.getInstance();
		rem.setDonationWebTarget(dWT);
		rem.setWebTarget(wT);
		rem.setInvocationBuilder(iB);
		
		token = new Date().getTime();
		rem.setToken(token);
		usr = new Usuario("nom", "dir", "cont", "fot");
		rem.setUser(usr);
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		i1 = new Incidencia("No hay luz", "En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
	    
		    
		when(dWT.request(MediaType.APPLICATION_JSON)).thenReturn(iB);
	}
	
	@Test
	public void getToken() {
		assertEquals(token, rem.getToken());
	}
	@Test
	public void setToken() {
		long t = new Date().getTime();
		rem.setToken(t);
		assertEquals(t, rem.getToken());
	}
	@Test
	public void getUser() {
		assertEquals(usr, rem.getUser());
	}
	@Test
	public void setUser() {
		Usuario u = new Usuario("a", "b", "c", "d");
		rem.setUser(u);
		assertEquals(u, rem.getUser());
	}
	
	@Test
	public void getInstance(){
		assertEquals(rem, Remote.getInstance());
//		Remote.setInstance(null);
//		Remote.getInstance();
	}
	@Test
	public void testregistro() {
		when(wT.path("prueba/registro")).thenReturn(dWT);
		when(iB.post(Entity.entity(usr, MediaType.APPLICATION_JSON))).thenReturn(Response.ok().build());
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.notModified().build());
		
		
		assertTrue(rem.registro(usr));
		assertFalse(rem.registro(null));
		
	}
	@Test
	public void testlogIn() {
		List<String> temp = new ArrayList<>();
		temp.add(usr.getCorreo()); temp.add(usr.getContrasena());
		Gson gson = new Gson();
		
		
		ArrayList<String> ret = new ArrayList<>();
		ret.add(gson.toJson(token)); ret.add(gson.toJson(usr));
		
		when(wT.path("prueba/login")).thenReturn(dWT);
		
		Response res = org.mockito.Mockito.mock(Response.class);
		when(res.readEntity(ArrayList.class)).thenReturn(ret);
		when(res.getStatus()).thenReturn(200);
		
		
		when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(res);
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(403).build());
		
		assertEquals(rem.logIn(temp), token); 
		assertEquals(rem.logIn(null), 403);
	}
	@Test
	public void testupdateUser() {
		when(wT.path("prueba/updateUser")).thenReturn(dWT);
		
		ArrayList<Object> temp = new ArrayList<>();
		temp.add(token); temp.add(usr);
		when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(Response.ok().build());
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertTrue(rem.updateUser(temp));
		assertFalse(rem.updateUser(null));
	}
	@Test
	public void testgetServCliente() {
		Response res = org.mockito.Mockito.mock(Response.class);
		when(res.readEntity(String.class)).thenReturn("prueba");
		when(res.getStatus()).thenReturn(200);
		
		when(wT.path("prueba/servicioCliente")).thenReturn(dWT);
		when(iB.get()).thenReturn(res);
		assertEquals(rem.getServCliente(), "prueba");
		when(iB.get()).thenReturn(Response.status(401).build());
		assertEquals(rem.getServCliente(), null);
	}
	@Test
	public void testaddPlaza() {
		when(wT.path("prueba/addPlaza")).thenReturn(dWT);
	
		Gson gson = new Gson();
		ArrayList<String> temp = new ArrayList<>();
		temp.add(gson.toJson(token)); temp.add(gson.toJson(p1));
		when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(Response.ok().build());
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertTrue(rem.addPlaza(temp));
		assertFalse(rem.addPlaza(null));
	}
	@Test
	public void testcrearincidencia() {
		when(wT.path("prueba/createIncidencia")).thenReturn(dWT);
		
		ArrayList<String> temp = new ArrayList<String>();
		Gson gson = new Gson();
        temp.add(gson.toJson(token));
        temp.add(gson.toJson(i1));
        
        when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(Response.ok().build());
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertTrue(rem.crearincidencia(temp));
		assertFalse(rem.crearincidencia(null));
		
	}
	/*@Test
	public void testupdatePlaza() {}
	@Test
	public void testborrarPlaza() {}
	@Test
	public void testgetMisPlazas() {}
	@Test
	public void testaddPlazaFav() {}
	@Test
	public void testgetMisFav() {}*/
	@Test
	public void testgetAlquilados() {
		when(wT.path("prueba/getAlquilados")).thenReturn(dWT);
		
		ArrayList<String> temp = new ArrayList<String>();
		Gson gson = new Gson();
        temp.add(gson.toJson(token));
        temp.add(gson.toJson(p1));
        
        ArrayList<Alquiler> ret = new ArrayList<>();
        ret.add(new Alquiler(new Date(), new Date(), 80, usr, p1));
        
        Response res = org.mockito.Mockito.mock(Response.class);
		when(res.readEntity(ArrayList.class)).thenReturn(ret);
		when(res.getStatus()).thenReturn(200);
        
        when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(res);
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
	
		assertNotNull(rem.getAlquilados(temp));
		assertNull(rem.getAlquilados(null));
	}
	@Test
	public void testgetTlf() {
		when(wT.path("prueba/getTlf")).thenReturn(dWT);
		
		ArrayList<String> temp = new ArrayList<String>();
		Gson gson = new Gson();
        temp.add(gson.toJson(token));
        temp.add(gson.toJson(usr));
        
        Response res = org.mockito.Mockito.mock(Response.class);
		when(res.readEntity(Usuario.class)).thenReturn(usr);
		when(res.getStatus()).thenReturn(200);
        
        when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(res);
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
				
		assertNotNull(rem.getTlf(temp));
		assertNull(rem.getTlf(null));
	
	}
	@Test
	public void testsetPuntuacion() {
		when(wT.path("prueba/setPuntuacion")).thenReturn(dWT);
		
		ArrayList<String> temp = new ArrayList<String>();
		Gson gson = new Gson();
        temp.add(gson.toJson(token));
        temp.add(gson.toJson(8));
        temp.add(gson.toJson(usr));
        
        when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(Response.ok().build());
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertTrue(rem.setPuntuacion(temp));
		assertFalse(rem.setPuntuacion(null));
		
	}
	@Test
	public void testgetLocalizacion() {
		when(wT.path("prueba/getLocalizacion")).thenReturn(dWT);
		
		ArrayList<String> temp = new ArrayList<>();
		Gson gson = new Gson();
		temp.add(gson.toJson(token));
		temp.add(gson.toJson(new Plaza(token, null, temp, token)));
		
        
		Response res = org.mockito.Mockito.mock(Response.class);
		when(res.getStatus()).thenReturn(200);
		when(res.readEntity(String.class)).thenReturn("");
			
		when(iB.post(Entity.entity(temp, MediaType.APPLICATION_JSON))).thenReturn(res);
		when(iB.post(Entity.entity(null, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertNotNull(rem.getLocalizacion(temp));
		when(res.getStatus()).thenReturn(401);
		assertNull(rem.getLocalizacion(temp));
	}
	@Test
	public void testgeAllPlazas() {
		when(wT.path("prueba/getAllPlazas")).thenReturn(dWT);
		
		ArrayList<Plaza> ret = new ArrayList<>();
		ret.add(p1);
		Gson gson = new Gson();
        
		Response res = org.mockito.Mockito.mock(Response.class);
		when(res.readEntity(String.class)).thenReturn(gson.toJson(ret));
		when(res.getStatus()).thenReturn(200);
	        
		
        when(iB.post(Entity.entity(token, MediaType.APPLICATION_JSON))).thenReturn(res);
		when(iB.post(Entity.entity((long)0, MediaType.APPLICATION_JSON))).thenReturn(Response.status(401).build());
		
		assertTrue(rem.getAllPlazas(token).size() > 0);
		assertEquals(rem.getAllPlazas((long)0).size(), 0);
	}
	@Test
	public void testConstructorRequest() {
		Gson gson = new Gson();
		ArrayList<String> ret = Remote.constructorRequest(usr);
		Usuario uret = gson.fromJson(ret.get(0), Usuario.class);
		
		
		assertEquals(uret.getCorreo(), usr.getCorreo());
	}
	@Test
	public void main() {
		String hm = "0.0.0.0";
		String p = "8080";
		String[] t = {hm, p};
		Remote.main(t);
	}	
}