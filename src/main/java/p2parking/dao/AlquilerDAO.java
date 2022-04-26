package p2parking.dao;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
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
    public Alquiler find(String param) {//suponiendo param =usrAlquilador.getEmail();
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Alquiler devolver = null;
		try {
			tx.begin();
			Alquiler result = null;
			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() +"," + Usuario.class.getName() + " WHERE usuario_email == '" + param + "'");
			query.setUnique(true);
			result = (Alquiler) query.execute();
			try {
				devolver = new Alquiler(result.getFechaIni(), result.getFechaFin(), result.getPrecio(), result.getAlquilador(), result.getPlaza());
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
    
    public ArrayList<Alquiler> findAll(String param) {//suponiendo param =usrAlquilador.getEmail();
    	PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		ArrayList<Alquiler> devolver = new ArrayList<>();
		try {
			tx.begin();
			Alquiler result = null;
			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() +"," + Usuario.class.getName() + " WHERE usuario_email == '" + param + "'");
			query.setUnique(true);
			result = (Alquiler) query.execute();
			try {
				Alquiler temp = new Alquiler(result.getFechaIni(), result.getFechaFin(), result.getPrecio(), result.getAlquilador(), result.getPlaza());
				devolver.add(temp);
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
