package pe.edu.unmsm.software.eapisw.service;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;
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

    }

    public Producto getEncontrado() {
        return encontrado;
    }

    /*MOSTRAR*/
    public DefaultTableModel mostrarArrayList() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel mostrarListaDoble() {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);

        }
        return dtm;
    }

    public DefaultTableModel mostrarCola() {
        cola = dbProducto.readCola();

        DefaultTableModel dtm;
        int cantidad = this.cola.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

        for (int i = 0; i < cantidad; i++) {

            Producto prod = cola.desencolar();
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel mostrarArbolABB() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel mostrarArbolAVL() {
        arbolAVL = dbProducto.readArbolAVL("");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

        ArrayList<Producto> arrayL = arbolAVL.getInOrden();

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel mostrarArbolRN() {
        arbolRojoNegro = dbProducto.readArbolRojoNegro("");
        

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    /*ORDENAMIENTO*/
    //------ARRAYLIST------
    public DefaultTableModel ordenarArrayListID() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        Ordenamiento.ArrayID(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArrayListCodigo() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        Ordenamiento.ArrayCodigo(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArrayListNombre() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        Ordenamiento.ArrayNombre(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArrayListStock() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        Ordenamiento.ArrayStock(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArrayListPrecioVenta() {
        arrayList = dbProducto.read();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        Ordenamiento.ArrayPrecioVenta(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Producto prod = arrayList.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    //------LISTA DOBLE------
    public DefaultTableModel ordenarListaDobleID(String com) {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        if (com.equalsIgnoreCase("quicksort")) {
            Ordenamiento.QuicksortID(listaDoble, 0, cantidad - 1);
        } else if (com.equalsIgnoreCase("selection")) {
            Ordenamiento.SeleccionID(listaDoble);
        } else if (com.equalsIgnoreCase("insertion")) {
            Ordenamiento.InsercionID(listaDoble);
        } else if (com.equalsIgnoreCase("burbuja")) {
            Ordenamiento.BurbujaID(listaDoble);
        } else {
            JOptionPane.showMessageDialog(null, "La estructura actual no tiene ordenamiento provisto de ArrayList");
        }
        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarListaDobleCodigo(String com) {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};
        dtm = new DefaultTableModel(null, titulos);

        if (com.equalsIgnoreCase("quicksort")) {
            Ordenamiento.QuicksortCodigo(listaDoble, 0, cantidad - 1);
        } else if (com.equalsIgnoreCase("selection")) {
            Ordenamiento.SeleccionCodigo(listaDoble);
        } else if (com.equalsIgnoreCase("insertion")) {
            Ordenamiento.InsercionCodigo(listaDoble);
        } else if (com.equalsIgnoreCase("burbuja")) {
            Ordenamiento.BurbujaCodigo(listaDoble);
        } else {
            JOptionPane.showMessageDialog(null, "La estructura actual no tiene ordenamiento provisto de ArrayList");
        }
        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarListaDobleNombre(String com) {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        if (com.equalsIgnoreCase("quicksort")) {
            Ordenamiento.QuicksortNombre(listaDoble, 0, cantidad - 1);
        } else if (com.equalsIgnoreCase("selection")) {
            Ordenamiento.SeleccionNombre(listaDoble);
        } else if (com.equalsIgnoreCase("insertion")) {
            Ordenamiento.InsercionNombre(listaDoble);
        } else if (com.equalsIgnoreCase("burbuja")) {
            Ordenamiento.BurbujaNombre(listaDoble);
        } else {
            JOptionPane.showMessageDialog(null, "La estructura actual no tiene ordenamiento provisto de ArrayList");
        }
        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarListaDobleStock(String com) {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        if (com.equalsIgnoreCase("quicksort")) {
            Ordenamiento.QuicksortStock(listaDoble, 0, cantidad - 1);
        } else if (com.equalsIgnoreCase("selection")) {
            Ordenamiento.SeleccionStock(listaDoble);
        } else if (com.equalsIgnoreCase("insertion")) {
            Ordenamiento.InsercionStock(listaDoble);
        } else if (com.equalsIgnoreCase("burbuja")) {
            Ordenamiento.BurbujaStock(listaDoble);
        } else {
            JOptionPane.showMessageDialog(null, "La estructura actual no tiene ordenamiento provisto de ArrayList");
        }

        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarListaDoblePrecioVenta(String com) {
        listaDoble = dbProducto.readListaDoble();

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        if (com.equalsIgnoreCase("quicksort")) {
            Ordenamiento.QuicksortPrecioVenta(listaDoble, 0, cantidad - 1);
        } else if (com.equalsIgnoreCase("selection")) {
            Ordenamiento.SeleccionPrecioVenta(listaDoble);
        } else if (com.equalsIgnoreCase("insertion")) {
            Ordenamiento.InsercionPrecioVenta(listaDoble);
        } else if (com.equalsIgnoreCase("burbuja")) {
            Ordenamiento.BurbujaPrecioVenta(listaDoble);
        } else {
            JOptionPane.showMessageDialog(null, "La estructura actual no tiene ordenamiento provisto de ArrayList");
        }
        for (int i = 0; i < cantidad; i++) {
            Producto prod = listaDoble.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    //------ARBOL ABB------
    public DefaultTableModel ordenarArbolABBID() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();

        arbolBinario.setComparador(Comparator.comparing(Producto::getIdProducto));

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArbolABBCodigo() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();
        //Ordenamiento.ArrayCodigo(arrayL);
        arbolBinario.setComparador(Comparator.comparing(Producto::getCodigo));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArbolABBNombre() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();
        //Ordenamiento.ArrayNombre(arrayL);
        arbolBinario.setComparador(Comparator.comparing(Producto::getNombre));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArbolABBStock() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();
        //Ordenamiento.ArrayStock(arrayL);
        arbolBinario.setComparador(Comparator.comparing(Producto::getStock));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    public DefaultTableModel ordenarArbolABBPrecioVenta() {
        arbolBinario = dbProducto.readArbolABB();

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolBinario.getInOrden();
        //Ordenamiento.ArrayPrecioVenta(arrayL);
        arbolBinario.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }
        return dtm;
    }

    //------ARBOL AVL------
    public DefaultTableModel ordenarArbolAVLID() {
        arbolAVL = dbProducto.readArbolAVL("");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

//        ProductoComparatorID cpm = new ProductoComparatorID();
//        arbolAVL.setComparador(cpm);
        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        //Ordenamiento.ArrayID(arrayL);
        //arbolAVL.setComparador(Comparator.comparing(Producto::getIdProducto));

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolAVLCodigo() {
        arbolAVL = dbProducto.readArbolAVL("codigo");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

//        ProductoComparatorCodigo cpm = new ProductoComparatorCodigo();
//        arbolAVL.setComparador(cpm);
        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        //Ordenamiento.ArrayCodigo(arrayL);
        //arbolAVL.setComparador(Comparator.comparing(Producto::getCodigo));

        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolAVLNombre() {
        arbolAVL = dbProducto.readArbolAVL("nombre");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

//        ProductoComparatorNombre cpm = new ProductoComparatorNombre();
//        arbolAVL.setComparador(cpm);
        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        //Ordenamiento.ArrayNombre(arrayL);

        //arbolAVL.setComparador(Comparator.comparing(Producto::getNombre));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolAVLStock() {
        arbolAVL = dbProducto.readArbolAVL("stock");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

//        ProductoComparatorStock cpm = new ProductoComparatorStock();
//        arbolAVL.setComparador(cpm);
        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        //Ordenamiento.ArrayStock(arrayL);

        //arbolAVL.setComparador(Comparator.comparing(Producto::getStock));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolAVLPrecioVenta() {
        arbolAVL = dbProducto.readArbolAVL("precio");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

//        ProductoComparatorPrecioVenta cpm = new ProductoComparatorPrecioVenta();
//        arbolAVL.setComparador(cpm);
        ArrayList<Producto> arrayL = arbolAVL.getInOrden();
        //Ordenamiento.ArrayPrecioVenta(arrayL);

        //arbolAVL.setComparador(Comparator.comparing(Producto::getPrecio_venta));
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    //------ARBOL RN------
    public DefaultTableModel ordenarArbolRNID() {

        arbolRojoNegro = dbProducto.readArbolRojoNegro("");

        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();

        Ordenamiento.ArrayID(arrayL);
     
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolRNCodigo() {
        arbolRojoNegro = dbProducto.readArbolRojoNegro("codigo");
        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
//        ProductoComparatorCodigo cpm = new ProductoComparatorCodigo();
//        arbolRojoNegro.setComparador(cpm);
        Ordenamiento.ArrayCodigo(arrayL);
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolRNNombre() {
        arbolRojoNegro = dbProducto.readArbolRojoNegro("nombre");
        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
//        ProductoComparatorNombre cpm = new ProductoComparatorNombre();
//        arbolRojoNegro.setComparador(cpm);
        Ordenamiento.ArrayNombre(arrayL);
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolRNStock() {
        arbolRojoNegro = dbProducto.readArbolRojoNegro("stock");
        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
//        ProductoComparatorStock cpm = new ProductoComparatorStock();
//        arbolRojoNegro.setComparador(cpm);
        Ordenamiento.ArrayStock(arrayL);
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    public DefaultTableModel ordenarArbolRNPrecioVenta() {
        arbolRojoNegro = dbProducto.readArbolRojoNegro("precio");
        DefaultTableModel dtm;
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);
        ArrayList<Producto> arrayL = arbolRojoNegro.getInOrden();
//        ProductoComparatorPrecioVenta cpm = new ProductoComparatorPrecioVenta();
//        arbolRojoNegro.setComparador(cpm);
        Ordenamiento.ArrayPrecioVenta(arrayL);
        for (int i = 0; i < arrayL.size(); i++) {
            Producto prod = arrayL.get(i);
            Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
            dtm.addRow(fila);
        }

        return dtm;
    }

    /* BUSQUEDA */
    public DefaultTableModel busquedaSecuencial(String com, String tipo) {
        listaDoble = dbProducto.readListaDoble();

        int aux1 = 0;
        double aux2 = 0;

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

        ListaDoble<Producto> listaRespuesta = null;

        switch (tipo) {

            case "codigo":
                listaRespuesta = BusquedaSecuencial.busquedaSecuencialCodigo(listaDoble, com);
                break;

            case "nombre":
                listaRespuesta = BusquedaSecuencial.busquedaSecuencialNombre(listaDoble, com);
                break;

            case "id":
                try {
                    aux1 = Integer.parseInt(com);
                    listaRespuesta = BusquedaSecuencial.busquedaSecuencialID(listaDoble, aux1);
                } catch (NumberFormatException e) {
                }
                break;

            case "stock":
                try {
                    aux1 = Integer.parseInt(com);
                    listaRespuesta = BusquedaSecuencial.busquedaSecuencialStock(listaDoble, aux1);
                } catch (NumberFormatException e) {
                }
                break;

            case "precio":
                try {
                    aux2 = Double.parseDouble(com);
                    listaRespuesta = BusquedaSecuencial.busquedaSecuencialPrecio(listaDoble, aux2);
                } catch (NumberFormatException e) {
                }
                break;

            default:
                listaRespuesta = null;
        }

        if (listaRespuesta != null) {
            for (int i = 0; i < listaRespuesta.getLongitud(); i++) {
                Producto prod = listaRespuesta.get(i);
                Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                    prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
                dtm.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto con codigo " + com);
        }
        return dtm;
    }
    
    public DefaultTableModel busquedaBinaria(String com, String tipo) {
        listaDoble = dbProducto.readListaDoble();

        int aux1 = 0;
        double aux2 = 0;

        DefaultTableModel dtm;
        int cantidad = this.listaDoble.getLongitud();
        String[] titulos = {"Int", "ID", "Código", "Nombre", "Descripción", "Caracteristicas", "Stock", "Precio"};

        dtm = new DefaultTableModel(null, titulos);

        ListaDoble<Producto> listaRespuesta = null;

        switch (tipo) {

            case "codigo":
                listaRespuesta = BusquedaBinaria.busquedaBinariaCodigo(listaDoble, com);
                break;

            case "nombre":
                listaRespuesta = BusquedaBinaria.busquedaBinariaNombre(listaDoble, com);
                break;

            case "id":
                try {
                    aux1 = Integer.parseInt(com);
                    listaRespuesta = BusquedaBinaria.busquedaBinariaID(listaDoble, aux1);
                } catch (NumberFormatException e) {
                }
                break;

            case "stock":
                try {
                    aux1 = Integer.parseInt(com);
                    listaRespuesta = BusquedaBinaria.busquedaBinariaStock(listaDoble, aux1);
                } catch (NumberFormatException e) {
                }
                break;

            case "precio":
                try {
                    aux2 = Double.parseDouble(com);
                    listaRespuesta = BusquedaBinaria.busquedaBinariaPrecio(listaDoble, aux2);
                } catch (NumberFormatException e) {
                }
                break;

            default:
                listaRespuesta = null;
        }

        if (listaRespuesta != null) {
            for (int i = 0; i < listaRespuesta.getLongitud(); i++) {
                Producto prod = listaRespuesta.get(i);
                Object[] fila = new Object[]{i, prod.getIdProducto(), prod.getCodigo(), prod.getNombre(), prod.getDescripcion(),
                    prod.getCaracteristicas(), prod.getStock(), prod.getPrecio_venta()};
                dtm.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto con codigo " + com);
        }
        return dtm;

    }
    
    

}
