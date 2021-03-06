
package Alerts.AlertBasic;

import Alerts.*;
import Ventanas.Modulo_Cliente.Opciones;
import Ventanas.Modulo_Cliente.Registrar;

import Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado;
import static Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.IDCotizacion;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tablaDestinos;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.io.File;
import static java.lang.System.exit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class WarningFinalizarConsolidado extends javax.swing.JDialog {

    public WarningFinalizarConsolidado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
        ID.setVisible(false);
        

    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NombreEmpresa = new javax.swing.JLabel();
        msj2 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        msj3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        msj4 = new javax.swing.JLabel();
        msj5 = new javax.swing.JLabel();
        log3 = new JButtonEspecial.JButtonEspecial();
        ID = new javax.swing.JLabel();
        msj6 = new javax.swing.JLabel();
        msj7 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        rSPanelImage1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(246, 247, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warn.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 110));

        NombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        NombreEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombreEmpresa.setText("Servicios");
        jPanel1.add(NombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 380, 30));

        msj2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("¿Desea Finalizar esta Cotizacion?");
        jPanel1.add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 330, 30));

        log2.setBackground(new java.awt.Color(204, 204, 204));
        log2.setForeground(new java.awt.Color(128, 128, 131));
        log2.setText("Aceptar");
        log2.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        log2.setColorHover(new java.awt.Color(204, 204, 204));
        log2.setColorNormal(new java.awt.Color(204, 204, 204));
        log2.setColorPressed(new java.awt.Color(153, 153, 153));
        log2.setColorTextHover(new java.awt.Color(128, 128, 131));
        log2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log2ActionPerformed(evt);
            }
        });
        jPanel1.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 230, 30));

        msj3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj3.setText("Podra Finalizar la Cotizacion pero no incluirá:");
        jPanel1.add(msj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 290, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 280, 10));

        msj4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj4.setText("   ");
        jPanel1.add(msj4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 290, 20));

        msj5.setBackground(new java.awt.Color(204, 51, 0));
        msj5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(msj5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 290, 20));

        log3.setBackground(new java.awt.Color(204, 204, 204));
        log3.setForeground(new java.awt.Color(128, 128, 131));
        log3.setText("Cancelar");
        log3.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        log3.setColorHover(new java.awt.Color(204, 204, 204));
        log3.setColorNormal(new java.awt.Color(204, 204, 204));
        log3.setColorPressed(new java.awt.Color(153, 153, 153));
        log3.setColorTextHover(new java.awt.Color(128, 128, 131));
        log3.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log3ActionPerformed(evt);
            }
        });
        jPanel1.add(log3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 30));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        msj6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        msj6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj6.setText("¡Esta Cotización no se Podra Modificar Despues!");
        jPanel1.add(msj6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 320, 30));

        msj7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj7.setText("*Tome en cuenta que al presionar este boton");
        jPanel1.add(msj7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 290, 20));

        rSPanelImage1.add(jPanel1);
        jPanel1.setBounds(6, 4, 408, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
    this.dispose();
  String ID_Cotizacion=ID.getText();
//     
    Ventanas.Modulo_Cotizaciones_Consolidado.Opciones.finalizarCotizacion(ID_Cotizacion);
    Ventanas.Modulo_Cotizaciones_Consolidado.Opciones.listarCotizaciones(""); 
    ver();
//        Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.jButton3.setEnabled(false);
//        Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.pnlFinalizar.setEnabled(false);
//        Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.txtTipo_Concepto.setEnabled(false);
//        Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.buscarConso.setEnabled(false);
//        //Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.cmbCliente.setSelectedIndex(0);
//        Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.lblNombre.setText("");
//        
//        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.tablaR.getModel();       
//        modelo.setRowCount(0); 
//       
//        
//        Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.jButton3.setEnabled(false);        
//        Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.txtTipo_Concepto.setEnabled(false);
//        Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.buscarConso.setEnabled(false);
//        Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.cmbCliente.setSelectedIndex(0);
//        Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.lblNombre.setText("");
//        
//        DefaultTableModel modelo2 = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Consolidado.ModificarCotizaciones_Consolidado.tablaR.getModel();
//        
//        modelo2.setRowCount(0); 

    
    
    
    
    }//GEN-LAST:event_log2ActionPerformed

    private void log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log3ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConexionAlert dialog = new ConexionAlert(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ID;
    public static javax.swing.JLabel NombreEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static JButtonEspecial.JButtonEspecial log2;
    private JButtonEspecial.JButtonEspecial log3;
    public static javax.swing.JLabel msj2;
    public static javax.swing.JLabel msj3;
    public static javax.swing.JLabel msj4;
    public static javax.swing.JLabel msj5;
    public static javax.swing.JLabel msj6;
    public static javax.swing.JLabel msj7;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
public void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        int ID1 = Integer.parseInt(ID.getText());
        
        if (ID1 >= 0) {

       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "/Consultas/Renta_Consolidacion.jasper";            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(archivo));
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("logo2", this.getClass().getResourceAsStream("/Consultas/reporte.png"));
            parametro.put("ID_Cotizacion", ID1);
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
            AC.msj1.setText("¡Error  generar la Cotizacion!");
            AC.msj2.setText("Verifique que se agregaron los datos ");
            AC.setVisible(true);
        }
}
}
