package controle.servlet;

import controle.api.ServicoUsuario;
import controle.servico.ServicoUsuarioImplementado;
import modelo.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class Validador extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServicoUsuario sUsuario = new ServicoUsuarioImplementado();
        try {
            Usuario uBD = sUsuario.achaUsuarioPorLogin(nomeUsuario);
            if (uBD != null && uBD.getSenha().equals(senha) && uBD.getLogin().equals(nomeUsuario)) {
                req.setAttribute("usuarioLogado", uBD);
                sc.getRequestDispatcher("/jsp//home.jsp").forward(req, resp);
            } else {
                req.setAttribute("falhaAutenticação", true);
                sc.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
