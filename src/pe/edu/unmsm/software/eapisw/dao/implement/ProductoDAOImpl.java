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
import pe.edu.unmsm.software.eapisw.service.ProductoService.ProductoComparatorCodigo;
import pe.edu.unmsm.software.eapisw.service.ProductoService.ProductoComparatorID;
import pe.edu.unmsm.software.eapisw.service.ProductoService.ProductoComparatorNombre;
import pe.edu.unmsm.software.eapisw.service.ProductoService.ProductoComparatorPrecioVenta;
import pe.edu.unmsm.software.eapisw.service.ProductoService.ProductoComparatorStock;
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
    ArbolRojoNegro.NodoRojoNegro raizRN;
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
        String query = "INSERT INTO PRODUCTO (codigo, nombre, descripcion, caracteristicas, stock, precio_venta)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getCaracteristicas());
            ps.setInt(5, producto.getStock());
            ps.setDouble(6, producto.getPrecio_venta());

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Producto creado con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el producto, intentelo nuevamente.");
        }

        return resultado;
    }

    @Override
    public boolean update(Producto producto) {
        String query = "UPDATE PRODUCTO SET codigo=?, nombre=?, descripcion= ?, caracteristicas= ?, stock= ?, precio_venta= ? "
                + "WHERE idproducto= ?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getCaracteristicas());
            ps.setInt(5, producto.getStock());
            ps.setDouble(6, producto.getPrecio_venta());
            ps.setInt(7, producto.getIdProducto());

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Producto editado con éxito.");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo editar el producto, intentelo nuevamente.");
        }

        return false;
    }

    @Override
    public Producto read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Producto readArbolABB(String id) {
        return null;
    }

    /*public Producto readArbolAVL(String id) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }*/
    public Producto readArbolRN(String id) {
        return null;
    }

    @Override
    public boolean delete(String codigo) {
        String query = "DELETE from Producto WHERE codigo='" + codigo + "'";
        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            int n = ps.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto, intentelo nuevamente.");
        }

        return false;
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
                producto.setIdProducto(rs.getInt(1));
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
                producto.setIdProducto(rs.getInt(1));
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

    public ArbolAVL readArbolAVL(String com) {
        if (com.equalsIgnoreCase("precio")) {
            ProductoComparatorPrecioVenta cpm = new ProductoComparatorPrecioVenta();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("codigo")) {
            ProductoComparatorCodigo cpm = new ProductoComparatorCodigo();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("nombre")) {
            ProductoComparatorNombre cpm = new ProductoComparatorNombre();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("stock")) {
            ProductoComparatorStock cpm = new ProductoComparatorStock();
            arbolAVL.setComparador(cpm);
        } else {
            ProductoComparatorID cpm = new ProductoComparatorID();
            arbolAVL.setComparador(cpm);
        }

        String query = "Select * from Producto";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                arbolAVL.insertar(producto);
            }

        } catch (SQLException e) {
            arbolAVL = null;
        }
        return arbolAVL;
    }

    public ArbolRojoNegro readArbolRojoNegro(String com) {

        String query = "Select * from Producto";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
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
                producto.setIdProducto(rs.getInt(1));
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
                producto.setIdProducto(rs.getInt(1));
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCaracteristicas(rs.getString(5));
                producto.setStock(rs.getInt(6));
                producto.setPrecio_venta(rs.getDouble(7));

                listaDoble.setLast(producto);
            }

        } catch (SQLException e) {
            listaDoble = null;
        }
        return listaDoble;
    }

}
