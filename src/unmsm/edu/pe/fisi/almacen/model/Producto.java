package unmsm.edu.pe.fisi.almacen.model;

public class Producto {

    private String nombre;
    private String codigo;
    private int stock;
    private float precioCompra;
    private float precioVenta;
    private int actualizado;

    public Producto(String nombre, String codigo, int stock, float precioCompra, float precioVenta) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        actualizado = 0;
    }

    public Producto(String nombre, String codigo, int stock, float precioCompra, float precioVenta, int actualizado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.actualizado = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

}
