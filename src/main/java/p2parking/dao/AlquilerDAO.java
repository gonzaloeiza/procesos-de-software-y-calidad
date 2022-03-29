package p2parking.dao;

import p2parking.jdo.Alquiler;

import java.util.List;

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

    }

    @Override
    public void delete(Alquiler object) {

    }

    @Override
    public List<Alquiler> getAll() {
        return null;
    }

    @Override
    public Alquiler find(String param) {
        return null;
    }
}
