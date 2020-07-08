package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Consulta {
    
    
public static ResultSet resultado;
public static String LISTAR = "select ID_Consulta, fecha, Hora, Nombre_Medico,Cedula,Nombre_Paciente From consultav order by ID_Consulta DESC";



public static void Agregar_Consulta(int ID_Consulta,String Peso, String Talla, String Temperatura, String Consulta, String Diagnostico, String Receta){
    try 
    {
        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarConsulta (?,?,?,?,?,?,?)}");

           
            consulta.setInt(1, ID_Consulta);
            consulta.setString(2, Peso);
            consulta.setString(3, Talla);
            consulta.setString(4, Temperatura);
            consulta.setString(5, Consulta);
            consulta.setString(6, Diagnostico);
            consulta.setString(7, Receta);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de la Consulta!");
            AC.msj2.setText("Guardados correctamente");
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

public static void Agregar_ConsultaOrdinaria(int Turno, Date Fecha, String Hora , int Id_Paciente ,int ID_Medico, String Motivo_C, int ID_TRIAGE) {
        try {
            long date = Fecha.getTime();
            java.sql.Date FechaC = new java.sql.Date(date);
            
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarConsultaOrdinaria (?,?,?,?,?,?,?)}");
            
            consulta.setInt(1, Turno);
            consulta.setDate(2, FechaC);
            consulta.setString(3, Hora);
            consulta.setInt(4, Id_Paciente);
            consulta.setInt(5, ID_Medico);
            consulta.setString(6, Motivo_C);
            consulta.setInt(7, ID_TRIAGE);

            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡El turno se ha generado!");
            AC.msj2.setText("Exitosamente");
            
        } catch (SQLException ex) {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }

public static void Consulta_Atendida(int ID){
    try
    {
        CallableStatement consulta = Conexion.con.prepareCall("{call ConsultaOrdinariaAtendida (?)}");
        consulta.setInt(1, ID);
        consulta.execute();
    }
    catch(SQLException ex)
    {
        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
        AC.msj1.setText("¡Error 3714!");
        AC.msj2.setText("¡Contacte a servicios ProMedic!");
        AC.setVisible(true);
    }
}

}
