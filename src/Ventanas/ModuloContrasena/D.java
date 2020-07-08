package Ventanas.ModuloContrasena;

import Alerts.ConexionAlert;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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

public class D extends javax.swing.JPanel {

    public D() {
        initComponents();
        
        int codigo = 0;
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i < 1; i++) {
                codigo = number.nextInt(1000000);
            }
        } catch (NoSuchAlgorithmException nsae) {

        }

        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);

        String correoEnvia = "ramy.cotizaciones@gmail.com";
        String contrasena = "abecedario";
        String destinatario = AsistenciaContrasena.correo.getText().trim();
        String asunto = "Soporte Ramy.Cotizaciones, recuperación de contraseña";
        String mensaje = "<p><strong>Hola,</strong> <em>"+ AsistenciaContrasena.user.getText().trim() +"</em>.</p>"
                        +"<p>Hemos recibido una solicitud para acceder a tu cuenta Cotizaciones en <span style='color: #000080;'>Express Logistics Ramy</span>, Ramy.Cotizaciones@gmail.com, a trav&eacute;s de tu direcci&oacute;n de correo electr&oacute;nico.</p>"
                        +"<p><br />Tu c&oacute;digo de verificaci&oacute;n para tu cuenta de Cotizaciones en <span style='color: #000080;'>Express Logistics Ramy</span> es: <strong>"+ codigo+ "</strong>.&nbsp;<br />Si no has solicitado este c&oacute;digo, puede que alguien est&eacute; intentando acceder a tu cuenta Cotizaciones en<span style='color: ##000080;'>Express Logistics Ramy</span>.</p>"
                        +"<p>Has recibido este mensaje porque esta direcci&oacute;n de correo electr&oacute;nico figura como direcci&oacute;n de recuperaci&oacute;n de la cuenta Cotizaciones en <span style='color: ##000080;'>Express Logistics Ramy</span>, proporcionaste esta direcci&oacute;n al crear tu usuario.<br />Si crees que no deber&iacute;a figurar como tal, puedes eliminarla de dicha cuenta y proporcionar una nueva direcci&oacute;n.</p>"
                        +"<p><br /><span style='color: #000080;'><strong>Atentamente,</strong></span><br />El equipo de Cuentas para Cotizaciones de <span style='color: #000080;'>Express Logistics Ramy</span>.</p>";


        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setContent(mensaje, "text/html"); 
            String cadena = Integer.toString(codigo);
            AsistenciaContrasena.codigo.setText(cadena);
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
           
        } catch (AddressException ex) {
            ConexionAlert poper = new ConexionAlert(null, true);
            poper.setVisible(true);
            Logger.getLogger(AsistenciaContrasena.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            ConexionAlert poper = new ConexionAlert(null, true);
            poper.setVisible(true);
            Logger.getLogger(AsistenciaContrasena.class.getName()).log(Level.SEVERE, null, ex);
        }
        AsistenciaContrasena.jLabel3.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        D = new javax.swing.JPanel();
        log3 = new JButtonEspecial.JButtonEspecial();
        info6 = new javax.swing.JLabel();
        info7 = new javax.swing.JLabel();
        info10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        D.setBackground(new java.awt.Color(255, 255, 255));
        D.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D.setName("D"); // NOI18N
        D.setLayout(null);

        log3.setBackground(new java.awt.Color(204, 204, 204));
        log3.setForeground(new java.awt.Color(128, 128, 131));
        log3.setText("Aceptar");
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
        D.add(log3);
        log3.setBounds(42, 270, 268, 37);

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setForeground(new java.awt.Color(130, 180, 232));
        info6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/correoooo.gif"))); // NOI18N
        D.add(info6);
        info6.setBounds(10, 1, 340, 210);

        info7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info7.setForeground(new java.awt.Color(130, 180, 232));
        info7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info7.setText("El correo ha sido enviado");
        D.add(info7);
        info7.setBounds(30, 205, 280, 20);

        info10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info10.setForeground(new java.awt.Color(130, 180, 232));
        info10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info10.setText("con éxito.");
        D.add(info10);
        info10.setBounds(30, 220, 280, 20);

        add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log3ActionPerformed
        E poper = new E();
        poper.setSize(350,330);
        D.removeAll();
        D.add(poper);
        D.revalidate();
        D.repaint();
    }//GEN-LAST:event_log3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel D;
    public static javax.swing.JLabel info10;
    public static javax.swing.JLabel info6;
    public static javax.swing.JLabel info7;
    private JButtonEspecial.JButtonEspecial log3;
    // End of variables declaration//GEN-END:variables
}
