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
        lblImagenNiño.setVisible(false);
        lblImagenNiña.setVisible(false);
        lblImagenIndefinido.setVisible(false);
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
        info = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        info2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagenNiño = new javax.swing.JLabel();
        lblImagenNiña = new javax.swing.JLabel();
        lblImagenIndefinido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        info5 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        info6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        info7 = new javax.swing.JLabel();
        lblUltimaConsulta = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        info8 = new javax.swing.JLabel();
        lblCita = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        pnlagregar = new javax.swing.JPanel();
        info9 = new javax.swing.JLabel();
        pnlayuda = new javax.swing.JPanel();
        info10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        info11 = new javax.swing.JLabel();
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

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Alergias:");
        jPanel3.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 52, 20));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 280, 7));

        lblPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(102, 102, 102));
        lblPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaciente.setText("ALexander Rubicel Orozco Salmeron");
        jPanel3.add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 300, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/age.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 10));

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setText("Edad:");
        jPanel3.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/alergias.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        lblEdad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 220, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagenNiño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caraniño.png"))); // NOI18N
        jPanel1.add(lblImagenNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        lblImagenNiña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caraniña.png"))); // NOI18N
        jPanel1.add(lblImagenNiña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        lblImagenIndefinido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caraindefinido.png"))); // NOI18N
        jPanel1.add(lblImagenIndefinido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 100, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        info3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info3.setForeground(new java.awt.Color(102, 102, 102));
        info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info3.setText("Teléfono:");
        jPanel3.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 200, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/genre.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        info5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info5.setForeground(new java.awt.Color(102, 102, 102));
        info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info5.setText("Género:");
        jPanel3.add(info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 50, 20));

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 210, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        txtAlergias.setEditable(false);
        txtAlergias.setColumns(20);
        txtAlergias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAlergias.setForeground(new java.awt.Color(102, 102, 102));
        txtAlergias.setLineWrap(true);
        txtAlergias.setRows(5);
        txtAlergias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAlergias.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtAlergias.setOpaque(false);
        txtAlergias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlergiasKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtAlergias);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 80));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 300, 80));

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setForeground(new java.awt.Color(102, 102, 102));
        info6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info6.setText("Notas:  ");
        jPanel3.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 50, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/note.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        txtNotas.setEditable(false);
        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNotas.setForeground(new java.awt.Color(102, 102, 102));
        txtNotas.setLineWrap(true);
        txtNotas.setRows(5);
        txtNotas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNotas.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtNotas.setOpaque(false);
        txtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotasKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtNotas);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 130));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 300, 130));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 280, 10));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ultimacosulta.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, -1, 20));

        info7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info7.setForeground(new java.awt.Color(102, 102, 102));
        info7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info7.setText("Última Consulta:");
        jPanel3.add(info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 305, 100, 20));

        lblUltimaConsulta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUltimaConsulta.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblUltimaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 305, 150, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/date.png"))); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 325, -1, 20));

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setForeground(new java.awt.Color(102, 102, 102));
        info8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info8.setText("Citas:");
        jPanel3.add(info8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 325, 40, 20));

        lblCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCita.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 325, 220, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/address.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 260, 20));
        jPanel3.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlagregar.setBackground(new java.awt.Color(255, 255, 255));
        pnlagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregarMouseEntered(evt);
            }
        });
        pnlagregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info9.setForeground(new java.awt.Color(128, 128, 131));
        info9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/expedietne.png"))); // NOI18N
        pnlagregar.add(info9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel10.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        pnlayuda.setBackground(new java.awt.Color(255, 255, 255));
        pnlayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlayudaMouseEntered(evt);
            }
        });
        pnlayuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info10.setForeground(new java.awt.Color(128, 128, 131));
        info10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ayuda30.png"))); // NOI18N
        pnlayuda.add(info10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel10.add(pnlayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 40));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, 10));

        info11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info11.setForeground(new java.awt.Color(0, 128, 128));
        info11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info11.setText("Consultorio Médico");
        jPanel3.add(info11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(239, 238, 244));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info1.setForeground(new java.awt.Color(128, 128, 131));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setText("Consultas");
        jPanel7.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 735, 40));

        jPanel9.setBackground(new java.awt.Color(251, 251, 251));

        pnlPrincipal.setBackground(new java.awt.Color(251, 251, 251));

        jScrollPane1.setBackground(new java.awt.Color(251, 251, 251));
        jScrollPane1.setBorder(null);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Clave", "Fecha", "Hora", "Atendio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(250);
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

    private void txtAlergiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlergiasKeyTyped

    }//GEN-LAST:event_txtAlergiasKeyTyped

    private void txtNotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotasKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

    }//GEN-LAST:event_tablaMouseClicked

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        Registrar poper = new Registrar(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlayudaMouseClicked
        Ayuda3 AP= new Ayuda3(null, true);
        AP.setVisible(true);
    }//GEN-LAST:event_pnlayudaMouseClicked

    private void pnlayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlayudaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlayudaMouseEntered
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    public static javax.swing.JLabel info10;
    public static javax.swing.JLabel info11;
    public static javax.swing.JLabel info2;
    public static javax.swing.JLabel info3;
    public static javax.swing.JLabel info5;
    public static javax.swing.JLabel info6;
    public static javax.swing.JLabel info7;
    public static javax.swing.JLabel info8;
    public static javax.swing.JLabel info9;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public static javax.swing.JLabel lblCita;
    public static javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEdad;
    public static javax.swing.JLabel lblGenero;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JLabel lblImagenIndefinido;
    public static javax.swing.JLabel lblImagenNiña;
    public static javax.swing.JLabel lblImagenNiño;
    public static javax.swing.JLabel lblPaciente;
    public static javax.swing.JLabel lblTelefono;
    public static javax.swing.JLabel lblUltimaConsulta;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnlayuda;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextArea txtAlergias;
    public static javax.swing.JTextArea txtNotas;
    // End of variables declaration//GEN-END:variables
}
