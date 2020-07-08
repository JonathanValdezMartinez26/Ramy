package Ventanas.ModuloContrasena;

import Alerts.ConexionAlert;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class E extends javax.swing.JPanel {

    public E() {
        initComponents();
        
        AsistenciaContrasena.jLabel3.setText("Cambiar la contraseña de "+ AsistenciaContrasena.correo.getText().trim());
        Font font = cuatro.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cuatro.setFont(font.deriveFont(attributes));
        cuatro.setText(AsistenciaContrasena.correo.getText().trim());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        E = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        dos = new javax.swing.JLabel();
        cuatro = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        info8 = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        txtCod = new app.bolivia.swing.JCTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        E.setBackground(new java.awt.Color(255, 255, 255));
        E.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        E.setName("E"); // NOI18N
        E.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText(" Introduce un código de verificación");
        E.add(jLabel20);
        jLabel20.setBounds(0, 110, 330, 20);

        uno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uno.setForeground(new java.awt.Color(102, 102, 102));
        uno.setText("ProMedic te ha enviado un código de");
        E.add(uno);
        uno.setBounds(45, 135, 270, 17);

        dos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dos.setForeground(new java.awt.Color(102, 102, 102));
        dos.setText("verificación al correo electrónico:");
        E.add(dos);
        dos.setBounds(45, 150, 280, 17);

        cuatro.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cuatro.setText("correo que proporcionaste");
        E.add(cuatro);
        cuatro.setBounds(45, 163, 200, 20);

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
        E.add(log2);
        log2.setBounds(42, 270, 268, 37);

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setForeground(new java.awt.Color(102, 102, 102));
        info8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/email.png"))); // NOI18N
        E.add(info8);
        info8.setBounds(0, 0, 350, 120);

        info1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(153, 0, 0));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        E.add(info1);
        info1.setBounds(40, 240, 270, 30);

        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txtCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });
        E.add(txtCod);
        txtCod.setBounds(42, 200, 268, 40);

        add(E, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
    if(txtCod.getText().equals(AsistenciaContrasena.codigo.getText()))
    {
        E1 poper = new E1();
        poper.setSize(350,330);
        E.removeAll();
        E.add(poper);
        E.revalidate();
        E.repaint();
    }
    else
    {
        info1.setText("El código es incorrecto. Inténtalo de nuevo.");
    }
    }//GEN-LAST:event_log2ActionPerformed

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        this.info1.setText("");
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        int limite =30;
        if (txtCod.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyReleased
        this.info1.setText("");
    }//GEN-LAST:event_txtCodKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel E;
    private javax.swing.JLabel cuatro;
    private javax.swing.JLabel dos;
    public static javax.swing.JLabel info1;
    public static javax.swing.JLabel info8;
    public static javax.swing.JLabel jLabel20;
    private JButtonEspecial.JButtonEspecial log2;
    public static app.bolivia.swing.JCTextField txtCod;
    private javax.swing.JLabel uno;
    // End of variables declaration//GEN-END:variables
}
