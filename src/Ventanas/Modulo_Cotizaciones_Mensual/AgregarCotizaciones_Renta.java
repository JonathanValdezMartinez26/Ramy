package Ventanas.Modulo_Cotizaciones_Mensual;

import A_tabla.EstiloTablaHeader;
import Ventanas.Modulo_Cliente.*;
import A_tabla.EstiloTablaHeader1;
import A_tabla.EstiloTablaRenderer;
import A_tabla.EstiloTablaRenderer1;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import static Alerts.AlertBasic.AgregarDestinos.ID;
import Alerts.AlertBasic.Eliminar;
import Alerts.AlertBasic.EliminarTran;
import Alerts.FadeEffect;
import Clases.Clientes;
import Clases.Conexion;
import Clases.Cotizaciones;
import static Clases.Cotizaciones.ObtenID;
import Clases.CotizacionesRentaMen;
import Clases.MyTableCellEditor;
import Clases.MyTableCellEditorCotiRentaPrecio;
import Clases.MyTableCellEditor3;
import Clases.MyTableCellEditor4;
import Clases.MyTableCellEditorServMensNombre;
import Clases.MyTableCellEditorServMensPrecio;
import Clases.database;
import Clases.estados;
import Clases.localidades;
import Clases.municipios;
import Ventanas.CotizacionReporte.ConfigCotizacion;
import Ventanas.CotizacionReporte.ConfigCotizacionRenta;
import Ventanas.Modulo_Cotizaciones.AgregarCotizaciones;
import static Ventanas.Modulo_Cotizaciones.AgregarCotizaciones.IDCotizacion;
import static Ventanas.Modulo_Cotizaciones.AgregarCotizaciones.tabla1;
import static Ventanas.Modulo_Cotizaciones.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones_Mensual.Opciones.*;
import static configInicio.Configuracion.txtEmail;
import static configInicio.Configuracion.txtNombre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rojerusan.RSPanelsSlider;
import java.awt.Color;
import java.awt.Font; 
import java.awt.event.ItemEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import Ventanas.Modulo_Cotizaciones_Mensual.Opciones;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarCotizaciones_Renta extends javax.swing.JDialog {

    private boolean minimiza = false;

    int x, y;
    boolean res = true;
    int  MunicipioItem = 0;
    int ID;
    ResultSet resultado, nombre;
    int ID_Per [];
    int ID_Cli[];
    String ID_Con[];
    
    private database db = new database();
    
    public AgregarCotizaciones_Renta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        Clientes();       
        Periodo();        
        ID_rutas.setVisible(false);
        IDCotizacion.setVisible(false);
        
         
        tablaR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaR.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablaR.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablaR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        tabla1.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditorServMensNombre(db,"Nombre del Servicio"));//Columna Precio
        tabla1.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditorServMensPrecio(db,"Precio"));//Columna Precio
        tablaR.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditorCotiRentaPrecio(db,"Precio"));//Columna Precio
    }
    
    public void Clientes()
    {
        int ID_Cliente = 0;
        try 
        {
            resultado = Conexion.consulta("Select Max(ID_Cliente) from clientes");
            while (resultado.next()) 
            {
                ID_Cliente = resultado.getInt(1);
            }
        } 
        catch (SQLException ex) 
        {

        }

        ID_Cliente++;
        ID_Cli = new int[ID_Cliente];
        ID_Cli[0] = 0;
        int i = 1;
        try 
        {
            resultado = Conexion.consulta("SELECT ID_cliente, Nombre_cliente from clientes");
            while (resultado.next()) 
            {
                ID_Cli[i] = resultado.getInt(1);
                cmbCliente.addItem(resultado.getString(2));
                i++;
            }
        } 
        catch (SQLException ex) 
        {

        }
    }
    
  
    public void Periodo()
    {
        int ID_Periodo = 0;

        try 
        {
            resultado = Conexion.consulta("Select Max(ID_Periodo) from Periodo");
            while (resultado.next()) 
            {
                ID_Periodo = resultado.getInt(1);
            }
        } 
        catch (SQLException ex) 
        {

        }
        ID_Periodo++;
        ID_Per= new int[ID_Periodo];
        ID_Per[0] = 0;
        int i = 1;
        try 
        {
            resultado = Conexion.consulta("SELECT ID_Periodo, Periodo from Periodo");
            while (resultado.next()) 
            {
                ID_Per [i] = resultado.getInt(1);
                cmbPeriodo.addItem(resultado.getString(2));
                i++;
            }
        } 
        catch (SQLException ex) 
        {

        }
    }
    public void eliminar()
    {
        int Fila = tablaR.getSelectedRow();
            if(Fila >= 0)
        {
          int ID = Integer.parseInt(tablaR.getValueAt(Fila, 0).toString());
//            int ID = Integer.parseInt(IDCotizacion.getText());

            EliminarTran ME = new EliminarTran(null, true);
            ME.ID.setText(""+ID);
//            ME.Cotizacion.setText(""+ID_Cotizacion);
            ME.setVisible(true);
            Opciones.listar("",ID);
//           JOptionPane.showMessageDialog(null,""+ID);
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("A eliminar");
            AC.setVisible(true);
        }
           
    }
    ////////////////////////////////////////////////////////////////////////////
    public void Guardar(){        
//        Date Fecha_I = txtFechaI.getDate();
//        Date Fecha_F = txtFechaF.getDate();
        
        
        if (IDCotizacion.getText().equals("")) {
//if (comboCliente==0) {
            Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Elija un");
            AC.msj2.setText("Cliente para Continuar");
            AC.setVisible(true);
        } else {
            int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
            String Concepto = txtTipo_Concepto.getText();
            int ID_Periodos = cmbPeriodo.getSelectedIndex();
            int ID_Periodo = ID_Per[ID_Periodos];

            int comboCliente = cmbCliente.getSelectedIndex();
            
            if (txtTipo_Concepto.getText().equals("") || ID_Periodos == 0) {
                Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Llene todos los campos!");
                AC.msj2.setText("Para Agregar Renta");
                AC.setVisible(true);
            } else {
                if (Ventanas.Modulo_Cotizaciones_Mensual.Opciones.verificaRentaM(ID_Cotizacion, Concepto, ID_Periodo) == 0) {                    
                    
                    Clases.CotizacionesRentaMen fichaIdent = new Clases.CotizacionesRentaMen();
                    
                    fichaIdent.setID_Cotizacion(ID_Cotizacion);
                    fichaIdent.setConcepto(Concepto);
                    fichaIdent.setID_Periodo(ID_Periodo);
                    
                    if (Ventanas.Modulo_Cotizaciones_Mensual.Opciones.registrarCotiRenta(ID_Cotizacion, Concepto, ID_Periodo)) {
                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Datos de la cotizacion!");
                        AC.msj2.setText("Guardados correctamente");
                        AC.setVisible(true);
                        Opciones.listar("", ID_Cotizacion);
                        
                        txtTipo_Concepto.setText("");
                        cmbPeriodo.setSelectedIndex(0);
                        
                    } else {
                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Error verifique!");
                        AC.msj2.setText("los datos ingresados  ");
                        AC.setVisible(true);
                    }
                    
                } else {
                    Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Error el Periodo!");
                    AC.msj2.setText("ya existe ");
                    AC.setVisible(true);
                }
                
            }
        }
         }
    
    public static void cargarServicio(){
        int ID_Cotizacion;
        ID_Cotizacion=Integer.parseInt(AgregarCotizaciones_Renta.IDCotizacion.getText());
        Ventanas.Modulo_Cotizaciones_Mensual.Opciones.insertarServicio(ID_Cotizacion);
        //Opciones.llenarServicio(ID_Cotizacion);
        
    }
    public static void finalizar(){
        
        Alerts.AlertBasic.WarningFinalizarMensual AC = new  Alerts.AlertBasic.WarningFinalizarMensual(null, true);
        AC.ID.setText(IDCotizacion.getText());
        AC.setVisible(true);
      
    
    //AgregarCotizaciones.dispose();
    }
                        

    ////////////////////////////////////////////////////////////////////////
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        lblNombreNuevo17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane = new javax.swing.JScrollPane();
        tablaR = new javax.swing.JTable();
        cmbCliente = new ComboBox.SComboBox();
        lblNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlEliminar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlFinalizar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlVista = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnleditar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnleditar2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlAyuda = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        IDCotizacion = new javax.swing.JLabel();
        ID_rutas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblatencion1 = new javax.swing.JLabel();
        cmbPeriodo = new ComboBox.SComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtTipo_Concepto = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new JButtonEspecial.JButtonEspecial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 35, 30));

        lblNombreNuevo17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo17.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo17.setText("     Cotizaciones > Nueva Cotizacion para renta de unidades");
        jPanel7.add(lblNombreNuevo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 877, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 13, 915, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Servicio", "ID_Cotizacion", "Nombre del Adicional", "Precio", "Supr para Borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setRowHeight(30);
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(0);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla1.getColumnModel().getColumn(1).setMinWidth(0);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(1).setMaxWidth(0);
            tabla1.getColumnModel().getColumn(4).setMinWidth(150);
            tabla1.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla1.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        tablaR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_", "Concepto", "Periodo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaR.setAlignmentX(2.0F);
        tablaR.setAlignmentY(2.0F);
        tablaR.setRowHeight(25);
        tablaR.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tablaR);
        if (tablaR.getColumnModel().getColumnCount() > 0) {
            tablaR.getColumnModel().getColumn(0).setMinWidth(0);
            tablaR.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaR.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
        );

        jcMousePanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 880, 360));

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Cliente" }));
        cmbCliente.setToolTipText("");
        cmbCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        jcMousePanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 380, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcMousePanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Seleccione una empresa o cliente para inciar la cotización.");
        jcMousePanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 20));
        jcMousePanel1.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 860, 3));

        jPanel1.setBackground(new java.awt.Color(225, 225, 225));
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
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 210, -1));

        pnlEliminar.setBackground(new java.awt.Color(225, 225, 225));
        pnlEliminar.setToolTipText("Eliminar Registro");
        pnlEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEliminarMouseExited(evt);
            }
        });
        pnlEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("    Eliminar");
        pnlEliminar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        pnlEliminar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        pnlFinalizar.setBackground(new java.awt.Color(225, 225, 225));
        pnlFinalizar.setToolTipText("Finalizar Cotización");
        pnlFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        pnlFinalizar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnlFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 70));

        pnlVista.setBackground(new java.awt.Color(225, 225, 225));
        pnlVista.setToolTipText("Visualizar Cotización");
        pnlVista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlVistaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlVistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlVistaMouseExited(evt);
            }
        });
        pnlVista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText(" Vista Previa");
        pnlVista.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlVista.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnlVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 250, 70));

        pnleditar.setBackground(new java.awt.Color(225, 225, 225));
        pnleditar.setToolTipText("Agregar Adicional");
        pnleditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnleditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnleditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnleditarMouseExited(evt);
            }
        });
        pnleditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("  Adicionales");
        pnleditar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-servicios-40.png"))); // NOI18N
        pnleditar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 69));
        pnleditar.getAccessibleContext().setAccessibleDescription("Ag");

        pnleditar2.setBackground(new java.awt.Color(225, 225, 225));
        pnleditar2.setToolTipText("Agregar Adicionales");
        pnleditar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnleditar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnleditar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnleditar2MouseExited(evt);
            }
        });
        pnleditar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("  Adicionales");
        pnleditar2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-servicios-40.png"))); // NOI18N
        pnleditar2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnleditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 69));

        pnlAyuda.setBackground(new java.awt.Color(225, 225, 225));
        pnlAyuda.setToolTipText("Ayuda");
        pnlAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlAyudaMouseExited(evt);
            }
        });
        pnlAyuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("      Ayuda");
        pnlAyuda.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ayuda30.png"))); // NOI18N
        pnlAyuda.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 10, 30, 40));

        jPanel1.add(pnlAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 70));

        jcMousePanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 890, 70));
        jcMousePanel1.add(IDCotizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 20));
        jcMousePanel1.add(ID_rutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 140, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Seleccione un Concepto");
        jcMousePanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 190, 20));

        lblatencion1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblatencion1.setText("Atención a:");
        jcMousePanel1.add(lblatencion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, 30));

        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Periodo" }));
        cmbPeriodo.setToolTipText("");
        cmbPeriodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbPeriodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPeriodoItemStateChanged(evt);
            }
        });
        cmbPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbPeriodoKeyTyped(evt);
            }
        });
        jcMousePanel1.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 380, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Seleccione un Periodo ");
        jcMousePanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 190, 20));

        txtTipo_Concepto.setBorder(null);
        txtTipo_Concepto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipo_Concepto.setPlaceholder("Ej. Remolque");
        txtTipo_Concepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipo_ConceptoKeyTyped(evt);
            }
        });
        jcMousePanel1.add(txtTipo_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 370, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jcMousePanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/linea.PNG"))); // NOI18N
        jcMousePanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(128, 128, 131));
        jButton1.setText("Aceptar");
        jButton1.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton1.setColorHover(new java.awt.Color(204, 204, 204));
        jButton1.setColorNormal(new java.awt.Color(204, 204, 204));
        jButton1.setColorPressed(new java.awt.Color(153, 153, 153));
        jButton1.setColorTextHover(new java.awt.Color(128, 128, 131));
        jButton1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jcMousePanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            int ID_Client = cmbCliente.getSelectedIndex();
           int ID_Cliente = ID_Cli[ID_Client];
            int i = 1;
            
            cmbCliente.setEnabled(false);
            Cotizaciones.Agregar_Cotizacion(ID_Cliente,4);
           
            lblNombre.setText(Cotizaciones.ObtenerNombre(ID_Cliente));
            IDCotizacion.setText(""+ObtenID());
            Opciones.listarCotizaciones("");
            //IDCotizacion.setVisible(true);
            
         }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
     
