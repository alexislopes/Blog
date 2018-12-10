package controle.servico;

import jpa.UsuarioJPA;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public class ServicoUsuarioImplementado implements UsuarioJPA {
    private UsuarioJPA usuarioJPA;

    public ServicoUsuarioImplementado(){
         usuarioJPA = new Usuario();
    }

    @Override
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return usuarioJPA.insereUsuario(usuario);
    }

    @Override
    public Usuario achaUsuarioPorId(Long id) throws SQLException {
        return usuarioJPA.achaUsuarioPorId(id);
    }

    @Override
    public Usuario achaUsuarioPorLogin(String nomeUsuario) throws SQLException, ClassNotFoundException {
        return usuarioJPA.achaUsuarioPorLogin(nomeUsuario);
    }

    @Override
    public Usuario achaUsuarioPorNome(String name) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Usuario> achaTodos() {
        return null;
    }

    @Override
    public boolean deletaUsuarioPorId(Long id) throws SQLException {
        return usuarioJPA.deletaUsuarioPorId(id);
    }

    @Override
    public boolean verificaUsuario(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public void mostraTodos(List<Usuario> listaUsuarios) {

    }

    @Override
    public List<String> achaTodosLogin() {
        return null;
    }

    @Override
    public boolean verificaLogin(String login) {
        return false;
    }

    @Override
    public Usuario atualizaUsuario(Usuario novoUsuario) {
        return usuarioJPA.atualizaUsuario(novoUsuario);
    }
}