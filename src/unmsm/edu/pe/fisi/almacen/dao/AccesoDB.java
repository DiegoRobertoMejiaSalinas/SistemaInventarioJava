/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.fisi.almacen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lab02-Pc11
 */
public class AccesoDB {

    private static final String USUARIO = "root";
    private static final String PASSWORD=  "root";
    private static final String HOST = "localhost:3306";
    private static final String BD = "almacendb";
    Connection conexion;
    
    String url = String.format("jdbc:mysql://%s/%s?useSSL=false", HOST, BD);
    //String url= "jdbc:mysql://localhost:3306/almacendb";

    /*public AccesoDB() {
        conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            /*conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + "/" + BD, USUARIO, PASSWORD);*/
            
            /*conexion = DriverManager.getConnection(url);

            if (conexion != null) {
                System.out.println(conexion);
                System.out.println("Conexion establecida");
            } else {
                System.out.println(conexion);
                System.out.println("Error al crear conexion");
            }
        } catch (Exception ex) {
            System.out.println("Instancia no dada");
        }
    }*/
    
    public Connection getConnection(){
        Connection conn= null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection(url,USUARIO, PASSWORD);
            System.out.println("Conexion exitosa");
        }catch(Exception ex){
            System.out.println(ex);
        }
        return conn;
    }
    
    public void llamada() throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        
        Connection aux= getConnection();
        
        ps= aux.prepareStatement("SELECT * FROM productos");
        rs= ps.executeQuery();
        
        while(rs.next()){
            System.out.println("\n\n"+ "Nombre: " +rs.getString(2) + "\tCodigo: "+ rs.getString(3));
        }
    }

    /*public Connection getConnection() {
        return conexion;
    }*/

    public void desconectar() {
        try {
            conexion = null;
            if (conexion == null) {
                System.out.println("Conexion terminada");
            } else {
                System.out.println("Error al cerrar la instancia de la conexion");
            }
        }catch(Exception ex){
            System.out.println("No existe la instancia");
        }
    }

}
