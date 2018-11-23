package modelo;

import dao.api.ComentarioDAO;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@Entity
public class Comentario implements ComentarioDAO {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private Long usuario;
    private Long postagem;
    private String conteudo;
    private Calendar data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getPostagem() {
        return postagem;
    }

    public void setPostagem(Long postagem) {
        this.postagem = postagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public Comentario insereComentario(Comentario comentario) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Comentario achaComentarioPorId(Long id) throws SQLException {
        return null;
    }

    @Override
    public Comentario achaComentarioPorUsuario(Long idUsuario) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Comentario achaComentarioPorPost(Long idPost) {
        return null;
    }

    @Override
    public List<Comentario> achaTodos() {
        return null;
    }

    @Override
    public Comentario atualizaUsuario(Comentario novoComentario) {
        return null;
    }

    @Override
    public boolean deletaComentarioPorId(Long id) throws SQLException {
        return false;
    }

    @Override
    public boolean verificaComentario(Comentario comentario) throws SQLException {
        return false;
    }

    @Override
    public void mostraTodos(List<Comentario> listaComentarios) {

    }
}