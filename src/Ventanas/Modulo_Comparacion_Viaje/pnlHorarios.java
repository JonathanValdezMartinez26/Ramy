package Ventanas.Modulo_Comparacion_Viaje;

import Ventanas.Modulo_Cotizaciones.Opciones;
import A_tabla.EstiloTablaHeader;
import A_tabla.EstiloTablaHeader1;
import A_tabla.EstiloTablaHeader_1;
import A_tabla.EstiloTablaRenderer;
import A_tabla.EstiloTablaRenderer11;
import A_tabla.MyScrollbarUI;
import Clases.Conexion;
import java.awt.Color;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static Ventanas.Modulo_Cotizaciones.pnlBitacora.tablabitacora;

public class pnlHorarios extends javax.swing.JPanel {

    public pnlHorarios() {
        initComponents();
        if(buscar.getText().equals(""))
        {
            Opciones.listar("");
        }
        else
        {
            Opciones.listar(buscar.getText());
        }
        
        this.tablamedico.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablamedico.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablamedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablabitacora.getTableHeader().setReorderingAllowed(false) ;
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader_1());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer11());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false) ;
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cmbTran = new ComboBox.SComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbTran1 = new ComboBox.SComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1102, 654));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("  Comparativos");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 69));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 70));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1106, 69));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(0, 144, 183));
        buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR MÉDICO");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 20, 145, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/campo-buscar.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 210, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 65, 1080, 10));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 85));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transporte/Empresa", "Desde", "Hasta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(62);
        jScrollPane3.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 236, 1080, 410));

        cmbTran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elije una opción" }));
        cmbTran.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTranActionPerformed(evt);
            }
        });
        add(cmbTran, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 230, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("  Seleccione un Destino");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("  Seleccione un Origen");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 30));

        cmbTran1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elije una opción" }));
        cmbTran1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTran1ActionPerformed(evt);
            }
        });
        add(cmbTran1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

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

    private void cmbTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTranActionPerformed

    private void cmbTran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTran1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTran1ActionPerformed

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private ComboBox.SComboBox cmbTran;
    private ComboBox.SComboBox cmbTran1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
