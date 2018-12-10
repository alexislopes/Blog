package dao;

import jpa.UsuarioPapelJPA;
import modelo.Papel;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPapelDAOMySQL implements UsuarioPapelJPA {

    Connection conexao;

    public UsuarioPapelDAOMySQL() throws ClassNotFoundException, SQLException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false";
        final String USER = "root";
        final String PW = "1234";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists papelusuario(idusuario int," +
                "idpapel int," +
                "constraint idusuario foreign key(idusuario) references usuario (id)," +
                "constraint idpapel foreign key(idpapel) references papel (id)," +
                "constraint pk primary key (idusuario, idpapel)" +
                ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);
    }

    @Override
    public List<Long> achaPorUsuario(Usuario u) throws SQLException {

        List<Long> idpapeis = new ArrayList<>();

        PreparedStatement query = conexao.prepareStatement("select * from papelusuario where idusuario = ?");
        query.setLong(1, u.getId());

        ResultSet rs = query.executeQuery();

        while(rs.next()){
            idpapeis.add(rs.getLong(2));
        }

        return idpapeis;
    }

    @Override
    public List<Long> achaPorPapel(Papel u) {
        return null;
    }

    @Override
    public void inserePapelUsuario(Long id) throws SQLException {
        String query =  "insert into papelusuario values (?, ?)";
        PreparedStatement ps = conexao.prepareStatement(query);
        ps.setLong(1, id);
        ps.setInt(2,2);
        ps.execute();
        ps.close();



    }
}