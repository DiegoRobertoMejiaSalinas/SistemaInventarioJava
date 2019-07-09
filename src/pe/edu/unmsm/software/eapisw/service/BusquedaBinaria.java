package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class BusquedaBinaria {

    public static int busquedaBinariaPosicion(ListaDoble<Producto> lista, String codigo) {
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

    public static ListaDoble busquedaBinariaID(ListaDoble<Producto> lista, int id) {
        int n = lista.getLongitud();

        Producto producto = null;
        ListaDoble<Producto> respuesta = new ListaDoble<>();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            int comp = lista.get(centro).getIdProducto();

            if (comp == id) { //comp.compareTo(codigo) == 0
                producto = lista.get(centro);
                respuesta.setLast(producto);
                sup= centro - 1;
            } else if (id < comp) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }

    public static ListaDoble busquedaBinariaCodigo(ListaDoble<Producto> lista, String codigo) {
        int n = lista.getLongitud();

        Producto producto = null;
        ListaDoble<Producto> respuesta = new ListaDoble<>();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            String comp = lista.get(centro).getCodigo();

            if (comp.compareTo(codigo) == 0) { //comp.compareTo(codigo) == 0
                producto = lista.get(centro);
                respuesta.setLast(producto);
                sup= centro - 1;
            } else if (codigo.compareTo(comp) < 0) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return respuesta;
    }

    public static ListaDoble busquedaBinariaNombre(ListaDoble<Producto> lista, String nombre) {
        int n = lista.getLongitud();

        Producto producto = null;
        ListaDoble<Producto> respuesta = new ListaDoble<>();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            String comp = lista.get(centro).getNombre();

            if (comp.compareTo(nombre) == 0) { //comp.compareTo(codigo) == 0
                producto = lista.get(centro);
                respuesta.setLast(producto);
                sup= centro - 1;
            } else if (nombre.compareTo(comp) < 0) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        
        return respuesta;
    }

    public static ListaDoble busquedaBinariaStock(ListaDoble<Producto> lista, int stock) {
        int n = lista.getLongitud();

        Producto producto = null;
        ListaDoble<Producto> respuesta = new ListaDoble<>();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            int comp = lista.get(centro).getStock();

            if (comp == stock) { //comp.compareTo(codigo) == 0
                producto = lista.get(centro);
                respuesta.setLast(producto);
                sup= centro - 1;
            } else if (stock < comp) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }

    public static ListaDoble busquedaBinariaPrecio(ListaDoble<Producto> lista, double precio) {
        int n = lista.getLongitud();

        Producto producto = null;
        ListaDoble<Producto> respuesta = new ListaDoble<>();

        int centro = -1, inf = 0, sup = n - 1;
        while (inf <= sup) {

            centro = (sup + inf) / 2;

            double comp = lista.get(centro).getIdProducto();

            if (comp == precio) { //comp.compareTo(codigo) == 0
                producto = lista.get(centro);
                respuesta.setLast(producto);
                sup= centro - 1;
            } else if (precio < comp) { //codigo < comp
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return respuesta;
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

    public static int busquedaBinaria(ArrayList<Producto> vector, String codigo) {
        int n = vector.size();
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (vector.get(centro).getCodigo().compareTo(codigo) == 0) { //vector.get(centro).getCodigo() == codigo
                return centro;
            } else if (codigo.compareTo(vector.get(centro).getCodigo()) < 0) { //dato < vector[centro]
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

}
