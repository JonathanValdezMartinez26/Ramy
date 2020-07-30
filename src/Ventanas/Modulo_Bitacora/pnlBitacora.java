package Ventanas.Modulo_Bitacora;

import A_tabla.EstiloTablaHeader;
import A_tabla.EstiloTablaHeader1;
import A_tabla.EstiloTablaHeader_1;
import A_tabla.EstiloTablaRenderer;
import A_tabla.EstiloTablaRenderer11;
import A_tabla.MyScrollbarUI;
import Clases.Conexion;
import static Ventanas.Modulo_Bitacora.pnlBitacora.tablabitacora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class pnlBitacora extends javax.swing.JPanel {

    public pnlBitacora() {
        initComponents();
        if(buscar.getText().equals(""))
        {
            Opciones.listar("");
        }
        else
        {
            Opciones.listar(buscar.getText());
        }
        
        this.tablabitacora.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablabitacora.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablabitacora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablabitacora.getTableHeader().setReorderingAllowed(false) ;
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader_1());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer11());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false) ;
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablabitacora = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlpdf = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlpdf1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buscarBitacora = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1102, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        });
        jScrollPane1.setViewportView(tablabitacora);
        if (tablabitacora.getColumnModel().getColumnCount() > 0) {
            tablabitacora.getColumnModel().getColumn(0).setPreferredWidth(2);
            tablabitacora.getColumnModel().getColumn(1).setPreferredWidth(220);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 290, 490));

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("      Bitacora");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 70));

        pnlpdf.setBackground(new java.awt.Color(225, 225, 225));
        pnlpdf.setToolTipText("Visualizar Bitacora");
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
        jLabel19.setText("    Visualizar");
        pnlpdf.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlpdf.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

        pnlpdf1.setBackground(new java.awt.Color(225, 225, 225));
        pnlpdf1.setToolTipText("Ajustes");
        pnlpdf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlpdf1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlpdf1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlpdf1MouseExited(evt);
            }
        });
        pnlpdf1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("    Ajustes");
        pnlpdf1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-dólar-estadounidense-40.png"))); // NOI18N
        pnlpdf1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlpdf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 69));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(0, 144, 183));
        buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR CLIENTE");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 20, 140, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        buscarBitacora.setBorder(null);
        buscarBitacora.setForeground(new java.awt.Color(0, 144, 183));
        buscarBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarBitacora.setPlaceholder("BUSCAR BITACORA");
        buscarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBitacoraActionPerformed(evt);
            }
        });
        buscarBitacora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarBitacoraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarBitacoraKeyTyped(evt);
            }
        });
        jPanel4.add(buscarBitacora, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 20, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 210, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1105, 85));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(12);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(12);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(12);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 156, 790, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void tablabitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabitacoraMouseClicked
        JTable table =(JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount() == 1)
        {
            String a = tablabitacora.getValueAt(tablabitacora.getSelectedRow() , 0).toString();
            int id = Integer.parseInt(a);
            Opciones.CargarDatos(id);
        }
    }//GEN-LAST:event_tablabitacoraMouseClicked

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

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void pnlpdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseClicked
        ver();
    }//GEN-LAST:event_pnlpdfMouseClicked

    private void pnlpdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseEntered
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlpdfMouseEntered

    private void pnlpdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseExited
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlpdfMouseExited

    private void buscarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBitacoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarBitacoraActionPerformed

    private void buscarBitacoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarBitacoraKeyReleased
        
        Opciones.listarBitacora(this.buscarBitacora.getText().trim());        
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarBitacoraKeyReleased

    private void buscarBitacoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarBitacoraKeyTyped
        // TODO add your handling code here:
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarBitacoraKeyTyped

    private void pnlpdf1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdf1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlpdf1MouseExited

    private void pnlpdf1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdf1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlpdf1MouseEntered

    private void pnlpdf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdf1MouseClicked
     pnlBitacoraAjustes PBA =new pnlBitacoraAjustes(null, true);
        PBA.setVisible(true);
    }//GEN-LAST:event_pnlpdf1MouseClicked

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    public static app.bolivia.swing.JCTextField buscarBitacora;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlpdf;
    private javax.swing.JPanel pnlpdf1;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTable tablabitacora;
    // End of variables declaration//GEN-END:variables
public void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        
        int Fila = tablabitacora.getSelectedRow();
        int Filita = 1; 
  
        if (Fila >= 0) {

            int ID = Integer.parseInt(tablabitacora.getValueAt(Fila, 0).toString());
            
    
       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "C:\\Users\\RVC.RVC-PC\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Bitacora.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
            parametro.put("ID_Cliente", ID);
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

