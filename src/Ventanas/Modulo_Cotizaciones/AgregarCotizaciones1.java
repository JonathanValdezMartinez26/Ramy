package Ventanas.Modulo_Cotizaciones;

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
import Clases.EditarNombreAdicionall;
import Clases.EditarCamioneta15Adicional;
import Clases.Render;
import Clases.database;
import Clases.estados;
import Clases.localidades;
import Clases.municipios;
import MyTableCellEditor.EditarCamioneta35Adicional;
import Ventanas.CotizacionReporte.ConfigCotizacionD;
import Ventanas.CotizacionReporte.ConfigCotizacionDire;
import static Ventanas.Modulo_Cliente.Opciones.*;
import static Ventanas.Modulo_Cliente.Registrar.tabla3;
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
import Ventanas.Modulo_Cotizaciones.Opciones;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.IDCotizacion;
import static Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.finalizar;
import static Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tabla1;
import static Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tablaR;
import static Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tablaDestinos;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import MyTableCellEditor.EditarClienteCamioneta15;
import MyTableCellEditor.EditarFullAdicional;
import MyTableCellEditor.EditarRabonAdicional;
import MyTableCellEditor.EditarTorthonAdicional;
import MyTableCellEditor.EditarTrailerAdicional;


public class AgregarCotizaciones1 extends javax.swing.JDialog {
    
    //final TableRowSorter sorter;
    private boolean minimiza = false;

    int x, y;
    boolean res = true;
    int  MunicipioItem = 0;
    int ID;
    
    ResultSet resultado, resultados;
    int ID_Tran [];
    int ID_Ori [];
    int ID_Des [];
    int ID_Cli[];
    
    private database db = new database();
    public static AgregarCotizaciones1 AC=new AgregarCotizaciones1(null, true);
    
    
    public AgregarCotizaciones1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        Clientes();
        Origenes();
        Destinos();
        Transportes();
        
