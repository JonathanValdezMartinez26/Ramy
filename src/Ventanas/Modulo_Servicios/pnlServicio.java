package Ventanas.Modulo_Servicios;

import A_tabla.*;
import Clases.Conexion;
import static Ventanas.Modulo_Cliente.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.IDCotizacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class pnlServicio extends javax.swing.JPanel {

    public pnlServicio() 
    {
        initComponents();
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        Clientes();
        Origenes();
        Destinos();
    }
    
    ResultSet resultado, resultados;
    int ID_Tran [];
    int ID_Orig [];
    int ID_Des [];
    int ID_Cli[];
    
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

            resultado = Conexion.consulta("Select Max(ID_Ruta) from rutav");

            while (resultado.next()) {
                ID_Origen = resultado.getInt(1);
            }
        } catch (SQLException ex) {

        }

        ID_Origen++;

        ID_Orig = new int[ID_Origen];
        ID_Orig[0] = 0;
        
    }
    
    public void Destinos()
    {
         int ID_Destino = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Ruta) from rutav");

            while (resultado.next()) {
                ID_Destino = resultado.getInt(1);
            }
        } catch (SQLException ex) {

        }

        ID_Destino++;

        ID_Des = new int[ID_Destino];

        ID_Des[0] = 0;
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cmbOrigenes = new ComboBox.SComboBox();
        cmbDestino = new ComboBox.SComboBox();
        jButton1 = new JButtonEspecial.JButtonEspecial();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cmbCliente = new ComboBox.SComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("  Comparativos");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Global  Servicios");
        pnlorigenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlorigenesMouseExited(evt);
            }
        });
        pnlorigenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("     Global");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        jLabel1.setText("Se muestran los resultados para el Origen Estado de Mexico y Destino Toluca con el destino ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 740, 30));

        cmbOrigenes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Origen" }));
        cmbOrigenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbOrigenes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrigenesItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbOrigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 230, 30));

        cmbDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Destino" }));
        cmbDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDestinoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 230, 30));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(128, 128, 131));
        jButton1.setText("Filtrar Resultados");
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 220, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1105, 85));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre Cliente", "Camioneta 1.5", "Camioneta 3.5", "Rabón", "Torthon", "Tráiler", "Fulll"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(6).setResizable(false);
            tabla.getColumnModel().getColumn(7).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, 1086, 430));

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Cliente" }));
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
        add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 480, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
        ver();
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            int ID_Client = cmbCliente.getSelectedIndex();
            int ID_Cliente = ID_Cli[ID_Client];
            int i = 1;

            //JOptionPane.showMessageDialog(null,"ID_CLiente " + ID_Cliente);
            cmbOrigenes.removeAllItems();
            cmbOrigenes.addItem("Seleccione un Origen");

            try {

                resultado = Conexion.consulta("SELECT ID_Municipio_Origen, Origen from rutav where "
                    + "(ID_Cliente = "+ID_Cliente+") GROUP BY Origen");

                while (resultado.next()) {
                    ID_Orig[i] = resultado.getInt(1);
                    cmbOrigenes.addItem(resultado.getString(2).trim());
                    i++;
                }
            }
            catch (SQLException ex) {
            }

        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ID_Origen = cmbOrigenes.getSelectedIndex();
        int ID_Origenes = ID_Orig[ID_Origen];
       
        
        int ID_Destin = cmbDestino.getSelectedIndex();
        int ID_Destinos = ID_Des[ID_Destin];
        
        
        if(ID_Origenes == 0 && ID_Destinos == 0)
            {
                 JOptionPane.showMessageDialog(null, "Seleccione un Origen y Un Destino");
            }
        else
        {
            Opciones.listar(ID_Origenes, ID_Destinos);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDestinoItemStateChanged
        
    }//GEN-LAST:event_cmbDestinoItemStateChanged

    private void cmbOrigenesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrigenesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        
        int ID_Client = cmbCliente.getSelectedIndex();
        int ID_Cliente = ID_Cli[ID_Client];
        int i = 0;
        
        int ID_Origen = cmbOrigenes.getSelectedIndex();
        int ID_Origenes = ID_Orig[ID_Origen];
        int ID_OrigenB=0;
        
        int ID_Destin = cmbDestino.getSelectedIndex();
            int ID_Destinos = ID_Des[ID_Destin];
            int ID_DestinoB=0;
        
        
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
                  
                    
         /////////////////
         
         
//         
        cmbDestino.removeAllItems();
        cmbDestino.addItem("Seleccione un Destino");
        
        try {
            resultado = Conexion.consulta("SELECT ID_Municipio_Destino, Destino from rutav where "
                    + "(ID_Cliente = "+ID_Cliente+") and (ID_Municipio_Origen = "+ID_Origenes+") GROUP BY Destino");

            while (resultado.next()) {
                ID_Des[i] = resultado.getInt(1);
                cmbDestino.addItem(resultado.getString(2).trim());
                i++;
            }
        } catch (SQLException ex) {

        }
      }
    }//GEN-LAST:event_cmbOrigenesItemStateChanged
    DefaultTableModel model = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            
            return false;
        }
        
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComboBox.SComboBox cmbCliente;
    private ComboBox.SComboBox cmbDestino;
    private ComboBox.SComboBox cmbOrigenes;
    private JButtonEspecial.JButtonEspecial jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlorigenes;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();

        try {
            Reportes.Reportes r = new Reportes.Reportes(new JFrame(), true);
            File fichero = new File("test.txt");
            System.out.println("La ruta del fichero es: " + fichero.getAbsolutePath());
            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Reportes\\Servicios.jasper";
//            String archivo = "Reportes/Servicios.jasper";";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cc.conexion());

            JRViewer jrv = new JRViewer(jasperPrint);
            jrv.setZoomRatio((float) 0.95);
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

