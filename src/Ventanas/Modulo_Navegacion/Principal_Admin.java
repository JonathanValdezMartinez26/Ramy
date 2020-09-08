package Ventanas.Modulo_Navegacion;

import Ventanas.Inicio.pnlInicio;
import Ventanas.Modulo_AcercaDe.pnlAcerca;
import Ventanas.Modulo_Cliente.pnlClientes;
import Ventanas.Modulo_Configuracion.pnlConfiguracion;
import Ventanas.Modulo_Bitacora.pnlBitacora;
import Ventanas.Modulo_Servicios.pnlServicio;
import Ventanas.Modulo_Cliente.pnlPacientePersonalizado;
import Ventanas.Modulo_Cotizaciones.pnlCotizaciones;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
import Ventanas.Modulo_Reportes.pnlReportes;
import Ventanas.Modulo_Transportes.pnlTransportes;
import Ventanas.Modulo_Usuario.pnlUsuarios;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Principal_Admin extends javax.swing.JFrame {

    public Principal_Admin() {
        initComponents();
        this.lblUserActivo.setVisible
        (false);
        this.lblIDActivo.setVisible(false);
        try 
            {
                this.setIconImage(new ImageIcon(getClass().getResource("/Images/Icon.png")).getImage());
            } 
        catch (NullPointerException ex) 
        {
             
        }
        //Fecha del sistema
        Date sistemaFech = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
        fecha.setText(formato.format(sistemaFech));
        //Hora del sistema
        Timer tiempo = new Timer(100, new Principal_Admin.horas());
        tiempo.start();
        this.setExtendedState(MAXIMIZED_BOTH);
        //Subrayado Nombre del que inica sesión
        Font font = info.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        info.setFont(font.deriveFont(attributes));
    }
    public static int ID_Usuario; 

    public static void setID_Usuario(int ID_Usuario) {
        Principal_Admin.ID_Usuario = ID_Usuario;
    }

    public void Iniciar(String Rol) {

        if ("3".equals(Rol)) {
        }

        if ("2".equals(Rol)) {
        }

        if ("1".equals(Rol)) 
        {
            uno.setVisible(true);
            dos.setVisible(true);
            tres.setVisible(true);
            cuatro.setVisible(true);
            cinco.setVisible(true);
            seis.setVisible(true);
            siete.setVisible(true);
            siete.setVisible(true);
            ocho.setVisible(true);
            nueve.setVisible(true);
            diez.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rSButtonMetro1 = new JButtonEspecial.JButtonEspecial();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        lblUserActivo = new javax.swing.JLabel();
        lblIDActivo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cinco = new JButtonEspecial.JButtonEspecial();
        uno = new JButtonEspecial.JButtonEspecial();
        dos = new JButtonEspecial.JButtonEspecial();
        cuatro = new JButtonEspecial.JButtonEspecial();
        tres = new JButtonEspecial.JButtonEspecial();
        seis = new JButtonEspecial.JButtonEspecial();
        diez = new JButtonEspecial.JButtonEspecial();
        siete = new JButtonEspecial.JButtonEspecial();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        ocho = new JButtonEspecial.JButtonEspecial();
        nueve = new JButtonEspecial.JButtonEspecial();
        jPanel8 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        info1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(210, 210, 214));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonMetro1.setText("-");
        rSButtonMetro1.setToolTipText("Minimizar");
        rSButtonMetro1.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonMetro1.setColorNormal(new java.awt.Color(210, 210, 214));
        rSButtonMetro1.setColorPressed(new java.awt.Color(136, 0, 0));
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel5.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1301, 0, 30, 30));

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
        jPanel5.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1332, 0, 30, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1362, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(136, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(38, 8, 115));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setBackground(new java.awt.Color(204, 204, 204));
        info.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setText("Dr. Jonathan Valdez Martinez");
        jPanel6.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 240, 40));

        lblUserActivo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblUserActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 20));

        lblIDActivo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblIDActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 40, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Male_User_25px.png"))); // NOI18N
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, -1, 40));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1362, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(239, 238, 244));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(239, 238, 244));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText(" NAVEGACIÓN");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        cinco.setBackground(new java.awt.Color(239, 238, 244));
        cinco.setForeground(new java.awt.Color(128, 128, 131));
        cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cotizacion.png"))); // NOI18N
        cinco.setText("Cotizaciones");
        cinco.setColorHover(new java.awt.Color(204, 204, 204));
        cinco.setColorNormal(new java.awt.Color(239, 238, 244));
        cinco.setColorPressed(new java.awt.Color(204, 204, 204));
        cinco.setColorTextHover(new java.awt.Color(128, 128, 131));
        cinco.setColorTextNormal(new java.awt.Color(128, 128, 131));
        cinco.setColorTextPressed(new java.awt.Color(128, 128, 131));
        cinco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cinco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cinco.setIconTextGap(20);
        cinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cincoMousePressed(evt);
            }
        });
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });
        jPanel3.add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 254, 250, 50));

        uno.setForeground(new java.awt.Color(128, 128, 131));
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        uno.setText("Inicio");
        uno.setColorHover(new java.awt.Color(204, 204, 204));
        uno.setColorNormal(new java.awt.Color(204, 204, 204));
        uno.setColorPressed(new java.awt.Color(204, 204, 204));
        uno.setColorTextHover(new java.awt.Color(128, 128, 131));
        uno.setColorTextNormal(new java.awt.Color(128, 128, 131));
        uno.setColorTextPressed(new java.awt.Color(128, 128, 131));
        uno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        uno.setIconTextGap(20);
        uno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                unoMousePressed(evt);
            }
        });
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        jPanel3.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 250, 50));

        dos.setBackground(new java.awt.Color(239, 238, 244));
        dos.setForeground(new java.awt.Color(128, 128, 131));
        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clientes.png"))); // NOI18N
        dos.setText("Clientes");
        dos.setColorHover(new java.awt.Color(204, 204, 204));
        dos.setColorNormal(new java.awt.Color(239, 238, 244));
        dos.setColorPressed(new java.awt.Color(204, 204, 204));
        dos.setColorTextHover(new java.awt.Color(128, 128, 131));
        dos.setColorTextNormal(new java.awt.Color(128, 128, 131));
        dos.setColorTextPressed(new java.awt.Color(128, 128, 131));
        dos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dos.setIconTextGap(20);
        dos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dosMousePressed(evt);
            }
        });
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });
        jPanel3.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 104, 250, 50));

        cuatro.setBackground(new java.awt.Color(239, 238, 244));
        cuatro.setForeground(new java.awt.Color(128, 128, 131));
        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/car.png"))); // NOI18N
        cuatro.setText("Unidades");
        cuatro.setColorHover(new java.awt.Color(204, 204, 204));
        cuatro.setColorNormal(new java.awt.Color(239, 238, 244));
        cuatro.setColorPressed(new java.awt.Color(204, 204, 204));
        cuatro.setColorTextHover(new java.awt.Color(128, 128, 131));
        cuatro.setColorTextNormal(new java.awt.Color(128, 128, 131));
        cuatro.setColorTextPressed(new java.awt.Color(128, 128, 131));
        cuatro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cuatro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cuatro.setIconTextGap(20);
        cuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuatroMousePressed(evt);
            }
        });
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });
        jPanel3.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, 250, 50));

        tres.setBackground(new java.awt.Color(239, 238, 244));
        tres.setForeground(new java.awt.Color(128, 128, 131));
        tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/services.png"))); // NOI18N
        tres.setText("Comparativo Costos");
        tres.setColorHover(new java.awt.Color(204, 204, 204));
        tres.setColorNormal(new java.awt.Color(239, 238, 244));
        tres.setColorPressed(new java.awt.Color(204, 204, 204));
        tres.setColorTextHover(new java.awt.Color(128, 128, 131));
        tres.setColorTextNormal(new java.awt.Color(128, 128, 131));
        tres.setColorTextPressed(new java.awt.Color(128, 128, 131));
        tres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tres.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tres.setIconTextGap(20);
        tres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tresMousePressed(evt);
            }
        });
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });
        jPanel3.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 250, 50));

        seis.setBackground(new java.awt.Color(239, 238, 244));
        seis.setForeground(new java.awt.Color(128, 128, 131));
        seis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pdf-36.png"))); // NOI18N
        seis.setText("Bitacoras Costos");
        seis.setColorHover(new java.awt.Color(204, 204, 204));
        seis.setColorNormal(new java.awt.Color(239, 238, 244));
        seis.setColorPressed(new java.awt.Color(204, 204, 204));
        seis.setColorTextHover(new java.awt.Color(128, 128, 131));
        seis.setColorTextNormal(new java.awt.Color(128, 128, 131));
        seis.setColorTextPressed(new java.awt.Color(128, 128, 131));
        seis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seis.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        seis.setIconTextGap(20);
        seis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                seisMousePressed(evt);
            }
        });
        seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seisActionPerformed(evt);
            }
        });
        jPanel3.add(seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 304, 250, 50));

        diez.setBackground(new java.awt.Color(239, 238, 244));
        diez.setForeground(new java.awt.Color(128, 128, 131));
        diez.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/aboutt.png"))); // NOI18N
        diez.setText("Acerca de");
        diez.setColorHover(new java.awt.Color(204, 204, 204));
        diez.setColorNormal(new java.awt.Color(239, 238, 244));
        diez.setColorPressed(new java.awt.Color(204, 204, 204));
        diez.setColorTextHover(new java.awt.Color(128, 128, 131));
        diez.setColorTextNormal(new java.awt.Color(128, 128, 131));
        diez.setColorTextPressed(new java.awt.Color(128, 128, 131));
        diez.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        diez.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        diez.setIconTextGap(20);
        diez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diezMousePressed(evt);
            }
        });
        diez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diezActionPerformed(evt);
            }
        });
        jPanel3.add(diez, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 554, 250, 50));

        siete.setBackground(new java.awt.Color(239, 238, 244));
        siete.setForeground(new java.awt.Color(128, 128, 131));
        siete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/globalpdf.png"))); // NOI18N
        siete.setText("Reportes Generales");
        siete.setColorHover(new java.awt.Color(204, 204, 204));
        siete.setColorNormal(new java.awt.Color(239, 238, 244));
        siete.setColorPressed(new java.awt.Color(204, 204, 204));
        siete.setColorTextHover(new java.awt.Color(128, 128, 131));
        siete.setColorTextNormal(new java.awt.Color(128, 128, 131));
        siete.setColorTextPressed(new java.awt.Color(128, 128, 131));
        siete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        siete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        siete.setIconTextGap(20);
        siete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sieteMousePressed(evt);
            }
        });
        siete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sieteActionPerformed(evt);
            }
        });
        jPanel3.add(siete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 354, 250, 50));

        jLabel1.setBackground(new java.awt.Color(239, 238, 244));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText(" OTROS");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 404, 250, 50));

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 654, 250, 40));

        ocho.setBackground(new java.awt.Color(239, 238, 244));
        ocho.setForeground(new java.awt.Color(128, 128, 131));
        ocho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usermale.png"))); // NOI18N
        ocho.setText("Usuarios");
        ocho.setColorHover(new java.awt.Color(204, 204, 204));
        ocho.setColorNormal(new java.awt.Color(239, 238, 244));
        ocho.setColorPressed(new java.awt.Color(204, 204, 204));
        ocho.setColorTextHover(new java.awt.Color(128, 128, 131));
        ocho.setColorTextNormal(new java.awt.Color(128, 128, 131));
        ocho.setColorTextPressed(new java.awt.Color(128, 128, 131));
        ocho.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ocho.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ocho.setIconTextGap(20);
        ocho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ochoMousePressed(evt);
            }
        });
        ocho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ochoActionPerformed(evt);
            }
        });
        jPanel3.add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 454, 250, 50));

        nueve.setBackground(new java.awt.Color(239, 238, 244));
        nueve.setForeground(new java.awt.Color(128, 128, 131));
        nueve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/store.png"))); // NOI18N
        nueve.setText("Configuración");
        nueve.setColorHover(new java.awt.Color(204, 204, 204));
        nueve.setColorNormal(new java.awt.Color(239, 238, 244));
        nueve.setColorPressed(new java.awt.Color(204, 204, 204));
        nueve.setColorTextHover(new java.awt.Color(128, 128, 131));
        nueve.setColorTextNormal(new java.awt.Color(128, 128, 131));
        nueve.setColorTextPressed(new java.awt.Color(128, 128, 131));
        nueve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nueve.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        nueve.setIconTextGap(20);
        nueve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nueveMousePressed(evt);
            }
        });
        nueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueveActionPerformed(evt);
            }
        });
        jPanel3.add(nueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 504, 250, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 694));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setText("DIA - MES - AÑO");

        hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText("HORA");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(950, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(hora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha)))
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 694, 1112, 40));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        info1.setFont(new java.awt.Font("Sylfaen", 1, 35)); // NOI18N
        info1.setForeground(new java.awt.Color(35, 8, 115));
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(info1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 40, 1106, 654));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 32, 1362, 734));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMousePressed
        this.uno.setSelected(true);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false); 
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_unoMousePressed

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        pnlInicio poper = new pnlInicio();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.uno.isSelected()) {
            this.uno.setColorNormal(new Color(204, 204, 204));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));
            
            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
        } else {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
        this.uno.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_unoActionPerformed

    private void cincoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cincoMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(true);
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_cincoMousePressed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        pnlCotizaciones poper = new pnlCotizaciones();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.cinco.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(204, 204, 204));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_cincoActionPerformed

    private void dosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dosMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(true);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_dosMousePressed

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
        pnlClientes poper = new pnlClientes();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.dos.isSelected()) {
            this.dos.setColorNormal(new Color(204, 204, 204));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));
            
            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_dosActionPerformed

    private void cuatroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatroMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(true);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_cuatroMousePressed

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroActionPerformed
        pnlTransportes poper = new pnlTransportes();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.cuatro.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(204, 204, 204));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));
            
            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_cuatroActionPerformed

    private void tresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tresMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(true);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_tresMousePressed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        pnlServicio poper = new pnlServicio();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.tres.isSelected()) {
            this.tres.setColorNormal(new Color(204, 204, 204));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tresActionPerformed

    private void seisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seisMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(true);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_seisMousePressed

    private void seisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seisActionPerformed
        pnlBitacora poper = new pnlBitacora();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.seis.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(204, 204, 204));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_seisActionPerformed

    private void diezMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diezMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(true);
    }//GEN-LAST:event_diezMousePressed

    private void diezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diezActionPerformed
        pnlAcerca poper = new pnlAcerca();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.diez.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));
            
            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(204, 204, 204));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_diezActionPerformed

    private void sieteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sieteMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
         this.siete.setSelected(false);
        this.siete.setSelected(true);
        this.ocho.setSelected(false);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_sieteMousePressed

    private void sieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sieteActionPerformed
        pnlReportes poper = new pnlReportes();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
       
        if (this.siete.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));
            
            this.siete.setColorNormal(new Color(204, 204, 204));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_sieteActionPerformed

    private void ochoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ochoMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
         this.siete.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(true);
        this.nueve.setSelected(false);
        this.diez.setSelected(false);
    }//GEN-LAST:event_ochoMousePressed

    private void ochoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ochoActionPerformed
        pnlUsuarios poper = new pnlUsuarios();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.ocho.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));

            this.ocho.setColorNormal(new Color(204, 204, 204));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_ochoActionPerformed

    private void nueveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nueveMousePressed
        this.uno.setSelected(false);
        this.dos.setSelected(false);
        this.tres.setSelected(false);
        this.cuatro.setSelected(false);
        this.cinco.setSelected(false);
        this.seis.setSelected(false);
        this.siete.setSelected(false);
        this.ocho.setSelected(false);
        this.nueve.setSelected(true);
        this.diez.setSelected(false);
    }//GEN-LAST:event_nueveMousePressed

    private void nueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueveActionPerformed
        pnlConfiguracion poper = new pnlConfiguracion();
        poper.setSize(1106, 654);
        pnlPrincipal.removeAll();
        pnlPrincipal.add(poper);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        if (this.nueve.isSelected()) {
            this.uno.setColorNormal(new Color(239, 238, 244));
            this.uno.setColorHover(new Color(204, 204, 204));
            this.uno.setColorPressed(new Color(204, 204, 204));

            this.dos.setColorNormal(new Color(239, 238, 244));
            this.dos.setColorHover(new Color(204, 204, 204));
            this.dos.setColorPressed(new Color(204, 204, 204));

            this.tres.setColorNormal(new Color(239, 238, 244));
            this.tres.setColorHover(new Color(204, 204, 204));
            this.tres.setColorPressed(new Color(204, 204, 204));

            this.cuatro.setColorNormal(new Color(239, 238, 244));
            this.cuatro.setColorHover(new Color(204, 204, 204));
            this.cuatro.setColorPressed(new Color(204, 204, 204));

            this.cinco.setColorNormal(new Color(239, 238, 244));
            this.cinco.setColorHover(new Color(204, 204, 204));
            this.cinco.setColorPressed(new Color(204, 204, 204));

            this.seis.setColorNormal(new Color(239, 238, 244));
            this.seis.setColorHover(new Color(204, 204, 204));
            this.seis.setColorPressed(new Color(204, 204, 204));

            this.siete.setColorNormal(new Color(239, 238, 244));
            this.siete.setColorHover(new Color(204, 204, 204));
            this.siete.setColorPressed(new Color(204, 204, 204));
            
            this.ocho.setColorNormal(new Color(239, 238, 244));
            this.ocho.setColorHover(new Color(204, 204, 204));
            this.ocho.setColorPressed(new Color(204, 204, 204));
            
            this.nueve.setColorNormal(new Color(204, 204, 204));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
            
            this.diez.setColorNormal(new Color(239, 238, 244));
            this.diez.setColorHover(new Color(204, 204, 204));
            this.diez.setColorPressed(new Color(204, 204, 204));
            
        } else {
            this.nueve.setColorNormal(new Color(239, 238, 244));
            this.nueve.setColorHover(new Color(204, 204, 204));
            this.nueve.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_nueveActionPerformed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed

    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged

    }//GEN-LAST:event_jPanel5MouseDragged

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
       this.dispose();
       Login a = new Login();
       a.setVisible(true);
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        this.setExtendedState(ICONIFIED);
        this.setExtendedState(1);
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            hora.setText(String.format(formato.format(sistemaHora), now));
        }
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
            java.util.logging.Logger.getLogger(Principal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButtonEspecial.JButtonEspecial cinco;
    private JButtonEspecial.JButtonEspecial cuatro;
    private JButtonEspecial.JButtonEspecial diez;
    private JButtonEspecial.JButtonEspecial dos;
    private javax.swing.JLabel fecha;
    public static javax.swing.JLabel hora;
    public static javax.swing.JLabel info;
    public static javax.swing.JLabel info1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblIDActivo;
    public static javax.swing.JLabel lblUserActivo;
    private JButtonEspecial.JButtonEspecial nueve;
    private JButtonEspecial.JButtonEspecial ocho;
    private javax.swing.JPanel pnlPrincipal;
    private JButtonEspecial.JButtonEspecial rSButtonMetro1;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    private JButtonEspecial.JButtonEspecial seis;
    private JButtonEspecial.JButtonEspecial siete;
    private JButtonEspecial.JButtonEspecial tres;
    private JButtonEspecial.JButtonEspecial uno;
    // End of variables declaration//GEN-END:variables
}
