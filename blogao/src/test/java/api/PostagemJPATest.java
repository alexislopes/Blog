package api;

import modelo.Postagem;

import java.sql.SQLException;
import java.util.List;

public interface PostagemJPATest {

    public void inserePostagemTest() throws SQLException, ClassNotFoundException;

    public void achaPostagemPorIdTest() throws SQLException;

    public void achaPostagemPorTituloTest() throws SQLException, ClassNotFoundException;

    public void achaPostagemPorDataTest() throws SQLException, ClassNotFoundException;

    public void achaTodasTest();

    public void atualizaPostagemTest();

    public void deletaPostagemPorIdTest() throws SQLException;

    public void verificaPostagemTest() throws SQLException;

    public void mostraTodasTest();
}
