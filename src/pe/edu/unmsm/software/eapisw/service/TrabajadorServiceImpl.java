package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.implement.ClienteDAOImpl;
import pe.edu.unmsm.software.eapisw.dao.implement.TrabajadorDAOImpl;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.model.Trabajador;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;

public class TrabajadorServiceImpl {

    private Trabajador encontrado = null;
    private String query = "";
    private TrabajadorDAOImpl dbTrabajador;
    public ArbolAVL<Trabajador> arbolAVL;
    public ArbolAVL.NodoAVL raiz;

    String[] titulos = {"Int", "ID", "Nombre", "Paterno", "Materno", "Tipo Documento", "Num Documento", "Direccion",
        "Telefono", "Email", "Login", "Rol", "Sueldo"};

    public TrabajadorServiceImpl() {
        dbTrabajador = new TrabajadorDAOImpl();
    }

    public Trabajador getEncontrado() {
        return encontrado;
    }

    /*MOSTRAR*/
    public DefaultTableModel mostrarArbolAVL() {
        arbolAVL = dbTrabajador.readArbolAVL("");

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);
        
        ArrayList<Trabajador> arrayL = arbolAVL.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Trabajador prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdPersona(), prod.getNombre(), prod.getaPaterno(), prod.getaMaterno(),
                prod.getTipoDocumento(), prod.getNumeroDocumento(), prod.getDireccion(), prod.getTelefono(), prod.getEmail(),
                prod.getLogin(), prod.getAcceso(),prod.getSueldo()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    /*ORDENAR*/
    public DefaultTableModel ordenarArbolAVL(String com) {
        arbolAVL = dbTrabajador.readArbolAVL(com);

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        ArrayList<Trabajador> arrayL = arbolAVL.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Trabajador prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdPersona(), prod.getNombre(), prod.getaPaterno(), prod.getaMaterno(),
                prod.getTipoDocumento(), prod.getNumeroDocumento(), prod.getDireccion(), prod.getTelefono(), prod.getEmail(),
                prod.getSueldo()};
            dtm.addRow(fila);
        }

        return dtm;
    }
}
