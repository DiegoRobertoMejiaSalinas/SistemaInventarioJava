/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.eapisw.controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unmsm.software.eapisw.model.Cliente;
import pe.edu.unmsm.software.eapisw.service.ClienteServiceImpl;

/**
 *
 * @author Purple
 */
public class ClienteLista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClienteLista
     */
    public ClienteLista() {
        initComponents();
        this.setResizable(false);
        mostrarTabla();
    }
    
    void darFormaTabla() {
        Tabla.getColumnModel().getColumn(0).setMinWidth(20);
        Tabla.getColumnModel().getColumn(1).setMinWidth(20);
        Tabla.getColumnModel().getColumn(2).setMinWidth(100);
        Tabla.getColumnModel().getColumn(3).setMinWidth(100);
        Tabla.getColumnModel().getColumn(4).setMinWidth(100);
        Tabla.getColumnModel().getColumn(5).setMinWidth(100);
        Tabla.getColumnModel().getColumn(6).setMinWidth(120);
        Tabla.getColumnModel().getColumn(7).setMinWidth(30);
        Tabla.getColumnModel().getColumn(8).setMinWidth(100);
        Tabla.getColumnModel().getColumn(10).setMinWidth(130);

    }

    public void mostrarTabla() {
        ClienteServiceImpl trabajadorService = new ClienteServiceImpl();
        DefaultTableModel modelo = trabajadorService.mostrarArbolAVL();
        Tabla.setModel(modelo);
        darFormaTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int seleccionado = Tabla.getSelectedRow();

            int id = Integer.parseInt(Tabla.getValueAt(seleccionado, 1).toString());
            String nombre = Tabla.getValueAt(seleccionado, 2).toString();
            String paterno = Tabla.getValueAt(seleccionado, 3).toString();
            String materno = Tabla.getValueAt(seleccionado, 4).toString();
            String tipoDoc = Tabla.getValueAt(seleccionado, 5).toString();
            String numDoc = Tabla.getValueAt(seleccionado, 6).toString();
            String direccion= Tabla.getValueAt(seleccionado, 7).toString();
            String telefono= Tabla.getValueAt(seleccionado, 8).toString();
            String email= Tabla.getValueAt(seleccionado, 9).toString();
            String codigoCliente= Tabla.getValueAt(seleccionado, 10).toString();

            Cliente prod = new Cliente();
            prod.setIdPersona(id);
            prod.setNombre(nombre);
            prod.setaPaterno(paterno);
            prod.setaMaterno(materno);
            prod.setTipoDocumento(tipoDoc);
            prod.setNumeroDocumento(numDoc);
            prod.setDireccion(direccion);
            prod.setTelefono(telefono);
            prod.setEmail(email);
            prod.setCodigoCliente(codigoCliente);

            frmClienteCrear crear = new frmClienteCrear();
            crear.editar(prod);
            //crear.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Primero seleccione un cliente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
