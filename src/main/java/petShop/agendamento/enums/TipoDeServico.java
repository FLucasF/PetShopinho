package petShop.agendamento.enums;

/***
 * Classe para métodos do tipo TipoDeServico, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public enum TipoDeServico {
    TOSA("Tosa"),
    BANHO("Banho"),
    COMPLETO("Completo");
    private final String descricao;

    TipoDeServico(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return descricao;
    }

}