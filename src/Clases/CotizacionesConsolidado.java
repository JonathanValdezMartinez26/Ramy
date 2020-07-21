package Clases;

import Ventanas.Modulo_Cliente.Opciones;
import static Ventanas.Modulo_Cliente.Opciones.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;

public class CotizacionesConsolidado {

public static ResultSet resultado;
 
    public static String LISTAR = "Select * from Asigna_Cotizaciones_Rentav";
    public static String LISTA = "select * from Consolidado order by ID_Consolidado";
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
     
     
     
    
    public static void main(String args[])
    {
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is : " + utilDate);
        java.sql.Date sqlDate = convert(utilDate);
        System.out.println("java.sql.Date is : " + sqlDate);
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        System.out.println("dateFormated date is : " + df.format(utilDate));
    }

    private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
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

    public static int DeleteTran(int ID_Asigna_Cotizacion_Renta) {
        int existe = 0;
  
        String SQL = "delete from asigna_cotizaciones_renta where(ID_Asigna_Cotizacion_Renta= "+ ID_Asigna_Cotizacion_Renta+")";
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
    public static String registrar = "INSERT INTO Asigna_Cotizacion_Consolidado("
           + "ID_Cotizacion_Consolidado,"
            + "ID_Cotizacion,"
            + "ID_Consolidado)"
            + "VALUES(?,?,?)";
    
     
  private int ID_Asigna_Cotizacion;
  private int ID_Cotizacion;
  private int ID_Consolidado;
    
    public int getID_Asigna_Cotizacion() {
        return ID_Asigna_Cotizacion;
    }

    public void setID_Asigna_Cotizacion(int ID_Asigna_Cotizacion) {
        this.ID_Asigna_Cotizacion = ID_Asigna_Cotizacion;
    }
    
     public int getID_Cotizacion() {
        return ID_Cotizacion;
    }

    public void setID_Cotizacion(int ID_Cotizacion) {
        this.ID_Cotizacion = ID_Cotizacion;
    }

    
    public int getID_Consolidado() {
        return ID_Consolidado;
    }

    public void setID_Consolidado(int ID_Consolidado) {
        this.ID_Consolidado = ID_Consolidado;
    }
    
       public static void Agregar_Tipo(String Nombre) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarTipocon (?)}");
            
            consulta.setString(1, Nombre);

            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de la consolidacion!");
            AC.msj2.setText("Guardados correctamente");
            AC.setVisible(true);
            
        } catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }



}
