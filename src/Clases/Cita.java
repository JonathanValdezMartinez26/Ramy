package Clases;

import Alerts.AlertBasic.Success;
import Alerts.AlertBasic.Error;
import Ventanas.Modulo_Cita.Opciones;
import static Ventanas.Modulo_Cita.pnlCitas.buscar;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cita {
    
public static String LISTAR = "SELECT ID_ConsultaOrdinaria,Nombres_Med,Apellidos_Med,Fecha_Cita,Dia_Cita,Hora_Cita,Nombres,Apellidos,Estado FROM CitaV ORDER BY ID_Cita Desc";   

public static ResultSet resultado;

public static void Agregar_Cita(int Turno, Date Fecha,int ID_Paciente, int ID_Medico, String Motivo_C ,int ID_TRIAGE,String Hora,
String Dia_Semana, int Semana_Cita){
    
 String Estado = "Pendiente";  
 
 long date = Fecha.getTime();
 java.sql.Date FechaC = new java.sql.Date(date);
    
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call Agregar_Cita_ConsultaO(?,?,?,?,?,?,?,?,?,?)}");

                            consulta.setInt(1, Turno);
                            consulta.setDate(2, FechaC);
                            consulta.setInt(3, ID_Paciente);
                            consulta.setInt(4, ID_Medico);
                            consulta.setString(5, Motivo_C);
                            consulta.setInt(6, ID_TRIAGE);
                            consulta.setString(7, Hora);
                            consulta.setString(8, Estado);
                            consulta.setString(9, Dia_Semana);
                            consulta.setInt(10, Semana_Cita);

                            consulta.execute();
                            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de la Cita!");
            AC.msj2.setText("Guardados correctamente");
            AC.setVisible(true);
            
            if(buscar.equals(""))
            {
                Opciones.listar("");
            }
            else
            {
                Opciones.listar(buscar.getText());
            }
     }   
        catch (SQLException ex) 
        {    
            System.out.println(ex);
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }


public static void Actualizar_CitaAtendida(int ID){
   
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarCitaEstado(?) }");
            consulta.setInt(1, ID);   
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


public static void Cita_Atendida(int ID){
    try
    {
        CallableStatement consulta = Conexion.con.prepareCall("{call CitaAtendida (?)}");
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

public static void Cancelar_Consulta(int ID){
    try{
            CallableStatement consulta = Conexion.con.prepareCall("{call Cancelar_ConsultaOrdinariaCita (?)}");
            consulta.setInt(1, ID);
            consulta.execute();
            
            Success AC = new  Success(null, true);
            AC.setVisible(true);
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
