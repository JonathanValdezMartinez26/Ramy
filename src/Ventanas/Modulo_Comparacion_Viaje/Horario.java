package Ventanas.Modulo_Comparacion_Viaje;

import Ventanas.Modulo_Cotizaciones.Horario;
import Ventanas.Modulo_Medico.AgregarTran;
import Clases.Conexion;
import Clases.Dia_Medico;
import Clases.Hora_Medico;
import Clases.Medico;
import Ventanas.Modulo_Usuario.AgregarUsuarioMedico;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class Horario extends javax.swing.JDialog {

    public Horario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        
        PanelL.setVisible(false);
        PanelM.setVisible(false); 
        PanelX.setVisible(false); 
        PanelJ.setVisible(false); 
        PanelV.setVisible(false); 
        PanelS.setVisible(false);  
        PanelD.setVisible(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel12 = new javax.swing.JPanel();
        pnlespecialidad = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ckL = new javax.swing.JCheckBox();
        ckM = new javax.swing.JCheckBox();
        ckX = new javax.swing.JCheckBox();
        ckJ = new javax.swing.JCheckBox();
        ckV = new javax.swing.JCheckBox();
        ckS = new javax.swing.JCheckBox();
        ckD = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        PanelL = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbDesde = new javax.swing.JComboBox();
        cmbHasta = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PanelM = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cmbDesde2 = new javax.swing.JComboBox();
        cmbHasta2 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        PanelJ = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cmbDesde4 = new javax.swing.JComboBox();
        cmbHasta4 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        PanelX = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cmbDesde3 = new javax.swing.JComboBox();
        cmbHasta3 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        PanelV = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cmbDesde5 = new javax.swing.JComboBox();
        cmbHasta5 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        PanelS = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cmbDesde6 = new javax.swing.JComboBox();
        cmbHasta6 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        PanelD = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        cmbDesde9 = new javax.swing.JComboBox();
        cmbHasta9 = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Horario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(225, 225, 225));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlespecialidad.setBackground(new java.awt.Color(225, 225, 225));
        pnlespecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlespecialidadMouseExited(evt);
            }
        });
        pnlespecialidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("    Guardar ");
        pnlespecialidad.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 14));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar (2).png"))); // NOI18N
        pnlespecialidad.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 40));

        jPanel12.add(pnlespecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 69));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel9.setText("Dias disponibles");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ckL.setBackground(new java.awt.Color(255, 255, 255));
        ckL.setText("L");
        ckL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckLItemStateChanged(evt);
            }
        });
        jPanel3.add(ckL);

        ckM.setBackground(new java.awt.Color(255, 255, 255));
        ckM.setText("M");
        ckM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckMItemStateChanged(evt);
            }
        });
        jPanel3.add(ckM);

        ckX.setBackground(new java.awt.Color(255, 255, 255));
        ckX.setText("X");
        ckX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckXItemStateChanged(evt);
            }
        });
        jPanel3.add(ckX);

        ckJ.setBackground(new java.awt.Color(255, 255, 255));
        ckJ.setText("J");
        ckJ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckJItemStateChanged(evt);
            }
        });
        jPanel3.add(ckJ);

        ckV.setBackground(new java.awt.Color(255, 255, 255));
        ckV.setText("V");
        ckV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckVItemStateChanged(evt);
            }
        });
        jPanel3.add(ckV);

        ckS.setBackground(new java.awt.Color(255, 255, 255));
        ckS.setText("S");
        ckS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckSItemStateChanged(evt);
            }
        });
        jPanel3.add(ckS);

        ckD.setBackground(new java.awt.Color(255, 255, 255));
        ckD.setText("D");
        ckD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckDItemStateChanged(evt);
            }
        });
        jPanel3.add(ckD);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 810, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        PanelL.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel10.setText("Hasta");

        cmbDesde.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setText("Lunes");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel12.setText("Desde");

        javax.swing.GroupLayout PanelLLayout = new javax.swing.GroupLayout(PanelL);
        PanelL.setLayout(PanelLLayout);
        PanelLLayout.setHorizontalGroup(
            PanelLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelLLayout.setVerticalGroup(
            PanelLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 0, 0);
        jPanel1.add(PanelL, gridBagConstraints);

        PanelM.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel16.setText("Hasta");

        cmbDesde2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel17.setText("Martes");

        jLabel18.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel18.setText("Desde");

        javax.swing.GroupLayout PanelMLayout = new javax.swing.GroupLayout(PanelM);
        PanelM.setLayout(PanelMLayout);
        PanelMLayout.setHorizontalGroup(
            PanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        PanelMLayout.setVerticalGroup(
            PanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 41);
        jPanel1.add(PanelM, gridBagConstraints);

        PanelJ.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel22.setText("Hasta");

        cmbDesde4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel23.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel23.setText("Jueves");

        jLabel24.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel24.setText("Desde");

        javax.swing.GroupLayout PanelJLayout = new javax.swing.GroupLayout(PanelJ);
        PanelJ.setLayout(PanelJLayout);
        PanelJLayout.setHorizontalGroup(
            PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelJLayout.setVerticalGroup(
            PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel1.add(PanelJ, gridBagConstraints);

        PanelX.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel19.setText("Hasta");

        cmbDesde3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel20.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel20.setText("Miercoles");

        jLabel21.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel21.setText("Desde");

        javax.swing.GroupLayout PanelXLayout = new javax.swing.GroupLayout(PanelX);
        PanelX.setLayout(PanelXLayout);
        PanelXLayout.setHorizontalGroup(
            PanelXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelXLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelXLayout.setVerticalGroup(
            PanelXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelXLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel1.add(PanelX, gridBagConstraints);

        PanelV.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel25.setText("Hasta");

        cmbDesde5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel26.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel26.setText("Viernes");

        jLabel27.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel27.setText("Desde");

        javax.swing.GroupLayout PanelVLayout = new javax.swing.GroupLayout(PanelV);
        PanelV.setLayout(PanelVLayout);
        PanelVLayout.setHorizontalGroup(
            PanelVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelVLayout.setVerticalGroup(
            PanelVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel1.add(PanelV, gridBagConstraints);

        PanelS.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel28.setText("Hasta");

        cmbDesde6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel29.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel29.setText("Sabado");

        jLabel30.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel30.setText("Desde");

        javax.swing.GroupLayout PanelSLayout = new javax.swing.GroupLayout(PanelS);
        PanelS.setLayout(PanelSLayout);
        PanelSLayout.setHorizontalGroup(
            PanelSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelSLayout.setVerticalGroup(
            PanelSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel1.add(PanelS, gridBagConstraints);

        PanelD.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel37.setText("Hasta");

        cmbDesde9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        cmbHasta9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M", "02:00 P.M", "02:30 P.M", "03:00 P.M", "03:30 P.M", "04:00 P.M", "04:30 P.M", "05:00 A.M", "05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M" }));

        jLabel38.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel38.setText("Domingo");

        jLabel39.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel39.setText("Desde");

        javax.swing.GroupLayout PanelDLayout = new javax.swing.GroupLayout(PanelD);
        PanelD.setLayout(PanelDLayout);
        PanelDLayout.setHorizontalGroup(
            PanelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbDesde9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cmbHasta9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelDLayout.setVerticalGroup(
            PanelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDesde9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHasta9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel1.add(PanelD, gridBagConstraints);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 810, 510));

        setSize(new java.awt.Dimension(808, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckLItemStateChanged
        if(ckL.isSelected()){
            PanelL.setVisible(true);
        }
        else{
            PanelL.setVisible(false);
        }
    }//GEN-LAST:event_ckLItemStateChanged

    private void ckMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckMItemStateChanged
        if(ckM.isSelected()){
            PanelM.setVisible(true);
        }
        else{
            PanelM.setVisible(false);
        }
    }//GEN-LAST:event_ckMItemStateChanged

    private void ckXItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckXItemStateChanged
        if(ckX.isSelected()){
            PanelX.setVisible(true);
        }
        else{
            PanelX.setVisible(false);
        }
    }//GEN-LAST:event_ckXItemStateChanged

    private void ckJItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckJItemStateChanged
        if(ckJ.isSelected()){
            PanelJ.setVisible(true);
        }
        else{
            PanelJ.setVisible(false);
        }
    }//GEN-LAST:event_ckJItemStateChanged

    private void ckVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckVItemStateChanged
        if(ckV.isSelected()){
            PanelV.setVisible(true);
        }
        else{
            PanelV.setVisible(false);
        }
    }//GEN-LAST:event_ckVItemStateChanged

    private void ckSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckSItemStateChanged
        if(ckS.isSelected()){
            PanelS.setVisible(true);
        }
        else{
            PanelS.setVisible(false);
        }
    }//GEN-LAST:event_ckSItemStateChanged

    private void ckDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckDItemStateChanged
        if(ckD.isSelected()){
            PanelD.setVisible(true);
        }
        else{
            PanelD.setVisible(false);
        }
    }//GEN-LAST:event_ckDItemStateChanged

    private void pnlespecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseClicked
        Guardar();
    }//GEN-LAST:event_pnlespecialidadMouseClicked

    private void pnlespecialidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseEntered
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.gray,Color.LIGHT_GRAY));
    }//GEN-LAST:event_pnlespecialidadMouseEntered

    private void pnlespecialidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlespecialidadMouseExited
        pnlespecialidad.setBorder(new EtchedBorder(EtchedBorder.RAISED,new java.awt.Color(225,225,225),new java.awt.Color(225,225,225)));
    }//GEN-LAST:event_pnlespecialidadMouseExited

    ResultSet resultado;
    
   private String Nombre;
   private String Apellido;
   private String Cedula;
   private int ID_Especialidad;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    
    public void setID_Especialidad(int ID_Especialidad) {
        this.ID_Especialidad = ID_Especialidad;
    }
   
   
    AgregarTran AM;

    public void setAM(AgregarTran AM) {
        this.AM = AM;
    }
    
    
    
    public void Guardar(){
        if(ckL.isSelected()){
        int HRi = cmbDesde.getSelectedIndex();
        int HRs = cmbHasta.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
               Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                   AC.msj1.setText("¡Seleccione Correctamente!");
                   AC.msj2.setText("Las Horas de entrada y salida");
                   AC.setVisible(true);
           return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Lunes no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
        
         if(ckM.isSelected()){
        int HRi = cmbDesde2.getSelectedIndex();
        int HRs = cmbHasta2.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Seleccione Correctamente!");
                AC.msj2.setText("Las Horas de entrada y salida");
                AC.setVisible(true);
               return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Martes no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
         
          if(ckX.isSelected()){
        int HRi = cmbDesde3.getSelectedIndex();
        int HRs = cmbHasta3.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione Correctamente!");
            AC.msj2.setText("Las Horas de entrada y salida");
            AC.setVisible(true);
            return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Miercoles no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
          
            if(ckJ.isSelected()){
        int HRi = cmbDesde4.getSelectedIndex();
        int HRs = cmbHasta4.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione Correctamente!");
            AC.msj2.setText("Las Horas de entrada y salida");
            AC.setVisible(true);
               return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Jueves no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
            
              if(ckV.isSelected()){
        int HRi = cmbDesde5.getSelectedIndex();
        int HRs = cmbHasta5.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione Correctamente!");
            AC.msj2.setText("Las Horas de entrada y salida");
            AC.setVisible(true);
            return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Viernes no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
              
                if(ckS.isSelected()){
        int HRi = cmbDesde6.getSelectedIndex();
        int HRs = cmbHasta6.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione Correctamente!");
            AC.msj2.setText("Las Horas de entrada y salida");
            AC.setVisible(true);
            return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Sabado no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
                
        if(ckD.isSelected()){
        int HRi = cmbDesde9.getSelectedIndex();
        int HRs = cmbHasta9.getSelectedIndex();
        
         if(HRi==0 || HRs==0){
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Seleccione Correctamente!");
            AC.msj2.setText("Las Horas de entrada y salida");
            AC.setVisible(true);return;
            }
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida el Domingo no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////
        Medico.Agregar_Medico(Nombre, Apellido, Cedula, ID_Especialidad);
         
            int ID_MaxM = 0;
            
            try{
               resultado = Conexion.consulta("Select ID_Medico from Medico where Cedula =" + Cedula );
               
               while(resultado.next()){
                   ID_MaxM = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
            
           
            AgregarHorario(ID_MaxM);
            
            String NombreUsuario = Nombre.trim() + ID_MaxM;
            String NombreCompleto = Nombre.trim() + " " + Apellido.trim();
           
            StringTokenizer ST = new StringTokenizer(NombreUsuario, " ");
            StringTokenizer STT = new StringTokenizer(NombreCompleto, " ");
            
            String Name = "";
            
            while(ST.hasMoreTokens()){
            Name = Name.concat(ST.nextToken());
            }
            Name = Name.toLowerCase();
            
            this.dispose();
            AgregarUsuarioMedico AUM = new AgregarUsuarioMedico(null, true);
            
            AUM.setNombreCompleto(NombreCompleto);
            AUM.setNombreUsuario(Name);
            AUM.setID_MAX(ID_MaxM);
            AUM.setVisible(true);
            
    }
    
 public void AgregarHorario(int ID_MaxM){
        
     
            if(ckL.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "L");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde.getSelectedItem();
              String HoraFinal = (String) cmbHasta.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckM.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "M");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde2.getSelectedItem();
              String HoraFinal = (String) cmbHasta2.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckX.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "X");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde3.getSelectedItem();
              String HoraFinal = (String) cmbHasta3.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckJ.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "J");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde4.getSelectedItem();
              String HoraFinal = (String) cmbHasta4.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckV.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "V");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde5.getSelectedItem();
              String HoraFinal = (String) cmbHasta5.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckS.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "S");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde6.getSelectedItem();
              String HoraFinal = (String) cmbHasta6.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            if(ckD.isSelected()){
                
               int ID_MaxD = 0;
               
               Dia_Medico.Agregar_Dia_Medico(ID_MaxM, "D");
               
                try{
               resultado = Conexion.consulta("Select Max(ID_Dia_Medico) from Dia_Medico");
               
               while(resultado.next()){
                   ID_MaxD = resultado.getInt(1);
               }
                
            }catch(SQLException ex){}
               
              String HoraInicio = (String) cmbDesde9.getSelectedItem();
              String HoraFinal = (String) cmbHasta9.getSelectedItem();
              
              Hora_Medico.Agregar_Hora_Medico(ID_MaxD, HoraInicio, HoraFinal);
               
            }
            
            /***************************************************************/
            
            
    }
   
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Horario dialog = new Horario(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelD;
    private javax.swing.JPanel PanelJ;
    private javax.swing.JPanel PanelL;
    private javax.swing.JPanel PanelM;
    private javax.swing.JPanel PanelS;
    private javax.swing.JPanel PanelV;
    private javax.swing.JPanel PanelX;
    private javax.swing.JCheckBox ckD;
    private javax.swing.JCheckBox ckJ;
    private javax.swing.JCheckBox ckL;
    private javax.swing.JCheckBox ckM;
    private javax.swing.JCheckBox ckS;
    private javax.swing.JCheckBox ckV;
    private javax.swing.JCheckBox ckX;
    private javax.swing.JComboBox cmbDesde;
    private javax.swing.JComboBox cmbDesde2;
    private javax.swing.JComboBox cmbDesde3;
    private javax.swing.JComboBox cmbDesde4;
    private javax.swing.JComboBox cmbDesde5;
    private javax.swing.JComboBox cmbDesde6;
    private javax.swing.JComboBox cmbDesde9;
    private javax.swing.JComboBox cmbHasta;
    private javax.swing.JComboBox cmbHasta2;
    private javax.swing.JComboBox cmbHasta3;
    private javax.swing.JComboBox cmbHasta4;
    private javax.swing.JComboBox cmbHasta5;
    private javax.swing.JComboBox cmbHasta6;
    private javax.swing.JComboBox cmbHasta9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlespecialidad;
    // End of variables declaration//GEN-END:variables
}
