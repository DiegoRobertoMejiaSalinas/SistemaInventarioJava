package unmsm.edu.pe.fisi.almacen.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unmsm.edu.pe.fisi.almacen.dao.AccesoDB;
import unmsm.edu.pe.fisi.almacen.dao.InterfaceGlobal;
import unmsm.edu.pe.fisi.almacen.model.Cliente;
import unmsm.edu.pe.fisi.almacen.model.Trabajador;
import unmsm.edu.pe.fisi.almacen.structure.ArbolBinario;
import unmsm.edu.pe.fisi.almacen.structure.Cola;
import unmsm.edu.pe.fisi.almacen.structure.ListaDoble;

public class ClienteDAOImpl implements InterfaceGlobal<ArbolBinario<Cliente>, String> {

    PreparedStatement ps;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    ArbolBinario<Trabajador> nuevo;

    @Override
    public boolean create(ArbolBinario<Cliente> arbol) {
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            int cont = 1;
            while (cont != arbol.getLongitud()) {
                ps = conexion.prepareStatement("INSERT INTO venta VALUES(?,?,?)");
                //Indicamos los parametros para la consulta
                ps.setString(2, arbol.getMayor().getDato().getNombre());
                ps.setString(3, arbol.getMayor().getDato().getDni());
                ps.setString(4, arbol.getMayor().getDato().getProductos().getCabecera().getDato().getNombre());
                cont++;
                arbol.getMayor().getDato().getProductos().setCabecera(arbol.getMayor().getDato().getProductos().getCabecera().getSgte());
                ps.execute();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean createCliente(Cliente cliente) {
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            int cont = 1;
            while (cliente.getProductos().getCabecera() != null) {
                ps = conexion.prepareStatement("INSERT INTO trabajador VALUES(?,?,?)");
                //Indicamos los parametros para la consulta
                ps.setString(2, cliente.getNombre());
                ps.setString(3, cliente.getDni());
                ps.setString(4, cliente.getProductos().getCabecera().getDato().getNombre());
                cont++;
                cliente.getProductos().setCabecera(cliente.getProductos().getCabecera().getSgte());
                ps.execute();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(ArbolBinario<Cliente> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArbolBinario<Cliente> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArbolBinario<Cliente> read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
