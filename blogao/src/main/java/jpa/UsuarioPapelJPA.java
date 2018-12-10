package jpa;

import modelo.Papel;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioPapelJPA {
    public List<Long> achaPorUsuario(Usuario u) throws SQLException;
    public List<Long> achaPorPapel(Papel u);
    public void inserePapelUsuario(Long id) throws SQLException;
}
