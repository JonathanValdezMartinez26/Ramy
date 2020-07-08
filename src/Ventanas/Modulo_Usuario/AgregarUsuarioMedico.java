/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Modulo_Usuario;

import Alerts.AWTUtilities;
import Alerts.AlertBasic.SuccessEmail;
import Alerts.ConexionAlert;
import Clases.Conexion;
import Clases.Medico;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class AgregarUsuarioMedico extends javax.swing.JDialog {

    int x,y;
    public AgregarUsuarioMedico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        this.ID_MaxMM.setVisible(false);
        barra.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        es = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        barra = new JButtonEspecial.JButtonEspecial();
        lblInfo = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        log = new JButtonEspecial.JButtonEspecial();
        txtUser = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        txtCorreoElectronico1 = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCorreoElectronico2 = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ID_MaxMM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ingresar datos usuario");
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        es.setBackground(new java.awt.Color(255, 255, 255));
        es.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        info.setText("Usuarios > Usuario Médico");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        barra.setText("X");
        barra.setToolTipText("Cerrar");
        barra.setColorHover(new java.awt.Color(102, 102, 102));
        barra.setColorNormal(new java.awt.Color(210, 210, 214));
        barra.setColorPressed(new java.awt.Color(136, 0, 0));
        barra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraActionPerformed(evt);
            }
        });
        jPanel7.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 0, 30, 30));

        es.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 603, -1));

        jcMousePanel1.add(es, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 603, 30));

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(102, 102, 102));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jcMousePanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 500, 20));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(null);

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Aceptar");
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
        log.setBounds(360, 200, 200, 25);

        txtUser.setBorder(null);
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPlaceholder("Ej. Enrique ");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtUser);
        txtUser.setBounds(320, 40, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel1);
        jLabel1.setBounds(320, 70, 230, 2);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("  Nombre completo del médico");
        pnlPrincipal.add(jLabel13);
        jLabel13.setBounds(30, 20, 200, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("  Usuario");
        pnlPrincipal.add(jLabel16);
        jLabel16.setBounds(300, 20, 180, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel7);
        jLabel7.setBounds(50, 70, 230, 2);

        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlPrincipal.add(nombre);
        nombre.setBounds(50, 40, 230, 30);

        txtCorreoElectronico1.setBorder(null);
        txtCorreoElectronico1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreoElectronico1.setPlaceholder("Ej. medico@dominio.com");
        txtCorreoElectronico1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoElectronico1KeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtCorreoElectronico1);
        txtCorreoElectronico1.setBounds(50, 130, 230, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel9);
        jLabel9.setBounds(50, 160, 230, 2);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("  Correo Electrónico");
        pnlPrincipal.add(jLabel18);
        jLabel18.setBounds(30, 110, 140, 20);

        txtCorreoElectronico2.setBorder(null);
        txtCorreoElectronico2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreoElectronico2.setPlaceholder("Ej. medico@dominio.com");
        txtCorreoElectronico2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoElectronico2KeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtCorreoElectronico2);
        txtCorreoElectronico2.setBounds(320, 130, 230, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel10);
        jLabel10.setBounds(320, 160, 230, 2);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("  Confirmar Correo Electrónico");
        pnlPrincipal.add(jLabel19);
        jLabel19.setBounds(300, 110, 210, 20);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel11);
        jLabel11.setBounds(320, 160, 230, 2);
        pnlPrincipal.add(ID_MaxMM);
        ID_MaxMM.setBounds(510, 10, 0, 0);

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 36, 601, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(627, 283));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String NombreUsuario, NombreCompleto;
    int ID_MaxM;

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
        this.txtUser.setText(NombreUsuario);
    }
    
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
        this.nombre.setText(NombreCompleto);
    }
    
    public void setID_MAX(int ID_MaxM) {
        this.ID_MaxM = ID_MaxM;
        this.ID_MaxMM.setText(""+ID_MaxM);
    }
    
    ResultSet resultado;
    int ID_MaxU = 0;
    boolean conexion = false;
   
    public void Falta()
    {
        this.lblInfo.setText("¡Todos los Campos son Requeridos!");
        this.txtUser.requestFocus();
    }
    
    public void Seleccionar()
    {
        String Nombre_Usuario = NombreCompleto;
        String Usuario = txtUser.getText().trim();
        String Contrasena_Usuario = "12345678";
        String Correo_Electronico1 = txtCorreoElectronico1.getText().trim();
        String Correo_Electronico2 = txtCorreoElectronico2.getText().trim();
        
        if(!"".equals(Usuario) && !"".equals(Correo_Electronico1) && !"".equals(Correo_Electronico2))
        {
             if (Ventanas.Modulo_Usuario.Opciones.verificaUsuario(this.txtUser.getText()).equals(this.txtUser.getText()) && !this.txtUser.getText().equals(Ventanas.Modulo_Navegacion.Principal_Admin.lblUserActivo.getText())) 
            {
                this.lblInfo.setText("El nombre de usuario no está disponible.");
                this.txtUser.requestFocus();
            }
            else
            {
                if(Correo_Electronico1.equals(Correo_Electronico2))
                {
                    if (Ventanas.Modulo_Usuario.Opciones.verificaUsuarioEmail(Correo_Electronico1) != 0) 
                    {
                        this.lblInfo.setText("El Correo Electrónico ya está registrado.");
                        this.txtCorreoElectronico1.requestFocus();
                    }
                    else
                    {
                        B1 poper = new B1();
                        poper.setSize(601, 240);
                        pnlPrincipal.removeAll();
                        pnlPrincipal.add(poper);
                        pnlPrincipal.revalidate();
                        pnlPrincipal.repaint();
                    }
                }
                else
                {
                    this.lblInfo.setText("¡Las cuentas de correo no coinciden, verifique!");
                }
            }
        }
        else
        {
            if ("".equals(Usuario))
            {
                this.lblInfo.setText("¡Nombre de Usuario Requerido!");
                this.txtUser.requestFocus();
            }
            else
            {
                if ("".equals(Correo_Electronico1))
                {
                    this.lblInfo.setText("¡Correo Electrónico Requerido!");
                    this.txtCorreoElectronico1.requestFocus();   
                }
                else
                {
                    if ("".equals(Correo_Electronico2))
                    {
                        this.lblInfo.setText("¡Confirmacion del Correo Electrónico Requerido!");
                        this.txtCorreoElectronico2.requestFocus();
                    }
                    else
                    {
                        Falta();
                    }
                }
            }
        }
        
    }
    
    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        int limite =15;
        if (txtUser.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        Socket sock = new Socket();
            InetSocketAddress addr = new InetSocketAddress("www.google.com",80);
            try
            {
                sock.connect(addr,3000);
                conexion = true;
                Seleccionar();
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
        
    }//GEN-LAST:event_logActionPerformed

    private void txtCorreoElectronico1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElectronico1KeyTyped
         this.lblInfo.setText("");
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$");
 
        String email = txtCorreoElectronico1.getText();
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            this.lblInfo.setText("");
        } else {
            this.lblInfo.setText("El Email Ingresado es Inválido");
        }
    }//GEN-LAST:event_txtCorreoElectronico1KeyTyped

    private void txtCorreoElectronico2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElectronico2KeyTyped
        this.lblInfo.setText("");
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$");

        String email = txtCorreoElectronico2.getText();
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            this.lblInfo.setText("");
        } else {
            this.lblInfo.setText("El Email Ingresado es Inválido");
        }
    }//GEN-LAST:event_txtCorreoElectronico2KeyTyped

    private void barraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraActionPerformed
        this.dispose();
    }//GEN-LAST:event_barraActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarUsuarioMedico dialog = new AgregarUsuarioMedico(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel ID_MaxMM;
    public static JButtonEspecial.JButtonEspecial barra;
    public static javax.swing.JPanel es;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblInfo;
    private JButtonEspecial.JButtonEspecial log;
    public static javax.swing.JLabel nombre;
    private javax.swing.JPanel pnlPrincipal;
    public static app.bolivia.swing.JCTextField txtCorreoElectronico1;
    public static app.bolivia.swing.JCTextField txtCorreoElectronico2;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
