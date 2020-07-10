package Clases;

import Ventanas.Modulo_Cliente.Opciones;
import static Ventanas.Modulo_Cliente.Opciones.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cotizaciones {

public static ResultSet resultado;
 
    public static String LISTAR = "Select C.ID_Cliente,C.Nombre_Cliente,C.Atencion,E.estado,M.municipio,L.localidad,C.Calle from\n" +
 " Clientes C left Join t_localidad L ON L.id_localidad = C.id_localidad left Join t_municipio M ON M.id_municipio = L.id_municipio left Join t_estado E ON E.id_estado = M.id_estado\n";
    
     public static void Agregar_Cotizacion(int ID_Cliente) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarCotizacion (?) }");
        
            consulta.setInt(1, ID_Cliente);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Cliente Asignado!");
            AC.msj2.setText("Correctamente");
            AC.setVisible(true);
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProSystem!");
            AC.setVisible(true);
        }
    }
     
    public static void Agregar_RutaCotizacion(int ID_Cotizacion, int ID_ruta ) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarRutaCotizacion (?,?) }");
        
            consulta.setInt(1, ID_Cotizacion);
            consulta.setInt(2, ID_ruta);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Servicio Agregado!");
            AC.msj2.setText("Correctamente");
            AC.setVisible(true);
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProSystem!");
            AC.setVisible(true);
        }
    }  
     
     public static int ObtenID() {
        int c = 0;
        String SQL = "SELECT MAX(ID_Cotizacion) FROM Cotizaciones";
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
     
    ///////////////////////////////////////////////////////////////////
      public static String ObtenerNombre(int ID_Cliente) {
        String existe = "";
  
        String SQL = "SELECT Atencion from clientes where ID_Cliente = "+ID_Cliente;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getString(1);
            }           
        } catch (SQLException ex) {
             Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    //////////////////////////////////////////////////////////////////
    public static int ObtenerIDRuta(int ID_Cliente, int ID_Origenes, int ID_Destinos, int ID_Transporte) {
        int existe = 0;
  
        String SQL = "SELECT Id_Ruta from rutav where (ID_Cliente = "+ID_Cliente+") and (ID_Municipio_Origen = "+ID_Origenes+") and (ID_Municipio_Destino = "+ID_Destinos+") and (ID_Transporte = "+ID_Transporte+")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
             Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    ///////////////////////////////////////////////////////////////////
    public static int ObtenerPrecio(int ID_Ruta) {
        int existe = 0;
  
        String SQL = "SELECT Precio from rutav where (ID_ruta= "+ ID_Ruta+")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                existe = rs.getInt(1);
            }           
        } catch (SQLException ex) {
             Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
     
     public static void Agregar_Ruta(int ID_Cliente, int ID_Origen, int ID_Destino,  float Precio, int ID_Transporte) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarRuta (?,?,?,?,?) }");
            consulta.setInt(1, ID_Cliente);
            consulta.setInt(2, ID_Origen);
            consulta.setInt(3, ID_Destino);
            consulta.setFloat(4, Precio);
            consulta.setInt(5, ID_Transporte);
            consulta.execute();
            

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de Origen-Destino!");
            AC.msj2.setText("Guardados correctamente");
            AC.setVisible(true);
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProSystem!");
            AC.setVisible(true);
        }
    }
     
     ////////////////////////////////////////////////////////////////////////////
     public static void EliminarAsignaCotizacion(int ID) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call Eliminar_Asigna_Cotizacion (?)}");

            consulta.setInt(1, ID);
            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Servicio!");
            AC.msj2.setText("Eliminado Correctamente");
            AC.setVisible(true);
            
        } 
        catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3715!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }



}
