package Clases;

import Alerts.AlertBasic.SuccessEmail;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {
    
    
public static ResultSet resultado;

public static String LISTAR = "select ID_usuario,Nombre_Usuario,Correo_Electronico,Rol,Estado from UsuarioV WHERE ID_Usuario!= 1 order by ID_Usuario";

public static void Agregar_Usuario(String Nombre_Usuario, String Usuario, String Contrasena_Usuario, String Correo_Electronico, String Rol_Usuario){
    try 
    {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarUsuario (?,?,?,?,?)}");
            
        consulta.setString(1, Nombre_Usuario);
        consulta.setString(2, Usuario);
        consulta.setString(3, Contrasena_Usuario);
        consulta.setString(4, Correo_Electronico);
        consulta.setString(5, Rol_Usuario);    
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


public static void Actualizar_Usuario(int ID, String Nombre, String Contrasena, String Rol){
    try 
    {
        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarUsuario (?,?,?,?) }");

        consulta.setInt(1,ID);
        consulta.setString(2, Nombre);
        consulta.setString(3, Contrasena);
        consulta.setString(4, Rol);  
       
        consulta.execute();
        
        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
        AC.msj1.setText("¡los datos del usuario!");
        AC.msj2.setText("¡Se actualizaron correctamente!");
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
 
public static void Activar_Usuario(int ID){
    try
    {
        CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Usuario (?)}");

        consulta.setInt(1, ID);
        consulta.execute();
        
        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
        AC.msj1.setText("¡los datos del usuario!");
        AC.msj2.setText("¡Se activarón correctamente!");
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

public static void Desactivar_Usuario(int ID)
    {
        try
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Usuario (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡los datos del usuario!");
            AC.msj2.setText("¡Se desactivarón correctamente!");
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
