package Ventanas.Modulo_Usuario;

import Alerts.*;
import Alerts.AWTUtilities;
import Clases.Conexion;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class AgregarUser extends javax.swing.JDialog {

     int x, y;
     ResultSet resultado;
     int ID_Esp [];
    
    public AgregarUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        correo.setVisible(false);
        
    }
    boolean conexion = false;
    
    public void Guardar(){
        if (this.txtNombre.getText().length() == 0 || this.txtUser.getText().length() == 0
                || this.txtEmail.getText().length() == 0 || this.cmbRol.getSelectedIndex() == 0) {
                
                   Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                   AC.msj1.setText("¡Llene todos los campos!");
                   AC.msj2.setText("Seleccione Correctamente");
                   AC.setVisible(true);
            
        } 
        else 
        {
                if (Ventanas.Modulo_Usuario.Opciones.verificaNombreUser(txtNombre.getText().trim()) != 0) 
                {
                    this.lblNombre.setText("El usuario ya tiene una cuenta.");
                    this.txtNombre.requestFocus();
                }
                else
                {
                    if (Ventanas.Modulo_Usuario.Opciones.verificaUser(txtUser.getText().trim()) != 0) 
                    {
                        this.lblUsuario.setText("El nombre de usuario no está disponible.");
                        this.txtUser.requestFocus();
                    }
                    else
                    {
                        if (Ventanas.Modulo_Usuario.Opciones.verificaUsuarioEmail(txtEmail.getText().trim()) != 0) 
                        {
                            this.lblEmail.setText("El Correo Electrónico ya está registrado.");
                            this.txtEmail.requestFocus();
                        }
                        else
                        {
                            if(lblInfo.getText().equals("Correo Electrónico Invalido"))
                            {
                                lblEmail.setText("Verifique el Correo Electrónico");
                            }
                            else
                            {
                                B poper = new B();
                                poper.setSize(601, 240);
                                pnlPrincipal.removeAll();
                                pnlPrincipal.add(poper);
                                pnlPrincipal.revalidate();
                                pnlPrincipal.repaint();
                                barra.setVisible(false);
                            }
                        } 
                    }    
                } 
        }
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
        txtNombre = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUser = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbRol = new ComboBox.SComboBox();
        txtEmail = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        barra = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Guardar Médico");
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

        pnlPrincipal.add(jPanel12);
        jPanel12.setBounds(0, 0, 350, 69);

        txtNombre.setBorder(null);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setPlaceholder("Ej. Pedro Perez Flores");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtNombre);
        txtNombre.setBounds(60, 110, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel1);
        jLabel1.setBounds(60, 140, 230, 2);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nombre Completo del Usuario");
        pnlPrincipal.add(jLabel13);
        jLabel13.setBounds(40, 90, 220, 20);

        txtUser.setBorder(null);
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPlaceholder("Ej. Pedro");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtUser);
        txtUser.setBounds(60, 180, 230, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel3);
        jLabel3.setBounds(60, 210, 230, 2);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Usuario");
        pnlPrincipal.add(jLabel14);
        jLabel14.setBounds(40, 160, 180, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Rol Usuario");
        pnlPrincipal.add(jLabel15);
        jLabel15.setBounds(40, 300, 180, 20);

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "Administrador", "Recepción" }));
        cmbRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlPrincipal.add(cmbRol);
        cmbRol.setBounds(60, 330, 230, 30);

        txtEmail.setBorder(null);
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setPlaceholder("Ej. pedroperezflores@dominio.com");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtEmail);
        txtEmail.setBounds(60, 250, 230, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel4);
        jLabel4.setBounds(60, 280, 230, 2);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Correo Electrónico");
        pnlPrincipal.add(jLabel16);
        jLabel16.setBounds(40, 230, 210, 20);
        pnlPrincipal.add(txtID);
        txtID.setBounds(10, 70, 320, 20);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 102, 102));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblNombre);
        lblNombre.setBounds(10, 140, 322, 20);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblUsuario);
        lblUsuario.setBounds(10, 210, 322, 20);

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblEmail);
        lblEmail.setBounds(10, 280, 322, 20);
        pnlPrincipal.add(correo);
        correo.setBounds(10, 250, 320, 10);

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(102, 102, 102));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPrincipal.add(lblInfo);
        lblInfo.setBounds(10, 360, 330, 40);

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 39, 350, 410));

        barra.setBackground(new java.awt.Color(210, 210, 214));
        barra.setPreferredSize(new java.awt.Dimension(804, 30));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });
        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Agregar Usuario");
        barra.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 29));

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
        barra.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 30, 30));

        jcMousePanel1.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 9, 350, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
            Socket sock = new Socket();
            InetSocketAddress addr = new InetSocketAddress("www.google.com",80);
            try
            {
                sock.connect(addr,3000);
                conexion = true;
                Guardar();
            }
            catch(Exception e)
            {
                conexion = false;
                ConexionAlert poper = new ConexionAlert(null, true);
                poper.setVisible(true);
            }
            finally
            {
                try
                {
                    sock.close();
                }
                catch(Exception e)
                {

                }
            }
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

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

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
       int limite =15;
        if (txtUser.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        this.lblInfo.setText("");
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$");

        String email = txtEmail.getText();
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            this.lblInfo.setText("");
        } else {
            this.lblInfo.setText("Correo Electrónico Invalido");
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        this.lblInfo.setText("");
        lblNombre.setText("");
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        this.lblInfo.setText("");
        lblUsuario.setText("");
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
         lblEmail.setText("");
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
         correo.setText("");
        this.correo.setText(txtEmail.getText());
    }//GEN-LAST:event_txtEmailFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarUser dialog = new AgregarUser(new javax.swing.JFrame(), true);
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
    public static javax.swing.JPanel barra;
    public static ComboBox.SComboBox cmbRol;
    public static javax.swing.JLabel correo;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel12;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfo;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static app.bolivia.swing.JCTextField txtEmail;
    private javax.swing.JLabel txtID;
    public static app.bolivia.swing.JCTextField txtNombre;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
