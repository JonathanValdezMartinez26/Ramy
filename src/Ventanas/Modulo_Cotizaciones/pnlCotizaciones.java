/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas.Modulo_Cotizaciones;

import Ventanas.Modulo_Cliente.*;
import A_tabla.*;
import Clases.Clientes;
import Clases.Conexion;
import static Ventanas.Modulo_Cliente.Registrar.B;
import static Ventanas.Modulo_Cliente.Registrar.C;
import static Ventanas.Modulo_Cliente.Registrar.PanelDesliza;
import static Ventanas.Modulo_Cliente.pnlClientes.tabla;
import Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado;
import Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta;
import Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
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
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import rojerusan.RSPanelsSlider;

public class pnlCotizaciones extends javax.swing.JPanel {

    
    
    public pnlCotizaciones() {
        initComponents();
        Opciones.listarCotizaciones("");
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRendererCitas());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        
    }
    public void Modificar() {

        int Fila = tabla.getSelectedRow();
        int Filita = 1; 
  
        if (Fila >= 0) {
            String status = (tabla.getValueAt(Fila, 4).toString());
            
                    if(status.equals("PENDIENTE")){
                    int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());            

                    ModificarCotizaciones MP = new ModificarCotizaciones(null, true);
                    MP.CargarDatos(ID);
                    MP.setPP(this);
                    MP.setVisible(true);
                    }else{
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Esta cotización!");
                        AC.msj2.setText("A sido finalizada");
                        AC.setVisible(true);
                    }
            
            
        } else {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("A modificar");
            AC.setVisible(true);
        }
   

    }
    public void Eliminar() {

        int Fila = tabla.getSelectedRow();
        int Filita = 1; 
        int ID = 0;
  
        if (Fila >= 0) {
                        ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());            
                        Alerts.AlertBasic.EliminarCotizaciones AC = new  Alerts.AlertBasic.EliminarCotizaciones(null, true);
                        AC.msj1.setText("¡Desea Eliminar!");
                        AC.msj2.setText("la Cotizacion");
                        AC.msj2.setText("Esta acción no se podrá deshacer");
                        AC.ID.setText("" + ID);
                        AC.setVisible(true);
                        
                        
                    
        } else {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("A Eliminar");
            AC.setVisible(true);
        }
   

    }
    
    ///////////////////
    public void Origenes()
    {    
        int Fila = tabla.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
//          a.PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log1.setVisible(false);
            
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }
    ////////////////////
    public void Destinos()
    {    
        int Fila = tabla.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, B, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log2.setVisible(false);
            a.log3.setVisible(false);
           
        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }
    ////////////////////
    public void Rutas()
    {    
        int Fila = tabla.getSelectedRow();
      
            if(Fila >= 0)
        {
            int ID = 0;
            ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            Registrar a = new  Registrar(null, true);
            a.PanelDesliza.setPanelSlider(2, C, RSPanelsSlider.DIRECT.RIGHT);
            a.ID_C.setText(""+ID);
            a.listar(ID);
            a.setVisible(true);
            a.log4.setVisible(false);
            a.log5.setVisible(false);

        }
    else
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("para Asignar/ver Origenes");
            AC.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnleditar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlorigenes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlpdf = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlagregar1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pnlagregar2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pnlagregar3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre del Cliente", "Atención", "Fecha de Alta", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(22);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        pnlPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 1086, 480));

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("   Cotizaciones");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 70));

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar.setToolTipText("Agregar Cotizacion Directa");
        pnlagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregarMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregarMouseClicked(evt);
            }
        });
        pnlagregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("     Directa");
        pnlagregar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista-40.png"))); // NOI18N
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 69));

        pnleditar.setBackground(new java.awt.Color(225, 225, 225));
        pnleditar.setToolTipText("Editar Cotizacion");
        pnleditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnleditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnleditarMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnleditarMouseClicked(evt);
            }
        });
        pnleditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("     Editar");
        pnleditar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/añadireditar.png"))); // NOI18N
        pnleditar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 69));

        pnlorigenes.setBackground(new java.awt.Color(225, 225, 225));
        pnlorigenes.setToolTipText("Visualizar Cotizacion");
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
        jLabel15.setText("   Visualizar");
        pnlorigenes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        pnlorigenes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlorigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 69));

        pnlpdf.setBackground(new java.awt.Color(225, 225, 225));
        pnlpdf.setToolTipText("Eliminar Cotizacion");
        pnlpdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlpdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlpdfMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlpdfMouseClicked(evt);
            }
        });
        pnlpdf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("    Eliminar");
        pnlpdf.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        pnlpdf.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, -1, 69));

        pnlagregar1.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar1.setToolTipText("Agregar Cotizacion por Consolidado");
        pnlagregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregar1MouseExited(evt);
            }
        });
        pnlagregar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText(" Consolidado");
        pnlagregar1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista-40.png"))); // NOI18N
        pnlagregar1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 69));

        pnlagregar2.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar2.setToolTipText("Agregar Cotizacion por Ruta");
        pnlagregar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregar2MouseExited(evt);
            }
        });
        pnlagregar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("   Por Ruta");
        pnlagregar2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista-40.png"))); // NOI18N
        pnlagregar2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 69));

        pnlagregar3.setBackground(new java.awt.Color(225, 225, 225));
        pnlagregar3.setToolTipText("Agregar Cotizacion por Renta");
        pnlagregar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlagregar3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlagregar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlagregar3MouseExited(evt);
            }
        });
        pnlagregar3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("  Por Renta");
        pnlagregar3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista-40.png"))); // NOI18N
        pnlagregar3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, 69));

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

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
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 20, 145, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        pnlPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1105, 85));

        add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 652));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        AgregarCotizaciones1 AC = new AgregarCotizaciones1(null, true);
        AC.setVisible(true);
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
       Opciones.listarCotizaciones(this.buscar.getText().trim());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void pnleditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseClicked
      Modificar();
    }//GEN-LAST:event_pnleditarMouseClicked

    private void pnleditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseEntered
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnleditarMouseEntered

    private void pnleditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnleditarMouseExited
        pnleditar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnleditarMouseExited

    private void pnlorigenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseClicked
       ver();
