package petShop.agendamento.classes;

import petShop.adocao.classes.Adocao;

public class Agendamento {
    private DonoAnimal donoAnimal;
    private Adocao animal;
    private Horario horario;
    private String tipoDeServico;

    public Agendamento(DonoAnimal donoAnimal, Adocao animal, Horario horario, String tipoDeServico) {
        this.donoAnimal = donoAnimal;
        this.animal = animal;
        this.horario = horario;
        this.tipoDeServico = tipoDeServico;

    }

    public String toString() {
        return this.donoAnimal.toString() + "\n" + "ANIMAL: " + "\n" + this.animal.toString() + "\n" + this.horario.toString() + "\n" +
                "Tipo do Serviço: " + this.tipoDeServico;
    }

    public Agendamento() {
        this(null, null, null, null);

    }

    public DonoAnimal getDonoAnimal() {
        return this.donoAnimal;
    }

    public void setDonoAnimal(DonoAnimal donoAnimal) {
        this.donoAnimal = donoAnimal;
    }

    public Adocao getAnimal() {
        return this.animal;
    }

    public void setAnimal(Adocao animal) {
        this.animal = animal;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getTipoDeServico() {
        return this.tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }
}
