package Ventanas.Modulo_Cliente;

import Alerts.*;
import Alerts.AWTUtilities;
import Clases.Clientes;
import static Clases.Clientes.ObtenID;
import Clases.Conexion;
import Clases.Tipo_Transporte;
import Clases.Transporte;
import Clases.estados;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import Clases.localidades;
import Clases.municipios;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModificarCliente extends javax.swing.JDialog {

     int x, y;
     int ColoniaItem = 0;
     ResultSet resultado;
     int ID_Col [], ID_Est [], ID_Mun [];
     int IDD;
     private pnlClientes VM;
     
    public ModificarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        setLocationRelativeTo(null);
        this.txtNombre.requestFocus();
        
        estados cc = new estados();
        DefaultComboBoxModel modelEstado = new DefaultComboBoxModel(cc.mostrarEstados());
        cmbEstado.setModel(modelEstado);
    }

    public void Guardar(){
        String Nombre = txtNombre.getText().trim();
        String Atencion = txtAtencion.getText().trim();
        String Calle = txtCalle.getText().trim();
        
        int comboEstado = cmbEstado.getSelectedIndex();
        int comboMunicipio = cmbMunicipio.getSelectedIndex();
        int comboColonia = cmbColonia.getSelectedIndex();
        
            if("".equals(Nombre))
                {
                    Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Llene correctamente!");
                    AC.msj2.setText("El campo Nombre");
                    AC.setVisible(true);
                }
            else
            {
               if(txtNombre.getText().trim().length() <3)
                {
                    Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Datos Incorrectos!");
                    AC.msj2.setText("El campo Empresa/Cliente debe");
                    AC.msj3.setText("contener más de 3 caracteres");
                    AC.setVisible(true);
                }
               else
               {
                    if("".equals(Atencion))
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Llene correctamente!");
                        AC.msj2.setText("El campo Atención a");
                        AC.setVisible(true);
                    }
                   else
                   {
                        if(txtAtencion.getText().trim().length() <3)
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Datos Incorrectos!");
                            AC.msj2.setText("El campo Atención a debe");
                            AC.msj3.setText("contener más de 3 caracteres");
                            AC.setVisible(true);
                        }
                        else
                        {
                            if(comboEstado==0)
                            {
                               Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                               AC.msj1.setText("¡Elija un");
                               AC.msj2.setText("Estado válido");
                               AC.setVisible(true);
                            }
                            else
                            {
                                if(comboMunicipio==0)
                                {
                                   Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                   AC.msj1.setText("¡Elija un !");
                                   AC.msj2.setText("Municipio válido");
                                   AC.setVisible(true);
                                }
                                else
                                {
                                    if(comboColonia==0)
                                    {
                                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                        AC.msj1.setText("¡Elija!");
                                        AC.msj2.setText("Una Colonia válida");
                                        AC.setVisible(true);
                                    }
                                    else
                                    {
                                            if("".equals(Calle))
                                            {
                                                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                                AC.msj1.setText("¡Llene correctamente!");
                                                AC.msj2.setText("El campo Calle");
                                                AC.setVisible(true);
                                            }
                                            else
                                            {
                                                if("".equals(Nombre)|| "".equals(Atencion) || comboEstado==0 || comboMunicipio==0 || comboColonia==0 || "".equals(Calle))
                                                {
                                                    Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                                    AC.msj1.setText("¡Llene todos los campos!");
                                                    AC.msj2.setText("Seleccione Correctamente");
                                                    AC.setVisible(true);
                                                }
                                                else
                                                {
                                                    Clientes.Agregar_Cliente(Nombre,Atencion, ColoniaItem, Calle);
                                                    Ventanas.Modulo_Cliente.Opciones.listar("");
                                                    this.dispose();
                                                    
                                                    Alerts.AlertBasic.AgregarDestinos AC = new  Alerts.AlertBasic.AgregarDestinos(null, true);
                                                    AC.NombreEmpresa.setText(Nombre);
                                                    AC.ID.setText(""+ObtenID());
                                                    AC.setVisible(true);
                                                 }
                                            }
                                    }
                                }
                            }
                        }
                   }
               }
            }    
    }

     public void setVM(pnlClientes VM) {
        this.VM = VM;
    }
     
      public void CargarDatos(int ID,String atencion,String Localidad, String Municipio, String Estado){
        
        CargarEstado();
        CargarMunicipio(Municipio);
        CargarLocalidad(Localidad);
         
        String Nombre_cliente="";
        String Atencion="",Calle="";
        
        try{
            
            resultado = Conexion.consulta("Select * from clientes Where ID_cliente = "+ID);
            
            while(resultado.next()){
             IDD = resultado.getInt(1);
             Nombre_cliente = resultado.getString(2);
             Atencion = resultado.getString(3);
             Calle = resultado.getString(5);
             
            }
            
        }
        catch(SQLException ex){}
        
        txtNombre.setText(Nombre_cliente);
        txtAtencion.setText(atencion);
        
        cmbMunicipio.setSelectedItem(Municipio);
        cmbEstado.setSelectedItem(Estado);
        txtCalle.setText(Calle);
        cmbColonia.setSelectedItem(Localidad);
        cmbEstado.getSelectedIndex();
        //cmbColonia1.setSelectedItem(4);
        //cmbColonia1.set("sasass");
    }

     public void CargarLocalidad(String Nombre){
            
     int ID_Localidad = 0;
     int ID_Mun =0;
    ///////////////////////
     try{
         
     resultado = Conexion.consulta("Select id_municipio from t_localidad where localidad='"+ Nombre +"'");
         
     while(resultado.next()){
         ID_Mun = resultado.getInt(1);
     }
     }catch(SQLException ex){
         
     }
     ////////////////////
      try{
         
     resultado = Conexion.consulta("Select Max(id_localidad) from t_localidad");
         
     while(resultado.next()){
         ID_Localidad = resultado.getInt(1);
     }
     }catch(SQLException ex){
         
     }
        
      ID_Localidad++;
   
      ID_Col = new int[ID_Localidad];


       
      ID_Col [0] = 0; 
      
      int i = 1;
      
    try{
         
     resultado = Conexion.consulta("Select id_localidad, localidad from t_localidad where id_municipio=" + ID_Mun);
         
     while(resultado.next()){
         ID_Col [i] = resultado.getInt(1);
         cmbColonia.addItem(resultado.getString(2).trim());
         i++;
     }
     }catch(SQLException ex){
         
     }
}
    
    public void CargarMunicipio(String Municipio){
    int ID_Est = 0;        
    int ID_Municipio = 0;
    ///////////////////////
     try{
         
     resultado = Conexion.consulta("Select id_estado from t_municipio where municipio='"+ Municipio +"'");
         
     while(resultado.next()){
        ID_Est = resultado.getInt(1);
     }
     }catch(SQLException ex){
         
     }
     ////////////////////
    try{
         
    resultado = Conexion.consulta("Select Max(id_municipio) from t_municipio");
         
        while(resultado.next()){
             ID_Municipio = resultado.getInt(1);
        }
    }catch(SQLException ex){}
        
    ID_Municipio++;
   
    ID_Mun = new int[ID_Municipio];

    ID_Mun [0] = 0; 
      
    int i = 1;
      
    try{
        resultado = Conexion.consulta("Select id_municipio, municipio from t_municipio where id_estado =" + ID_Est);

        while(resultado.next()){
            ID_Mun [i] = resultado.getInt(1);
            cmbMunicipio.addItem(resultado.getString(2).trim());
            i++;
        }
     }catch(SQLException ex){
         
     }
}
     
    public void CargarEstado(){
            
     int ID_Estado = 0;
     
      try{
         
     resultado = Conexion.consulta("Select Max(id_estado) from t_estado");
         
     while(resultado.next()){
         ID_Estado = resultado.getInt(1);
     }
     }catch(SQLException ex){
         
     }
        
      ID_Estado++;
   
      ID_Est = new int[ID_Estado];


       
      ID_Est [0] = 0; 
      
      int i = 1;
      
      try{
         
     resultado = Conexion.consulta("Select id_estado, estado from t_estado");
         
     while(resultado.next()){
         ID_Est [i] = resultado.getInt(1);
         cmbEstado.addItem(resultado.getString(2).trim());
         i++;
     }
     }catch(SQLException ex){
         
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
        jPanel7 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        jLabel19 = new javax.swing.JLabel();
        lblNombreNuevo4 = new javax.swing.JLabel();
        txtNombre = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblNombreNuevo7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAtencion = new app.bolivia.swing.JCTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        lblNombreNuevo5 = new javax.swing.JLabel();
        cmbEstado = new ComboBox.SComboBox();
        lblNombreNuevo20 = new javax.swing.JLabel();
        cmbColonia = new ComboBox.SComboBox();
        lblNombreNuevo8 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblNombreNuevo21 = new javax.swing.JLabel();
        txtCalle = new app.bolivia.swing.JCTextField();
        cmbMunicipio = new ComboBox.SComboBox();

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
        pnlagregar.setToolTipText("Guardar Especialidad");
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

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 69));

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
        info.setText("Modificar Cliente");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 30, 30));

        pnlPrincipal.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 210, -1));

        lblNombreNuevo4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo4.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo4.setText("Nombre del la Empresa/Negocio ó Cliente*");
        pnlPrincipal.add(lblNombreNuevo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, -1));

        txtNombre.setBorder(null);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setPlaceholder("Ej. QUIMICA Y FARMACIA,  S.A. DE C.V.");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 280, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 210, -1));

        lblNombreNuevo7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo7.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo7.setText("En Atención a (Nombre del representante)");
        pnlPrincipal.add(lblNombreNuevo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 300, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 210, -1));

        txtAtencion.setBorder(null);
        txtAtencion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAtencion.setPlaceholder("Ej. LIC. D. DELFINA CRUZ MARTÍNEZ");
        txtAtencion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAtencionKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 280, 30));
        pnlPrincipal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 650, 10));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 144, 183));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("DATOS DOMICILIO:");
        pnlPrincipal.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, -1));

        lblNombreNuevo5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo5.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo5.setText("Estado*");
        pnlPrincipal.add(lblNombreNuevo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Estado" }));
        cmbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        pnlPrincipal.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 230, -1));

        lblNombreNuevo20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo20.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo20.setText("Municipio*");
        pnlPrincipal.add(lblNombreNuevo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        cmbColonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona Localidad" }));
        cmbColonia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbColonia.setMinimumSize(new java.awt.Dimension(134, 23));
        cmbColonia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbColoniaItemStateChanged(evt);
            }
        });
        pnlPrincipal.add(cmbColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 230, -1));

        lblNombreNuevo8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo8.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo8.setText("Colonia o Población*");
        pnlPrincipal.add(lblNombreNuevo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        pnlPrincipal.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 150, -1));

        lblNombreNuevo21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo21.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo21.setText("Calle y Número*");
        pnlPrincipal.add(lblNombreNuevo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        txtCalle.setBorder(null);
        txtCalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCalle.setPlaceholder("Ej. Ámbar Toribio Gutierrez");
        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 280, 30));

        cmbMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Municipio" }));
        cmbMunicipio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMunicipioItemStateChanged(evt);
            }
        });
        pnlPrincipal.add(cmbMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 230, -1));

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 9, 700, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }

        int limite =20;
        if (txtNombre.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAtencionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAtencionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtencionKeyTyped

    private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleKeyTyped

    private void cmbMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMunicipioItemStateChanged
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            municipios mun = (municipios) cmbMunicipio.getSelectedItem();
//            localidades loc = new localidades();
//            DefaultComboBoxModel modelLocalidad = new DefaultComboBoxModel(loc.mostrarLocalidad(mun.getId()));
//            cmbColonia.setModel(modelLocalidad);
//        }
    }//GEN-LAST:event_cmbMunicipioItemStateChanged

    private void cmbColoniaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbColoniaItemStateChanged
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            estados est = (estados) cmbEstado.getSelectedItem();
//            String mun = cmbMunicipio.getSelectedItem().toString();
//            
//            //localidades loc = (localidades) cmbColonia.getSelectedItem();
//
//            //ColoniaItem = loc.getId();
//        }
    }//GEN-LAST:event_cmbColoniaItemStateChanged

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            estados est = (estados) cmbEstado.getSelectedItem();
//            municipios mun = new municipios();
//            DefaultComboBoxModel modelMunicipio = new DefaultComboBoxModel(mun.mostrarMunicipio(est.getId()));
//            cmbMunicipio.setModel(modelMunicipio);
//            cmbColonia.removeAllItems();
//        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarCliente dialog = new ModificarCliente(new javax.swing.JFrame(), true);
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
    private ComboBox.SComboBox cmbColonia;
    private ComboBox.SComboBox cmbEstado;
    private ComboBox.SComboBox cmbMunicipio;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator3;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblNombreNuevo20;
    public static javax.swing.JLabel lblNombreNuevo21;
    public static javax.swing.JLabel lblNombreNuevo4;
    public static javax.swing.JLabel lblNombreNuevo5;
    public static javax.swing.JLabel lblNombreNuevo7;
    public static javax.swing.JLabel lblNombreNuevo8;
    public static javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static app.bolivia.swing.JCTextField txtAtencion;
    public static app.bolivia.swing.JCTextField txtCalle;
    public static app.bolivia.swing.JCTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
