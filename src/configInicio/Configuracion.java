/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configInicio;

import Alerts.AWTUtilities;
import Alerts.FadeEffect;
import Notificaciones.DesktopNotify;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Configuracion extends javax.swing.JFrame {

    int i = 32;
    int x,y;
    
    public Configuracion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Images/Icon.png")).getImage());
        this.setLocationRelativeTo(this);

        FadeEffect.fadeInFrameSplash(this, 10, 0.1f);
        AWTUtilities.setOpaque(this, false);
        this.txtNombre.requestFocus();
        
    }
    
    public void Falta()
    {
        this.lblInfo.setText(" ¡Todos los Campos son Requeridos!");
        this.txtNombre.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro1 = new rsbuttom.RSButtonMetro();
        rSButtonMetro2 = new rsbuttom.RSButtonMetro();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        pnlUsuario = new javax.swing.JPanel();
        txtNombre = new app.bolivia.swing.JCTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblInfo10 = new javax.swing.JLabel();
        txtUser = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ob = new javax.swing.JLabel();
        rSButtonMetro3 = new rsbuttom.RSButtonMetro();
        jSeparator3 = new javax.swing.JSeparator();
        txtPass = new jpass.JRPasswordField();
        PanelNuevaContraseña = new javax.swing.JPanel();
        ojo1 = new javax.swing.JLabel();
        ojo2 = new javax.swing.JLabel();
        txtPass1 = new jpass.JRPasswordField();
        PanelNuevaContraseña1 = new javax.swing.JPanel();
        ojo3 = new javax.swing.JLabel();
        ojo4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setBackground(new java.awt.Color(249, 249, 249));
        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        rSButtonMetro1.setText("-");
        rSButtonMetro1.setToolTipText("Minimizar");
        rSButtonMetro1.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro1.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro1.setColorPressed(new java.awt.Color(102, 102, 102));
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel7.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 0, 30, 30));

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 0, 30, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 7, 794, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/portadainstalacion.png"))); // NOI18N
        jcMousePanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 37, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jcMousePanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 30, -1, 360));

        pnlUsuario.setBackground(new java.awt.Color(249, 249, 249));
        pnlUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(236, 235, 235));
        txtNombre.setBorder(null);
        txtNombre.setToolTipText("Evite el Uso de Caracteres Especiales");
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setPlaceholder("Ej. Pedro Perez Flores");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlUsuario.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 30));
        pnlUsuario.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 570, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Caja.png"))); // NOI18N
        pnlUsuario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 330, 50));

        lblInfo10.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        lblInfo10.setForeground(new java.awt.Color(35, 8, 115));
        lblInfo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo10.setText("CONFIGURAR USUARIO SUPER ADMIN");
        pnlUsuario.add(lblInfo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtUser.setBackground(new java.awt.Color(236, 235, 235));
        txtUser.setBorder(null);
        txtUser.setToolTipText("Con el Iniciara Sesión");
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPlaceholder("Ej. Pedro");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnlUsuario.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 150, 30));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Nombre Completo*");
        pnlUsuario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 20));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Contraseña*");
        pnlUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 20));

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(102, 102, 102));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlUsuario.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 520, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jLabel7.setName(""); // NOI18N
        pnlUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 70, 180, 50));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Nombre de Usuario*");
        pnlUsuario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 50, 150, 20));

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Contraseña:");
        pnlUsuario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 20));

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Confirmar Contraseña*");
        pnlUsuario.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 160, 20));

        txtEmail.setBackground(new java.awt.Color(236, 235, 235));
        txtEmail.setBorder(null);
        txtEmail.setToolTipText("Sera el Medio de Recuperación de su Contraseña");
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setPlaceholder("Ej. pedroperezflores@dominio.com");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        pnlUsuario.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 310, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Caja.png"))); // NOI18N
        pnlUsuario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 330, 50));

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Correo Electrónico*");
        pnlUsuario.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, 20));

        ob.setBackground(new java.awt.Color(153, 153, 153));
        ob.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        ob.setForeground(new java.awt.Color(153, 153, 153));
        ob.setText("* Campos Obligatorios");
        pnlUsuario.add(ob, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 130, 20));

        rSButtonMetro3.setText("Siguiente");
        rSButtonMetro3.setToolTipText("Avanzar");
        rSButtonMetro3.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro3.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro3.setColorPressed(new java.awt.Color(0, 144, 183));
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        pnlUsuario.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));
        pnlUsuario.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 570, 10));

        txtPass.setBackground(new java.awt.Color(236, 235, 235));
        txtPass.setBorder(null);
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setPlaceholder("********");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        pnlUsuario.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 149, 170, 35));

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

        pnlUsuario.add(PanelNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 145, 33, 40));

        txtPass1.setBackground(new java.awt.Color(236, 235, 235));
        txtPass1.setBorder(null);
        txtPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass1.setPlaceholder("Contraseña");
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass1KeyPressed(evt);
            }
        });
        pnlUsuario.add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 170, 30));

        PanelNuevaContraseña1.setBackground(new java.awt.Color(249, 249, 249));
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
        ojo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojito1.png"))); // NOI18N
        PanelNuevaContraseña1.add(ojo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        ojo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ojo4.setForeground(new java.awt.Color(102, 102, 102));
        ojo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ojo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojito2.png"))); // NOI18N
        PanelNuevaContraseña1.add(ojo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        pnlUsuario.add(PanelNuevaContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 145, 33, 40));

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

        pnlUsuario.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 147, 242, 37));

        jPanel3.setBackground(new java.awt.Color(236, 235, 235));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        pnlUsuario.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 147, 242, 37));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 38, 592, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        this.setExtendedState(ICONIFIED);
        this.setExtendedState(1);
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        this.lblInfo.setText("");
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$");
 
        String email = txtEmail.getText();
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            this.lblInfo.setText("");
        } else {
            this.lblInfo.setText("El Email Ingresado es Inválido");
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
        int limite =20;
        if (txtUser.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
        
        int limite =40;
        if (txtNombre.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        String Nomb = txtNombre.getText().trim();
        String User = txtUser.getText().trim();
        String Pass = txtPass.getText().trim();
        String Pass1 = txtPass1.getText().trim();
        String Email = txtEmail.getText().trim();
        
        if (!"".equals(Nomb) && !"".equals(User) && !"".equals(Pass) && !"".equals(Pass1) && !"".equals(Email)) 
        {
            if(Pass.equals(Pass1))
            {
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                String email = txtEmail.getText();
                Matcher mather = pattern.matcher(email);
                if(mather.find() == true)
                {
                    Dos poper = new Dos();
                    poper.setSize(592, 350);
                    poper.lblNombre.setText(Nomb);
                    poper.lblUser.setText(User);
                    poper.lblEmail.setText(Email);
                    poper.lblPasw.setText(Pass);

                    pnlPrincipal.removeAll();
                    pnlPrincipal.add(poper);
                    pnlPrincipal.revalidate();
                    pnlPrincipal.repaint();
                }
                else
                {
                    this.lblInfo.setText("El Email Ingresado es Inválido");
                    txtEmail.requestFocus();
                }
            }
            else
            {
                this.lblInfo.setText("¡La Contraseña no Coincide, Verifique!");
                this.txtPass1.requestFocus();
            }
        } 
        else 
            {
                 if ("".equals(Nomb))
                    {
                        this.lblInfo.setText("¡Nombre Completo Requerido!");
                        this.txtNombre.requestFocus();
                    }
                else
                    {
                        if ("".equals(User))
                            {
                                this.lblInfo.setText("¡Nombre de Usuario Requerido!");
                                this.txtUser.requestFocus();
                            }
                        else
                            {
                                if ("".equals(Pass))
                                {
                                    this.lblInfo.setText("¡Contraseña Requerida!");
                                    this.txtPass.requestFocus();
                                    
                                }
                                else
                                {
                                    if ("".equals(Pass1))
                                    {
                                        this.lblInfo.setText("¡Confirme la Contraseña!");
                                        this.txtPass1.requestFocus();
                                    }
                                else
                                    {
                                        if ("".equals(Email))
                                        {
                                            this.lblInfo.setText("¡Correo Electrónico Requerido!");
                                            this.txtEmail.requestFocus();
                                        }
                                        else
                                        {
                                            Falta();
                                        }
                                    }
                                }
                            }
                    }
            }
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
         this.lblInfo.setText("");
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
         this.lblInfo.setText("");
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
         this.lblInfo.setText("");
    }//GEN-LAST:event_txtEmailKeyPressed

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

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
         this.lblInfo.setText("");
    }//GEN-LAST:event_txtPassKeyPressed

    private void PanelNuevaContraseña1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseña1MousePressed
        txtPass1.setEchoChar((char)0);
        ojo3.setVisible(false);
        ojo4.setVisible(true);
    }//GEN-LAST:event_PanelNuevaContraseña1MousePressed

    private void PanelNuevaContraseña1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelNuevaContraseña1MouseReleased
        txtPass1.setEchoChar((char)42);
        ojo3.setVisible(true);
        ojo4.setVisible(false);
    }//GEN-LAST:event_PanelNuevaContraseña1MouseReleased

    private void txtPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtPass1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JPanel PanelNuevaContraseña1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfo10;
    private javax.swing.JLabel ob;
    public static javax.swing.JLabel ojo1;
    public static javax.swing.JLabel ojo2;
    public static javax.swing.JLabel ojo3;
    public static javax.swing.JLabel ojo4;
    private javax.swing.JPanel pnlPrincipal;
    public static javax.swing.JPanel pnlUsuario;
    private rsbuttom.RSButtonMetro rSButtonMetro1;
    private rsbuttom.RSButtonMetro rSButtonMetro2;
    private rsbuttom.RSButtonMetro rSButtonMetro3;
    public static app.bolivia.swing.JCTextField txtEmail;
    public static app.bolivia.swing.JCTextField txtNombre;
    public static jpass.JRPasswordField txtPass;
    public static jpass.JRPasswordField txtPass1;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
