package pe.edu.unmsm.software.eapisw.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.InterfaceDAO;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.service.ClienteService.ClienteComparatorCodigoCliente;
import pe.edu.unmsm.software.eapisw.service.ClienteService.ClienteComparatorAPaterno;
import pe.edu.unmsm.software.eapisw.service.ClienteService.ClienteComparatorID;
import pe.edu.unmsm.software.eapisw.service.ClienteService.ClienteComparatorNombre;
import pe.edu.unmsm.software.eapisw.service.ClienteService.ClienteComparatorNumDocumento;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;

public class ClienteDAOImpl implements InterfaceDAO<Cliente, String> {

    PreparedStatement ps1;
    PreparedStatement ps2;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    ArrayList<Cliente> arrayList;
    ArbolAVL<Cliente> arbolAVL;
    ArbolAVL.NodoAVL raiz;

    public ClienteDAOImpl() {
        acceso = new AccesoDB();
        arbolAVL = new ArbolAVL<>();
    }

    @Override
    public boolean create(Cliente cliente) {
        boolean resultado = true;
        String query = "INSERT INTO persona (nombre, apaterno, amaterno,"
                + "tipo_documento, num_documento, direccion, telefono, email)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        String query2 = "INSERT INTO cliente (idpersona, codigo_cliente)"
                + " values ((SELECT idpersona from persona ORDER BY idpersona desc"
                + " limit 1), ?)";

        try {
            conexion = acceso.getConexion();
            ps1 = conexion.prepareStatement(query);
            ps2 = conexion.prepareStatement(query2);

            ps1.setString(1, cliente.getNombre());
            ps1.setString(2, cliente.getaPaterno());
            ps1.setString(3, cliente.getaMaterno());
            ps1.setString(4, cliente.getTipoDocumento());
            ps1.setString(5, cliente.getNumeroDocumento());
            ps1.setString(6, cliente.getDireccion());
            ps1.setString(7, cliente.getTelefono());
            ps1.setString(8, cliente.getEmail());

            ps2.setString(1, cliente.getCodigoCliente());

            int n = ps1.executeUpdate();

            if (n != 0) {

                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente, intentelo nuevamente.");
            return false;
        }
        return resultado;
    }

    @Override
    public boolean update(Cliente cliente) {
        boolean resultado = true;
        String query = "UPDATE persona SET nombre=?, apaterno=?, amaterno=?, tipo_documento=?, "
                + "num_documento=?, direccion=?, telefono=?, email=? where idpersona=?";
        String query2 = "UPDATE cliente SET codigo_cliente=? where idpersona=?";

        try {
            conexion = acceso.getConexion();
            ps1 = conexion.prepareStatement(query);
            ps2 = conexion.prepareStatement(query2);

            ps1.setString(1, cliente.getNombre());
            ps1.setString(2, cliente.getaPaterno());
            ps1.setString(3, cliente.getaMaterno());
            ps1.setString(4, cliente.getTipoDocumento());
            ps1.setString(5, cliente.getNumeroDocumento());
            ps1.setString(6, cliente.getDireccion());
            ps1.setString(7, cliente.getTelefono());
            ps1.setString(8, cliente.getEmail());
            ps1.setInt(9, cliente.getIdPersona());

            ps2.setString(1, cliente.getCodigoCliente());
            ps2.setInt(2, cliente.getIdPersona());

            int n = ps1.executeUpdate();

            if (n != 0) {
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    JOptionPane.showMessageDialog(null, "Cliente editado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo editar el cliente, intentelo nuevamente.");
            return false;
        }
        return resultado;
    }

    @Override
    public ArrayList read() {
        String query = "Select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, c.codigo_cliente from persona p inner join cliente c "
                + "on p.idpersona=c.idpersona";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            rs = ps1.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setaPaterno(rs.getString(3));
                cliente.setaMaterno(rs.getString(4));
                cliente.setTipoDocumento(rs.getString(5));
                cliente.setNumeroDocumento(rs.getString(6));
                cliente.setDireccion(rs.getString(7));
                cliente.setTelefono(rs.getString(8));
                cliente.setEmail(rs.getString(9));
                cliente.setCodigoCliente(rs.getString(10));

                arrayList.add(cliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            arrayList = null;
        }

        return arrayList;
    }

    public ArbolAVL readArbolAVL(String com) {
        if (com.equalsIgnoreCase("id")) {
            ClienteComparatorID cpm = new ClienteComparatorID();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("nombre")) {
            ClienteComparatorNombre cpm = new ClienteComparatorNombre();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("apaterno")) {
            ClienteComparatorAPaterno cpm = new ClienteComparatorAPaterno();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("numdoc")) {
            ClienteComparatorNumDocumento cpm = new ClienteComparatorNumDocumento();
            arbolAVL.setComparador(cpm);
        } else {
            ClienteComparatorCodigoCliente cpm = new ClienteComparatorCodigoCliente();
            arbolAVL.setComparador(cpm);
        }

        String query = "Select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, c.codigo_cliente from persona p inner join cliente c "
                + "on p.idpersona=c.idpersona";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            rs = ps1.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setaPaterno(rs.getString(3));
                cliente.setaMaterno(rs.getString(4));
                cliente.setTipoDocumento(rs.getString(5));
                cliente.setNumeroDocumento(rs.getString(6));
                cliente.setDireccion(rs.getString(7));
                cliente.setTelefono(rs.getString(8));
                cliente.setEmail(rs.getString(9));
                cliente.setCodigoCliente(rs.getString(10));

                arbolAVL.insertar(cliente);
            }

        } catch (SQLException e) {
            arbolAVL = null;
        }
        return arbolAVL;
    }

    @Override
    public boolean delete(String codigo) {
        String query = "DELETE FROM cliente WHERE idpersona=?";
        String query2 = "DELETE FROM persona WHERE idpersona=?";
        return false;
    }

    public boolean deleteCliente(int id) {

        String query = "DELETE FROM cliente WHERE idpersona=?";
        String query2 = "DELETE FROM persona WHERE idpersona=?";

        try {
            //Obtener conexion con la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            ps2 = conexion.prepareStatement(query2);

            ps1.setInt(1, id);
            ps2.setInt(1, id);

            int n = ps1.executeUpdate();

            if (n != 0) {
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente, intentelo nuevamente.");
        }

        return false;
    }

    @Override
    public Cliente read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
