package petShop.agendamento;

import petShop.agendamento.classes.Agendamento;
import petShop.agendamento.exceptions.AgendamentoNaoEncontradoException;
import petShop.agendamento.exceptions.HorarioInformadoExisteException;
import petShop.agendamento.exceptions.HorarioNaoInformadoException;
import petShop.agendamento.exceptions.ListaAgendamentoVaziaException;

import java.util.List;

public interface InterfaceAgendamento {
    boolean cadastrarAgendamento(Agendamento animalAgendamento) throws HorarioInformadoExisteException, HorarioNaoInformadoException;
    String pesquisarAgendamentoBaseadoNoDia(String diaAgendamentoVerificar) throws AgendamentoNaoEncontradoException, ListaAgendamentoVaziaException;
    List<Agendamento> obterListaDeAgendamento() throws ListaAgendamentoVaziaException;
    boolean deletarAgendamento(String nomeDoAnimal) throws ListaAgendamentoVaziaException, AgendamentoNaoEncontradoException;
}
