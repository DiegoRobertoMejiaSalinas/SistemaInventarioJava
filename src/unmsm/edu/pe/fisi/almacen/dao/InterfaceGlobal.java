/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.fisi.almacen.dao;

/**
 *
 * @author Purple
 */
public interface InterfaceGlobal<E, K> {
     boolean create(E e);
     boolean update(E e);
     E read();
     E read(K id);
     boolean delete(K id);
}
