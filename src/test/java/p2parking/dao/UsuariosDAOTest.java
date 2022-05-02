package p2parking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.Test;

import p2parking.jdo.Usuario;

public class UsuariosDAOTest {
	
	PersistenceManager pm;
	PersistenceManagerFactory pmf;
	UsuariosDAO usuariosDAO;
	
	Usuario u1;
	Usuario u2;
	
	@Before
	public void setUp() {
		usuariosDAO = UsuariosDAO.getInstance();
		pm = org.mockito.Mockito.mock(PersistenceManager.class);
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		when(pm.currentTransaction()).thenReturn(pmf.getPersistenceManager().currentTransaction());
		usuariosDAO.setPm(pm);
		
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		u2 = new Usuario("javier", "javier@gmail.com", "1234", "ss");
		
	}
	
	@Test
	public void testSave() {
		when(pm.makePersistent(u1)).thenReturn(u1);
		assertTrue(usuariosDAO.save(u1));
	}
	
	@Test
	public void testDelete() {
		when(pm.makePersistent(u1)).thenReturn(u1);
		assertTrue(usuariosDAO.delete(u1));
	}
	
	@Test
	public void testGetAll() {
//		List<Usuario> tempUsuario = new ArrayList<Usuario>();
//		tempUsuario.add(u1);
//		tempUsuario.add(u2);
//		when(pm.newQuery("SELECT FROM " + Usuario.class.getName()).execute()).thenReturn(tempUsuario);
		
		
	}
}