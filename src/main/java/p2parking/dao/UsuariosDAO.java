package p2parking.dao;

import p2parking.jdo.Usuario;

import java.util.List;

public class UsuariosDAO extends DataAccessObjectBase implements iAccesoObjeto<Usuario> {
	
	private static UsuariosDAO instance;	
	
	private UsuariosDAO() { }
	
	public static UsuariosDAO getInstance() {
		if (instance == null) {
			instance = new UsuariosDAO();
		}		
		
		return instance;
	}
	
    @Override
    public void save(Usuario object) {

    }

    @Override
    public void delete(Usuario object) {

    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public Usuario find(String param) {
    	
        return null;
    }
}
