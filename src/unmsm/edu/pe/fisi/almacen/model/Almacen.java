package unmsm.edu.pe.fisi.almacen.model;

import unmsm.edu.pe.fisi.almacen.structure.ListaDoble;

public class Almacen {

    private String almacenNombre;
    private ListaDoble<Producto> productos;

    public Almacen(String almacenNombre, ListaDoble productos) {
        this.almacenNombre = almacenNombre;
        this.productos = productos;
    }

    public Almacen(String almacenNombre) {
        this.almacenNombre = almacenNombre;
        this.productos = null;
    }

    public String getAlmacenNombre() {
        return almacenNombre;
    }

    public void setAlmacenNombre(String almacenNombre) {
        this.almacenNombre = almacenNombre;
    }

    public ListaDoble getProductos() {
        return productos;
    }

    public void setProductos(ListaDoble productos) {
        this.productos = productos;
    }

    public void insertarProducto(Producto nuevo) {
        this.productos.insertarAlFinal(nuevo);
    }
    
    public float getGanancias(){
        return ganancias();
    }
    
    public float getInversion(){
        return compras();
    }

    /*public void quitarProducto(String codigo){
     this.productos.
     }*/
    private float ganancias() {
        float ganancias = 0;

        ListaDoble<Producto> aux = productos;
        while (aux != null) {
            int stock = aux.getCabecera().getDato().getStock();
            float venta = aux.getCabecera().getDato().getPrecioVenta();
            float compra = aux.getCabecera().getDato().getPrecioCompra();

            ganancias += stock * (venta - compra);

            aux.setCabecera(aux.getCabecera().getSig());

        }

        return ganancias;
    }

    private float compras() {
        float compras = 0;

        ListaDoble<Producto> aux = productos;
        while (aux != null) {
            int stock = aux.getCabecera().getDato().getStock();
            float compra = aux.getCabecera().getDato().getPrecioCompra();
            compras += stock * (compra);
            aux.setCabecera(aux.getCabecera().getSig());
        }
        return compras;
    }

    public String getTodosProductos() {
        return this.productos.toString();
    }
}