//Origenes();
    }//GEN-LAST:event_pnlorigenesMouseClicked

    private void pnlorigenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseEntered
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlorigenesMouseEntered

    private void pnlorigenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlorigenesMouseExited
        pnlorigenes.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlorigenesMouseExited

    private void pnlpdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseClicked
        Eliminar();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlpdfMouseClicked

    private void pnlpdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseEntered
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlpdfMouseEntered

    private void pnlpdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpdfMouseExited
        pnlpdf.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlpdfMouseExited

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked


        
    }//GEN-LAST:event_tablaMouseClicked

    private void pnlagregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar1MouseClicked
    AgregarCotizaciones_Consolidado poper =new Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlagregar1MouseClicked

    private void pnlagregar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar1MouseEntered
        pnlagregar1.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregar1MouseEntered

    private void pnlagregar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar1MouseExited
        pnlagregar1.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregar1MouseExited

    private void pnlagregar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar2MouseClicked

        //AgregarCotizaciones poper = new AgregarCotizaciones(null, true);
        AgregarCotizacionesRuta poper =new Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta(null, true);
        poper.setVisible(true);



//        Ventanas.Modulo_Ruta_Cotizacion.prueba p=new Ventanas.Modulo_Ruta_Cotizacion.prueba();
//        p.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlagregar2MouseClicked

    private void pnlagregar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar2MouseEntered
        pnlagregar2.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregar2MouseEntered

    private void pnlagregar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar2MouseExited
        pnlagregar2.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregar2MouseExited

    private void pnlagregar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar3MouseClicked
    AgregarCotizaciones_Renta poper =new Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta(null, true);
        poper.setVisible(true);
    }//GEN-LAST:event_pnlagregar3MouseClicked

    private void pnlagregar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar3MouseEntered
        pnlagregar3.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregar3MouseEntered

    private void pnlagregar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregar3MouseExited
        pnlagregar3.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregar3MouseExited
     
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnlagregar1;
    private javax.swing.JPanel pnlagregar2;
    private javax.swing.JPanel pnlagregar3;
    private javax.swing.JPanel pnleditar;
    private javax.swing.JPanel pnlorigenes;
    private javax.swing.JPanel pnlpdf;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
     
    public void ver() {
        Clases.Conexion cc = new Clases.Conexion();
        
        int Fila = tabla.getSelectedRow();
        int Filita = 1; 
  
        if (Fila >= 0) {

            int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
            
    
       try {
            Consultas.Reportes r = new Consultas.Reportes(new JFrame(), true);
            String archivo = "C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Ramy\\src\\Consultas\\Cotizacion.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            Map parametro = new HashMap();
            parametro.put("ID_Cliente", ID);
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
            AC.msj1.setText("¡Seleccione el registro!");
            AC.msj2.setText("a visualizar");
            AC.setVisible(true);
        }
}
    }
