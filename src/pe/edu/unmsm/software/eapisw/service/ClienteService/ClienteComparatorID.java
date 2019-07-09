package pe.edu.unmsm.software.eapisw.service.ClienteService;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Cliente;

public class ClienteComparatorID implements Comparator<Cliente>{
    
    @Override
    public int compare(Cliente o1, Cliente o2) {
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
