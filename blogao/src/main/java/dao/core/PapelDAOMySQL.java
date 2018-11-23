package dao.core;

import dao.api.PapelDAO;
import modelo.EnumPapeis;
import modelo.Papel;

import java.sql.*;
import java.util.List;

public class PapelDAOMySQL implements PapelDAO {

    private Connection conexao;

    public PapelDAOMySQL() throws ClassNotFoundException, SQLException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false";
        final String USER = "root";
        final String PW = "1234";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists papel(id int primary key," +
                "tipo enum('ADMINISTRADOR', 'USUARIO', 'VISITANTE')" +
                ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);
    }

    @Override
    public Papel inserirPapel(Papel papel) throws SQLException {
        Papel p = null;

        PreparedStatement comandoSQL = conexao.prepareStatement("select * from banco.tabela where id = ?");
        ResultSet rs = comandoSQL.executeQuery();
        rs.next();
        p = new Papel();
        p.setId(rs.getLong(1));
        p.setDescricao(EnumPapeis.valueOf(rs.getString(2)));
        System.out.println(rs.getString(2));
        rs.close();
        conexao.close(); // usando singleton não precisa fechar a conexão.

        return p;
    }

    @Override
    public Papel achaPorId(Long id) throws SQLException {
        Papel papel = null;
        PreparedStatement query = conexao.prepareStatement("select * from papel where id = ?");
        query.setLong(1, id);

        ResultSet rs = query.executeQuery();

        if (rs.next()){
            papel = new Papel();

            papel.setId(rs.getLong(1));
            String descricao = rs.getString(2);

            EnumPapeis desc = EnumPapeis.valueOf(descricao);
            papel.setDescricao(desc);
        }

        return papel;
    }

    @Override
    public Papel achaPorDescricao(String descricao) {
        return null;
    }

    @Override
    public List<Papel> achaTodosPapeis() throws SQLException {

        PreparedStatement query = conexao.prepareStatement("select * from papel");
        ResultSet rs = query.executeQuery();
        Papel papel = null;

        while(rs.next()){
            papel = new Papel();

            papel.setId(rs.getLong(1));
            String descricao = rs.getString(2);

            EnumPapeis desc = EnumPapeis.valueOf(descricao);
        }

        return null;
    }

    @Override
    public Papel atualizaPapel(Papel papelAtual, Papel papelNovo) {
        return null;
    }
}