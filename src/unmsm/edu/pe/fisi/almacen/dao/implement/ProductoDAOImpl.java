package unmsm.edu.pe.fisi.almacen.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import unmsm.edu.pe.fisi.almacen.dao.AccesoDB;
import unmsm.edu.pe.fisi.almacen.dao.InterfaceGlobal;
import unmsm.edu.pe.fisi.almacen.model.Producto;
import unmsm.edu.pe.fisi.almacen.structure.ListaDoble;

public class ProductoDAOImpl implements InterfaceGlobal<ListaDoble<Producto>, Integer> {

    PreparedStatement ps;
    ResultSet rs;
    Connection conexion;
    AccesoDB acceso;

    ListaDoble<Producto> nuevo;

    public ProductoDAOImpl() {
        nuevo = new ListaDoble<>();
        acceso = new AccesoDB();
    }

    @Override
    public boolean create(ListaDoble<Producto> e) {
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?)");
            //Indicamos los parametros para la consulta

            ps.setString(2, e.getUltimo().getDato().getNombre());
            ps.setString(3, e.getUltimo().getDato().getCodigo());
            ps.setInt(4, e.getUltimo().getDato().getStock());
            ps.setFloat(5, e.getUltimo().getDato().getPrecioCompra());
            ps.setFloat(6, e.getUltimo().getDato().getPrecioVenta());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean createProducto(Producto e) {
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?)");
            //Indicamos los parametros para la consulta

            ps.setString(2, e.getNombre());
            ps.setString(3, e.getCodigo());
            ps.setInt(4, e.getStock());
            ps.setFloat(5, e.getPrecioCompra());
            ps.setFloat(6, e.getPrecioVenta());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean update(Producto actualizado) {
        boolean resultado = true;
        conexion = acceso.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE productos "
                    + "SET nombre = ?, codigo = ?, stock = ?,"
                    + " precioCompra = ?, precioVenta = ?"
                    + "WHERE codigo = ?");
            ps.setString(2, actualizado.getNombre());
            ps.setString(3, actualizado.getCodigo());
            ps.setInt(4, actualizado.getStock());
            ps.setFloat(5, actualizado.getPrecioCompra());
            ps.setFloat(5, actualizado.getPrecioVenta());
            ps.setString(6, actualizado.getCodigo());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(ListaDoble<Producto> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Producto readL(String cod) {
        Producto producto = null;

        try {
            conexion = acceso.getConnection();
            ps = conexion.prepareStatement("Select * from productos where codigo= ?");
            ps.setString(3, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String codigo = rs.getString("codigo");
                int stock = rs.getInt("stock");
                float precioCompra = rs.getFloat("precioCompra");
                float precioVenta = rs.getFloat("precioVenta");

                producto = new Producto(nombre, codigo, stock, precioCompra, precioVenta);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return producto;
    }

    @Override
    public ListaDoble<Producto> read() {
        try {
            //Obtenemos la conexion
            conexion = acceso.getConnection();
            Statement st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM productos");

            while (rs.next()) {

                //Leeemos de la bd
                String nombre = rs.getString("nombre");
                String codigo = rs.getString("codigo");
                int stock = rs.getInt("stock");
                float precioCompra = rs.getFloat("precioCompra");
                float precioVenta = rs.getFloat("precioVenta");

                
                Producto productoB= new Producto(nombre, codigo, stock, precioCompra, precioVenta);
                nuevo.insertarAlFinal(productoB);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nuevo;
    }

    @Override
    public ListaDoble<Producto> read(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
