
package Ventanas.Modulo_Servicios;

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

    
    public static void listar(int ID_Origen, int ID_Destino) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Servicios.pnlServicio.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "SELECT Id_Ruta, Nombre_Cliente,Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full  from `rutav` WHERE ID_Municipio_Origen = "+ ID_Origen+ " and ID_Municipio_Destino = "+ ID_Destino;
           
        String datos[] = new String[8];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                datos [5] = rs.getString(6);
                datos [6] = rs.getString(7);
                datos [7] = rs.getString(8);
                
               
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
 
    
 public static int verificaServicio(String Nombre) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM Servicio where Nombre_Servicio = '" + Nombre +"'";
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
        String SQL = "SELECT COUNT(*) FROM Transportes where Nombre_Transporte = " + Nombre +" and ID_Tipo_Transporte != " + id;
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