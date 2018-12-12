package controle.servlet;

import modelo.Postagem;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MostraPostagem", urlPatterns = {"mostrapostagem"}, loadOnStartup = 1)
public class MostraPostagem extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

        String strid = request.getParameter("postId");
        Long id = Long.parseLong(strid);

        System.out.println("id do post: " + id);

        Postagem postagem = new Postagem();
        try {
            postagem = postagem.achaPostagemPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("postagem", postagem);
        sc.getRequestDispatcher("/jsp/verPost.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

    }
}
