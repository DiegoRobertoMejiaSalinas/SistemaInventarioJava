package unmsm.edu.pe.fisi.almacen.model;

public class Admin extends Trabajador {

    public Admin(String nombre, String apellido, String telefono, String dni, int administrador) {
        super(nombre, apellido, telefono, dni);
        administrador= 1;
    }

    public Admin(String nombre, String apellido, String telefono, String dni, int administrador, int actualizado) {
        super(nombre, apellido, telefono, dni, actualizado);
        administrador= 1;
    }
    
    public void insertarProducto(Almacen almacen, Producto nuevo){
        almacen.insertarProducto(nuevo);
    }
    
    public float getGanancias(Almacen almacen){
        return almacen.getGanancias();
    }
    
    public float getInversion(Almacen almacen){
        return almacen.getInversion();
    }

}
