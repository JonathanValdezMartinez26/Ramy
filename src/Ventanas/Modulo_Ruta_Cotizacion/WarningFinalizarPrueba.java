
package Ventanas.Modulo_Ruta_Cotizacion;

import Alerts.AlertBasic.*;
import Alerts.*;
import Ventanas.Modulo_Cliente.Opciones;
import Ventanas.Modulo_Cliente.Registrar;

import Ventanas.Modulo_Cotizaciones.pnlCotizaciones;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tablaDestinos;
import com.sun.glass.events.KeyEvent;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import necesario.RSAWTUtilities;

public class WarningFinalizarPrueba extends javax.swing.JDialog {

    
    public WarningFinalizarPrueba(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
        ID.setVisible(false);
        prueba v=new prueba();
        
        
        
        
        log2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               //v.setVisible(true);
                
            }
        });

    }
    
    public static void agregarJFrame(prueba j) {
        j.dispose();
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
        lblBander2 = new javax.swing.JLabel();

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
        log2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                log2MouseClicked(evt);
            }
        });
        log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log2ActionPerformed(evt);
            }
        });
        log2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                log2KeyTyped(evt);
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
        jPanel1.add(lblBander2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 70, 20));

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
        
//     variable.
       // v.setVisible();
//        this.setVisible(false);
//        prueba.lblBander.setText("OK");
//        lblBander2.setText("OK");
//        JOptionPane.showMessageDialog(null, "Debe cerrarse prueba");
//        Ventanas.Modulo_Ruta_Cotizacion.prueba p = new Ventanas.Modulo_Ruta_Cotizacion.prueba();
//        p.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        
//        p.addWindowListener(new WindowAdapter() {     	
//        @Override
//	public void windowClosing(WindowEvent e) {
//                //Este método se deshace de la ventana una vez que el usuario hace clic en el botón de cierre.
//		dispose();
//	}
//});  
//        
//this.dispose();

        
        
        
        
    }//GEN-LAST:event_log2ActionPerformed

    private void log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log3ActionPerformed
        this.dispose();
        prueba p =new prueba();
        p.setVisible(true);
    
    }//GEN-LAST:event_log3ActionPerformed

    private void log2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_log2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_log2KeyTyped

    private void log2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log2MouseClicked
        pnlCotizaciones pc=new pnlCotizaciones();
        pc.setVisible(false);
    }//GEN-LAST:event_log2MouseClicked

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
    public static javax.swing.JLabel lblBander2;
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
}
