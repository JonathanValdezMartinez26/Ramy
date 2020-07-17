package Ventanas.Modulo_Cotizaciones_Mensual;
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

  
    
///////////////////////////////////////
    public static void listarCotizaciones(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.pnlCotizaciones.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            //sql = "Select * from cotizacionesv";
            sql = "Select * from cotizacionesv where Estado=0";
        } else {
            
            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta, Estatus from cotizacionesv where Estado=0 AND Nombre_Cliente LIKE '%" + busca +"%' AND Estado=0 OR Atencion LIKE '%"+ busca +"%'  AND Estado=0 OR Fecha_Alta LIKE '%"+ busca +"%' AND Estado=0 OR Estatus LIKE '%"+busca+"%' AND Estado=0 ";
            
           }
        String datos[] = new String[6];
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
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///////////////////////////////////////
    
    public static void listar(String busca,  int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tablaR.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
           sql = "Select ID_Asigna_Cotizacion_Renta, Fecha_I, Fecha_F,Nombre_Transporte,Precio from asigna_cotizaciones_Rentav where ID_Cotizacion="+ ID;
        } else {
            
            sql = "Select ID_asigna_Cotizacion_Renta, Fecha_I, Fecha_F,Nombre_Transporte,Precio  from Asigna_Contizaciones_Rentav where  Fecha_I LIKE '"+ busca +"%' OR Fecha_F LIKE '"+ busca +"%' OR  Nombre_Transporte LIKE '%" + busca +"%' OR  Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
           }
        String datos[] = new String[5];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2).trim();;
                datos [2] = rs.getString(3).trim();;
                datos [3] = rs.getString(4);
                datos [4] = String.valueOf(rs.getInt(5));
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void eliminarCotizacion(int ID) {
        
        String sql = "";
               //JOptionPane.showMessageDialog(null, ID);
               sql="delete from asigna_cotizaciones_renta where ID_Asigna_Cotizacion_Renta =" + ID;

                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();
                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Esta cotización!");
                        AC.msj2.setText("A sido Eliminada");
                        AC.setVisible(true);
                            Opciones.listar("", ID);
                            //res=true;
                         }catch(SQLException e){            
                            System.out.println(e);
                        }

    }
    //////////////////////////////////////////////////////////////////
     public static void listarModificar(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.ModificarCotizaciones.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_asigna_Cotizacion, Origen, Destino,Precio from asigna_cotizacionv where ID_Cotizacion =" + ID;
        } else {
            
            sql = "Select ID_asigna_Cotizacion, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
           }
        String datos[] = new String[4];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///////////////////////////////////////////////////////////////////
    public static int verificaRentaM(int ID_Cotizacion,int ID_Periodo) {
        int c = 0;
        String SQL = "SELECT COUNT(Id_Cotizacion)FROM Asigna_Cotizaciones_Renta where (ID_Cotizacion = "+ID_Cotizacion+") and (ID_Periodo = "+ID_Periodo+")";
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
    
        public static boolean registrar(Clases.CotizacionesRentaMen uc) {
        String sql = Clases.CotizacionesRentaMen.registrar;
        
       
        
        
        
        try {
            
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getID_Asigna_Cotizacion());
            ps.setInt(2, uc.getID_Cotizacion());
            ps.setInt(3,uc.getID_Periodo());
            ps.executeUpdate();
            
            
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return false;
    }
    
     ///////////////////////////////////////////////////////////////////
    
    public static void listarCotizacionRuta(String busca, String ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from cotizaciones_ruta where ID_Cliente =" + ID;
        } else {
            
            sql = "Select ID_asigna_Cotizacion, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
           }
        String datos[] = new String[6];
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
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Ventanas.Modulo_Ruta_Cotizacion.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
    
    
    
