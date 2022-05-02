package p2parking.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Before;
import org.junit.Test;

import p2parking.jdo.Incidencia;

public class IncidenciaDAOTest {

	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	IncidenciaDAO incidenciaDAO;
	
	Incidencia i1;
	
	@Before
	public void setUp() {
		incidenciaDAO = IncidenciaDAO.getInstance();
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		when(pm.currentTransaction()).thenReturn(pmf.getPersistenceManager().currentTransaction());
		incidenciaDAO.setPm(pm);
		
		i1 = new Incidencia("No hay luz", "En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
	}
	
	@Test
	public void testSave() {
		when(pm.makePersistent(i1)).thenReturn(i1);
		assertTrue(incidenciaDAO.save(i1));
	}
	
	@Test
	public void testDelete() {
		when(pm.makePersistent(i1)).thenReturn(i1);
		assertTrue(incidenciaDAO.delete(i1));
	}
	
	@Test
	public void testGetAll() {
		assertNull(incidenciaDAO.getAll());
	}
	
	@Test
	public void testFind() {
		assertNull(incidenciaDAO.find(""));
	}
	
	@Test
	public void testFindAll() {
		assertNull(incidenciaDAO.findAll(""));
	}
}
