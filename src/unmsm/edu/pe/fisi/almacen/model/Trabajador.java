package unmsm.edu.pe.fisi.almacen.model;

public class Trabajador{

    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private int actualizado;

    public Trabajador(String nombre, String apellido, String telefono, String dni, int actualizado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.actualizado = 1;
    }

    public Trabajador(String nombre, String apellido, String telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        actualizado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getActualizado() {
        return actualizado;
    }

    public void setActualizado(int actualizado) {
        this.actualizado = actualizado;
    }

    public int compare(Trabajador o1, Trabajador o2) {
        return o1.apellido.compareTo(o2.apellido);
    }
}
