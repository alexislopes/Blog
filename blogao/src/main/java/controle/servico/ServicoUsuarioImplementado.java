package controle.servico;

import controle.api.ServicoUsuario;
import dao.api.UsuarioDAO;
import modelo.Usuario;

import java.sql.SQLException;

public class ServicoUsuarioImplementado implements ServicoUsuario {
    private UsuarioDAO usuarioDAO;

    public ServicoUsuarioImplementado(){
        UsuarioDAO usuarioDAO = new Usuario();
    }

    @Override
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return usuarioDAO.insereUsuario(usuario);
    }

    @Override
    public Usuario achaUsuarioPorId(long id) throws SQLException, ClassNotFoundException {
        return usuarioDAO.achaUsuarioPorId(id);
    }

    @Override
    public Usuario achaUsuarioPorLogin(String nomeUsuario) throws SQLException, ClassNotFoundException {
        return usuarioDAO.achaUsuarioPorLogin(nomeUsuario);
    }

    @Override
    public void deletaUsuarioPorId(Long id) throws SQLException {
        usuarioDAO.deletaUsuarioPorId(id);
    }

    @Override
    public void atualizaUsuario(Usuario novoUsuario) {
        usuarioDAO.atualizaUsuario(novoUsuario);
    }
}