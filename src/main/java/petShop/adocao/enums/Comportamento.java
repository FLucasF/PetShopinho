package petShop.adocao.enums;
/***
 * Classe para metodos do tipo Comportamento, onde serão contidos, enums que servem para informar o
 * comportamento do animal.
 * @author Lucas Felipe
 */
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
