package p2parking.dao;

import java.util.List;

import p2parking.jdo.Favoritos;

public class FavoritosDAO extends DataAccessObjectBase implements iAccesoObjeto<Favoritos>{

	private static FavoritosDAO instance;	
	
	private FavoritosDAO() { }
	
	public static FavoritosDAO getInstance() {
		if (instance == null) {
			instance = new FavoritosDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Favoritos object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Favoritos object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Favoritos> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Favoritos find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
