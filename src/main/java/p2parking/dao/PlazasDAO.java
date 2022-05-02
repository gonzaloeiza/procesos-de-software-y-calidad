package p2parking.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.datanucleus.store.Extent;

import p2parking.jdo.Plaza;

public class PlazasDAO implements iAccesoObjeto<Plaza>{

	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf=null;
	private static PlazasDAO instance;
	
	private PlazasDAO(){
		System.out.println("Constructor PlazasDAO");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm=pmf.getPersistenceManager();
	}
	
	public static PlazasDAO getInstance(){
		if(instance == null) {
			instance = new PlazasDAO();
		}
		return instance;
	}
	
	public void setPm(PersistenceManager pm) {
		this.pm = pm;
	}
	
	@Override
	public boolean save(Plaza plaza) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(plaza);
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(Plaza plaza) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(plaza);
		tx.commit();
		return true;
		
	}

	@Override
	public ArrayList<Plaza> getAll() {
		Transaction tx = pm.currentTransaction();
		List<Plaza> tempPlaza = null;
		ArrayList<Plaza> aDevolver = new ArrayList<Plaza>();
		try {
			tx.begin();
			Query query = pm.newQuery("SELECT FROM " + Plaza.class.getName());
			tempPlaza = (List<Plaza>) query.execute();
			tx.commit();
		} catch(Exception ex) {
			//System.out.println("EXCEPCION AL OBTENER LA PLAZA: \n"+ ex.getMessage());
		}
		
		for (int x=0; x<tempPlaza.size(); x++) {
			aDevolver.add(tempPlaza.get(x));
		}
		return aDevolver;
	}

	@Override
	public Plaza find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Plaza> findPlazasDeUsuario(String correo) {
		Transaction tx = pm.currentTransaction();
		List<Plaza> tempPlaza = null;
		try {
		tx.begin();
		Query query = pm.newQuery("SELECT FROM " + Plaza.class.getName() + " WHERE propietario.correo == '" + correo + "'");
		tempPlaza = (List<Plaza>)query.execute();
		tx.commit();
		} catch(Exception ex) {
			System.out.println("EXCEPCION AL OBTENER LA PLAZA: \n"+ ex.getMessage());
		}
		return tempPlaza;
	}

	@Override
	public List<Plaza> findAll(String param) {
		// TODO Auto-generated method stub
		return null;
	}
}
