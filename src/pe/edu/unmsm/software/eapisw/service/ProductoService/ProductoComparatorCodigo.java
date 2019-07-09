package pe.edu.unmsm.software.eapisw.service.ProductoService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ProductoComparatorCodigo implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getCodigo().compareTo(o2.getCodigo());
    }

}
