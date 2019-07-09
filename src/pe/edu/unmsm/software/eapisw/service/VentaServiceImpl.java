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
    String[] titulos = {"ID", "IDCliente", "Cliente", "IDTrabajador",
        "Trabajador", "Fecha", "Estado"};

    public VentaServiceImpl() {
        dbventa = new VentaDAOImpl();
    }

    public DefaultTableModel mostrar(String buscar) {
        ArrayList registro = dbventa.readString("", buscar);

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        System.out.println(registro);

        for (int i = 0; i < registro.size(); i++) {
            dtm.addRow((Object[]) registro.get(i));
        }

        return dtm;
    }

    public DefaultTableModel ordenar(String com, String buscar) {
        ArrayList registro = dbventa.readString(com, buscar);

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < registro.size(); i++) {
            dtm.addRow((Object[]) registro.get(i));
        }

        return dtm;
    }
}
