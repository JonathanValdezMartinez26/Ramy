package Ventanas.Modulo_Transportes;

import Ventanas.Modulo_Transportes.ModificarTran;
import Ventanas.Modulo_Transportes.Opciones;
import Ventanas.Modulo_Transportes.AgregarTran;
import A_tabla.*;
import Clases.Conexion;
import Ventanas.Modulo_Tipo_Servicio.AgregarTipoServicio;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
import Ventanas.Modulo_Tipo_Transportes.pnlTipoTransportes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
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
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Jonathan Valdez
 */
public class pnlTransportes extends javax.swing.JPanel {

    public pnlTransportes() 
    {
        initComponents();
        if(buscar.getText().equals(""))
        {
            Opciones.listar("");
        }
        else
        {
            Opciones.listar(buscar.getText());
        }
        
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
    }
    
   
   
    
    public void Modificar()
    {
        int Fila = tabla.getSelectedRow();
        if(Fila >= 0)
        {
            int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());

            ModificarTran MM = new ModificarTran(null, true);
            MM.CargarDatos(ID);
          
            MM.setVisible(true);
        }
    else{
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡ Seleccione el registro !");
            AC.msj2.setText("A modificar");
            AC.setVisible(true);  
        }
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlespecialidad = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        buscar = new app.bolivia.swing.JCTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("   Transportes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        pnlespecialidad.setBackground(new java.awt.Color(225, 225, 225));
        pnlespecialidad.setToolTipText("Módulo Transportes");
        pnlespecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseExited(evt);
            }
        });
        pnlespecialidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("  Tipo de Transporte");
        pnlespecialidad.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 14));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/camion.png"))); // NOI18N
        pnlespecialidad.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 8, -1, 40));

        jPanel12.add(pnlespecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

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

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 69));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

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
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 90, 145, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1105, 85));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Transporte", "Tipo de Transporte"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 1086, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
    Opciones.listar(this.buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void pnlespecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseClicked
        pnlTipoTransportes VE=new pnlTipoTransportes(null, true);
        VE.setVisible(true);
    }//GEN-LAST:event_pnlespecialidadMouseClicked

    private void pnlespecialidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseEntered
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlespecialidadMouseEntered

    private void pnlespecialidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseExited
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlespecialidadMouseExited

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
        ver();
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited
    DefaultTableModel model = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            
            return false;
        }
        
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlespecialidad;
    private javax.swing.JPanel pnlorigenes;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            File fichero = new File("test.txt");
            System.out.println("La ruta del fichero es: " + fichero.getAbsolutePath());
            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Transportes.jasper";
//            String archivo = "Reportes/Transportes.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
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