        lblatencion.setVisible(false);
        ID_rutas.setVisible(false);
        IDCotizacion.setVisible(false);
        IDCotizacion1.setVisible(false);
        
     
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.jTable1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        jTable1.getColumnModel().getColumn( 2 ).setCellEditor(new EditarNombreAdicionall(db,""));//Columna Precio
        jTable1.getColumnModel().getColumn( 3 ).setCellEditor(new EditarCamioneta15Adicional(db,""));//Columna Precio        
        jTable1.getColumnModel().getColumn( 4 ).setCellEditor(new EditarCamioneta35Adicional(db,""));//Columna Precio        
        jTable1.getColumnModel().getColumn( 5 ).setCellEditor(new EditarRabonAdicional(db,""));//Columna Precio        
        jTable1.getColumnModel().getColumn( 6 ).setCellEditor(new EditarTorthonAdicional(db,""));//Columna Precio        
        jTable1.getColumnModel().getColumn( 7 ).setCellEditor(new EditarTrailerAdicional(db,""));//Columna Precio        
        jTable1.getColumnModel().getColumn( 8 ).setCellEditor(new EditarFullAdicional(db,""));//Columna Precio        
        //jTable1.setDefaultRenderer(Object.class, new Render());
//                                               
    
    }
    public void AgregarCotizaciones11(){
        boolean t=false;
        AgregarCotizaciones1 AC=new AgregarCotizaciones1(null, t);
        
}
    
    public void Clientes()
    {
        int ID_Cliente = 0;
        try 
        {
            resultado = Conexion.consulta("Select Max(ID_cliente) from clientes");
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
        public static void cargarServicio(){
        int ID_Cotizacion;
        ID_Cotizacion=Integer.parseInt(AgregarCotizaciones1.IDCotizacion.getText());
        Opciones.insertarServicio(ID_Cotizacion);
        //Opciones.llenarServicio(ID_Cotizacion);
        
    }
    ////////////////////////////////////////////////////////////////////////
    public static void finalizar(String ID1,int Fila){
        
        String F= String.valueOf(Fila);
        Alerts.AlertBasic.WarningFinalizar AC9 = new  Alerts.AlertBasic.WarningFinalizar(null, true);
        AC9.ID.setText(""+ID1);
        AC9.filas.setText(""+F);
        AC9.setVisible(true);
      //JOptionPane.showMessageDialog(null, "Desde finalizar()"+ID1);
    
    //AgregarCotizaciones.dispose();
    }
    
    public void guardarAutomatico(){
    
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();
        int Filas1 = modelo.getRowCount();  
                        for (int i = 0; i < Filas1; i++) {
                            //String IDAsignaCot = tabla.getValueAt(i, 0).toString();
                            String IDCot = tabla.getValueAt(i, 0).toString();
                            String IDRuta = tabla.getValueAt(i, 1).toString();
                            String Origen = tabla.getValueAt(i, 2).toString();
                            String Destino = tabla.getValueAt(i, 3).toString();
                            String Camioneta15 = tabla.getValueAt(i, 4).toString();
                            String Camioneta35 = tabla.getValueAt(i, 5).toString();
                            String Rabon = tabla.getValueAt(i, 6).toString();
                            String Torthon = tabla.getValueAt(i, 7).toString();
                            String Trailer = tabla.getValueAt(i, 8).toString();
                            String Full = tabla.getValueAt(i, 9).toString();

                            Boolean checked = Boolean.valueOf(tabla.getValueAt(i, 10).toString());

                            String sql;
                            
                                sql = "insert guardar_cotizacion_directa(ID_GuardarCotD,IDRuta,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                                        + " values(NULL, '" + IDRuta + "','" + IDCot + "','" + Origen + "','" + Destino + "','" + Camioneta15 + "','" + Camioneta35 + "','" + Rabon + "','" + Torthon + "','" + Trailer + "','" + Full + "','0')";

                                try {
                                    PreparedStatement pstm = cn.prepareStatement(sql);
                                    pstm.execute();
                                    pstm.close();
                                 

                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                        }
                Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Viajes Asignados!");
                AC.msj2.setText("Correctamente");
                AC.setVisible(true);

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        lblNombreNuevo17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbCliente = new ComboBox.SComboBox();
        lblatencion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        pnlEliminar2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlVista = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlFinalizar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnleditar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlAyuda = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        IDCotizacion = new javax.swing.JLabel();
        ID_rutas = new javax.swing.JLabel();
        cmbOrigenes = new ComboBox.SComboBox();
        jLabel6 = new javax.swing.JLabel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        IDCotizacion1 = new javax.swing.JLabel();

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1128, 0, 30, 30));

        lblNombreNuevo17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo17.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo17.setText("     Cotizaciones > Nueva Cotización para Fletes Directos");
        jPanel7.add(lblNombreNuevo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1120, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, 1157, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Cotizacion", "IDRuta", "Origen", "Destino", "Camioneta 1.5", "Camioneta 3.5", "Rabón", "Torthon", "Tráiler", "Fulll", "Selecciona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(4).setMinWidth(120);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(4).setMaxWidth(120);
            tabla.getColumnModel().getColumn(5).setMinWidth(120);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(5).setMaxWidth(120);
            tabla.getColumnModel().getColumn(6).setMinWidth(70);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(6).setMaxWidth(70);
            tabla.getColumnModel().getColumn(7).setMinWidth(70);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(7).setMaxWidth(70);
            tabla.getColumnModel().getColumn(8).setMinWidth(70);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(8).setMaxWidth(70);
            tabla.getColumnModel().getColumn(9).setMinWidth(70);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(9).setMaxWidth(70);
            tabla.getColumnModel().getColumn(10).setMinWidth(100);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(10).setMaxWidth(100);
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDCoti", "Nombre del Adicional", "Camioneta 1.5", "Camioneta 3.5", "Rabón", "Torthon", "Tráiler", "Full", "Supr para Borrar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(30);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(2).setMinWidth(370);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(370);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(370);
            jTable1.getColumnModel().getColumn(3).setMinWidth(135);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(135);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(135);
            jTable1.getColumnModel().getColumn(4).setMinWidth(135);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(135);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(135);
            jTable1.getColumnModel().getColumn(5).setMinWidth(85);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(6).setMinWidth(85);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(7).setMinWidth(85);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(8).setMinWidth(85);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(9).setMinWidth(159);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(159);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(159);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jcMousePanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 1140, 360));

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Cliente" }));
        cmbCliente.setToolTipText("");
        cmbCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        jcMousePanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 380, 30));

        lblatencion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblatencion.setText("Atención a:");
        jcMousePanel1.add(lblatencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcMousePanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Seleccione una empresa o cliente para inciar la cotización.");
        jcMousePanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 20));
        jcMousePanel1.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1140, 3));

        jPanel1.setBackground(new java.awt.Color(225, 225, 225));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEliminar2.setBackground(new java.awt.Color(225, 225, 225));
        pnlEliminar2.setToolTipText("Guardar Registros");
        pnlEliminar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEliminar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEliminar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEliminar2MouseExited(evt);
            }
        });
        pnlEliminar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("    Guardar");
        pnlEliminar2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar (2).png"))); // NOI18N
        pnlEliminar2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnlEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 70));

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

        jPanel1.add(pnlVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        pnlFinalizar.setBackground(new java.awt.Color(225, 225, 225));
        pnlFinalizar.setToolTipText("Finalizar Cotización");
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
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnleditar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-servicios-40.png"))); // NOI18N
        pnleditar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel1.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 69));

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

        jPanel1.add(pnlAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 80, 70));

        jcMousePanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 890, 70));
        jcMousePanel1.add(IDCotizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 120, 20));
        jcMousePanel1.add(ID_rutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 140, 20));

        cmbOrigenes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asigne Origen" }));
        cmbOrigenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrigenes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrigenesItemStateChanged(evt);
            }
        });
        cmbOrigenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrigenesActionPerformed(evt);
            }
        });
        jcMousePanel1.add(cmbOrigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 420, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Origenes disponibles para la empresa/cliente seleccionado(a):");
        jcMousePanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 420, 20));

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
        jcMousePanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 200, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jcMousePanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 210, -1));

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

        jcMousePanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 180, -1, -1));
        jcMousePanel1.add(IDCotizacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 150, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.dispose();
        //this.setVisible(false);
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

            cmbOrigenes.removeAllItems();
            cmbOrigenes.addItem("Seleccione un Origen");
            cmbOrigenes.addItem("Todos los Origenes");

            try {
                resultado = Conexion.consulta("SELECT ID_Municipio_Origen, Origen from rutav where "
                        + "(ID_Cliente = "+ID_Cliente+") GROUP BY Origen");

                while (resultado.next()) {
                    ID_Ori[i] = resultado.getInt(1);
                    //cmbOrigenes.addItem(resultado.getString(2).trim());
                    i++;
                }
            } 
            catch (SQLException ex) {
            }
            
            try {

                resultado = Conexion.consulta("SELECT ID_Origen, Origen from rutav where "
                        + "(ID_Cliente = "+ID_Cliente+") GROUP BY Origen");

                while (resultado.next()) {
                    ID_Ori[i] = resultado.getInt(1);
                    //cmbOrigenes.addItem(resultado.getString(2).trim());
                    i++;
                }
            } 
            catch (SQLException ex) {
            }
            
            cmbCliente.setEnabled(false);
            Cotizaciones.Agregar_Cotizacion(ID_Cliente, 1);
            lblatencion.setVisible(true);
            
            lblNombre.setText(Cotizaciones.ObtenerNombre(ID_Cliente));
            IDCotizacion.setText(""+ObtenID());
            IDCotizacion1.setText(""+ObtenID());            
            Opciones.listarCotizaciones("");
            
            
         }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmbOrigenesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrigenesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        
        int ID_Client = cmbCliente.getSelectedIndex();
        int ID_Cliente = ID_Cli[ID_Client];
        int i = 1;
        
        int ID_Origen = cmbOrigenes.getSelectedIndex();
        int ID_Origenes = ID_Ori[ID_Origen];
        
        String Origenes = (String) cmbOrigenes.getSelectedItem();
        
        if(Origenes == "Todos los Origenes")
        {
//          cmbOrigenes.removeAllItems();
//          cmbOrigenes.addItem("Sin Origenes Disponibles...");
            try {

                resultado = Conexion.consulta("SELECT ID_ruta from ruta where (ID_Cliente = "+ID_Cliente+")");
                int ID = 0;
                int ID_Cotiza = Integer.parseInt(IDCotizacion.getText());
                while (resultado.next()) 
                {
                     ID = resultado.getInt(1);
                    i++;
                    
                    String q = " INSERT INTO asigna_cotizacion(ID_asigna_Cotizacion,ID_Cotizacion,ID_ruta,Fecha_Alta, Estado)"
                                        + "VALUES (NULL,'"+ID_Cotiza+"',"+ID+",current_timestamp(), 0)";      
                                        try {
                                            PreparedStatement pstm = cn.prepareStatement(q);
                                            pstm.execute();
                                            pstm.close();
                                    
                                            }
                                        catch(SQLException e)
                                        {            
                                            System.out.println(e);
                                        }
                }
                Ventanas.Modulo_Cotizaciones.Opciones.listar("", ID_Cotiza);
                guardarAutomatico();
                 
                 
            } 
            catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
        }
       
    }        


    }//GEN-LAST:event_cmbOrigenesItemStateChanged

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
//    
      int ID = Integer.parseInt(IDCotizacion.getText());
      //Ventanas.Modulo_Cotizaciones.Opciones.listar(buscar.getText(), ID);
      DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();
      final TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
      tabla.setRowSorter(sorter);
      
      String text = buscar.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
      
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void pnlEliminar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminar2MouseClicked
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);
        sorter.setRowFilter(null);
        int existe = 0;
