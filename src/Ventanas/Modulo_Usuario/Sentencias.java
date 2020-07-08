package Ventanas.Modulo_Usuario;

import java.util.Date;

public class Sentencias {

    public static String LISTAR = "SELECT * FROM usuario WHERE ID_Rol_Usuario != '3'";

    public static String REGISTRAR = "INSERT INTO usuario("
            + "ID_Usuario,"
            + "Nombre_Usuario,"
            + "Usuario,"
            + "Contrasena_Usuario,"
            + "Correo_Electronico,"
            + "ID_Rol_Usuario) "
            + "VALUES(?,?,?,?,?,?)";
    
    
    private int id;
    private String nombre;
    private String usuario;
    private String password;
    private String email;
    private int tipo_usuario;
    private Date fecha_alta;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    public Date getFecha_Alta() {
        return fecha_alta;
    }

    public void setFecha_Alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

}
