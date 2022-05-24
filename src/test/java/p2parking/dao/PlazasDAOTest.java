package p2parking.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import p2parking.jdo.Plaza;
import p2parking.testCategories.IntegrationTest;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
@Category(IntegrationTest.class)
public class PlazasDAOTest {

	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	PlazasDAO plazasDAO;

	Plaza p1;

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

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