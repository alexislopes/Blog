import api.UsuarioJPATest;
import modelo.Postagem;
import modelo.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UsuarioTest implements UsuarioJPATest {
    private Usuario usuario;

    private Usuario comparavel = new Usuario("Alexis Lopes", "alexis@lopes.com", "1234", "alexis" );

    @Before
    public void setUp(){
        usuario = new Usuario();
        Random gerador = new Random();
        usuario.setNome("Usuario" + gerador.nextInt());
        usuario.setLogin(usuario.getNome().toLowerCase());
        usuario.setEmail(usuario.getNome().toLowerCase() + "@" + usuario.getNome().toLowerCase() + ".com");
        usuario.setSenha("1234");
    }

    @Test
    @Override
    public void insereUsuarioTest() throws SQLException, ClassNotFoundException {
        assertEquals(usuario, usuario.insereUsuario(usuario));
    }

    @Test
    @Override
    public void achaUsuarioPorIdTest() throws SQLException {

    }

    @Test
    @Override
    public void achaUsuarioPorLoginTest() throws SQLException, ClassNotFoundException {

    }

    @Test
    @Override
    public void achaUsuarioPorNomeTest() throws SQLException, ClassNotFoundException {

    }

    @Test
    @Override
    public void achaTodosTest() {
        List<Usuario> usuarios;
        usuarios = usuario.achaTodos();
        for (Usuario usuario : usuarios){
            System.out.println(usuario.toString());
        }
    }

    @Test
    @Override
    public void atualizaUsuarioTest() {

    }

    @Test
    @Override
    public void deletaUsuarioPorIdTest() throws SQLException {

    }

    @Test
    @Override
    public void verificaUsuarioTest() throws SQLException {

    }

    @Test
    @Override
    public void mostraTodosTest() {

    }

    @Test
    @Override
    public void achaTodosLoginTest() {

    }

    @Test
    @Override
    public void verificaLoginTest() {

    }
}
