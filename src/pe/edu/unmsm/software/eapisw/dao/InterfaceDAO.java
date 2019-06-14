package pe.edu.unmsm.software.eapisw.dao;

public interface InterfaceDAO<E, K> {

    boolean create(E e);

    boolean update(E e);

    E read();

    E read(K id);

    boolean delete(K codigo);

}
