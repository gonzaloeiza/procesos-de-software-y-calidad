package p2parking.dao;

import p2parking.jdo.Alquiler;
import p2parking.jdo.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class AlquilerDAO implements iAccesoObjeto<Alquiler> {
	
	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf=null;
	private static AlquilerDAO instance;	
	
	private AlquilerDAO() {
		System.out.println("Constructor AlquierDAO");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm=pmf.getPersistenceManager();
	}
	
	public static AlquilerDAO getInstance() {
		if (instance == null) {
			instance = new AlquilerDAO();
		}		
		return instance;
	}
	
	public void setPm(PersistenceManager pm) {
		this.pm = pm;
	}
	
    @Override
    public boolean save(Alquiler alquier) {
    	Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(alquier);
		tx.commit();
		return true;
    }

    @Override
    public boolean delete(Alquiler alquier) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(alquier);
		tx.commit();
		return true;
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
    
    @Override
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
