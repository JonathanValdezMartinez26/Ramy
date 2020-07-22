
package Ventanas.Modulo_Configuracion;

import Ventanas.Modulo_Servicios.*;
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
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Configuracion.pnlIncrementoPrecios.tabla.getModel();

        while (modelo.getRowCount() > 0) 
        {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Clientes.LISTARCOSTOS;
        } 
        else 
        {
            
//            sql = "SELECT * FROM Serviciov WHERE (ID_Servicio LIKE'" + busca + "%' OR "
//                    + "Nombre_Servicio LIKE'" + busca + "%' OR Nombre_Tipo_Servicio LIKE'" + busca + "%')"
//                    + " ORDER BY ID_Servicio";
        }
        String datos[] = new String[8];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = String.valueOf(rs.getInt(2));
                datos [2] = rs.getString(3);
                datos [3] = String.valueOf(rs.getDate(4));
                datos [4] = String.valueOf(rs.getDate(5));
                datos [5] = String.valueOf(rs.getDate(6));
                datos [6] = rs.getString(7);
                
                int Valor = rs.getInt(8);
                String Res = "";
                
//                     34 < 365    365 > 40
                if(Valor <= 365 && Valor > 40){
                  Res = "VIGENTE";
                }
                if(Valor < 39 && Valor > 1){
                  Res = "PROXIMA A VENCER";
                }
                if(Valor == 0 ){
                  Res = "VENCIDA";
                }
                datos [7] = Res;
               
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      public static void listarAjustes(int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Configuracion.pnlAjustes.tabla.getModel();

        while (modelo.getRowCount() > 0) 
        {
            modelo.removeRow(0);
        }
       
            String sql = "SELECT Fecha_Ajuste, Fecha_Siguiente_Ajuste, Tarifa, Incremento_Ajuste, Concepto_Ajuste from ajuste_preciov where ID_cliente = 1 order by Fecha_Ajuste";
 
        String datos[] = new String[5];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getDate(1));
                datos [1] = String.valueOf(rs.getDate(2));
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4)+ " %";
                datos [4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}