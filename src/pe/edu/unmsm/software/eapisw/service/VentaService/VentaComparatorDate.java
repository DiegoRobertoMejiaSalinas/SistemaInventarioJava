package pe.edu.unmsm.software.eapisw.service.VentaService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Venta;

public class VentaComparatorDate implements Comparator<Venta> {

    @Override
    public int compare(Venta o1, Venta o2) {
        return o1.getFechaVenta().compareTo(o2.getFechaVenta());
    }
}
