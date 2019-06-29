package pe.edu.unmsm.software.eapisw.service;

import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class Ordenamiento {
public static void ordenamientoBurbuja(ListaDoble listaDoble){
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoBurbuja();
    }

    public static void ordenamientoInsercion(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoInsercion();
    }

    public static void ordenamientoSeleccion(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoSeleccion();
    }

    public static void ordenamientoQuicksort(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }
    
    public static void main(String[] args) {
        ListaDoble<Producto> lista= new ListaDoble<>();
        
        lista.setFirst(new Producto("rtyrt", null, null, null, 2, 20));
        lista.setFirst(new Producto("asasd", null, null, null, 2, 20));
        lista.setFirst(new Producto("xcxcv", null, null, null, 2, 20));
        
        System.out.println(lista);
        
        ordenamientoQuicksort(lista,0 , lista.getLongitud()-1);
        System.out.println("Ordenamiento\n"+lista);
    }
}
