package Ventanas.Modulo_Ruta_Cotizacion;

import Ventanas.Modulo_Cotizaciones.*;
import A_tabla.EstiloTablaHeader;
import Ventanas.Modulo_Cliente.*;
import A_tabla.EstiloTablaHeader1;
import A_tabla.EstiloTablaRenderer;
import A_tabla.EstiloTablaRenderer1;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import static Alerts.AlertBasic.AgregarDestinos.ID;
import Alerts.AlertBasic.Eliminar;
import Alerts.FadeEffect;
import Clases.Clientes;
import Clases.Conexion;
import Clases.Cotizaciones;
import static Clases.Cotizaciones.ObtenID;
import Clases.MyTableCellEditor;
import Clases.MyTableCellEditor1;
import Clases.MyTableCellEditorRuta;
import Clases.MyTableCellEditorServRutNombre;
import Clases.MyTableCellEditorServRutPrecio;
import Clases.database;
import Clases.estados;
import Clases.localidades;
import Clases.municipios;
import static Ventanas.Modulo_Cliente.Opciones.*;
import static Ventanas.Modulo_Cliente.Registrar.tabla3;
import static Ventanas.Modulo_Cotizaciones.Opciones.cn;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Ruta_Cotizacion.pnlRutasGuardadas.info;
import Ventanas.Modulo_Tipo_Servicio.ModificarTipoServicio;
import static Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio.tabla;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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



public class AgregarCotizacionesRuta extends javax.swing.JDialog {

    private boolean minimiza = false;

    int x, y;
    boolean res = true;
    int  MunicipioItem = 0;
    int ID;
    ResultSet resultado, nombre;
    int ID_Tran [];
    int ID_Ori [];
    int ID_Des [];
    int ID_Cli[];
    private database db = new database();
    
    public AgregarCotizacionesRuta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        Clientes();
        Origenes();
        Destinos();
        llenarTransportes();
        lblatencion.setVisible(true);
        lblID_Cliente.setVisible(true);
        ID_rutas.setVisible(true);
        IDCotizacion.setVisible(true);
     
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        
        tabla.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditorRuta(db,"Precio"));//Columna Precio
