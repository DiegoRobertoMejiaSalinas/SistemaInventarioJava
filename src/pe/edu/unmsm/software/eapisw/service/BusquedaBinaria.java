package pe.edu.unmsm.software.eapisw.service;

import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;


public class BusquedaBinaria {

    public static int busquedaBinaria(ListaDoble<Producto> lista, String codigo) {
        int n = lista.getLongitud();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            String comp = lista.get(centro).getCodigo();
     
            if (comp.compareTo(codigo) == 0) { //comp.compareTo(codigo) == 0
                return centro;
            } else if (codigo.compareTo(comp) < 0) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

    public static int busquedaBinaria(int vector[], int dato) {
        int n = vector.length;
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector[centro] == dato) {
                return centro;
            } else if (dato < vector[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

}
