package p2parking.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import p2parking.jdo.Incidencia;
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class IncidenciaDAOTest {

	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	IncidenciaDAO incidenciaDAO;
	
	Incidencia i1;
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
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