//        tabla1.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditorServRutNombre(db,"Nombre del Servicio"));//Columna Precio
//        tabla1.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditorServRutPrecio(db,"Precio"));//Columna Precio
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
    
    public void Origenes()
    {
         int ID_Origen = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_ruta) from rutav");

            while (resultado.next()) {
                ID_Origen = resultado.getInt(1);
            }
        } catch (SQLException ex) {

        }

        ID_Origen++;

        ID_Ori = new int[ID_Origen];
        ID_Ori[0] = 0;
        
    }
    
    public void Destinos()
    {
         int ID_Destino = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_ruta) from rutav");

            while (resultado.next()) {
                ID_Destino = resultado.getInt(1);
            }
        } catch (SQLException ex) {

        }

        ID_Destino++;

        ID_Des = new int[ID_Destino];

        ID_Des[0] = 0;
        
    }
    
    public void Transportes()
    {
        int ID_Transportes = 0;

          try
            {
                resultado = Conexion.consulta("Select Max(ID_transporte) from transportes");

                while(resultado.next())
                {
                    ID_Transportes = resultado.getInt(1);
                }
            }
            catch(SQLException ex)
            {

            }

                ID_Transportes++;
                ID_Tran = new int[ID_Transportes];
                ID_Tran [0] = 0; 
                
    }
    public void llenarTransportes(){
    int ID_Transporte = 0;
        try 
        {
            resultado = Conexion.consulta("Select Max(ID_Transporte) from transportes");
            while (resultado.next()) 
            {
                ID_Transporte = resultado.getInt(1);
            }
        } 
        catch (SQLException ex) 
        {

        }

        ID_Transporte++;
        ID_Tran = new int[ID_Transporte];
        ID_Tran[0] = 0;
        int i = 1;
        try 
        {
            resultado = Conexion.consulta("SELECT ID_Transporte, Nombre_Transporte from transportes");
            while (resultado.next()) 
            {
                ID_Tran[i] = resultado.getInt(1);
                cmbTransportes.addItem(resultado.getString(2));
                i++;
            }
        } 
        catch (SQLException ex) 
        {

        }

    }
    public void eliminar()
    {
        int Fila = tabla.getSelectedRow();
            if(Fila >= 0)
        {
            int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
            Eliminar ME = new Eliminar(null, true);
            ME.ID.setText(""+ID);
            ME.Cotizacion.setText(""+ID_Cotizacion);
            ME.setVisible(true);
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
    private void Guardar(String destino,int IDOrigen ,int IDClient,int IDCot ){
        int ID_Ruta = 0;
        
        int comboCliente = cmbCliente.getSelectedIndex();
        int comboOrigen= cmbOrigenes.getSelectedIndex();
        int comboDestino = cmbDestinos.getSelectedIndex();
        int comboTransporte = cmbTransportes.getSelectedIndex();
        
        int ID_ORIGEN = Integer.parseInt(lblID_Origen.getText());
        int ID_TRAN = Integer.parseInt(lblIDTrans.getText());
        
        
      String destino1="";
           for (int i = 0; i < tablaDestinos.getRowCount(); i++) {
               destino1+="|".concat(tablaDestinos.getValueAt(i, 1).toString());
           }
        ////////////////
        int ID_Client1 = cmbCliente.getSelectedIndex();
        int ID_Cliente = ID_Cli[ID_Client1];
            
        int ID_Origen = cmbOrigenes.getSelectedIndex();
        int ID_Origenes = ID_Ori[ID_Origen];
            
        int ID_Destin = cmbDestinos.getSelectedIndex();
        int ID_Destinos = ID_Des[ID_Destin];
        
        int ID_Transporte = cmbTransportes.getSelectedIndex();
        int ID_Transportes = ID_Tran[ID_Transporte];
       int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
        
        if(comboCliente==0)
            {
                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Elija un");
                AC.msj2.setText("Cliente para Continuar");
                AC.setVisible(true);
            }
            else
            {
                if(comboOrigen==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Elija un !");
                        AC.msj2.setText("Origen");
                        AC.setVisible(true);
                    }
                else
                {
                    if(comboDestino==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Elija un !");
                        AC.msj2.setText("Destino");
                        AC.setVisible(true);
                    }
                    else
                    {
                        if(ID_TRAN==0)
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Elija un !");
                            AC.msj2.setText("Transporte");
                            AC.setVisible(true);
                        }
                        else
                        {
                             if(comboCliente==0 || comboOrigen==0 || comboDestino==0 || comboTransporte==0)
                            {
                                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                AC.msj1.setText("¡Seleccione Un!");
                                AC.msj2.setText("Cliente, Origen - Destino y Transporte");
                                AC.msj3.setText("Para Continuar");
                                AC.setVisible(true);
                            }
                            else
                            {
                                if(Ventanas.Modulo_Ruta_Cotizacion.Opciones.verificaRutaCotizacion1(ID_Cotizacion,ID_ORIGEN, destino1,ID_TRAN)==0){
                                    //////Si la ruta no existe, agrega los datos selecionados a la tabla cotizaciones_ruta
//                                   int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
                                    String Origen =AgregarCotizacionesRuta.cmbOrigenes.getSelectedItem().toString();                                    
                                    String Transportes=AgregarCotizacionesRuta.cmbTransportes.getSelectedItem().toString();                                    
                                    Opciones.registrarCotizacionesRuta(IDCot,IDClient,IDOrigen,Origen,destino,ID_Transporte,Transportes);
                                    Opciones.listar("",ID_Cotizacion );
                                }else{
                                    
                                     Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                        AC.msj1.setText("¡Error!");
                                        AC.msj2.setText("El Origen - Destino ya Estan");
                                        AC.msj3.setText("Registrados con el Mismo Transporte");
                                        AC.setVisible(true);
                               
//                                ID_rutas.setText(""+ Cotizaciones.ObtenerIDCotizacionRuta(ID_Cliente,IDOrigen, destino, ID_Transportes));
//                                int ID_Rutas = Integer.parseInt(ID_rutas.getText());
//                                 int IDCliente=Integer.parseInt(lblID_Cliente.getText());
//                                int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
                                
//                                
//                                Opciones.listar("",ID_Cotizacion );
//                                
//                                String destino1="";
//                                        for (int i = 0; i < tablaDestinos.getRowCount(); i++) {
//                                                 destino1+="|".concat(tablaDestinos.getValueAt(i, 1).toString());                
//                                        }

                                         
//                                    if(Ventanas.Modulo_Ruta_Cotizacion.Opciones.verificaRutaCotizacion1(ID_Cotizacion,ID_Origen,destino1)==0)
//                                    {   
//
//                                        Opciones.agregarCotizacionRuta(ID_Cotizacion, ID_Rutas, IDCliente);
//                                  //      Ventanas.Modulo_Cotizaciones.Opciones.listar("", ID_Cotizacion);
//                                        Opciones.listar("",ID_Cotizacion );
//                                        this.cmbOrigenes.setSelectedItem(0);
//                                        this.cmbDestinos.setSelectedItem(0);
//                                        this.cmbTransportes.setSelectedItem(0);
////                                        ID_rutas.setText("");
//
//                                    }
                                   
                                    
                                    //}
                                }
                                
                                
                            }
                        }
                    }
                   
                }
            }
    

        
    }
    
    public static void cargarServicio(){
        int ID_Cotizacion1;
        ID_Cotizacion1=Integer.parseInt(AgregarCotizacionesRuta.IDCotizacion.getText());
        Ventanas.Modulo_Ruta_Cotizacion.Opciones.insertarServicio(ID_Cotizacion1);
 
 }
    public static void finalizar(){
        
        Alerts.AlertBasic.WarningFinalizarRuta AC = new  Alerts.AlertBasic.WarningFinalizarRuta(null, true);
        AC.ID.setText(IDCotizacion.getText());
        AC.setVisible(true);
      
    
    //AgregarCotizaciones.dispose();
    }
    
    
//    
    ////////////////////////////////////////////////////////////////////////
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        lblNombreNuevo17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        cmbCliente = new ComboBox.SComboBox();
        lblatencion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlEliminar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlVista = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlFinalizar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnleditar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        IDCotizacion = new javax.swing.JLabel();
        ID_rutas = new javax.swing.JLabel();
        cmbDestinos = new ComboBox.SComboBox();
        jButton3 = new javax.swing.JButton();
        cmbOrigenes = new ComboBox.SComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbTransportes = new ComboBox.SComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestinos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        IDCotizacion1 = new javax.swing.JLabel();
        IDCotizacion2 = new javax.swing.JLabel();
        IDCotizacion3 = new javax.swing.JLabel();
        IDCotizacion4 = new javax.swing.JLabel();
        IDCotizacion5 = new javax.swing.JLabel();
        lblID_Cliente = new javax.swing.JLabel();
        lblID_Origen = new javax.swing.JLabel();
        lblIDTrans = new javax.swing.JLabel();
        lblIDCoti = new javax.swing.JLabel();

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 0, 30, 30));

        lblNombreNuevo17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo17.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo17.setText("     Clientes > Ata Origen, Destinos y Asignación");
        jPanel7.add(lblNombreNuevo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 877, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 13, 905, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_", "Origen", "Destinos", "Unidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Float.class
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
        tabla.setRowHeight(25);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(4).setMinWidth(140);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(140);
            tabla.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        tabla1.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios Extra"));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_", "Nombre del Servicio", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setRowHeight(20);
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(0);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jcMousePanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 880, 280));

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Cliente" }));
        cmbCliente.setToolTipText("");
        cmbCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });
        jcMousePanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 420, 30));

        lblatencion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblatencion.setText("Atención a:");
        jcMousePanel1.add(lblatencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcMousePanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 350, 30));

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

        pnlVista.setBackground(new java.awt.Color(225, 225, 225));
        pnlVista.setToolTipText("Activar o Desactivar Paciente");
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

        jPanel1.add(pnlFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 70));

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
        pnleditar.setToolTipText("Editar Paciente");
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
        jLabel13.setText("    Servicios");
        pnleditar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-servicios-40.png"))); // NOI18N
        pnleditar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 69));

        jcMousePanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 70));
        jcMousePanel1.add(IDCotizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 80, 20));
        jcMousePanel1.add(ID_rutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 140, 20));

        cmbDestinos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Destino" }));
        cmbDestinos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDestinos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDestinosItemStateChanged(evt);
            }
        });
        jcMousePanel1.add(cmbDestinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 310, 30));

        jButton3.setText("Agregar Destino");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jcMousePanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 110, 30));

        cmbOrigenes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Origen" }));
        cmbOrigenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrigenes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrigenesItemStateChanged(evt);
            }
        });
        jcMousePanel1.add(cmbOrigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 420, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Unidades disponibles para el Origen y Destino seleccionado:");
        jcMousePanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 420, 20));

        cmbTransportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una Unidad" }));
        cmbTransportes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbTransportes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTransportesItemStateChanged(evt);
            }
        });
        cmbTransportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTransportesActionPerformed(evt);
            }
        });
        jcMousePanel1.add(cmbTransportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 420, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Origenes disponibles para la empresa/cliente seleccionado(a):");
        jcMousePanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 420, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Destinos disponibles para el origen seleccionado:");
        jcMousePanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 430, 20));

        tablaDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDestinos.setRowHeight(20);
        tablaDestinos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaDestinos);
        if (tablaDestinos.getColumnModel().getColumnCount() > 0) {
            tablaDestinos.getColumnModel().getColumn(0).setMinWidth(0);
            tablaDestinos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaDestinos.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jcMousePanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 440, 110));

        jButton4.setText("Agregar Ruta a la cotización");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jcMousePanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 440, 30));
        jcMousePanel1.add(IDCotizacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 70, 20));
        jcMousePanel1.add(IDCotizacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 90, 20));
        jcMousePanel1.add(IDCotizacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 20));
        jcMousePanel1.add(IDCotizacion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 20));
        jcMousePanel1.add(IDCotizacion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 20));

        lblID_Cliente.setText("0");
        jcMousePanel1.add(lblID_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 20, 20));
        jcMousePanel1.add(lblID_Origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, 20));
        jcMousePanel1.add(lblIDTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 150, 20));
        jcMousePanel1.add(lblIDCoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 150, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
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
//            String cliente=cmbCliente.getSelectedItem().toString();            
            int ID_Client = cmbCliente.getSelectedIndex();
            int ID_Cliente = ID_Cli[ID_Client];
//            String ID_ClienteString="";
    
            int i = 1;
            int er;
//             int IDR = Integer.parseInt(IDCotizacion2.getText());
            //JOptionPane.showMessageDialog(null, ID_Client);
          
            try {
                resultado = Conexion.consulta("SELECT ID_Municipio_Origen, Origen from rutav where "
                        + "(ID_Cliente = "+ID_Cliente+") GROUP BY Origen");

                while (resultado.next()) {
                    ID_Ori[i] = resultado.getInt(1);
                    cmbOrigenes.addItem(resultado.getString(2).trim());
                    i++;
                }
            } 
            catch (SQLException ex) {
            }            
            lblID_Cliente.setText(""+ID_Cliente);
            cmbCliente.setEnabled(false);
            Cotizaciones.Agregar_Cotizacion(ID_Cliente,3);
            lblatencion.setVisible(true);
            lblNombre.setText(Cotizaciones.ObtenerNombre(ID_Cliente));
            IDCotizacion.setText(""+ObtenID());
            Opciones.listarCotizaciones("");
//            int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
//            Opciones.listar("",ID_Cotizacion );
            
            
//            if(Opciones.verificaCliente(ID_Cliente)==0)///falta decirle que compare por origen, destino y cliente
//                {
//                    JOptionPane.showMessageDialog(null, "No existe ninguna ruta con ese cliente");
//                    Opciones.listar("",ID_Cotizacion );
//                }
//            else{
//                    //JOptionPane.showMessageDialog(null, "Este clietne ya tiene ruta");
//                    pnlRutasGuardadas RG=new pnlRutasGuardadas(null,true);
//                    //RG.Opciones.listarDetallesCotizaciones(ID_Cliente,cliente);
//                    RG.setVisible(true);
//                    //JOptionPane.showMessageDialog(null, ID+" "+clientes);
//                    //llenarDetalles(ID_Cliente, cliente);
//                    //poper.Opciones.listarDetallesCotizaciones(ID_Cliente, cliente);  
////                    int ID_Cotizacion = Integer.parseInt(IDCotizacion.getText());
////                    Opciones.listar("",ID_Cotizacion );
//                }
         }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmbDestinosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDestinosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            int ID_Client = cmbCliente.getSelectedIndex();
