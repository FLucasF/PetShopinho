package petShop.adocao.enums;

public enum Comportamento {
    DOCIL("Dócil"),
    AGRESSIVO("Grande");
    private final String descricao;

    Comportamento(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
