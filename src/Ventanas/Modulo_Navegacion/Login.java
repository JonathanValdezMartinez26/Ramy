package Ventanas.Modulo_Navegacion;

import Alerts.AWTUtilities;
import Alerts.AgregarCit;
import Alerts.FadeEffect;
import Clases.Conexion;
import Ventanas.ModuloContrasena.AsistenciaContrasena;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 
public class Login extends javax.swing.JFrame {
   
    int x, y;
    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;
    ResultSet resultado;
    
    public Login() {
        initComponents();
        AWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        this.txtUser.requestFocus();
        setIconImage(new ImageIcon(getClass().getResource("/Images/Icon.png")).getImage());
        setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
     
    
    public void Conectar() {

        String User = txtUser.getText().trim();
        String Pass = txtPass.getText().trim();
        

        if (!"".equals(User) && !"".equals(Pass)) {
            
            int ID_Usuario = 0, Rol = 0;
            String Nombre = "";

            try {

                resultado = cc.consulta("Select ID_Usuario, ID_Rol_Usuario, Nombre_Usuario from usuario where Usuario = '" + User + "' "
                        + " and Contrasena_Usuario = '" + Pass + "' and Estado = " + true);

                while (resultado.next()) {
                    ID_Usuario = resultado.getInt(1);
                    Rol = resultado.getInt(2);
                    Nombre = resultado.getString(3);

                }

            } catch (SQLException ex) {
            }

            if (ID_Usuario == 0) {
                this.info.setText("¡Usuario y/o contraseña incorrectos!");
                txtUser.setText("");
                txtPass.setText("");
                txtUser.requestFocus();
                return;
            }
            if(Rol == 1)
            {
                Principal_Admin P = new Principal_Admin();
                String id = Funciones.obtenerID(this.txtUser.getText());
                P.info.setText("Admin. "+ Nombre);
                P.lblUserActivo.setText(this.txtUser.getText());
                P.lblIDActivo.setText(id);
                P.setVisible(true);
                P.toFront();
            }
            else
            { 
                if(Rol == 2)
                {
//                    Principal_Secretaria P = new Principal_Secretaria();
//                    String id = Funciones.obtenerID(this.txtUser.getText());
//                    P.info.setText("Asis. "+ Nombre);
//                    P.lblUserActivo.setText(this.txtUser.getText());
//                    P.lblIDActivo.setText(id);
//                    P.setVisible(true);
//                    P.toFront();
                }
            }
            
            
            this.dispose();

            

        } 
        else 
            {
                 if (!"".equals(User))
                    {
                        this.info.setText("¡Contraseña requerida!");
                        this.txtPass.requestFocus();
                    }
                else
                {
                    if (!"".equals(Pass))
                        {
                            this.info.setText("¡Nombre de usuario requerido!");
                            this.txtUser.requestFocus();
                        }
                    else
                        {
                            Falta();
                        }
                }
            }

    }
    
    public void Falta()
    {
        this.info.setText(" ¡Usuario y contraseña requeridos!");
        this.txtUser.requestFocus();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        txtUser = new app.bolivia.swing.JCTextField();
        txtPass = new jpass.JRPasswordField();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        CR = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        log = new JButtonEspecial.JButtonEspecial();
        PanelNuevaContraseña = new javax.swing.JPanel();
        ojo1 = new javax.swing.JLabel();
        ojo2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setBackground(new java.awt.Color(236, 235, 235));
        txtUser.setBorder(null);
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPlaceholder(" Usuario");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 244, 190, 30));

        txtPass.setBackground(new java.awt.Color(236, 235, 235));
        txtPass.setBorder(null);
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setPlaceholder("Contraseña");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 290, 170, 30));

        jPanel7.setBackground(new java.awt.Color(210, 210, 214));
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 560, Short.MAX_VALUE)
                .addComponent(rSButtonMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rSButtonMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 30));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 8, 115));
        jLabel4.setText("Bienvenido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 210, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ramy.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-530, -230, 770, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 380, 10));

        CR.setBackground(new java.awt.Color(204, 204, 204));
        CR.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        CR.setForeground(new java.awt.Color(153, 153, 153));
        CR.setText("¿Olvidaste tu contraseña?");
        CR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CRMouseExited(evt);
            }
        });
        jPanel1.add(CR, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 150, -1));

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 250, 20));

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Iniciar Sesión");
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
        jPanel1.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 250, 25));

        PanelNuevaContraseña.setBackground(new java.awt.Color(249, 249, 249));
        PanelNuevaContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseñaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseñaMouseReleased(evt);
            }
        });
        PanelNuevaContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ojo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo1.setForeground(new java.awt.Color(102, 102, 102));
        ojo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojito1.png"))); // NOI18N
        PanelNuevaContraseña.add(ojo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        ojo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo2.setForeground(new java.awt.Color(102, 102, 102));
        ojo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojito2.png"))); // NOI18N
        PanelNuevaContraseña.add(ojo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel1.add(PanelNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 285, 33, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoRamy1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 250, 130));

        jPanel2.setBackground(new java.awt.Color(236, 235, 235));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 287, 242, 37));

        jPanel3.setBackground(new java.awt.Color(236, 235, 235));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconl.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 240, 242, -1));

        jcMousePanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 9, 590, 418));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
       
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
       
    }//GEN-LAST:event_materialButton1ActionPerformed

    private void materialButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_materialButton1KeyTyped
        this.info.setText("");
    }//GEN-LAST:event_materialButton1KeyTyped

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed

    }//GEN-LAST:event_ExitActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        this.info.setText("");
    }//GEN-LAST:event_txtUserKeyTyped

    private void CRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRMouseEntered
    Font font = CR.getFont();
    Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    CR.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_CRMouseEntered

    private void CRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRMouseExited
    Font font = CR.getFont();
    Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
    attributes.put(TextAttribute.UNDERLINE, -1);
    CR.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_CRMouseExited

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        this.info.setText("");
    }//GEN-LAST:event_txtPassKeyTyped

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        Conectar();
    }//GEN-LAST:event_logActionPerformed

    private void PanelNuevaContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseñaMousePressed
        txtPass.setEchoChar((char)0);
        ojo1.setVisible(false);
        ojo2.setVisible(true);
    }//GEN-LAST:event_PanelNuevaContraseñaMousePressed

    private void PanelNuevaContraseñaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseñaMouseReleased
        txtPass.setEchoChar((char)42);
        ojo1.setVisible(true);
        ojo2.setVisible(false);
    }//GEN-LAST:event_PanelNuevaContraseñaMouseReleased

    private void CRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRMouseClicked
        AsistenciaContrasena P = new AsistenciaContrasena();
        P.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CRMouseClicked
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
    private javax.swing.JLabel CR;
    private javax.swing.JPanel PanelNuevaContraseña;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator2;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private JButtonEspecial.JButtonEspecial log;
    public static javax.swing.JLabel ojo1;
    public static javax.swing.JLabel ojo2;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static jpass.JRPasswordField txtPass;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
