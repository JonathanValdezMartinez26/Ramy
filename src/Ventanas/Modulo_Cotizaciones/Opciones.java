package Ventanas.Modulo_Cotizaciones;

import Clases.Conexion;
import static Ventanas.Modulo_Cotizaciones_Consolidado.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones_Mensual.Opciones.cn;
import static Ventanas.Modulo_Ruta_Cotizacion.Opciones.cn;
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
            sql = "Select * from cotizacionesv where Estado = 0";
        } else {
            
//            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta, Estatus from cotizacionesv where Estado = 0 AND Nombre_Cliente LIKE '%" + busca +"%' OR Atencion LIKE '%"+ busca +"%' OR Fecha_Alta LIKE '%"+ busca +"%' OR Estatus LIKE '%"+busca+"%'";
            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta,Tipo_Cotizacion, Estatus from cotizacionesv "
                    + "where Estado = 0 AND Nombre_Cliente LIKE '%" + busca +"%' AND Estado=0 "
                    + " OR Atencion LIKE '%"+ busca +"%'  AND Estado=0"
                    + " OR Fecha_Alta LIKE '%"+ busca +"%' AND Estado=0 "
                    + " OR Estatus LIKE '%"+busca+"%'AND Estado=0"
                    + " OR Tipo_Cotizacion LIKE '%"+busca+"%'AND Estado=0";
            
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
                datos [5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///////////////////////////////////////
    
    public static void listar(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_Cotizacion, Origen, Destino,Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full,Estado from asigna_cotizacionv"
                    + " where ID_Cotizacion =" + ID;
        } else {
            
             sql = "Select ID_Cotizacion, Origen, Destino,Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full,Estado from asigna_cotizacionv"
                    + " where ID_Cotizacion =" + ID+" AND Destino LIKE '%"+busca+"%'"
                     + "OR ID_Cotizacion =" + ID+" AND Camioneta_1_5 LIKE '%"+busca+"%'";
              
           }
        
        Object datos[] = new Object[12];
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
                datos [5] = rs.getString(6);
                datos [6] = rs.getString(7);
                datos [7] = rs.getString(8);
                datos [8] = rs.getString(9);
                
                
                 if(rs.getString(10).equals("1")){
			 datos[9]=Boolean.TRUE;
			}else{
			 datos[9]=Boolean.FALSE;
			}	
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
               sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;

                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();
                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Esta cotización!");
                        AC.msj2.setText("A sido Eliminada");
                        AC.setVisible(true);
                            
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
            sql = "Select ID_GuardarCotD,ID_Cotizacion, Origen, Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado from guardar_cotizacion_directa"
                    + " where ID_Cotizacion =" + ID +" ORDER BY Origen, Destino ASC";
        } else {
            
//             sql = "Select ID_asigna_Cotizacion,ID_Cotizacion, Origen, Destino,Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full,Estado from asigna_cotizacionv"
//                    + " where ID_Cotizacion =" + ID+" AND Destino LIKE '%"+busca+"%'"
//                     + "OR ID_Cotizacion =" + ID+" AND Camioneta_1_5 LIKE '%"+busca+"%'";
              
           }
        
        Object datos[] = new Object[12];
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
                datos [5] = rs.getString(6);
                datos [6] = rs.getString(7);
                datos [7] = rs.getString(8);
                datos [8] = rs.getString(9);
                datos [9] = rs.getString(10);
                 if(rs.getString(11).equals("1")){
			 datos[10]=Boolean.TRUE;
			}else{
			 datos[10]=Boolean.FALSE;
			}	
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///////////////////////////////////////////////////////////////////
    public static int verificaRutaCotizacion(int ID_Cotizacion, int ID_Ruta) {
        int existe = 0;
  
        String SQL = "SELECT count(Id_Cotizacion) from asigna_cotizacion where (ID_Cotizacion = "+ID_Cotizacion+") and (ID_Ruta = "+ID_Ruta+")";
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
    
    public static void finalizarCotizacion(String IDCotizacion){
        String sql = "";               
               sql="UPDATE cotizaciones Set Estatus = '2' Where ID_Cotizacion =" + IDCotizacion;
                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Esta cotización!");
                        AC.msj2.setText("A sido Finalizada");
                        AC.setVisible(true);
                            
                            //res=true;
                         }catch(SQLException e){            
                            System.out.println(e);
                        }

    }
    public static void insertarServicio(int ID_Cotizacion){
        
           String q = " INSERT INTO servicios (ID_Servicio,ID_Cotizacion,Nombre_Servicio,Precio)"
                                        + "VALUES (NULL,'"+ID_Cotizacion+"','',0)";      
                                        try {PreparedStatement pstm = cn.prepareStatement(q);
                                    pstm.execute();
                                    pstm.close();
                                    Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                                    AC.msj1.setText("¡Agrega Nombre y Precio!");
                                    AC.msj2.setText("A la Tabla Servicios");
                                    AC.setVisible(true);
                                    
                                    }catch(SQLException e){            
                                    System.out.println(e);}
                                        
    }
    
    public static void llenarServicio(int ID_Cotizacion){


    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones1.jTable1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        
            sql = "Select ID_Servicio, ID_Cotizacion, Nombre_Servicio,Precio from servicios where ID_Cotizacion =" + ID_Cotizacion;
        
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
                datos [4] = "";
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public static void eliminarServicio(int idRow){
     
try {
    PreparedStatement pst=(PreparedStatement) cn.prepareStatement("DELETE FROM servicios WHERE ID_Servicio="+idRow);
    pst.executeUpdate();
            Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Se a borrado!");
            AC.msj2.setText("El servicio");
            AC.setVisible(true);
        }
catch(SQLException e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }
    
public static void llenarServicioMod(int ID_Cotizacion){
DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.ModificarCotizaciones.jTable1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        
            sql = "Select ID_Servicio, ID_Cotizacion, Nombre_Servicio,Precio from servicios where ID_Cotizacion =" + ID_Cotizacion;
        
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
                datos [4] = "";
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
public static int verificaViajeGuardado(int ID_Cotizacion,String Origen,String Destino) {
        int existe = 0;
  
        
        String SQL = "SELECT count(Id_Cotizacion) from guardar_cotizacion_directa where (ID_Cotizacion = "+ID_Cotizacion+") and (Origen LIKE '"+Origen+"')and (Destino LIKE '"+Destino+"')";
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
    public static void AgregarViajeGuardado(int IDCotizacion,String Origen,String Destino) {
        String q = " INSERT INTO guardar_cotizacion_directa (ID_GuardarCotD,ID_Cotizacion,Origen,Destino,Camioneta_15,Camioneta_35,Rabon,Torthon,Trailer,Full,Estado)"
                + "VALUES (NULL,'" + IDCotizacion + "','" +Origen + "','" + Destino + "',0,0,0,0,0,0,1)";

        try {
            PreparedStatement pstm = cn.prepareStatement(q);
            pstm.execute();
            pstm.close();
           

        } catch (SQLException e) {
            System.out.println(e);
            Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProSystem!");
            AC.setVisible(true);

        }
    }
    
}
    
    
    
