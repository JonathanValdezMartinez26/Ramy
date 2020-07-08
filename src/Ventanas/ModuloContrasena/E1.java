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

public class E1 extends javax.swing.JPanel {

    public E1() {
        initComponents();
        
        AsistenciaContrasena.jLabel3.setText("Cambiar la contraseña de "+ "");
    }
        private boolean camposCorrectos = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        E = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        log = new JButtonEspecial.JButtonEspecial();
        info1 = new javax.swing.JLabel();
        txtPass2 = new jpass.JRPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPass1 = new jpass.JRPasswordField();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        E.setBackground(new java.awt.Color(255, 255, 255));
        E.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        E.setName("E"); // NOI18N
        E.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Crea una contraseña segura que no utilices");
        E.add(jLabel5);
        jLabel5.setBounds(40, 30, 270, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Confirmar la contraseña");
        E.add(jLabel13);
        jLabel13.setBounds(43, 172, 230, 20);

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Cambiar Contraseña");
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
        E.add(log);
        log.setBounds(42, 270, 268, 37);

        info1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(153, 0, 0));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        E.add(info1);
        info1.setBounds(40, 240, 270, 30);

        txtPass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txtPass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass2KeyPressed(evt);
            }
        });
        E.add(txtPass2);
        txtPass2.setBounds(42, 200, 268, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("en otras cuentas.");
        E.add(jLabel6);
        jLabel6.setBounds(40, 45, 270, 17);
        jLabel6.getAccessibleContext().setAccessibleName("");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Crea una contraseña");
        E.add(jLabel14);
        jLabel14.setBounds(42, 90, 230, 20);

        txtPass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txtPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass1KeyPressed(evt);
            }
        });
        E.add(txtPass1);
        txtPass1.setBounds(42, 120, 268, 40);
        E.add(jSeparator1);
        jSeparator1.setBounds(40, 80, 270, 20);

        add(E, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        String Pass1 = txtPass1.getText().trim();
        String Pass2 = txtPass2.getText().trim();
        
        if (!"".equals(Pass1) && !"".equals(Pass2)) {
            
            try 
            {
                camposCorrectos = true;
                
                if(this.txtPass1.getText().length() < 8)
                {
                    this.info1.setText("Debés ingresar 8 caracteres como mínimo");
                    camposCorrectos = false;
                    this.txtPass1.requestFocus();
                }
            
                if(!this.txtPass2.getText().equals(this.txtPass1.getText()))    
                {
                    this.info1.setText("Las contraseñas no coinciden");
                    camposCorrectos = false;
                    this.txtPass2.requestFocus();
                }

                if (camposCorrectos) 
                {
                    if (Funciones.actualizarPass(AsistenciaContrasena.id.getText().trim(), this.txtPass1.getText())) 
                    {
                        DesktopNotify.showDesktopMessage("Crear Contraseña...", "Ha cambiado la contraseña con éxito.", DesktopNotify.INFORMATION, 8000);
                        E2 poper = new E2();
                        poper.setSize(350,330);
                        E.removeAll();
                        E.add(poper);
                        E.revalidate();
                        E.repaint();
                    }
                }
            } 
            catch(Exception ex) 
            {
                
            }   
        }
        else
        {
             if ("".equals(Pass1) && "".equals(Pass2)) 
             {
                this.info1.setText("Los campos son nesesarios, verifique");
                this.txtPass1.requestFocus(); 
             }
             else
             {
                if("".equals(Pass1))
                {
                    this.txtPass1.requestFocus();
                    this.info1.setText("Crear una Contraseña requerido");   
                }
                else
                {
                    if("".equals(Pass2))
                    {
                        this.txtPass2.requestFocus();
                        this.info1.setText("Campo Confirmar Contraseña requerido");
                    }
                }
             }
        }
    }//GEN-LAST:event_logActionPerformed

    private void txtPass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass2KeyPressed
        this.info1.setText("");
    }//GEN-LAST:event_txtPass2KeyPressed

    private void txtPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyPressed
         this.info1.setText("");
    }//GEN-LAST:event_txtPass1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel E;
    public static javax.swing.JLabel info1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private JButtonEspecial.JButtonEspecial log;
    public static jpass.JRPasswordField txtPass1;
    public static jpass.JRPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}
