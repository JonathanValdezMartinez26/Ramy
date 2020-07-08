
package Alerts.AlertBasic;

import Alerts.*;
import com.sun.glass.events.KeyEvent;
import java.awt.event.WindowEvent;
import necesario.RSAWTUtilities;

public class SuccessEmail extends javax.swing.JDialog {

    public SuccessEmail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 20, 0.1f);
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        D = new javax.swing.JPanel();
        info6 = new javax.swing.JLabel();
        info10 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        info8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        D.setBackground(new java.awt.Color(255, 255, 255));
        D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 180, 232), 5));
        D.setName("D"); // NOI18N
        D.setLayout(null);

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setForeground(new java.awt.Color(130, 180, 232));
        info6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/correoooo.gif"))); // NOI18N
        D.add(info6);
        info6.setBounds(0, 8, 320, 220);

        info10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info10.setForeground(new java.awt.Color(130, 180, 232));
        info10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info10.setText("provisional, revise su bandeja de entrada.");
        D.add(info10);
        info10.setBounds(10, 237, 300, 20);

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
        D.add(log2);
        log2.setBounds(20, 270, 280, 30);

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setForeground(new java.awt.Color(130, 180, 232));
        info8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info8.setText("Hemos enviado un correo con la contraseña");
        D.add(info8);
        info8.setBounds(10, 217, 300, 30);

        rSPanelImage1.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 322, 316));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log2ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SuccessEmail dialog = new SuccessEmail(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel D;
    public static javax.swing.JLabel info10;
    public static javax.swing.JLabel info6;
    public static javax.swing.JLabel info8;
    private JButtonEspecial.JButtonEspecial log2;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
