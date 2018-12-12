import api.PostagemJPATest;
import modelo.Postagem;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostagemTest implements PostagemJPATest {

    private Postagem postagem;

    @Before
    public void setUp(){
        postagem = new Postagem();
    }

    @Test
    @Override
    public void inserePostagemTest() throws SQLException, ClassNotFoundException {

    }

    @Test
    @Override
    public void achaPostagemPorIdTest() throws SQLException {

    }

    @Test
    @Override
    public void achaPostagemPorTituloTest() throws SQLException, ClassNotFoundException {

    }

    @Test
    @Override
    public void achaPostagemPorDataTest() throws SQLException, ClassNotFoundException {

    }

    @Test
    @Override
    public void achaTodasTest() {

    }

    @Test
    @Override
    public void atualizaPostagemTest() {

    }

    @Test
    @Override
    public void deletaPostagemPorIdTest() throws SQLException {

    }

    @Test
    @Override
    public void verificaPostagemTest() throws SQLException {

    }

    @Test
    @Override
    public void mostraTodasTest() {

    }
}