////////////////////Verifica si no hay combos seleccionados
        if (this.tabla.getRowCount() != 0) {
            int Filas = modelo.getRowCount();
            for (int j = 0; j < Filas; j++) {
                Boolean validar = Boolean.valueOf(Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getValueAt(j, 10).toString());
                if (validar) {///////Verifica si existen checks seleccionados
                    existe++;
                }
            }
            if (existe > 0) {//////Si existen checks seleccionados, se guardan los viajes para editarlos despues
                        String IDC=IDCotizacion.getText();
                        Opciones.eliminarViajesGuardados(IDC);
                        int Filas1 = modelo.getRowCount();
                        for (int i = 0; i < Filas1; i++) {
                            //String IDAsignaCot = tabla.getValueAt(i, 0).toString();
                            String IDCot = tabla.getValueAt(i, 0).toString();
                            String IDRuta = tabla.getValueAt(i, 1).toString();
                            String Origen = tabla.getValueAt(i, 2).toString();
                            String Destino = tabla.getValueAt(i, 3).toString();
                            String Camioneta15 = tabla.getValueAt(i, 4).toString();
                            String Camioneta35 = tabla.getValueAt(i, 5).toString();
                            String Rabon = tabla.getValueAt(i, 6).toString();
                            String Torthon = tabla.getValueAt(i, 7).toString();
                            String Trailer = tabla.getValueAt(i, 8).toString();
                            String Full = tabla.getValueAt(i, 9).toString();

                            Boolean checked = Boolean.valueOf(tabla.getValueAt(i, 10).toString());
                            
                            String sql;
                            if (checked) {
                                
                                sql = "insert guardar_cotizacion_directa(ID_GuardarCotD,IDRuta,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                                        + " values(NULL, '" + IDRuta + "','" + IDCot + "','" + Origen + "','" + Destino + "','" + Camioneta15 + "','" + Camioneta35 + "','" + Rabon + "','" + Torthon + "','" + Trailer + "','" + Full + "','1')";
                                //System.out.println("IDRuta: "+IDRuta+sql);
                                try {
                                    PreparedStatement pstm = cn.prepareStatement(sql);
                                    pstm.execute();
                                    pstm.close();

                                } catch (SQLException e) {
                                    System.out.println(e);
                                }

                            } else {
                                
                                sql = "insert guardar_cotizacion_directa(ID_GuardarCotD,IDRuta,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                                        + " values(NULL,'" + IDRuta + "','" + IDCot + "','" + Origen + "','" + Destino + "','" + Camioneta15 + "','" + Camioneta35 + "','" + Rabon + "','" + Torthon + "','" + Trailer + "','" + Full + "','0')";

                                try {
                                    PreparedStatement pstm = cn.prepareStatement(sql);
                                    pstm.execute();
                                    pstm.close();
                                //System.out.println("IDRuta: "+IDRuta+sql);
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                                               
                        
                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Viajes Guardados!");
                        AC.msj2.setText("Correctamente");
                        AC.msj3.setText("Se podran seleccionar despues");
                        AC.setVisible(true);
                        this.dispose();                    
            }else{
                Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Porfavor Marque!");
                AC.msj2.setText("Al menos un Viaje");
                AC.msj3.setText("Para poder Guardar Cotizacion");
//                System.out.println("ruta: "+sql);
                AC.setVisible(true);
            }      

            } else {
                Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Porfavor Asigne!");
                AC.msj2.setText("Al menos un Viaje");
                AC.msj3.setText("Para poder Finalizar Cotizacion");
                AC.setVisible(true);
            }

    }//GEN-LAST:event_pnlEliminar2MouseClicked

    private void pnlEliminar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminar2MouseEntered
        pnlEliminar2.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlEliminar2MouseEntered

    private void pnlEliminar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminar2MouseExited
        pnlEliminar2.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlEliminar2MouseExited

    private void pnlVistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVistaMouseClicked
     ConfigCotizacionDire VE=new ConfigCotizacionDire(null, true);
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
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);
        sorter.setRowFilter(null);
        int existe = 0;
////////////////////Verifica si no hay combos seleccionados
        if (this.tabla.getRowCount() != 0) {
            int Filas = modelo.getRowCount();
            for (int j = 0; j < Filas; j++) {
                Boolean validar = Boolean.valueOf(tabla.getValueAt(j, 10).toString());
                if (validar) {///////Verifica si existen checks seleccionados
                    existe++;
                }
            }
            if (existe > 0) {////Si existen combos palomeados, verifica la tabla adicionales
                ///////////////////////verifica si la Adicionales no esta vacia y la recorre para validar campos vacios 
                if (this.jTable1.getRowCount() != 0) {
                    int existenombre = 0;
                    int existeprecio = 0;
                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        if (jTable1.getValueAt(i, 2).toString().equals("")) {
                            existenombre++;
                        }
                        if (jTable1.getValueAt(i, 3).toString().equals("0")) {
                            existeprecio++;
                        }
                    }
                    if (existenombre == 0 ) {//////////verifica si la Adicionales no tiene campos vacios, registra datos y finaliza cotizxacion

                            int Filas1 = modelo.getRowCount();
                        for (int i = 0; i < Filas1; i++) {
                            
                            String IDCot = tabla.getValueAt(i, 0).toString();
                            String IDRuta = tabla.getValueAt(i, 1).toString();
                            String Origen = tabla.getValueAt(i, 2).toString();
                            String Destino = tabla.getValueAt(i, 3).toString();
                            String Camioneta15 = tabla.getValueAt(i, 4).toString();
                            String Camioneta35 = tabla.getValueAt(i, 5).toString();
                            String Rabon = tabla.getValueAt(i, 6).toString();
                            String Torthon = tabla.getValueAt(i, 7).toString();
                            String Trailer = tabla.getValueAt(i, 8).toString();
                            String Full = tabla.getValueAt(i, 9).toString();

                            Boolean checked = Boolean.valueOf(tabla.getValueAt(i, 10).toString());

                            String sql;
                            if (checked) {
                                sql = "insert reporte_cotizacion_directa(ID_ReporteCotD,IDRuta,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                                        + " values(NULL,'" + IDRuta + "','" + IDCot + "','" + Origen + "','" + Destino + "','" + Camioneta15 + "','" + Camioneta35 + "','" + Rabon + "','" + Torthon + "','" + Trailer + "','" + Full + "','1')";

                                try {
                                    PreparedStatement pstm = cn.prepareStatement(sql);
                                    pstm.execute();
                                    pstm.close();

                                } catch (SQLException e) {
                                    System.out.println(e);
                                }

                            } else {
                                sql = "insert reporte_cotizacion_directa(ID_ReporteCotD,IDRuta,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                                        + " values(NULL,'" + IDRuta + "','" + IDCot + "','" + Origen + "','" + Destino + "','" + Camioneta15 + "','" + Camioneta35 + "','" + Rabon + "','" + Torthon + "','" + Trailer + "','" + Full + "','0')";

                                try {
                                    PreparedStatement pstm = cn.prepareStatement(sql);
                                    pstm.execute();
                                    pstm.close();

                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                    String ID_Cotizacion = IDCotizacion.getText();
                    Ventanas.Modulo_Cotizaciones_Mensual.Opciones.finalizarCotizacion(ID_Cotizacion);
                    Ventanas.Modulo_Cotizaciones_Mensual.Opciones.listarCotizaciones("");
                    ver(ID_Cotizacion); 
                    this.dispose();
                    Opciones.eliminarViajesGuardados(ID_Cotizacion);///////Este metodo sirve para evitar repetir viajes guardados en la bd
                    }                  
                    else {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                          AC.msj1.setText("¡Campos Vacios!");
                          AC.msj2.setText(" Porfavor asigne Nombre  ");
                          AC.msj3.setText("del Adicional y sus respectivos precios");                                    
                          AC.setVisible(true);
                    }

                } else {
                    ////////Si la tabla1 esta vacia, se le pregunta al cliente, si desea finalizar cotizacion 
                    //////sin agregar ningun servicio, todo esto mediante este metodo
                    //this.setVisible(false);
                    String IDCot="";
                    int Filas1 = modelo.getRowCount();
                        for (int i = 0; i < 1; i++) {
                            IDCot = tabla.getValueAt(i, 0).toString();
                            
                        }
                    finalizar(IDCot,Filas1);

                    //JOptionPane.showMessageDialog(null,"Finaliza directo");
                }

            }else{
                    Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Porfavor Seleccione!");
                AC.msj2.setText("Al menos un Viaje");
                AC.msj3.setText("Para poder Finalizar Cotizacion");
                AC.setVisible(true);
            }      
            
            

            } else {
                Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Porfavor Asigne!");
                AC.msj2.setText("Al menos un Viaje");
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

        String  IDCotiza=IDCotizacion.getText();

    if(this.tabla.getRowCount()!=0){
        if(this.jTable1.getRowCount()==0){ /////Si tabla1 esta vacia, se agrega el primer campo       
        cargarServicio();
        int ID_Cotizacion;
        ID_Cotizacion=Integer.parseInt(AgregarCotizaciones1.IDCotizacion.getText());        
        Ventanas.Modulo_Cotizaciones.Opciones.llenarServicio(ID_Cotizacion);
        this.jTable1.getSelectionModel().setSelectionInterval(0,0);

        }else{//////////Si tabla1 esta llena, recorrerla para validar campos vacios
            int existenombre = 0;
            int existeprecio = 0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
//                 if(jTable1.getValueAt(i, 2).toString().equals("")){
//                     existenombre++;
//                 }                                 
//                 if(jTable1.getValueAt(i, 3).toString().equals("0")){
//                     existeprecio++;
//                 }                                 
        }
            if(existenombre==0){////////Si ningun campo esta vacio, se puede agregar otro nuevo campo
                cargarServicio();
                int ID_Cotizacion;
                ID_Cotizacion = Integer.parseInt(AgregarCotizaciones1.IDCotizacion.getText());
                Opciones.llenarServicio(ID_Cotizacion);
//                this.tabla1.getSelectionModel().setSelectionInterval(0, 0);                
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
                                AC.msj1.setText("¡Porfavor Asigne!");
                                AC.msj2.setText("Viajes");
                                AC.msj3.setText("Para poder Asignar Adicionales");
                                AC.setVisible(true);
        }
     

        
        
//      
    }//GEN-LAST:event_pnleditarMouseClicked

    private void pnleditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseEntered
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnleditarMouseEntered

    private void pnleditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseExited
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnleditarMouseExited

    private void cmbOrigenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrigenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrigenesActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
    
//        int press=evt.getKeyCode();        
//        if(this.tabla.getSelectedRow()!=-1 && press==127 ){
//            int ID_Cotizacion;
//            //ID_Cotizacion = Integer.parseInt(AgregarCotizaciones_Renta.IDCotizacion.getText());
//            int a1 = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
//            
//            /////Remover datos de la tabla sin modificar bd
//            DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
//            modelo.removeRow(tabla.getSelectedRow());
//            //this.tabla.getSelectionModel().setSelectionInterval(0, 0);
//
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
////        buscar.setText("");    
//        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();
//      final TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
//      tabla.setRowSorter(sorter);
//          sorter.setRowFilter(null);
//        
      

    }//GEN-LAST:event_tablaMouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        int press=evt.getKeyCode();        
        if(this.jTable1.getSelectedRow()!=-1 && press==127 ){
            int ID_Cotizacion;
            ID_Cotizacion = Integer.parseInt(AgregarCotizaciones1.IDCotizacion.getText());
            int a1 = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            //DefaultTableModel modelo = (DefaultTableModel) this.tabla1.getModel();
            Ventanas.Modulo_Cotizaciones_Mensual.Opciones.eliminarServicio(a1);
            Ventanas.Modulo_Cotizaciones.Opciones.llenarServicio(ID_Cotizacion);
            this.jTable1.getSelectionModel().setSelectionInterval(0, 0);

        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void pnlAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAyudaMouseClicked

        ConfigCotizacionD poper =new Ventanas.CotizacionReporte.ConfigCotizacionD(null, true);
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
                AgregarCotizaciones1 dialog = new AgregarCotizaciones1(new javax.swing.JFrame(), true);
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
    public static javax.swing.JLabel IDCotizacion1;
    private javax.swing.JLabel ID_rutas;
    public static app.bolivia.swing.JCTextField buscar;
    private ComboBox.SComboBox cmbCliente;
    private ComboBox.SComboBox cmbOrigenes;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    public static jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JSeparator l2;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombreNuevo17;
    private javax.swing.JLabel lblatencion;
    private javax.swing.JPanel pnlAyuda;
    private javax.swing.JPanel pnlEliminar2;
    private javax.swing.JPanel pnlFinalizar;
    private javax.swing.JPanel pnlVista;
    private javax.swing.JPanel pnleditar;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
public void ver(String ID) {
    
        Clases.Conexion cc = new Clases.Conexion();
        int ID1 = Integer.parseInt(ID);
        if (ID1 >= 0) {

       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            //String archivo = "src/Consultas/CotizacionD_1_1.jasper";
            //ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //Ser
            String archivo = "/Consultas/CotizacionD_1_1.jasper";
            //String subreportePath = sc.getRealPath("/Consultas/");
            String subreportePath = "\\Consultas\\";
            
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(archivo));            
            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("logo", this.getClass().getResourceAsStream("/Consultas/reporte.png"));
            
            parametro.put("SUBREPORT_DIR", subreportePath);
            //parametro.put("SUBREPORT_DIR", subreportePath);
            //parametro.put("SUBREPORT_DIR", subreportePath);
            parametro.put("ID_Cotizacion", ID1);
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
