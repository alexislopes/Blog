package controle.servlet;

import modelo.Comentario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "Comentar", urlPatterns = {"comentar"}, loadOnStartup = 1)
public class Comentar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

        String parecer = null;

        String nomeUsuario = request.getParameter("nomeUsuario");
        String cometario = request.getParameter("comentairo");
        Long idPostagem = Long.parseLong(request.getParameter("idPostagem"));
        Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));

        Comentario comentario = new Comentario(idUsuario, idPostagem, cometario, new Date().toString() );

        try {
            comentario.insereComentario(comentario);
            parecer = "Comentario adicionado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            parecer = "Erro ao adicionar comentario!";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            parecer = "Erro ao adicionar comentario!";
        }

        request.setAttribute("parecer", parecer);
        sc.getRequestDispatcher("/jsp/verPost.jsp").forward(request, response);
    }
}
