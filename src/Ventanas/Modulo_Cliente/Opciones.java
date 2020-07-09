package Ventanas.Modulo_Cliente;

import Clases.Conexion;
import static Ventanas.Modulo_Tipo_Transportes.Opciones.cn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.pnlClientes.tabla.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Clientes.LISTAR;
            
            String datos[] = new String[7];
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
                modelo.addRow(datos);
            }
            if(contador == 0 && !busca.equals("")){
            datos[3]= "Sin Clientes...";
            modelo.addRow(datos);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
        else 
        {   
            sql = "SELECT id_Paciente, concat_ws(' ',Nombres,Apellidos) as persona, Fecha_Nac,Nombre_Tutor,Telefono,Direccion,Estado FROM paciente WHERE concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Paciente LIKE '"+ busca +"%' OR DATE_FORMAT(Paciente.Fecha_Nac, '%d/%m/%Y' ) LIKE '%"+ busca +"%' OR Nombre_Tutor LIKE '" + busca +"%' OR Telefono LIKE'"+ busca +"%' OR Direccion LIKE'"+ busca +"%' OR Estado LIKE'"+ busca +"%' ORDER BY ID_Paciente";         
            String datos[] = new String[7];
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                String Paciente =  rs.getString(2).trim();
                datos[1] = Paciente;
                String Edad = rs.getString(3).trim();
                try{
                      
                               
                   }
                catch(Exception e){
                    System.out.println(e);
                }
                datos[2] = ed;
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                boolean Estado = rs.getBoolean(7);
                String Estate = "Inactivo";

                if (Estado) {
                    Estate = "Activo";
                }
                datos[6] = Estate;

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }
    ///////////////////////////////////////////////////////////////////
    public static int verificaOrigen(int ID, int Municipio) {
        int existe = 0;
        String SQL = "select count(ID_Municipio) from Origen where ID_Cliente = '"+ ID+"' and ID_Municipio = '" + Municipio +"'";
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
    ///////////////////////////////////////////////////////////////////
    public static int verificaOrigen1(int ID) {
        int existe = 0;
        String SQL = "select count(*) from Origen where ID_Cliente = '"+ ID+"'";
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
    //////////////////////////////////////////////////////////////////
    public static int verificaDestino(int ID, int Municipio) {
        int existe = 0;
        String SQL = "select count(ID_Municipio) from Destino where ID_Cliente = '"+ ID+"' and ID_Municipio = '" + Municipio +"'";
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
    ///////////////////////////////////////////////////////////////////
    public static int verificaOrigenID(int ID) {
        int existe = 0;
        String SQL = "select count(ID_Municipio) from Origen where ID_Cliente = '"+ ID+"'";
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
    
    public static int verificaDestinoID(int ID) {
        int existe = 0;
        String SQL = "select count(ID_Municipio) from Destino where ID_Cliente = '"+ ID+"'";
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
    
    public static void listarOrigen(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "Select ID_Origen, estado, municipio, fecha_registro from origenv where ID_Cliente =" + ID;
      
            String datos[] = new String[4];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public static void listarViaje(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla3.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "Select ID_Ruta, Origen, Destino, Nombre_Transporte,Precio from rutav where ID_Cliente =" + ID;
      
            String datos[] = new String[5];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

     
    public static void listarDestino(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla2.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "Select ID_Destino, estado, municipio, fecha_registro from destinov where ID_Cliente =" + ID;
      
            String datos[] = new String[4];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
       
    public static void listarOrigenDestino(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla2.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "Select ID_Destino, estado, municipio, fecha_registro from destinov where ID_Cliente =" + ID;
      
            String datos[] = new String[4];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
     public static int verificaEmpresa(String Nombre) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM clientes where Nombre_cliente = '" + Nombre +"'";
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
}
  
    
    
