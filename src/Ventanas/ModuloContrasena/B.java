
package Ventanas.ModuloContrasena;

public class B extends javax.swing.JPanel {

    public B() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        log = new JButtonEspecial.JButtonEspecial();
        jLabel14 = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        txtPass = new jpass.JRPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        B.setBackground(new java.awt.Color(255, 255, 255));
        B.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B.setName("B"); // NOI18N
        B.setLayout(null);

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resetpas.png"))); // NOI18N
        B.add(info);
        info.setBounds(0, 0, 350, 120);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Esta pregunta permite demostrar que ");
        B.add(jLabel5);
        jLabel5.setBounds(43, 120, 270, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText(" realmente eres el propietario de esta cuenta.");
        B.add(jLabel6);
        jLabel6.setBounds(38, 135, 280, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("recuerdes.");
        B.add(jLabel13);
        jLabel13.setBounds(43, 172, 230, 20);

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Siguiente");
        log.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        log.setColorHover(new java.awt.Color(204, 204, 204));
        log.setColorNormal(new java.awt.Color(204, 204, 204));
        log.setColorPressed(new java.awt.Color(153, 153, 153));
        log.setColorTextHover(new java.awt.Color(128, 128, 131));
        log.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        B.add(log);
        log.setBounds(42, 270, 268, 37);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Ingresa la última contraseña que");
        B.add(jLabel14);
        jLabel14.setBounds(43, 160, 240, 20);

        info1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(153, 0, 0));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B.add(info1);
        info1.setBounds(40, 240, 270, 30);

        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });
        B.add(txtPass);
        txtPass.setBounds(42, 200, 268, 40);

        add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        if (!"".equals(this.txtPass.getText())) {
            C poper = new C();
            poper.setSize(350,330);
            B.removeAll();
            B.add(poper);
            B.revalidate();
            B.repaint();
        }
        else{
            this.info1.setText("Ingresa la última contraseña que recuerdes ");
            this.txtPass.requestFocus();
        }
    }//GEN-LAST:event_logActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        this.info1.setText("");
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        this.info.setText("");
    }//GEN-LAST:event_txtPassKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel B;
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private JButtonEspecial.JButtonEspecial log;
    public static jpass.JRPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
