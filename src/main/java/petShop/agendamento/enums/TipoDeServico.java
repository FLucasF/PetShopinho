package petShop.agendamento.enums;

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