package Clases;

import Ventanas.Modulo_Tipo_Servicio.AgregarTipoServicio;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Tipo_Servicio {

    public static ResultSet resultado;
    
    public static String LISTAR = "select * from Tipo_Servicio order by ID_Tipo_Servicio";

     public static void Agregar_Tipo(String Nombre) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarTipoSer (?)}");
            
            consulta.setString(1, Nombre);

            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos del Servicio !");
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

    public static void Actualizar_TipoSer(int ID, String Nombre) {

        try {
                CallableStatement consulta = Conexion.con.prepareCall("{call ModificarTipoServicio (?,?) }");

                consulta.setInt(1, ID);
                consulta.setString(2, Nombre);
                

                consulta.execute();
            
                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Datos del Tipo de Servicio!");
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

    public static void Activar_Especialidad(int ID) 
    {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Especialidad!");
            AC.msj2.setText("Activada Correctamente");
            AC.setVisible(true);

        } 
        catch (SQLException ex) 
        {

            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3718!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);

        }
    }

    public static void Desactivar_Especialidad(int ID) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Especialidad!");
            AC.msj2.setText("Desactivada Correctamente");
            AC.setVisible(true);
            
        } 
        catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3715!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }

    
}
