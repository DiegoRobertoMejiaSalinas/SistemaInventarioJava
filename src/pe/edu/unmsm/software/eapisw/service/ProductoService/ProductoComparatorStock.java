package pe.edu.unmsm.software.eapisw.service.ProductoService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ProductoComparatorStock implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {

        if (o1.getStock() > o2.getStock()) {
            return 1;
        } else {
            if (o1.getStock() == o2.getStock()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
