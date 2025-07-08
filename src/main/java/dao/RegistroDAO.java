package dao;

import model.Registro;
import java.sql.*;
import java.util.*;

public class RegistroDAO {
    private static final String URL = "jdbc:derby://localhost:1527/evidencia";
    private static final String USER = "app", PASS = "app";

    public void guardar(Registro r) throws SQLException {
        String sql = "INSERT INTO HistorialIMC(usuario_id,fecha,peso,imc,categoria) VALUES(?,?,?,?,?)";
        try (Connection c = DriverManager.getConnection(URL,USER,PASS);
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, r.getUsuarioId());
            p.setDate(2, new java.sql.Date(r.getFecha().getTime()));
            p.setDouble(3, r.getPeso());
            p.setDouble(4, r.getImc());
            p.setString(5, r.getCategoria());
            p.executeUpdate();
        }
    }

    public List<Registro> obtenerPorUsuario(int uid) throws SQLException {
        String sql = "SELECT * FROM HistorialIMC WHERE usuario_id=? ORDER BY fecha DESC";
        List<Registro> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(URL,USER,PASS);
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, uid);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Registro r = new Registro();
                r.setId(rs.getInt("id"));
                r.setUsuarioId(uid);
                r.setFecha(rs.getDate("fecha"));
                r.setPeso(rs.getDouble("peso"));
                r.setImc(rs.getDouble("imc"));
                r.setCategoria(rs.getString("categoria"));
                lista.add(r);
            }
        }
        return lista;
    }
}
