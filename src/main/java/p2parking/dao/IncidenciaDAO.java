package p2parking.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import p2parking.jdo.Incidencia;

public class IncidenciaDAO implements iAccesoObjeto<Incidencia> {
	
	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf=null;
	private static IncidenciaDAO instance;	
	
	private IncidenciaDAO() {
		System.out.println("Constructor IncidenciaDAO");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm=pmf.getPersistenceManager();
	}
	
	public static IncidenciaDAO getInstance() {
		if (instance == null) {
			instance = new IncidenciaDAO();
		}		
		return instance;
	}

    @Override
    public boolean save(Incidencia incidencia) {
    	Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(incidencia);
		tx.commit();
		return true;
    }

	@Override
	public boolean delete(Incidencia incidencia) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(incidencia);
		tx.commit();
		return true;
	}

	@Override
	public List<Incidencia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Incidencia> findAll(String param) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
