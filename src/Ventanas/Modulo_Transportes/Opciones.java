
package Ventanas.Modulo_Transportes;

import Ventanas.Modulo_Transportes.Opciones;
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
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Transportes.pnlTransportes.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Transporte.LISTAR;
        } else {
            
            sql = "SELECT * FROM transportev WHERE (ID_Transporte LIKE'" + busca + "%' OR "
                    + "Nombre_Transporte LIKE'" + busca + "%' OR Tipo_Transporte LIKE'" + busca + "%')"
                    + " ORDER BY ID_Transporte";
           }
        String datos[] = new String[4];
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
   
    
 
    
 public static int verificaTran(String Nombre) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM transportes where Nombre_Transporte = '" + Nombre +"'";
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
 
  public static int verificarTransporte(String Nombre, int id) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM transportes where Nombre_Transporte = " + Nombre +" and ID_Tipo_Transporte != " + id;
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