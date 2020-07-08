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

public class Clientes {

public static ResultSet resultado;
 
    public static String LISTAR = "Select C.ID_Cliente,C.Nombre_Cliente,C.Atencion,E.estado,M.municipio,L.localidad,C.Calle from\n" +
 " Clientes C left Join t_localidad L ON L.id_localidad = C.id_localidad left Join t_municipio M ON M.id_municipio = L.id_municipio left Join t_estado E ON E.id_estado = M.id_estado\n";

     public static void Agregar_Cliente(String Nombre_cliente, String Atencion, int ID_Localidad, String Calle) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarCliente (?,?,?,?) }");
           // CallableStatement consulta = (CallableStatement) Conexion.con.prepareStatement("INSERT INTO Clinica.Clientes(Nombre_cliente, RFC, ID_Estado, Direccion) VALUES (" + Nombre_cliente +","+ RFC +","+ ID_Estado +","+ Direccion + ")");
            
            consulta.setString(1, Nombre_cliente);
            consulta.setString(2, Atencion);
            consulta.setInt(3, ID_Localidad );
            consulta.setString(4, Calle);

            consulta.execute();
            

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos del Cliente!");
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
     
     public static int ObtenID() {
        int c = 0;
        String SQL = "SELECT MAX(ID_cliente) FROM Clientes";
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
     
     public static void Agregar_Origen(int ID, int ID_Municipio) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarOrigen (?,?) }");
           // CallableStatement consulta = (CallableStatement) Conexion.con.prepareStatement("INSERT INTO Clinica.Clientes(Nombre_cliente, RFC, ID_Estado, Direccion) VALUES (" + Nombre_cliente +","+ RFC +","+ ID_Estado +","+ Direccion + ")");
            consulta.setInt(1, ID);
            consulta.setInt(2, ID_Municipio);
            consulta.execute();
            

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de Origen!");
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
     
     public static void Agregar_Destino(int ID, int ID_Municipio) {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarDestino (?,?) }");
           // CallableStatement consulta = (CallableStatement) Conexion.con.prepareStatement("INSERT INTO Clinica.Clientes(Nombre_cliente, RFC, ID_Estado, Direccion) VALUES (" + Nombre_cliente +","+ RFC +","+ ID_Estado +","+ Direccion + ")");
            consulta.setInt(1, ID);
            consulta.setInt(2, ID_Municipio);
            consulta.execute();
            

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Datos de Destino!");
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

    public static void Actualizar_Clientes(int ID, String Nombre_cliente, String RFC, int ID_Estado, String Direccion) {

        try {
                CallableStatement consulta = Conexion.con.prepareCall("{call ModificarClientes (?,?,?,?,?) }");
 
            consulta.setInt(1, ID);    
            consulta.setString(2, Nombre_cliente);
            consulta.setString(3, RFC);
            consulta.setInt(4, ID_Estado);
            consulta.setString(5, Direccion);

                consulta.execute();
            
                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
                AC.msj1.setText("¡Datos del Cliente!");
                AC.msj2.setText("Actualizados Correctamente");
                AC.setVisible(true);
                
        } 
        catch (SQLException ex) 
        {
            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3714!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);
        }
    }

    public static void Activar_Especialidad(int ID) 
    {
        try 
        {
            CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
            
            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Especialidad!");
            AC.msj2.setText("Activada Correctamente");
            AC.setVisible(true);

        } 
        catch (SQLException ex) 
        {

            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
            AC.msj1.setText("¡Error 3718!");
            AC.msj2.setText("¡Contacte a servicios ProMedic!");
            AC.setVisible(true);

        }
    }

    public static void Desactivar_Especialidad(int ID) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();

            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
            AC.msj1.setText("¡Especialidad!");
            AC.msj2.setText("Desactivada Correctamente");
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
