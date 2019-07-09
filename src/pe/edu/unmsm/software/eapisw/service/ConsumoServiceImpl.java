package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.implement.ConsumoDAOImpl;

public class ConsumoServiceImpl {

    private ConsumoDAOImpl dbconsumo;
    String[] titulos = {"Producto", "Cantidad", "Precio"};

    public ConsumoServiceImpl() {
        dbconsumo= new ConsumoDAOImpl();
    }
    
    public DefaultTableModel mostrar(int buscar){
     ArrayList registro= dbconsumo.readTabla(buscar);
        
     DefaultTableModel dtm;

     dtm = new DefaultTableModel(null, titulos);
        
     System.out.println(registro);
        
     for(int i=0; i<registro.size(); i++){
     dtm.addRow((Object[]) registro.get(i));
     }
        
     return dtm;
     }
    
}
