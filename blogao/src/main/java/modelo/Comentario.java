package modelo;

import dao.PapelDAOMySQL;
import dao.UsuarioPapelDAOMySQL;
import jpa.ComentarioJPA;
import jpa.PapelJPA;
import jpa.UsuarioPapelJPA;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Comentario implements ComentarioJPA {

    @Id
    @GeneratedValue
    private Long id;

    private Long usuario;
    private Long postagem;
    private String conteudo;
    private String data;

    @Transient
    private EntityManagerFactory factory;

    @Transient
    private EntityManager manager;

    public Comentario() {
    }

    public Comentario(Long usuario, Long postagem, String conteudo, String data) {
        this.usuario = usuario;
        this.postagem = postagem;
        this.conteudo = conteudo;
        this.data = data;
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void iniciaManager(){
        this.factory = Persistence.createEntityManagerFactory("comentario");
        this.manager = factory.createEntityManager();
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", usuario=" + usuario + ", postagem=" + postagem + ", conteudo='" + conteudo + '\'' + ", data='" + data + '\'' + '}';
    }

    @Override
    public Comentario insereComentario(Comentario comentario) throws SQLException, ClassNotFoundException {
        iniciaManager();

        manager.getTransaction().begin();
        manager.persist(comentario);
        manager.getTransaction().commit();

        System.out.println("ID do comentario: " + comentario.getId());

        manager.close();

        return comentario;
    }

    @Override
    public Comentario achaComentarioPorId(Long id) throws SQLException {
        iniciaManager();
        return manager.find(Comentario.class, id);
    }

    @Override
    public Comentario achaComentarioPorUsuario(Long idUsuario) throws SQLException, ClassNotFoundException {
        iniciaManager();

        Query query = manager.createQuery("SELECT c FROM Comentario AS c " + "WHERE 'c.usuario' LIKE :paramLogin");
        query.setParameter("paramLogin", idUsuario);

        Comentario achado = (Comentario) query.getSingleResult();
        System.out.println(achado.toString());

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public Comentario achaComentarioPorPost(Long idPost) {
        iniciaManager();

        Query query = manager.createQuery("SELECT c FROM Comentario AS c " + "WHERE 'c.postagem' LIKE :paramLogin");
        query.setParameter("paramLogin", idPost);

        Comentario achado = (Comentario) query.getSingleResult();
        System.out.println(achado.toString());

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public List<Comentario> achaTodos() {
        iniciaManager();
        return manager.createQuery("select c from Comentario c").getResultList();
    }

    @Override
    public Comentario atualizaUsuario(Comentario novoComentario) {
        iniciaManager();

        manager.getTransaction().begin();
        manager.merge(novoComentario);
        manager.getTransaction().commit();

        return novoComentario;
    }

    @Override
    public boolean deletaComentarioPorId(Long id) throws SQLException {
        iniciaManager();

        Comentario encontrado = achaComentarioPorId(id);

        manager.getTransaction().begin();
        manager.remove(encontrado);
        manager.getTransaction().commit();

        return verificaComentario(encontrado);
    }

    @Override
    public boolean verificaComentario(Comentario comentario) throws SQLException {
        iniciaManager();

        boolean tem = true;
        Comentario auxiliar = achaComentarioPorId(comentario.getId());

        if (auxiliar == null || !auxiliar.usuario.equals(comentario.usuario)) {
            tem = false;
        }

        return tem;
    }

    @Override
    public void mostraTodos(List<Comentario> listaComentarios) {

    }
}