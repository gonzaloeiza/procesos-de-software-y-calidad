package p2parking.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IncidenciaTest {
	
	private Incidencia inc;
	private Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario("gonzalo", "eizaguirregonzalo@gmail.com", "1234", "");
		inc = new Incidencia(usuario, "titulo", "mens", false);
		
	}
	
	@Test
	public void testgetUsuario() {
		assertEquals(usuario, inc.getUsuario());
	}
	@Test
	public void tetsetUsuario() {
		Usuario temp = new Usuario("", "", "", "");
		inc.setUsuario(temp);
		assertEquals(temp, inc.getUsuario());
	}
	
	@Test
	public void testgetTitulo() {
		assertEquals("titulo", inc.getTitulo());
	}
	@Test
	public void tetsetTitulo() {
		inc.setTitulo("1");
		assertEquals("1", inc.getTitulo());
	}
	
	@Test
	public void testgetMensage() {
		assertEquals("mens", inc.getMensaje());
		
	}
	@Test
	public void tetsetMensage() {
		inc.setMensaje("1");
		assertEquals("1", inc.getMensaje());
	}
	
	@Test
	public void testgetResuelto() {
		assertFalse(inc.isResuelto());
		
	}
	@Test
	public void tetsetResuelto() {
		inc.setResuelto(true);
		assertTrue(inc.isResuelto());
	}
}