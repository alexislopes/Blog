package jpa;

import modelo.Comentario;
import modelo.Postagem;

import java.sql.SQLException;
import java.util.List;

public interface PostagemJPA {
    public Postagem inserePostagem(Postagem postagem) throws SQLException, ClassNotFoundException;

    public Postagem achaPostagemPorId(Long id) throws SQLException;

    public Postagem achaPostagemPorTitulo(String titulo) throws SQLException, ClassNotFoundException;

    public Postagem achaPostagemPorData(String data) throws SQLException, ClassNotFoundException;

    public List<Postagem> achaTodas();

    public Postagem atualizaPostagem(Postagem postagemNova);

    public boolean deletaPostagemPorId(Long id) throws SQLException;

    public boolean verificaPostagem(Postagem postagem) throws SQLException;

    public void mostraTodas(List<Postagem> listaPostagem);
    List<Comentario> achaComentarios(Postagem postagem);
}