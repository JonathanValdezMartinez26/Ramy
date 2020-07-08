/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Modulo_Diagnostico;

import Clases.Cita;
import Clases.Conexion;
import Clases.Consulta;
import Ventanas.Modulo_Consulta.AgregarConsultas;
import Ventanas.Modulo_Consulta.Opciones;
import Ventanas.Modulo_Consulta.Principal_Medico;
import static Ventanas.Modulo_Consulta.pnlConsultaMedico.fechas;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class AgregarDiagnostico extends javax.swing.JDialog {

    public AgregarDiagnostico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        
        Date sistemaFech = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
        lblID.setText(formato.format(sistemaFech));
        lblID.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        msj2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDr = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtPeso = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTalla = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTemperatura = new app.bolivia.swing.JCTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsulta = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtReceta = new javax.swing.JTextArea();
        log = new JButtonEspecial.JButtonEspecial();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(679, 695));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(225, 225, 225));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msj2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        msj2.setForeground(new java.awt.Color(153, 153, 153));
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("Receta");
        jPanel3.add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 78, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 679, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NIÑO.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 110));

        txtPaciente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPaciente.setForeground(new java.awt.Color(102, 102, 102));
        txtPaciente.setText("Jonathan Valdez Martinez");
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Paciente.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 147, -1, 30));

        txtDr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDr.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtDr, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 280, 29));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Médico:  ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, 29));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 633, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Bebés, Niñas y Niños");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("            CONSULTORIO MÉDICO DR. ENRIQUE ARTEAGA JAIMES");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 460, 10));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Peso.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, -1, 20));

        txtPeso.setBorder(null);
        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPeso.setPlaceholder("10.00 Kg");
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 90, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Talla.");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 193, -1, 20));

        txtTalla.setBorder(null);
        txtTalla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTalla.setPlaceholder("95 cm");
        txtTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTallaKeyTyped(evt);
            }
        });
        jPanel1.add(txtTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 80, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Edad.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 147, -1, 30));

        fecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha1.setForeground(new java.awt.Color(102, 102, 102));
        fecha1.setText("DIA - MES - AÑO");
        jPanel1.add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 230, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Tempuratura.");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 193, -1, 20));

        txtTemperatura.setBorder(null);
        txtTemperatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTemperatura.setPlaceholder("37º C");
        txtTemperatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTemperaturaKeyTyped(evt);
            }
        });
        jPanel1.add(txtTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 90, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 460, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel14.setText("   Consulta");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 110, 30));

        txtConsulta.setColumns(20);
        txtConsulta.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txtConsulta.setLineWrap(true);
        txtConsulta.setRows(5);
        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsultaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtConsulta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 600, 100));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel15.setText("Diagnostico");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 105, 20));

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setRows(5);
        txtDiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiagnosticoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDiagnostico);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 145, 600, 100));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel16.setText("Receta");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 105, 20));

        txtReceta.setColumns(20);
        txtReceta.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txtReceta.setLineWrap(true);
        txtReceta.setRows(5);
        txtReceta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecetaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtReceta);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 265, 600, 100));

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Terminar consulta");
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
        jPanel2.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 220, 640, 410));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NIÑA.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 130, 120));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 230, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 90, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 230, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 210, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 80, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 90, -1));

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(102, 102, 102));
        lblID.setText("1");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 50, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Fecha:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 60, 30));

        fecha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha2.setForeground(new java.awt.Color(102, 102, 102));
        fecha2.setText("DIA - MES - AÑO");
        jPanel1.add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 679, 640));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, 0));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 145, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 85, 0));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 85, 0));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, 0));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 85, 0));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String Paciente;
    private String Medico;
    private int ID_Consulta = 0;
    private AgregarConsultas AC;

    public void setAC(AgregarConsultas AC) {
        this.AC = AC;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

    public void setID_Consulta(int ID_Consulta) {
        this.ID_Consulta = ID_Consulta;
        lblID.setText(""+ID_Consulta);
    }

    public void MostrarDrPaciente() {
        txtDr.setText(Medico);
        txtPaciente.setText(Paciente);
    }

    public void Guardar() {
        String Peso = txtPeso.getText().trim();
        String Talla = txtTalla.getText().trim();
        String Temperatura = txtTemperatura.getText().trim();
        String ConsultaF = txtConsulta.getText().trim();
        String Diagnostico = txtDiagnostico.getText().trim();
        String Receta = txtReceta.getText().trim();

        if("".equals(Peso) && "".equals(Talla) && "".equals(Temperatura) && "".equals(ConsultaF) && "".equals(Diagnostico) && "".equals(Receta)) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Complete todos los campos!");
            AC.msj2.setText("Llene correctamente");
            AC.msj3.setText("Para continuar");
            AC.setVisible(true);
        }
        else
        {
            Consulta.Agregar_Consulta(ID_Consulta,Peso, Talla, Temperatura, ConsultaF, Diagnostico, Receta);
            Consulta.Consulta_Atendida(ID_Consulta);
            Cita.Actualizar_CitaAtendida(ID_Consulta);
            
            
            this.dispose();
            java.util.Date fecha = new Date();
            Opciones.listarConsultasOrdinariaspnlMedico("", fecha, Integer.parseInt(Principal_Medico.lblIDMedico.getText()));
            
            
            Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            String archivo = "Reportes/Receta.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
            parametro.put("ID_C", Integer.parseInt(lblID.getText()));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());

            JRViewer jrv = new JRViewer(jasperPrint);
            jrv.setZoomRatio((float) 0.5);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
        } catch (JRException ex) {
            System.err.println("Error iReport: " + ex.getMessage());
        }
    
            
        }

        

    }

    private void txtConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyTyped
    if(evt.getKeyChar() == KeyEvent.VK_TAB){
      txtDiagnostico.requestFocus();
    }
    int limite =200;
        if (txtConsulta.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtConsultaKeyTyped

    private void txtDiagnosticoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiagnosticoKeyTyped
    if(evt.getKeyChar() == KeyEvent.VK_TAB){
     txtReceta.requestFocus();
    }     
        int limite =500;
        if (txtDiagnostico.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtDiagnosticoKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        int limite =10;
        if (txtPeso.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtTallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTallaKeyTyped
        int limite =10;
        if (txtTalla.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtTallaKeyTyped

    private void txtTemperaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperaturaKeyTyped
        int limite =10;
        if (txtTemperatura.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtTemperaturaKeyTyped

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        Guardar();
    }//GEN-LAST:event_logActionPerformed

    private void txtRecetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecetaKeyTyped
        int limite =700;
        if (txtReceta.getText().length()== limite)
        {   
            evt.consume();
        }
    }//GEN-LAST:event_txtRecetaKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarDiagnostico dialog = new AgregarDiagnostico(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel fecha1;
    private javax.swing.JLabel fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblID;
    private JButtonEspecial.JButtonEspecial log;
    public static javax.swing.JLabel msj2;
    private javax.swing.JTextArea txtConsulta;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JLabel txtDr;
    private javax.swing.JLabel txtPaciente;
    public static app.bolivia.swing.JCTextField txtPeso;
    private javax.swing.JTextArea txtReceta;
    public static app.bolivia.swing.JCTextField txtTalla;
    public static app.bolivia.swing.JCTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables


}
