package Ventanas.Modulo_Usuario;

import Alerts.ConexionAlert;
import Clases.Conexion;
import Clases.Medico;
import Ventanas.ModuloContrasena.AsistenciaContrasena;
import static Ventanas.Modulo_Usuario.AgregarUsuarioMedico.txtCorreoElectronico1;
import static Ventanas.Modulo_Usuario.AgregarUsuarioMedico.txtCorreoElectronico2;
import static Ventanas.Modulo_Usuario.AgregarUsuarioMedico.txtUser;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class C1 extends javax.swing.JPanel {

    ResultSet resultado;
    int ID_MaxU = 0;
    
    public C1() {
        initComponents();
        String Nombre_Usuario = AgregarUsuarioMedico.nombre.getText();
        String Usuario = txtUser.getText().trim();
        String Correo_Electronico1 = txtCorreoElectronico1.getText().trim();
        String Correo_Electronico2 = txtCorreoElectronico2.getText().trim();
        
                String Matricula = "";
                                Random rnd = new Random();

                                for (int i = 0; i < 7; i++)
                                {
                                    if(i < 4)
                                    {
                                        Matricula += rnd.nextInt(10);
                                    }
                                    else
                                    {
                                        Matricula += (char)(65);
                                    }
                                }

                                int codigo = 0;
                                    try {
                                        SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
                                        for (int i = 0; i < 1; i++) {
                                            codigo = number.nextInt(1000000);
                                        }
                                    } catch (NoSuchAlgorithmException nsae) {

                                    }

                                    Properties propiedad = new Properties();
                                    propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
                                    propiedad.setProperty("mail.smtp.starttls.enable", "true");
                                    propiedad.setProperty("mail.smtp.port", "587");
                                    propiedad.setProperty("mail.smtp.auth", "true");

                                    Session sesion = Session.getDefaultInstance(propiedad);
                                    String correoEnvia = "promedicsoporte@gmail.com";
                                    String contrasena = "Abecedario27a";
                                    String destinatario =  AgregarUsuarioMedico.txtCorreoElectronico1.getText().trim();;
                                    String asunto = "Soporte ProMedic, Acceso a cuentas";
                                    String mensaje = "<p><strong>Hola,</strong> <em>"+ AgregarUsuarioMedico.nombre.getText().trim() +"</em>.</p>"
                                                    +"<p>Hemos recibido una solicitud de registro para cuentas <span style='color: #008080;'>ProMedic</span>, promedicsoporte@gmail.com, a trav&eacute;s de tu direcci&oacute;n de correo electr&oacute;nico.</p>"
                                                    +"<p><br />Usuario: <strong>" + Usuario + "</strong> y t&uacute; contrase&ntilde;a provisional <span style='color: #008080;'>ProMedic</span> es: <strong>"+ Matricula+ "</strong>.&nbsp;<br />Deber&aacute;s cambiar t&uacute; contrase&ntilde;a de forma Manual, una vez una vez iniciado sesi&oacute;n, para mayor protecci&oacute;n.<br /><br />Si no has solicitado est&aacute; cuenta, puede que alguien est&eacute; intentando utilizar tu direcci&oacute;n de correo electr&oacute;nico.</p>"
                                                    +"<p>Has recibido este mensaje porque esta direcci&oacute;n de correo electr&oacute;nico figura como direcci&oacute;n de creaci&oacute;n de la cuenta <span style='color: #008080;'>ProMedic</span>, proporcionaste esta direcci&oacute;n al crear tu usuario.<br />Si crees que no deber&iacute;a figurar como tal, puedes eliminarla de dicha cuenta y proporcionar una nueva direcci&oacute;n.</p>"
                                                    +"<p><br /><span style='color: #008080;'><strong>Atentamente,</strong></span><br />El equipo de Cuentas <span style='color: #008080;'>ProMedic</span>.</p>";

                                    MimeMessage mail = new MimeMessage(sesion);
                                    try {
                                        mail.setFrom(new InternetAddress (correoEnvia));
                                        mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                                        mail.setSubject(asunto);
                                        mail.setContent(mensaje, "text/html"); 
                                        String cadena = Integer.toString(codigo);
                                        

                                        Transport transporte = sesion.getTransport("smtp");
                                        transporte.connect(correoEnvia,contrasena);
                                        transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                                        transporte.close();
                                        
                                            Clases.Usuario.Agregar_Usuario(Nombre_Usuario, Usuario, Matricula, Correo_Electronico1, "3");

                                            try
                                            {
                                               resultado = Conexion.consulta("Select ID_Usuario from Usuario where Usuario = '"+ Usuario +"'");
                                               while(resultado.next())
                                               {
                                                   ID_MaxU = resultado.getInt(1);
                                               } 
                                            }
                                            catch(SQLException ex)
                                            {
                                                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                                AC.msj1.setText("¡Error 3714!");
                                                AC.msj2.setText("¡Contacte a servicios ProMedic!");
                                                AC.setVisible(true); 
                                            }

                                            Medico.Usuario_Medico(Integer.parseInt(AgregarUsuarioMedico.ID_MaxMM.getText()), ID_MaxU, AgregarUsuarioMedico.txtUser.getText());  
                                            
                                            AgregarUsuarioMedico.barra.setVisible(true);

                                    } catch (AddressException ex) {
                                        ConexionAlert poper = new ConexionAlert(null, true);
                                        poper.setVisible(true);
                                        Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (MessagingException ex) {
                                        ConexionAlert poper = new ConexionAlert(null, true);
                                        poper.setVisible(true);
                                        Logger.getLogger(pnlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                    }
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B = new javax.swing.JPanel();
        info6 = new javax.swing.JLabel();
        info7 = new javax.swing.JLabel();
        info10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        B.setBackground(new java.awt.Color(255, 255, 255));
        B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info6.setForeground(new java.awt.Color(130, 180, 232));
        info6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/correoooo.gif"))); // NOI18N
        B.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 340, 210));

        info7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info7.setForeground(new java.awt.Color(130, 180, 232));
        info7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info7.setText("El correo ha sido enviado");
        B.add(info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 280, 20));

        info10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info10.setForeground(new java.awt.Color(130, 180, 232));
        info10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info10.setText("con éxito.");
        B.add(info10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 280, 20));
        B.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 20));
        B.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 240, 20));
        B.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 240, 20));

        add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 601, 240));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel B;
    public static javax.swing.JLabel info10;
    public static javax.swing.JLabel info6;
    public static javax.swing.JLabel info7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
