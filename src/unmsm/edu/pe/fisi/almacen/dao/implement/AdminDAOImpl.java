
package unmsm.edu.pe.fisi.almacen.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import unmsm.edu.pe.fisi.almacen.dao.AccesoDB;
import unmsm.edu.pe.fisi.almacen.dao.InterfaceGlobal;
import unmsm.edu.pe.fisi.almacen.model.Admin;
import unmsm.edu.pe.fisi.almacen.structure.Cola;

public class AdminDAOImpl implements InterfaceGlobal<Cola<Admin>, String>{
    
    PreparedStatement ps;
    //Para obtener el resultado de la ejecucion de la consulta
    ResultSet rs;
    //Para poder almacenar la conexion
    Connection conexion;
    //Para obtener la conexion
    AccesoDB acceso;
    
    Cola<Admin> nuevo;

    @Override
    public boolean create(Cola<Admin> cola) {
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement("INSERT INTO trabajador VALUES(?,?,?,?,?,?,?,?)");
            //Indicamos los parametros para la consulta
            ps.setString(2, cola.getCabecera().getDato().getUsuario());
            ps.setString(3, cola.getCabecera().getDato().getContrasena());
            ps.setString(4, cola.getCabecera().getDato().getNombre());
            ps.setString(5, cola.getCabecera().getDato().getApellido());
            ps.setString(6, cola.getCabecera().getDato().getTelefono());
            ps.setString(7, cola.getCabecera().getDato().getDni());
            ps.setInt(8, cola.getCabecera().getDato().getActualizado());
            ps.setInt(9, cola.getCabecera().getDato().getAdministrador());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean createAdmin(Admin admin){
        boolean resultado = true;
        try {
            //Obtener la conexion a la BD
            conexion = acceso.getConnection();
            //Preparamos la consulta a ejecutar
            ps = conexion.prepareStatement("INSERT INTO trabajador VALUES(?,?,?,?,?,?,?,?)");
            //Indicamos los parametros para la consulta
            ps.setString(2, admin.getUsuario());
            ps.setString(3, admin.getContrasena());
            ps.setString(4, admin.getNombre());
            ps.setString(5, admin.getApellido());
            ps.setString(6, admin.getTelefono());
            ps.setString(7, admin.getDni());
            ps.setInt(8, admin.getActualizado());
            ps.setInt(9, admin.getAdministrador());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean update(Admin actualizado){
        boolean resultado = true;
        conexion = acceso.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE trabajador "
                    + "SET usuario = ?, contrasena = ?, nombre = ?, apellido = ?, "
                    + "telefono = ?, dni = ?, actualizado = ? "
                    + "WHERE usuario = ?");
            ps.setString(2, actualizado.getUsuario());
            ps.setString(3, actualizado.getContrasena());
            ps.setString(4, actualizado.getNombre());
            ps.setString(5, actualizado.getApellido());
            ps.setString(6, actualizado.getTelefono());
            ps.setString(7, actualizado.getDni());
            ps.setInt(8, actualizado.getActualizado());
            ps.setString(2, actualizado.getUsuario());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean update(Cola<Admin> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Admin readL(String u){
        Admin adminBuscado = null;
        try {
            //Obtenemos la conexion
            conexion = acceso.getConnection();
            ps = conexion.prepareStatement("SELECT * FROM trabajador WHERE USER = ? ");
            ps.setString(1, u);
            rs = ps.executeQuery();

            if (rs.next()) {

                //Leeemos de la bd
                String usuario = rs.getString("User");
                String contrasena = rs.getString("Contrasenia");
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String telefono = rs.getString("Telefono");
                String dni = rs.getString("DNI");
                int actualizado = rs.getInt("actualizado");

                adminBuscado = new Admin(usuario, contrasena, nombres, apellidos, telefono, dni, actualizado);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return adminBuscado;
    }
    
    @Override
    public Cola<Admin> read() {
        try {
            //Obtenemos la conexion
            conexion = acceso.getConnection();
            Statement st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM trabajador");

            while (rs.next()) {
                //Leeemos de la bd
                String user = rs.getString("User");
                String contrasenia = rs.getString("Contrasenia");
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String telefono = rs.getString("Telefono");
                String dni = rs.getString("DNI");
                int actualizado = rs.getInt("actualizado");

                Admin adminBuscado = new Admin(user, contrasenia, nombres, apellidos, telefono, dni, actualizado);
                nuevo.encolar(adminBuscado);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nuevo;
    }

    @Override
    public Cola<Admin> read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
