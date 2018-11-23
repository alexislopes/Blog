package modelo;

import dao.api.PapelDAO;
import dao.api.UsuarioDAO;
import dao.api.UsuarioPapelDAO;
import dao.core.PapelDAOMySQL;
import dao.core.UsuarioPapelDAOMySQL;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements UsuarioDAO {

    @Id
    @GeneratedValue()
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String login;

    @Transient
    private List<Papel> papeis;

    public Usuario(){}

    public List<Papel> getPapeis() {
        return papeis;
    }

    @Transient
    private EntityManagerFactory factory;

    @Transient
    private EntityManager manager;

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public Usuario(Long id, String nome, String senha, String login, String email, List<Papel> papeis){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
        this.papeis = papeis;
    }

    public Usuario(Long id, String nome, String senha, String login, String email){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
    }

    public Usuario(String nome, String senha){
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

    @Override
    public String toString() {
        return "modelo.Usuario{" + "id=" + id + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ", senha='" + senha + '\'' + ", nomeUsuario='" + login + '\'' + '}';
    }

    @Override
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {

        factory = Persistence.createEntityManagerFactory("usuario");
        manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

        System.out.println("ID do usuario: " + usuario.getId());

        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        usuarioPapelDAO.inserePapelUsuario(usuario.getId());

        manager.close();

        return usuario;
    }

    @Override
    public Usuario achaUsuarioPorId(Long id) throws SQLException {
        return manager.find(Usuario.class, new Long(id));
    }

    @Override
    public Usuario achaUsuarioPorLogin(String login) throws SQLException, ClassNotFoundException {
        PapelDAO papelDAO = new PapelDAOMySQL();
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();

        Query query = manager
                .createQuery("select u from Usuario as u "+
                        "where u.login = :paramFinalizado");
        query.setParameter("paramFinalizado", login);

        Usuario achado = (Usuario) query.getSingleResult();

        idPapeis = usuarioPapelDAO.achaPorUsuario(achado);
        for(Long idPapel: idPapeis){
            papeis.add(papelDAO.achaPorId(idPapel));
        }

        achado.setPapeis(papeis);

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public Usuario achaUsuarioPorNome(String name) throws SQLException, ClassNotFoundException {
        PapelDAO papelDAO = new PapelDAOMySQL();
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();

        Query query = manager
                .createQuery("select u from Usuario as u "+
                        "where u.nome = :paramFinalizado");
        query.setParameter("paramFinalizado", name);

        Usuario achado = (Usuario) query.getSingleResult();

        idPapeis = usuarioPapelDAO.achaPorUsuario(achado);
        for(Long idPapel: idPapeis){
            papeis.add(papelDAO.achaPorId(idPapel));
        }

        achado.setPapeis(papeis);

        System.out.println(achado.toString());

        return achado;
    }

    @Override
    public List<Usuario> achaTodos() {

        List<Usuario> lista = manager
                .createQuery("select '*' from Usuario")
                .getResultList();

        return lista;
    }

    @Override
    public Usuario atualizaUsuario(Usuario usuarioNovo) {

        manager.getTransaction().begin();
        manager.merge(usuarioNovo);
        manager.getTransaction().commit();

        return usuarioNovo;
    }

    @Override
    public boolean deletaUsuarioPorId(Long id) throws SQLException {

        Usuario encontrado = achaUsuarioPorId(id);

        manager.getTransaction().begin();
        manager.remove(encontrado);
        manager.getTransaction().commit();

        return verificaUsuario(encontrado);
    }

    @Override
    public boolean verificaUsuario(Usuario usuario) throws SQLException {
        boolean tem = true;
        Usuario auxiliar = achaUsuarioPorId(usuario.getId());

        if(auxiliar == null || !auxiliar.getLogin().equals(usuario.getLogin())){
            tem = false;
        }

        return tem;
    }

    @Override
    public void mostraTodos(List<Usuario> listaUsuarios) {

    }

    @Override
    public List<String> achaTodosLogin() {
        List<Usuario> todosUsuarios = achaTodos();
        List<String> todosLogin = new ArrayList<>();

        for(Usuario usuario : todosUsuarios){
            todosLogin.add(usuario.getLogin());
        }

        return todosLogin;
    }

    @Override
    public boolean verificaLogin(String login) {
        List<String> todosLogin = achaTodosLogin();
        boolean tem = false;

        for(String loginAchado : todosLogin){
            if(loginAchado.equals(login)){
                tem = true;
            }
        }

        return tem;
    }
}