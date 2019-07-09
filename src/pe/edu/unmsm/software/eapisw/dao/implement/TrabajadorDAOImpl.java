package pe.edu.unmsm.software.eapisw.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.InterfaceDAO;
import pe.edu.unmsm.software.eapisw.model.Trabajador;
import pe.edu.unmsm.software.eapisw.service.TrabajadorService.TrabajadorComparatorAPaterno;
import pe.edu.unmsm.software.eapisw.service.TrabajadorService.TrabajadorComparatorID;
import pe.edu.unmsm.software.eapisw.service.TrabajadorService.TrabajadorComparatorNombre;
import pe.edu.unmsm.software.eapisw.service.TrabajadorService.TrabajadorComparatorNumDocumento;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;

public class TrabajadorDAOImpl implements InterfaceDAO<Trabajador, String> {

    PreparedStatement ps1;
    PreparedStatement ps2;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;

    ArrayList<Trabajador> arrayList;
    ArbolAVL<Trabajador> arbolAVL;
    ArbolAVL.NodoAVL raiz;

    public TrabajadorDAOImpl() {
        acceso = new AccesoDB();
        arbolAVL = new ArbolAVL<>();
    }

    public Trabajador login(String login, String pass) {
        String query = "Select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password "
                + " from persona p inner join trabajador t "
                + "on p.idpersona=t.idpersona WHERE t.login='" + login + "' and t.password= '" + pass + "'";

        Trabajador trabajador = null;

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            rs = ps1.executeQuery();

            while (rs.next()) {

                trabajador= new Trabajador();
                trabajador.setIdPersona(rs.getInt(1));
                trabajador.setNombre(rs.getString(2));
                trabajador.setaPaterno(rs.getString(3));
                trabajador.setaMaterno(rs.getString(4));
                trabajador.setTipoDocumento(rs.getString(5));
                trabajador.setNumeroDocumento(rs.getString(6));
                trabajador.setDireccion(rs.getString(7));
                trabajador.setTelefono(rs.getString(8));
                trabajador.setEmail(rs.getString(9));
                trabajador.setSueldo(rs.getDouble(10));
                trabajador.setAcceso(rs.getString(11));
                trabajador.setLogin(rs.getString(12));
                trabajador.setPassword(rs.getString(13));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta.");
            trabajador = null;
        }

        return trabajador;
    }

