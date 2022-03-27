package p2parking.dao;

import p2parking.jdo.Plaza;

import java.util.List;

public class PlazasDAO extends DataAccessObjectBase implements iAccesoObjeto<Plaza> {

    private static PlazasDAO instance;

    private PlazasDAO () { }

    public static PlazasDAO getInstance() {
        if (instance == null) {
            instance = new PlazasDAO();
        }
        return instance;
    }

    @Override
    public void save(Plaza object) {

    }

    @Override
    public void delete(Plaza object) {

    }

    @Override
    public List<Plaza> getAll() {
        return null;
    }

    @Override
    public Plaza find(String param) {
        return null;
    }
}
