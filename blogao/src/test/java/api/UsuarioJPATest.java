package api;

import modelo.Usuario;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioJPATest {

    @Test
    public void insereUsuarioTest() throws SQLException, ClassNotFoundException;

    @Test
    public void achaUsuarioPorIdTest() throws SQLException;

    @Test
    public void achaUsuarioPorLoginTest() throws SQLException, ClassNotFoundException;

    @Test
    public void achaUsuarioPorNomeTest() throws SQLException, ClassNotFoundException;

    @Test
    public void achaTodosTest();

    @Test
    public void atualizaUsuarioTest();

    @Test
    public void deletaUsuarioPorIdTest() throws SQLException;

    @Test
    public void verificaUsuarioTest() throws SQLException;

    @Test
    public void mostraTodosTest();

    @Test
    public void achaTodosLoginTest();

    @Test
    public void verificaLoginTest();
}
