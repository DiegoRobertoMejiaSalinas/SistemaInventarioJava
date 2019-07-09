package pe.edu.unmsm.software.eapisw.model;

public class Trabajador extends Persona implements Comparable<Trabajador> {

    private double sueldo;
    private String acceso;
    private String login;
    private String password;

    public Trabajador() {
    }

    public Trabajador(double sueldo, String acceso, String login, String password) {
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.login = login;
        this.password = password;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(Trabajador o) {
        return this.getaPaterno().compareTo(o.getaPaterno());
    }

}
