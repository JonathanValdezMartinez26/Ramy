
package Alerts;

import Clases.Cita;
import com.sun.glass.events.KeyEvent;
import java.awt.event.WindowEvent;
import necesario.RSAWTUtilities;

public class PendienteCita extends javax.swing.JDialog {

    public PendienteCita(java.awt.Frame parent, boolean modal) {
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

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        msj1 = new javax.swing.JLabel();
        msj2 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        msj3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        msj4 = new javax.swing.JLabel();
        msj5 = new javax.swing.JLabel();
        log3 = new JButtonEspecial.JButtonEspecial();
        ID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        rSPanelImage1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(246, 247, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warn.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 110));

        msj1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        msj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj1.setText("Verifique su conexión");
        jPanel1.add(msj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 30));

        msj2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("¿Desea cancelar la cita?");
        jPanel1.add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 240, 30));

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
        jPanel1.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 155, 140, 30));

        msj3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj3.setText("Tome en cuenta que al presionar el");
        jPanel1.add(msj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 220, 10));

        msj4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj4.setText("botón aceptar, estará confirmando la");
        jPanel1.add(msj4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 230, 20));

        msj5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        msj5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj5.setText("cancelación de la cita.");
        jPanel1.add(msj5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, 20));

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
        jPanel1.add(log3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 140, 30));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        rSPanelImage1.add(jPanel1);
        jPanel1.setBounds(6, 4, 330, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        this.dispose();
        Cita.Cancelar_Consulta(Integer.parseInt(ID.getText()));
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private JButtonEspecial.JButtonEspecial log2;
    private JButtonEspecial.JButtonEspecial log3;
    public static javax.swing.JLabel msj1;
    public static javax.swing.JLabel msj2;
    public static javax.swing.JLabel msj3;
    public static javax.swing.JLabel msj4;
    public static javax.swing.JLabel msj5;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
