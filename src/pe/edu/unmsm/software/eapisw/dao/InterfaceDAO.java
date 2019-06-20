package pe.edu.unmsm.software.eapisw.dao;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceDAO<E, K> {

    boolean create(E e);

    boolean update(E e);

    ArrayList read();

    E read(K id);

    boolean delete(K codigo);

}
