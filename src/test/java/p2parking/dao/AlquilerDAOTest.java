package p2parking.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Before;
import org.junit.Test;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

public class AlquilerDAOTest {
	
	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	AlquilerDAO alquilerDAO;
	
	Usuario u1;
	Plaza p1;
	Alquiler a1;
	
	@Before
	public void setUp() {
		alquilerDAO = AlquilerDAO.getInstance();
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		when(pm.currentTransaction()).thenReturn(pmf.getPersistenceManager().currentTransaction());
		alquilerDAO.setPm(pm);
		
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		a1 = new Alquiler(new Date(2000, 03, 15), new Date(2000, 03, 15), 0, u1, p1);
	}
		
	@Test
	public void testSave() {
		when(pm.makePersistent(a1)).thenReturn(a1);
		assertTrue(alquilerDAO.save(a1));
	}
	
	@Test
	public void testDelete() {
		when(pm.makePersistent(a1)).thenReturn(a1);
		assertTrue(alquilerDAO.delete(a1));
	}
}