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

//          con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);
            con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);

//          con = DriverManager.getConnection("jdbc:mysql://localhost/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);
<<<<<<< HEAD
//            con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);
=======
            con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);
>>>>>>> 5d4f24112e5426b532c8b7f9dfa336d588e04216

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

//            con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8","root", "");
//           con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8","root", "");

            con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8","root", "");
//           con = DriverManager.getConnection("jdbc:mysql://localhost/clinica?useUnicode=true&characterEncoding=utf-8","root", "");

//           con = DriverManager.getConnection("jdbc:mysql://192.168.100.14/clinica?useUnicode=true&characterEncoding=utf-8", user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return con;
    }   
 
 
         }
