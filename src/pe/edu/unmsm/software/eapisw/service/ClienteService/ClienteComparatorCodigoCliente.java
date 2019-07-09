package pe.edu.unmsm.software.eapisw.service.ClienteService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Cliente;

public class ClienteComparatorCodigoCliente implements Comparator<Cliente>{

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getCodigoCliente().compareTo(o2.getCodigoCliente());
    }

}
