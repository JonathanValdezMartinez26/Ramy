package Ventanas.Modulo_Servicios;

import A_tabla.*;
import Clases.Cita;
import Clases.Conexion;
import Ventanas.Modulo_Cita.*;
import Ventanas.Modulo_Tipo_Servicio.AgregarTipoServicio;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
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

public class pnlServicio extends javax.swing.JPanel {

    public pnlServicio() 
    {
        initComponents();
        Opciones.listar("");
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

            ModificarServicio MM = new ModificarServicio(null, true);
            MM.CargarDatos(ID);
            MM.setVM(this);
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
        pnlmodificar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlespecialidad = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pnleditar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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
        jLabel6.setText("   Servicios");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        pnlmodificar.setBackground(new java.awt.Color(225, 225, 225));
        pnlmodificar.setToolTipText("Activar/Desactivar Médico");
        pnlmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseExited(evt);
            }
        });
        pnlmodificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("     Estado");
        pnlmodificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sincronizar.png"))); // NOI18N
        pnlmodificar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 69));

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Agregar Médico");
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

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 69));

        pnlespecialidad.setBackground(new java.awt.Color(225, 225, 225));
        pnlespecialidad.setToolTipText("Modulo Especialidades");
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
        jLabel24.setText("  Tipo de Servicio");
        pnlespecialidad.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 14));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/servicio.png"))); // NOI18N
        pnlespecialidad.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 48, 48));

        jPanel12.add(pnlespecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

        pnleditar.setBackground(new java.awt.Color(225, 225, 225));
        pnleditar.setToolTipText("Editar Médico");
        pnleditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnleditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnleditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnleditarMouseExited(evt);
            }
        });
        pnleditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("      Editar");
        pnleditar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        pnleditar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 69));

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Activar o Desactivar Paciente");
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
        jLabel15.setText("   Visualizar");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, 69));

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
                "No.", "Servicio", "Tipo_Servicio"
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

    private void pnlmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseClicked

    }//GEN-LAST:event_pnlmodificarMouseClicked

    private void pnlmodificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseEntered
        pnlmodificar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlmodificarMouseEntered

    private void pnlmodificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseExited
        pnlmodificar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlmodificarMouseExited

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        AgregarServicio poper = new AgregarServicio(null, true);
        poper.setVisible(true);

    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void pnlespecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseClicked
        pnlTipoServicio VE=new pnlTipoServicio(null, true);
        VE.setVisible(true);
    }//GEN-LAST:event_pnlespecialidadMouseClicked

    private void pnlespecialidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseEntered
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlespecialidadMouseEntered

    private void pnlespecialidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseExited
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlespecialidadMouseExited

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnleditar;
    private javax.swing.JPanel pnlespecialidad;
    private javax.swing.JPanel pnlmodificar;
    private javax.swing.JPanel pnlorigenes;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            File fichero = new File("test.txt");
            System.out.println("La ruta del fichero es: " + fichero.getAbsolutePath());
            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Servicios.jasper";
//            String archivo = "Reportes/Servicios.jasper";";
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

