package p2parking.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import p2parking.jdo.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AlquilerDAOTest {
	
	@Mock
	AlquilerDAO alqDAO; 
	Usuario u1;
	Plaza p1;
	Alquiler a;
	ArrayList<Alquiler> la;
	
	@Before
	public void setUp() {
		alqDAO = org.mockito.Mockito.mock(AlquilerDAO.class);
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());		    
		a = new Alquiler(new Date(), new Date(), 4, u1, p1);
		la = new ArrayList<>(); la.add(a);
	}
		
	@Test
	public void testSave() {
		when(alqDAO.save(a)).thenReturn(true);
		assertEquals(alqDAO.save(a), true);
	}
	
	@Test
	public void testDelete() {
		when(alqDAO.delete(a)).thenReturn(true);
		assertEquals(alqDAO.delete(a), true);
	}
	
	@Test
	public void testGetAll() {
		when(alqDAO.getAll()).thenReturn(la);
		assertEquals(alqDAO.getAll().get(0), la.get(0));
	}
	
	@Test
	public void testFind() {
		when(alqDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(a);
		assertEquals(alqDAO.find(a.getAlquilador().getCorreo()), a);
	}
	
	@Test
	public void testFindAll() {
		when(alqDAO.findAll("gonzaloeizaguirre@opendeusto.es")).thenReturn(la);
		assertEquals(alqDAO.findAll(a.getAlquilador().getCorreo()), la);
	}
}