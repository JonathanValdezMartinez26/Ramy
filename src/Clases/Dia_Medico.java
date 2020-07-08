package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dia_Medico {
    
    
public static ResultSet resultado;

public static void Agregar_Dia_Medico(int ID_Medico, String Dia)
    {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarDia_Medico (?,?)}");
            consulta.setInt(1, ID_Medico);
            consulta.setString(2, Dia);
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
