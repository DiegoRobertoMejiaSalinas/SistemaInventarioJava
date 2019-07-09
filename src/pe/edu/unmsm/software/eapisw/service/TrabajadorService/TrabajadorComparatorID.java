package pe.edu.unmsm.software.eapisw.service.TrabajadorService;

import pe.edu.unmsm.software.eapisw.service.ClienteService.*;
import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.model.Trabajador;

public class TrabajadorComparatorID implements Comparator<Trabajador>{
    
    @Override
    public int compare(Trabajador o1, Trabajador o2) {
        if(o1.getIdPersona()> o2.getIdPersona()){
            return 1;
        }else{
            if(o1.getIdPersona() == o2.getIdPersona()){
                return 0;
            }else{
                return -1;
            }
        }
    }

}
