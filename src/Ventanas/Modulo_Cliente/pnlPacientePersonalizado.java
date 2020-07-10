/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas.Modulo_Cliente;

import A_tabla.*;
import Alerts.Ayuda3;
import Clases.Conexion;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class pnlPacientePersonalizado extends javax.swing.JPanel {

    public pnlPacientePersonalizado() {
        initComponents();
        JScrollPane scroller = new JScrollPane(jPanel2);
        lblID.setVisible(false);
        this.jLabel1.setVisible(false);
        
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader1());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer1());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        info5 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        info6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        info1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setPreferredSize(new java.awt.Dimension(1106, 648));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(102, 102, 102));
        lblPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaciente.setText("SABRITAS S.A DE C.V");
        jPanel3.add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 300, 40));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 10));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/genre.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        info5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info5.setForeground(new java.awt.Color(102, 102, 102));
        info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info5.setText("Dirección:");
        jPanel3.add(info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 20));

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(102, 102, 102));
        lblGenero.setText("Sr. Juan Carlos Garcia Marin");
        jPanel3.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, 20));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 280, 10));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/address.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(102, 102, 102));
        lblDireccion.setText("Toluca de Lerdo, Estado de México.");
        jPanel3.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 260, 20));
        jPanel3.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 280, 10));

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Visualizar Transportes");
        pnlorigenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseExited(evt);
            }
        });
        pnlorigenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("     Global");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 314, 69));

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setForeground(new java.awt.Color(102, 102, 102));
        info6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info6.setText("Atención a:");
        jPanel3.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 80, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(239, 238, 244));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info1.setForeground(new java.awt.Color(128, 128, 131));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setText("Cotizaciones del Cliente");
        jPanel7.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 735, 40));

        jPanel9.setBackground(new java.awt.Color(251, 251, 251));

        pnlPrincipal.setBackground(new java.awt.Color(251, 251, 251));

        jScrollPane1.setBackground(new java.awt.Color(251, 251, 251));
        jScrollPane1.setBorder(null);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave de Cotizacion", "Fecha de Alta", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(60);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 735, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

    }//GEN-LAST:event_tablaMouseClicked

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
//        ver();
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel info1;
    private javax.swing.JLabel info5;
    public static javax.swing.JLabel info6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlorigenes;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
