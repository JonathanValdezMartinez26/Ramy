package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class municipios {

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

    public Vector<municipios> mostrarMunicipio(int idEstado) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
         java.sql.Connection con = conn.conexion();

        Vector<municipios> datos = new Vector<municipios>();
        municipios dat = null;
        try {

            String sql = "SELECT * FROM t_municipio WHERE id_estado=" + idEstado;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new municipios();
            dat.setId(0);
            dat.setNombre("Seleccione Municipio");
            datos.add(dat);

            while (rs.next()) {
                dat = new municipios();
                dat.setId(rs.getInt("id_municipio"));
                dat.setNombre(rs.getString("municipio"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
