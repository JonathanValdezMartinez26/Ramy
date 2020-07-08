/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Modulo_Cita;

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

/**
 *
 * @author jona
 */
public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cita.pnlCitas.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Cita.LISTAR;
        } else {
            
            sql = "SELECT ID_ConsultaOrdinaria,Nombres_Med,Apellidos_Med,Fecha_Cita,Dia_Cita,Hora_Cita,Nombres,Apellidos,Estado FROM CitaV WHERE (ID_ConsultaOrdinaria LIKE'" + busca + "%' OR "
                    + "Nombres_Med LIKE'" + busca + "%' OR Apellidos_Med LIKE'" + busca + "%' OR "
                    + "DATE_FORMAT(Fecha_Cita, '%d/%m/%Y' ) LIKE'" + busca + "%' OR Dia_Cita LIKE'" + busca + "%' OR "
                    + "Hora_Cita LIKE'" + busca + "%' OR Nombres LIKE'" + busca + "%' OR "
                    + "Apellidos LIKE'" + busca + "%' OR Estado LIKE'" + busca +"%') "
                    + " ORDER BY Fecha_Cita Desc, Hora_Cita Asc";
        }
        String datos[] = new String[7];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                String Medico = "Dr. " + rs.getString(2).trim() + " " + rs.getString(3).trim();
                datos[1] = Medico;
                SimpleDateFormat SDF = new SimpleDateFormat("dd/MMM/yyyy");
                Date Fecha = rs.getDate(4);
                datos[2] = SDF.format(Fecha);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                String Paciente = rs.getString(7).trim() + " " + rs.getString(8).trim();
                datos[5] = Paciente;
                datos[6] = rs.getString(9);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void listarCitasBuscar(String busca, int ID_M) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cita.pnlCitasMedico.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql="";
        if (busca.equals("")) {
            sql = "SELECT ID_ConsultaOrdinaria,Nombres_Med,Apellidos_Med,Fecha_Cita,Dia_Cita,Hora_Cita,Nombres,Apellidos,Estado FROM CitaV where ID_Medico="+ ID_M+" ORDER BY ID_Cita Desc";   

        } else {
            
            
               sql = "SELECT ID_ConsultaOrdinaria,Nombres_Med,Apellidos_Med,Fecha_Cita,Dia_Cita,Hora_Cita,Nombres,Apellidos,Estado FROM CitaV WHERE (ID_ConsultaOrdinaria LIKE'" + busca + "%' OR "
                    + "Nombres_Med LIKE'" + busca + "%' OR Apellidos_Med LIKE'" + busca + "%' OR "
                    + "DATE_FORMAT(Fecha_Cita, '%d/%m/%Y' ) LIKE'" + busca + "%' OR Dia_Cita LIKE'" + busca + "%' OR "
                    + "Hora_Cita LIKE'" + busca + "%' OR Nombres LIKE'" + busca + "%' OR "
                    + "Apellidos LIKE'" + busca + "%' OR Estado LIKE'" + busca +"%') "
                    + " and ID_Medico = "+ ID_M + " ORDER BY Fecha_Cita Desc, Hora_Cita Asc";
        }
        String datos[] = new String[7];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                String Medico = "Dr. " + rs.getString(2).trim() + " " + rs.getString(3).trim();
                datos[1] = Medico;
                SimpleDateFormat SDF = new SimpleDateFormat("dd/MMM/yyyy");
                Date Fecha = rs.getDate(4);
                datos[2] = SDF.format(Fecha);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                String Paciente = rs.getString(7).trim() + " " + rs.getString(8).trim();
                datos[5] = Paciente;
                datos[6] = rs.getString(9);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public static int verificaCita() {
        int existe = 0;
        String SQL = "select count(ID_Cita) from cita";
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
     
     public static int verificaConsultaordinaria(Date Fecha) {
         
        long date = Fecha.getTime();
        java.sql.Date FechaC = new java.sql.Date(date);
        
        int existe = 0;
        String SQL = "select count(ID_ConsultaOrdinaria) from ConsultaOrdinaria where Fecha ='"+ FechaC +"' and estado = 1";
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