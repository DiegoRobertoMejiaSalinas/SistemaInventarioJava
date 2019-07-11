package pe.edu.unmsm.software.eapisw.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.InterfaceDAO;
import pe.edu.unmsm.software.eapisw.model.Consumo;
import pe.edu.unmsm.software.eapisw.structure.ArbolRojoNegro;

public class ConsumoDAOImpl implements InterfaceDAO<Consumo, String> {

    PreparedStatement ps;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    public Double totalConsumo = 0.0;

    ArrayList<Consumo> arrayList;

    public ConsumoDAOImpl() {
        acceso = new AccesoDB();
        arrayList = new ArrayList<>();
    }

    @Override
    public boolean create(Consumo consumo) {
        String query = "INSERT INTO Consumo (idventa, idproducto, cantidad, precio_venta) "
                + "VALUES (?, ?, ?, ?)";
        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            ps.setInt(1, consumo.getIdVenta());
            ps.setInt(2, consumo.getIdProducto());
            System.out.println("IDProducto: "+consumo.getIdProducto());
            ps.setInt(3, consumo.getCantidad());
            ps.setDouble(4, consumo.getPrecioVenta());

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Consumo registrado con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo registrar el consumo, intentelo nuevamente.");
        }

        return false;
    }

    @Override
    public boolean update(Consumo consumo) {
        String query = "UPDATE Consumo SET idventa=?, idproducto=?, cantidad= ?, precio_venta= ? "
                + "WHERE idconsumo= ?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            ps.setInt(1, consumo.getIdVenta());
            ps.setInt(2, consumo.getIdProducto());
            ps.setInt(3, consumo.getCantidad());
            ps.setDouble(4, consumo.getPrecioVenta());
            ps.setInt(5, consumo.getIdConsumo());
            

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Consumo editado con éxito.");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo editar el consumo, intentelo nuevamente.");
        }

        return false;
    }

    public ArbolRojoNegro readArbolRojoNegro(String buscar) {
        ArbolRojoNegro<Consumo> arbolRN= new ArbolRojoNegro<Consumo>();
        
        String query = "SELECT c.idconsumo, c.idventa, c.idproducto, c.cantidad, "
                + "c.precio_venta from consumo c inner join producto p on c.idproducto=p.idproducto "
                + "where c.idventa = "+buscar;

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setIdConsumo(rs.getInt(1));
                consumo.setIdVenta(rs.getInt(2));
                consumo.setIdProducto(rs.getInt(3));
                consumo.setCantidad(rs.getInt(4));
                consumo.setPrecioVenta(rs.getDouble(5));
                
                totalConsumo+= (rs.getInt(4) * rs.getDouble(5));
                System.out.println(consumo);

                arbolRN.insertar(consumo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo llamar al consumo");
            System.out.println(e);
            arbolRN = null;
        }

        return arbolRN;
    }

    ArrayList<String[]> array = new ArrayList<>();

    public ArrayList readTabla(int buscar) {
        String query = "SELECT c.idconsumo, c.idventa, c.idproducto, p.nombre, c.cantidad, "
                + "c.precio_venta "
                + "FROM consumo c inner join producto p on c.idproducto= p.idproducto "
                + "WHERE c.idventa= " + buscar + "";

        String[] registro = new String[12];

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idventa");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");

                totalConsumo += (rs.getInt("cantidad") * rs.getDouble("precio_venta"));

                array.add(registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo llamar al consumo");
            System.out.println(e);
            array = null;
        }

        return array;
    }
    
    public ArrayList readTablita(int buscar) {
        String query = "SELECT c.idconsumo, c.idventa, c.idproducto, p.nombre, c.cantidad, "
                + "c.precio_venta "
                + "FROM consumo c inner join producto p on c.idproducto= p.idproducto "
                + "WHERE c.idventa= " + buscar + "";

        String[] registro = new String[12];

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                registro[0] = rs.getString("nombre");
                registro[1] = rs.getString("cantidad");
                registro[2] = rs.getString("precio_venta");

                totalConsumo += (rs.getInt("cantidad") * rs.getDouble("precio_venta"));

                array.add(registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo llamar al consumo");
            System.out.println(e);
            array = null;
        }

        return array;
    }


    @Override
    public boolean delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean deleteConsumo(Consumo consumo){
        String query = "DELETE FROM consumo WHERE idconsumo = ?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            ps.setInt(1, consumo.getIdConsumo());

            int n = ps.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Consumo eliminado con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar consumo, intentelo nuevamente.");
        }

        return false;
    }

    @Override
    public ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consumo read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
