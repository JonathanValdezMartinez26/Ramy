package Ventanas.Modulo_Tipo_Servicio;

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
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Tipo_Servicio.LISTAR;
        } else {
            
            sql = "SELECT * FROM Tipo_Servicio WHERE (ID_Tipo_Servicio LIKE'" + busca + "%' OR "
                    + "Nombre_Tipo_Servicio LIKE'" + busca + "%') "
                    + "ORDER BY ID_Tipo_Servicio";
           }
        String datos[] = new String[2];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
          
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static int verificaTipo(String Nombre) {
        int existe = 0;
        String SQL = "select count(Nombre_Tipo_Servicio) from Tipo_Servicio where Nombre_Tipo_Servicio = '"+ Nombre+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
     
      public static int verificaTipoTran(String Tipo_Transporte, int id) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM Tipo_Transporte where Tipo_Transporte = " + Tipo_Transporte +" and ID_Tipo_Transporte != " + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }
            
            return c;

        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    
    }