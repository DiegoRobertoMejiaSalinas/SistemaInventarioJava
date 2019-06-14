package pe.edu.unmsm.software.eapisw.model;

public class Producto {

    private String codigo;
    private String nombre;
    private int stock;
    private double precioVenta;
    private double precioCompra;

    public Producto(String codigo, String nombre, int stock, double precioVenta, double precioCompra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra + '}';
    }

}
