package controle.servlet;

import jpa.UsuarioJPA;
import modelo.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Cadastro", urlPatterns = {"cadastro"}, loadOnStartup = 1)
public class Cadastro extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

        String usuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String login = request.getParameter("apelidoUsuario");
        String email = request.getParameter("emailUsuario");

        Usuario novoUsuario = new Usuario(usuario, email, senha, login);

        UsuarioJPA servicoUsuario = new Usuario();

        // verificar se já existe login com: if(novoUsuario.verificaLogin(login)){
        List<String> logins = servicoUsuario.achaTodosLogin();

        if (logins.contains(login)) {
            response.sendRedirect("login");
        } else {
            try {
                servicoUsuario.insereUsuario(novoUsuario);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            response.sendRedirect("paginainicial");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}