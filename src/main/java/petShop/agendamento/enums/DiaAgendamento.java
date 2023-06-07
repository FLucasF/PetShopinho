package petShop.agendamento.enums;

/***
 * Classe para métodos do tipo DiaAgendamento, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public enum DiaAgendamento {
    NAO_INFORMADO("Não informado"),
    SEGUNDA_FEIRA("Segunda-feira"),
    TERCA_FEIRA("Terça-feira"),
    QUARTA_FEIRA("Quarta-feira"),
    QUINTA_FEIRA("Quinta-feira"),
    SEXTA_FEIRA("Sexta-feira"),
    SABADO("Sábado");
    private final String descricao;

    DiaAgendamento(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return descricao;
    }
}