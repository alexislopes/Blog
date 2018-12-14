package modelo;

import controle.servlet.Comentar;
import jpa.PapelJPA;
import jpa.UsuarioJPA;
import jpa.UsuarioPapelJPA;
import dao.PapelDAOMySQL;
import dao.UsuarioPapelDAOMySQL;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements UsuarioJPA {

    @Id
    @GeneratedValue()
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String login;

    @Transient
    private List<Papel> papeis;

    @Transient
    private EntityManagerFactory factory;

    @Transient
    private EntityManager manager;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String senha, String login, String email, List<Papel> papeis) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
        this.papeis = papeis;
    }

    public Usuario(Long id, String nome, String senha, String login, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha, String login) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String nomeUsuario) {
        this.login = nomeUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void iniciaManager(){
        this.factory = Persistence.createEntityManagerFactory("usuario");
        this.manager = factory.createEntityManager();
    }

    @Override
    public String toString() {
        return "modelo.Usuario{" + "id=" + id + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ", senha='" + senha + '\'' + ", nomeUsuario='" + login + '\'' + '}';
    }

    @Override
    public Usuario insereUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        iniciaManager();

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

        System.out.println("ID do usuario: " + usuario.getId());
        manager.close();


        UsuarioPapelJPA usuarioPapelJPA = new UsuarioPapel();
        usuarioPapelJPA.inserePapelUsuario(usuario.getId());



        return usuario;
    }

    @Override
    public Usuario achaUsuarioPorId(Long id) {
        iniciaManager();

        return manager.find(Usuario.class, id);
    }

    @Override
    public Usuario achaUsuarioPorLogin(String login) throws SQLException, ClassNotFoundException {
        iniciaManager();

        PapelJPA papelJPA = new PapelDAOMySQL();
        UsuarioPapelJPA usuarioPapelJPA = new UsuarioPapel();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();

        Query query = manager.createQuery("SELECT u FROM Usuario AS u " + "WHERE u.login LIKE :paramLogin");
        query.setParameter("paramLogin", login);

        Usuario achado = (Usuario) query.getSingleResult();
        System.out.println(achado.toString());

        idPapeis = usuarioPapelJPA.achaPorUsuario(achado);
        for(Long idPapel: idPapeis){
            papeis.add(papelJPA.achaPorId(idPapel));
        }

        achado.setPapeis(papeis);

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public Usuario achaUsuarioPorNome(String name) throws SQLException, ClassNotFoundException {
        iniciaManager();

        PapelJPA papelJPA = new PapelDAOMySQL();
        UsuarioPapelJPA usuarioPapelJPA = new UsuarioPapel();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();

        Query query = manager.createQuery("select u from Usuario as u " + "where u.nome = :paramFinalizado");
        query.setParameter("paramFinalizado", name);

        Usuario achado = (Usuario) query.getSingleResult();

        idPapeis = usuarioPapelJPA.achaPorUsuario(achado);
        for (Long idPapel : idPapeis) {
            papeis.add(papelJPA.achaPorId(idPapel));
        }

        achado.setPapeis(papeis);

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public List<Usuario> achaTodos() {
        iniciaManager();
        return manager.createQuery("select u from Usuario u").getResultList();
    }

    @Override
    public Usuario atualizaUsuario(Usuario usuarioNovo) {
        iniciaManager();

        manager.getTransaction().begin();
        manager.merge(usuarioNovo);
        manager.getTransaction().commit();

        return usuarioNovo;
    }

    public Usuario atualizaUsuarioDesacoplado(Long id) {
        iniciaManager();

        Usuario u2 = manager.find(Usuario.class, id);
        manager.detach(u2); // desacopla
        manager.getTransaction();
        manager.merge(u2); // acopla
        manager.getTransaction().commit();

        return u2;
    }

    @Override
    public boolean deletaUsuarioPorId(Long id) throws SQLException {
        iniciaManager();

        Usuario encontrado = achaUsuarioPorId(id);

        manager.getTransaction().begin();
        manager.remove(encontrado);
        manager.getTransaction().commit();

        Comentario comentario = new Comentario();
        comentario.deletaComentariosDeUsuario(id);

        return verificaUsuario(encontrado);
    }

    @Override
    public boolean verificaUsuario(Usuario usuario) {
        iniciaManager();

        boolean tem = true;
        Usuario auxiliar = achaUsuarioPorId(usuario.getId());

        if (auxiliar == null || !auxiliar.getLogin().equals(usuario.getLogin())) {
            tem = false;
        }

        return tem;
    }

    @Override
    public void mostraTodos(List<Usuario> listaUsuarios) {
        iniciaManager();

    }

    @Override
    public List<String> achaTodosLogin() {
        iniciaManager();

        List<Usuario> todosUsuarios = achaTodos();
        List<String> todosLogin = new ArrayList<>();

        for (Usuario usuario : todosUsuarios) {
            todosLogin.add(usuario.getLogin());
        }

        return todosLogin;
    }

    @Override
    public boolean verificaLogin(String login) {
        iniciaManager();

        List<String> todosLogin = achaTodosLogin();
        boolean tem = false;

        for (String loginAchado : todosLogin) {
            if (loginAchado.equals(login)) {
                tem = true;
            }
        }

        return tem;
    }
}