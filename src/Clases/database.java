package Clases;
import java.sql.*;
import javax.swing.JOptionPane;

public class database {
 /* DATOS PARA LA CONEXION */
    

//      private String bd = "ramy8102_ctz_01";//BASE DE DATOS
//  private String login = "ramy8102_ctz_01"; //USUARIO
//  private String password = "RAMY_001CTZ"; //CONTRASEÑA
//  
  
  
  private String bd = "Clinica";//BASE DE DATOS
  private String login = "root"; //USUARIO
  private String password = ""; //CONTRASEÑA


// private String url = "jdbc:mysql://192.168.0.14/"+bd;
  
 // private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?schema&sessionVariables=wait_timeout=600&confluence&autoReconnect=true&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useInformationSchema = true"; 
  
//private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?confluence&autoReconnect=true&useInformationSchema = true"; 
  
  //private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?confluence&autoReconnect=true&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&noAccessToProcedureBodies=true";
   //private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?noAccessToProcedureBodies=true&useUnicode=true&useJDBCCompilantTimezoneShift=true";
//private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?useUnicode=true&useUnicode=true&characterEncoding=utf-8";   
//private String url = "jdbc:mysql://64.34.157.80:3306/"+bd+"?useUnicode=true&useJDBCCompilantTimezoneShift=true";

  private String url = "jdbc:mysql://localhost/"+bd+"?schema&sessionVariables=wait_timeout=600&confluence&autoReconnect=true&useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useInformationSchema = true"; 
  //private String url = "jdbc:mysql://localhost/"+bd;
  private Connection conn = null;

  /* Constructor de clase: Se conecta a la base de datos
  */
   public database(){
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.cj.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("OK base de datos "+bd+" listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }

    public Connection getConnection()
    {
        return this.conn;
    }
/* Realiza una consulta a la base de datos, retorna un Object[][] con los
 * datos de la tabla persona
 */
    public Object[][] Select_OD(int id)
    {
        
     int registros = 0;      
      String consulta = "Select ID_Ruta, Origen, Destino, Nombre_Transporte, Precio FROM rutav where ID_Cliente="+id;
      String consulta2 = "Select count(*) as total from rutav ";
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         PreparedStatement pstm = conn.prepareStatement( consulta2 );
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][5];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = conn.prepareStatement(consulta);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){       
            data[i][0] = res.getString( "ID_Ruta" );
            data[i][1] = res.getString( "Origen" );
            data[i][2] = res.getString( "Destino" );
            data[i][3] = res.getString( "Nombre_Transporte" );
            data[i][4] = res.getString( "Precio" );
            i++;
         }
         res.close();
          }catch(SQLException e){
               System.out.println(e);
        }
      //JOptionPane.showMessageDialog(null,"holaaaaaaaaa");
    return data;
                    
    }

