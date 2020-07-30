/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.CotizacionReporte;


import Clases.Conexion;
import Clases.ConfigCotizaciones;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class ConfigCotizacion extends javax.swing.JDialog {

    public static boolean continuar = false;

    /**
     * Creates new form ErrorAlert
     */
    public ConfigCotizacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //CargarDatos();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);

    }
    ResultSet resultado;
     int IDD;
       private ConfigCotizacion VE;

    public void setVE(ConfigCotizacion  VE) {
        this.VE = VE;
    }
    
    public void CargarDatos(){
      
        String parte1="";
        String parte2="";
        String parte3="";
        String at="";
        String primerap="";
        String puesto="";
        String segundap="";
        String puesto2="";
        
       
        try{
            
            resultado = Conexion.consulta("Select * from pie Where ID_pie = 1");
            
            while(resultado.next()){
             IDD = resultado.getInt(1);
             parte1 = resultado.getString(2);
             parte2 = resultado.getString(3);
             parte3 = resultado.getString(4);
             at = resultado.getString(5);
             primerap = resultado.getString(6);
             puesto = resultado.getString(7);
             segundap = resultado.getString(8);
             puesto2 = resultado.getString(9);
             
            }
            
        }catch(SQLException ex){}
        
        txtparte1.setText(parte1);
        txtparte2.setText(parte2);
        txtparte3.setText(parte3);
        txtat.setText(at);
        txtprimerap.setText(primerap);
        txtpuesto.setText(puesto);
        txtsegundap.setText(segundap);
        txtpuesto2.setText(puesto2);

    }
    
        public void Guardar(){
        String parte1=txtparte1.getText().trim();
        String parte2=txtparte2.getText().trim();
        String parte3=txtparte3.getText().trim();
        String at=txtat.getText().trim();
        String primerap=txtprimerap.getText().trim();
        String puesto=txtpuesto.getText().trim();
        String segundap=txtsegundap.getText().trim();
        String puesto2=txtpuesto2.getText().trim();
        
        
        if("".equals(parte1) || "".equals(parte2) || "".equals(parte3)||"".equals(at)||"".equals(primerap)||"".equals(puesto)||"".equals(segundap)||"".equals(puesto2))
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Llene todos los campos!");
            AC.msj2.setText("Seleccione Correctamente");
            AC.setVisible(true);
        }
       
                else
                {
                    ConfigCotizaciones.Actualizar_Tipo(IDD, parte1,parte2,parte3,at,primerap,puesto,segundap,puesto2);
                    
                    this.dispose();
                
                  
                    
                   
                }
            
            
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtparte1 = new app.bolivia.swing.JCTextField();
        txtparte2 = new app.bolivia.swing.JCTextField();
        txtparte3 = new app.bolivia.swing.JCTextField();
        jPanel7 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        txtpuesto = new app.bolivia.swing.JCTextField();
        txtat = new app.bolivia.swing.JCTextField();
        txtprimerap = new app.bolivia.swing.JCTextField();
        txtsegundap = new app.bolivia.swing.JCTextField();
        txtpuesto2 = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlagregar = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("ART                                          | CANT | PRECIO | IMPORTE");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("==============================================");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Coca cola 600ml                               2       $11.00      $22.00");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Coca cola 600ml                               2       $11.00       $22.00");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Coca cola 600ml                               2       $11.00       $22.00");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("==============================================");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("TOTAL: $66.00");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("==============================================");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Captura1.PNG"))); // NOI18N

        txtparte1.setBorder(null);
        txtparte1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtparte1.setPlaceholder("               Ej. A ESTOS PRECIOS SE LES AUMENTARA EL IMPUESTO AL VA....");
        txtparte1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtparte1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtparte1KeyTyped(evt);
            }
        });

        txtparte2.setBorder(null);
        txtparte2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtparte2.setPlaceholder("           Ej. LAS CARGAS VIAJAN POR CUENTA Y RIESGO DEL REMITENT...");
        txtparte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtparte2ActionPerformed(evt);
            }
        });
        txtparte2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtparte2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtparte2KeyTyped(evt);
            }
        });

        txtparte3.setBorder(null);
        txtparte3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtparte3.setPlaceholder("           Ej. **PRECIOS LIBRES DE MANIOBRA DE CARGA Y DESCARGA");
        txtparte3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtparte3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtparte3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtparte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtparte2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtparte1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtparte1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtparte2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtparte3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcMousePanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 510, 500));

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
        info.setText("Cotizacion Directa");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 30));

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 13, 551, -1));

        txtpuesto.setBorder(null);
        txtpuesto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpuesto.setPlaceholder("Ej. GERENTE GENERAL");
        txtpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpuestoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpuestoKeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 170, 30));

        txtat.setBorder(null);
        txtat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtat.setPlaceholder("Ej. ATENTAMENTE");
        txtat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtatKeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 150, 30));

        txtprimerap.setBorder(null);
        txtprimerap.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtprimerap.setPlaceholder("Ej. ALFONSO RAMIREZ VALDEZ");
        txtprimerap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprimerapKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprimerapKeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtprimerap, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 190, 30));

        txtsegundap.setBorder(null);
        txtsegundap.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtsegundap.setPlaceholder("Ej. MARIO JESUS SALAZAR SALAZAR");
        txtsegundap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsegundapKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsegundapKeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtsegundap, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, 180, 30));

        txtpuesto2.setBorder(null);
        txtpuesto2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpuesto2.setPlaceholder("     Ej. DEPTO. DE FACTURACIÓN");
        txtpuesto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpuesto2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpuesto2KeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtpuesto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 160, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jcMousePanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 160, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jcMousePanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 600, 160, -1));

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Guardar Servicio");
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

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("    Guardar");
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar (2).png"))); // NOI18N
        pnlagregar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jcMousePanel1.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
       
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
      
    }//GEN-LAST:event_jPanel7MousePressed

    private void txtpuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuestoKeyReleased
        txtpuesto.setText(txtpuesto.getText().toUpperCase());
    }//GEN-LAST:event_txtpuestoKeyReleased

    private void txtpuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuestoKeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }

        int limite =45;
        if (txtpuesto.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtpuestoKeyTyped

    private void txtparte1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte1KeyReleased

    private void txtparte1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte1KeyTyped

    private void txtparte2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte2KeyReleased

    private void txtparte2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte2KeyTyped

    private void txtparte3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte3KeyReleased

    private void txtparte3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparte3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte3KeyTyped

    private void txtatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtatKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtatKeyReleased

    private void txtatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtatKeyTyped

    private void txtprimerapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprimerapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprimerapKeyReleased

    private void txtprimerapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprimerapKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprimerapKeyTyped

    private void txtsegundapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsegundapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsegundapKeyReleased

    private void txtsegundapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsegundapKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsegundapKeyTyped

    private void txtpuesto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuesto2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpuesto2KeyReleased

    private void txtpuesto2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuesto2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpuesto2KeyTyped

    private void txtparte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtparte2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparte2ActionPerformed

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        Guardar();
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

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
            java.util.logging.Logger.getLogger(ConfigCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigCotizacion dialog = new ConfigCotizacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JPanel pnlagregar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static app.bolivia.swing.JCTextField txtat;
    public static app.bolivia.swing.JCTextField txtparte1;
    public static app.bolivia.swing.JCTextField txtparte2;
    public static app.bolivia.swing.JCTextField txtparte3;
    public static app.bolivia.swing.JCTextField txtprimerap;
    public static app.bolivia.swing.JCTextField txtpuesto;
    public static app.bolivia.swing.JCTextField txtpuesto2;
    public static app.bolivia.swing.JCTextField txtsegundap;
    // End of variables declaration//GEN-END:variables
}
