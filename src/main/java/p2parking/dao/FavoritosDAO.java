package p2parking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import p2parking.jdo.Favorito;
import p2parking.jdo.Usuario;

public class FavoritosDAO extends DataAccessObjectBase implements iAccesoObjeto<Favorito>{

	private static FavoritosDAO instance;	
	
	private FavoritosDAO() { }
	
	public static FavoritosDAO getInstance() {
		if (instance == null) {
			instance = new FavoritosDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Favorito object) {
		super.saveObject(object);
		
	}

	@Override
	public void delete(Favorito object) {
		super.deleteObject(object);		
	}

	@Override
	public List<Favorito> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Favorito> usuarios = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Favorito> userExtent = pm.getExtent(Favorito.class, true);
			
			for (Favorito usuario : userExtent) {
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
	public Favorito find(String param) {//suponiendo param=usr.getEmail();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Favorito result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT * FROM " + Usuario.class.getName() + " WHERE email == '" + param + "'");
			query.setUnique(true);
			result = (Favorito) query.execute();
			
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
