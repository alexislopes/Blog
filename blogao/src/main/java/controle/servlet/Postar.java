package controle.servlet;

import jpa.PostagemJPA;
import jpa.UsuarioJPA;
import modelo.Postagem;
import modelo.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Postar", urlPatterns = {"postar"}, loadOnStartup = 1)
public class Postar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        String parecer = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("texto");

        Postagem novaPostagem = new Postagem(titulo, texto, fmt.format(new Date()));

        PostagemJPA servicoPostagem = new Postagem();

        try {
            servicoPostagem.inserePostagem(novaPostagem);
            parecer = "Postagem adicionada com sucesso!";
        } catch (SQLException e) {
            parecer = "Erro ao adicionar postagem!";
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            parecer = "Erro ao adicionar postagem!";
            e.printStackTrace();
        }

        request.setAttribute("parecer", parecer);
        sc.getRequestDispatcher("/jsp/casa.jsp").forward(request, response);
    }
}
