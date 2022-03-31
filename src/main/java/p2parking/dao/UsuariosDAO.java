package p2parking.dao;

import java.util.List;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import p2parking.jdo.Usuario;

public class UsuariosDAO extends DataAccessObjectBase implements iAccesoObjeto<Usuario> {

	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf=null;
	private static UsuariosDAO instance = new UsuariosDAO();
	
	private UsuariosDAO(){
		System.out.println("Constructor UsuariosDAO");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm=pmf.getPersistenceManager();
	}
	
	public static UsuariosDAO getInstance(){
		return instance;
	}
	
	@Override
	public void save(Usuario usuario) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(usuario);
		tx.commit();
		
	}

	@Override
	public void delete(Usuario usuario) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(usuario);
		tx.commit();
		
	}

	@Override
	public List<Usuario> getAll() {
		Transaction tx = pm.currentTransaction();
		List<Usuario> tempUsuario=null;
		try {
		tx.begin();
		Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName());
		tempUsuario = (List<Usuario>)query.execute();
		tx.commit();
		} catch(Exception ex) {
			System.out.println("EXCEPCION AL OBTENER EL USUARIO: \n"+ ex.getMessage());
		}
		return tempUsuario;
	}

	@Override
	public Usuario find(String correo) {
		Transaction tx = pm.currentTransaction();
		List<Usuario> tempUsuario=null;
		try {
		tx.begin();
		Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE correo	 == '" + correo + "'");
		tempUsuario = (List<Usuario>)query.execute();
		tx.commit();
		} catch(Exception ex) {
			System.out.println("EXCEPCION AL OBTENER LA USUARIO: \n"+ ex.getMessage());
		}	
		return tempUsuario.get(0);
	}
}
