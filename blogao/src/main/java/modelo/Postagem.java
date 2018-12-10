package modelo;

import jpa.PostagemJPA;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postagem implements PostagemJPA {

    @Id
    @GeneratedValue()
    private Long id;

    private String titulo;
    private String texto;
    private String data;

    @Transient
    private ArrayList<Comentario> comentarios;

    @Transient
    private EntityManagerFactory factory;

    @Transient
    private EntityManager manager;



    public Postagem() {}

    public Postagem(String titulo, String texto, String data) {
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
    }

    public Postagem(Long id, String titulo, String texto, String data) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Postagem{" + "id=" + id + ", titulo='" + titulo + '\'' + ", texto='" + texto + '\'' + ", data=" + data + '}';
    }

    public void iniciaManager(){
        this.factory = Persistence.createEntityManagerFactory("postagem");
        this.manager = factory.createEntityManager();
    }

    @Override
    public Postagem inserePostagem(Postagem postagem) throws SQLException, ClassNotFoundException {
        iniciaManager();

        manager.getTransaction().begin();
        manager.persist(postagem);
        manager.getTransaction().commit();

        System.out.println("ID do usuario: " + postagem.getId());

        manager.close();

        return postagem;
    }

    @Override
    public Postagem achaPostagemPorId(Long id) throws SQLException {
        iniciaManager();
        return manager.find(Postagem.class, id);
    }

    @Override
    public Postagem achaPostagemPorTitulo(String titulo) throws SQLException, ClassNotFoundException {
        iniciaManager();

        Query query = manager.createQuery("SELECT p FROM Postagem AS p " + "WHERE p.titulo LIKE :paramLogin");
        query.setParameter("paramLogin", titulo);

        Postagem achado = (Postagem) query.getSingleResult();
        System.out.println(achado.toString());

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public Postagem achaPostagemPorData(String data) throws SQLException, ClassNotFoundException {
        iniciaManager();

        Query query = manager.createQuery("SELECT p FROM Postagem AS p " + "WHERE p.data LIKE :paramLogin");
        query.setParameter("paramLogin", data);

        Postagem achado = (Postagem) query.getSingleResult();
        System.out.println(achado.toString());

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public List<Postagem> achaTodas() {
        iniciaManager();

        List<Postagem> lista = manager.createQuery("select '*' from Postagem ").getResultList();

        return lista;
    }

    @Override
    public Postagem atualizaPostagem(Postagem postagemNova) {
        iniciaManager();

        manager.getTransaction().begin();
        manager.merge(postagemNova);
        manager.getTransaction().commit();

        return postagemNova;
    }

    @Override
    public boolean deletaPostagemPorId(Long id) throws SQLException {
        iniciaManager();

        Postagem encontrado = achaPostagemPorId(id);

        manager.getTransaction().begin();
        manager.remove(encontrado);
        manager.getTransaction().commit();

        return verificaPostagem(encontrado);
    }

    @Override
    public boolean verificaPostagem(Postagem postagem) throws SQLException {
        iniciaManager();

        boolean tem = true;
        Postagem auxiliar = achaPostagemPorId(postagem.getId());

        if (auxiliar == null || !auxiliar.getTitulo().equals(postagem.getTitulo())) {
            tem = false;
        }

        return tem;
    }

    @Override
    public void mostraTodas(List<Postagem> listaPostagem) {
        iniciaManager();

    }
}