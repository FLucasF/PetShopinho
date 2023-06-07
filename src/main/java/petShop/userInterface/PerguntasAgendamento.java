package petShop.userInterface;

import petShop.adocao.classes.Adocao;
import petShop.agendamento.classes.Agendamento;
import petShop.agendamento.classes.DonoAnimal;
import petShop.agendamento.classes.Horario;
import petShop.agendamento.enums.DiaAgendamento;
import petShop.agendamento.enums.HorarioAgendamento;
import petShop.agendamento.enums.TipoDeServico;
import javax.swing.*;

/***
 * Classe para métodos do tipo Perguntas Agendamento, onde serão contidos, todas as perguntas utilizdas
 * na hora de criar um objeto do tipo Agendamento.
 * @author Lucas Felipe
 */

public class PerguntasAgendamento {
    private final PerguntasAdocao perguntasAdocao = new PerguntasAdocao();

    /**
     * Método que é utilizado para fazer as perguntas necessárias para criar
     * um objeto do tipo Agendamento.
     * @return animalAgendado
     */
    public Agendamento perguntaAgendamento() {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        boolean continuar;
        String tipoDeServico = "";
        String nomeDono;

        DonoAnimal donoAnimal = new DonoAnimal();
        Adocao animal = new Adocao();
        Horario horario = new Horario();

        try {
            do {
                nomeDono = JOptionPane.showInputDialog(null, "Digite o nome do dono: (ex.: Lucas)", "Nome do Dono", JOptionPane.QUESTION_MESSAGE);
                if (nomeDono.equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite algum nome!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }
            } while (nomeDono.equals(""));

            donoAnimal = new DonoAnimal(nomeDono);

            animal = perguntasAdocao.perguntaCadastrarAnimal();

            do {
                continuar = true;
                try {
                    String serv = JOptionPane.showInputDialog(null, """
                            Qual o tipo de serviço:
                            [1] Tosa
                            [2] Banho
                            [3] Completo""", "Tipo do Serviço", JOptionPane.QUESTION_MESSAGE);
                    switch (serv) {
                        case "1" -> tipoDeServico = TipoDeServico.BANHO.toString();
                        case "2" -> tipoDeServico = TipoDeServico.TOSA.toString();
                        case "3" -> tipoDeServico = TipoDeServico.COMPLETO.toString();
                        default ->
                                JOptionPane.showMessageDialog(null, "Digite uma das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

                    }
                    continuar = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, um dos números informados!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }
            } while (continuar);

            horario = perguntaHorario();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um dos números informados", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar, pois um das opções foram informadas incorretamente.");
            return new Agendamento();
        }

        return new Agendamento(donoAnimal, animal, horario, tipoDeServico);
    }

