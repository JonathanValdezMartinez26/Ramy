package Ventanas.Modulo_Usuario;

import Alerts.*;
import Alerts.AWTUtilities;
import Notificaciones.DesktopNotify;
import Ventanas.Modulo_Navegacion.Funciones;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class pnlUser_2 extends javax.swing.JDialog {

    int x, y;
    private boolean camposCorrectos = false;
    private String nombreActual = "";
    
    public pnlUser_2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        info1 = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPass = new jpass.JRPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        log = new JButtonEspecial.JButtonEspecial();
        lblPass = new javax.swing.JLabel();
        lblNombreNuevo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtUser = new app.bolivia.swing.JCTextField();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        info1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(102, 102, 102));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setText("Cambiar Nombre");
        jPanel7.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 30));

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 0, 30, 30));

        pnlPrincipal.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 463, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        txtPass.setBorder(null);
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setPlaceholder("Contraseña Actual");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 310, 30));

        jLabel1.setBackground(new java.awt.Color(153, 204, 0));
        pnlPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 30, 30));

        jLabel2.setBackground(new java.awt.Color(153, 204, 0));
        pnlPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 30, 30));

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Cambiar Usuario");
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
        pnlPrincipal.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 340, 25));

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(102, 102, 102));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 340, 20));

        lblNombreNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreNuevo.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblNombreNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 340, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iuser.png"))); // NOI18N
        pnlPrincipal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 110, 110));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cuenta protegida por contraseña");
        pnlPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Escribir un nuevo nombre de Usuario");
        pnlPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 290, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Asistente");
        pnlPrincipal.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 230, -1));

        txtUser.setBorder(null);
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPlaceholder("Nuevo Nombre de Usuario");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 340, 30));

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 7, 462, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        this.lblPass.setText("");
    }//GEN-LAST:event_txtPassKeyTyped

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        if (this.txtUser.getText().length() == 0 || this.txtPass.getText().length() == 0) {

            this.lblPass.setText("¡Todos los campos son requeridos!");
            this.txtUser.requestFocus();
        } else {
            camposCorrectos = true;
            if (Ventanas.Modulo_Usuario.Opciones.verificaUsuario(this.txtUser.getText()).equals(this.txtUser.getText())
                    && !this.txtUser.getText().equals(Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.getText())) {
                this.lblNombreNuevo.setText("El nombre de usuario ya existe.");
                camposCorrectos = false;
                this.txtUser.requestFocus();
            }
            String pass = Funciones.verificaPassword(Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.getText());
            System.out.println("");
            if (!pass.equals(this.txtPass.getText())) {
                this.lblPass.setText("La contraseña no es correcta.");
                camposCorrectos = false;
                this.txtPass.requestFocus();
            }

            if (camposCorrectos) {
                nombreActual = Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.getText();               
                if (Funciones.actualizarUs(Ventanas.Modulo_Navegacion.Principal_Admin.lblIDActivo.getText(), this.txtUser.getText())) {
                    DesktopNotify.showDesktopMessage("CAMBIAR NOMBRE DE USUARIO...", "Has cambiado el nombre de usuario: "
                        +nombreActual+" por: "+Funciones.obtenerUsuario(Ventanas.Modulo_Navegacion.Principal_Admin.lblIDActivo.getText()), DesktopNotify.INFORMATION, 8000);
                   Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.setText(Funciones.obtenerUsuario(Ventanas.Modulo_Navegacion.Principal_Admin.lblIDActivo.getText()));
                   this.dispose();      
                }
            }
        }
    }//GEN-LAST:event_logActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        this.lblNombreNuevo.setText("");
    }//GEN-LAST:event_txtUserKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pnlUser_2 dialog = new pnlUser_2(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel info1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblNombreNuevo;
    public static javax.swing.JLabel lblPass;
    private JButtonEspecial.JButtonEspecial log;
    public static javax.swing.JPanel pnlPrincipal;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static jpass.JRPasswordField txtPass;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
