package Clases;

import Ventanas.Modulo_Tipo_Servicio.AgregarTipoServicio;
import Ventanas.Modulo_Tipo_Servicio.pnlTipoServicio;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Tipo_Transporte {

    public static ResultSet resultado;
    
    public static String LISTAR = "select * from tipo_transporte order by ID_Tipo_Transporte";

     public static void Agregar_Tipo(String Nombre) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarTipotran (?)}");
            
            consulta.setString(1, Nombre);

            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos del Transporte!");
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

    public static void Actualizar_TipoTran(int ID, String Nombre) {

        try {
                CallableStatement consulta = Conexion.con.prepareCall("{call ModificarTipoTranspotes (?,?) }");

                consulta.setInt(1, ID);
                consulta.setString(2, Nombre);
                

                consulta.execute();
            
                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Datos del Tipo de Transporte!");
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
