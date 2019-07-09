/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.eapisw.controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.dao.implement.ProductoDAOImpl;
import pe.edu.unmsm.software.eapisw.model.Producto;
import pe.edu.unmsm.software.eapisw.service.BusquedaSecuencial;
import pe.edu.unmsm.software.eapisw.service.Ordenamiento;
import pe.edu.unmsm.software.eapisw.service.ProductoServiceImpl;

/**
 *
 * @author Purple
 */
public class frmProductoDemo extends javax.swing.JFrame {

    String ordenado = "id";

    public frmProductoDemo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        grupo.add(btnBurbuja);
        grupo.add(btnInsercion);
        grupo.add(btnSeleccion);
        grupo.add(btnQuicksort);

        btnQuicksort.setSelected(true);

        elemBusqueda.add(btnBusquedaID);
        elemBusqueda.add(btnBusquedaNombre);
        elemBusqueda.add(btnBusquedaCodigo);
        elemBusqueda.add(btnBusquedaPrecio);
        elemBusqueda.add(btnBusquedaStock);

        btnBusquedaID.setSelected(true);

    }

    /* --------------------------- MOSTRAR --------------------------*/
    void mostrarArrayList() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarArrayList();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void mostrarListaDoble() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarListaDoble();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void mostrarCola() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarCola();
        Tabla.setModel(modelo);
        ordenado = "id";
        //System.out.println(productoService.cola.getLongitud());
    }

    void mostrarArbolABB() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarArbolABB();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void mostrarArbolAVL() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarArbolAVL();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void mostrarArbolRN() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.mostrarArbolRN();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    /* --------------------------- ORDENAR --------------------------*/
    void ordenarListaDobleID() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        String com = "quicksort";
        if (btnBurbuja.isSelected()) {
            com = "burbuja";
        } else if (btnInsercion.isSelected()) {
            com = "insertion";
        } else if (btnSeleccion.isSelected()) {
            com = "selection";
        } else if (btnQuicksort.isSelected()) {
            com = "quicksort";
        }
        modelo = productoService.mostrarListaDoble();
        Tabla.setModel(modelo);
        ordenado = "id";

    }

    void ordenarListaDobleCodigo() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        String com = "quicksort";
        if (btnBurbuja.isSelected()) {
            com = "burbuja";
        } else if (btnInsercion.isSelected()) {
            com = "insertion";
        } else if (btnSeleccion.isSelected()) {
            com = "selection";
        } else if (btnQuicksort.isSelected()) {
            com = "quicksort";
        }
        modelo = productoService.ordenarListaDobleCodigo(com);
        Tabla.setModel(modelo);
        ordenado = "codigo";
    }

    void ordenarListaDobleNombre() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        String com = "quicksort";
        if (btnBurbuja.isSelected()) {
            com = "burbuja";
        } else if (btnInsercion.isSelected()) {
            com = "insertion";
        } else if (btnSeleccion.isSelected()) {
            com = "selection";
        } else if (btnQuicksort.isSelected()) {
            com = "quicksort";
        }
        modelo = productoService.ordenarListaDobleNombre(com);
        Tabla.setModel(modelo);
        ordenado = "nombre";
    }

    void ordenarListaDobleStock() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        String com = "quicksort";
        if (btnBurbuja.isSelected()) {
            com = "burbuja";
        } else if (btnInsercion.isSelected()) {
            com = "insertion";
        } else if (btnSeleccion.isSelected()) {
            com = "selection";
        } else if (btnQuicksort.isSelected()) {
            com = "quicksort";
        }
        modelo = productoService.ordenarListaDobleStock(com);
        Tabla.setModel(modelo);
        ordenado = "stock";
    }

    void ordenarListaDoblePrecioVenta() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        String com = "quicksort";
        if (btnBurbuja.isSelected()) {
            com = "burbuja";
        } else if (btnInsercion.isSelected()) {
            com = "insertion";
        } else if (btnSeleccion.isSelected()) {
            com = "selection";
        } else if (btnQuicksort.isSelected()) {
            com = "quicksort";
        }
        modelo = productoService.ordenarListaDoblePrecioVenta(com);
        Tabla.setModel(modelo);
        ordenado = "precio";
    }

    void ordenarArrayListCodigo() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArrayListCodigo();
        Tabla.setModel(modelo);
        ordenado = "codigo";
    }

    void ordenarArrayListNombre() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArrayListNombre();
        Tabla.setModel(modelo);
        ordenado = "nombre";
    }

    void ordenarArrayListStock() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArrayListStock();
        Tabla.setModel(modelo);
        ordenado = "stock";
    }

    void ordenarArrayListPrecioVenta() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArrayListPrecioVenta();
        Tabla.setModel(modelo);
        ordenado = "precio";
    }

    void ordenarArrayListID() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArrayListID();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    /*void ordenarArbolABBID() {
     ProductoServiceImpl productoService = new ProductoServiceImpl();

     DefaultTableModel modelo;
     modelo = productoService.ordenarArbolABBID();
     Tabla.setModel(modelo);
     }

     void ordenarArbolABBNombre() {
     ProductoServiceImpl productoService = new ProductoServiceImpl();

     DefaultTableModel modelo;
     modelo = productoService.ordenarArbolABBNombre();
     Tabla.setModel(modelo);
     }

     void ordenarArbolABBCodigo() {
     ProductoServiceImpl productoService = new ProductoServiceImpl();

     DefaultTableModel modelo;
     modelo = productoService.ordenarArbolABBCodigo();
     Tabla.setModel(modelo);
     }

     void ordenarArbolABBStock() {
     ProductoServiceImpl productoService = new ProductoServiceImpl();

     DefaultTableModel modelo;
     modelo = productoService.ordenarArbolABBStock();
     Tabla.setModel(modelo);
     }

     void ordenarArbolABBPrecioVenta() {
     ProductoServiceImpl productoService = new ProductoServiceImpl();

     DefaultTableModel modelo;
     modelo = productoService.ordenarArbolABBPrecioVenta();
     Tabla.setModel(modelo);
     }*/
    void ordenarArbolAVLID() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolAVLID();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void ordenarArbolAVLCodigo() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolAVLCodigo();
        Tabla.setModel(modelo);
        ordenado = "codigo";
    }

    void ordenarArbolAVLNombre() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolAVLNombre();
        Tabla.setModel(modelo);
        ordenado = "nombre";
    }

    void ordenarArbolAVLStock() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolAVLStock();
        Tabla.setModel(modelo);
        ordenado = "stock";
    }

    void ordenarArbolAVLPrecio() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolAVLPrecioVenta();
        Tabla.setModel(modelo);
        ordenado = "precio";
    }

    void ordenarArbolRNID() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolRNID();
        Tabla.setModel(modelo);
        ordenado = "id";
    }

    void ordenarArbolRNCodigo() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolRNCodigo();
        Tabla.setModel(modelo);
        ordenado = "codigo";
    }

    void ordenarArbolRNNombre() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolRNNombre();
        Tabla.setModel(modelo);
        ordenado = "nombre";
    }

    void ordenarArbolRNStock() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolRNStock();
        Tabla.setModel(modelo);
        ordenado = "stock";
    }

    void ordenarArbolRNPrecio() {
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo;
        modelo = productoService.ordenarArbolRNPrecioVenta();
        Tabla.setModel(modelo);
        ordenado = "precio";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        elemBusqueda = new javax.swing.ButtonGroup();
        tipoBusqueda = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnArrayList = new javax.swing.JButton();
        btnListaDoble = new javax.swing.JButton();
        btnCola = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnArbolAVL = new javax.swing.JButton();
        btnArbolRN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstructura = new javax.swing.JTextField();
        btnCodigo = new javax.swing.JButton();
        btnNombre = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        btnPrecio = new javax.swing.JButton();
        btnID = new javax.swing.JButton();
        btnBurbuja = new javax.swing.JRadioButton();
        btnInsercion = new javax.swing.JRadioButton();
        btnSeleccion = new javax.swing.JRadioButton();
        btnQuicksort = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBusquedaID = new javax.swing.JRadioButton();
        btnBusquedaCodigo = new javax.swing.JRadioButton();
        btnBusquedaNombre = new javax.swing.JRadioButton();
        btnBusquedaStock = new javax.swing.JRadioButton();
        btnBusquedaPrecio = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(875, 569));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Int", "ID", "Codigo", "Nombre", "Descripcion", "Caracteristicas", "Stock", "Precio Venta"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jLabel1.setText("Mostrar");

        btnArrayList.setText("ArrayList");
        btnArrayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrayListActionPerformed(evt);
            }
        });

        btnListaDoble.setText("Lista Doble");
        btnListaDoble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDobleActionPerformed(evt);
            }
        });

        btnCola.setText("Cola");
        btnCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColaActionPerformed(evt);
            }
        });

        jLabel2.setText("__________________");

        btnArbolAVL.setText("Arbol AVL");
        btnArbolAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolAVLActionPerformed(evt);
            }
        });

        btnArbolRN.setText("Arbol R-N");
        btnArbolRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolRNActionPerformed(evt);
            }
        });

        jLabel3.setText("Tiempo:");

        txtTiempo.setEnabled(false);

        jLabel4.setText("Estructura:");

        txtEstructura.setEnabled(false);

        btnCodigo.setText("Código");
        btnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoActionPerformed(evt);
            }
        });

        btnNombre.setText("Nombre");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        btnStock.setText("Stock");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });

        btnPrecio.setText("Precio Venta");
        btnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecioActionPerformed(evt);
            }
        });

        btnID.setText("ID Producto");
        btnID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDActionPerformed(evt);
            }
        });

        btnBurbuja.setText("Burbuja");

        btnInsercion.setText("Inserción");

        btnSeleccion.setText("Selección");

        btnQuicksort.setText("Quicksort");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel5.setText("Solo valido con Lista Doble");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Buscar:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBusquedaID.setText("ID");

        btnBusquedaCodigo.setText("Código");

        btnBusquedaNombre.setText("Nombre");

        btnBusquedaStock.setText("Stock");

        btnBusquedaPrecio.setText("Precio Venta");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setText("Aplicado con Lista Doble");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnArrayList)
                            .addComponent(btnListaDoble)
                            .addComponent(btnCola)
                            .addComponent(jLabel2)
                            .addComponent(btnArbolAVL)
                            .addComponent(btnArbolRN))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                            .addComponent(btnID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBurbuja)
                                            .addComponent(btnInsercion)
                                            .addComponent(btnSeleccion)
                                            .addComponent(btnQuicksort)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnBusquedaNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBusquedaID)
                                            .addComponent(btnBusquedaCodigo))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBusquedaStock)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBusquedaPrecio)
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel7)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(btnArrayList)
                        .addGap(18, 18, 18)
                        .addComponent(btnListaDoble)
                        .addGap(18, 18, 18)
                        .addComponent(btnCola)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(btnArbolAVL)
                        .addGap(31, 31, 31)
                        .addComponent(btnArbolRN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnID)
                                .addGap(18, 18, 18)
                                .addComponent(btnCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(btnNombre)
                                .addGap(18, 18, 18)
                                .addComponent(btnStock)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrecio)
                                .addGap(38, 38, 38)
                                .addComponent(btnBurbuja)
                                .addGap(18, 18, 18)
                                .addComponent(btnInsercion)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccion)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuicksort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBusquedaID)
                            .addComponent(btnBusquedaStock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBusquedaCodigo)
                            .addComponent(btnBusquedaPrecio)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusquedaNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArrayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrayListActionPerformed
        long INICIO_MS = System.currentTimeMillis();
        mostrarArrayList();
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("ArrayList");
    }//GEN-LAST:event_btnArrayListActionPerformed

    private void btnListaDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDobleActionPerformed
        long INICIO_MS = System.currentTimeMillis();
        mostrarListaDoble();
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("Lista Doble");
    }//GEN-LAST:event_btnListaDobleActionPerformed

    private void btnColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColaActionPerformed
        long INICIO_MS = System.currentTimeMillis();
        mostrarCola();
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("Cola");
    }//GEN-LAST:event_btnColaActionPerformed

    private void btnArbolAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolAVLActionPerformed
        long INICIO_MS = System.currentTimeMillis();
        mostrarArbolAVL();
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("Arbol AVL");
    }//GEN-LAST:event_btnArbolAVLActionPerformed

    private void btnArbolRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolRNActionPerformed
        long INICIO_MS = System.currentTimeMillis();
        mostrarArbolRN();
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("Arbol Rojo Negro");
    }//GEN-LAST:event_btnArbolRNActionPerformed

    private void btnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoActionPerformed
        if (txtEstructura.getText().equalsIgnoreCase("") || txtEstructura.getText().equalsIgnoreCase("ArrayList")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArrayListCodigo();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            txtEstructura.setText("ArrayList");
        } else if (txtEstructura.getText().equalsIgnoreCase("Lista Doble")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarListaDobleCodigo();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            if (btnBurbuja.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Burbuja.");
            } else if (btnSeleccion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Selection.");
            } else if (btnInsercion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Insertion.");
            } else if (btnQuicksort.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Quicksort.");
            } else {

            }
        } /*else if (txtEstructura.getText().equalsIgnoreCase("Arbol ABB")) {
         long INICIO_MS = System.currentTimeMillis();
         ordenarArbolABBCodigo();
         long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
         txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
         } */ else if (txtEstructura.getText().equalsIgnoreCase("Arbol AVL")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolAVLCodigo();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else if (txtEstructura.getText().equalsIgnoreCase("Arbol Rojo Negro")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolRNCodigo();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else {
            JOptionPane.showMessageDialog(null, "La estructura Cola no puede realizar ordenamiento");
        }
    }//GEN-LAST:event_btnCodigoActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        if (txtEstructura.getText().equalsIgnoreCase("") || txtEstructura.getText().equalsIgnoreCase("ArrayList")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArrayListNombre();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            txtEstructura.setText("ArrayList");
        } else if (txtEstructura.getText().equalsIgnoreCase("Lista Doble")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarListaDobleNombre();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            if (btnBurbuja.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Burbuja.");
            } else if (btnSeleccion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Selection.");
            } else if (btnInsercion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Insertion.");
            } else if (btnQuicksort.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Quicksort.");
            } else {

            }
        } /*else if (txtEstructura.getText().equalsIgnoreCase("Arbol ABB")) {
         long INICIO_MS = System.currentTimeMillis();
         ordenarArbolABBNombre();
         long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
         txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
         } */ else if (txtEstructura.getText().equalsIgnoreCase("Arbol AVL")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolAVLNombre();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else if (txtEstructura.getText().equalsIgnoreCase("Arbol Rojo Negro")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolRNNombre();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else {
            JOptionPane.showMessageDialog(null, "La estructura Cola no puede realizar ordenamiento");
        }
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        if (txtEstructura.getText().equalsIgnoreCase("") || txtEstructura.getText().equalsIgnoreCase("ArrayList")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArrayListStock();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            txtEstructura.setText("ArrayList");
        } else if (txtEstructura.getText().equalsIgnoreCase("Lista Doble")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarListaDobleStock();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            if (btnBurbuja.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Burbuja.");
            } else if (btnSeleccion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Selection.");
            } else if (btnInsercion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Insertion.");
            } else if (btnQuicksort.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Quicksort.");
            } else {

            }
        } /*else if (txtEstructura.getText().equalsIgnoreCase("Arbol ABB")) {
         long INICIO_MS = System.currentTimeMillis();
         ordenarArbolABBStock();
         long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
         txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
         } */ else if (txtEstructura.getText().equalsIgnoreCase("Arbol AVL")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolAVLStock();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else if (txtEstructura.getText().equalsIgnoreCase("Arbol Rojo Negro")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolRNStock();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else {
            JOptionPane.showMessageDialog(null, "La estructura Cola no puede realizar ordenamiento");
        }
    }//GEN-LAST:event_btnStockActionPerformed

    private void btnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecioActionPerformed
        if (txtEstructura.getText().equalsIgnoreCase("") || txtEstructura.getText().equalsIgnoreCase("ArrayList")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArrayListPrecioVenta();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            txtEstructura.setText("ArrayList");
        } else if (txtEstructura.getText().equalsIgnoreCase("Lista Doble")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarListaDoblePrecioVenta();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            if (btnBurbuja.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Burbuja.");
            } else if (btnSeleccion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Selection.");
            } else if (btnInsercion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Insertion.");
            } else if (btnQuicksort.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Quicksort.");
            } else {

            }

        } /*else if (txtEstructura.getText().equalsIgnoreCase("Arbol ABB")) {
         long INICIO_MS = System.currentTimeMillis();
         ordenarArbolABBPrecioVenta();
         long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
         txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
         } */ else if (txtEstructura.getText().equalsIgnoreCase("Arbol AVL")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolAVLPrecio();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else if (txtEstructura.getText().equalsIgnoreCase("Arbol Rojo Negro")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolRNPrecio();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else {
            JOptionPane.showMessageDialog(null, "La estructura Cola no puede realizar ordenamiento");
        }
    }//GEN-LAST:event_btnPrecioActionPerformed

    private void btnIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDActionPerformed
        if (txtEstructura.getText().equalsIgnoreCase("") || txtEstructura.getText().equalsIgnoreCase("ArrayList")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArrayListID();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            txtEstructura.setText("ArrayList");
        } else if (txtEstructura.getText().equalsIgnoreCase("Lista Doble")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarListaDobleID();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
            if (btnBurbuja.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Burbuja.");
            } else if (btnSeleccion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Selection.");
            } else if (btnInsercion.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Insertion.");
            } else if (btnQuicksort.isSelected()) {
                JOptionPane.showMessageDialog(null, "Se ha realizado el ordenamiento Quicksort.");
            } else {

            }
        } /*else if (txtEstructura.getText().equalsIgnoreCase("Arbol ABB")) {
         long INICIO_MS = System.currentTimeMillis();
         ordenarArbolABBID();
         long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
         txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
         } */ else if (txtEstructura.getText().equalsIgnoreCase("Arbol AVL")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolAVLID();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else if (txtEstructura.getText().equalsIgnoreCase("Arbol Rojo Negro")) {
            long INICIO_MS = System.currentTimeMillis();
            ordenarArbolRNID();
            long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
            txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        } else {
            JOptionPane.showMessageDialog(null, "La estructura Cola no puede realizar ordenamiento");
        }
    }//GEN-LAST:event_btnIDActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscar.getText();
        ProductoServiceImpl productoService = new ProductoServiceImpl();

        DefaultTableModel modelo = null;

        long INICIO_MS = System.currentTimeMillis();
        if (btnBusquedaStock.isSelected()) {
            modelo = productoService.busquedaSecuencial(texto, "stock");
        } else if (btnBusquedaID.isSelected()) {
            modelo = productoService.busquedaSecuencial(texto, "id");
        } else if (btnBusquedaCodigo.isSelected()) {
            modelo = productoService.busquedaSecuencial(texto, "codigo");
        } else if (btnBusquedaNombre.isSelected()) {
            modelo = productoService.busquedaSecuencial(texto, "nombre");
        } else if (btnBusquedaPrecio.isSelected()) {
            modelo = productoService.busquedaSecuencial(texto, "precio");
        }
        long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
        txtTiempo.setText(String.valueOf(DURACION_MS) + " ms.");
        txtEstructura.setText("Búsqueda");

        if (modelo == null) {
            modelo = productoService.mostrarArbolRN();
        }

        Tabla.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProductoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductoDemo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnArbolAVL;
    private javax.swing.JButton btnArbolRN;
    private javax.swing.JButton btnArrayList;
    private javax.swing.JRadioButton btnBurbuja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JRadioButton btnBusquedaCodigo;
    private javax.swing.JRadioButton btnBusquedaID;
    private javax.swing.JRadioButton btnBusquedaNombre;
    private javax.swing.JRadioButton btnBusquedaPrecio;
    private javax.swing.JRadioButton btnBusquedaStock;
    private javax.swing.JButton btnCodigo;
    private javax.swing.JButton btnCola;
    private javax.swing.JButton btnID;
    private javax.swing.JRadioButton btnInsercion;
    private javax.swing.JButton btnListaDoble;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnPrecio;
    private javax.swing.JRadioButton btnQuicksort;
    private javax.swing.JRadioButton btnSeleccion;
    private javax.swing.JButton btnStock;
    private javax.swing.ButtonGroup elemBusqueda;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup tipoBusqueda;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEstructura;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
