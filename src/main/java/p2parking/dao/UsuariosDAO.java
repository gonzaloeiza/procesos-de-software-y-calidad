package p2parking.dao;

import java.util.List;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import p2parking.jdo.Usuario;

public class UsuariosDAO implements iAccesoObjeto<Usuario> {

	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf=null;
	private static UsuariosDAO instance;
	
	public UsuariosDAO(){
		System.out.println("Constructor UsuariosDAO");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm=pmf.getPersistenceManager();
	}
	
	public static UsuariosDAO getInstance(){
		if(instance == null) {
			instance =  new UsuariosDAO();
		}
		return instance;
	}
	
	public void setPm(PersistenceManager pm) {
		this.pm = pm;
	}
	
	/**
	 * Metodo para guardar un usuario
	 * 
	 * @param usuario la plaza que quieres guardar
	 * @return devuelve un boolean true
	 */
	@Override
	public boolean save(Usuario usuario) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(usuario);
		tx.commit();
		return true;
		
	}
	/**
	 * Metodo para guardar un usuario
	 * 
	 * @param usuario la plaza que quieres guardar
	 * @return devuelve un boolean true
	 */
	@Override
	public boolean delete(Usuario usuario) {
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.deletePersistent(usuario);
		tx.commit();
		return true;
		
	}
	/**
	 * Metodo para una lista de todos los usuarios
	 * 
	 * @return devuelve una lista de todas los usuarios
	 */
	@Override
	public List<Usuario> getAll() {
		Transaction tx = pm.currentTransaction();
		List<Usuario> tempUsuario=null;
		try {
		tx.begin();
		Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName());
		System.out.println(query);
		tempUsuario = (List<Usuario>)query.execute();
		System.out.println(query.execute());
		tx.commit();
		} catch(Exception ex) {
			System.out.println("EXCEPCION AL OBTENER EL USUARIO: \n"+ ex.getMessage());
		}
		return tempUsuario;
	}
	/**
	 * Metodo para econtrar un usuario por su correo
	 * 
	 * @param correo el correo que quieres buscar su usuario
	 * @return devuelve un usuario
	 */
	@Override
	public Usuario find(String correo) {
		Transaction tx = pm.currentTransaction();
		Usuario tempUsuario = null;
		try {
		tx.begin();
		Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE correo	 == '" + correo + "'");
		query.setUnique(true);
		tempUsuario = (Usuario)query.execute();
		tx.commit();
		} catch(Exception ex) {
			System.out.println("EXCEPCION AL OBTENER LA USUARIO: \n"+ ex.getMessage());
		}	
		return tempUsuario;
	}
	/**
	 * Metodo para encontrar plazas las plzas asociadas a un correo
	 * 
	 * @param param el correo que quieres ver los usuarios
	 */
	@Override
	public List<Usuario> findAll(String param) {
		// TODO Auto-generated method stub
		return null;
	}
}
