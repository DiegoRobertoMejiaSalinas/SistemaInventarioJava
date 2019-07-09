package pe.edu.unmsm.software.eapisw.model;

public class Cliente extends Persona implements Comparable<Cliente> {

    private String codigoCliente;

    public Cliente() {
    }

    public Cliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.getaPaterno().compareTo(o.getaPaterno());
    }

}
