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
import org.junit.experimental.categories.Category;

import p2parking.jdo.Incidencia;
import p2parking.testCategories.IntegrationTest;

@Category(IntegrationTest.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class IncidenciaDAOTest {
	
}
