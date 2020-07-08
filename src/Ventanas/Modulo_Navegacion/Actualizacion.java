
package Ventanas.Modulo_Navegacion;

import Alerts.*;
import Alerts.AlertBasic.*;
import com.sun.glass.events.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import necesario.RSAWTUtilities;

public class Actualizacion extends javax.swing.JDialog {

    public Actualizacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        msj4.setVisible(false);
        
        final Timer timer = new Timer();
        
        TimerTask task = new TimerTask() 
        {
            public void run() 
            {
                msj1.setVisible(false);
                msj2.setText("Sin actualizaciones disponibles");
                msj4.setVisible(true);
                log2.setVisible(true);
                log3.setVisible(false);
            }
        };
        timer.schedule(task, 20000); 

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
        log2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        msj1 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        msj2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        info2 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        msj3 = new javax.swing.JLabel();
        log3 = new JButtonEspecial.JButtonEspecial();
        msj4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        rSPanelImage1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(246, 247, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 144, 183), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msj1.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        msj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cargando.gif"))); // NOI18N
        jPanel1.add(msj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 510, 210));

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
        jPanel1.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 290, 30));

        msj2.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("Espere, estamos trabajando...");
        jPanel1.add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 530, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(246, 247, 248));

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setText("Versión actual. ");

        info3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info3.setForeground(new java.awt.Color(102, 102, 102));
        info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info3.setText("1.0.0.1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(info2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info3)
                .addGap(0, 56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 200, 20));

        msj3.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        msj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj3.setText("Buscando Actualización");
        jPanel1.add(msj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 430, 60));

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
        jPanel1.add(log3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 290, 30));

        msj4.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        msj4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reload.png"))); // NOI18N
        jPanel1.add(msj4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 510, 210));

        rSPanelImage1.add(jPanel1);
        jPanel1.setBounds(10, 8, 553, 415);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log2ActionPerformed

    private void log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_log3ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Actualizacion dialog = new Actualizacion(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel info2;
    public static javax.swing.JLabel info3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JButtonEspecial.JButtonEspecial log2;
    private JButtonEspecial.JButtonEspecial log3;
    public static javax.swing.JLabel msj1;
    public static javax.swing.JLabel msj2;
    public static javax.swing.JLabel msj3;
    public static javax.swing.JLabel msj4;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
