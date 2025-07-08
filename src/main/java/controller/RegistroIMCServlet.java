package controller;

import dao.RegistroDAO;
import model.Calculadora;
import model.Registro;
import model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/RegistroIMC")
public class RegistroIMCServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }
        Usuario u = (Usuario) s.getAttribute("usuario");
        double peso = Double.parseDouble(req.getParameter("peso"));
        if (peso <= 0) {
            req.setAttribute("error", "Peso debe ser mayor que 0.");
            req.getRequestDispatcher("imcForm.jsp").forward(req, resp);
            return;
        }

        double imc = Calculadora.calcularIMC(peso, u.getEstatura());
        String cat = Calculadora.determinarCategoria(imc);

        Registro r = new Registro();
        r.setUsuarioId(u.getId());
        r.setFecha(new Date());
        r.setPeso(peso);
        r.setImc(imc);
        r.setCategoria(cat);

        try {
            RegistroDAO dao = new RegistroDAO();
            dao.guardar(r);
            List<Registro> lista = dao.obtenerPorUsuario(u.getId());
            req.setAttribute("imc", imc);
            req.setAttribute("cat", cat);
            req.setAttribute("registros", lista);
            req.getRequestDispatcher("historial.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
