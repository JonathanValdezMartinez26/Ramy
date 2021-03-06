package Ventanas.Modulo_Cliente;

import A_tabla.*;
import Clases.Clientes;
import Clases.Conexion;
import Ventanas.CotizacionReporte.ConfigCotizacionclienteayuda;
import static Ventanas.Modulo_Cliente.Registrar.B;
import static Ventanas.Modulo_Cliente.Registrar.C;
import static Ventanas.Modulo_Cliente.Registrar.PanelDesliza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import rojerusan.RSPanelsSlider;

public class pnlClientes extends javax.swing.JPanel {

    public pnlClientes() {
        initComponents();
        Opciones.listar("");
        tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        
    }
    public void Modificar() {

        int Fila = tabla1.getSelectedRow();
        int Filita = 1; 
  
        if (Fila >= 0) {

            int ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            String localidad = (tabla1.getValueAt(Fila, 5).toString());
            String municipio = (tabla1.getValueAt(Fila, 4).toString());
            String estado = (tabla1.getValueAt(Fila, 3).toString());
            String atencion = (tabla1.getValueAt(Fila, 2).toString());
            
            ModificarCliente MP = new ModificarCliente(null, true);
            MP.CargarDatos(ID,atencion, localidad, municipio, estado);
            MP.setVM(this);
            MP.setVisible(true);

        } else {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("A modificar");
            AC.setVisible(true);
        }
    }
    
