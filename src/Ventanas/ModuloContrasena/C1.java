package Ventanas.ModuloContrasena;

import Alerts.ConexionAlert;
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
import java.util.Timer;
import java.util.TimerTask;

public class C1 extends javax.swing.JPanel {

    public C1() {
        initComponents();
       
        AsistenciaContrasena.jLabel3.setText("Estamos por terminar...");
        final Timer timer = new Timer();
        
        TimerTask task = new TimerTask() 
        {
            public void run() 
            {
                System.out.println("acción acontecida");
                D poper = new D();
                poper.setSize(350,330);
                C.removeAll();
                C.add(poper);
                C.revalidate();
                C.repaint();
            }
        };
        timer.schedule(task, 100); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        C = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        info8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        C.setBackground(new java.awt.Color(255, 255, 255));
        C.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        C.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Accediendo al servidor");
        C.add(jLabel20);
        jLabel20.setBounds(0, 170, 350, 20);

        uno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uno.setForeground(new java.awt.Color(102, 102, 102));
        uno.setText("              Espere un momento...");
        C.add(uno);
        uno.setBounds(50, 187, 270, 17);

        info8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info8.setForeground(new java.awt.Color(102, 102, 102));
        info8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cargando-Espere-Por-Favor-62159.gif"))); // NOI18N
        C.add(info8);
        info8.setBounds(0, 70, 350, 120);

        add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel C;
    public static javax.swing.JLabel info8;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel uno;
    // End of variables declaration//GEN-END:variables
}
