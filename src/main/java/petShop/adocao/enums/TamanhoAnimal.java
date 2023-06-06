package petShop.adocao.enums;

public enum TamanhoAnimal {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");
    private final String descricao;

    TamanhoAnimal(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