//         IDCotizacion.setText(""+ObtenID());
         int ID = Integer.parseInt(IDCotizacion.getText());
         Opciones.listar(buscar.getText(), ID);
         

         
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void pnlEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseClicked
        eliminar();
        int ID = Integer.parseInt(IDCotizacion.getText());
        Opciones.listar("",ID);
        buscar.setText("");
    }//GEN-LAST:event_pnlEliminarMouseClicked

    private void pnlEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseEntered
        pnlEliminar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlEliminarMouseEntered

    private void pnlEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseExited
        pnlEliminar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlEliminarMouseExited

    private void pnlVistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseClicked
     ConfigCotizacionRenta VE=new ConfigCotizacionRenta(null, true);
     VE.CargarDatos();
     VE.setVisible(true);      
    }//GEN-LAST:event_pnlVistaMouseClicked

    private void pnlVistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseEntered
        pnlVista.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlVistaMouseEntered

    private void pnlVistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseExited
        pnlVista.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlVistaMouseExited

    private void pnlFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseClicked

int comboPeriodo=cmbPeriodo.getSelectedIndex();
       String ID_Coti=IDCotizacion.getText();
       String concepto=txtTipo_Concepto.getText();
        
////////////////////Verifica si no hay combos seleccionados
 if(this.tablaR.getRowCount()!=0){
       int existenombre2 = 0;
            int existeprecio2 = 0;
            for (int i = 0; i < tablaR.getRowCount(); i++) {                                                 
                 if(tablaR.getValueAt(i, 3).toString().equals("0")){
                     existeprecio2++;
                 }                                 
        }
    if(existeprecio2 ==0){        
        ///////////////////////verifica si la tabla1 no esta vacia y la recorre para validar campos vacios 
     if(this.tabla1.getRowCount()!=0){        
            int existenombre = 0;
            int existeprecio = 0;
            for (int i = 0; i < tabla1.getRowCount(); i++) {
                 if(tabla1.getValueAt(i, 2).toString().equals("")){
                     existenombre++;
                 }                                 
                 if(tabla1.getValueAt(i, 3).toString().equals("0")){
                     existeprecio++;
                 }                                 
        }
        if (existenombre == 0 && existeprecio == 0) {//////////verifica si la tabla1 no tiene campos vacios, finaliza cotizacion
             String ID_Cotizacion = IDCotizacion.getText();
             Ventanas.Modulo_Cotizaciones_Mensual.Opciones.finalizarCotizacion(ID_Cotizacion);
             Ventanas.Modulo_Cotizaciones_Mensual.Opciones.listarCotizaciones("");
             ver();
             
                this.dispose();        
                    }else{            
                          Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                          AC.msj1.setText("¡Campos Vacios!");
                          AC.msj2.setText("Porfavor llene Completamente ");
                          AC.msj3.setText("La Tabla de Adicionales");                                    
                          AC.setVisible(true);
                    }
               }
                else{  
                        ////////Si la tabla1 esta vacia, se le pregunta al cliente, si desea finalizar cotizacion 
                        //////sin agregar ningun servicio, todo esto mediante este metodo
                       //this.setVisible(false);
                        finalizar();
                       
                       //JOptionPane.showMessageDialog(null,"Finaliza directo");
                    }
    
                                    }else{
                                            Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                                            AC.msj1.setText("¡Porfavor Asigne!");
                                            AC.msj2.setText("Precio(s)");
                                            AC.msj3.setText("Para poder Finalizar Cotizacion");
                                            AC.setVisible(true);
                                    }               
                                                    }else{
                                                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                                                        AC.msj1.setText("¡Porfavor Asigne!");
                                                        AC.msj2.setText("Un Cliente-Concepto-Periodo");
                                                        AC.msj3.setText("Para poder Finalizar Cotizacion");
                                                        AC.setVisible(true);
                                                }

              
    }//GEN-LAST:event_pnlFinalizarMouseClicked

    private void pnlFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseEntered
        pnlFinalizar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlFinalizarMouseEntered

    private void pnlFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseExited
        pnlFinalizar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlFinalizarMouseExited

    private void pnleditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseClicked

    if(this.tablaR.getRowCount()!=0){//Si la tablaR no esta vacia, permitir agregar servicios
        if(this.tabla1.getRowCount()==0){ /////Si tabla1 esta vacia, se agrega el primer campo       
        cargarServicio();
        int ID_Cotizacion;
        ID_Cotizacion=Integer.parseInt(AgregarCotizaciones_Renta.IDCotizacion.getText());        
        Ventanas.Modulo_Cotizaciones_Mensual.Opciones.llenarServicio(ID_Cotizacion);
        this.tabla1.getSelectionModel().setSelectionInterval(0,0);

        }else{//////////Si tabla1 esta llena, recorrerla para validar campos vacios
            int existenombre = 0;
            int existeprecio = 0;
            for (int i = 0; i < tabla1.getRowCount(); i++) {
                 if(tabla1.getValueAt(i, 2).toString().equals("")){
                     existenombre++;
                 }                                 
                 if(tabla1.getValueAt(i, 3).toString().equals("0")){
                     existeprecio++;
                 }                                 
        }
            if(existenombre==0 && existeprecio==0){////////Si ningun campo esta vacio, se puede agregar otro nuevo campo
                cargarServicio();
                int ID_Cotizacion;
                ID_Cotizacion = Integer.parseInt(AgregarCotizaciones_Renta.IDCotizacion.getText());
                Ventanas.Modulo_Cotizaciones_Mensual.Opciones.llenarServicio(ID_Cotizacion);
                //this.tabla1.getSelectionModel().setSelectionInterval(0, 0);             
    //JOptionPane.showMessageDialog(null, "exitennombre="+existenombre+ " existePrecio= "+existeprecio );
                    }else{            
                          Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                          AC.msj1.setText("¡Campos Vacios!");
                          AC.msj2.setText("Para Agregar otro Adicional");
                          AC.msj3.setText("Asigne un Nombre y Precio");                                    
                          AC.setVisible(true);
                    }
         }
        } else {
                                Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                                AC.msj1.setText("¡Porfavor Seleccione!");
                                AC.msj2.setText("Un Cliente-Concepto-Periodo");
                                AC.msj3.setText("Para poder Asignar Adicionales");
                                AC.setVisible(true);
        }
    
    }//GEN-LAST:event_pnleditarMouseClicked

    private void pnleditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseEntered
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnleditarMouseEntered

    private void pnleditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseExited
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnleditarMouseExited

    private void cmbPeriodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPeriodoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPeriodoItemStateChanged

    private void txtTipo_ConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipo_ConceptoKeyTyped
