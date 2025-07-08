package controller;

import dao.UsuarioDAO;
import model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String usr  = req.getParameter("usuario");
        String pass = req.getParameter("contrasena");
        try {
            Usuario u = new UsuarioDAO().validarLogin(usr, pass);
            if (u != null) {
                HttpSession s = req.getSession();
                s.setAttribute("usuario", u);
                resp.sendRedirect("imcForm.jsp");
            } else {
                req.setAttribute("error", "Usuario o contraseña incorrectos.");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
