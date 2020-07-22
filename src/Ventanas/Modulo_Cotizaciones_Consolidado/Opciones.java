package Ventanas.Modulo_Cotizaciones_Consolidado;
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
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Consolidado.AgregarCotizaciones_Consolidado.tablaR.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
           sql = "Select ID_Cotizacion_Consolidado, Consolidado, Precio from asigna_cotizacion_Consolidado where ID_Cotizacion="+ ID;
        } else {
            
            sql = "Select ID_Cotizacion_Consolidado, Consolidado, Precio from asigna_cotizacion_Consolidado where  Consolidado LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' AND ID_Cotizacion =" + ID;
            
           }
        String datos[] = new String[3];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = rs.getString(2);
                datos [2] = String.valueOf(rs.getInt(3));
                
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
               sql="delete from asigna_cotizacion_consolidado where ID_Cotizacion_Consolidado =" + ID;

                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();
                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Esta Registro!");
                        AC.msj2.setText("A sido Eliminado");
                        AC.setVisible(true);
                        Opciones.listar("", ID);
                        pstm.close();
                        
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
    public static int verificaConsolidado(int ID_Cotizacion,String Consolidado) {
        int c = 0;
        String SQL = "SELECT COUNT(Id_Cotizacion)FROM Asigna_Cotizacion_Consolidado where (ID_Cotizacion = "+ID_Cotizacion+") and (Consolidado = '"+Consolidado+"')";
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
    
        public static boolean registrar(Clases.CotizacionesConsolidado uc) {
        String sql = Clases.CotizacionesConsolidado.registrar;

        try {
            
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getID_Asigna_Cotizacion());
            ps.setInt(2, uc.getID_Cotizacion());
            ps.setString(3,uc.getConsolidado());
            ps.executeUpdate();
          
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return false;
    }
    
     ///////////////////////////////////////////////////////////////////
    

     public static int verificaTipo(String Nombre) {
        int existe = 0;
        String SQL = "select count(Consolidado) from Consolidado where Consolidado = '"+ Nombre+"'";
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
     
     public static void listar1(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Consolidado.pnlTipoConsolidado.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.CotizacionesConsolidado.LISTA;
        } else {
            
//            sql = "SELECT * FROM Tipo_Transporte WHERE (ID_Tipo_Transporte LIKE'" + busca + "%' OR "
//                    + "Tipo_Transporte LIKE'" + busca + "%') "
//                    + "ORDER BY ID_Tipo_Transporte";
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
     
   
    
}
    
    
    
