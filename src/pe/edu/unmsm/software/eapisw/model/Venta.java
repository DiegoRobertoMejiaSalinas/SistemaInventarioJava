package pe.edu.unmsm.software.eapisw.model;

import java.sql.Date;

public class Venta implements Comparable<Venta> {

    private int idVenta;
    private int idCliente;
    private int idTrabajador;
    private Date fechaVenta;
    private String estado;

    public Venta() {
    }

    public Venta(int idVenta, int idCliente, int idTrabajador, Date fechaVenta, String estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + ", estado=" + estado + '}';
    }

    @Override
    public int compareTo(Venta o) {
        return this.fechaVenta.compareTo(o.fechaVenta);
    }

}
