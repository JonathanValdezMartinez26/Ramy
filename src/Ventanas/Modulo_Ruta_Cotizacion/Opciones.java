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
            
            sql = "Select ID_Cotizacion, Nombre_Cliente, Atencion, Fecha_Alta, Estatus from cotizacionesv where Estado=0 AND Nombre_Cliente LIKE '%" + busca +"%' AND Estado=0 OR Atencion LIKE '%"+ busca +"%'  AND Estado=0 OR Fecha_Alta LIKE '%"+ busca +"%' AND Estado=0 OR Estatus LIKE '%"+busca+"%' AND Estado=0 ";
            
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
    ///////////////////////////////////////
    
    public static void listar(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones.AgregarCotizaciones.tabla.getModel();

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
    public static void guardarFake(String IDCotizacion,String IDCliente ,String IDOrigen,String origen,String IDTrans,String transporte,String destino){
        
        int comboCliente = AgregarCotizacionesRuta.cmbCliente.getSelectedIndex();
        int comboOrigen= AgregarCotizacionesRuta.cmbOrigenes.getSelectedIndex();
        int comboDestino = AgregarCotizacionesRuta.cmbDestinos.getSelectedIndex();
        int comboTransporte = AgregarCotizacionesRuta.cmbTransportes.getSelectedIndex();
        
        if(comboCliente==0)
            {
                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                AC.msj1.setText("¡Elija un");
                AC.msj2.setText("Cliente para Continuar");
                AC.setVisible(true);
            }
            else
            {
                if(comboOrigen==0)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Elija un !");
                        AC.msj2.setText("Origen");
                        AC.setVisible(true);
                    }
                else
                {
                    if(comboDestino==0 && AgregarCotizacionesRuta.tablaDestinos.getRowCount()!=0 && AgregarCotizacionesRuta.tablaDestinos.getSelectedRow()!=-1)
                    {
                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Agrege un Destino!");
                        AC.msj2.setText("a la tabla");
                        AC.setVisible(true);
                    }
                    else
                    {
                        if(comboTransporte==0)
                        {
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Elija un !");
                            AC.msj2.setText("Transporte");
                            AC.setVisible(true);
                        }
                        else
                        {
                             if(comboCliente==0 || comboOrigen==0 || comboDestino==0 || comboTransporte==0)
                            {
                                Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                                AC.msj1.setText("¡Seleccione Un!");
                                AC.msj2.setText("Cliente, Origen - Destino y Transporte");
                                AC.msj3.setText("Para Continuar");
                                AC.setVisible(true);
                            }
                            
                             
                                else
                                {
//                                    if(Ventanas.Modulo_Cotizaciones.Opciones.verificaRutaCotizacion(ID_Cotizacion, ID_Rutas)==0)
//                                    {   

//                                        Cotizaciones.Agregar_RutaCotizacion(ID_Cotizacion, ID_Rutas);
//                                        Ventanas.Modulo_Cotizaciones.Opciones.listar("", ID_Cotizacion);
                                        
                                          String q = " INSERT INTO cotizaciones_ruta (ID_CotizacionRuta,ID_Cotizacion,ID_Cliente,ID_Origen,Origen,Destino,ID_Transporte,Transporte,Precio)"
                                        + "VALUES (NULL,'"+IDCotizacion+"','"+IDCliente+"','"+IDOrigen+"','"+origen+"','"+destino+"','"+IDTrans+"','"+transporte+"','0')";      
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
//                                    }
//                                    else
//                                    {
//                                        Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
//                                        AC.msj1.setText("¡Error!");
//                                        AC.msj2.setText("El Origen - Destino ya Estan");
//                                        AC.msj3.setText("Registrados con el Mismo Transporte");
//                                        AC.setVisible(true);
//                                    }
                                 
                            }    
                        }
                    }
                }  
        } 
    }
    public static void inicializarCombox(){
                                         AgregarCotizacionesRuta.cmbOrigenes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbDestinos.setSelectedItem(0);
                                        AgregarCotizacionesRuta.cmbTransportes.setSelectedItem(0);
                                        AgregarCotizacionesRuta.ID_rutas.setText("");

    }
        
    
        
    
    
    public static int verificaCliente(int ID_Cliente) {
        int existe = 0;
  
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
    public static void listarDetallesCotizaciones(String busca,int IDCliente,String cliente) {
        pnlRutasGuardadas.lblID.setText(""+IDCliente);
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.pnlRutasGuardadas.tabla.getModel();
        int contador = 0;
        String sql="";
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
            sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from cotizaciones_ruta where ID_Cliente =" + IDCliente;
        
            String datos[] = new String[6];
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
     ///////////////////////////////////////////////////////////////////
   public static void listarCotizacionesID(String dato) {
       AgregarCotizacionesRuta.lblIDCoti.setText(""+dato);
       
         DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Ruta_Cotizacion.AgregarCotizacionesRuta.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        //if (busca.equals("")) {
            sql = "Select ID_CotizacionRuta, Origen, Destino,Transporte,Precio from cotizaciones_ruta where ID_CotizacionRuta =" + dato;
        ///} else {
            
            //sql = "Select ID_asigna_Cotizacion, Origen, Destino,Precio from asigna_cotizacionv where  Origen LIKE '%" + busca +"%' OR Destino LIKE '"+ busca +"%' OR Precio LIKE '"+ busca +"%' and ID_Cotizacion =" + ID;
            
           ///}
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
    
    
    
