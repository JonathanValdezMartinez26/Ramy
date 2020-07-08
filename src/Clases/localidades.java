package Clases;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class localidades {

    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Vector<localidades> mostrarLocalidad(int idMunicipio) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
         java.sql.Connection con = conn.conexion();

        Vector<localidades> datos = new Vector<localidades>();
        localidades dat = null;

        try {

            String sql = "SELECT * FROM t_localidad WHERE id_municipio=" + idMunicipio;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new localidades();
            dat.setId(0);
            dat.setNombre("Seleccione localidad");
            datos.add(dat);

            while (rs.next()) {
                dat = new localidades();
                dat.setId(rs.getInt("id_localidad"));
                dat.setNombre(rs.getString("localidad"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
