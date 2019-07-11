package pe.edu.unmsm.software.eapisw.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.InterfaceDAO;
import pe.edu.unmsm.software.eapisw.model.Venta;
import pe.edu.unmsm.software.eapisw.service.VentaService.VentaComparatorClienteID;
import pe.edu.unmsm.software.eapisw.service.VentaService.VentaComparatorDate;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;

public class VentaDAOImpl implements InterfaceDAO<Venta, String> {

    PreparedStatement ps;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    ArrayList<String[]> arrayList;

    public VentaDAOImpl() {
        acceso = new AccesoDB();
        arrayList = new ArrayList<>();
    }

    @Override
    public boolean create(Venta venta) {
        boolean resultado = true;
        String query = "INSERT INTO venta (idcliente, idtrabajador, fecha, estado) "
                + "VALUES (?, ?, ?, ?)";
        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            ps.setInt(1, venta.getIdCliente());
            ps.setInt(2, venta.getIdTrabajador());
            ps.setDate(3, venta.getFechaVenta());
            ps.setString(4, venta.getEstado());

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Venta registrada con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la venta, intentelo nuevamente.");
            System.out.println(e);
        }

        return resultado;
    }

    @Override
    public boolean update(Venta venta) {
        String query = "UPDATE venta SET idcliente=?, idtrabajador=?, estado=? WHERE idventa=?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            ps.setInt(1, venta.getIdCliente());
            ps.setInt(2, venta.getIdTrabajador());
            ps.setString(3, venta.getEstado());
            ps.setInt(4, venta.getIdVenta());

            int n = ps.executeUpdate();

            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Venta editada con éxito.");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo editar la venta, intentelo nuevamente.");
        }

        return false;

    }

    @Override
    public ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList readString() {

        String query = "SELECT v.idventa, v.idcliente, (SELECT nombre from almacened.persona where idpersona=v.idcliente) as clienten, "
                + "(SELECT apaterno from almacened.persona where idpersona=v.idcliente) as clienteap, "
                + "v.idtrabajador, (SELECT nombre from almacened.persona where idpersona=v.idtrabajador) as trabajadorn, "
                + "(SELECT apaterno from almacened.persona where idpersona=v.idtrabajador) as trabajadorap, "
                + "v.fecha, v.estado "
                + "FROM almacened.venta v ";

        String[] registro = new String[6];

      
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

         
            while (rs.next()) {
                registro[0] = rs.getString("v.idventa");
                System.out.println(registro[0]);
                registro[1] = rs.getString("v.idcliente");
                registro[2] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[3] = rs.getString("v.idtrabajador");
                registro[4] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[5] = rs.getString("v.estado");

                arrayList.add(registro);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a las ventas.");
            arrayList = null;
        }
        return arrayList;
    }

    @Override
    public Venta read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteVenta(Venta venta) {
        String query = "DELETE FROM venta WHERE idventa = ?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement(query);

            ps.setInt(1, venta.getIdVenta());

            int n = ps.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Venta eliminada con éxito.");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la venta, intentelo nuevamente.");
        }

        return false;
    }

}
