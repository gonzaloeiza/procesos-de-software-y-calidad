package p2parking.dao;

import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PlazasDAO extends DataAccessObjectBase implements iAccesoObjeto<Plaza> {
<<<<<<< HEAD

    private static PlazasDAO instance;

    private PlazasDAO () { }

    public static PlazasDAO getInstance() {
        if (instance == null) {
            instance = new PlazasDAO();
        }
        return instance;
    }

=======
	
	private static PlazasDAO instance;	
	
	private PlazasDAO() { }
	
	public static PlazasDAO getInstance() {
		if (instance == null) {
			instance = new PlazasDAO();
		}		
		
		return instance;
	}
	
>>>>>>> refs/remotes/origin/master
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
    public Plaza find(String param) {//suponiendo param = usr.getEmail();
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Plaza devolver = null;
		try {
			tx.begin();
			Plaza result = null;
			Query<?> query = pm.newQuery("SELECT FROM " + Plaza.class.getName() +"," + Usuario.class.getName() + " WHERE usuario_email == '" + param + "'");
			query.setUnique(true);
			result = (Plaza) query.execute();
			try {
				devolver = new Plaza(result.getPrecio(), result.getLocalizacion(), result.getFotos());
			} catch(Exception e) {}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Plaza: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return devolver;    	
    }
}
