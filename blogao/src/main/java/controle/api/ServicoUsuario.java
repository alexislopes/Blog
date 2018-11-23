package controle.api;

import modelo.Usuario;

import java.sql.SQLException;

public interface ServicoUsuario {
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    public Usuario achaUsuarioPorLogin(String nomeUsuario) throws SQLException, ClassNotFoundException;
    public Usuario achaUsuarioPorId(long id) throws SQLException, ClassNotFoundException;
    public void deletaUsuarioPorId(Long id) throws SQLException;
    public void atualizaUsuario(Usuario novoUsuario);
}