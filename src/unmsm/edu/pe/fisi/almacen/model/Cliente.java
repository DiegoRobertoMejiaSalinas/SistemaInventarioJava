package unmsm.edu.pe.fisi.almacen.model;

import unmsm.edu.pe.fisi.almacen.structure.Cola;

public class Cliente {

    private String nombre;
    private String dni;
    private Cola productos;

    public Cliente(String nombre, String dni, Cola productos) {
        this.nombre = nombre;
        this.dni = dni;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cola getProductos() {
        return productos;
    }

    public void setProductos(Cola productos) {
        this.productos = productos;
    }

    public int cantidadProductos() {
        return this.productos.getCantidad();
    }
}