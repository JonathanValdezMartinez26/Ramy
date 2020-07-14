package Ventanas.Modulo_Ruta_Cotizacion;

import Ventanas.Modulo_Tipo_Servicio.*;
import A_tabla.EstiloTablaHeader;
import A_tabla.EstiloTablaRenderer;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import Clases.Conexion;
import Ventanas.Modulo_Cliente.ModificarCliente;
import static Ventanas.Modulo_Cliente.pnlClientes.tabla;
import static Ventanas.Modulo_Ruta_Cotizacion.Opciones.cn;
import Ventanas.Modulo_Servicios.ModificarServicio;
import static Ventanas.Modulo_Tipo_Servicio.ModificarTipoServicio.txtNombre;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class pnlRutasGuardadas extends javax.swing.JDialog {

   
    int i = 32;
    int x,y;
    
    public pnlRutasGuardadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Opciones.listarDetallesCotizaciones(""+,"");
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
    }
  ResultSet resultado;
    public pnlRutasGuardadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void listarDetalles(int ID,String Clientes){
        
       Opciones.listarDetallesCotizaciones(null, ID,Clientes);
        info.setText(Clientes);

    }
     public void Modificar()
    {
        int Fila = tabla.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            ModificarTipoServicio ME = new ModificarTipoServicio(null, true);
            ME.CargarDatos(ID);
//            ME.setVE(this);
            ME.setVisible(true);
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("A modificar");
            AC.setVisible(true);
        }
        
        
    }
     
      public void ModificarCotizacion(int IDCliente,String cliente)
    {
        
        pnlRutasGuardadas.lblID.setText(""+IDCliente);
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.pnlRutasGuardadas.tabla.getModel();
        int contador = 0;
        String sql="";
//        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblPaciente.setText(nombre);
//        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblGenero.setText(atencion);
//        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblDireccion.setText(direccion);
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        //String sql = "Select ID_Cotizacion, Fecha_Alta, Estatus from cotizacionesv where ID_Cliente =" + ID;
        //String sql = "Select ID_Cotizacion, Fecha_Alta, Estatus from cotizaciones where ID_Cliente="+ID;
        sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from cotizaciones_ruta where ID_Cliente =" + IDCliente;
            String datos[] = new String[6];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Ventanas.Modulo_Cliente.Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        JOptionPane.showMessageDialog(null, "Desde llenar detalles");
        
    }
      public void obtenerIDCotizacionRuta(String dato){
          
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        info = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlFinalizar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 0, 30, 30));

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("a");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 712, -1));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Agregar Servicio");
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
        jLabel22.setText("    Asignar");
        pnlagregar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo.png"))); // NOI18N
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        pnlFinalizar.setBackground(new java.awt.Color(225, 225, 225));
        pnlFinalizar.setToolTipText("Editar Paciente");
        pnlFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlFinalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlFinalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlFinalizarMouseExited(evt);
            }
        });
        pnlFinalizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("    Finalizar");
        pnlFinalizar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/comprobado.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        pnlFinalizar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 70));

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 712, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(0, 144, 183));
        buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 145, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 10, 210, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 690, 5));
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 150, 20));

        pnlPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 713, 85));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Origen", "Destino", "Unidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 690, 120));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Origen", "Destino", "Unidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(0);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla1.getColumnModel().getColumn(1).setResizable(false);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla1.getColumnModel().getColumn(2).setResizable(false);
            tabla1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 690, 150));

        pnlPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 690, 290));

        jcMousePanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 40, 712, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
         this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
//        Opciones.listar(this.buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked

        int Fila = tabla.getSelectedRow();
        String IDCliente=lblID.getText();
        int Filita = 1; 
  
        if (Fila >= 0) {

            String dato=String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0));//ID de la fila que se selecciona
           
           
            //Generar una tabla nueva que se llame asigna_cotizacion_ruta
            //vas a insertar el id dato que es el id de la cotizacion_ruta
            //en la tabla asigna_cotizacion_ruta
            //Cotizaciones.InsertarAsignaCotizaciones(ID);
            Opciones.listarCotizacionRuta("",IDCliente);
            
            
         

        } else {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione un registro!");
            AC.msj2.setText("A Agregar");
            AC.setVisible(true);
        }
        

    }//GEN-LAST:event_pnlagregarMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void pnlFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseClicked
        //ver();
        this.dispose();

    }//GEN-LAST:event_pnlFinalizarMouseClicked

    private void pnlFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseEntered
        pnlFinalizar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlFinalizarMouseEntered

    private void pnlFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseExited
        pnlFinalizar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlFinalizarMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pnlRutasGuardadas dialog = new pnlRutasGuardadas(new javax.swing.JFrame(), true);
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
    
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JLabel lblID;
    private javax.swing.JPanel pnlFinalizar;
    public static javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables

    
}
