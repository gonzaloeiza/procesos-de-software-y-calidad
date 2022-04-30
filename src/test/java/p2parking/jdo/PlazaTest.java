package p2parking.jdo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlazaTest {
	
	private Plaza plaza1;
	private Plaza plaza2;
	private Plaza plaza3;
	private long fecha1;
	private long fecha2;
	private long fecha3;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private List<Usuario> listaFavoritos;
	
	@Before
	public void setUp() {
		fecha1 = new Date(2022, 07, 14).getTime();
		fecha2 = new Date(2022, 02, 22).getTime();
		fecha3 = new Date(2022, 01, 07).getTime();
		plaza1 = new Plaza(13.5f, "C/Iturribide 7", new ArrayList<String>(), fecha1);
		plaza2 = new Plaza(24.2f, "C/Pozas 13", new ArrayList<String>(), fecha2, "Plaza Paco", "Plaza Amplia", true);
		plaza3 = new Plaza(17.7f, "C/Ribera 5", new ArrayList<String>(), fecha3);
		usuario1 = new Usuario("Oier","oier.deusto@opendeusto,es", "1234", "");
		usuario2 = new Usuario("Lander","l.deusto@opendeusto,es", "1234", "");
		usuario3 = new Usuario("Gonzalo","g.deusto@opendeusto,es", "1234", "");
		plaza1.setPropietario(usuario1);
		listaFavoritos = new ArrayList<Usuario>();
		listaFavoritos.add(usuario2);
		listaFavoritos.add(usuario3);
		plaza1.setUsuariosFavoritos(listaFavoritos);
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(13.5f, plaza1.getPrecio(),0);
		assertEquals(24.2f, plaza2.getPrecio(),0);
		assertEquals(17.7f, plaza3.getPrecio(),0);
	}

	@Test
	public void testGetLocalizacion() {
		assertEquals("C/Iturribide 7", plaza1.getLocalizacion());
		assertEquals("C/Pozas 13", plaza2.getLocalizacion());
		assertEquals("C/Ribera 5", plaza3.getLocalizacion());
	}
	
	@Test
	public void testGetFotos() {
		assertEquals(new ArrayList<String>(), plaza1.getFotos());
		assertEquals(new ArrayList<String>(), plaza2.getFotos());
		assertEquals(new ArrayList<String>(), plaza3.getFotos());
	}

	@Test
	public void testGetFechaPublicacion() {
		assertEquals(fecha1, plaza1.getFechaPublicacion());
		assertEquals(fecha2, plaza2.getFechaPublicacion());
		assertEquals(fecha3, plaza3.getFechaPublicacion());
	}
	
	@Test
	public void testSetLocalizacion() {
		plaza1.setLocalizacion("C/Gran Via 4");
		assertEquals("C/Gran Via 4", plaza1.getLocalizacion());	
	}

	@Test
	public void testSetFotos() {
		ArrayList<String> fotos = new ArrayList<>();
		fotos.add("aaa");
		plaza1.setFotos(fotos);
		assertEquals(fotos, plaza1.getFotos());
	}

	@Test
	public void testSetFechaPublicacion() {
		long fecha = new Date(2022, 11, 25).getTime();
		plaza1.setFechaPublicacion(fecha);
		assertEquals(fecha, plaza1.getFechaPublicacion());	
	}

	@Test
	public void testSetPrecio() {
		plaza1.setPrecio(19.1f);
		assertEquals(19.1f, plaza1.getPrecio(),0);	
	}
	
	@Test
	public void testGetPropietario() {
		assertEquals(usuario1, plaza1.getPropietario());
	}

	@Test
	public void testSetPropietario() {
		Usuario usuario2 = new Usuario("Imanol", "imanol@gmail.com", "12345", "");
		plaza1.setPropietario(usuario2);
		assertEquals(usuario2, plaza1.getPropietario());
	}

	@Test
	public void tesGetUsuariosFavoritos() {
		assertEquals(listaFavoritos, plaza1.getUsuariosFavoritos());
	}

	@Test
	public void testSetUsuariosFavoritos() {
		listaFavoritos.remove(usuario2);
		plaza1.setUsuariosFavoritos(listaFavoritos);
		assertEquals(listaFavoritos, plaza1.getUsuariosFavoritos());
	}
	
	@Test 
	public void testSetDescripcion() {
		plaza2.setDescripcion("Plaza para 2 coches");
		assertEquals("Plaza para 2 coches", plaza2.getDescripcion());
		
		
	}
	@Test
	public void testSetTitulo() {
		plaza2.setTitulo("Plaza Gonzalo");
		assertEquals("Plaza Gonzalo", plaza2.getTitulo());
	}
	
	@Test 
	public void testSetSeguro() {
		plaza2.setSeguro(false);
		assertEquals(false, plaza2.isSeguro());
		
	}
	
	@Test 
	public void testIsSeguro() {
		assertEquals(true, plaza2.isSeguro());
	}
	
	@Test
	public void testGetTitulo() {
		assertEquals("Plaza Paco", plaza2.getTitulo());
		
	}
	
	@Test 
	public void testGetDescripcion() {
		assertEquals("Plaza Amplia", plaza2.getDescripcion());
		
		
	}
	

	
	
}