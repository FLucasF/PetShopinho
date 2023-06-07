package petShop.agendamento.classes;

import java.util.Objects;

/***
 * Classe para métodos do tipo Horario, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public class Horario {
    private String dia;
    private String horario;

    public Horario(String dia, String horario) {
        this.dia = dia;
        this.horario = horario;
    }
    public Horario() {
        this(null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario1 = (Horario) o;
        return dia.equals(horario1.dia) && horario.equals(horario1.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, horario);
    }

    @Override
    public String toString() {
        return "Dia do agendamento: " + this.dia + ", Horário do agendamento: " + this.horario;
    }

    public String getDia() {
        return this.dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
