package Clases;
import java.sql.*;
import javax.swing.JOptionPane;

public class database {
 /* DATOS PARA LA CONEXION */
  private String bd = "Clinica";//BASE DE DATOS
  private String login = "root"; //USUARIO
  private String password = ""; //CONTRASEÑA

  private String url = "jdbc:mysql://192.168.100.14/"+bd;
//  private String url = "jdbc:mysql://localhost/"+bd;
  private Connection conn = null;

  /* Constructor de clase: Se conecta a la base de datos
  */
   public database(){
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
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
    public boolean updateNombreServicio(String nuevoNombre, String id)
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
    public boolean updatePrecioServicio(String precio, String id)
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
        String q = " UPDATE  asigna_ruta_servicio SET " + valores + " WHERE ID_AsignaRutaServicio= " + id;
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
        String q = " UPDATE Asigna_cotizaciones_renta SET " + valores + " WHERE ID_Asigna_cotizacion_renta= " + id;
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

}
