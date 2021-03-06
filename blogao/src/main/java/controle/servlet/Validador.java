package controle.servlet;

//import controle.api.ServicoUsuario;
//import controle.servico.ServicoUsuarioImplementado;

import jpa.UsuarioJPA;
import modelo.Usuario;

import javax.persistence.NoResultException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("usuarioLogado", achado);
                    doGet(request, response);
                } else {
                    request.setAttribute("falhaAutenticação", true);
                    response.sendRedirect("login");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ei) {
                ei.printStackTrace();
            } catch (NoResultException nre) {
                response.sendRedirect("login");
            }

        }




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        //sc.getRequestDispatcher("/jsp/casa.jsp").forward(request, response);
        response.sendRedirect("paginainicial");
    }
}
