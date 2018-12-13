package controle.servlet;

import modelo.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Deletar", urlPatterns = {"deletar"}, loadOnStartup = 1)
public class Deleta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean deletou = false;
        ServletContext sc = request.getServletContext();
        HttpSession sessao = request.getSession();

        Long id = Long.valueOf(request.getParameter("id"));

        Usuario usuario = new Usuario();

        try {
            deletou = usuario.deletaUsuarioPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.sendRedirect("gerenciar");

    }
}