//            int ID_Cliente = ID_Cli[ID_Client];
//            
//            int ID_Origen = cmbOrigenes.getSelectedIndex();
//            int ID_Origenes = ID_Ori[ID_Origen];
//            
//            int ID_Destin = cmbDestinos.getSelectedIndex();
//            int ID_Destinos = ID_Des[ID_Destin];
            
            
            
        
            
        }
        
    }//GEN-LAST:event_cmbDestinosItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tablaDestinos.getModel();          
        boolean avisar=false;
        int comboDestino = cmbDestinos.getSelectedIndex(); 
        //////Obtiene el dato que se ha seleccionado y lo guarda en la variable destino
        String destino=cmbDestinos.getSelectedItem().toString();
        
        ////si el combo no se ha seleccionado, pedir seleccionar uno
        if (comboDestino==0) {
         Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
          AC.msj1.setText("¡Seleccione Un Destino!");
          AC.msj2.setText("Para Continuar.");
          AC.msj3.setText("");
          AC.setVisible(true);
        }       
        else{//////////Se permite añadir hasta 10 destinos                         
             String datos[] = new String[10];
             datos [1] = destino;
                ///////Recorrido de la tabla
                for(int i = 0; i<tablaDestinos.getRowCount(); i++){
                    //////Compara el valor a ingresar con los datos de la tabla y si son identicos activa la bandera a true 
                        if(tablaDestinos.getValueAt(i, 1).equals(destino)){
                            
                              Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                              AC.msj1.setText( "¡El  destino  ya existe!");
                              AC.msj2.setText("Verifique los datos.");
                              AC.msj3.setText("");
                              AC.setVisible(true);
                            
//                        JOptionPane.showMessageDialog(null, "El "+ destino + " ya existe en la tabla.");                       
                        avisar=true;                        
                         }
                       }
                //////Si la bandera no se activa agregar a la tabla
                if (avisar==false) {
                modelo.addRow(datos);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbOrigenesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrigenesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        
        int ID_Client = cmbCliente.getSelectedIndex();
        int ID_Cliente = ID_Cli[ID_Client];
        int i = 1;
        
        int ID_Origen = cmbOrigenes.getSelectedIndex();
        int ID_Origenes = ID_Ori[ID_Origen];
        //int ID_OrigenB=ID_Ori[ID_Origen];
        int ID_OrigenB=0;
        
        ///////Obtener Id origen
                    try {
                resultado = Conexion.consulta("SELECT ID_Origen from origen where "
                        + "ID_Municipio="+ID_Origenes);
                //select ID_Origen from origen WHERE ID_Municipio=688

                while (resultado.next()) {
                    ID_OrigenB = resultado.getInt(1);
                    //cmbOrigenes.addItem(resultado.getString(2).trim());
                    i++;
                }
            } 
            catch (SQLException ex) {
            }            
                    lblID_Origen.setText(""+ID_OrigenB);
        
        cmbDestinos.removeAllItems();
        cmbDestinos.addItem("Seleccione un Destino");
        
        
        ///////Obtner destinos de ese origen
        try {
            resultado = Conexion.consulta("SELECT ID_Municipio_Destino, Destino from rutav where "
                    + "(ID_Cliente = "+ID_Cliente+") and (ID_Municipio_Origen = "+ID_Origenes+") GROUP BY Destino");

            while (resultado.next()) {
                ID_Des[i] = resultado.getInt(1);
                cmbDestinos.addItem(resultado.getString(2).trim());
                i++;
            }
        } catch (SQLException ex) {

        }
        
                //JOptionPane.showMessageDialog(null,"Origenes");
        
      }
    }//GEN-LAST:event_cmbOrigenesItemStateChanged

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        
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
    }//GEN-LAST:event_pnlEliminarMouseClicked

    private void pnlEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseEntered
        pnlEliminar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlEliminarMouseEntered

    private void pnlEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseExited
        pnlEliminar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlEliminarMouseExited

    private void pnlVistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseClicked
      
    }//GEN-LAST:event_pnlVistaMouseClicked

    private void pnlVistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseEntered
        pnlVista.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlVistaMouseEntered

    private void pnlVistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseExited
        pnlVista.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlVistaMouseExited

    private void pnlFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFinalizarMouseClicked
    if(this.tabla.getRowCount()!=0){
       int existenombre2 = 0;
            int existeprecio2 = 0;
            for (int i = 0; i < tabla.getRowCount(); i++) {                                                 
                 if(tabla.getValueAt(i, 2).toString().equals("0")){
                     existeprecio2++;
                 }                                 
        }
    if(existeprecio2 ==0){        
        ///////////////////////verifica si la tabla destino no esta vacia y la recorre para validar campos vacios 
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
             Ventanas.Modulo_Ruta_Cotizacion.Opciones.finalizarCotizacion(ID_Cotizacion);
             Ventanas.Modulo_Ruta_Cotizacion.Opciones.listarCotizaciones("");
             ver();
             
                this.dispose();        
                    }else{            
                          Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                          AC.msj1.setText("¡Campos Vacios!");
                          AC.msj2.setText("Porfavor llene Completamente ");
                          AC.msj3.setText("La Tabla de Servicios");                                    
                          AC.setVisible(true);
                    }
               }
                else{  
                        ////////Si la tabla1 esta vacia, se le pregunta al cliente, si desea finalizar cotizacion 
                        //////sin agregar ningun servicio, todo esto mediante este metodo
                       finalizar();
                       //JOptionPane.showMessageDialog(null,"Finaliza directo");
                    }
    
                                    }else{
                                            Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                                            AC.msj1.setText("¡Porfavor Asigne!");
                                            AC.msj2.setText("Precio'(s)'");
                                            AC.msj3.setText("Para poder Finalizar Cotizacion");
                                            AC.setVisible(true);
                                    }               
                                                    }else{
                                                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                                                        AC.msj1.setText("¡Porfavor Asigne!");
                                                        AC.msj2.setText("Un Cliente-Consolidado");
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

    private void cmbTransportesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTransportesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
         String Trans=cmbTransportes.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null,"Transporte ID="+Trans);
        String IDTrans="";
        
        try {
            resultado = Conexion.consulta("SELECT ID_Transporte from transportes where Nombre_Transporte='"+Trans+"'");
                    

            while (resultado.next()) {
                IDTrans= resultado.getString(1);
                //cmbDestinos.addItem(resultado.getString(2).trim());
                
            }
        } catch (SQLException ex) {

        }
        
   lblIDTrans.setText(IDTrans);
   JOptionPane.showMessageDialog(null, IDTrans);
        }
    

    }//GEN-LAST:event_cmbTransportesItemStateChanged

    private void pnleditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseClicked
      if(this.tabla.getRowCount()!=0){//Si la tablaR no esta vacia, permitir agregar servicios
        if(this.tabla1.getRowCount()==0){ /////Si tabla1 esta vacia, se agrega el primer campo       
        cargarServicio();
        int ID_Cotizacion;
        ID_Cotizacion=Integer.parseInt(AgregarCotizacionesRuta.IDCotizacion.getText());        
        Ventanas.Modulo_Ruta_Cotizacion.Opciones.llenarServicio(ID_Cotizacion);
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
                ID_Cotizacion = Integer.parseInt(AgregarCotizacionesRuta.IDCotizacion.getText());
                Ventanas.Modulo_Ruta_Cotizacion.Opciones.insertarServicio(ID_Cotizacion);
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
                                AC.msj2.setText("Un Cliente-Consolidado");
                                AC.msj3.setText("Para poder Asignar Servicios");
                                AC.setVisible(true);
        }
    }//GEN-LAST:event_pnleditarMouseClicked

    private void pnleditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseEntered
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnleditarMouseEntered

    private void pnleditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseExited
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnleditarMouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if((this.tablaDestinos.getRowCount()==0)){
           Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
           AC.msj1.setText("¡Asigne Destinos a la tabla!");
           AC.msj2.setText("Para poder asignar cotizacion");
           //AC.msj3.setText("Registrados con el Mismo Transporte");
           AC.setVisible(true);
       }else{
           
           
           String origen =cmbOrigenes.getSelectedItem().toString();
           String transporte=cmbTransportes.getSelectedItem().toString();
           String IDCliente=lblID_Cliente.getText();
           String IDOrigen=lblID_Origen.getText();
           String IDTrans=lblIDTrans.getText();
           String IDCoti=IDCotizacion.getText();
           int IDOri=Integer.parseInt(lblID_Origen.getText());
           int IDClient=Integer.parseInt(lblID_Cliente.getText());
           int IDCot=Integer.parseInt(IDCotizacion.getText());
           
           
           
           
           String destino="";
           for (int i = 0; i < tablaDestinos.getRowCount(); i++) {
               destino+="|".concat(tablaDestinos.getValueAt(i, 1).toString());
           }
           Guardar(destino,IDOri,IDClient,IDCot);
           
           
           
       }
       this.cmbDestinos.setSelectedIndex(0);
       this.cmbTransportes.setSelectedIndex(0);
       
