package petShop.agendamento.enums;

/***
 * Classe para métodos do tipo HorarioAgendamento, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public enum HorarioAgendamento {
    NAO_INFORMADO("Não informado"),
    OITO_HORAS("08:00"),
    NOVE_HORAS("09:00"),
    DEZ_HORAS("10:00"),
    ONZE_HORAS("11:00"),
    DOZE_HORAS("12:00"),
    TREZE_HORAS("13:00"),
    QUATORZE_HORAS("14:00"),
    QUINZE_HORAS("15:00"),
    DEZESSEIS_HORAS("16:00"),
    DEZESETE_HORAS("17:00"),
    DEZOITO_HORAS("18:00");
    private final String descricao;

    HorarioAgendamento(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return descricao;
    }
}