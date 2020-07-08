/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Modulo_Tipo_Transportes;

import Ventanas.Modulo_Tipo_Transportes.Opciones;
import Clases.Conexion;
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
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Tipo_Transportes.pnlTipoTransportes.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Tipo_Transporte.LISTAR;
        } else {
            
            sql = "SELECT * FROM Tipo_Transporte WHERE (ID_Tipo_Transporte LIKE'" + busca + "%' OR "
                    + "Tipo_Transporte LIKE'" + busca + "%') "
                    + "ORDER BY ID_Tipo_Transporte";
           }
        String datos[] = new String[2];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
          
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static int verificaTipo(String Nombre) {
        int existe = 0;
        String SQL = "select count(Tipo_Transporte) from Tipo_Transporte where Tipo_Transporte = '"+ Nombre+"'";
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
     
      public static int verificaTipoTran(String Tipo_Transporte, int id) {
        int c = 0;
        String SQL = "SELECT COUNT(*) FROM Tipo_Transporte where Tipo_Transporte = " + Tipo_Transporte +" and ID_Tipo_Transporte != " + id;
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