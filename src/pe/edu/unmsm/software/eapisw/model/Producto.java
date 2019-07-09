package pe.edu.unmsm.software.eapisw.model;

public class Producto implements Comparable<Producto> {

    private int idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String caracteristicas;
    private int stock;
    private double precio_venta;

    public Producto(String codigo, String nombre, String descripcion, String caracteristicas, int stock, double precio_venta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.stock = stock;
        this.precio_venta = precio_venta;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", caracteristicas=" + caracteristicas + ", stock=" + stock + ", precio_venta=" + precio_venta + '}';
    }

    @Override
    public int compareTo(Producto o) {
        if (this.idProducto > o.idProducto) {
            return 1;
        } else {
            if (this.idProducto == o.idProducto) {
                return 0;
            } else {
                return -1;
           }
        }

        //return this.codigo.compareTo(o.codigo);
    }

}
