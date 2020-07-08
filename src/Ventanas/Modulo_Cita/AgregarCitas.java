package Ventanas.Modulo_Cita;

import A_tabla.EstiloTablaHeader;
import A_tabla.EstiloTablaRendererAgregarCita;
import A_tabla.MyScrollbarUI;
import Alerts.AWTUtilities;
import Alerts.CitaPendiente;
import Alerts.FadeEffect;
import Alerts.HorarioAlert;
import Clases.Cita;
import Clases.Conexion;
import Clases.Consulta;
import Ventanas.Modulo_Consulta.pnlConsultaAdmin;
import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;

public class AgregarCitas extends javax.swing.JDialog {

    Timer timer = null;
    TimerTask task;
    int i = 32;
    int x,y;
    boolean flag = false;
    
    public AgregarCitas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        
        this.tabla.getTableHeader().setReorderingAllowed(false);
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        Date Hoy = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        jCalendar1.setMinSelectableDate(calendar.getTime());
        jCalendar1.setDate(calendar.getTime());
        
        flag = true;
        String[] Header = {"Hora", "Estado"};
        String[] Horas = { "09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M " ,"02:00 P.M","02:30 P.M", "03:00 P.M","03:30 P.M", "04:00 P.M","04:30 P.M", "05:00 A.M","05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M"};

        model.setColumnIdentifiers(Header);
        model.setRowCount(23);

        for (int k = 0; k < 23; k++) 
        {
            String hr = Horas[k];
            model.setValueAt(hr, k, 0);
        }

        tabla.setModel(model);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(130);
        columnModel.getColumn(1).setPreferredWidth(210);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(1).setResizable(false);
        tabla.setColumnModel(columnModel);

        int ID_Especialidad = 0;
        try 
        {
            resultado = Conexion.consulta("Select Max(ID_Especialidad) from Especialidad");
            while (resultado.next()) 
            {
                ID_Especialidad = resultado.getInt(1);
            }
        } 
        catch (SQLException ex) 
        {

        }

        ID_Especialidad++;
        ID_Esp = new int[ID_Especialidad];
        ID_Esp[0] = 0;
        int i = 1;
        try 
        {
            resultado = Conexion.consulta("Select ID_Especialidad, Nombre from Especialidad where Estado = "+true);
            while (resultado.next()) 
            {
                ID_Esp[i] = resultado.getInt(1);
                cmbEspecialidad.addItem(resultado.getString(2));
                i++;
            }
        } 
        catch (SQLException ex) 
        {

        }
/////
        int ID_Paciente = 0;

        try 
        {
            resultado = Conexion.consulta("Select Max(ID_Paciente) from Paciente");

            while (resultado.next()) 
            {
                ID_Paciente = resultado.getInt(1);
            }
        } 
        catch (SQLException ex) 
        {

        }

        ID_Paciente++;
        ID_Pac = new int[ID_Paciente];
        ID_Pac[0] = 0;
        int j = 1;
        
        try 
        {
            resultado = Conexion.consulta("Select ID_Paciente, Nombres, Apellidos from Paciente where Estado = "+true);
            while (resultado.next()) 
            {
                ID_Pac[j] = resultado.getInt(1);
                cmbPaciente.addItem(resultado.getString(2).trim() + " " + resultado.getString(3).trim() + " || " +resultado.getString(1).trim());
                j++;
            }
        } 
        catch (SQLException ex) 
        {

        }

