package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.implement.ClienteDAOImpl;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;
import pe.edu.unmsm.software.eapisw.structure.ArbolRojoNegro;

public class ClienteServiceImpl {

    private Cliente encontrado = null;
    private String query = "";
    private ClienteDAOImpl dbCliente;
    public ArbolAVL<Cliente> arbolAVL;
    public ArbolAVL.NodoAVL raiz;
    public ArbolRojoNegro<Cliente> arbolRojoNegro;

    String[] titulos = {"Int", "ID", "Nombre", "Paterno", "Materno", "Tipo Documento", "Num Documento", "Direccion",
        "Telefono", "Email", "Código Cliente"};

    public ClienteServiceImpl() {
        dbCliente = new ClienteDAOImpl();
    }

    public Cliente getEncontrado() {
        return encontrado;
    }

    /*MOSTRAR*/
    public DefaultTableModel mostrarArbolAVL() {
        arbolAVL = dbCliente.readArbolAVL("");

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        ArrayList<Cliente> arrayL = arbolAVL.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Cliente prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdPersona(), prod.getNombre(), prod.getaPaterno(), prod.getaMaterno(),
                prod.getTipoDocumento(), prod.getNumeroDocumento(), prod.getDireccion(), prod.getTelefono(), prod.getEmail(),
                prod.getCodigoCliente()};
            dtm.addRow(fila);
        }

        return dtm;
    }
    
    public DefaultTableModel mostrarArbolRNVentas() {
        arbolRojoNegro = dbCliente.readArbolRojoNegro("");

        DefaultTableModel dtm;
        String[] titulos = {"ID", "Código", "Nombre"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Cliente> arrayL = arbolRojoNegro.getInOrden();
        for (int i = 0; i < arrayL.size(); i++) {
            Cliente prod = arrayL.get(i);
            Object[] fila = new Object[]{prod.getIdPersona(), prod.getNombre(), prod.getaPaterno()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    /*ORDENAR*/
    public DefaultTableModel ordenarArbolAVL(String com) {
        arbolAVL = dbCliente.readArbolAVL(com);

        DefaultTableModel dtm;

        dtm = new DefaultTableModel(null, titulos);

        ArrayList<Cliente> arrayL = arbolAVL.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Cliente prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdPersona(), prod.getNombre(), prod.getaPaterno(), prod.getaMaterno(),
                prod.getTipoDocumento(), prod.getNumeroDocumento(), prod.getDireccion(), prod.getTelefono(), prod.getEmail(),
                prod.getCodigoCliente()};
            dtm.addRow(fila);
        }

        return dtm;
    }
}
