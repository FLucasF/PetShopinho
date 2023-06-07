package petShop.adocao.enums;

/***
 * Classe para metodos do tipo TamanhoAnimal, onde serão contidos, enums que servem para informar o
 * tamanho do animal.
 * @author Lucas Felipe
 */

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