        int ID_Medico = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Medico) from Medico");

            while (resultado.next()) {
                ID_Medico = resultado.getInt(1);
            }
        } catch (SQLException ex) {

        }

        ID_Medico++;

        ID_Med = new int[ID_Medico];

        ID_Med[0] = 0;
        
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRendererAgregarCita());
    }
    
     public void Guardar() {
         
        String cmbPacNom = cmbPaciente.getSelectedItem().toString();
        
        int cmbPac = cmbPaciente.getSelectedIndex();
        int cmbMed = cmbMedico.getSelectedIndex();
        int ID_Paciente = ID_Pac[cmbPac];
        int ID_Medico = ID_Med[cmbMed];

        Date Fecha = jCalendar1.getDate();

        int fila = tabla.getSelectedRow();

        if (cmbMed == 0 || cmbPac == 0 || Fecha == null) {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Complete todos los campos!");
            AC.msj2.setText("seleccione correctamente");
            AC.setVisible(true);
            return;
        }
        if (fila < 0) 
        {    
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("Seleccione la hora correctamente");
            AC.msj2.setText("");
        } else {

            if (DiaDisponible()) {

                String Estado = model.getValueAt(fila, 1).toString();
                String Hora = model.getValueAt(fila, 0).toString();

                if ("No disponible".equalsIgnoreCase(Estado.trim())) {
                    Alerts.AlertBasic.Warning AC = new  Alerts.AlertBasic.Warning(null, true);
                    AC.msj1.setText("Hora no disponible");
                    AC.msj2.setText("Verifique el horario médico");
                    return;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(Fecha.getTime());
                int Dia = cal.get(Calendar.DAY_OF_WEEK);
                int Semana = cal.get(Calendar.WEEK_OF_YEAR);

                String Dia_Semana = "";
                switch (Dia) {
                    case 1:
                        Dia_Semana = "Domingo";
                        break;
                    case 2:
                        Dia_Semana = "Lunes";
                        break;
                    case 3:
                        Dia_Semana = "Martes";
                        break;
                    case 4:
                        Dia_Semana = "Miercoles";
                        break;
                    case 5:
                        Dia_Semana = "Jueves";
                        break;
                    case 6:
                        Dia_Semana = "Viernes";
                        break;
                    case 7:
                        Dia_Semana = "Sabado";
                        break;

                    default:
                        break;
                }
                 if(Ventanas.Modulo_Medico.Opciones.verificaCitaPaciente(ID_Paciente) == 0)
                {
                    int Turno = Ventanas.Modulo_Consulta.Opciones.verificarTurno(Fecha, ID_Medico) + 1;
                    
                    Cita.Agregar_Cita(Turno, Fecha, ID_Paciente, ID_Medico, "Cita Agendada" ,1,Hora,
                    Dia_Semana, Semana);
                    Limpiar();
                }
                 else
                {
                    CitaPendiente AC = new  CitaPendiente(null, true);
                    AC.msj1.setText("" + cmbPacNom);
                    AC.setVisible(true);
                }

            }

        }

    }

     public void Limpiar() {
        cmbPaciente.setSelectedIndex(0);
        cmbPaciente.setSelectedIndex(0);
        cmbEspecialidad.setSelectedIndex(0);
        ckD.setSelected(false);
        ckJ.setSelected(false);
        ckL.setSelected(false);
        ckM.setSelected(false);
        ckS.setSelected(false);
        ckV.setSelected(false);
        ckX.setSelected(false);

        Date hoy = new Date();
        jCalendar1.setDate(hoy);

        String[] Horas = {"09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M " ,"02:00 P.M","02:30 P.M", "03:00 P.M","03:30 P.M", "04:00 P.M","04:30 P.M", "05:00 A.M","05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M"};
        model.setRowCount(23);

        for (int k = 0; k < 23; k++) {

            String hr = Horas[k];
            model.setValueAt(hr, k, 0);
            model.setValueAt("", k, 1);
        }

    }
     
     public void CargarHorario() {
        
        this.tabla.setEnabled(true);
        
        String[] Horas = {"09:00 A.M", "09:30 A.M", "10:00 A.M", "10:30 A.M", "11:00 A.M", "11:30 A.M", "12:00 P.M", "12:30 P.M", "01:00 P.M", "01:30 P.M " ,"02:00 P.M","02:30 P.M", "03:00 P.M","03:30 P.M", "04:00 P.M","04:30 P.M", "05:00 A.M","05:30 P.M", "06:00 P.M", "06:30 P.M", "07:00 P.M", "07:30 P.M", "08:00 P.M"};

        model.setRowCount(23);

        for (int k = 0; k < 23; k++) {

            String hr = Horas[k];
            model.setValueAt(hr, k, 0);
        }

        int ID_Medic = cmbMedico.getSelectedIndex();

        if (ID_Medic < 0) {
            ID_Medic = 0;
        }

        int ID_Medico = ID_Med[ID_Medic];

        String HoraInicio = "09:00 AM";
        String HoraFinal = "08:00 PM";

        boolean L = false;
        boolean M = false;
        boolean X = false;
        boolean J = false;
        boolean V = false;
        boolean S = false;
        boolean D = false;

        ckL.setSelected(L);
        ckM.setSelected(M);
        ckX.setSelected(X);
        ckJ.setSelected(J);
        ckV.setSelected(V);
        ckS.setSelected(S);
        ckD.setSelected(D);

        ArrayList<String> Dias = new ArrayList<>();
        ArrayList<String> Hora_Inicial = new ArrayList<>();
        ArrayList<String> Hora_Final = new ArrayList<>();

        try {

            resultado = Conexion.consulta("Select Dia, Hora_Inicial, Hora_Final"
                    + " from Horario where ID_Medico = " + ID_Medico);

            while (resultado.next()) {
                Dias.add(resultado.getString(1));
                Hora_Inicial.add(resultado.getString(2));
                Hora_Final.add(resultado.getString(3));
            }
        } catch (SQLException ex) {

        }

        ArrayList<String> Hrs = new ArrayList<String>();
        ArrayList<String> Estados = new ArrayList<String>();

        long date = 0;
        try {
            Date Fecha = jCalendar1.getDate();
            date = Fecha.getTime();
            java.sql.Date Fechac = new java.sql.Date(date);
            resultado = Conexion.consulta("Select Hora_Cita, Estado from Cita where (ID_Medico = " + ID_Medico
                    + ") and (Fecha_Cita = '" + Fechac + "')");

            while (resultado.next()) {
                Hrs.add(resultado.getString(1));
                Estados.add(resultado.getString(2));
            }
        } catch (SQLException ex) {

        }

        Date Hoy = jCalendar1.getDate();
        long hoy = Hoy.getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(hoy);
        int Dia = cal.get(Calendar.DAY_OF_WEEK);

        String Day = "";

        switch (Dia) {
            case 1:
                Day = "D";
                break;

            case 2:
                Day = "L";
                break;

            case 3:
                Day = "M";
                break;

            case 4:
                Day = "X";
                break;

            case 5:
                Day = "J";
                break;

            case 6:
                Day = "V";
                break;

            case 7:
                Day = "S";
                break;

            default:
                break;
        }
        
       int item = 0;
       
       if(Dias.contains(Day)){
           
           item = Dias.indexOf(Day);
           
       }
       else{
           
           for(int r=0; r<tabla.getRowCount();r++){
               tabla.setValueAt("No Disponible", r, 1);
           }
           
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            return;
       }

        int Horai = 0;
        int Horaf = 0;

        HoraInicio = Hora_Inicial.get(item);
        HoraFinal = Hora_Final.get(item);
        
        for (int r = 0; r < 23; r++) {

            String HRM = (String) model.getValueAt(r, 0);

            if (HRM.equalsIgnoreCase(HoraInicio)) {
                Horai = r;
            }
            if (HRM.equalsIgnoreCase(HoraFinal)) {
                Horaf = r;
            }

        }

        if (ID_Medico != 0) {

            model.setRowCount(0);

            Horaf++;

            int TamanoHorario = Horaf - Horai;

            for (int k = 0; k < TamanoHorario; k++) {
                model.addRow(new Object[]{"", ""});

                String hr = Horas[Horai];
                Horai++;

                model.setValueAt(hr, k, 0);
                model.setValueAt("Disponible", k, 1);
            }

            for (int q = 0; q < model.getRowCount(); q++) {

                String HRM = (String) model.getValueAt(q, 0);

                for (int p = 0; p < Hrs.size(); p++) {

                    if (Hrs.get(p).equalsIgnoreCase(HRM)) {
                        if ("Pendiente".equals(Estados.get(p))) {
                            model.setValueAt(" No disponible", q, 1);
                        }

                    }
                }

            }

        }


        for (String Dia1 : Dias) {
            
            if(Dia1.equalsIgnoreCase("L")){
                L=true;
            }
            if(Dia1.equalsIgnoreCase("M")){
                M=true;
            }
            if(Dia1.equalsIgnoreCase("X")){
                X=true;
            }
            if(Dia1.equalsIgnoreCase("J")){
                J=true;
            }
            if(Dia1.equalsIgnoreCase("V")){
                V=true;
            }
            if(Dia1.equalsIgnoreCase("S")){
                S=true;
            }
            if(Dia1.equalsIgnoreCase("D")){
                D=true;
            }
            
        }
        
        ckL.setSelected(L);
        ckM.setSelected(M);
        ckX.setSelected(X);
        ckJ.setSelected(J);
        ckV.setSelected(V);
        ckS.setSelected(S);
        ckD.setSelected(D);
        
        
        tabla.setModel(model);
        tabla.setDefaultRenderer(Object.class, new EstiloTablaRendererAgregarCita());
        
    }
     
       public boolean DiaDisponible() {

        Date Fecha = jCalendar1.getDate();
        long date = Fecha.getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        int Dia = cal.get(Calendar.DAY_OF_WEEK);

        this.tabla.setEnabled(true);
        tabla.setDefaultRenderer(Object.class, new EstiloTablaRendererAgregarCita());

        if (!ckD.isSelected() && Dia == 1) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Domingo no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckL.isSelected() && Dia == 2) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Lunes no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckM.isSelected() && Dia == 3) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Martes no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckX.isSelected() && Dia == 4) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);

            P.msj1.setText("Dia Miercoles no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckJ.isSelected() && Dia == 5) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Jueves no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckV.isSelected() && Dia == 6) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Viernes no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        if (!ckS.isSelected() && Dia == 7) {
            this.tabla.setEnabled(false);
            tabla.setDefaultRenderer(Object.class, new MiRenderDisable());
            HorarioAlert P = new HorarioAlert(null, true);
            
            P.msj1.setText("Dia Sabado no disponible");
            P.msj2.setText("En horario del medico");
            P.setVisible(true);
            return false;
        }
        return true;
    }

  
    ResultSet resultado;
    int ID_Esp[];
    int ID_Pac[];
    int ID_Med[];
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new JButtonEspecial.JButtonEspecial();
        info = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ckL = new javax.swing.JCheckBox();
        ckM = new javax.swing.JCheckBox();
        ckX = new javax.swing.JCheckBox();
        ckJ = new javax.swing.JCheckBox();
        ckV = new javax.swing.JCheckBox();
        ckS = new javax.swing.JCheckBox();
        ckD = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cmbMedico = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        log = new JButtonEspecial.JButtonEspecial();
        cmbPaciente = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.png"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);

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
        jPanel7.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 0, 30, 30));

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(102, 102, 102));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Agendar Cita");
        jPanel7.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 997, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        ckL.setBackground(new java.awt.Color(255, 255, 255));
        ckL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckL.setText("L");
        ckL.setEnabled(false);

        ckM.setBackground(new java.awt.Color(255, 255, 255));
        ckM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckM.setText("M");
        ckM.setEnabled(false);

        ckX.setBackground(new java.awt.Color(255, 255, 255));
        ckX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckX.setText("X");
        ckX.setEnabled(false);

        ckJ.setBackground(new java.awt.Color(255, 255, 255));
        ckJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckJ.setText("J");
        ckJ.setEnabled(false);

        ckV.setBackground(new java.awt.Color(255, 255, 255));
        ckV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckV.setText("V");
        ckV.setEnabled(false);

        ckS.setBackground(new java.awt.Color(255, 255, 255));
        ckS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckS.setText("S");
        ckS.setEnabled(false);

        ckD.setBackground(new java.awt.Color(255, 255, 255));
        ckD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckD.setText("D");
        ckD.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(ckL)
                .addGap(7, 7, 7)
                .addComponent(ckM)
                .addGap(5, 5, 5)
                .addComponent(ckX)
                .addGap(7, 7, 7)
                .addComponent(ckJ)
                .addGap(9, 9, 9)
                .addComponent(ckV)
                .addGap(7, 7, 7)
                .addComponent(ckS)
                .addGap(7, 7, 7)
                .addComponent(ckD))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ckL)
            .addComponent(ckM)
            .addComponent(ckX)
            .addComponent(ckJ)
            .addComponent(ckV)
            .addComponent(ckS)
            .addComponent(ckD)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 130, 560, 60);

        tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(40);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(600, 35, 377, 470);

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cmbMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedicoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbMedico);
        cmbMedico.setBounds(310, 90, 266, 30);

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setText(" Especialidad");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(210, 50, 100, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la hora de la cita en la tabla de horario");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(600, 17, 360, 17);

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cmbEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEspecialidadItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbEspecialidad);
        cmbEspecialidad.setBounds(310, 50, 266, 30);

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel16.setText("   Médico");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(240, 90, 70, 27);

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\jvald\\Documents\\NetBeansProjects\\Copias Clinica Dr.Enrique\\24112019\\src\\Images\\icons8-schedule-75.png")); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(80, 10, 80, 100);

        jCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la fecha de la cita en los dias disponibles del médico"));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        jPanel1.add(jCalendar1);
        jCalendar1.setBounds(20, 190, 560, 320);

        log.setBackground(new java.awt.Color(204, 204, 204));
        log.setForeground(new java.awt.Color(128, 128, 131));
        log.setText("Guardar");
        log.setColorHover(new java.awt.Color(204, 204, 204));
        log.setColorNormal(new java.awt.Color(204, 204, 204));
        log.setColorPressed(new java.awt.Color(153, 153, 153));
        log.setColorTextHover(new java.awt.Color(128, 128, 131));
        log.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        jPanel1.add(log);
        log.setBounds(600, 515, 377, 30);

        cmbPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        jPanel1.add(cmbPaciente);
        cmbPaciente.setBounds(310, 10, 266, 30);

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel9.setText("Paciente");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 10, 70, 27);

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
         this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        if (flag) {
            try {
                CargarHorario();
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {

            }

            int ID_Medico = cmbMedico.getSelectedIndex();

            if (ID_Medico != 0) {
                DiaDisponible();
            }
         
        }
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        this.setVisible(false);
         
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
     Guardar();
    }//GEN-LAST:event_logActionPerformed

    private void cmbMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedicoItemStateChanged
        CargarHorario();
    }//GEN-LAST:event_cmbMedicoItemStateChanged

    private void cmbEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEspecialidadItemStateChanged
        int ID_Espec = cmbEspecialidad.getSelectedIndex();

        int ID_Especialidad = ID_Esp[ID_Espec];

        int i = 1;

        cmbMedico.removeAllItems();
        cmbMedico.addItem("<Seleccione>");

        try {

            resultado = Conexion.consulta("Select ID_Medico, Nombres, Apellidos from Medico where "
                    + "(ID_Especialidad = "+ID_Especialidad+") and (Estado = "+true+")");

            while (resultado.next()) {
                ID_Med[i] = resultado.getInt(1);
                cmbMedico.addItem(resultado.getString(2).trim() + " " + resultado.getString(3).trim());
                i++;
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cmbEspecialidadItemStateChanged

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCitas dialog = new AgregarCitas(new javax.swing.JFrame(), true);
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
    
    
   

    public class MiRenderDisable extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            this.setOpaque(true);
            this.setBackground(Color.GRAY);
            this.setForeground(Color.BLACK);

            return this;
        }
    }
    
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ckD;
    private javax.swing.JCheckBox ckJ;
    private javax.swing.JCheckBox ckL;
    private javax.swing.JCheckBox ckM;
    private javax.swing.JCheckBox ckS;
    private javax.swing.JCheckBox ckV;
    private javax.swing.JCheckBox ckX;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbMedico;
    private javax.swing.JComboBox cmbPaciente;
    public static javax.swing.JLabel info;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private JButtonEspecial.JButtonEspecial log;
    private JButtonEspecial.JButtonEspecial rSButtonMetro2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    
}
