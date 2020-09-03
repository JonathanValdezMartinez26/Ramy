package Ventanas.Modulo_Cotizaciones_Mensual;
import Clases.Conexion;
import static Ventanas.Modulo_Cotizaciones.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones_Consolidado.Opciones.cn;
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
        String datos[] = new String[7];
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
    
    public static void listar(String busca,  int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tablaR.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        if (busca.equals("")) {
           sql = "Select ID_Asigna_Cotizacion_Renta,Concepto, Periodo,Precio from asigna_cotizaciones_rentav where ID_Cotizacion="+ ID+" ORDER BY Periodo , Concepto ASC";
        } else {
    
            
            sql = "Select ID_asigna_Cotizacion_Renta,Concepto, Periodo,Precio  from asigna_cotizaciones_rentav"
                    + " where  (ID_Cotizacion =" +ID+" AND Periodo LIKE '%"+ busca +"%')"
                    + " OR (ID_Cotizacion =" +ID+" AND Concepto LIKE '"+ busca +"%')"
                    + " OR (ID_Cotizacion =" +ID+" AND Precio LIKE '"+ busca +"%')";
            
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
               sql="delete from asigna_cotizaciones_renta where ID_Asigna_Cotizacion_Renta =" + ID;

                try {
                            PreparedStatement pstm = cn.prepareStatement(sql);
                            pstm.execute();
                            pstm.close();
                            
                        Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                        AC.msj1.setText("¡Este Registro!");
                        AC.msj2.setText("A sido Eliminado");
                        AC.setVisible(true);
                        Opciones.listarModificar("",ID);              
                        pstm.close();
                        
                            //res=true;
                         }catch(SQLException e){            
                            System.out.println(e);
                            
                        }

    }
    //////////////////////////////////////////////////////////////////
     public static void listarModificar(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Mensual.ModificarCotizaciones_Renta.tablaR.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
     String sql = "";
        if (busca.equals("")) {
           sql = "Select ID_Asigna_Cotizacion_Renta,Concepto, Periodo,Precio from asigna_cotizaciones_Rentav where ID_Cotizacion="+ ID;
        } else {
    
            
            sql = "Select ID_asigna_Cotizacion_Renta,Concepto, Periodo,Precio  from asigna_cotizaciones_Rentav"
                    + " where  (ID_Cotizacion =" +ID+" AND Periodo LIKE '%"+ busca +"%')"
                    + " OR (ID_Cotizacion =" +ID+" AND Concepto LIKE '"+ busca +"%')"
                    + " OR (ID_Cotizacion =" +ID+" AND Precio LIKE '"+ busca +"%')";
            
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
    public static int verificaRentaM(int ID_Cotizacion,String Concepto,int ID_Periodo) {
        int c = 0;
        String SQL = "SELECT COUNT(Id_Cotizacion)FROM asigna_cotizaciones_renta where (ID_Cotizacion = "+ID_Cotizacion+") and  (Concepto = '" + Concepto +"')  and  (ID_Periodo = "+ID_Periodo+")";
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
            ps.setString(3, uc.getConcepto());
            ps.setInt(4,uc.getID_Periodo());
            ps.executeUpdate();
            
            
            
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return false;
    }
        public static boolean registrarCotiRenta(int IdCot,String concepto,int IdPer) {

            String q = " INSERT INTO asigna_cotizaciones_renta (ID_Asigna_Cotizacion_Renta,ID_Cotizacion,Concepto,ID_Periodo,Precio)"
                    + "VALUES (NULL,'" + IdCot + "','" + concepto + "','" + IdPer + "',0)";
            try {
                PreparedStatement pstm = cn.prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;

            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }

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


    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Mensual.AgregarCotizaciones_Renta.tabla1.getModel();

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
   
    public static void llenarServicioMod(int ID_Cotizacion){


    DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cotizaciones_Mensual.ModificarCotizaciones_Renta.tabla1.getModel();

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
                        AC.msj1.setText("¡Esta cotización!");
                        AC.msj2.setText("A sido Finalizada");
                        AC.setVisible(true);
                            
                            //res=true;
                         }catch(SQLException e){            
                            System.out.println(e);
                        }

    }    
}   
    

    
    
    
