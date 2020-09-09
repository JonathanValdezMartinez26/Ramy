/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas.Modulo_Reportes;

import Ventanas.Modulo_Navegacion.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Jonathan Valdez
 */
public class pnlReportes extends javax.swing.JPanel {
    private final String logotipo="/Consultas/reporte.png";

    /**
     * Creates new form Inicio
     */
    public pnlReportes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConf_1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        citas = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        consultas = new javax.swing.JPanel();
        info1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        usuarios = new javax.swing.JPanel();
        info5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        pnlConf_1.setBackground(new java.awt.Color(255, 255, 255));
        pnlConf_1.setName("pnlConf_1"); // NOI18N
        pnlConf_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(46, 48, 146));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPORTES");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, 180, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(46, 48, 146));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("CLIENTES");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        citas.setBackground(new java.awt.Color(51, 0, 153));
        citas.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        citas.setForeground(new java.awt.Color(0, 51, 51));
        citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                citasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                citasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                citasMouseExited(evt);
            }
        });

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnCliente.png"))); // NOI18N

        javax.swing.GroupLayout citasLayout = new javax.swing.GroupLayout(citas);
        citas.setLayout(citasLayout);
        citasLayout.setHorizontalGroup(
            citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        citasLayout.setVerticalGroup(
            citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, citasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jPanel5.add(citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 179, -1));

        pnlConf_1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, 230));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(46, 48, 146));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("       REPORTES");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 150, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(46, 48, 146));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("       TRANSPORTES");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        consultas.setBackground(new java.awt.Color(51, 0, 153));
        consultas.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        consultas.setForeground(new java.awt.Color(204, 0, 0));
        consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                consultasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                consultasMouseExited(evt);
            }
        });

        info1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(102, 102, 102));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnTransporte.png"))); // NOI18N

        javax.swing.GroupLayout consultasLayout = new javax.swing.GroupLayout(consultas);
        consultas.setLayout(consultasLayout);
        consultasLayout.setHorizontalGroup(
            consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        consultasLayout.setVerticalGroup(
            consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jPanel7.add(consultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, -1));

        pnlConf_1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, 230));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(46, 48, 146));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("REPORTES");
        jPanel10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 150, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(46, 48, 146));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("USUARIOS");
        jPanel10.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        usuarios.setBackground(new java.awt.Color(51, 0, 153));
        usuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        usuarios.setForeground(new java.awt.Color(204, 0, 0));
        usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usuariosMouseExited(evt);
            }
        });

        info5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info5.setForeground(new java.awt.Color(102, 102, 102));
        info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnUsers.png"))); // NOI18N

        javax.swing.GroupLayout usuariosLayout = new javax.swing.GroupLayout(usuarios);
        usuarios.setLayout(usuariosLayout);
        usuariosLayout.setHorizontalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        usuariosLayout.setVerticalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jPanel10.add(usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        pnlConf_1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, 230));

        jPanel13.setBackground(new java.awt.Color(225, 225, 225));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("  Reportes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("   Globales");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 90, 40));

        jPanel13.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 70));

        pnlConf_1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConf_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConf_1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultasMouseClicked
        ver_TRAN();
    }//GEN-LAST:event_consultasMouseClicked

    private void consultasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultasMouseEntered
        consultas.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_consultasMouseEntered

    private void consultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultasMouseExited
        consultas.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_consultasMouseExited

    private void usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosMouseClicked
        ver_U();
    }//GEN-LAST:event_usuariosMouseClicked

    private void usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosMouseEntered
        usuarios.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_usuariosMouseEntered

    private void usuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosMouseExited
        usuarios.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_usuariosMouseExited

    private void citasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citasMouseExited
        citas.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_citasMouseExited

    private void citasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citasMouseEntered
        citas.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_citasMouseEntered

    private void citasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citasMouseClicked
        ver_C();
    }//GEN-LAST:event_citasMouseClicked

  public void ver_U() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            String archivo = "/Reportes/Usuarios .jasper";
            //String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Usuarios .jasper";
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
     
     public void ver_SER() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
//            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Servicios.jasper";
            String archivo = "src/Reportes/Servicios.jasper";
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
     
     public void ver_C() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
//            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Clientes.jasper";
            String archivo = "/Reportes/Clientes.jasper";
            //String archivo = "src/Reportes/Clientes.jasper";
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
     
     public void ver_TRAN() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
//            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Transportes.jasper";
            //String archivo = "src/Reportes/Transportes.jasper";
            String archivo = "/Reportes/Transportes.jasper";
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
     
     public void ver_P() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            String archivo = "src/Reportes/Pacientes.jasper";
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
     
     
     public void ver_CO() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            String archivo = "src/Reportes/Consultas.jasper";
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
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel citas;
    private javax.swing.JPanel consultas;
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    public static javax.swing.JLabel info5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pnlConf_1;
    private javax.swing.JPanel usuarios;
    // End of variables declaration//GEN-END:variables
}
