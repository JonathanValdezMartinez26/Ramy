
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

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Clientes.LISTARCOSTOS;
        } else {
            
            sql = "SELECT * FROM Serviciov WHERE (ID_Servicio LIKE'" + busca + "%' OR "
                    + "Nombre_Servicio LIKE'" + busca + "%' OR Nombre_Tipo_Servicio LIKE'" + busca + "%')"
                    + " ORDER BY ID_Servicio";
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