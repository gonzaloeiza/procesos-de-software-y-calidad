package p2parking.jdo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	private List<Plaza> plz1;
	private List<Plaza> plz2;
	private List<Plaza> plz3;
	
	private List<Plaza> fav1;
	private List<Plaza> fav2;
	private List<Plaza> fav3;
	
	private List<Incidencia> inc1;
	private List<Incidencia> inc2;
	private List<Incidencia> inc3;
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	
	@Before
	public void setUp() {
		plz1 = new ArrayList<>();
		plz2 = new ArrayList<>();
		plz3 = new ArrayList<>();
		
		inc1 = new ArrayList<>();
		inc2 = new ArrayList<>();
		inc3 = new ArrayList<>();
		
		fav1 = new ArrayList<>();
		fav2 = new ArrayList<>();
		fav3 = new ArrayList<>();
		
		usuario1 = new Usuario("gonzalo", "eizaguirregonzalo@gmail.com", "1234", "f1", plz1, "11", 10, fav1, inc1);
		usuario2 = new Usuario("javier", "lufecoba@gmail.com", "abcd", "f2", plz2, "22", 9, fav2, inc2);
		usuario3 = new Usuario("imanol", "imanol@gmail.com", "qwer", "f3", plz3, "33", 8, fav3, inc3);
	}
	
	
	@Test
	public void testGetNombre() {
		assertEquals("gonzalo", usuario1.getNombre());
		assertEquals("javier", usuario2.getNombre());
		assertEquals("imanol", usuario3.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		usuario1.setNombre("1");
		usuario2.setNombre("2");
		usuario3.setNombre("3");
		assertEquals("1", usuario1.getNombre());
		assertEquals("2", usuario2.getNombre());
		assertEquals("2", usuario3.getNombre());
		
	}
	
	@Test
	public void testGetCorreo() {
		assertEquals("eizaguirregonzalo@gmail.com", usuario1.getCorreo());
		assertEquals("lufecoba@gmail.com", usuario2.getCorreo());
		assertEquals("imanol@gmail.com", usuario3.getCorreo());
	}
	@Test
	public void testSetCorreo() {
		usuario1.setCorreo("1");
		usuario2.setCorreo("2");
		usuario3.setCorreo("3");		
		assertEquals("1", usuario1.getCorreo());
		assertEquals("2", usuario2.getCorreo());
		assertEquals("3", usuario3.getCorreo());
	}
	
	@Test
	public void testGetContrasena() {
		assertEquals("1234", usuario1.getContrasena());
		assertEquals("abcd", usuario2.getContrasena());
		assertEquals("qwer", usuario3.getContrasena());
	}
	
	@Test
	public void testSetContrasena() {
		usuario1.setCorreo("1");
		usuario2.setCorreo("2");
		usuario3.setCorreo("3");
		assertEquals("1", usuario1.getContrasena());
		assertEquals("2", usuario2.getContrasena());
		assertEquals("3", usuario3.getContrasena());
	}
	@Test
	public void testgetFoto() {
		assertEquals("f1", usuario1.getFoto());
		assertEquals("f2", usuario2.getFoto());
		assertEquals("f3", usuario3.getFoto());
	}
	@Test
	public void testsetFoto() {
		usuario1.setFoto("1");
		usuario2.setFoto("2");
		usuario3.setFoto("3");
		assertEquals("1", usuario1.getFoto());
		assertEquals("2", usuario2.getFoto());
		assertEquals("3", usuario3.getFoto());
	}
	
	@Test
	public void testgetPlazas() {
		assertEquals(plz1, usuario1.getPlazas());
		assertEquals(plz2, usuario2.getPlazas());
		assertEquals(plz3, usuario3.getPlazas());
	}
	@Test
	public void testsetPlazas() {
		ArrayList<Plaza> t1 = new ArrayList<>();
		ArrayList<Plaza> t2 = new ArrayList<>();
		ArrayList<Plaza> t3 = new ArrayList<>();
		
		usuario1.setPlazas(t1);
		usuario2.setPlazas(t2);
		usuario3.setPlazas(t3);
		assertEquals(t1, usuario1.getPlazas());
		assertEquals(t2, usuario2.getPlazas());
		assertEquals(t3, usuario3.getPlazas());
	}
	
	@Test
	public void testgetTelefono() {
		assertEquals("11", usuario1.getTelefono());
		assertEquals("22", usuario2.getTelefono());
		assertEquals("33", usuario3.getTelefono());
	}
	@Test
	public void testsetTelefono() {
		usuario1.setTelefono("1");
		usuario2.setTelefono("2");
		usuario3.setTelefono("3");
		assertEquals("1", usuario1.getTelefono());
		assertEquals("2", usuario2.getTelefono());
		assertEquals("3", usuario3.getTelefono());
	}
	
	@Test
	public void testgetPuntuacion() {
		assertEquals(10, usuario1.getPuntuacion());
		assertEquals(9, usuario2.getPuntuacion());
		assertEquals(8, usuario3.getPuntuacion());
	}
	@Test
	public void testsetPuntuacion() {
		usuario1.setPuntuacion(0);
		usuario2.setPuntuacion(1);
		usuario3.setPuntuacion(2);
		assertEquals(0, usuario1.getPuntuacion());
		assertEquals(1, usuario2.getPuntuacion());
		assertEquals(2, usuario3.getPuntuacion());
	}
	
	@Test
	public void testgetPlazasFavoritos() {
		assertEquals(fav1, usuario1.getPlazasFavoritos());
		assertEquals(fav2, usuario2.getPlazasFavoritos());
		assertEquals(fav3, usuario3.getPlazasFavoritos());
	}
	@Test
	public void testsetPlazasFavoritos() {
		ArrayList<Plaza> t1 = new ArrayList<>();
		ArrayList<Plaza> t2 = new ArrayList<>();
		ArrayList<Plaza> t3 = new ArrayList<>();
		
		usuario1.setPlazasFavoritos(t1);
		usuario2.setPlazasFavoritos(t2);
		usuario3.setPlazasFavoritos(t3);
		assertEquals(t1, usuario1.getPlazasFavoritos());
		assertEquals(t2, usuario2.getPlazasFavoritos());
		assertEquals(t3, usuario3.getPlazasFavoritos());
	}
	
	@Test
	public void testgetIncidencias() {
		assertEquals(inc1, usuario1.getIncidencias());
		assertEquals(inc2, usuario2.getIncidencias());
		assertEquals(inc3, usuario3.getIncidencias());
	}
	@Test
	public void testsetIncidencias() {
		ArrayList<Incidencia> t1 = new ArrayList<>();
		ArrayList<Incidencia> t2 = new ArrayList<>();
		ArrayList<Incidencia> t3 = new ArrayList<>();
		
		usuario1.setIncidencias(t1);
		usuario2.setIncidencias(t2);
		usuario3.setIncidencias(t3);
		assertEquals(t1, usuario1.getIncidencias());
		assertEquals(t2, usuario2.getIncidencias());
		assertEquals(t3, usuario3.getIncidencias());
	}
}
