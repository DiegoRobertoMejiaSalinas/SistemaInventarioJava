package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import java.util.Comparator;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ArbolBinario;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class Ordenamiento {

    /*ID PRODUCTO*/
    public static void ArrayID(ArrayList arrayList) {
        arrayList.sort(Comparator.comparing(Producto::getIdProducto));
    }

    public static void BurbujaID(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getIdProducto));
        listaDoble.ordenamientoBurbuja();
    }

    public static void InsercionID(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getIdProducto));
        listaDoble.ordenamientoInsercion();
    }

    public static void SeleccionID(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getIdProducto));
        listaDoble.ordenamientoSeleccion();
    }

    public static void QuicksortID(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getIdProducto));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }
    /*CODIGO*/

    public static void ArrayCodigo(ArrayList arrayList) {
        arrayList.sort(Comparator.comparing(Producto::getCodigo));
    }

    public static void BurbujaCodigo(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoBurbuja();
    }

    public static void InsercionCodigo(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoInsercion();
    }

    public static void SeleccionCodigo(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoSeleccion();
    }

    public static void QuicksortCodigo(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getCodigo));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }

    /*NOMBRE*/
    public static void BurbujaNombre(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getNombre));
        listaDoble.ordenamientoBurbuja();
    }

    public static void InsercionNombre(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getNombre));
        listaDoble.ordenamientoInsercion();
    }

    public static void SeleccionNombre(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getNombre));
        listaDoble.ordenamientoSeleccion();
    }

    public static void QuicksortNombre(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getNombre));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }

    public static void ArrayNombre(ArrayList arrayList) {
        arrayList.sort(Comparator.comparing(Producto::getNombre));
    }

    /*STOCK*/
    public static void ArrayStock(ArrayList arrayList) {
        arrayList.sort(Comparator.comparing(Producto::getStock));
    }

    public static void BurbujaStock(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getStock));
        listaDoble.ordenamientoBurbuja();
    }

    public static void InsercionStock(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getStock));
        listaDoble.ordenamientoInsercion();
    }

    public static void SeleccionStock(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getStock));
        listaDoble.ordenamientoSeleccion();
    }

    public static void QuicksortStock(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getStock));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }

    /*PRECIO DE VENTA*/
    public static void ArrayPrecioVenta(ArrayList arrayList) {
        arrayList.sort(Comparator.comparing(Producto::getPrecio_venta));
    }

    public static void BurbujaPrecioVenta(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        listaDoble.ordenamientoBurbuja();
    }

    public static void InsercionPrecioVenta(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        listaDoble.ordenamientoInsercion();
    }

    public static void SeleccionPrecioVenta(ListaDoble listaDoble) {
        listaDoble.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        listaDoble.ordenamientoSeleccion();
    }

    public static void QuicksortPrecioVenta(ListaDoble listaDoble, int izquierda, int derecha) {
        listaDoble.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        listaDoble.ordenamientoQuicksort(izquierda, derecha);
    }

}
