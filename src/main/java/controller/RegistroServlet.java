package controller;

import dao.UsuarioDAO;
import model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        u.setNombre(req.getParameter("nombre"));
        u.setUsuario(req.getParameter("usuario"));
        u.setContrasena(req.getParameter("contrasena"));
        u.setEdad(Integer.parseInt(req.getParameter("edad")));
        u.setSexo(req.getParameter("sexo"));
        u.setEstatura(Double.parseDouble(req.getParameter("estatura")));

        try {
            boolean ok = new UsuarioDAO().registrar(u);
            if (ok) {
                resp.sendRedirect("index.jsp");
            } else {
                req.setAttribute("error", "Edad o estatura inválida.");
                req.getRequestDispatcher("CrearCuenta.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "Error al registrar: " + e.getMessage());
            req.getRequestDispatcher("CrearCuenta.jsp").forward(req, resp);
        }
    }
}
