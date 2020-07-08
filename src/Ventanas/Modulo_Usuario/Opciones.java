package Ventanas.Modulo_Usuario;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
       
public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Usuario.pnlUsuarios.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Usuario.LISTAR;
        } else {
            
            sql = "select ID_usuario,Nombre_Usuario,Correo_Electronico,Rol,Estado from UsuarioV WHERE ("
                    + "ID_usuario LIKE'" + busca + "%' OR Correo_Electronico LIKE'" + busca + "%' OR "
                    + "Rol LIKE'" + busca +"%' OR Estado LIKE'" + busca + "%' OR Nombre_Usuario LIKE'" + busca + "%') AND ID_Usuario!= 1";
            
           }
        String datos[] = new String[5];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     

    public static boolean registrar(Sentencias uc) {
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId());
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getUsuario());
            ps.setString(4, uc.getPassword());
            ps.setString(5, uc.getEmail());
            ps.setInt(6, uc.getTipo_usuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return false;
    }
    
    public static int verificarUsuarios() {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM usuario";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }
            
            return c;

        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static String verificaUsuario(String usuario) {
        String existe = "";
        String SQL = "SELECT usuario FROM usuario WHERE usuario = '"+ usuario+"'";
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
    public static String verificaNombreUsuario(String usuario) {
        String existe = "";
        String SQL = "SELECT Nombre_Usuario FROM usuario WHERE usuario = '"+ usuario+"'";
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
    
    public static String verificaUsuarioCorreo(String correo) {
        String existe = "";
        String id = "";
        String user = "";
        String SQL = "SELECT Correo_Electronico, ID_Usuario, Nombre_Usuario FROM usuario WHERE Correo_Electronico= '"+ correo +"' and Estado = true" ;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
                id = rs.getString(2);
                user = rs.getString(3);
            }           
            Ventanas.ModuloContrasena.AsistenciaContrasena.id.setText(id);
            Ventanas.ModuloContrasena.AsistenciaContrasena.user.setText(user);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
    
    public static String extraerNombre(String id) {
        String nombre = "";
        String SQL = "SELECT nombre FROM usuario WHERE id = "+ id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                nombre = rs.getString(1);
            }
            return nombre;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nombre;
    }
    
    public static String extraerPassword(String id) {
        String password = "";
        String SQL = "SELECT password FROM usuario WHERE id = '"+id+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                password = rs.getString(1);
            }
            return password;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return password;
    }
    
    
    public static int verificaNombreUser(String usuario) {
        int existe = 0;
        String SQL = "SELECT COUNT(Nombre_Usuario) FROM Usuario WHERE Nombre_usuario = '"+ usuario+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
    
     public static int verificaUser(String usuario) {
        int existe = 0;
        String SQL = "SELECT COUNT(Nombre_Usuario) FROM usuario WHERE usuario = '"+ usuario+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }
     
     public static int verificaUsuarioEmail(String correo) {
        int existe = 0;
        String SQL = "SELECT count(Correo_Electronico) FROM usuario WHERE Correo_Electronico= '"+ correo +"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return existe;
    }

}
