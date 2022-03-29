package p2parking.dao;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

public class AlquilerDAO extends DataAccessObjectBase implements iAccesoObjeto<Alquiler> {
	
	private static AlquilerDAO instance;	
	
	private AlquilerDAO() { }
	
	public static AlquilerDAO getInstance() {
		if (instance == null) {
			instance = new AlquilerDAO();
		}		
		
		return instance;
	}
	
    @Override
    public void save(Alquiler object) {
    	super.saveObject(object);
    }

    @Override
    public void delete(Alquiler object) {
    	super.deleteObject(object);
    }

    @Override
    public List<Alquiler> getAll() {
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Alquiler> alquileres = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Alquiler> alquilerExtent = pm.getExtent(Alquiler.class, true);
			
			for (Alquiler alquiler : alquilerExtent) {
				alquileres.add(alquiler);
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

		return alquileres;
	}

    @Override
    public Alquiler find(String param) {
        return null;
    }
}
