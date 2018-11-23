package modelo;

public enum EnumPapeis {
    ADMINISTRADOR("Administrador"), USUARIO("Usuário Comum"), VISITANTE("Visitante");

    private final String descricao;

    EnumPapeis(String valor) {
        this.descricao = valor;
    }

    public String toString() {
        return this.descricao;
    }
}
