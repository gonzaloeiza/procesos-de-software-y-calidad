package p2parking.jdo;


import java.util.List;

public interface iAccesoObjeto<DomainObject> {
    public void save(DomainObject object);
    public void delete(DomainObject object);
    public List<DomainObject> getAll();
    public DomainObject find(String param);
}
