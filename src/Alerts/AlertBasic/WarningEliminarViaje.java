
package Alerts.AlertBasic;

import Alerts.*;
import Ventanas.Modulo_Cliente.Opciones;
import Ventanas.Modulo_Cliente.Registrar;

import Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tablaDestinos;
import com.sun.glass.events.KeyEvent;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;

public class WarningEliminarViaje extends javax.swing.JDialog {

    public WarningEliminarViaje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
        ID.setVisible(false);
        IDC.setVisible(false);
        

    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        msj2 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        msj3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        log3 = new JButtonEspecial.JButtonEspecial();
        ID = new javax.swing.JLabel();
        msj6 = new javax.swing.JLabel();
        msj7 = new javax.swing.JLabel();
        msj8 = new javax.swing.JLabel();
        IDC = new javax.swing.JLabel();

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

        msj2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("¿Desea Eliminar este Viaje?");
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
        msj3.setText("los precios nuevamente.");
        jPanel1.add(msj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 290, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 280, 10));

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
        msj6.setText("¡Este Viaje no se Podra Recuperar Despues!");
        jPanel1.add(msj6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 320, 30));

        msj7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj7.setText("*Tome en cuenta que si borra este viaje,podra");
        jPanel1.add(msj7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 290, 20));

        msj8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj8.setText("registrarlo nuevamente pero se tendran que asignar");
        jPanel1.add(msj8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 290, 20));

        IDC.setText("0");
        jPanel1.add(IDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

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
               int IDRuta=Integer.parseInt(ID.getText());
               int IDCliente=Integer.parseInt(IDC.getText());
               Ventanas.Modulo_Cliente.Opciones.eliminarViaje(IDRuta);
            Opciones.listarViaje("",IDCliente);
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
    public static javax.swing.JLabel IDC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static JButtonEspecial.JButtonEspecial log2;
    private JButtonEspecial.JButtonEspecial log3;
    public static javax.swing.JLabel msj2;
    public static javax.swing.JLabel msj3;
    public static javax.swing.JLabel msj6;
    public static javax.swing.JLabel msj7;
    public static javax.swing.JLabel msj8;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