    ///////////////////
    public void Origenes()
    {    
        int Fila = tabla1.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
//          a.PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log1.setVisible(false);
          
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }
    ////////////////////
    public void Destinos()
    {    
        int Fila = tabla1.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log2.setVisible(false);
            a.log3.setVisible(false);
           
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }
    ////////////////////
    public void Rutas()
    {    
        int Fila = tabla1.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, C, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log4.setVisible(false);
            a.log5.setVisible(false);

        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnldestinos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnleditar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlviajes = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlpdf = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlAyuda = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre del Cliente", "Atención", "Estado", "Municipio", "Localidad", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(1).setResizable(false);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(190);
            tabla1.getColumnModel().getColumn(2).setResizable(false);
            tabla1.getColumnModel().getColumn(2).setPreferredWidth(154);
            tabla1.getColumnModel().getColumn(3).setResizable(false);
            tabla1.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(4).setResizable(false);
            tabla1.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(5).setResizable(false);
            tabla1.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla1.getColumnModel().getColumn(6).setResizable(false);
            tabla1.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("   Clientes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 70));

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Agregar Cliente");
        pnlagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregarMouseExited(evt);
            }
        });
        pnlagregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("    Agregar");
        pnlagregar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo.png"))); // NOI18N
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

        pnldestinos.setBackground(new java.awt.Color(225, 225, 225));
        pnldestinos.setToolTipText("Agregar Destinos");
        pnldestinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnldestinosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnldestinosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnldestinosMouseExited(evt);
            }
        });
        pnldestinos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("   Destinos");
        pnldestinos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/destino.png"))); // NOI18N
        pnldestinos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnldestinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, 69));

        pnleditar.setBackground(new java.awt.Color(225, 225, 225));
        pnleditar.setToolTipText("Editar Cliente");
        pnleditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnleditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnleditarMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnleditarMouseClicked(evt);
            }
        });
        pnleditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("     Editar");
        pnleditar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        pnleditar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 69));

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Agregar Origenes");
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
        jLabel15.setText("   Origenes");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/origen.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 69));

        pnlviajes.setBackground(new java.awt.Color(225, 225, 225));
        pnlviajes.setToolTipText("Asignación Origenes - Destinos");
        pnlviajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlviajesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlviajesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlviajesMouseExited(evt);
            }
        });
        pnlviajes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText(" Costo/Ruta");
        pnlviajes.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrega-40.png"))); // NOI18N
        pnlviajes.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlviajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 69));

        pnlpdf.setBackground(new java.awt.Color(225, 225, 225));
        pnlpdf.setToolTipText("Reporte");
        pnlpdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlpdfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlpdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlpdfMouseExited(evt);
            }
        });
        pnlpdf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("     Global");
        pnlpdf.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlpdf.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 69));

        pnlAyuda.setBackground(new java.awt.Color(225, 225, 225));
        pnlAyuda.setToolTipText("Ayuda");
        pnlAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseExited(evt);
            }
        });
        pnlAyuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("     Ayuda");
        pnlAyuda.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ayuda.png"))); // NOI18N
        pnlAyuda.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 40, 40));

        jPanel12.add(pnlAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 80, 69));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(0, 144, 183));
        buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 20, 145, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 652));
    }// </editor-fold>//GEN-END:initComponents

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        JTable table =(JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount() == 2)
        {
            String a = tabla1.getValueAt(tabla1.getSelectedRow() , 0).toString();
            int id = Integer.parseInt(a);
            String nombre = tabla1.getValueAt(tabla1.getSelectedRow() , 1).toString();
            String atencion = tabla1.getValueAt(tabla1.getSelectedRow() , 2).toString();
            String direccion = tabla1.getValueAt(tabla1.getSelectedRow() , 6).toString();
            
            pnlPacientePersonalizado poper = new pnlPacientePersonalizado();
              
            Opciones.listarDetalles(id,nombre,atencion,direccion);
            poper.setSize(1106, 654);
            pnlPrincipal.removeAll();
            pnlPrincipal.add(poper);
            pnlPrincipal.revalidate();
            pnlPrincipal.repaint();
        }
    }//GEN-LAST:event_tabla1MouseClicked

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        AgregarCliente poper = new AgregarCliente(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
    Opciones.listar(this.buscar.getText().trim());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void pnldestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnldestinosMouseClicked
        int Fila = tabla1.getSelectedRow();
      
        if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.log2.setVisible(false);
            a.log3.setVisible(false);
            a.a3.setText("Destinos.");
            a.setVisible(true);
            a.cmbEstado1.requestFocus();
           
           
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }//GEN-LAST:event_pnldestinosMouseClicked

    private void pnldestinosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnldestinosMouseEntered
        pnldestinos.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnldestinosMouseEntered

    private void pnldestinosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnldestinosMouseExited
        pnldestinos.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnldestinosMouseExited

    private void pnleditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseClicked
        Modificar();
    }//GEN-LAST:event_pnleditarMouseClicked

    private void pnleditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseEntered
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnleditarMouseEntered

    private void pnleditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseExited
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnleditarMouseExited

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
        int Fila = tabla1.getSelectedRow();
      
        if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.log1.setVisible(false);
            a.a3.setText("Origenes.");
            a.setVisible(true);
            a.cmbEstado.requestFocus();
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited

    private void pnlviajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlviajesMouseClicked
    int Fila = tabla1.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla1.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, C, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            //a.Actualizar_Tabla(ID);
            a.listar(ID);
            a.log4.setVisible(false);
            a.log5.setVisible(false);
            a.a3.setText("Asignación a Servicios.");
            //if (Ventanas.Modulo_Cliente.Opciones.verificaViaje(ID) == 0) {
                Ventanas.Modulo_Cliente.Registrar.cmbDestinos.addItem("Todos los Destinos");            
                //a.ComboDestino(ID);
                a.ComboOrigen(ID);                
            //} else {
              //  a.ComboDestinoNormal(ID);
               // a.ComboOrigen(ID);                
            //}
            a.ComboTransportes();
            a.setVisible(true);
            a.cmbOrigenes.requestFocus();
            
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }//GEN-LAST:event_pnlviajesMouseClicked

    private void pnlviajesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlviajesMouseEntered
        pnlviajes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlviajesMouseEntered

    private void pnlviajesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlviajesMouseExited
        pnlviajes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlviajesMouseExited

    private void pnlpdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseExited
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlpdfMouseExited

    private void pnlpdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseEntered
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlpdfMouseEntered

    private void pnlpdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseClicked
        ver();
    }//GEN-LAST:event_pnlpdfMouseClicked

    private void pnlAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseClicked

        ConfigCotizacionclienteayuda poper =new Ventanas.CotizacionReporte.ConfigCotizacionclienteayuda(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlAyudaMouseClicked

    private void pnlAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseEntered
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlAyudaMouseEntered

    private void pnlAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseExited
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlAyudaMouseExited
     
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlAyuda;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnldestinos;
    private javax.swing.JPanel pnleditar;
    private javax.swing.JPanel pnlorigenes;
    private javax.swing.JPanel pnlpdf;
    private javax.swing.JPanel pnlviajes;
    public static javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
     
     
   
  
    
//    public void ver() {
//        Clases.Conexion cc = new Clases.Conexion();
//        
//       int Fila = pnlClientes.tabla1.getSelectedRow();
//        int Filita = 1; 
//  
//        if (Fila >= 0) {
//
//      int ID = Integer.parseInt(pnlClientes.tabla1.getValueAt(Fila, 0).toString());
//            
//    
//       try {
//            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
//            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Ruta.jasper";
//            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
//            Map parametro = new HashMap();
//            parametro.put("ID_Cliente", ID);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());
//
//            JRViewer jrv = new JRViewer(jasperPrint);
//            jrv.setZoomRatio((float) 0.75);
//            r.contenedor.removeAll();
//
//            r.contenedor.setLayout(new BorderLayout());
//            r.contenedor.add(jrv, BorderLayout.CENTER);
//
//            r.contenedor.repaint();
//            r.contenedor.revalidate();
//            jrv.setVisible(true);
//            r.setVisible(true);
//        } catch (JRException ex) {
//            System.err.println("Error iReport: " + ex.getMessage());
//        }
//    }
//        else
//        {
//            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
//            AC.msj1.setText("¡Seleccione el registro!");
//            AC.msj2.setText("a visualizar");
//            AC.setVisible(true);
//        }
//}
    
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
//            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Clientes.jasper";
            String archivo = "/Reportes/Clientes.jasper";
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(archivo));
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("logo", this.getClass().getResourceAsStream("/Consultas/reporte.png"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());

            JRViewer jrv = new JRViewer(jasperPrint);
            jrv.setZoomRatio((float) 0.95);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
        } catch (JRException ex) {
            System.err.println("Error iReport: " + ex.getMessage());
        }
    }
     
    }
