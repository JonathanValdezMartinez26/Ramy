package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class estados {

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

    public Vector<estados> mostrarEstados() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        java.sql.Connection con = conn.conexion();

        Vector<estados> datos = new Vector<estados>();
        estados dat = null;
        try {

            String sql = "SELECT * FROM t_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new estados();
            dat.setId(0);
            dat.setNombre("Seleccione Estado");
            datos.add(dat);

            while (rs.next()) {
                dat = new estados();
                dat.setId(rs.getInt("id_estado"));
                dat.setNombre(rs.getString("estado"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
