package p2parking.dao;

import p2parking.jdo.Plaza;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PlazasDAO extends DataAccessObjectBase implements iAccesoObjeto<Plaza> {
	
	private static PlazasDAO instance;	
	
	private PlazasDAO() { }
	
	public static PlazasDAO getInstance() {
		if (instance == null) {
			instance = new PlazasDAO();
		}		
		
		return instance;
	}
	

    @Override
    public void save(Plaza object) {
    	super.saveObject(object);
    }

    @Override
    public void delete(Plaza object) {
    	super.deleteObject(object);
    }

    @Override
    public List<Plaza> getAll() {
    	
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Plaza> articles = new ArrayList<>();
		
		try {
			tx.begin();
				
			Extent<Plaza> extent = pm.getExtent(Plaza.class, true);
			for (Plaza category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Plazas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return articles;
    }

    @Override
    public Plaza find(String param) {
    	//funcion no necesaria
    	return null;
    }
    
    public List<Plaza> findPlazasDeUsuario(String correo) {
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Plaza> plazasUsuario = new ArrayList<Plaza>();

		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Plaza.class.getName() + " WHERE propietario.correo == '" + correo + "'");
			plazasUsuario = (List<Plaza>) query.executeList();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying user's plazas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
    	
    	return plazasUsuario;
    }

}
