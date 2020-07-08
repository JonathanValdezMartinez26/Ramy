package Ventanas.Modulo_Comparacion_Viaje;

import Ventanas.Modulo_Cotizaciones.Opciones;
import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
    public static void CargarDatos(int id){
    
    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.pnlBitacora.tabla.getModel();
    modelo.setRowCount(0);
    
    int contador = 0;
    String datos[] = new String[7];
    
        String sql ="Select Dia, Hora_Inicial, Hora_Final from Horario Where ID_Medico = "+ id;
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String Dia = rs.getString(1);

           if("L".equals(Dia))
           {
               Dia = "Lunes";
           }
           if("M".equals(Dia))
           {
               Dia = "Martes";
           }
           if("X".equals(Dia))
           {
               Dia = "Miercoles";
           }
           if("J".equals(Dia))
           {
               Dia = "Jueves";
           }
           if("V".equals(Dia))
           {
               Dia = "Viernes";
           }
           if("S".equals(Dia))
           {
               Dia = "Sabado";
           }
           if("D".equals(Dia))
           {
               Dia = "Domingo";
           }
            datos [0] = Dia;
            datos [1] = rs.getString(2);
            datos [2] = rs.getString(3);

            modelo.addRow(datos);
            }
           
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.pnlBitacora.tablabitacora.getModel();
        DefaultTableModel modelot = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.pnlBitacora.tabla.getModel();

        modelot.setRowCount(0);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Medico.LISTARM;
        } else {
            
            sql = "select ID_Medico,concat_ws(' ',Nombres,Apellidos) as Medico, Cedula from medico where concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Medico LIKE '"+ busca +"%' OR Cedula LIKE '"+ busca +"%' and Estado = true";
            
           }
        String datos[] = new String[3];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
    
    
    
