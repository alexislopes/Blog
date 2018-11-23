package dao.api;

import modelo.Papel;

import java.sql.SQLException;
import java.util.List;

public interface PapelDAO {
    public Papel inserirPapel(Papel papel) throws SQLException;
    public Papel achaPorId(Long id) throws SQLException;
    public Papel achaPorDescricao(String descricao);
    public List<Papel> achaTodosPapeis() throws SQLException;
    public Papel atualizaPapel(Papel papelAtual, Papel papelNovo);
}