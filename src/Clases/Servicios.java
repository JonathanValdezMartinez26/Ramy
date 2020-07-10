package Clases;

import Ventanas.Modulo_Tipo_Servicio.AgregarTipoServicio;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Servicios {

    public static ResultSet resultado;
    
    public static String LISTAR = "select * from serviciov order by ID_Servicio";

     public static void Agregar_Tipo(String Nombre_Servicio, int ID_Tipo_Servicio) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarServicio (?,?)}");
            
            consulta.setString(1, Nombre_Servicio);
            consulta.setInt(2, ID_Tipo_Servicio);

            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos del Servicio!");
            AC.msj2.setText("Guardados correctamente");
            AC.setVisible(true);
            
        } catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }

    public static void Actualizar_Servicios(int ID, String Nombre_Servicio, int ID_Tipo_Servicio) {

        try {
                CallableStatement consulta = Conexion.con.prepareCall("{call ModificarServicio (?,?,?) }");

                consulta.setInt(1, ID);
                consulta.setString(2, Nombre_Servicio);
                consulta.setInt(3, ID_Tipo_Servicio);

                consulta.execute();
            
                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Datos del Servicio!");
                AC.msj2.setText("Actualizados Correctamente");
                AC.setVisible(true);
                
        } 
        catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }


    
}
