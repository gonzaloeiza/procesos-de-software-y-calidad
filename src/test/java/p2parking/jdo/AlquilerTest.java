package p2parking.jdo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import p2parking.testCategories.UnitTest;

@Category(UnitTest.class)
public class AlquilerTest {
	
	private Alquiler alquiler;
	private Usuario usuario1;
	private Plaza plaza1;
	private Long fecha1;
	
	@Before
	public void setUp() {
		fecha1 = new Date(2022, 07, 14).getTime();
		usuario1 = new Usuario("Endika", "endika.deusto@gmail.com","1234","");
		plaza1 = new Plaza(17.2f, "C/Navarra 3", new ArrayList<String>(), fecha1);
		alquiler = new Alquiler(new Date(2022, 10, 14), new Date(2022, 11, 02), 15.5f, usuario1, plaza1);
	}
	
	@Test
	public void testGetFechaIni() {
		assertEquals(new Date(2022, 10, 14), alquiler.getFechaIni());
	}
	
	@Test
	public void testSetFechaIni() {
		alquiler.setFechaIni(new Date(2022, 05, 22));
		assertEquals(new Date(2022, 05, 22), alquiler.getFechaIni());
	}
	
	@Test
	public void getFechaFin() {
		assertEquals(new Date(2022, 11, 02), alquiler.getFechaFin());
	}
	
	@Test
	public void testSetFechaFin() {
		alquiler.setFechaFin(new Date(2022, 06, 13));
		assertEquals(new Date(2022, 06, 13), alquiler.getFechaFin());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(15.5f, alquiler.getPrecio(), 0);
	}

	@Test
	public void testSetPrecio() {
		alquiler.setPrecio(13.4f);
		assertEquals(13.4f, alquiler.getPrecio(), 0);
		
	}

	@Test
	public void testGetAlquilador() {
		assertEquals(usuario1, alquiler.getAlquilador());
		
	}
	
	@Test
	public void testSetAlquilador() {
		Usuario usuario2 = new Usuario("Lander", "lander.deusto@deusto.es", "222", "");
		alquiler.setAlquilador(usuario2);
		assertEquals(usuario2, alquiler.getAlquilador());
	}

	@Test
	public void testGetPlaza() {
		assertEquals(plaza1, alquiler.getPlaza());
		
		
	}

	@Test
	public void testSetPlaza() {
		Plaza plaza2 = new Plaza(18.6f, "C/Amistad 4", new ArrayList<String>(), fecha1);
		alquiler.setPlaza(plaza2);
		assertEquals(plaza2, alquiler.getPlaza());
	}
	
}