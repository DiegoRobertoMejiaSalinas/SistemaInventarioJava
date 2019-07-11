package pe.edu.unmsm.software.eapisw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.AccesoDB;
import pe.edu.unmsm.software.eapisw.dao.implement.VentaDAOImpl;

public class VentaServiceImpl {

    private VentaDAOImpl dbventa;
    String[] titulos = {"IDVenta", "IDCliente", "Cliente", "IDTrabajador",
        "Trabajador", "Estado"};
    
    ArrayList<String[]> registro;

    public VentaServiceImpl() {
        dbventa = new VentaDAOImpl();
    }

    public DefaultTableModel mostrar() {
        registro = dbventa.readString();
        
        System.out.println((Object) registro);

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < registro.size(); i++) {
            dtm.addRow((Object[]) registro.get(i));
        }

        return dtm;
    }

    public DefaultTableModel ordenar() {
        ArrayList registro = dbventa.readString();

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < registro.size(); i++) {
            dtm.addRow((Object[]) registro.get(i));
        }

        return dtm;
    }
}