    /**
     * Método que é utilizado para fazer as perguntas necessárias para criar
     * um objeto do tipo Horario.
     * @return o dia e a hora escolhida.
     */
    public Horario perguntaHorario() {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        boolean continuar;
        String diaAgendamento = null;
        do {
            continuar = true;
            try {
                String dia = JOptionPane.showInputDialog(null, """
                        Qual o dia do agendamento:
                         1 - Segunda-feira   2 - Terça-feira
                         3 - Quarta-feira      4 - Quinta-feira
                         5 - Sexta-feira        6 - Sábado""", "Dia do Agendamento", JOptionPane.QUESTION_MESSAGE);

                switch (dia) {
                    case "1" -> diaAgendamento = DiaAgendamento.SEGUNDA_FEIRA.toString();
                    case "2" -> diaAgendamento = DiaAgendamento.TERCA_FEIRA.toString();
                    case "3" -> diaAgendamento = DiaAgendamento.QUARTA_FEIRA.toString();
                    case "4" -> diaAgendamento = DiaAgendamento.QUINTA_FEIRA.toString();
                    case "5" -> diaAgendamento = DiaAgendamento.SEXTA_FEIRA.toString();
                    case "6" -> diaAgendamento = DiaAgendamento.SABADO.toString();
                    default ->
                            JOptionPane.showMessageDialog(null, "Digite uma das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }
                continuar = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informação incorreta, tente novamente!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
            } catch (NullPointerException e) {
                e.printStackTrace();
                return new Horario("", "");
            }
        } while (continuar);

        String horaAgendamento = null;
        do {
            continuar = true;
            try {
                String h = JOptionPane.showInputDialog(null, """
                        Digite qual o hórario:
                        1 - 08:00h   2 - 09:00h   3 - 10:00h
                        4 - 11:00h   5 - 12:00h   6 - 13:00h
                        7 - 14:00h   8 - 15:00h   9 - 16:00h
                               10 - 17:00h   11 - 18:00h""", "Horário do Agendamento", JOptionPane.QUESTION_MESSAGE);
                switch (h) {
                    case "1" -> horaAgendamento = HorarioAgendamento.OITO_HORAS.toString();
                    case "2" -> horaAgendamento = HorarioAgendamento.NOVE_HORAS.toString();
                    case "3" -> horaAgendamento = HorarioAgendamento.DEZ_HORAS.toString();
                    case "4" -> horaAgendamento = HorarioAgendamento.ONZE_HORAS.toString();
                    case "5" -> horaAgendamento = HorarioAgendamento.DOZE_HORAS.toString();
                    case "6" -> horaAgendamento = HorarioAgendamento.TREZE_HORAS.toString();
                    case "7" -> horaAgendamento = HorarioAgendamento.QUATORZE_HORAS.toString();
                    case "8" -> horaAgendamento = HorarioAgendamento.QUINZE_HORAS.toString();
                    case "9" -> horaAgendamento = HorarioAgendamento.DEZESSEIS_HORAS.toString();
                    case "10" -> horaAgendamento = HorarioAgendamento.DEZESETE_HORAS.toString();
                    case "11" -> horaAgendamento = HorarioAgendamento.DEZOITO_HORAS.toString();
                    default ->
                            JOptionPane.showMessageDialog(null, "Digite uma das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }
                continuar = false;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informação incorreta, tente novamente!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
            } catch (NullPointerException e) {
                e.printStackTrace();
                return new Horario("", "");
            }

        } while (continuar);

        return new Horario(diaAgendamento, horaAgendamento);
    }

    /**
     * Método que é utilizado para fazer as perguntas necessárias para
     * pegar o dia a ser pesquisado e ser utilizado no método pesquisaAgendamentoPeloDia.
     * @return diaAgendamentoVerificar.
     */
    public String perguntaPesquisarBaseadoNoDia() {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        boolean continuar;
        String diaAgendamentoVerificar = null;

        do {
            continuar = true;

            try {
                String p = JOptionPane.showInputDialog(null, """
                        Qual dia deseja verificar:
                        1 - Segunda-feira   2 - Terça-feira
                        3 - Quarta-feira      4 - Quinta-feira
                        5 - Sexta-feira        6 - Sábado""", "Dia há verificar", JOptionPane.QUESTION_MESSAGE);

                switch (p) {
                    case "1" -> diaAgendamentoVerificar = DiaAgendamento.SEGUNDA_FEIRA.toString();
                    case "2" -> diaAgendamentoVerificar = DiaAgendamento.TERCA_FEIRA.toString();
                    case "3" -> diaAgendamentoVerificar = DiaAgendamento.QUARTA_FEIRA.toString();
                    case "4" -> diaAgendamentoVerificar = DiaAgendamento.QUINTA_FEIRA.toString();
                    case "5" -> diaAgendamentoVerificar = DiaAgendamento.SEXTA_FEIRA.toString();
                    case "6" -> diaAgendamentoVerificar = DiaAgendamento.SABADO.toString();
                    default ->
                            JOptionPane.showMessageDialog(null, "Digite uma das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }
                continuar = false;

            } catch (NullPointerException e) {
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma das opções");
            }
        } while (continuar);

        return diaAgendamentoVerificar;
    }

    /**
     * Método que é utilizado para fazer a pergunta necessária para deletar
     * um objeto do tipo Agendamento.
     * @return o nome do animal a ser deletado
     */
    public String perguntaDeletarAgendamento() {
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        return JOptionPane.showInputDialog(null, "Digite o nome do animal que deseja deletar: ", "Nome do Animal", JOptionPane.QUESTION_MESSAGE);
    }

}
