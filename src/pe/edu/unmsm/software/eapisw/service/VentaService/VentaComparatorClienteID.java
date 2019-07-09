package pe.edu.unmsm.software.eapisw.service.VentaService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Venta;

public class VentaComparatorClienteID implements Comparator<Venta>{

    @Override
    public int compare(Venta o1, Venta o2) {
        if(o1.getIdCliente() > o2.getIdCliente()){
            return 1;
        }else if(o1.getIdCliente() == o2.getIdCliente()){
            return 0;
        }else{
            return -1;
        }
    }

}
