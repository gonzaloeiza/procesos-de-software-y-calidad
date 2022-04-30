package p2parking.server;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOFatalDataStoreException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import p2parking.client.ServerMock;
import p2parking.jdo.Usuario;

public class MainServerTest {
	
	MainServer serv;
	
	@Before
	public void setUp() {
		serv = new MainServer();
	}
	
	/*@Test
	public void testMain() {
		ServerMock.main(null);
	}*/
	@Test
	public void registro() {
		assertEquals(serv.getClass(), MainServer.class);
	}
	
	/*
	@Test
	public void logIn() {
		List<String> l = new ArrayList<>();	
		l.add("email");	l.add("contra");
		
		//assertEquals(serv.login(l), 1);
	}*/
	
	
}