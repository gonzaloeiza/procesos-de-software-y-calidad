package p2parking.jdo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
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
	public void testNombre() {
		
		usuario1.setNombre("001");
		usuario2.setNombre("asdfsafdsafkjhsan kaslkjdflksjf lkasjdlfjlñajfsa jsadñls alñjasñldfjañls jf");
		usuario3.setNombre("");
		
		assertEquals("001", usuario1.getNombre());
		assertEquals("asdfsafdsafkjhsan kaslkjdflksjf lkasjdlfjlñajfsa jsadñls alñjasñldfjañls jf", usuario2.getNombre());
		assertEquals("", usuario3.getNombre());
	}
	
	@Test
	public void testContrasena() {
		
		usuario1.setContrasena("001");
		usuario2.setContrasena("asdfsafdsafkjhsan kaslkjdflksjf lkasjdlfjlñajfsa jsadñls alñjasñldfjañls jf");
		
		assertEquals("001", usuario1.getContrasena());
		assertEquals("asdfsafdsafkjhsan kaslkjdflksjf lkasjdlfjlñajfsa jsadñls alñjasñldfjañls jf", usuario2.getContrasena());
	}
	
	@Test
	public void testCorreo() {
		
		usuario1.setCorreo("eizaguirregonzalo@gmail.com");
		usuario2.setCorreo("lufecoba@gmail.com");
		usuario3.setCorreo("imanol@gmail.com");
		
		assertEquals("eizaguirregonzalo@gmail.com", usuario1.getCorreo());
		assertEquals("lufecoba@gmail.com", usuario2.getCorreo());
		assertEquals("imanol@gmail.com", usuario3.getCorreo());
	}
	
	@Test
	public void testFotos() {
		
		usuario1.setFoto("f1");
		usuario2.setFoto("f2");
		usuario3.setFoto("f3");
		
		assertEquals("f1", usuario1.getFoto());
		assertEquals("f2", usuario2.getFoto());
		assertEquals("f3", usuario3.getFoto());
	}
	
	@Test
	public void testPlazas() {
		
		usuario1.setPlazas(new ArrayList<Plaza>());
		usuario2.setPlazas(new ArrayList<Plaza>());
		usuario3.setPlazas(new ArrayList<Plaza>());
		
		assertEquals(0, usuario1.getPlazas().size());
		assertEquals(0, usuario2.getPlazas().size());
		assertEquals(0, usuario3.getPlazas().size());
		
		Plaza p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
	    Plaza p2 = new Plaza(12.2f, "", new ArrayList<String>(),  new Date(2000, 03, 15).getTime());
	    Plaza p3 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());  
		
		usuario1.addPlaza(p1);
		usuario1.addPlaza(p2);
		usuario2.addPlaza(p3);
		
		assertEquals(2, usuario1.getPlazas().size());
		assertEquals(1, usuario2.getPlazas().size());
		
		
	}
	
	
}
