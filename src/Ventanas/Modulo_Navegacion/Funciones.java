
package Ventanas.Modulo_Navegacion;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Funciones {
    
    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static String verificaPassword(String usuario) {
        String existe = "";
        String SQL = "select Contrasena_Usuario from usuario where Usuario = '"+ usuario+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
    
     public static boolean actualizarPass(String id, String pass) {
        String sql = "UPDATE usuario SET Contrasena_Usuario = ? WHERE ID_Usuario = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return false;
    }
     
     public static String obtenerUsuario(String id) {
        String existe = "";
        String SQL = "SELECT Usuario FROM usuario WHERE ID_Usuario = "+ id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
     
     public static String obtenerID(String usuario) {
        String existe = "";
        String SQL = "SELECT ID_Usuario FROM usuario WHERE Usuario = '"+ usuario+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
     
     public static String obtenerIDM(String usuario) {
        String existe = "";
        String SQL = "SELECT ID_Medico FROM Medico as M, Usuario as U WHERE U.Usuario = '" +usuario+"' and U.ID_Usuario=M.ID_Usuario";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
     
     public static boolean actualizarUs(String id, String usNu) {
        String sql = "UPDATE usuario SET Usuario = ? WHERE ID_Usuario = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usNu);
            ps.setString(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return false;
    }
    
}
