package pe.edu.unmsm.software.eapisw.service.TrabajadorService;

import pe.edu.unmsm.software.eapisw.service.ClienteService.*;
import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.model.Trabajador;

public class TrabajadorComparatorAPaterno implements Comparator<Trabajador>{
@Override
    public int compare(Trabajador o1, Trabajador o2) {
        return o1.getaPaterno().compareTo(o2.getaPaterno());
    }
}
