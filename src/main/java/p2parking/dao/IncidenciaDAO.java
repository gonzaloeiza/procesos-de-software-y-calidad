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
	 /**
	   * Metodo get para conseguir la instancia del IncidenciaDAO
	   * 
	   * @return devuelve una instancia 
	   */  
	public static IncidenciaDAO getInstance() {
		if (instance == null) {
			instance = new IncidenciaDAO();
		}		
		return instance;
	}
	 /**
	   * Metodo para acceder al valor 
	   * 
	   * @param pm la variable de persistenceManager
	   */  
	public void setPm(PersistenceManager pm) {
		this.pm = pm;
	}
   /**
	   * Metodo para guardar 
	   * 
	   * @param incidencia recibe una incidencia 
	   * @return devuelve un boolean true
	   */  	  
    @Override
    public boolean save(Incidencia incidencia) {
    	Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(incidencia);
		tx.commit();
		return true;
    }

    /**
	   * Metodo para eliminar una inicidencia
	   * 
	   * @param incidencia recibe una incidencia 
	   * @return devuelve un boolean true
	   */  
	@Override
	public boolean delete(Incidencia incidencia) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(incidencia);
		tx.commit();
		return true;
	}

	/**
	   * Metodo para eliminar una inicidencia
	   * 
	   */ 
	@Override
	public List<Incidencia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
    /**
	   * Metodo para encontrar todos los alquileres por su email
	   * 
	   * @param param un string que es el email asociado al alquiler que quieres borrar
	   */  
	@Override
	public Incidencia find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	
    /**
	   * Metodo para encontrar todos los alquileres por su email
	   * 
	   * @param param un string que es el email asociado al alquiler que quieres borrar
	   */  	
	@Override
	public List<Incidencia> findAll(String param) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
