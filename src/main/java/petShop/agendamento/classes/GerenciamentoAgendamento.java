package petShop.agendamento.classes;

import petShop.agendamento.InterfaceAgendamento;
import petShop.agendamento.exceptions.AgendamentoNaoEncontradoException;
import petShop.agendamento.exceptions.HorarioInformadoExisteException;
import petShop.agendamento.exceptions.HorarioNaoInformadoException;
import petShop.agendamento.exceptions.ListaAgendamentoVaziaException;
import java.util.ArrayList;
import java.util.List;

/***
 * Classe para métodos do tipo Agendamento, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public class GerenciamentoAgendamento implements InterfaceAgendamento {
    private ArrayList<Agendamento> agendamentos;

    public GerenciamentoAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    /**
     * Método utilizado para cadastrar o agendamento.
     * @param animalAgendamento
     * @return boolean, true caso consiga cadastrar e false caso não consiga cadastrar.
     * @throws HorarioInformadoExisteException
     * @throws HorarioNaoInformadoException
     */
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

    /**
     * Método utilizado para pesquisar o agendamento baseado no dia informado.
     * @param diaAgendamentoVerificar
     * @return msg, que no caso, é uma String concatenada com todos os objetos que tem como atributo
     * o dia informado.
     * @throws AgendamentoNaoEncontradoException
     * @throws ListaAgendamentoVaziaException
     */

    @Override
    public String pesquisarAgendamentoBaseadoNoDia(String diaAgendamentoVerificar) throws AgendamentoNaoEncontradoException, ListaAgendamentoVaziaException {
        if (!this.agendamentos.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (Agendamento a : this.agendamentos) {
                if (a.getHorario().getDia().equals(diaAgendamentoVerificar)) {
                    msg.append(a).append("\n").append("==--==").append("\n");
                }
            }
            if(msg.toString().equals("")) {
                throw new AgendamentoNaoEncontradoException("Não existe agendamento cadastrado no dia" +
                        " informado em agendamentos");
            }
            return msg.toString();
        }
        throw new ListaAgendamentoVaziaException("A lista de agendamentos está vazia."); //TODO: Verificar se a mensagem está correta
    }

    /**
     * Método utilizado para obter uma lista dos objetos da lista de agendamentos.
     * @return List<Agendamento>, retorna a lista de todos os objetos cadastrados na lista agendamentos.
     * @throws ListaAgendamentoVaziaException
     */
    @Override
    public List<Agendamento> obterListaDeAgendamento() throws ListaAgendamentoVaziaException {
        if (!this.agendamentos.isEmpty()) {
            return this.agendamentos;
        }
        throw new ListaAgendamentoVaziaException("A lista está vazia, adicione algum animal para poder lista-la!");
    }

    /**
     * Método utilizado para deletar o agendamento cujo o nome do animal seja igual ao do informado.
     * @param nomeDoAnimal
     * @return boolean, true caso consiga cadastrar e false caso não consiga cadastrar.
     * @throws ListaAgendamentoVaziaException
     * @throws AgendamentoNaoEncontradoException
     */
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
