package Clases;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
public static Connection con;
public static Statement state,state1;
public static ResultSet result,result1;

public void Conectar(String user,String pass)throws SQLException,ClassNotFoundException
{  
            DriverManager.registerDriver( new com.mysql.jdbc.Driver());

          con = DriverManager.getConnection("jdbc:mysql://64.34.157.80:3306/ramy8102_ctz_01?noAccessToProcedureBodies=true&autoReconnect=true", user, pass);
          //con = DriverManager.getConnection("jdbc:mysql://64.34.157.80:3306/ramy8102_ctz_01?noAccessToProcedureBodies=true?useUnicode=true&useJDBCCompilantTimezoneShift=true", user, pass);
          //con = DriverManager.getConnection("jdbc:mysql://64.34.157.80:3306/ramy8102_ctz_01?useUnicode=true&useJDBCCompilantTimezoneShift=true", user, pass);

            state=con.createStatement(result.TYPE_SCROLL_SENSITIVE,result.CONCUR_UPDATABLE);
}
public static ResultSet consulta(String sql)throws SQLException{
        
        state1 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,result1.CONCUR_READ_ONLY);
        result1 = state1.executeQuery(sql);//aqui hago consultas y devuelvo los resultados
        return result1;
}
 
  public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://64.34.157.80:3306/ramy8102_ctz_01?noAccessToProcedureBodies=true&autoReconnect=true","ramy8102_ctz_01", "RAMY_001CTZ");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.0.14/clinica?useUnicode=true&characterEncoding=utf-8","root", "");
        //con = DriverManager.getConnection("jdbc:mysql://localhost/clinica?useUnicode=true&characterEncoding=utf-8","root", "");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return con;
    }   
}
