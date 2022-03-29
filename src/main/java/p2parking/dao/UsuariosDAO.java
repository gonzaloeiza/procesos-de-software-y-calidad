package p2parking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import p2parking.jdo.Usuario;

public class UsuariosDAO extends DataAccessObjectBase implements iAccesoObjeto<Usuario> {
	
	private static UsuariosDAO instance;	
	
	private UsuariosDAO() { }
	
	public static UsuariosDAO getInstance() {
		if (instance == null) {
			instance = new UsuariosDAO();
		}		
		
		return instance;
	}
	
    @Override
    public void save(Usuario object) {
    	super.saveObject(object);
    }

    @Override
    public void delete(Usuario object) {
    	super.deleteObject(object);
    }

    @Override
    public List<Usuario> getAll() {
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Usuario> usuarios = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Usuario> userExtent = pm.getExtent(Usuario.class, true);
			
			for (Usuario usuario : userExtent) {
				usuarios.add(usuario);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}

    @Override
    public Usuario find(String correo) {
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Usuario result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT * FROM " + Usuario.class.getName() + " WHERE email == '" + correo + "'");
			query.setUnique(true);
			result = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
}
