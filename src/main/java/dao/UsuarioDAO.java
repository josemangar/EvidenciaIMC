package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private static final String URL = "jdbc:derby://localhost:1527/evidencia";
    private static final String USER = "app", PASS = "app";

    public boolean registrar(Usuario u) throws SQLException {
        if (u.getEdad() < 15 || u.getEstatura() < 1.0 || u.getEstatura() > 2.5) {
            return false;
        }
        String sql = "INSERT INTO Usuario(nombre,usuario,contrasena,edad,sexo,estatura) VALUES(?,?,?,?,?,?)";
        try (Connection c = DriverManager.getConnection(URL,USER,PASS);
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, u.getNombre());
            p.setString(2, u.getUsuario());
            p.setString(3, u.getContrasena());
            p.setInt(4, u.getEdad());
            p.setString(5, u.getSexo());
            p.setDouble(6, u.getEstatura());
            p.executeUpdate();
            return true;
        }
    }

    public Usuario validarLogin(String usuario, String pass) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE usuario=? AND contrasena=?";
        try (Connection c = DriverManager.getConnection(URL,USER,PASS);
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, usuario);
            p.setString(2, pass);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setUsuario(usuario);
                u.setContrasena(pass);
                u.setEdad(rs.getInt("edad"));
                u.setSexo(rs.getString("sexo"));
                u.setEstatura(rs.getDouble("estatura"));
                return u;
            }
            return null;
        }
    }
}
