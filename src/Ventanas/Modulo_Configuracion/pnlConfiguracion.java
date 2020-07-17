package Ventanas.Modulo_Configuracion;

import A_tabla.*;
import Clases.Conexion;
import Ventanas.Modulo_Usuario.pnlPass;
import Ventanas.Modulo_Usuario.pnlUser;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class pnlConfiguracion extends javax.swing.JPanel {

    public pnlConfiguracion() {
        initComponents();
        
    }
    
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConf_1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        pass = new javax.swing.JPanel();
        info1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pnlPrecios = new javax.swing.JPanel();
        info2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));

        pnlConf_1.setBackground(new java.awt.Color(255, 255, 255));
        pnlConf_1.setName("pnlConf_1"); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CAMBIAR NOMBRE DE");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 0, 153));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("USUARIO");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        user.setBackground(new java.awt.Color(51, 0, 153));
        user.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        user.setForeground(new java.awt.Color(0, 51, 51));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnUser.png"))); // NOI18N

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jPanel5.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 179, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 0, 153));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("CAMBIAR");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 150, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 0, 153));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("CONTRASEÑA");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        pass.setBackground(new java.awt.Color(51, 0, 153));
        pass.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        pass.setForeground(new java.awt.Color(204, 0, 0));
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passMouseExited(evt);
            }
        });

        info1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info1.setForeground(new java.awt.Color(102, 102, 102));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnPass.png"))); // NOI18N

        javax.swing.GroupLayout passLayout = new javax.swing.GroupLayout(pass);
        pass.setLayout(passLayout);
        passLayout.setHorizontalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        passLayout.setVerticalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        jPanel7.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 0, 153));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("INCREMENTO");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 0, 153));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("EN LOS PRECIOS");

        pnlPrecios.setBackground(new java.awt.Color(51, 0, 153));
        pnlPrecios.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        pnlPrecios.setForeground(new java.awt.Color(204, 0, 0));
        pnlPrecios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPreciosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPreciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPreciosMouseExited(evt);
            }
        });

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Estimar-100.png"))); // NOI18N

        javax.swing.GroupLayout pnlPreciosLayout = new javax.swing.GroupLayout(pnlPrecios);
        pnlPrecios.setLayout(pnlPreciosLayout);
        pnlPreciosLayout.setHorizontalGroup(
            pnlPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        pnlPreciosLayout.setVerticalGroup(
            pnlPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlConf_1Layout = new javax.swing.GroupLayout(pnlConf_1);
        pnlConf_1.setLayout(pnlConf_1Layout);
        pnlConf_1Layout.setHorizontalGroup(
            pnlConf_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConf_1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(pnlConf_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConf_1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlConf_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        pnlConf_1Layout.setVerticalGroup(
            pnlConf_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConf_1Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(pnlConf_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConf_1Layout.createSequentialGroup()
                        .addComponent(pnlPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel42)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel43))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConf_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConf_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed

    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed

    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed

    }//GEN-LAST:event_btnBackupActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed

    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        new pnlUser(null, true).setVisible(true);
    }//GEN-LAST:event_userMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        user.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_userMouseExited

    private void passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseExited
        pass.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_passMouseExited

    private void passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseEntered
        pass.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_passMouseEntered

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
    new pnlPass(null, true).setVisible(true);
    }//GEN-LAST:event_passMouseClicked

    private void pnlPreciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPreciosMouseClicked
        pnlIncrementoPrecios poper = new pnlIncrementoPrecios();
        
        poper.setSize(1106, 654);
        pnlConf_1.removeAll();
        pnlConf_1.add(poper);
        pnlConf_1.revalidate();
        pnlConf_1.repaint();
    }//GEN-LAST:event_pnlPreciosMouseClicked

    private void pnlPreciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPreciosMouseEntered
        pnlPrecios.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlPreciosMouseEntered

    private void pnlPreciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPreciosMouseExited
         pnlPrecios.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_pnlPreciosMouseExited
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    public static javax.swing.JLabel info2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pass;
    private javax.swing.JPanel pnlConf_1;
    private javax.swing.JPanel pnlPrecios;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables
}
