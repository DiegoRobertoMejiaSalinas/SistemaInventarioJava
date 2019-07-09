package pe.edu.unmsm.software.eapisw.service.ClienteService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ClienteComparatorNombre implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
