package Ventanas.ModuloContrasena;

import Alerts.ConexionAlert;
import java.net.InetSocketAddress;
import java.net.Socket;
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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class C extends javax.swing.JPanel {

    public C() {
        initComponents();
    }
    boolean conexion = false;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        C = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        tres = new javax.swing.JLabel();
        cinco = new javax.swing.JLabel();
        dos = new javax.swing.JLabel();
        cuatro = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        info8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        C.setBackground(new java.awt.Color(255, 255, 255));
        C.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        C.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText(" Correo electrónico de recuperación");
        C.add(jLabel20);
        jLabel20.setBounds(0, 120, 330, 40);

        uno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uno.setForeground(new java.awt.Color(102, 102, 102));
        uno.setText("ProMedic te enviará un correo electrónico");
        C.add(uno);
        uno.setBounds(48, 170, 270, 17);

        tres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tres.setForeground(new java.awt.Color(102, 102, 102));
        tres.setText("segura al ");
        C.add(tres);
        tres.setBounds(48, 200, 60, 17);

        cinco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cinco.setText("como medio de recuperación.");
        C.add(cinco);
        cinco.setBounds(48, 211, 250, 20);

        dos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dos.setForeground(new java.awt.Color(102, 102, 102));
        dos.setText("para acceder a tu cuenta de manera ");
        C.add(dos);
        dos.setBounds(48, 185, 280, 17);

        cuatro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cuatro.setText(" correo que proporcionaste");
        C.add(cuatro);
        cuatro.setBounds(103, 198, 200, 20);

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
        C.add(log2);
        log2.setBounds(42, 270, 268, 37);

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setForeground(new java.awt.Color(102, 102, 102));
        info8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/email.png"))); // NOI18N
        C.add(info8);
        info8.setBounds(0, 0, 350, 120);

        add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
            Socket sock = new Socket();
            InetSocketAddress addr = new InetSocketAddress("www.google.com",80);
            try
            {
                sock.connect(addr,3000);
                conexion = true;
                C1 poper = new C1();
                poper.setSize(350,330);
                C.removeAll();
                C.add(poper);
                C.revalidate();
                C.repaint();
                
            }
            catch(Exception e)
            {
                conexion = false;
                ConexionAlert poper = new ConexionAlert(null, true);
                poper.setVisible(true);
            }
            finally
            {
                try
                {
                    sock.close();
                }
                catch(Exception e)
                {

                }
            }
    }//GEN-LAST:event_log2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel C;
    private javax.swing.JLabel cinco;
    private javax.swing.JLabel cuatro;
    private javax.swing.JLabel dos;
    public static javax.swing.JLabel info8;
    public static javax.swing.JLabel jLabel20;
    private JButtonEspecial.JButtonEspecial log2;
    private javax.swing.JLabel tres;
    private javax.swing.JLabel uno;
    // End of variables declaration//GEN-END:variables
}