//         DefaultTableModel temp;
//        try{
//            temp = (DefaultTableModel) tablaDestinos.getModel();
//            int a =temp.getRowCount()-1;
//            for(int i=0; i<a; i++)
//                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
//        }catch(Exception e){
//            System.out.println(e);
//        }
//         if( tablaDestinos.getRowCount()>0){
//            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(0, tablaDestinos.getColumnCount());
//             
//            tablaDestinos.setModel(modelo);
//        }
       DefaultTableModel myTableModel = (DefaultTableModel) this.tablaDestinos.getModel(); 
       while (myTableModel.getRowCount() > 0) { 
       myTableModel.removeRow(0); 
} 


//        tablaDestinos
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbTransportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTransportesActionPerformed
         
    }//GEN-LAST:event_cmbTransportesActionPerformed

    private void tabla1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla1KeyPressed
       int press = evt.getKeyCode();
        if (this.tabla1.getSelectedRow() != -1 && press == 127) {
            int ID_Cotizacion;
            ID_Cotizacion = Integer.parseInt(AgregarCotizacionesRuta.IDCotizacion.getText());
            int a1 = Integer.parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString());
            DefaultTableModel modelo = (DefaultTableModel) this.tabla1.getModel();
            Ventanas.Modulo_Ruta_Cotizacion.Opciones.eliminarServicio(a1);
            Ventanas.Modulo_Ruta_Cotizacion.Opciones.llenarServicio(ID_Cotizacion);
            this.tabla1.getSelectionModel().setSelectionInterval(0, 0);
        } 

    }//GEN-LAST:event_tabla1KeyPressed

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCotizacionesRuta dialog = new AgregarCotizacionesRuta(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel IDCotizacion1;
    private javax.swing.JLabel IDCotizacion2;
    private javax.swing.JLabel IDCotizacion3;
    private javax.swing.JLabel IDCotizacion4;
    private javax.swing.JLabel IDCotizacion5;
    public static javax.swing.JLabel ID_rutas;
    public static app.bolivia.swing.JCTextField buscar;
    public static ComboBox.SComboBox cmbCliente;
    public static ComboBox.SComboBox cmbDestinos;
    public static ComboBox.SComboBox cmbOrigenes;
    public static ComboBox.SComboBox cmbTransportes;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane2;
    public static jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JSeparator l2;
    public static javax.swing.JLabel lblIDCoti;
    public static javax.swing.JLabel lblIDTrans;
    public static javax.swing.JLabel lblID_Cliente;
    private javax.swing.JLabel lblID_Origen;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombreNuevo17;
    private javax.swing.JLabel lblatencion;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlFinalizar;
    private javax.swing.JPanel pnlVista;
    private javax.swing.JPanel pnleditar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTable tabla1;
    public static javax.swing.JTable tablaDestinos;
    // End of variables declaration//GEN-END:variables
public void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        int ID = Integer.parseInt(IDCotizacion.getText());
        
        if (ID >= 0) {

              try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "C:\\Users\\Mary\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Renta_ruta.jasper";
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
        
}
