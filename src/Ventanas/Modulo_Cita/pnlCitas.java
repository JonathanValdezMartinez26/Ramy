package Ventanas.Modulo_Cita;

import A_tabla.*;
import Alerts.PendienteCita;
import Clases.Cita;
import Clases.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class pnlCitas extends javax.swing.JPanel {

    public pnlCitas() {
        initComponents();
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.tabla.getTableHeader().setReorderingAllowed(false) ;
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRendererCitas());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        if(buscar.equals(""))
        {
            Opciones.listar("");
        }
        else
        {
            Opciones.listar(buscar.getText());
        }
        
    } 
   
    public void ActDes() {

        int Fila = tabla.getSelectedRow();
        int Col = 6;
        
        if(Ventanas.Modulo_Cita.Opciones.verificaCita() == 0)
        {
                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡No hay citas!");
                AC.msj2.setText("¡Para cancelar!");
                AC.setVisible(true);
        }
        else
        {
            if (Fila >= 0) {

             int ID = Integer.parseInt(tabla.getValueAt(Fila, 0).toString());
             String Estado = tabla.getValueAt(Fila, Col).toString();
             String Nombre = tabla.getValueAt(Fila, 5).toString();

             if (Estado.equalsIgnoreCase("Pendiente")) 
             {
                 PendienteCita AC = new  PendienteCita(null, true);
                 AC.ID.setText(""+ID);
                 AC.msj1.setText("De: " + Nombre);
                 AC.setVisible(true);

             } 
             else 
             {
                 if (Estado.equalsIgnoreCase("Atendida")) {
                     Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                     AC.msj1.setText("¡La cita ya ha sido atendida!");
                     AC.setVisible(true);
                 }
                 else 
                 {
                     Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                     AC.msj1.setText("¡Ya ha cancelado esta cita!");
                     AC.setVisible(true);
                 }
             }
                if(buscar.equals(""))
                {
                    Opciones.listar("");
                } else {
                    Opciones.listar(buscar.getText());
                }
            }
            else 
            {
                     Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                     AC.msj1.setText("¡Debe seleccionar!");
                     AC.msj2.setText("la cita a cancelar");
                     AC.setVisible(true);
            }
        }
    }


    ResultSet resultado;
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlmodificar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlagregar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1106, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Medico", "Fecha", "Dia", "Hora", "Paciente", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(6).setResizable(false);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 1086, 490));

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("     Citas");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        pnlmodificar.setBackground(new java.awt.Color(225, 225, 225));
        pnlmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlmodificarMouseExited(evt);
            }
        });
        pnlmodificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("    Cancelar");
        pnlmodificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        pnlmodificar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 69));

        pnlagregar.setBackground(new java.awt.Color(225, 225, 225));
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
        jLabel22.setText("    Agregar");
        pnlagregar.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo.png"))); // NOI18N
        pnlagregar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 69));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

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
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 20, 150, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1085, 5));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1105, 85));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseClicked
        ActDes();
    }//GEN-LAST:event_pnlmodificarMouseClicked

    private void pnlmodificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseEntered
        pnlmodificar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlmodificarMouseEntered

    private void pnlmodificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmodificarMouseExited
        pnlmodificar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlmodificarMouseExited

    private void pnlagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseClicked
        boolean verificamedico = false;
        boolean verificaespecialidad = false;
        boolean verificapaciente = false;
        
        
        if(Ventanas.Modulo_Medico.Opciones.verificarMedico() == 0)
        {
            verificamedico = true;
        }
        else
        {
            if(Ventanas.Modulo_Medico.Opciones.verificarEspecialidad() == 0)
            {
                verificaespecialidad = true;
            }
            else
            {
                if(Ventanas.Modulo_Medico.Opciones.verificarPacientes() == 0)
                {
                    verificapaciente = true;
                }
            }
        }
        
        
        if(verificamedico == true && verificaespecialidad == true && verificapaciente == true)
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Debe ingresar almenos!");
            AC.msj2.setText("Un registro para paciente y médico");
            AC.msj3.setText("Ó reactive los existentes");
            AC.setVisible(true);
        }
        else
        {
            if (verificaespecialidad == true)
            {
                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Debe ingresar almenos!");
                AC.msj2.setText("Un egistro para especialidad");
                AC.msj3.setText("Ó reactive los existentes");
                AC.setVisible(true);
            } 
            else 
            {
                if (verificamedico == true)
                {
                    Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Debe ingresar almenos!");
                    AC.msj2.setText("Un registro para médico");
                    AC.msj3.setText("Ó reactive los existentes");
                    AC.setVisible(true);
                } 
                else 
                {
                     if (verificapaciente == true)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Debe ingresar almenos un!");
                        AC.msj2.setText("Registro para paciente");
                        AC.setVisible(true);
                    } 
                    else 
                    {
                        AgregarCitas AC = new  AgregarCitas(null, true);
                        AC.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_pnlagregarMouseClicked

    private void pnlagregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseEntered
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlagregarMouseEntered

    private void pnlagregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlagregarMouseExited
        pnlagregar.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlagregarMouseExited

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        Opciones.listar(this.buscar.getText().trim());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped
     DefaultTableModel model = new DefaultTableModel() {

        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlagregar;
    private javax.swing.JPanel pnlmodificar;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
