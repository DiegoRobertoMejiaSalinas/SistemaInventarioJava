package pe.edu.unmsm.software.eapisw.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.InterfaceDAO;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;
import pe.edu.unmsm.software.eapisw.structure.ArbolBinario;
import pe.edu.unmsm.software.eapisw.structure.ArbolRojoNegro;
import pe.edu.unmsm.software.eapisw.structure.Cola;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class ProductoDAOImpl implements InterfaceDAO<Producto, String> {

    PreparedStatement ps;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    ArrayList<Producto> arrayList;
    ArbolAVL<Producto> arbolAVL;
    ArbolAVL.NodoAVL raiz;
    ArbolBinario<Producto> arbolABB;
    ArbolRojoNegro<Producto> arbolRN;
    Cola<Producto> cola;
    ListaDoble<Producto> listaDoble;

    public ProductoDAOImpl() {
        acceso = new AccesoDB();
        arrayList = new ArrayList<>();
        arbolAVL = new ArbolAVL<>();
        raiz = null;
        arbolABB = new ArbolBinario<>();
        arbolRN = new ArbolRojoNegro<>();
        cola = new Cola<>();
        listaDoble = new ListaDoble<>();
    }

    @Override
    public boolean create(Producto producto) {
        boolean resultado = true;
        try {
            conexion = acceso.getConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el producto, intentelo nuevamente.");
        }

        return resultado;
    }

    @Override
    public boolean update(Producto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Producto readArbolABB(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Producto readArbolAVL(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Producto readArbolRN(String id){
        return null;
    }

    @Override
    public boolean delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList read() {
        String query = "Select * from Producto";
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                arrayList.add(producto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            arrayList = null;
        }

        return arrayList;
    }

    public ArbolAVL readArbolAVL() {
        String query = "Select * from Producto";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                arbolAVL.insertar(raiz, producto);
            }

        } catch (SQLException e) {
            arbolAVL = null;
        }
        return arbolAVL;
    }

    public ArbolBinario readArbolABB() {
        String query = "Select * from Producto";
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                arbolABB.insertar(producto);
            }

        } catch (SQLException e) {
            arbolABB = null;
        }
        return arbolABB;
    }

    public ArbolRojoNegro readArbolRojoNegro() throws Exception {
        String query = "Select * from Producto";
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                arbolRN.insertar(producto);
            }
        } catch (SQLException e) {
            arbolRN = null;
        }
        return arbolRN;
    }

    public Cola readCola() {

        String query = "Select * from Producto";
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                cola.encolar(producto);
            }

        } catch (SQLException e) {
            cola = null;
        }
        return cola;
    }

    public ListaDoble readListaDoble() {
        String query = "Select * from Producto";
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                listaDoble.insertarAlFinal(producto);
            }

        } catch (SQLException e) {
            listaDoble = null;
        }
        return listaDoble;
    }

}
