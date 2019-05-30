package unmsm.edu.pe.fisi.almacen.model;

public class Admin extends Trabajador {

    private int administrador;

    public Admin(String usuario, String contrasena, String nombre, String apellido, String telefono, String dni) {
        super(usuario, contrasena, nombre, apellido, telefono, dni);
        administrador = 1;
    }

    public Admin(String usuario, String contrasena, String nombre, String apellido, String telefono, String dni, int actualizado) {
        super(usuario, contrasena, nombre, apellido, telefono, dni, actualizado);
        administrador = 1;
    }

    public int getAdministrador() {
        return administrador;
    }

    public void insertarProducto(Almacen almacen, Producto nuevo) {
        almacen.insertarProducto(nuevo);
    }

    public float getGanancias(Almacen almacen) {
        return almacen.getGanancias();
    }

    public float getInversion(Almacen almacen) {
        return almacen.getInversion();
    }

}
