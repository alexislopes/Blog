package modelo;

import jpa.UsuarioPapelJPA;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UsuarioPapel implements UsuarioPapelJPA {

    @Id
    @GeneratedValue()
    private Long id;

    private Long idUsuario;


    private Long idPapel;

    @Transient
    private EntityManagerFactory factory;

    @Transient
    private EntityManager manager;

    public UsuarioPapel() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(Long idPapel) {
        this.idPapel = idPapel;
    }

    public void iniciaManager() {
        this.factory = Persistence.createEntityManagerFactory("usuariopapel");
        this.manager = factory.createEntityManager();
    }

    @Override
    public String toString() {
        return "UsuarioPapel{" + "idUsuario=" + idUsuario + ", idPapel=" + idPapel + '}';
    }

    @Override
    public List<Long> achaPorUsuario(Usuario u) throws SQLException {
        iniciaManager();
        List<Long> idpapeis = new ArrayList<>();
        List<UsuarioPapel> usuarioPapelList = new ArrayList<>();
        Query query = manager.createQuery("SELECT pu FROM UsuarioPapel AS pu");

        usuarioPapelList = (List<UsuarioPapel>) query.getResultList();

        for (UsuarioPapel usuarioPapel : usuarioPapelList) {
            if (usuarioPapel.getIdUsuario() == u.getId()) {
                idpapeis.add(usuarioPapel.getIdPapel());
            }
        }
        return idpapeis;
    }

    @Override
    public List<Long> achaPorPapel(Papel u) {
        return null;
    }

    @Override
    public void inserePapelUsuario(Long id) throws SQLException {
        iniciaManager();
        UsuarioPapel usuarioPapel = new UsuarioPapel();
        usuarioPapel.setIdPapel(2L);
        usuarioPapel.setIdUsuario(id);

        manager.getTransaction().begin();
        manager.persist(usuarioPapel);
        manager.getTransaction().commit();

        manager.close();

    }
}