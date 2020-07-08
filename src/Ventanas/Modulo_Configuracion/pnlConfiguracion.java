/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas.Modulo_Configuracion;

import A_tabla.*;
import Clases.Cita;
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
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        resp = new javax.swing.JPanel();
        info2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        resp1 = new javax.swing.JPanel();
        info3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));

        pnlConf_1.setBackground(new java.awt.Color(255, 255, 255));
        pnlConf_1.setName("pnlConf_1"); // NOI18N
        pnlConf_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 144, 183));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CAMBIAR NOMBRE DE");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 144, 183));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("USUARIO");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        user.setBackground(new java.awt.Color(0, 144, 183));
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

        pnlConf_1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 136, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 144, 183));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("CAMBIAR");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 150, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 144, 183));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("CONTRASEÑA");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 150, -1));

        pass.setBackground(new java.awt.Color(0, 144, 183));
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

        pnlConf_1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 136, -1, 220));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 144, 183));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("CREAR RESPALDO");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 144, 183));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("BASE DE DATOS(BD)");

        resp.setBackground(new java.awt.Color(0, 144, 183));
        resp.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        resp.setForeground(new java.awt.Color(204, 0, 0));
        resp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                respMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                respMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                respMouseExited(evt);
            }
        });

        info2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info2.setForeground(new java.awt.Color(102, 102, 102));
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/data.png"))); // NOI18N

        javax.swing.GroupLayout respLayout = new javax.swing.GroupLayout(resp);
        resp.setLayout(respLayout);
        respLayout.setHorizontalGroup(
            respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        respLayout.setVerticalGroup(
            respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, respLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(resp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlConf_1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 136, -1, 230));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 144, 183));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("RESTAURAR");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 144, 183));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("BASE DE DATOS(BD)");

        resp1.setBackground(new java.awt.Color(0, 144, 183));
        resp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        resp1.setForeground(new java.awt.Color(204, 0, 0));
        resp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resp1MouseExited(evt);
            }
        });

        info3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info3.setForeground(new java.awt.Color(102, 102, 102));
        info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnRestore.png"))); // NOI18N

        javax.swing.GroupLayout resp1Layout = new javax.swing.GroupLayout(resp1);
        resp1.setLayout(resp1Layout);
        resp1Layout.setHorizontalGroup(
            resp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        resp1Layout.setVerticalGroup(
            resp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(resp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(resp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlConf_1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 136, -1, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(pnlConf_1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(pnlConf_1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void respMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_respMouseClicked

    private void respMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respMouseEntered
        resp.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY)); 
    }//GEN-LAST:event_respMouseEntered

    private void respMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respMouseExited
        resp.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_respMouseExited

    private void resp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resp1MouseClicked
        
    }//GEN-LAST:event_resp1MouseClicked

    private void resp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resp1MouseEntered
        resp1.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_resp1MouseEntered

    private void resp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resp1MouseExited
        resp1.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_resp1MouseExited

    private void passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseExited
        pass.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,Color.white));
    }//GEN-LAST:event_passMouseExited

    private void passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseEntered
        pass.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.DARK_GRAY, Color.LIGHT_GRAY));
    }//GEN-LAST:event_passMouseEntered

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
    new pnlPass(null, true).setVisible(true);
    }//GEN-LAST:event_passMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    public static javax.swing.JLabel info2;
    public static javax.swing.JLabel info3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pass;
    private javax.swing.JPanel pnlConf_1;
    private javax.swing.JPanel resp;
    private javax.swing.JPanel resp1;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables
}