    @Override
    public boolean create(Trabajador trab) {
        boolean resultado = true;
        String query = "INSERT INTO persona (nombre, apaterno, amaterno, "
                + "tipo_documento, num_documento, direccion, telefono, email) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?) ";
        String query2 = "INSERT INTO trabajador (idpersona, sueldo, acceso, login, password) "
                + " values ((SELECT idpersona from persona ORDER BY idpersona desc "
                + " limit 1), ?, ?, ?, ?)";

        try {
            conexion = acceso.getConexion();
            ps1 = conexion.prepareStatement(query);
            ps2 = conexion.prepareStatement(query2);

            ps1.setString(1, trab.getNombre());
            ps1.setString(2, trab.getaPaterno());
            ps1.setString(3, trab.getaMaterno());
            ps1.setString(4, trab.getTipoDocumento());
            ps1.setString(5, trab.getNumeroDocumento());
            ps1.setString(6, trab.getDireccion());
            ps1.setString(7, trab.getTelefono());
            ps1.setString(8, trab.getEmail());

            ps2.setDouble(1, trab.getSueldo());
            ps2.setString(2, trab.getAcceso());
            ps2.setString(3, trab.getLogin());
            ps2.setString(4, trab.getPassword());

            int n = ps1.executeUpdate();

            if (n != 0) {

                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    JOptionPane.showMessageDialog(null, "Trabajador registrado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo registrar el trabajador, intentelo nuevamente.");
            return false;
        }
        return resultado;
    }

    @Override
    public boolean update(Trabajador trab) {
        boolean resultado = true;
        String query = "UPDATE persona SET nombre=?, apaterno=?, amaterno=?, tipo_documento=?, "
                + "num_documento=?, direccion=?, telefono=?, email=? where idpersona=?";
        String query2 = "UPDATE trabajador SET sueldo=?, acceso=?, login=?, password=? where idpersona=?";

        try {
            conexion = acceso.getConexion();
            ps1 = conexion.prepareStatement(query);
            ps2 = conexion.prepareStatement(query2);

            ps1.setString(1, trab.getNombre());
            ps1.setString(2, trab.getaPaterno());
            ps1.setString(3, trab.getaMaterno());
            ps1.setString(4, trab.getTipoDocumento());
            ps1.setString(5, trab.getNumeroDocumento());
            ps1.setString(6, trab.getDireccion());
            ps1.setString(7, trab.getTelefono());
            ps1.setString(8, trab.getEmail());
            ps1.setInt(9, trab.getIdPersona());

            ps2.setDouble(1, trab.getSueldo());
            ps2.setString(2, trab.getAcceso());
            ps2.setString(3, trab.getLogin());
            ps2.setString(4, trab.getPassword());
            ps2.setInt(5, trab.getIdPersona());

            int n = ps1.executeUpdate();

            if (n != 0) {
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    JOptionPane.showMessageDialog(null, "Trabajador editado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo editar el trabajador, intentelo nuevamente.");
            return false;
        }
        return resultado;
    }

    @Override
    public ArrayList read() {
        String query = "Select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password "
                + " from persona p inner join trabajador t "
                + "on p.idpersona=t.idpersona";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();

            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            rs = ps1.executeQuery();

            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setIdPersona(rs.getInt(1));
                trabajador.setNombre(rs.getString(2));
                trabajador.setaPaterno(rs.getString(3));
                trabajador.setaMaterno(rs.getString(4));
                trabajador.setTipoDocumento(rs.getString(5));
                trabajador.setNumeroDocumento(rs.getString(6));
                trabajador.setDireccion(rs.getString(7));
                trabajador.setTelefono(rs.getString(8));
                trabajador.setEmail(rs.getString(9));
                trabajador.setSueldo(rs.getDouble(10));
                trabajador.setAcceso(rs.getString(11));
                trabajador.setLogin(rs.getString(12));
                trabajador.setPassword(rs.getString(13));

                arrayList.add(trabajador);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            arrayList = null;
        }

        return arrayList;
    }

    public ArbolAVL readArbolAVL(String com) {
        if (com.equalsIgnoreCase("id")) {
            TrabajadorComparatorID cpm = new TrabajadorComparatorID();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("nombre")) {
            TrabajadorComparatorNombre cpm = new TrabajadorComparatorNombre();
            arbolAVL.setComparador(cpm);
        } else if (com.equalsIgnoreCase("apaterno")) {
            TrabajadorComparatorAPaterno cpm = new TrabajadorComparatorAPaterno();
            arbolAVL.setComparador(cpm);
        } else {
            TrabajadorComparatorNumDocumento cpm = new TrabajadorComparatorNumDocumento();
            arbolAVL.setComparador(cpm);
        }

        String query = "Select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password "
                + " from persona p inner join trabajador t "
                + "on p.idpersona=t.idpersona";

        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConexion();
            //Preparamos la consulta a ejecutar
            ps1 = conexion.prepareStatement(query);
            rs = ps1.executeQuery();

            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setIdPersona(rs.getInt(1));
                trabajador.setNombre(rs.getString(2));
                trabajador.setaPaterno(rs.getString(3));
                trabajador.setaMaterno(rs.getString(4));
                trabajador.setTipoDocumento(rs.getString(5));
                trabajador.setNumeroDocumento(rs.getString(6));
                trabajador.setDireccion(rs.getString(7));
                trabajador.setTelefono(rs.getString(8));
                trabajador.setEmail(rs.getString(9));
                trabajador.setSueldo(rs.getDouble(10));
                trabajador.setAcceso(rs.getString(11));
                trabajador.setLogin(rs.getString(12));
                trabajador.setPassword(rs.getString(13));

                arbolAVL.insertar(trabajador);
            }

        } catch (SQLException e) {
            arbolAVL = null;
        }
        return arbolAVL;
    }

    @Override
    public boolean delete(String codigo) {
        String query = "DELETE FROM trabajador WHERE idpersona=?";
        String query2 = "DELETE FROM persona WHERE idpersona=?";
        return false;
    }

    public boolean deleteCliente(int id) {

        String query = "DELETE FROM trabajador WHERE idpersona=?";
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
                    JOptionPane.showMessageDialog(null, "Trabajador eliminado con éxito.");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el trabajador, intentelo nuevamente.");
        }

        return false;
    }

    @Override
    public Trabajador read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
