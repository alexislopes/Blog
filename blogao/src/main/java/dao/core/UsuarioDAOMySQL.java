package dao.core;

import dao.api.UsuarioDAO;
import dao.api.UsuarioPapelDAO;
import modelo.Papel;
import dao.api.PapelDAO;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {

    private Connection conexao;

    private EntityManagerFactory factory;
    private EntityManager manager;

    public UsuarioDAOMySQL() throws SQLException, ClassNotFoundException {

        factory = Persistence.createEntityManagerFactory("usuario");
        manager = factory.createEntityManager();

        /*final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false";
        final String USER = "root";
        final String PW = "1234";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists usuario( id int primary key," + "nome varchar(100)," + "senha varchar(200)," + "login varchar(100)," + "email varchar(100)" + ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);*/
    }

    @Override
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        /*String query = "INSERT INTO usuario (email, login, nome, senha) VALUES (?,?,?,?);";
        java.sql.PreparedStatement statement = conexao.prepareStatement(query);

        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getLogin());
        statement.setString(3, usuario.getNome());
        statement.setString(4, usuario.getSenha());

        statement.execute();
        statement.close();

        Usuario novo = achaUsuarioPorLogin(usuario.getLogin());
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        usuarioPapelDAO.inserePapelUsuario(novo.getId());*/

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
    public Usuario achaUsuarioPorLogin(String nomeUsuario) throws SQLException, ClassNotFoundException {

        PapelDAO papelDAO = new PapelDAOMySQL();
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();


        Usuario achado = null;

        PreparedStatement query = conexao.prepareStatement("select * from usuario where login = ?");
        query.setString(1, nomeUsuario);

        ResultSet rs = query.executeQuery();

        if (rs.next()) {

            achado = new Usuario();
            achado.setId(rs.getLong(1));
            achado.setNome(rs.getString(4));
            achado.setSenha(rs.getString(5));
            achado.setLogin(rs.getString(3));
            achado.setEmail(rs.getString(2));

            idPapeis = usuarioPapelDAO.achaPorUsuario(achado);
            for(Long idPapel: idPapeis){
                papeis.add(papelDAO.achaPorId(idPapel));
            }

            achado.setPapeis(papeis);

            System.out.println(achado.toString());
        }



        query.close();

        rs.close();

        System.out.println(achado.toString());


        return achado;
    }

    @Override
    public Usuario achaUsuarioPorId(Long idUsuario) throws SQLException {

        /*Usuario u = null;

        PreparedStatement comandoSQL = conexao.prepareStatement("select * from banco.tabela where id = ?");
        comandoSQL.setString(1, idUsuario.toString());
        ResultSet rs = comandoSQL.executeQuery();
        System.out.println("Conectei...");
        rs.next();
        u = new Usuario();
        u.setId(rs.getLong(1));
        u.setNomeUsuario(rs.getString(2));
        u.setSenha(rs.getString(3));
        u.setNome(rs.getString(4));
        u.setEmail(rs.getString(5));
        comandoSQL.close();
        rs.close(); // se estiver utilizando singleton não precisa fechar conexão*/

        Usuario encontrado = manager.find(Usuario.class, new Long(idUsuario));

        //System.out.println("encontrado" + encontrado.toString());

        return encontrado;
    }

    @Override
    public Usuario achaUsuarioPorNome(String nomeUsuario) throws SQLException {

        Usuario achado = null;

        PreparedStatement query = conexao.prepareStatement("select * from usuario where login = ?");
        query.setString(1, nomeUsuario);

        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            achado = new Usuario();
            achado.setId(rs.getLong(1));
            achado.setNome(rs.getString(2));
            achado.setSenha(rs.getString(3));
            achado.setLogin(rs.getString(4));
            achado.setEmail(rs.getString(5));
        }

        return achado;
    }

    @Override
    public List<Usuario> achaTodos() {
        List<Usuario> lista = manager
                .createQuery("select '*' from Usuario")
                .getResultList();

        /*for (Usuario usuario : lista) {
            System.out.println(usuario.getNome());
        }*/


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
        manager.contains(encontrado);

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
        return null;
    }

    @Override
    public boolean verificaLogin(String login) {
        return false;
    }


}