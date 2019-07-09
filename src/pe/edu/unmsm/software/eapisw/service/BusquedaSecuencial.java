package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class BusquedaSecuencial {

    public static int busquedaSecuencialPosicion(ListaDoble<Producto> lista, String codigo) {
        int n = lista.getLongitud();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getCodigo().compareTo(codigo) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static ListaDoble busquedaSecuencialID(ListaDoble<Producto> lista, int id) {
        int n = lista.getLongitud();

        Producto resultado = null;
        ListaDoble<Producto> listaRespuesta = new ListaDoble<>();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getIdProducto() == id) {
                resultado = lista.get(i);
                listaRespuesta.setLast(resultado);
            }
        }
        return listaRespuesta;
    }

    public static ListaDoble busquedaSecuencialCodigo(ListaDoble<Producto> lista, String codigo) {
        int n = lista.getLongitud();

        Producto resultado = null;
        ListaDoble<Producto> listaRespuesta = new ListaDoble<>();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getCodigo().compareTo(codigo) == 0) {
                resultado = lista.get(i);
                listaRespuesta.setLast(resultado);
            }
        }

        return listaRespuesta;
    }

    public static ListaDoble busquedaSecuencialNombre(ListaDoble<Producto> lista, String nombre) {
        int n = lista.getLongitud();

        Producto resultado = null;
        ListaDoble<Producto> listaRespuesta = new ListaDoble<>();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getNombre().compareTo(nombre) == 0) {
                resultado = lista.get(i);
                listaRespuesta.setLast(resultado);
            }
        }
        return listaRespuesta;
    }

    public static ListaDoble busquedaSecuencialStock(ListaDoble<Producto> lista, int stock) {
        int n = lista.getLongitud();

        Producto resultado = null;
        ListaDoble<Producto> listaRespuesta = new ListaDoble<>();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getStock() == stock) {
                resultado = lista.get(i);
                listaRespuesta.setLast(resultado);
            }
        }
        return listaRespuesta;
    }

    public static ListaDoble busquedaSecuencialPrecio(ListaDoble<Producto> lista, double precio) {
        int n = lista.getLongitud();

        Producto resultado = null;
        ListaDoble<Producto> listaRespuesta = new ListaDoble<>();

        for (int i = 0; i < n; i++) {
            if (lista.get(i).getPrecio_venta() == precio) {
                resultado = lista.get(i);
                listaRespuesta.setLast(resultado);
            }
        }
        return listaRespuesta;
    }

    public static int busquedaSecuencial(ArrayList<Producto> arrayList, String codigo) {
        int n = arrayList.size();

        for (int i = 0; i < n; i++) {
            if (arrayList.get(i).getCodigo().compareTo(codigo) == 0) {
                return i;
            }
        }
        return -1;
    }
}
