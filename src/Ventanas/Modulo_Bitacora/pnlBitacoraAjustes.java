package Ventanas.Modulo_Bitacora;

import A_tabla.EstiloTablaHeader;
import A_tabla.EstiloTablaRenderer;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import Clases.Conexion;
import Ventanas.CotizacionReporte.ConfigCotizacionbitaAju;
import static Ventanas.Modulo_Bitacora.pnlBitacora.buscar;
import static Ventanas.Modulo_Bitacora.pnlBitacora.tablabitacora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class pnlBitacoraAjustes extends javax.swing.JDialog {

   
    int i = 32;
    int x,y;
    
    public pnlBitacoraAjustes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblAjuste.setVisible(false);
        lblIDCliente.setVisible(false);
        if(buscarClienteAjuste.getText().equals(""))
        {
            Opciones.listarClientesAjustes("");
        }
        else
        {
            Opciones.listarClientesAjustes(buscarClienteAjuste.getText());
        }
        
        
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        tablaDatosAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaDatosAjuste.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablaDatosAjuste.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablaDatosAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tablabitacora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablabitacora.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablabitacora.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablabitacora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tablaFAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaFAjuste.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablaFAjuste.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablaFAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
    }

    public pnlBitacoraAjustes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabla1 = new javax.swing.JTable();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlAyuda = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabitacora = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        buscarClienteAjuste = new app.bolivia.swing.JCTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buscarDatosAjuste = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIDCliente = new javax.swing.JLabel();
        lblAjuste = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDatosAjuste = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaFAjuste = new javax.swing.JTable();

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de Viaje", "Costo Antiguo", "Costo Actual", "Transporte", "Modificación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(210, 210, 214));
        jPanel7.setPreferredSize(new java.awt.Dimension(804, 30));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel7MouseDragged(evt);
            }
        });
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Bitacora de Ajustes");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 30));

        rSButtonMetro2.setText("X");
        rSButtonMetro2.setToolTipText("Cerrar");
        rSButtonMetro2.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro2.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro2.setColorPressed(new java.awt.Color(136, 0, 0));
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 30, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 1009, -1));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Agregar Servicio");
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

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Reporte Ajuste");
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
        jLabel15.setText("    Reporte");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ReporteP.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 69));

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("      Ayuda");
        pnlAyuda.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ayuda30.png"))); // NOI18N
        pnlAyuda.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 10, 30, 40));

        jPanel12.add(pnlAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 69));

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        tablabitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Nombre del Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablabitacora.setName(""); // NOI18N
        tablabitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablabitacoraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablabitacoraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablabitacora);
        if (tablabitacora.getColumnModel().getColumnCount() > 0) {
            tablabitacora.getColumnModel().getColumn(0).setPreferredWidth(2);
        }

        pnlPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 290, 352));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarClienteAjuste.setBorder(null);
        buscarClienteAjuste.setForeground(new java.awt.Color(0, 144, 183));
        buscarClienteAjuste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarClienteAjuste.setPlaceholder("BUSCAR CLIENTE");
        buscarClienteAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteAjusteActionPerformed(evt);
            }
        });
        buscarClienteAjuste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarClienteAjusteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarClienteAjusteKeyTyped(evt);
            }
        });
        jPanel4.add(buscarClienteAjuste, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 20, 140, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 990, 5));

        buscarDatosAjuste.setBorder(null);
        buscarDatosAjuste.setForeground(new java.awt.Color(0, 144, 183));
        buscarDatosAjuste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarDatosAjuste.setPlaceholder("BUSCAR AJUSTE");
        buscarDatosAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDatosAjusteActionPerformed(evt);
            }
        });
        buscarDatosAjuste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarDatosAjusteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarDatosAjusteKeyTyped(evt);
            }
        });
        jPanel4.add(buscarDatosAjuste, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 20, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 210, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel3KeyTyped(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 210, -1));

        lblIDCliente.setText("Id");
        jPanel4.add(lblIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        lblAjuste.setText("aj");
        jPanel4.add(lblAjuste, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        pnlPrincipal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1010, 85));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tablaDatosAjuste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Ajuste_Bitacora", "Nombre de Viaje", "Costo Antiguo", "Costo Actual", "Transporte"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDatosAjuste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosAjusteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaDatosAjuste);
        if (tablaDatosAjuste.getColumnModel().getColumnCount() > 0) {
            tablaDatosAjuste.getColumnModel().getColumn(0).setMinWidth(0);
            tablaDatosAjuste.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaDatosAjuste.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        pnlPrincipal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 158, 550, 350));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tablaFAjuste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Ajuste", "Ajuste"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFAjuste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFAjusteMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaFAjuste);
        if (tablaFAjuste.getColumnModel().getColumnCount() > 0) {
            tablaFAjuste.getColumnModel().getColumn(0).setMinWidth(0);
            tablaFAjuste.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaFAjuste.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        pnlPrincipal.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 158, 130, 350));

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 1009, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
         this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
      
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void tablabitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabitacoraMouseClicked
        
         if (evt.getClickCount() == 1)
        {
            String a = tablabitacora.getValueAt(tablabitacora.getSelectedRow() , 0).toString();
            
            int id = Integer.parseInt(a);            
            Opciones.listarAjustes(id);
            buscarDatosAjuste.setText("");
        }
    }//GEN-LAST:event_tablabitacoraMouseClicked

    private void buscarClienteAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarClienteAjusteActionPerformed

    private void buscarClienteAjusteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarClienteAjusteKeyReleased
        Opciones.listarClientesAjustes(this.buscarClienteAjuste.getText().trim());
        buscarDatosAjuste.setText("");
    }//GEN-LAST:event_buscarClienteAjusteKeyReleased

    private void buscarClienteAjusteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarClienteAjusteKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarClienteAjusteKeyTyped

    private void buscarDatosAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDatosAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarDatosAjusteActionPerformed

    private void buscarDatosAjusteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarDatosAjusteKeyReleased

        String ID=lblIDCliente.getText();
        int IDC=Integer.parseInt(lblIDCliente.getText());
        String fecha=lblAjuste.getText();
        Opciones.listarDatosAjustes(this.buscarDatosAjuste.getText().trim(),IDC,fecha);
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarDatosAjusteKeyReleased

    private void buscarDatosAjusteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarDatosAjusteKeyTyped
        // TODO add your handling code here:
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarDatosAjusteKeyTyped

    private void tablaDatosAjusteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosAjusteMouseClicked
        
        
    }//GEN-LAST:event_tablaDatosAjusteMouseClicked

    private void tablaFAjusteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFAjusteMouseClicked
        if (evt.getClickCount() == 1)
        {
            String a = tablaFAjuste.getValueAt(tablaFAjuste.getSelectedRow() , 0).toString();
            int idCliente=Integer.parseInt(a);
            String fecha = tablaFAjuste.getValueAt(tablaFAjuste.getSelectedRow() , 1).toString();
            String buscar="";
            lblIDCliente.setText(a);
            lblAjuste.setText(fecha);
                
            Opciones.listarDatosAjustes("",idCliente,fecha);
        }

        
    }//GEN-LAST:event_tablaFAjusteMouseClicked

    private void tablabitacoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabitacoraMousePressed
    
    }//GEN-LAST:event_tablabitacoraMousePressed

    private void jLabel3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyTyped
        Opciones.listarClientesAjustes(this.buscarClienteAjuste.getText().trim());        
    }//GEN-LAST:event_jLabel3KeyTyped

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
        ver();
        //Origenes();
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited

    private void pnlAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseClicked

        ConfigCotizacionbitaAju poper =new Ventanas.CotizacionReporte.ConfigCotizacionbitaAju(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlAyudaMouseClicked

    private void pnlAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseEntered
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlAyudaMouseEntered

    private void pnlAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseExited
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlAyudaMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pnlBitacoraAjustes dialog = new pnlBitacoraAjustes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscarClienteAjuste;
    public static app.bolivia.swing.JCTextField buscarDatosAjuste;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblAjuste;
    public static javax.swing.JLabel lblIDCliente;
    private javax.swing.JPanel pnlAyuda;
    public static javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnlorigenes;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static javax.swing.JTable tabla1;
    public static javax.swing.JTable tablaDatosAjuste;
    public static javax.swing.JTable tablaFAjuste;
    public static javax.swing.JTable tablabitacora;
    // End of variables declaration//GEN-END:variables
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        
        int Fila = tablabitacora.getSelectedRow();
        int Fila1 = tablaFAjuste.getSelectedRow();
        int Filita = 1; 
  
        if (Fila >= 0 && Fila1 >= 0) {

            int ID = Integer.parseInt(tablabitacora.getValueAt(Fila, 0).toString());
//            int Modificacion1 = Integer.parseInt(tablaFAjuste.getValueAt(Fila1, 1).toString());
            String Modificacion= String.valueOf(tablaFAjuste.getValueAt(Fila1, 1));
    
       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "/Consultas/Bitacora_1.jasper";
//            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Bitacora_1.jasper";
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(archivo));            
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("logo", this.getClass().getResourceAsStream("/Consultas/reporte.png"));
            parametro.put("ID_Cliente", ID);
            parametro.put("Modificacion",Modificacion);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());
            
            JRViewer jrv = new JRViewer(jasperPrint);
            jrv.setZoomRatio((float) 0.75);
            
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
        else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("a visualizar");
            AC.setVisible(true);
        }
}
    
}
