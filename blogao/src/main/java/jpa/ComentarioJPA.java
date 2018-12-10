package jpa;

import modelo.Comentario;

import java.sql.SQLException;
import java.util.List;

public interface ComentarioJPA {
    public Comentario insereComentario(Comentario comentario) throws SQLException, ClassNotFoundException;

    public Comentario achaComentarioPorId(Long id) throws SQLException;

    public Comentario achaComentarioPorUsuario(Long idUsuario) throws SQLException, ClassNotFoundException;

    public Comentario achaComentarioPorPost(Long idPost);

    public List<Comentario> achaTodos();

    public Comentario atualizaUsuario(Comentario novoComentario);

    public boolean deletaComentarioPorId(Long id) throws SQLException;

    public boolean verificaComentario(Comentario comentario) throws SQLException;

    public void mostraTodos(List<Comentario> listaComentarios);

}