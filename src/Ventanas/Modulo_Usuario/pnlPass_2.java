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


public class pnlPass_2 extends javax.swing.JDialog {

    int x, y;
    private boolean camposCorrectos = false;
    private String nombreActual = "";
    
    public pnlPass_2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        ojoabierto2.setVisible(false);
        ojoabierto1.setVisible(false);
        ojoabierto3.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        info2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new jpass.JRPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass1 = new jpass.JRPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPass2 = new jpass.JRPasswordField();
        log = new JButtonEspecial.JButtonEspecial();
        jLabel10 = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblPassNew = new javax.swing.JLabel();
        PanelNuevaContraseña = new javax.swing.JPanel();
        ojo2 = new javax.swing.JLabel();
        ojoabierto2 = new javax.swing.JLabel();
        PanelContraseñaActual = new javax.swing.JPanel();
        ojo1 = new javax.swing.JLabel();
        ojoabierto1 = new javax.swing.JLabel();
        PanelNuevaContraseña1 = new javax.swing.JPanel();
        ojo3 = new javax.swing.JLabel();
        ojoabierto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(null);

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 0, 30, 30));

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setText("Cambiar Contraseña");
        jPanel7.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        pnlPrincipal.add(jPanel7);
        jPanel7.setBounds(0, 0, 438, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel3);
        jLabel3.setBounds(50, 110, 230, 2);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel4);
        jLabel4.setBounds(160, 110, 230, 2);

        txtPass.setBorder(null);
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setPlaceholder("Contraseña Actual");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtPass);
        txtPass.setBounds(50, 80, 310, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel5);
        jLabel5.setBounds(50, 170, 230, 2);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel6);
        jLabel6.setBounds(160, 170, 230, 2);

        txtPass1.setBorder(null);
        txtPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass1.setPlaceholder("Nueva Contraseña");
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPass1KeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtPass1);
        txtPass1.setBounds(50, 140, 310, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel7);
        jLabel7.setBounds(50, 230, 230, 2);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel8);
        jLabel8.setBounds(160, 230, 230, 2);

        txtPass2.setBorder(null);
        txtPass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass2.setPlaceholder("Confirmar Nueva Contraseña");
        txtPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPass2KeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtPass2);
        txtPass2.setBounds(50, 200, 310, 30);

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Guardar Cambios");
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
        pnlPrincipal.add(log);
        log.setBounds(50, 270, 340, 25);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seguridad.png"))); // NOI18N
        pnlPrincipal.add(jLabel10);
        jLabel10.setBounds(10, 40, 48, 48);

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(info);
        info.setBounds(20, 240, 390, 20);

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(102, 102, 102));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblPass);
        lblPass.setBounds(50, 110, 340, 20);

        lblPassNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPassNew.setForeground(new java.awt.Color(102, 102, 102));
        lblPassNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblPassNew);
        lblPassNew.setBounds(50, 170, 340, 20);

        PanelNuevaContraseña.setBackground(new java.awt.Color(255, 255, 255));
        PanelNuevaContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseñaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseñaMouseReleased(evt);
            }
        });
        PanelNuevaContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ojo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo2.setForeground(new java.awt.Color(102, 102, 102));
        ojo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyecerrado.png"))); // NOI18N
        PanelNuevaContraseña.add(ojo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 30, 28));

        ojoabierto2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojoabierto2.setForeground(new java.awt.Color(102, 102, 102));
        ojoabierto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojoabierto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyeabierto.png"))); // NOI18N
        PanelNuevaContraseña.add(ojoabierto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 30, 28));

        pnlPrincipal.add(PanelNuevaContraseña);
        PanelNuevaContraseña.setBounds(360, 140, 30, 30);

        PanelContraseñaActual.setBackground(new java.awt.Color(255, 255, 255));
        PanelContraseñaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelContraseñaActualMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelContraseñaActualMouseReleased(evt);
            }
        });
        PanelContraseñaActual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ojo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo1.setForeground(new java.awt.Color(102, 102, 102));
        ojo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyecerrado.png"))); // NOI18N
        PanelContraseñaActual.add(ojo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 30, 28));

        ojoabierto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojoabierto1.setForeground(new java.awt.Color(102, 102, 102));
        ojoabierto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojoabierto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyeabierto.png"))); // NOI18N
        PanelContraseñaActual.add(ojoabierto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 30, 28));

        pnlPrincipal.add(PanelContraseñaActual);
        PanelContraseñaActual.setBounds(360, 80, 30, 30);

        PanelNuevaContraseña1.setBackground(new java.awt.Color(255, 255, 255));
        PanelNuevaContraseña1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseña1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelNuevaContraseña1MouseReleased(evt);
            }
        });
        PanelNuevaContraseña1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ojo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo3.setForeground(new java.awt.Color(102, 102, 102));
        ojo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyecerrado.png"))); // NOI18N
        PanelNuevaContraseña1.add(ojo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 20));

        ojoabierto3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojoabierto3.setForeground(new java.awt.Color(102, 102, 102));
        ojoabierto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojoabierto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eyeabierto.png"))); // NOI18N
        PanelNuevaContraseña1.add(ojoabierto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 20));

        pnlPrincipal.add(PanelNuevaContraseña1);
        PanelNuevaContraseña1.setBounds(360, 200, 30, 30);

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 7, 438, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtPass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyTyped
        this.lblPassNew.setText("");
    }//GEN-LAST:event_txtPass1KeyTyped

    private void txtPass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass2KeyTyped
        this.info.setText("");
    }//GEN-LAST:event_txtPass2KeyTyped

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        String Pass = txtPass.getText().trim();
        String Pass1 = txtPass1.getText().trim();
        String Pass2 = txtPass2.getText().trim();
        
        if (!"".equals(Pass) && !"".equals(Pass1) && !"".equals(Pass2)) {
            
            try 
            {
                camposCorrectos = true;
                String pass = Funciones.verificaPassword(Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.getText());
                if (!pass.equals(this.txtPass.getText())) 
                {
                    this.lblPass.setText("La contraseña no es correcta.");
                    camposCorrectos = false;
                    this.txtPass.requestFocus();
                } 
                
                if(this.txtPass1.getText().length() < 8)
                {
                    this.lblPassNew.setText("¡Debés ingresar 8 caracteres como mínimo!");
                    camposCorrectos = false;
                    this.txtPass1.requestFocus();
                }
            
                if(!this.txtPass2.getText().equals(this.txtPass1.getText()))    
                {
                    this.info.setText("¡Las contraseñas no coinciden!");
                    camposCorrectos = false;
                    this.txtPass2.requestFocus();
                }

                if (camposCorrectos) 
                {
                    if (Funciones.actualizarPass(Ventanas.Modulo_Navegacion.Principal_Admin.lblIDActivo.getText(), this.txtPass1.getText())) 
                    {
                        DesktopNotify.showDesktopMessage("Cambiar Contraseña...", "Ha cambiado la contraseña con éxito.", DesktopNotify.INFORMATION, 8000);
                        Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.setText(Funciones.obtenerUsuario(Ventanas.Modulo_Navegacion.Principal_Admin.lblIDActivo.getText()));
                        this.dispose();
                    }
                }
            } 
            catch(Exception ex) 
            {
                
            }   
        }
        else
        {
             if ("".equals(Pass) && "".equals(Pass1) && "".equals(Pass2)) 
             {
                this.info.setText(" ¡Los campos son nesesarios para completar la operación!");
                this.txtPass.requestFocus(); 
             }
             else
             {
                if("".equals(Pass))
                    {
                        this.txtPass.requestFocus();
                        this.info.setText("¡Campo Contraseña Actual requerido!");
                    }
                    else
                    {
                        if("".equals(Pass1))
                        {
                            this.txtPass1.requestFocus();
                            this.info.setText("¡Campo Nueva Contraseña requerido!");
                        }
                        else
                        {
                            if("".equals(Pass2))
                            {
                                this.txtPass2.requestFocus();
                                this.info.setText("¡Campo Confirmar Nueva Contraseña requerido!");
                            }
                        }
                    }
             }
        }
    }//GEN-LAST:event_logActionPerformed

    private void PanelNuevaContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseñaMousePressed
        txtPass1.setEchoChar((char)0);
        ojo2.setVisible(false);
        ojoabierto2.setVisible(true);
    }//GEN-LAST:event_PanelNuevaContraseñaMousePressed

    private void PanelNuevaContraseñaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseñaMouseReleased
        txtPass1.setEchoChar((char)42);
        ojo2.setVisible(true);
        ojoabierto2.setVisible(false);
    }//GEN-LAST:event_PanelNuevaContraseñaMouseReleased

    private void PanelContraseñaActualMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelContraseñaActualMousePressed
        txtPass.setEchoChar((char)0);
        ojo1.setVisible(false);
        ojoabierto1.setVisible(true);
    }//GEN-LAST:event_PanelContraseñaActualMousePressed

    private void PanelContraseñaActualMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelContraseñaActualMouseReleased
        txtPass.setEchoChar((char)42);
        ojo1.setVisible(true);
        ojoabierto1.setVisible(false);
    }//GEN-LAST:event_PanelContraseñaActualMouseReleased

    private void PanelNuevaContraseña1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseña1MousePressed
        txtPass2.setEchoChar((char)0);
        ojo3.setVisible(false);
        ojoabierto3.setVisible(true);
    }//GEN-LAST:event_PanelNuevaContraseña1MousePressed

    private void PanelNuevaContraseña1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseña1MouseReleased
        txtPass2.setEchoChar((char)42);
        ojo3.setVisible(true);
        ojoabierto3.setVisible(false);
    }//GEN-LAST:event_PanelNuevaContraseña1MouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pnlPass_2 dialog = new pnlPass_2(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelContraseñaActual;
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JPanel PanelNuevaContraseña1;
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblPass;
    public static javax.swing.JLabel lblPassNew;
    private JButtonEspecial.JButtonEspecial log;
    public static javax.swing.JLabel ojo1;
    public static javax.swing.JLabel ojo2;
    public static javax.swing.JLabel ojo3;
    public static javax.swing.JLabel ojoabierto1;
    public static javax.swing.JLabel ojoabierto2;
    public static javax.swing.JLabel ojoabierto3;
    public static javax.swing.JPanel pnlPrincipal;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static jpass.JRPasswordField txtPass;
    public static jpass.JRPasswordField txtPass1;
    public static jpass.JRPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables

}
