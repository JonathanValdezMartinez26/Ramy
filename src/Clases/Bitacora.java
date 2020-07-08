
package Clases;


import static Ventanas.Modulo_Cliente.Opciones.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;


public class Bitacora {
    
    
public static ResultSet resultado;

 
 public static String LISTARM = "select ID_cliente, Nombre_cliente from clientes";
 public static String LISTARB = "select Nombre_Viaje, costo_antiguo,costo_nuevo,transporte,Fecha_Mod from bitacora_costos";
 
// public static int ObtenID() {
//        int c = 0;
//        String SQL = "SELECT MAX(ID_Cotizaciones) FROM Cotizaciones";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            if (rs.next()) {
//                c = rs.getInt(1);
//            }
//            return c;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return c;
//    }
 public static int ObtenerCliente(int ruta){
        int c = 0;
        String SQL = "SELECT ID_cliente FROM ruta where id_ruta="+ruta;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }
            return c;

        } catch (SQLException ex) {
            //Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
