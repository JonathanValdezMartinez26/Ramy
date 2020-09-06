package Ventanas.ModuloContrasena;

import Alerts.*;
import Alerts.AWTUtilities;
import Clases.Conexion;
import Ventanas.Modulo_Navegacion.Login;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import rojerusan.RSPanelsSlider;



public class AsistenciaContrasena extends javax.swing.JFrame{

     int x, y;
     int ID_Esp []; 
     boolean conexion = false;
    
    public AsistenciaContrasena() {
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Images/Icon.png")).getImage());
        correo.setVisible(false);
        codigo.setVisible(false);
        id.setVisible(false);
        user.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        pnlHome = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        info2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        A = new javax.swing.JPanel();
        info3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        log1 = new JButtonEspecial.JButtonEspecial();
        jLabel16 = new javax.swing.JLabel();
        info4 = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHome.setBackground(new java.awt.Color(249, 249, 250));
        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(210, 210, 214));
        jPanel7.setPreferredSize(new java.awt.Dimension(804, 30));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel7MouseDragged(evt);
            }
        });
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonMetro2.setText("X");
        rSButtonMetro2.setToolTipText("Cerrar");
        rSButtonMetro2.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro2.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro2.setColorPressed(new java.awt.Color(136, 0, 0));
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        info2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setText("¿No puedes iniciar sesión?");
        jPanel7.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 591, 30));

        pnlHome.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 591, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("De esta forma, sabremos que la cuenta te pertenece.");
        pnlHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 320, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/22.png"))); // NOI18N
        pnlHome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 210, 390));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlHome.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 10, 388));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setName("pnlPrincipal"); // NOI18N

        A.setBackground(new java.awt.Color(255, 255, 255));
        A.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        A.setName("A"); // NOI18N
        A.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info3.setForeground(new java.awt.Color(102, 102, 102));
        info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iuser.png"))); // NOI18N
        A.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Introduce la dirección de correo electrónico");
        A.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 120, 270, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText(" que esté asociada a esta cuenta.");
        A.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 135, 270, -1));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        A.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 200, 268, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("qué proporcionaste al crear la cuenta.");
        A.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 172, 250, 20));

        log1.setBackground(new java.awt.Color(204, 204, 204));
        log1.setForeground(new java.awt.Color(128, 128, 131));
        log1.setText("Siguiente");
        log1.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        log1.setColorHover(new java.awt.Color(204, 204, 204));
        log1.setColorNormal(new java.awt.Color(204, 204, 204));
        log1.setColorPressed(new java.awt.Color(153, 153, 153));
        log1.setColorTextHover(new java.awt.Color(128, 128, 131));
        log1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log1ActionPerformed(evt);
            }
        });
        A.add(log1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 270, 268, 37));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Introduce un correo electrónico");
        A.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 160, 240, 20));

        info4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        info4.setForeground(new java.awt.Color(153, 0, 0));
        info4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A.add(info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, 30));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlHome.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 61, 350, 330));
        pnlHome.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 40, -1));
        pnlHome.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));
        pnlHome.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 100, 20));
        pnlHome.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, -1, -1));

        jcMousePanel1.add(pnlHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 8, 590, 418));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        Login P = new Login();
        P.setVisible(true);
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        this.info4.setText("");
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        int limite =30;
        if (txtEmail.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void log1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log1ActionPerformed
        this.info4.setText("");

        if (!"".equals(this.txtEmail.getText())) {

            Socket sock = new Socket();
            InetSocketAddress addr = new InetSocketAddress("www.google.com",80);
            try
            {
                sock.connect(addr,3000);
                conexion = true;
                ///////////////////////////////////////////////////////////////
                String Correo = txtEmail.getText().trim();
                String ema = Ventanas.Modulo_Usuario.Opciones.verificaUsuarioCorreo(Correo);

                if (Correo.equals(ema)){
                    if(conexion == true)
                    {
                        correo.setText(ema);
                        B poper = new B();
                        poper.setSize(350, 330);
                        pnlPrincipal.removeAll();
                        pnlPrincipal.add(poper);
                        pnlPrincipal.revalidate();
                        pnlPrincipal.repaint();
                    }
                }
                else
                {
                    this.info4.setText("No se encontró tu cuenta. Vuelve a intentarlo");
                }
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
        }
        else
        {
            this.info4.setText("Ingresa la dirección de correo electrónico");
            this.txtEmail.requestFocus();
        }
    }//GEN-LAST:event_log1ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A;
    public static javax.swing.JLabel codigo;
    public static javax.swing.JLabel correo;
    public static javax.swing.JLabel id;
    public static javax.swing.JLabel info2;
    public static javax.swing.JLabel info3;
    public static javax.swing.JLabel info4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private JButtonEspecial.JButtonEspecial log1;
    public static javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlPrincipal;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static app.bolivia.swing.JCTextField txtEmail;
    public static javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

}
