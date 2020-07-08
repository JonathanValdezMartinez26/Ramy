package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Hora_Medico {
    
    
public static ResultSet resultado;

public static void Agregar_Hora_Medico(int ID_Dia_Medico, String HoraInicio, String HoraFinal)
    {
    
        try {
                CallableStatement consulta = Conexion.con.prepareCall("{call AgregarHora_Medico (?,?,?)}");

                consulta.setInt(1, ID_Dia_Medico);
                consulta.setString(2, HoraInicio);
                consulta.setString(3, HoraFinal);

                consulta.execute();

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
