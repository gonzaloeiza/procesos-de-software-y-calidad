package p2parking.client;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import p2parking.jdo.Usuario;



public class RemoteTest {
	Remote rem;
	long token;
	Usuario usr;
	
	@Before
	public void setUp() {
		Remote.getInstance();
		rem = new Remote("0.0.0.0", "8080");
		token = (new Date().getTime());
		rem.setToken(token);
		usr = new Usuario("nom", "dir", "cont", "fot");
		rem.setUser(usr);
	}
	
	@Test
	public void testGetNombre() {}
	
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
	}
	@Test
	public void main() {
		String hm = "0.0.0.0";
		String p = "8080";
		String[] t = {hm, p};
		Remote.main(t);
	}	
}