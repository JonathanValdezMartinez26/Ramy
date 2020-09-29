package Ventanas.Modulo_Cliente;

import A_tabla.EstiloTablaHeader1;
import A_tabla.EstiloTablaRenderer1;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import static Alerts.AlertBasic.AgregarDestinos.ID;
import Alerts.FadeEffect;
import Clases.Clientes;
import Clases.Conexion;
//import Clases.EditarClienteCamioneta15;
import Clases.MyTableCellEditor;
import Clases.database;
import Clases.estados;
import Clases.localidades;
import Clases.municipios;
import MyTableCellEditor.EditarClienteCamioneta15;
import MyTableCellEditor.EditarClienteCamioneta35;
import MyTableCellEditor.EditarClienteFull;
import MyTableCellEditor.EditarClienteRabon;
import MyTableCellEditor.EditarClienteTorthon;
import MyTableCellEditor.EditarClienteTrailer;
import static Ventanas.Modulo_Cliente.Opciones.*;
import static Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.IDCotizacion;
import static Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import static Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tabla1;
import static configInicio.Configuracion.txtEmail;
import static configInicio.Configuracion.txtNombre;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import static Ventanas.Modulo_Cliente.pnlClientes.tabla1;



public class Registrar extends javax.swing.JDialog {

    private boolean minimiza = false;

    int x, y;
    boolean res = true;
    String ed = "";
    Font fuente = new Font("Tahoma", 1, 11);
    Font fuente1 = new Font("Tahoma", 0, 14);
    int  MunicipioItem = 0;
    int ID;
    ResultSet resultado;
    int ID_Tran [];
    int ID_Ori [];
    int ID_Des [];
    public int id=0;
    //////////////////
    private database db = new database();
    private Object[][] dtOD;
    
    public Registrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        this.setLocationRelativeTo(parent);
        FadeEffect.fadeIn(this, 1, 0.1f);
        ocultarAciertos();
        lblIDOrigen.setVisible(false);
        ID_C.setVisible(false);
        
        ///////////////////////////
//        ID_C.setVisible(false);
        
