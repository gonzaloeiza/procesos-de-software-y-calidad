package p2parking.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import p2parking.jdo.Usuario;

public class UsuariosDAOTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	
	@Before
	public void setUp() {
		usuario1 = new Usuario("gonzalo", "eizaguirregonzalo@gmail.com", "12345678", "");
		usuario2 = new Usuario("javier", "lufecoba@gmail.com", "12345678", "");
		usuario3 = new Usuario("imanol", "imanol@gmail.com", "12345678", "");
	}
	
	
	@Test
	public void testGetNombre() {
		assertEquals("gonzalo", usuario1.getNombre());
		assertEquals("javier", usuario2.getNombre());
		assertEquals("imanol", usuario3.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		
	}
	
	@Test
	public void testGetCorreo() {
		assertEquals("eizaguirregonzalo@gmail.com", usuario1.getCorreo());
		assertEquals("lufecoba@gmail.com", usuario2.getCorreo());
		assertEquals("imanol@gmail.com", usuario3.getCorreo());
	}
}
