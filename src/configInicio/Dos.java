/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package configInicio;

import static configInicio.Configuracion.txtNombre;
import static configInicio.Uno.txtPass;
import static configInicio.Uno.txtPass1;


/**
 *
 * @author Jonathan Valdez
 */
public class Dos extends javax.swing.JPanel {

    public Dos() {
        initComponents();
        lblPasw.setVisible(false);
        
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dos = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblInfo10 = new javax.swing.JLabel();
        rSButtonMetro3 = new rsbuttom.RSButtonMetro();
        jSeparator3 = new javax.swing.JSeparator();
        rSButtonMetro5 = new rsbuttom.RSButtonMetro();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPasw = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(592, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dos.setBackground(new java.awt.Color(249, 249, 249));
        Dos.setLayout(null);
        Dos.add(jSeparator2);
        jSeparator2.setBounds(10, 40, 570, 10);

        lblInfo10.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        lblInfo10.setForeground(new java.awt.Color(35, 8, 115));
        lblInfo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo10.setText("VERIFIQUE SUS DATOS ");
        Dos.add(lblInfo10);
        lblInfo10.setBounds(10, 10, 217, 30);

        rSButtonMetro3.setText("Atras");
        rSButtonMetro3.setToolTipText("Avanzar");
        rSButtonMetro3.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro3.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro3.setColorPressed(new java.awt.Color(0, 144, 183));
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        Dos.add(rSButtonMetro3);
        rSButtonMetro3.setBounds(240, 300, 150, 35);
        Dos.add(jSeparator3);
        jSeparator3.setBounds(10, 40, 570, 10);

        rSButtonMetro5.setText("Siguiente");
        rSButtonMetro5.setToolTipText("Avanzar");
        rSButtonMetro5.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro5.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro5.setColorPressed(new java.awt.Color(0, 144, 183));
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });
        Dos.add(rSButtonMetro5);
        rSButtonMetro5.setBounds(400, 300, 150, 35);

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("  Nombre Completo:");
        Dos.add(jLabel6);
        jLabel6.setBounds(20, 100, 177, 20);

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Nombre de Usuario:");
        Dos.add(jLabel11);
        jLabel11.setBounds(20, 150, 177, 20);

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText(" Correo Electrónico:");
        Dos.add(jLabel16);
        jLabel16.setBounds(20, 200, 177, 20);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 102, 102));
        Dos.add(lblNombre);
        lblNombre.setBounds(210, 100, 367, 20);

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(102, 102, 102));
        Dos.add(lblUser);
        lblUser.setBounds(210, 150, 367, 20);

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        Dos.add(lblEmail);
        lblEmail.setBounds(210, 200, 367, 20);
        Dos.add(lblPasw);
        lblPasw.setBounds(20, 50, 540, 30);

        add(Dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 592, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        String Nombre = lblNombre.getText();
        String User = lblUser.getText();
        String Email = lblEmail.getText();
        String Passw = lblPasw.getText();

        Uno poper = new Uno();
        poper.setSize(592, 350);
        poper.txtNombre.setText(Nombre);
        poper.txtUser.setText(User);
        poper.txtEmail.setText(Email);
        poper.txtPass.setText(Passw);
        poper.txtPass1.setText(Passw);

        Dos.removeAll();
        Dos.add(poper);
        Dos.revalidate();
        Dos.repaint();
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        String Nomb = lblNombre.getText().trim();
        String User = lblUser.getText().trim();
        String Pass = lblPasw.getText().trim();
        String Email = lblEmail.getText().trim();

        Tres poper = new Tres();
        poper.setSize(592, 350);
        poper.lblNombre.setText(Nomb);
        poper.lblUser.setText(User);
        poper.lblPass.setText(Pass);
        poper.lblEmail.setText(Email);

        Dos.removeAll();
        Dos.add(poper);
        Dos.revalidate();
        Dos.repaint();
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Dos;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfo10;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblPasw;
    public static javax.swing.JLabel lblUser;
    private rsbuttom.RSButtonMetro rSButtonMetro3;
    private rsbuttom.RSButtonMetro rSButtonMetro5;
    // End of variables declaration//GEN-END:variables
}
