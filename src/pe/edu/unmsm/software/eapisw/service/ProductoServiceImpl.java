package pe.edu.unmsm.software.eapisw.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.implement.ProductoDAOImpl;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.structure.ArbolAVL;
import pe.edu.unmsm.software.eapisw.structure.ArbolBinario;
import pe.edu.unmsm.software.eapisw.structure.ArbolRojoNegro;
import pe.edu.unmsm.software.eapisw.structure.Cola;
import pe.edu.unmsm.software.eapisw.structure.ListaDoble;

public class ProductoServiceImpl {

    private Producto encontrado = null;

    private String query = "";

    private ProductoDAOImpl dbProducto;
    public ArrayList<Producto> arrayList;
    public ArbolAVL<Producto> arbolAVL;
    public ArbolAVL.NodoAVL raiz;
    public ArbolBinario<Producto> arbolBinario;
    public ArbolRojoNegro<Producto> arbolRojoNegro;
    public Cola<Producto> cola;
    public ListaDoble<Producto> listaDoble;

    public ProductoServiceImpl() {
        dbProducto = new ProductoDAOImpl();
        arrayList = dbProducto.read();

        arbolAVL = dbProducto.readArbolAVL();
        arbolBinario = dbProducto.readArbolABB();
        try {
            arbolRojoNegro = dbProducto.readArbolRojoNegro();
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        cola = dbProducto.readCola();
        listaDoble = dbProducto.readListaDoble();
    }

    public Producto getEncontrado() {
        return encontrado;
    }

    public DefaultTableModel mostrarArrayList() {
        DefaultTableModel dtm;
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        System.out.println(arrayList.size());
        return dtm;
    }

    public DefaultTableModel mostrarListaDoble() {
        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        System.out.println(cantidad);
        return dtm;
    }

    public DefaultTableModel mostrarCola() {
        DefaultTableModel dtm;
        int cantidad = this.cola.getLongitud();
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < cantidad; i++) {

            Producto prod = cola.desencolar();
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        System.out.println(cantidad);
        return dtm;
    }

    public DefaultTableModel mostrarArbolABB() {
        DefaultTableModel dtm;
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);
        System.out.println("Nodos de arbol binario: "+arbolBinario.getLongitud());
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();
        System.out.println("Nodos en el array: "+arrayL.size());

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel mostrarArbolAVL() {
        DefaultTableModel dtm;
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);

        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        System.out.println("Array SIZE: "+arrayL.size());

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }
    
    public DefaultTableModel mostrarArbolRN() {
        DefaultTableModel dtm;
        String[] titulos = {"Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);

        System.out.println(arbolRojoNegro.getNodos());
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
        System.out.println("Array SIZE: "+arrayL.size());

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public static void main(String[] args) {
        ProductoServiceImpl prod = new ProductoServiceImpl();
        prod.mostrarArbolRN();
        //prod.mostrarArbolABB();
    }

}
