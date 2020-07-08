package configInicio;

import static configInicio.Configuracion.txtEmail;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uno extends javax.swing.JPanel {

    public Uno() {
        initComponents();
      
    }
    
    public void Falta()
    {
        this.lblInfo.setText(" ¡Todos los Campos son Requeridos!");
        this.txtNombre.requestFocus();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        txtNombre = new app.bolivia.swing.JCTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblInfo10 = new javax.swing.JLabel();
        txtUser = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ob = new javax.swing.JLabel();
        rSButtonMetro3 = new rsbuttom.RSButtonMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPass = new jpass.JRPasswordField();
        jLabel2 = new javax.swing.JLabel();
        PanelNuevaContraseña = new javax.swing.JPanel();
        ojo1 = new javax.swing.JLabel();
        ojo2 = new javax.swing.JLabel();
        txtPass1 = new jpass.JRPasswordField();
        jLabel8 = new javax.swing.JLabel();
        PanelNuevaContraseña1 = new javax.swing.JPanel();
        ojo3 = new javax.swing.JLabel();
        ojo4 = new javax.swing.JLabel();

        pnlPrincipal.setBackground(new java.awt.Color(249, 249, 249));
        pnlPrincipal.setLayout(null);

        txtNombre.setBackground(new java.awt.Color(236, 235, 235));
        txtNombre.setBorder(null);
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
        pnlPrincipal.add(txtNombre);
        txtNombre.setBounds(50, 80, 310, 30);
        pnlPrincipal.add(jSeparator2);
        jSeparator2.setBounds(10, 40, 570, 10);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Caja.png"))); // NOI18N
        pnlPrincipal.add(jLabel4);
        jLabel4.setBounds(40, 70, 330, 50);

        lblInfo10.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        lblInfo10.setForeground(new java.awt.Color(35, 8, 115));
        lblInfo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo10.setText("CONFIGURAR USUARIO SUPER ADMIN");
        pnlPrincipal.add(lblInfo10);
        lblInfo10.setBounds(10, 10, 350, 30);

        txtUser.setBackground(new java.awt.Color(236, 235, 235));
        txtUser.setBorder(null);
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
        pnlPrincipal.add(txtUser);
        txtUser.setBounds(390, 80, 150, 30);

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Nombre Completo*");
        pnlPrincipal.add(jLabel6);
        jLabel6.setBounds(40, 50, 140, 20);

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(102, 102, 102));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblInfo);
        lblInfo.setBounds(40, 260, 520, 30);

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Nombre de Usuario*");
        pnlPrincipal.add(jLabel11);
        jLabel11.setBounds(377, 50, 150, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jLabel7.setName(""); // NOI18N
        pnlPrincipal.add(jLabel7);
        jLabel7.setBounds(377, 70, 180, 50);

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
        pnlPrincipal.add(txtEmail);
        txtEmail.setBounds(50, 220, 310, 30);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Caja.png"))); // NOI18N
        pnlPrincipal.add(jLabel13);
        jLabel13.setBounds(40, 210, 330, 50);

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Correo Electrónico*");
        pnlPrincipal.add(jLabel16);
        jLabel16.setBounds(40, 190, 140, 20);

        ob.setBackground(new java.awt.Color(153, 153, 153));
        ob.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        ob.setForeground(new java.awt.Color(153, 153, 153));
        ob.setText("* Campos Obligatorios");
        pnlPrincipal.add(ob);
        ob.setBounds(40, 320, 130, 20);

        rSButtonMetro3.setText("Siguiente");
        rSButtonMetro3.setToolTipText("");
        rSButtonMetro3.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro3.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro3.setColorPressed(new java.awt.Color(0, 144, 183));
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        pnlPrincipal.add(rSButtonMetro3);
        rSButtonMetro3.setBounds(400, 300, 150, 35);

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Contraseña*");
        pnlPrincipal.add(jLabel5);
        jLabel5.setBounds(40, 120, 130, 20);

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Contraseña:");
        pnlPrincipal.add(jLabel12);
        jLabel12.setBounds(40, 120, 130, 20);

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Confirmar Contraseña*");
        pnlPrincipal.add(jLabel14);
        jLabel14.setBounds(300, 120, 160, 20);

        txtPass.setBackground(new java.awt.Color(236, 235, 235));
        txtPass.setBorder(null);
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setPlaceholder("********");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        pnlPrincipal.add(txtPass);
        txtPass.setBounds(90, 149, 170, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/copntra1.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel2);
        jLabel2.setBounds(40, 140, 217, 50);

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

        pnlPrincipal.add(PanelNuevaContraseña);
        PanelNuevaContraseña.setBounds(257, 145, 33, 40);

        txtPass1.setBackground(new java.awt.Color(236, 235, 235));
        txtPass1.setBorder(null);
        txtPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass1.setPlaceholder("Contraseña");
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass1KeyPressed(evt);
            }
        });
        pnlPrincipal.add(txtPass1);
        txtPass1.setBounds(350, 150, 170, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/copntra1.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel8);
        jLabel8.setBounds(302, 140, 217, 50);

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

        pnlPrincipal.add(PanelNuevaContraseña1);
        PanelNuevaContraseña1.setBounds(518, 145, 33, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtEmailKeyPressed

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

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtUserKeyPressed

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

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtPassKeyPressed

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

    private void txtPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyPressed
        this.lblInfo.setText("");
    }//GEN-LAST:event_txtPass1KeyPressed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JPanel PanelNuevaContraseña1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfo10;
    private javax.swing.JLabel ob;
    public static javax.swing.JLabel ojo1;
    public static javax.swing.JLabel ojo2;
    public static javax.swing.JLabel ojo3;
    public static javax.swing.JLabel ojo4;
    public static javax.swing.JPanel pnlPrincipal;
    private rsbuttom.RSButtonMetro rSButtonMetro3;
    public static app.bolivia.swing.JCTextField txtEmail;
    public static app.bolivia.swing.JCTextField txtNombre;
    public static jpass.JRPasswordField txtPass;
    public static jpass.JRPasswordField txtPass1;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
