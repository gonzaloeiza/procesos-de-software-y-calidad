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
	long fecha1;
	long fecha2;
	long fecha3;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private ArrayList<Usuario> listaFavoritos;
	
	@Before
	public void setUp() {
		fecha1 = new Date(2022, 07, 14).getTime();
		fecha2 = new Date(2022, 02, 22).getTime();
		fecha3 = new Date(2022, 01, 07).getTime();
		plaza1 = new Plaza(13.5f, "C/Iturribide 7", new ArrayList<String>(), fecha1);
		plaza2 = new Plaza(24.2f, "C/Pozas 13", new ArrayList<String>(), fecha2);
		plaza3 = new Plaza(17.7f, "C/Ribera 5", new ArrayList<String>(), fecha3);
		usuario1 = new Usuario("Oier","oier.deusto@opendeusto,es", "1234", "");
		plaza1.setPropietario(usuario1);
		listaFavoritos.add(usuario2);
		listaFavoritos.add(usuario3);
		plaza1.setUsuariosFavoritos(listaFavoritos);
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(13.5f, plaza1.getPrecio());
		assertEquals(24.2f, plaza2.getPrecio());
		assertEquals(17.7f, plaza3.getPrecio());
	}

	@Test
	public void testGetLocalizacion() {
		assertEquals("C/Iturribide 7", plaza1.getLocalizacion());
		assertEquals("C/Pozas 13", plaza2.getLocalizacion());
		assertEquals("C/Ribera 5", plaza3.getLocalizacion());
	}
	
	@Test
	public void testGetFotos() {
		assertEquals(null, plaza1.getFotos());
		assertEquals(null, plaza2.getFotos());
		assertEquals(null, plaza3.getFotos());
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
		assertEquals(19.1f, plaza1.getPrecio());	
	}
	
	@Test
	public void testGetPropietario() {
		assertEquals(usuario1, plaza1.getPropietario());
	}

	@Test
	public void testSetPropietario(Usuario propietario) {
		Usuario usuario2 = new Usuario("Imanol", "imanol@gmail.com", "12345", "");
		plaza1.setPropietario(usuario2);
		assertEquals(usuario2, plaza1.getPropietario());
	}

	@Test
	public void tesGetUsuariosFavoritos() {
		assertEquals(listaFavoritos, plaza1.getUsuariosFavoritos());
	}

	@Test
	public void testSetUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		listaFavoritos.remove(usuario2);
		plaza1.setUsuariosFavoritos(listaFavoritos);
		assertEquals(listaFavoritos, plaza1.getUsuariosFavoritos());
	}

	
	
}