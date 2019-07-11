package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.controller.ConsumoFrame;
import pe.edu.unmsm.software.eapisw.dao.implement.ConsumoDAOImpl;
import pe.edu.unmsm.software.eapisw.model.Consumo;
import pe.edu.unmsm.software.eapisw.structure.ArbolRojoNegro;

public class ConsumoServiceImpl {

    private ConsumoDAOImpl dbconsumo;
    String[] titulos = {"Producto", "Cantidad", "Precio"};

    ArbolRojoNegro<Consumo> registro;
    ArrayList<String[]> guia;

    public ConsumoServiceImpl() {
        dbconsumo = new ConsumoDAOImpl();
    }

    public DefaultTableModel mostrar(String buscar) {
        guia = dbconsumo.readTabla(Integer.parseInt(buscar));

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < guia.size(); i++) {
            dtm.addRow(guia.get(i));
        }

        return dtm;
    }

}