//        char c=evt.getKeyChar();
//        if(Character.isDigit(c)) {
//            getToolkit().beep();
//            evt.consume();
//        }
        int limite =40;
        if (txtTipo_Concepto.getText().length()== limite)
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtTipo_ConceptoKeyTyped

    private void cmbPeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbPeriodoKeyTyped
         
    }//GEN-LAST:event_cmbPeriodoKeyTyped

    private void tabla1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla1KeyTyped
//        int press=evt.getKeyCode();
//        
//        JOptionPane.showMessageDialog(null,"La tecla presionada es "+press);
        

    }//GEN-LAST:event_tabla1KeyTyped

    private void tabla1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla1KeyPressed
        // TODO add your handling code here:
        int press=evt.getKeyCode();        
        if(this.tabla1.getSelectedRow()!=-1 && press==127 ){
            int ID_Cotizacion;
            ID_Cotizacion = Integer.parseInt(AgregarCotizaciones_Renta.IDCotizacion.getText());
            int a1 = Integer.parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString());
            DefaultTableModel modelo = (DefaultTableModel) this.tabla1.getModel();
            Ventanas.Modulo_Cotizaciones_Mensual.Opciones.eliminarServicio(a1);
            Ventanas.Modulo_Cotizaciones_Mensual.Opciones.llenarServicio(ID_Cotizacion);
            this.tabla1.getSelectionModel().setSelectionInterval(0, 0);

        }
