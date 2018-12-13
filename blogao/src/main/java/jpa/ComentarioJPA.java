package jpa;

import modelo.Comentario;

import java.sql.SQLException;
import java.util.List;

public interface ComentarioJPA {
    Comentario insereComentario(Comentario comentario) throws SQLException, ClassNotFoundException;

    Comentario achaComentarioPorId(Long id) throws SQLException;

    List <Comentario> achaComentarioPorUsuario(Long idUsuario) throws SQLException, ClassNotFoundException;

    List<Comentario> achaComentarioPorPost(Long idPost);

    List<Comentario> achaTodos();

    Comentario atualizaUsuario(Comentario novoComentario);

    boolean deletaComentarioPorId(Long id) throws SQLException;

    boolean deletaComentariosDeUsuario(Long idUsuario) throws SQLException;

    boolean verificaComentario(Comentario comentario) throws SQLException;

    void mostraTodos(List<Comentario> listaComentarios);



}