        estados cc = new estados();
        DefaultComboBoxModel modelEstado = new DefaultComboBoxModel(cc.mostrarEstados());
        cmbEstado.setModel(modelEstado);
        cmbEstado1.setModel(modelEstado);
        ///////////////////////////
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla2.getColumnModel().getColumn(0).setMinWidth(0);
        tabla2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla2.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
//        
        tabla3.getColumnModel().getColumn( 5 ).setCellEditor(new EditarClienteCamioneta15(db,"CAMIONETA 1.5 TON"));
        tabla3.getColumnModel().getColumn( 6 ).setCellEditor(new EditarClienteCamioneta35(db,"CAMIONETA 3.5 TON"));
        tabla3.getColumnModel().getColumn( 7 ).setCellEditor(new EditarClienteRabon(db,"RABÓN"));
        tabla3.getColumnModel().getColumn( 8 ).setCellEditor(new EditarClienteTorthon(db,"TORTHON"));
        tabla3.getColumnModel().getColumn( 9 ).setCellEditor(new EditarClienteTrailer(db,"TRÁILER"));
        tabla3.getColumnModel().getColumn( 10 ).setCellEditor(new EditarClienteFull(db,"FULL"));
        
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader1());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer1());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        tabla2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla2.getTableHeader().setDefaultRenderer(new EstiloTablaHeader1());
        this.tabla2.setDefaultRenderer(Object.class, new EstiloTablaRenderer1());
        this.tabla2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        tabla3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla3.getTableHeader().setDefaultRenderer(new EstiloTablaHeader1());
        this.tabla3.setDefaultRenderer(Object.class, new EstiloTablaRenderer1());
        this.tabla3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        /////////////////////
        
            
            
        
        
    }
    public static void validar(int ID){
        
            
            //Opciones.verificaViaje(int ID);
//            if(existe==0){
//                cmbDestinos.addItem("Todos los Destinos");
//            }else{
//                JOptionPane.showMessageDialog(null, "Las filas son: "+existe);
//                cmbDestinos.addItem("------------------");
//            }

    }
    ////////////////////////////////////////////////////////////////////////////
    public void listar(int ID)
    {
        Opciones.listarOrigen(null, ID);
        Opciones.listarDestino(null, ID);        
        Opciones.listarViaje("", ID);
    }
    
    /////////////////////////////
    private void Actualizar_Tabla(){
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        int id=74;
        String[] columNames = {"ID_Ruta" ,"Origen","Destino","Transporte","Precio"};        
        dtOD = db.Select_OD(id);
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtOD,columNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return column == 4;
            }
        };
        tabla3.setModel(datos);
}
    
    
    ////////////////////////////////////////////////////////////////////////////
    public void Guardar(){
        int comboEstado = cmbEstado.getSelectedIndex();
        int comboMunicipio = cmbMunicipio.getSelectedIndex();
        
        
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
                    if(comboMunicipio==0 || comboEstado==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Seleccione un!");
                        AC.msj2.setText("Estado y un Municipio");
                        AC.setVisible(true);
                    }
                    else
                    {
                        ID = Integer.parseInt(ID_C.getText());
                        if(Ventanas.Modulo_Cliente.Opciones.verificaOrigen(ID, MunicipioItem)==0)
                        {
                            Clientes.Agregar_Origen(ID,  MunicipioItem);
                            Opciones.listarOrigen(null, ID);
                            this.cmbMunicipio.setSelectedIndex(0);
                        }
                        else
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Error!");
                            AC.msj2.setText("El Estado y Municipio");
                            AC.msj3.setText("ya estan Registrados");
                            AC.setVisible(true);
                            this.cmbMunicipio.setSelectedIndex(0);
                        }
                    }
                }
            }
        
        
    }
    ////////////////////////////////////////////////////////////////////////////
    public void Guardar1(){
        int comboEstado = cmbEstado1.getSelectedIndex();
        int comboMunicipio = cmbMunicipio1.getSelectedIndex();
        
        
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
                    if(comboMunicipio==0 || comboEstado==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Seleccione un!");
                        AC.msj2.setText("Estado y un Municipio");
                        AC.setVisible(true);
                    }
                    else
                    {
                        ID = Integer.parseInt(ID_C.getText());
                        if(Ventanas.Modulo_Cliente.Opciones.verificaDestino(ID, MunicipioItem)==0)
                        {
                            Clientes.Agregar_Destino(ID,  MunicipioItem);
                            Opciones.listarDestino(null, ID);
                            this.cmbMunicipio1.setSelectedIndex(0);
                        }
                        else
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Error!");
                            AC.msj2.setText("El Estado y Municipio");
                            AC.msj3.setText("ya estan Registrados");
                            AC.setVisible(true);
                            this.cmbMunicipio1.setSelectedIndex(0);
                        }
                    }
                }
            }
        
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void ComboTransportes()
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
                int i = 1;

                try
                {
                    resultado = Conexion.consulta("Select ID_Transporte, Nombre_Transporte from transportes");

                    while(resultado.next())
                    {
                        ID_Tran [i] = resultado.getInt(1);
                        //cmbTransportes.addItem(resultado.getString(2).trim());
                        i++;
                    }
                }
                catch(SQLException ex)
                {

                }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void ComboOrigen(int ID)
    {
        int ID_Origen = 0;

          try
            {
                resultado = Conexion.consulta("Select Max(ID_Origen) from origenvv");

                while(resultado.next())
                {
                    ID_Origen = resultado.getInt(1);
                }
            }
            catch(SQLException ex)
            {

            }

                ID_Origen++;
                ID_Ori = new int[ID_Origen];

                ID_Ori [0] = 0; 
                int i = 1;

                try
                {
                  
                    resultado = Conexion.consulta("Select ID_Origen, Origen from origenvv where ID_Cliente ="+ID);

                    while(resultado.next())
                    {
                        ID_Ori [i] = resultado.getInt(1);
                        cmbOrigenes.addItem(resultado.getString(2).trim());
                        i++;
                    }
                }
                catch(SQLException ex)
                {

                }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void ComboDestino(int ID)
    {
        int ID_Destino = 0;

          try
            {
                resultado = Conexion.consulta("Select Max(ID_Destino) from destinovv");

                while(resultado.next())
                {
                    ID_Destino = resultado.getInt(1);
                }
            }
            catch(SQLException ex)
            {

            }

                ID_Destino++;
                ID_Des = new int[ID_Destino];

                ID_Des [0] = 0; 
                /////empezar a partir del item no.2
                int i = 2;

                try
                {
                    resultado = Conexion.consulta("Select ID_Destino, Destino from destinovv where ID_Cliente ="+ID);

                    while(resultado.next())
                    {
                        ID_Des [i] = resultado.getInt(1);
                        cmbDestinos.addItem(resultado.getString(2).trim());
                        i++;
                    }
                }
                catch(SQLException ex)
                {

                }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void ComboDestinoNormal(int ID)
    {
        int ID_Destino = 0;

          try
            {
                resultado = Conexion.consulta("Select Max(ID_Destino) from destinovv");

                while(resultado.next())
                {
                    ID_Destino = resultado.getInt(1);
                }
            }
            catch(SQLException ex)
            {

            }

                ID_Destino++;
                ID_Des = new int[ID_Destino];

                ID_Des [0] = 0; 
                /////empezar a partir del item no.2
                int i = 1;

                try
                {
                    resultado = Conexion.consulta("Select ID_Destino, Destino from destinovv where ID_Cliente ="+ID);

                    while(resultado.next())
                    {
                        ID_Des [i] = resultado.getInt(1);
                        cmbDestinos.addItem(resultado.getString(2).trim());
                        i++;
                    }
                }
                catch(SQLException ex)
                {

                }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void GuardarOD(){
//        int comboTransporte = cmbTransportes.getSelectedIndex();
        //int ID_Transporte = ID_Tran[comboTransporte];
        int comboOrigen = cmbOrigenes.getSelectedIndex();
        int ID_Origen = ID_Ori[comboOrigen];
        int comboDestino = cmbDestinos.getSelectedIndex();
        int ID_Destino = ID_Des[comboDestino];
        
        //JOptionPane.showMessageDialog(null, "ID_Transporte: " + ID_Transporte);
        
                if(comboOrigen==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Elija un !");
                        AC.msj2.setText("Origen válido");
                        AC.setVisible(true);
                    }
                else
                {
                    if(comboDestino == 0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Elija un !");
                        AC.msj2.setText("Destino válido");
                        AC.setVisible(true);
                    }
                    else
                    {
                        if(comboOrigen==0 || comboDestino==0)
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Seleccione un!");
                            AC.msj2.setText("Origen y Destino");
                            AC.setVisible(true);
                        }
                        else
                        {
                            
                            lblIDOrigen.setText(""+ID_Origen);
                            ID = Integer.parseInt(ID_C.getText());
                            if(Ventanas.Modulo_Cliente.Opciones.verificaRutaCotizacion(ID,ID_Origen, ID_Destino)==0)
                            {
                                  
                                //Clientes.Agregar_Ruta(ID, ID_Origen, ID_Destino, 0, ID_Transporte);
                                Opciones.AgregarRuta(ID, ID_Origen, ID_Destino);
                                Opciones.listarViaje("", ID);
                                    
//                                  this.cmbTransportes.setSelectedIndex(0);
//                                this.cmbOrigenes.setSelectedIndex(0);
                                  this.cmbDestinos.setSelectedIndex(0);
                            }
                            else
                            {
                                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                
                                AC.msj1.setText("¡El Origen y Destino!");
                                AC.msj2.setText("ya estan Registrados");
                                AC.setVisible(true);
                                this.cmbMunicipio1.setSelectedIndex(0);
                            }
                        }
                    }
                }
            
        
        
    }
    ////////////////////////////////////////////////////////////////////////////
     private void ocultarAciertos() {
        

        //Limpia campos del nivel UNO
        this.cmbEstado.setSelectedIndex(0);
        this.cmbMunicipio.setSelectedIndex(0);
        
        
//        Limpia campos del nivel TRES

//        focusNivel1();
    }
     public void confirmarEliminar(String IDRuta,String IDCliente){
         Alerts.AlertBasic.WarningEliminarViaje AC = new Alerts.AlertBasic.WarningEliminarViaje(null, true);
         AC.ID.setText(IDRuta);
         AC.IDC.setText(IDCliente);
         AC.setVisible(true);    
     }
 
//    private void focusNivel1()
//    {
//        this.cmbEstado.setNextFocusableComponent(cmbMunicipio);
//    }
    private void focusNivel2()
    {
//        this.cmbEstado.setSelectedIndex(0);
//        this.cmbDestinos.setSelectedIndex(0);
//        this.cmbTransportes.setSelectedIndex(0);
    }
    private void focusNivel3()
    {
//        this.cmbEstado.setSelectedIndex(0);
//        this.cmbDestinos.setSelectedIndex(0);
//        this.cmbTransportes.setSelectedIndex(0);
    }
//    public static void setSelectedIndex(int index) { 
//        int index;
//    if (!cmbDestinos.contains(index)) { 
//     super.setSelectedIndex(index); 
//    } 
//} 
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        lblNombreNuevo17 = new javax.swing.JLabel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        rSButtonMetro3 = new JButtonEspecial.JButtonEspecial();
        barra_estado = new javax.swing.JPanel();
        a3 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        ID_C = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        PanelDesliza = new rojerusan.RSPanelsSlider();
        A = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmbEstado = new ComboBox.SComboBox();
        cmbMunicipio = new ComboBox.SComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new JButtonEspecial.JButtonEspecial();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        log1 = new JButtonEspecial.JButtonEspecial();
        B = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmbEstado1 = new ComboBox.SComboBox();
        cmbMunicipio1 = new ComboBox.SComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new JButtonEspecial.JButtonEspecial();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        log3 = new JButtonEspecial.JButtonEspecial();
        C = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbOrigenes = new ComboBox.SComboBox();
        cmbDestinos = new ComboBox.SComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        lblIDOrigen = new javax.swing.JLabel();
        buscarViaje = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton33 = new JButtonEspecial.JButtonEspecial();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        log4 = new JButtonEspecial.JButtonEspecial();
        log5 = new JButtonEspecial.JButtonEspecial();
        D = new javax.swing.JPanel();
        log8 = new JButtonEspecial.JButtonEspecial();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        l1 = new javax.swing.JSeparator();

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

        lblNombreNuevo17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreNuevo17.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreNuevo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreNuevo17.setText("     Clientes > Ata Origen, Destinos y Asignación");
        jPanel7.add(lblNombreNuevo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 850, 30));

        rSButtonMetro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ayuda20.png"))); // NOI18N
        rSButtonMetro2.setToolTipText("Ayuda");
        rSButtonMetro2.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro2.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro2.setColorPressed(new java.awt.Color(136, 0, 0));
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 0, 30, 30));

        rSButtonMetro3.setText("X");
        rSButtonMetro3.setToolTipText("Cerrar");
        rSButtonMetro3.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro3.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro3.setColorPressed(new java.awt.Color(136, 0, 0));
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        jPanel7.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 0, 30, 30));

        jcMousePanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 12, 944, -1));

        barra_estado.setBackground(new java.awt.Color(255, 255, 255));
        barra_estado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        a3.setText("Origenes.");
        barra_estado.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 36, 310, 20));

        a2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 15)); // NOI18N
        a2.setText("Bienvenido al asistente de Configuración");
        barra_estado.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 270, -1));

        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/asistente+.png"))); // NOI18N
        barra_estado.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 50));

        ID_C.setText("0");
        barra_estado.add(ID_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        a5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 15)); // NOI18N
        a5.setText("para el alta de");
        barra_estado.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 37, 110, -1));

        jcMousePanel1.add(barra_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 760, -1));

        A.setBackground(new java.awt.Color(255, 255, 255));
        A.setName("A"); // NOI18N
        A.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Estado" }));
        cmbEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 30));

        cmbMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Municipio" }));
        cmbMunicipio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMunicipioItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 230, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 10));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 220, 30));

        A.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 60));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Origen", "Estado de Origen", "Municipio de Origen", "Fecha Alta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(20);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tabla);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        A.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 900, 320));

        jLabel1.setText("Seleccione un Origen y Posteriormente un Destino ");
        A.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, -1));

        log1.setBackground(new java.awt.Color(204, 204, 204));
        log1.setForeground(new java.awt.Color(128, 128, 131));
        log1.setText("Siguiente");
        log1.setColorHover(new java.awt.Color(204, 204, 204));
        log1.setColorNormal(new java.awt.Color(204, 204, 204));
        log1.setColorPressed(new java.awt.Color(153, 153, 153));
        log1.setColorTextHover(new java.awt.Color(128, 128, 131));
        log1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log1ActionPerformed(evt);
            }
        });
        A.add(log1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        PanelDesliza.add(A, "card2");

        B.setBackground(new java.awt.Color(255, 255, 255));
        B.setName("B"); // NOI18N
        B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEstado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Estado" }));
        cmbEstado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbEstado1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstado1ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 30));

        cmbMunicipio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Municipio" }));
        cmbMunicipio1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbMunicipio1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMunicipio1ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMunicipio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 230, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 880, 10));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setForeground(new java.awt.Color(128, 128, 131));
        jButton2.setText("Aceptar");
        jButton2.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton2.setColorHover(new java.awt.Color(204, 204, 204));
        jButton2.setColorNormal(new java.awt.Color(204, 204, 204));
        jButton2.setColorPressed(new java.awt.Color(153, 153, 153));
        jButton2.setColorTextHover(new java.awt.Color(128, 128, 131));
        jButton2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 220, 30));

        B.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 60));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Origen", "Estado de Destino", "Municipio de Destino", "Fecha Alta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla2.setRowHeight(20);
        tabla2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        B.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 900, 320));

        jLabel2.setText("Seleccione un Estado y Posteriormente un Municipio para agregar un Destino");
        B.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, -1));

        log2.setBackground(new java.awt.Color(204, 204, 204));
        log2.setForeground(new java.awt.Color(128, 128, 131));
        log2.setText("Atras");
        log2.setColorHover(new java.awt.Color(204, 204, 204));
        log2.setColorNormal(new java.awt.Color(204, 204, 204));
        log2.setColorPressed(new java.awt.Color(153, 153, 153));
        log2.setColorTextHover(new java.awt.Color(128, 128, 131));
        log2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log2ActionPerformed(evt);
            }
        });
        B.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        log3.setBackground(new java.awt.Color(204, 204, 204));
        log3.setForeground(new java.awt.Color(128, 128, 131));
        log3.setText("Siguiente");
        log3.setColorHover(new java.awt.Color(204, 204, 204));
        log3.setColorNormal(new java.awt.Color(204, 204, 204));
        log3.setColorPressed(new java.awt.Color(153, 153, 153));
        log3.setColorTextHover(new java.awt.Color(128, 128, 131));
        log3.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log3ActionPerformed(evt);
            }
        });
        B.add(log3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        PanelDesliza.add(B, "card3");

        C.setBackground(new java.awt.Color(255, 255, 255));
        C.setName("C"); // NOI18N
        C.setPreferredSize(new java.awt.Dimension(950, 445));
        C.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbOrigenes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Origen" }));
        cmbOrigenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrigenes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrigenesItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbOrigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 30));

        cmbDestinos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Destino" }));
        cmbDestinos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDestinos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDestinosItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbDestinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 290, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 900, 10));

        lblIDOrigen.setText("0");
        jPanel3.add(lblIDOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 10, 20));

        buscarViaje.setBorder(null);
        buscarViaje.setForeground(new java.awt.Color(0, 144, 183));
        buscarViaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarViaje.setPlaceholder("BUSCAR POR VIAJE");
        buscarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarViajeActionPerformed(evt);
            }
        });
        buscarViaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarViajeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarViajeKeyTyped(evt);
            }
        });
        jPanel3.add(buscarViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 145, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 210, -1));

        jButton33.setBackground(new java.awt.Color(204, 204, 204));
        jButton33.setForeground(new java.awt.Color(128, 128, 131));
        jButton33.setText("Aceptar");
        jButton33.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton33.setColorHover(new java.awt.Color(204, 204, 204));
        jButton33.setColorNormal(new java.awt.Color(204, 204, 204));
        jButton33.setColorPressed(new java.awt.Color(153, 153, 153));
        jButton33.setColorTextHover(new java.awt.Color(128, 128, 131));
        jButton33.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 220, 30));

        C.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 120));

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Ruta", "ID_Origen", "Origen", "ID_Destino", "Destino", "Camioneta 1.5", "Camioneta 3.5", "Rabon", "Torthon", "Trailer", "Full"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla3.setColumnSelectionAllowed(true);
        tabla3.setRowHeight(25);
        tabla3.getTableHeader().setReorderingAllowed(false);
        tabla3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabla3);
        tabla3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabla3.getColumnModel().getColumnCount() > 0) {
            tabla3.getColumnModel().getColumn(0).setMinWidth(0);
            tabla3.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla3.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla3.getColumnModel().getColumn(1).setMinWidth(0);
            tabla3.getColumnModel().getColumn(1).setPreferredWidth(0);
            tabla3.getColumnModel().getColumn(1).setMaxWidth(0);
            tabla3.getColumnModel().getColumn(3).setMinWidth(0);
            tabla3.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla3.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla3.getColumnModel().getColumn(5).setMinWidth(120);
            tabla3.getColumnModel().getColumn(5).setPreferredWidth(120);
            tabla3.getColumnModel().getColumn(5).setMaxWidth(120);
            tabla3.getColumnModel().getColumn(6).setMinWidth(120);
            tabla3.getColumnModel().getColumn(6).setPreferredWidth(120);
            tabla3.getColumnModel().getColumn(6).setMaxWidth(120);
            tabla3.getColumnModel().getColumn(7).setMinWidth(70);
            tabla3.getColumnModel().getColumn(7).setPreferredWidth(70);
            tabla3.getColumnModel().getColumn(7).setMaxWidth(70);
            tabla3.getColumnModel().getColumn(8).setMinWidth(90);
            tabla3.getColumnModel().getColumn(8).setPreferredWidth(90);
            tabla3.getColumnModel().getColumn(8).setMaxWidth(90);
            tabla3.getColumnModel().getColumn(9).setMinWidth(70);
            tabla3.getColumnModel().getColumn(9).setPreferredWidth(70);
            tabla3.getColumnModel().getColumn(9).setMaxWidth(70);
            tabla3.getColumnModel().getColumn(10).setMinWidth(70);
            tabla3.getColumnModel().getColumn(10).setPreferredWidth(70);
            tabla3.getColumnModel().getColumn(10).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        C.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 900, 260));

        jLabel3.setText("Seleccione un Estado y Posteriormente un Municipio");
        C.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, -1));

        log4.setBackground(new java.awt.Color(204, 204, 204));
        log4.setForeground(new java.awt.Color(128, 128, 131));
        log4.setText("Guardar");
        log4.setColorHover(new java.awt.Color(204, 204, 204));
        log4.setColorNormal(new java.awt.Color(204, 204, 204));
        log4.setColorPressed(new java.awt.Color(153, 153, 153));
        log4.setColorTextHover(new java.awt.Color(128, 128, 131));
        log4.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log4ActionPerformed(evt);
            }
        });
        C.add(log4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        log5.setBackground(new java.awt.Color(204, 204, 204));
        log5.setForeground(new java.awt.Color(128, 128, 131));
        log5.setText("Atras");
        log5.setColorHover(new java.awt.Color(204, 204, 204));
        log5.setColorNormal(new java.awt.Color(204, 204, 204));
        log5.setColorPressed(new java.awt.Color(153, 153, 153));
        log5.setColorTextHover(new java.awt.Color(128, 128, 131));
        log5.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log5ActionPerformed(evt);
            }
        });
        C.add(log5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        PanelDesliza.add(C, "card4");

        D.setBackground(new java.awt.Color(255, 255, 255));
        D.setName("D"); // NOI18N
        D.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DFocusGained(evt);
            }
        });
        D.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        log8.setBackground(new java.awt.Color(204, 204, 204));
        log8.setForeground(new java.awt.Color(128, 128, 131));
        log8.setText("Terminar");
        log8.setColorHover(new java.awt.Color(204, 204, 204));
        log8.setColorNormal(new java.awt.Color(204, 204, 204));
        log8.setColorPressed(new java.awt.Color(153, 153, 153));
        log8.setColorTextHover(new java.awt.Color(128, 128, 131));
        log8.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log8ActionPerformed(evt);
            }
        });
        D.add(log8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

        jLabel49.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 144, 183));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acheckmark.gif"))); // NOI18N
        D.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 750, 230));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Actualizamos la base de datos con tu información.");
        D.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 750, 40));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 144, 183));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("¡Registro Exitoso!");
        D.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 50));

        PanelDesliza.add(D, "card5");

        jcMousePanel1.add(PanelDesliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 130, 920, 470));
        jcMousePanel1.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 120, 903, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        Ventanas.CotizacionReporte.ConfigCotizacionViaje poper =new Ventanas.CotizacionReporte.ConfigCotizacionViaje(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            estados est = (estados) cmbEstado.getSelectedItem();
            municipios mun = new municipios();
            DefaultComboBoxModel modelMunicipio = new DefaultComboBoxModel(mun.mostrarMunicipio(est.getId()));
            cmbMunicipio.setModel(modelMunicipio);
        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void cmbMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMunicipioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            municipios mun = (municipios) cmbMunicipio.getSelectedItem();
            MunicipioItem = mun.getId();
        }
    }//GEN-LAST:event_cmbMunicipioItemStateChanged

    private void log1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log1ActionPerformed
        ID = Integer.parseInt(ID_C.getText());
        if(Opciones.verificaOrigen1(ID) == 0)
        {
            JOptionPane.showMessageDialog(null, ""+ ID );
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error!");
            AC.msj2.setText("No puede Avanzar");
            AC.msj3.setText("registre un Origen");
            AC.setVisible(true);
        }
        else
        {
            PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a3.setText("Destinos.");
        }
    }//GEN-LAST:event_log1ActionPerformed

    private void cmbEstado1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstado1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            estados est = (estados) cmbEstado1.getSelectedItem();
            municipios mun = new municipios();
            DefaultComboBoxModel modelMunicipio = new DefaultComboBoxModel(mun.mostrarMunicipio(est.getId()));
            cmbMunicipio1.setModel(modelMunicipio);
        }
    }//GEN-LAST:event_cmbEstado1ItemStateChanged

    private void cmbMunicipio1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMunicipio1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            municipios mun = (municipios) cmbMunicipio1.getSelectedItem();
            MunicipioItem = mun.getId();
        }
    }//GEN-LAST:event_cmbMunicipio1ItemStateChanged

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        PanelDesliza.setPanelSlider(2, A, RSPanelsSlider.DIRECT.RIGHT);
        a3.setText("Origenes.");
    }//GEN-LAST:event_log2ActionPerformed

    private void log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log3ActionPerformed
        if(Opciones.verificaDestino(ID, MunicipioItem) == 0)
        {
            PanelDesliza.setPanelSlider(2, C, RSPanelsSlider.DIRECT.RIGHT);
            a3.setText("Asignación a Servicios.");            
            ComboTransportes();

            cmbOrigenes.removeAllItems();
            cmbOrigenes.addItem("Seleccione un Origen");
            ComboOrigen(ID);

            cmbDestinos.removeAllItems();
            cmbDestinos.addItem("Seleccione un Destino");
            ComboDestino(ID);
        }
        else
        {
            PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a3.setText("Destinos.");
        }
    }//GEN-LAST:event_log3ActionPerformed

    private void cmbOrigenesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrigenesItemStateChanged
        
        int comboOrigen = cmbOrigenes.getSelectedIndex();
        int ID_Origen = ID_Ori[comboOrigen];
        lblIDOrigen.setText(""+ID_Origen);
        
    }//GEN-LAST:event_cmbOrigenesItemStateChanged

    private void cmbDestinosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDestinosItemStateChanged

    if (evt.getStateChange() == ItemEvent.SELECTED) {
        //cmbDestinos.removeItem("Todos los Destinos");
        //setSelectedIndex(1);
       
    }
        
    }//GEN-LAST:event_cmbDestinosItemStateChanged

    private void log4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log4ActionPerformed
        PanelDesliza.setPanelSlider(2, D, RSPanelsSlider.DIRECT.RIGHT);
        barra_estado.setVisible(false);
        l1.setVisible(false);
    }//GEN-LAST:event_log4ActionPerformed

    private void log5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log5ActionPerformed
        PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
        a3.setText("Destinos.");
    }//GEN-LAST:event_log5ActionPerformed

    private void log8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log8ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log8ActionPerformed

    private void DFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DFocusGained

    }//GEN-LAST:event_DFocusGained

    private void buscarViajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarViajeKeyReleased
        int IDCliente = Integer.parseInt(ID_C.getText());
        Opciones.listarViaje(Registrar.buscarViaje.getText(),IDCliente);
    }//GEN-LAST:event_buscarViajeKeyReleased

    private void buscarViajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarViajeKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarViajeKeyTyped

    private void buscarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarViajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarViajeActionPerformed

    private void tabla3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla3KeyPressed

        int press=evt.getKeyCode();        
        if(this.tabla3.getSelectedRow()!=-1 && press==127 ){
            String IDRuta =tabla3.getValueAt(tabla3.getSelectedRow(), 0).toString();            
            String IDCliente=ID_C.getText();           
            confirmarEliminar(IDRuta,IDCliente);
        }
             if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
            {
               evt.setKeyCode(java.awt.event.KeyEvent.VK_TAB);
               {
                   
               }
            }
             
    }//GEN-LAST:event_tabla3KeyPressed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        String Destinos = (String) cmbDestinos.getSelectedItem();        
        String Origenes = (String) cmbOrigenes.getSelectedItem();
        int indexOrigen=cmbOrigenes.getSelectedIndex();
        int indexDestino=cmbDestinos.getSelectedIndex();
        int existe=0;
        int existeOrigen=0;
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla3.getModel();
        int Filas1 = modelo.getRowCount();
        
        if(Destinos.equals("Todos los Destinos"))
        {       
            if(indexOrigen!=0){
                try {
                    int IDOrigen = Integer.parseInt(lblIDOrigen.getText());
                    int IDCliente = Integer.parseInt(ID_C.getText());
                    resultado = Conexion.consulta("SELECT ID_Destino from destino where (ID_Cliente = " + IDCliente + ")");
                    int ID = 0;
                    while (resultado.next()) {
                        ID = resultado.getInt(1);
                        
                        if (Ventanas.Modulo_Cliente.Opciones.verificaRutaCotizacion(IDCliente, IDOrigen, ID) == 0) {
                        String q = " INSERT INTO ruta (ID_Ruta,ID_Cliente,ID_Origen,ID_Destino,PCamioneta_1_5,PCamioneta_3_5,Rabon,Torthon,Trailer,Full)"
                                     + "VALUES (NULL,'" + IDCliente + "','" + IDOrigen + "','" + ID + "',0,0,0,0,0,0)";
                            try {
                                PreparedStatement pstm = cn.prepareStatement(q);
                                pstm.execute();
                                pstm.close();

                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                        } else {
                            existe++;
                        }
                    }
                    if (existe == 0) {
                        Opciones.listarViaje("", IDCliente);
                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Origen y Destinos!");
                        AC.msj2.setText("Han sido registrados");
                        AC.setVisible(true);
                        
                    } else {
                        Opciones.listarViaje("", IDCliente);
                        
                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Origen y Destinos!");
                        AC.msj2.setText("Han sido registrados");
                        AC.setVisible(true);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);

                }
//            }
            }else{
                       Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Seleccione!");
                        AC.msj2.setText("Origen");
                        AC.msj3.setText("Para Agregar Viajes");
                        AC.setVisible(true);
   
            }
                    
        
                        }else{
            
                        if(indexDestino!=0 && indexOrigen!=0){
                        GuardarOD();
                        
//                        int IDC = Integer.parseInt(ID_C.getText());
//                        Opciones.listarViaje("", IDC);
                        }else{
                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Seleccione!");
                        AC.msj2.setText("Origen y Destinos");
                        AC.msj3.setText("Para Agregar Viajes");
                        AC.setVisible(true);
                        }
                    }


    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Guardar1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrar dialog = new Registrar(new javax.swing.JFrame(), true);
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
    public static javax.swing.JPanel A;
    public static javax.swing.JPanel B;
    public static javax.swing.JPanel C;
    public static javax.swing.JPanel D;
    public static javax.swing.JLabel ID_C;
    public static rojerusan.RSPanelsSlider PanelDesliza;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    public static javax.swing.JLabel a3;
    private javax.swing.JLabel a5;
    public static javax.swing.JPanel barra_estado;
    public static app.bolivia.swing.JCTextField buscarViaje;
    public static ComboBox.SComboBox cmbDestinos;
    public static ComboBox.SComboBox cmbEstado;
    public static ComboBox.SComboBox cmbEstado1;
    public static ComboBox.SComboBox cmbMunicipio;
    public static ComboBox.SComboBox cmbMunicipio1;
    public static ComboBox.SComboBox cmbOrigenes;
    public static JButtonEspecial.JButtonEspecial jButton1;
    public static JButtonEspecial.JButtonEspecial jButton2;
    public static JButtonEspecial.JButtonEspecial jButton33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static jcMousePanel.jcMousePanel jcMousePanel1;
    public static javax.swing.JSeparator l1;
    private javax.swing.JLabel lblIDOrigen;
    public static javax.swing.JLabel lblNombreNuevo17;
    public static JButtonEspecial.JButtonEspecial log1;
    public static JButtonEspecial.JButtonEspecial log2;
    public static JButtonEspecial.JButtonEspecial log3;
    public static JButtonEspecial.JButtonEspecial log4;
    public static JButtonEspecial.JButtonEspecial log5;
    private JButtonEspecial.JButtonEspecial log8;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    private JButtonEspecial.JButtonEspecial rSButtonMetro3;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTable tabla2;
    public static javax.swing.JTable tabla3;
    // End of variables declaration//GEN-END:variables

    

}