/* Ejecuta la actualizacion de la tabla persona dado los valores de actualizacion
 * y el ID del registro a afectar
 */
    public boolean update(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET " + valores + " WHERE ID_Ruta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateNombreAdicional(String nuevoNombre, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Nombre= '"+nuevoNombre+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateCamioneta15(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Camioneta15= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateCamioneta35(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Camioneta35= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateRabon(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Rabon= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateTorthon(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Torthon= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateTrailer(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Trailer= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateFull(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Full= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    
    public boolean updateNombreServicioMensual(String nuevoNombre, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Nombre_Servicio= '"+nuevoNombre+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updatePrecioServicioMensual(String precio, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE servicios SET Precio= '"+precio+"' WHERE ID_Servicio= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 public boolean updateCotizacionRuta(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE  cotizaciones_ruta SET " + valores + " WHERE ID_CotizacionRuta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 
  public boolean updateCotizacionRenta(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE asigna_cotizaciones_renta SET " + valores + " WHERE ID_Asigna_cotizacion_renta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
  public boolean updateCotizacionRentaConcepto(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE Asigna_cotizaciones_renta SET Concepto ='"+valores+"' WHERE ID_Asigna_Cotizacion_Renta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
  public boolean updateCotizacionRentaPeriodo(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE Asigna_cotizaciones_renta SET ID_Periodo ='"+valores+"' WHERE ID_Asigna_Cotizacion_Renta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
  
    public boolean updateCotizacionConsolidado(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE asigna_cotizacion_consolidado SET " + valores + " WHERE ID_cotizacion_consolidado= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    
    public boolean updateCotizacionConsolidadoM(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE Asigna_cotizacion_consolidado SET " + valores + " WHERE ID_cotizacion_consolidado= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateClienteCamioneta15(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET PCamioneta_1_5=" + valores + " WHERE ID_Ruta= " + id;        
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Camioneta_15=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 
    public boolean updateClienteCamioneta35(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET PCamioneta_3_5=" + valores + " WHERE ID_Ruta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Camioneta_35=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateClienteRabon(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET Rabon=" + valores + " WHERE ID_Ruta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Rabon=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateClienteTorthon(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET Torthon=" + valores + " WHERE ID_Ruta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Torthon=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateClienteTrailer(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET Trailer=" + valores + " WHERE ID_Ruta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Trailer=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateClienteFull(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE ruta SET Full=" + valores + " WHERE ID_Ruta= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        String s = " UPDATE guardar_cotizacion_directa SET Full=" + valores + " WHERE IDRuta= " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(s);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean updateViajeModCamioneta15(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Camioneta_15=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 
    public boolean updateViajeModCamioneta35(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Camioneta_35=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateViajeModRabon(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Rabon=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateViajeModTorthon(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Torthon=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateViajeModTrailer(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Trailer=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
    public boolean updateViajeModFull(String valores, String id)
    {
        boolean res = false;
        //JOptionPane.showMessageDialog(null, valores+ " "+ id);
        String q = " UPDATE guardar_cotizacion_directa SET Full=" + valores + " WHERE ID_GuardarCotD= " + id;
        //sql="UPDATE cotizacionesv Set Estado = 1 Where ID_Cotizacion =" + ID;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  

        ////////Ejecuta la inserccion a la bitacora de reistros, siempre y cuando se realize una modificacion
    public boolean insertBitacora(String origen,String costoA, String costoN,String transporte,String ID)
        {            
        int id_Cliente=0;
        int id2=Integer.parseInt(ID);      
        id_Cliente=Bitacora.ObtenerCliente(id2);////////////
        boolean res = false;        
        String q = " INSERT INTO bitacora_costos (ID_Bitacora,Nombre_Viaje,costo_antiguo,costo_nuevo,transporte,Fecha_Mod,ID_ClienteB)"
                + "VALUES (NULL,'"+origen+"','"+costoA+"','"+costoN+"','"+transporte+"',(now()),'"+id_Cliente+"')";
        ////INSERT INTO `bitacora_costos` (`ID_Bitacora`, `Nombre_Viaje`, `costo_antiguo`, `costo_nuevo`,
        //`Fecha_Mod`, `ID_ClienteB`) VALUES (NULL, 'Villa,donato', '300', '400', current_timestamp(), '71');
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }
        ////////Ejecuta la inserccion a la bitacora de reistros, siempre y cuando se realize una modificacion
    public boolean insertBitacoraModificacion(String origen,String costoA, String costoN,String transporte,String ID)
        {            
        int id_Cliente=0;
        int id2=Integer.parseInt(ID);      
        id_Cliente=Bitacora.ObtenerClienteModificacion(id2);////////////
        boolean res = false;        
        String q = " INSERT INTO bitacora_costos (ID_Bitacora,Nombre_Viaje,costo_antiguo,costo_nuevo,transporte,Fecha_Mod,ID_ClienteB)"
                + "VALUES (NULL,'"+origen+"','"+costoA+"','"+costoN+"','"+transporte+"',(now()),'"+id_Cliente+"')";
        ////INSERT INTO `bitacora_costos` (`ID_Bitacora`, `Nombre_Viaje`, `costo_antiguo`, `costo_nuevo`,
        //`Fecha_Mod`, `ID_ClienteB`) VALUES (NULL, 'Villa,donato', '300', '400', current_timestamp(), '71');
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }

}
