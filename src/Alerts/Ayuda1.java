
package Alerts;

import Ventanas.Modulo_Navegacion.Principal_Admin;
import com.sun.glass.events.KeyEvent;
import java.awt.event.WindowEvent;
import necesario.RSAWTUtilities;

public class Ayuda1 extends javax.swing.JDialog {

    public Ayuda1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
        info1.setText("Hola, ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        jPanel2 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        info4 = new javax.swing.JLabel();
        info5 = new javax.swing.JLabel();
        info6 = new javax.swing.JLabel();
        info7 = new javax.swing.JLabel();
        info8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        rSPanelImage1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 144, 183), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/per.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 280));

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
        jPanel1.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 230, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setText("   manual de Usuario y/o contacte");
        jPanel2.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 230, 20));

        info1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info1.setText("Hola,");
        jPanel2.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2, 210, 26));

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setText("   una consulta, porqué no aparece ");
        jPanel2.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, -1, 26));

        info3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info3.setText("   del médico.  ");
        jPanel2.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 87, -1, 26));

        info4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info4.setText("   el médico, es  posible qué la hora  ");
        jPanel2.add(info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, -1, 26));

        info5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info5.setText("   actual no coincida con el  horario  ");
        jPanel2.add(info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, -1, 26));

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setText("   Si tiene problemas para registrar ");
        jPanel2.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 31, 220, 26));

        info7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info7.setText("   Para más información, revise el ");
        jPanel2.add(info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 230, 20));

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setText("   a Servicios Promedic.");
        jPanel2.add(info8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 158, 230, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 128, 128));
        jLabel2.setText("Ayuda ProMedic");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 80, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 230, 250));

        rSPanelImage1.add(jPanel1);
        jPanel1.setBounds(6, 4, 410, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log2ActionPerformed

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
    private javax.swing.JLabel info;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JLabel info4;
    private javax.swing.JLabel info5;
    private javax.swing.JLabel info6;
    private javax.swing.JLabel info7;
    private javax.swing.JLabel info8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private JButtonEspecial.JButtonEspecial log2;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
