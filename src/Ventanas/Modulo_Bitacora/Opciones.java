package Ventanas.Modulo_Bitacora;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static Conexion cc = new Conexion();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

        public static void CargarDatos(int id){
    
    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacora.tabla.getModel();
    modelo.setRowCount(0);
    
    int contador = 0;
    String datos[] = new String[6];
    
        String sql ="Select Nombre_Viaje,costo_antiguo,costo_nuevo,transporte,Fecha_Mod from bitacora_costos Where ID_ClienteB = "+ id;
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String Dia = rs.getString(1);

           
            datos [0] = Dia;
            datos [1] = rs.getString(2);
            datos [2] = rs.getString(3);
            datos [3] = rs.getString(4);
            datos [4] = rs.getString(5);

            modelo.addRow(datos);
            }
           
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacora.tablabitacora.getModel();
        DefaultTableModel modelot = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacora.tabla.getModel();

        modelot.setRowCount(0);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Bitacora.LISTARM;
        } else {        
            //sql = "select ID_Medico,concat_ws(' ',Nombres,Apellidos) as Medico, Cedula from medico where concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Medico LIKE '"+ busca +"%' OR Cedula LIKE '"+ busca +"%' and Estado = true";
            //sql = "select clientes(' ',Nombres,Apellidos) as Medico, Cedula from medico where concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Medico LIKE '"+ busca +"%' OR Cedula LIKE '"+ busca +"%' and Estado = true";
            sql = "SELECT ID_cliente, Nombre_cliente FROM clientes WHERE (Nombre_cliente LIKE'" + busca + "%' OR ID_cliente LIKE'"+busca+"%')"
                    + " ORDER BY Nombre_cliente";
           }
        String datos[] = new String[2];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
//                datos [2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void listarBitacora(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacora.tablabitacora.getModel();
        DefaultTableModel modelot = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacora.tabla.getModel();

        //modelo.setRowCount(0);
        while (modelot.getRowCount() > 0) {
            modelot.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Bitacora.LISTARB;
        } else {        
            //sql = "select ID_Medico,concat_ws(' ',Nombres,Apellidos) as Medico, Cedula from medico where concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Medico LIKE '"+ busca +"%' OR Cedula LIKE '"+ busca +"%' and Estado = true";
            //sql = "select clientes(' ',Nombres,Apellidos) as Medico, Cedula from medico where concat_ws(' ',Nombres,Apellidos) LIKE '%" + busca +"%' OR ID_Medico LIKE '"+ busca +"%' OR Cedula LIKE '"+ busca +"%' and Estado = true";
            //sql = "SELECT ID_cli, Nombre_cliente FROM clientes WHERE (Nombre_cliente LIKE'" + busca + "%' OR ID_cliente LIKE'"+busca+"%')"
              //      + " ORDER BY Nombre_cliente";
            sql = "SELECT Nombre_Viaje, costo_antiguo,costo_nuevo,transporte,Fecha_Mod from bitacora_costos WHERE (Nombre_Viaje LIKE'%" + busca + "%' OR costo_antiguo LIKE'"+busca+"%'"
                    + "OR costo_nuevo LIKE'"+busca+"%'OR transporte LIKE'"+busca+"%'OR Fecha_Mod LIKE'%"+busca+"%')"
                    + " ORDER BY Fecha_Mod";
            
           }
        String datos[] = new String[6];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = rs.getString(1);
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
//                datos [2] = rs.getString(3);
                
                modelot.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ///////////////////////////////////////////////////////////////////
    public static int verificaRutaCotizacion(int ID_Cliente, int ID_Origenes, int ID_Destinos, int ID_Transporte) {
        int existe = 0;
  
        String SQL = "SELECT count(Id_Ruta) from rutav where (ID_Cliente = "+ID_Cliente+") and (ID_Municipio_Origen = "+ID_Origenes+") and (ID_Municipio_Destino = "+ID_Destinos+") and (ID_Transporte = "+ID_Transporte+")";
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


    public static void listarClientesAjustes(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacoraAjustes.tablabitacora.getModel();
        DefaultTableModel modelot = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacoraAjustes.tablaFAjuste.getModel();

        modelot.setRowCount(0);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            //sql = Clases.Bitacora.LISTARM;
            sql = "select ID_cliente, Nombre_cliente from clientes";
        } else {                    
            sql = "SELECT ID_cliente, Nombre_cliente FROM clientes WHERE (Nombre_cliente LIKE'" + busca + "%')"
                    + " ORDER BY Nombre_cliente";
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
    public static void listarAjustes(int id){
    
    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacoraAjustes.tablaFAjuste.getModel();
    DefaultTableModel modelo1 = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacoraAjustes.tablaDatosAjuste.getModel();
    modelo.setRowCount(0);
    modelo1.setRowCount(0);
    
    int contador = 0;
    String datos[] = new String[6];
    
        String sql ="Select ID_Cliente,Fecha_Ajuste from ajuste_precio where ID_Cliente= "+ id;
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {               
            datos [0] = rs.getString(1);
            datos [1] = rs.getString(2);

            modelo.addRow(datos);
            }
           
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void listarDatosAjustes(String busca,int idCliente,String fecha){
    
    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Bitacora.pnlBitacoraAjustes.tablaDatosAjuste.getModel();
    modelo.setRowCount(0);
    
    int contador = 0;
    String datos[] = new String[7];
    
        String sql ="Select ID_Ajuste_Bitacora,Nombre_Viaje,Costo_Antiguo,Costo_Actual,Transporte from asigna_ajuste_bitacora"
                + " where Modificacion= '"+fecha+"' AND ID_Cliente='"+idCliente+"'";
        
        try {    
            String ed= "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {               
            datos [0] = String.valueOf(rs.getInt(1));
            datos [1] = rs.getString(2);
            datos [2] = rs.getString(3);
            datos [3] = rs.getString(4);
            datos [4] = rs.getString(5);
            
            
            modelo.addRow(datos);
            }
           
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    //JOptionPane.showMessageDialog(null,"La fecha es: "+fecha+" y el cliente es: "+idCliente);
    }
}
    
    
    
