package petShop.agendamento.classes;

import petShop.agendamento.InterfaceAgendamento;
import petShop.agendamento.exceptions.AgendamentoNaoEncontradoException;
import petShop.agendamento.exceptions.HorarioInformadoExisteException;
import petShop.agendamento.exceptions.HorarioNaoInformadoException;
import petShop.agendamento.exceptions.ListaAgendamentoVaziaException;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoAgendamento implements InterfaceAgendamento {
    private ArrayList<Agendamento> agendamentos;

    public GerenciamentoAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    @Override
    public boolean cadastrarAgendamento(Agendamento animalAgendamento) throws HorarioInformadoExisteException, HorarioNaoInformadoException{
        for (Agendamento a : this.agendamentos) {
            if (animalAgendamento.getHorario().equals(a.getHorario())) {
                throw new HorarioInformadoExisteException("O horário já está sendo ocupado por outro objeto");

            } else if (a.getHorario().getHorario() == (null) && a.getHorario().getDia() == (null)) {
                throw new HorarioNaoInformadoException("O horário não foi informado corretamente.");
            }
        }
        if (this.agendamentos.add(animalAgendamento)) {
            return true;
        }
        return false;
    }

    @Override
    public String pesquisarAgendamentoBaseadoNoDia(String diaAgendamentoVerificar) throws AgendamentoNaoEncontradoException, ListaAgendamentoVaziaException {
        if (!this.agendamentos.isEmpty()) {
            String msg = "";
            for (Agendamento a : this.agendamentos) {
                if (a.getHorario().getDia().equals(diaAgendamentoVerificar)) {
                    msg += a + "\n" + "==--==" + "\n";
                }
            }
            if(msg.equals("")) {
                throw new AgendamentoNaoEncontradoException("Não existe agendamento cadastrado no dia" +
                        " informado em agendamentos");
            }
            return msg;
        }
        throw new ListaAgendamentoVaziaException("A lista de agendamentos está vazia."); //TODO: Verificar se a mensagem está correta
    }

    @Override
    public List<Agendamento> obterListaDeAgendamento() throws ListaAgendamentoVaziaException {
        if (!this.agendamentos.isEmpty()) {
            return this.agendamentos;
        }
        throw new ListaAgendamentoVaziaException("A lista está vazia, adicione algum animal para poder lista-la!");
    }

    @Override
    public boolean deletarAgendamento(String nomeDoAnimal) throws ListaAgendamentoVaziaException, AgendamentoNaoEncontradoException {
        if (!this.agendamentos.isEmpty()) {
            for (Agendamento a : this.agendamentos) {
                if (a.getAnimal().getNomeAnimal().equals(nomeDoAnimal)) {
                    this.agendamentos.remove(a);
                    return true;
                }
            }
            throw new AgendamentoNaoEncontradoException("Não foi encontrado nenhum agendamento referente ao nome do animal informado!");
        }
        throw new ListaAgendamentoVaziaException("A lista de agendamentos está vazia, cadastre algo e tente novamente!");
    }



    public ArrayList<Agendamento> getAgendamentos() {
        return this.agendamentos;
    }
    public void setAgendamentos(ArrayList<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
