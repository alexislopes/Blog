package jpa;

import modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioJPA {
    public Usuario insereUsuario(Usuario usuario) throws ClassNotFoundException, SQLException;

    public Usuario achaUsuarioPorId(Long id) throws SQLException;

    public Usuario achaUsuarioPorLogin(String login) throws ClassNotFoundException, SQLException;

    public Usuario achaUsuarioPorNome(String name) throws  ClassNotFoundException, SQLException;

    public List<Usuario> achaTodos();

    public Usuario atualizaUsuario(Usuario usuarioNovo);

    public boolean deletaUsuarioPorId(Long id) throws SQLException;

    public boolean verificaUsuario(Usuario usuario) throws SQLException;

    public void mostraTodos(List<Usuario> listaUsuarios);

    public List<String> achaTodosLogin();

    public boolean verificaLogin(String login);
}
