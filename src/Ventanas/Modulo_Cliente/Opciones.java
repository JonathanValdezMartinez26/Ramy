package Ventanas.Modulo_Cliente;

import Clases.Conexion;
import static Ventanas.Modulo_Cotizaciones_Consolidado.Opciones.cn;
import static Ventanas.Modulo_Cotizaciones_Mensual.Opciones.cn;
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
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.pnlClientes.tabla1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Clases.Clientes.LISTAR;
        } else {
            
            sql = "SELECT * FROM clientev WHERE (ID_Cliente LIKE'" + busca + "%' OR "
                    + "Nombre_Cliente  LIKE'" + busca + "%' OR Atencion  LIKE'" + busca + "% 'OR estado  LIKE'" + busca + "%'"
                    + " OR municipio   LIKE'" + busca + "%' OR localidad  LIKE'" + busca + "%'"
                    + " OR Calle  LIKE'" + busca + "%')"
                    + " ORDER BY ID_Cliente";
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
                datos [6] = rs.getString(7);
               
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void modificarCliente(int id,String Nombre,String Atencion,String IDLocalidad,String Calle){
    
        String q="UPDATE clientes SET ID_cliente='"+id+"',Nombre_cliente='"+Nombre+"',Atencion='"+Atencion+"',id_localidad='"
                + ""+IDLocalidad+"',Calle='"+Calle+"' where ID_cliente='"+id+"'";
        
        try {
            PreparedStatement pstm = cn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            
                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Datos del Cliente!");
                AC.msj2.setText("Actualizados Correctamente");
                AC.setVisible(true);

         }catch(SQLException e){            
            System.out.println(e);
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);

        }
//            JOptionPane.showMessageDialog(null, "DESDE modificarCliente : ID Cliente a actualizar "+id+" "+Nombre+" "+ " "+
//            Atencion+" "+IDLocalidad+" "+Calle);


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
    
    ////////////////////////////////////////////////////
   public static int verificaRutaCotizacion(int ID_Cliente, int ID_Origen, int ID_Destino) {
        int existe = 0;
  
        String SQL = "SELECT count(Id_Ruta) from ruta where (ID_Cliente = "+ID_Cliente+") and (ID_Origen = "+ID_Origen+") and (ID_Destino = "+ID_Destino+")";
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
   public static int verificaViaje(int ID_Cliente) {
        int existe = 0;
  
        String SQL = "SELECT count(ID_Cliente) from rutav where (ID_Cliente = '"+ID_Cliente+"')";
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
    ////////////////////////////////////////////////////
    
    public static void listarOrigen(String busca, int ID) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.Registrar.tabla.getModel();
        int contador = 0;
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "Select ID_Origen, estado_nombre, municipio, fecha_registro from origenv where ID_Cliente =" + ID;
      
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
        String sql = "";
        if (busca.equals("")) {
            sql= "Select ID_Ruta, ID_Municipio_Origen,Origen, ID_Municipio_Destino,Destino, Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full from rutav"
               + " where ID_Cliente ="+ID+" ORDER BY Origen,Destino";
        } else {
            
            sql= "Select ID_Ruta, ID_Municipio_Origen,Origen, ID_Municipio_Destino,Destino, Camioneta_1_5,Camioneta_3_5,Rabon,Torthon,Trailer,Full from rutav"
                    + " where (ID_Cliente =" + ID + " AND Origen LIKE '%" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Destino LIKE '%" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Camioneta_1_5 LIKE '" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Camioneta_3_5 LIKE '" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Rabon LIKE '" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Torthon LIKE '" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Trailer LIKE '" + busca + "%')"
                    + " OR (ID_Cliente =" + ID + " AND Full LIKE '" + busca + "%')"
                    + " ORDER BY Origen,Destino";

//            sql = "Select ID_asigna_Cotizacion_Renta,Concepto, Periodo,Precio  from asigna_cotizaciones_Rentav"
//                    + " where  (ID_Cotizacion =" +ID+" AND Periodo LIKE '%"+ busca +"%')"
//                    + " OR (ID_Cotizacion =" +ID+" AND Concepto LIKE '"+ busca +"%')"
//                    + " OR (ID_Cotizacion =" +ID+" AND Precio LIKE '"+ busca +"%')";
//            
           }
        
      
      
            String datos[] = new String[11];
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
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                               
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
        String sql = "Select ID_Destino, estado_nombre, municipio, fecha_registro from destinov where ID_Cliente =" + ID;
      
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

public static void listarDetalles(int ID,String nombre, String atencion, String direccion) {
        DefaultTableModel modelo = (DefaultTableModel) Ventanas.Modulo_Cliente.pnlPacientePersonalizado.tabla.getModel();
        int contador = 0;
        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblPaciente.setText(nombre);
        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblGenero.setText(atencion);
        Ventanas.Modulo_Cliente.pnlPacientePersonalizado.lblDireccion.setText(direccion);
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        //String sql = "Select ID_Cotizacion, Fecha_Alta, Estatus from cotizacionesv where ID_Cliente =" + ID;
        //String sql = "Select ID_Cotizacion, Fecha_Alta, Estatus from cotizaciones where ID_Cliente="+ID;
        String sql= "Select ID_Cliente, Fecha_Alta, CASE Estatus WHEN 1 THEN 'Pendiente' WHEN 2 THEN 'Finalizada'"
                + "  WHEN 3 THEN 'Cancelada' END AS Estatus from cotizaciones where ID_Cliente="+ID;
      
            String datos[] = new String[3];
        try 
        {    
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                //datos[3] = rs.getString(4);
                //datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
           
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }     
    public static void AgregarRuta(int IDCliente,int IDOrigen,int IDDestino){
    
        String q = " INSERT INTO ruta (ID_Ruta,ID_Cliente,ID_Origen,ID_Destino,PCamioneta_1_5,PCamioneta_3_5,Rabon,Torthon,Trailer,Full)"
                       + "VALUES (NULL,'"+IDCliente+"','"+IDOrigen+"','"+IDDestino+"',0,0,0,0,0,0)";
               try {
                   PreparedStatement pstm = cn.prepareStatement(q);
                   pstm.execute();
                   pstm.close();
                   
                   Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
                   AC.msj1.setText("¡Datos de Origen-Destino!");
                   AC.msj2.setText("Guardados correctamente");
                   AC.setVisible(true);
                   

               } catch (SQLException e) {
                   System.out.println(e);
                   
                   Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                   AC.msj1.setText("¡Error 3714!");
                   AC.msj2.setText("¡Contacte a servicios ProSystem!");
                   AC.setVisible(true);
                   
               }
        
    }
    public static void eliminarViaje(int idRow){
     
try {
    PreparedStatement pst=(PreparedStatement) cn.prepareStatement("DELETE FROM ruta WHERE ID_Ruta="+idRow);
    pst.executeUpdate();
            Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Se a borrado!");
            AC.msj2.setText("El Viaje");
            AC.setVisible(true);
        }
catch(SQLException e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }

    
    
    
}
  
    
    
