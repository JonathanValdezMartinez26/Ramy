package Ventanas.Modulo_Ruta_Cotizacion;

import Ventanas.Modulo_Cotizaciones.*;
import Clases.Conexion;
import Clases.Cotizaciones;
import static Ventanas.Modulo_Cliente.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones.Opciones.cn;
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
            
          sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta,Tipo_Cotizacion,Estatus from cotizacionesv where Estado=0 AND Nombre_Cliente LIKE '%" + busca +"%' AND Estado=0 OR Atencion LIKE '%"+ busca +"%'  AND Estado=0 OR Fecha_Alta LIKE '%"+ busca +"%' AND Estado=0 OR Estatus LIKE '%"+busca+"%' AND Estado=0 ";
            
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
    public static int verificaRutaCotizacion1(int ID_Cotizacion, int ID_Origen, String Destinos ,int ID_transporte) {
        int existe = 0;
  
        String SQL = "SELECT count(Id_Cotizacion) from Cotizaciones_ruta where (ID_Cotizacion = "+ID_Cotizacion+")  and (ID_Origen = "+ID_Origen+") and  (Destino = '" + Destinos +"') and  (ID_Transporte = "+ID_transporte+") ";
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
    
    public static void registrarCotizacionesRuta(int ID_Cotizacion,int ID_Cliente, int IDOrigen,String Origen,String destino,int ID_Transporte,String Transportes){
        String q = " INSERT INTO  cotizaciones_ruta(ID_CotizacionRuta,ID_Cotizacion,ID_Cliente,ID_Origen,Origen,Destino,ID_Transporte,Transporte,Precio)"
                     + "VALUES (NULL,'"+ID_Cotizacion+"','"+ID_Cliente+"','"+IDOrigen+"','"+Origen+"','"+destino+"','"+ID_Transporte+"','"+Transportes+"','0')";      
                                        try {PreparedStatement pstm = cn.prepareStatement(q);
                                    pstm.execute();
                                    pstm.close();
                                    }catch(SQLException e){            
                                    System.out.println(e);}
                                        
                                        AgregarCotizacionesRuta.cmbOrigenes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbDestinos.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbTransportes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.ID_rutas.setText("");
                                        
                                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                                        AC.msj1.setText("¡Cotizacion Agregada!");
                                        AC.msj2.setText("Correctamente");
                                        AC.msj3.setText("Asigne el precio correspondiente");
                                        AC.setVisible(true);
                                        Opciones.listar("",ID_Cotizacion );
        
    }
    public static void listar(String busca, int ID_Cotizacion) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from Cotizaciones_ruta where ID_Cotizacion =" + ID_Cotizacion;
        } else {
            
            sql = "Select ID_CotizacionRuta, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID_Cotizacion;
            
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
  
    public static void inicializarCombox(){
                                         AgregarCotizacionesRuta.cmbOrigenes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbDestinos.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbTransportes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.ID_rutas.setText("");

    }
    public static void agregarCotizacionRuta(int IDCotizacion, int IDRuta, int IDCliente){        
                                    
           try {
          String q = " INSERT INTO asigna_ruta_servicio (ID_AsignaRutaServicio,ID_CotizacionRuta,ID_CotizacionRuta,ID_Cliente,ID_Cotizacion)"
                     + "VALUES (NULL,'"+IDRuta+"','"+IDCliente+"','"+IDCotizacion+"')";      
                                    
                                    PreparedStatement pstm = cn.prepareStatement(q);
                                    pstm.execute();
                                    pstm.close();
                               
                                    Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                                    AC.msj1.setText("¡Servicio Agregado!");
                                    AC.msj2.setText("Correctamente");
                                    AC.setVisible(true);
                                    
               }catch(SQLException e){ 
                   
                                    System.out.println(e);
                                    Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                    AC.msj1.setText("¡Error 3714!");
                                    AC.msj2.setText("¡Contacte a servicios ProSystem!");
                                    AC.setVisible(true);
                               }
    }
        
    
        
    
    
    public static int verificaCliente(int ID_Cliente) {
        int existe = 5;
 
        //SELECT count(Id_Cliente) from cotizaciones_ruta where (ID_Cliente = "72")
        String SQL = "SELECT count(Id_Cliente) from cotizaciones_ruta where (ID_Cliente = "+ID_Cliente+")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, existe+" "+ID_Cliente);
        return existe;
    }
    public static void listarDetallesCotizaciones(String busca,int IDCotizacion,String cliente, String IDCliente) {
        pnlRutasGuardadas.lblID.setText(""+IDCliente);
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.pnlRutasGuardadas.tabla.getModel();
        int contador = 0;
        String sql="";
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
            sql = "Select ID_CotizacionRuta,ID_Cotizacion,ID_Cliente ,ID_Origen,Origen, Destino,ID_Transporte,Transporte,Precio from cotizaciones_ruta where ID_Cotizacion ="+IDCotizacion+" AND ID_Cliente="+IDCliente;
        
            String datos[] = new String[12];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = String.valueOf(rs.getInt(2));
                datos[2] = String.valueOf(rs.getInt(3));
                datos[3] = String.valueOf(rs.getInt(4));
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = String.valueOf(rs.getInt(7));
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
//                datos[9] = rs.getString(10);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Ventanas.Modulo_Cliente.Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        
    }     
    public static void listarCotizacionRuta(String busca, String ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from cotizaciones_ruta where ID_Cotizacion =" + ID;
        } else {
            
            sql = "Select ID_CotizacionRuta, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
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
//    
//    public static void agregarAsigna(String IDCR,String IDCoti,String IDCli,String IDOri,String Ori,String Desti,String IDTrans,String Trans,String Precio){
//        
//        String q = " INSERT INTO asigna_ruta_servicio (ID_AsignaRutaServicio,ID_RutaCotizacion,ID_Cliente,ID_Origen,Origen,Destino,ID_Transporte,Transporte,Precio)"
//                + "VALUES (NULL,'"+IDCR+"','"+IDCli+"','"+IDOri+"','"+Ori+"','"+Desti+"','"+IDTrans+"','"+Trans+"','"+Precio+"')";
//        ////INSERT INTO `bitacora_costos` (`ID_Bitacora`, `Nombre_Viaje`, `costo_antiguo`, `costo_nuevo`,
//        //`Fecha_Mod`, `ID_ClienteB`) VALUES (NULL, 'Villa,donato', '300', '400', current_timestamp(), '71');
//        try {
//            PreparedStatement pstm = cn.prepareStatement(q);
//            pstm.execute();
//            pstm.close();
//            
//         }catch(SQLException e){            
//            System.out.println(e);
//        }
//        JOptionPane.showMessageDialog(null, "Datos agregados");
//        
//    }
    public static void listarAsigna(String busca/*,String ID*/) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
            sql = "Select ID_Cotizacion_Ruta,ID_Cliente,ID_Origen, Origen, Destino,ID_Transporte,Transporte,Precio from Cotizaciones_ruta";
//            sql = "Select ID_AsignaRutaServicio, Origen, Destino,Transporte,Precio from asigna_ruta_servicio";
        } else {
            
            //sql = "Select ID_asigna_Cotizacion, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
           }
        String datos[] = new String[6];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos [0] = String.valueOf(rs.getInt(1));
                datos [1] = String.valueOf(rs.getInt(2));
                datos [2] = String.valueOf(rs.getInt(3));
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                datos [5] = String.valueOf(rs.getInt(6));
                datos [6] = rs.getString(7);
                datos [7] = rs.getString(8);
                
                modelo.addRow(datos);
            }
            
            modelo.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Ventanas.Modulo_Ruta_Cotizacion.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     ///////////////////////////////////////////////////////////////////
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


    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla1.getModel();

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
            Logger.getLogger(Ventanas.Modulo_Cotizaciones_Mensual.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public static void llenarServicioModificar(int ID_Cotizacion){


    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla1.getModel();

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
            Logger.getLogger(Ventanas.Modulo_Cotizaciones_Mensual.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
   
    public static void eliminarServicio(int idRow){
     
try {
    PreparedStatement pst=(PreparedStatement) cn.prepareStatement("DELETE FROM servicios WHERE ID_Servicio="+idRow);
    pst.executeUpdate();
            Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Se a borrado!");
            AC.msj2.setText("El Adicional");
            AC.setVisible(true);
        }
catch(SQLException e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }
    public static void finalizarCotizacion(String IDCotizacion){
        String sql = "";               
               sql="UPDATE cotizaciones Set Estatus = '2' Where ID_Cotizacion =" + IDCotizacion;
                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Cotizacion Finalizada!");
                        AC.msj2.setText("Cierre la Ventana para Continuar");
                        AC.setVisible(true);
                        
                            
                            //res=true;
                         }catch(SQLException e){            
                            System.out.println(e);
                        }

    }    
    
}
    
    
    
