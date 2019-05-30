package unmsm.edu.pe.fisi.almacen.service;

import java.util.Comparator;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import unmsm.edu.pe.fisi.almacen.dao.implement.AdminDAOImpl;
import unmsm.edu.pe.fisi.almacen.model.Admin;
import unmsm.edu.pe.fisi.almacen.structure.Cola;


public class AdminServiceImpl {
    private Admin encontrado = null;
    private AdminDAOImpl dbAdmin;
    private Cola<Admin> cola;

    public AdminServiceImpl() {
        dbAdmin = new AdminDAOImpl();
        cola = dbAdmin.read();
    }

    public Admin getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Admin encontrado) {
        this.encontrado = encontrado;
    }
    

    public boolean agregar(Admin ad) {
        boolean resultado = true;

        Iterator<Admin> iterador = cola.getDescendingIterator();
        while (iterador.hasNext()) {
            Admin temporal = iterador.next();
            if (temporal.getUsuario().equalsIgnoreCase(ad.getUsuario())) {
                resultado = false;
            }
        }
        if (resultado == true) {
            cola.encolar(ad);
            dbAdmin.create(cola);
        }
        return resultado;
    }

    public void mostrarTabla(DefaultTableModel dtm) {

        Iterator<Admin> iterador = cola.getDescendingIterator();
        while (iterador.hasNext()) {
            Admin temporal = iterador.next();
            Object[] fila = new Object[]{temporal.getUsuario(), temporal.getApellido(), temporal.getTelefono(), temporal.getDni()};
            dtm.addRow(fila);
        }
    }

    public void ordenarApellido() {
        cola.setComparador(Comparator.comparing(Admin::getApellido));
        cola.ordenarPorBurbuja();
    }

    public void ordenarNombre() {
        cola.setComparador(Comparator.comparing(Admin::getNombre));
        cola.ordenarPorBurbuja();
    }

    public void ordenarUser() {
        cola.setComparador(Comparator.comparing(Admin::getUsuario));
        cola.ordenarPorBurbuja();
    }

    public void ordenarDNI() {
        cola.setComparador(Comparator.comparing(Admin::getDni));
        cola.ordenarPorBurbuja();
    }

    public Cola<Admin> getLista() {
        return cola;
    }

    public void setLista(Cola<Admin> lista) {
        this.cola = lista;
    }
}
