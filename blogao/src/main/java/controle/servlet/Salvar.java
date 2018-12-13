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

@WebServlet(name = "Salvar", urlPatterns = {"atualizar"}, loadOnStartup = 1)
public class Salvar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        HttpSession sessao = request.getSession();

        Long id = Long.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(id, nome, senha, login, email);

        usuario = usuario.atualizaUsuario(usuario);

        sessao.setAttribute("usuarioatualizado", usuario);

        response.sendRedirect("gerenciar");
    }
}
