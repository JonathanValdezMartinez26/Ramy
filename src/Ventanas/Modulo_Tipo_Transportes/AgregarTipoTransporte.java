package Ventanas.Modulo_Tipo_Transportes;

import Ventanas.Modulo_Tipo_Transportes.AgregarTipoTransporte;
import Ventanas.Modulo_Tipo_Transportes.Opciones;
import Alerts.*;
import Alerts.AWTUtilities;
import Clases.Tipo_Transporte;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class AgregarTipoTransporte extends javax.swing.JDialog {

     int x, y;
    
    public AgregarTipoTransporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        this.txtTipo_Transporte.requestFocus();
    }

    public void Guardar(){
        String Nombre = txtTipo_Transporte.getText().trim();
        
     
        if("".equals(Nombre)){
            
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Complete todos los campos!");
            AC.msj2.setText("Llene correctamente");
            AC.setVisible(true);
             
        }
        else{
             if(Ventanas.Modulo_Tipo_Transportes.Opciones.verificaTipo(Nombre) == 0)
                {
                    Tipo_Transporte.Agregar_Tipo(Nombre);
                    Opciones.listar("");
                    this.dispose();
                }
            else{
                  Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡El Tipo de Transporte!");
                    AC.msj2.setText(" Ya existe.");
                    AC.setVisible(true);
               
            }
        }
    }
    
    public void Limpiar(){
        
        txtTipo_Transporte.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTipo_Transporte = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Guardar Tipo de Transporte");
        pnlagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregarMouseExited(evt);
            }
        });
        pnlagregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("    Guardar");
        pnlagregar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar (2).png"))); // NOI18N
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 69));

        txtTipo_Transporte.setBorder(null);
        txtTipo_Transporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipo_Transporte.setPlaceholder("Ej. A");
        txtTipo_Transporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipo_TransporteKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtTipo_Transporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("  Nombre del Tipo de Transporte");
        pnlPrincipal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

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

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Agregar Tipo de Transporte");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 30));

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, 30));

        pnlPrincipal.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 5, 350, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        Guardar();
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void txtTipo_TransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipo_TransporteKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
        int limite =25;
        if (txtTipo_Transporte.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTipo_TransporteKeyTyped

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarTipoTransporte dialog = new AgregarTipoTransporte(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static app.bolivia.swing.JCTextField txtTipo_Transporte;
    // End of variables declaration//GEN-END:variables

}
