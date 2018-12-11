package controle.servlet;

//import controle.api.ServicoUsuario;
//import controle.servico.ServicoUsuarioImplementado;

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

@WebServlet(name = "Validador", urlPatterns = {"validador"}, loadOnStartup = 1)
public class Validador extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

        request.setCharacterEncoding("UTF-8");

        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        UsuarioJPA servicoUsuario = new Usuario();

        Usuario achado;
        try {

            achado = servicoUsuario.achaUsuarioPorLogin(nomeUsuario);


            if (achado != null && achado.getSenha().equals(senha) && achado.getLogin().equals(nomeUsuario)) {
                request.setAttribute("usuarioLogado", achado);
                doGet(request, response);
            } else {
                request.setAttribute("falhaAutenticação", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        sc.getRequestDispatcher("/jsp/casa.jsp").forward(req, resp);

    }
}
