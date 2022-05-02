package p2parking.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Before;
import org.junit.Test;

import p2parking.jdo.Plaza;

public class PlazasDAOTest {
	
	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	PlazasDAO plazasDAO;
	
	Plaza p1;
	
	@Before
	public void setUp() {
		plazasDAO = PlazasDAO.getInstance();
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		when(pm.currentTransaction()).thenReturn(pmf.getPersistenceManager().currentTransaction());
		plazasDAO.setPm(pm);
		
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
	}
	
	@Test
	public void testSave() {
		when(pm.makePersistent(p1)).thenReturn(p1);
		assertTrue(plazasDAO.save(p1));
	}
	
	@Test
	public void testDelete() {
		when(pm.makePersistent(p1)).thenReturn(p1);
		assertTrue(plazasDAO.delete(p1));
	}
	
	@Test
	public void testFind() {
		assertNull(plazasDAO.find(""));
	}
	
	@Test
	public void testFindAll() {
		assertNull(plazasDAO.findAll(""));
	}
}