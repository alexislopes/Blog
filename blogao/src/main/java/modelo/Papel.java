package modelo;

public class Papel{

    private Long id;
    private EnumPapeis descricao;

    public Papel() { }

    public Papel(Long id, EnumPapeis descricao) {
        this.id = id;
        this.setDescricao(descricao);
    }

    public EnumPapeis getDescricao() {
        return descricao;
    }

    public void setDescricao(EnumPapeis descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}