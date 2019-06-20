package pe.edu.unmsm.software.eapisw.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccesoDB {

    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";
    private static final String HOST = "localhost:3306";
    private static final String BD = "almacened";
    private static final String url= "jdbc:mysql://localhost:3306/almacenED";
    Connection conexion;

    public Connection getConexion() {
        try {
            //Carga el Driver de Mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Obtener un conexion con los permisos respectivos
            //desde el SGBD.
            conexion = DriverManager.getConnection(
                    url, USUARIO, PASSWORD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return conexion;
    }
}
