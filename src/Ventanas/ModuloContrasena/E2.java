package Ventanas.ModuloContrasena;

import Alerts.ConexionAlert;
import Notificaciones.DesktopNotify;
import Ventanas.Modulo_Navegacion.Funciones;
import java.awt.event.WindowEvent;
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

public class E2 extends javax.swing.JPanel {

    public E2() {
        initComponents();
        
        AsistenciaContrasena.jLabel3.setText("Medidas preventivas...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        D = new javax.swing.JPanel();
        info2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        D.setBackground(new java.awt.Color(255, 255, 255));
        D.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D.setName("D"); // NOI18N
        D.setLayout(null);

        info2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setIcon(new javax.swing.ImageIcon("C:\\Users\\jvald\\Documents\\NetBeansProjects\\Copias Clinica Dr.Enrique\\24112019\\src\\Images\\tips.PNG")); // NOI18N
        D.add(info2);
        info2.setBounds(0, 0, 350, 330);

        add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel D;
    public static javax.swing.JLabel info2;
    // End of variables declaration//GEN-END:variables
}
