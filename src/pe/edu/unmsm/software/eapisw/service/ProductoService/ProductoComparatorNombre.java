package pe.edu.unmsm.software.eapisw.service.ProductoService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ProductoComparatorNombre implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }

}