//        else{
//            Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
//                                AC.msj1.setText("¡Porfavor Seleccione!");
//                                AC.msj2.setText("Un Servicio");
//                                AC.msj3.setText("Para Eliminarlo");
//                                AC.setVisible(true);
//        }
        
    }//GEN-LAST:event_tabla1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     Guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pnleditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditar2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnleditar2MouseClicked

    private void pnleditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditar2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnleditar2MouseEntered

    private void pnleditar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditar2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pnleditar2MouseExited

    private void pnlAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseClicked

        ConfigCotizacion poper =new Ventanas.CotizacionReporte.ConfigCotizacion(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlAyudaMouseClicked

    private void pnlAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseEntered
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlAyudaMouseEntered

    private void pnlAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseExited
        pnlAyuda.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlAyudaMouseExited

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCotizaciones_Renta dialog = new AgregarCotizaciones_Renta(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel IDCotizacion;
    private javax.swing.JLabel ID_rutas;
    public static app.bolivia.swing.JCTextField buscar;
    public static ComboBox.SComboBox cmbCliente;
    public static ComboBox.SComboBox cmbPeriodo;
    public static JButtonEspecial.JButtonEspecial jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    public static jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JSeparator l2;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombreNuevo17;
    private javax.swing.JLabel lblatencion1;
    private javax.swing.JPanel pnlAyuda;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlFinalizar;
    private javax.swing.JPanel pnlVista;
    private javax.swing.JPanel pnleditar;
    private javax.swing.JPanel pnleditar2;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static javax.swing.JTable tabla1;
    public static javax.swing.JTable tablaR;
    public static app.bolivia.swing.JCTextField txtTipo_Concepto;
    // End of variables declaration//GEN-END:variables
public static void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        int ID = Integer.parseInt(IDCotizacion.getText());
        if (ID >= 0) {

       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Renta_Transporte_1.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
            parametro.put("ID_Cotizacion", ID);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());

            JRViewer jrv = new JRViewer(jasperPrint);
            jrv.setZoomRatio((float) 0.75);
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
        else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error  generar la Cotizacion!");
            AC.msj2.setText("Verifique que se agregaron los datos ");
            AC.setVisible(true);
        }
}
public static void listarCotizaciones(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.pnlCotizaciones.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            //sql = "Select * from cotizacionesv";
            sql = "Select * from cotizacionesv where Estado = 0";
        } else {
            
//            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta, Estatus from cotizacionesv where Estado = 0 AND Nombre_Cliente LIKE '%" + busca +"%' OR Atencion LIKE '%"+ busca +"%' OR Fecha_Alta LIKE '%"+ busca +"%' OR Estatus LIKE '%"+busca+"%'";
            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta, Estatus from cotizacionesv where Estado = 0 AND Nombre_Cliente LIKE '%" + busca +"%' AND Estado=0 OR Atencion LIKE '%"+ busca +"%'  AND Estado=0 OR Fecha_Alta LIKE '%"+ busca +"%' AND Estado=0 OR Estatus LIKE '%"+busca+"%'AND Estado=0";
            
           }
        String datos[] = new String[5];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Ventanas.Modulo_Cotizaciones.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
