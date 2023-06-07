package petShop.userInterface;

import petShop.adocao.classes.Adocao;
import petShop.adocao.classes.GerenciamentoAdocao;
import petShop.adocao.exceptions.AnimalInformadoIncorretamenteException;
import petShop.adocao.exceptions.AnimalNaoEncontradoException;
import petShop.adocao.exceptions.FalhaAoCadastrarAnimalException;
import petShop.adocao.exceptions.ListaAnimalVaziaException;
import petShop.adocao.gravadorAdocao.GravadorDeAdocao;
import petShop.agendamento.classes.Agendamento;
import petShop.agendamento.classes.GerenciamentoAgendamento;
import petShop.agendamento.exceptions.AgendamentoNaoEncontradoException;
import petShop.agendamento.exceptions.HorarioInformadoExisteException;
import petShop.agendamento.exceptions.HorarioNaoInformadoException;
import petShop.agendamento.exceptions.ListaAgendamentoVaziaException;
import petShop.agendamento.gravadorAgendamento.GravadorDeAgendamento;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

/***
 * Classe aonde são utilizados todos os métodos, classe main.
 * @author Lucas Felipe
 */

public class MainUser {
    public static void main(String[] args) {

        Agendamento animalAgendamento;

        //Instanciando gerenciamento
        GerenciamentoAgendamento gerenciamentoAgendamentos = new GerenciamentoAgendamento();
        GerenciamentoAdocao gerenciamentoAdocao = new GerenciamentoAdocao();

        //Instanciando perguntas
        PerguntasAdocao perguntasAdocao = new PerguntasAdocao();
        PerguntasAgendamento perguntasAgendamento = new PerguntasAgendamento();

        //Instanciando parte do gravador
        GravadorDeAdocao gravadorDeAdocao = new GravadorDeAdocao();
        GravadorDeAgendamento gravadorDeAgendamento = new GravadorDeAgendamento();

        try {
            gerenciamentoAdocao.setAnimais(gravadorDeAdocao.recuperarAdocao());
            JOptionPane.showMessageDialog(null, "Adoção recuperado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falha na recuperação de adoção!");
            e.printStackTrace();
        }
        try {
            gerenciamentoAgendamentos.setAgendamentos(gravadorDeAgendamento.recuperarAgendamento());
            JOptionPane.showMessageDialog(null, "Agendamento recuperado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falha na recuperação!");
            e.printStackTrace();
        }

        String opcao = "";
        String tipoMenu = "";
        boolean continuar1 = true;

        //Inicio
        while (continuar1) {

            try {
                UIManager.put("OptionPane.cancelButtonText", "Sair");
                opcao = Menu.exibirMenu();

            } catch (NumberFormatException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Caracter invalido!");
            }

           if (opcao == null) {
                if (!gerenciamentoAgendamentos.getAgendamentos().isEmpty()) {
                    try {
                        gravadorDeAdocao.gravaAdocao(gerenciamentoAdocao.getAnimais());
                        gravadorDeAgendamento.gravaAgendamento(gerenciamentoAgendamentos.getAgendamentos());

                        JOptionPane.showMessageDialog(null, "Contatos salvos com sucesso!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro na hora de gravar os dados!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nada foi salvo");
                }
                continuar1 = false;
            } else if (opcao.equals("1")) {//ADOÇÃO
                boolean continuar2 = true;
                do {
                    UIManager.put("OptionPane.cancelButtonText", "Voltar");
                    tipoMenu = Menu.exibirMenuAdicionarAnimal();
                    switch (tipoMenu) {

                        case "1" -> {//Opção: Cadastrar animal na lista animais
                            Adocao animalCadastrar = perguntasAdocao.perguntaCadastrarAnimal();
                            try {
                                boolean cadastrou = gerenciamentoAdocao.cadastrarAnimal(animalCadastrar);
                                if (cadastrou) {
                                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cadastro não foi efetuado.");
                                }
                            } catch (AnimalInformadoIncorretamenteException e) {
                                JOptionPane.showMessageDialog(null, "Falha ao conseguir cadastrar animal!");
                                e.printStackTrace();
                            } catch (FalhaAoCadastrarAnimalException e) {
                                JOptionPane.showMessageDialog(null, "Animal informado de forma incorreta!");
                                e.printStackTrace();
                            }
                        }

                        case "2" -> {//Opção: Pesquisar animal pelo tamanho
                            try {
                                String tamanho = perguntasAdocao.perguntaPesquisarAnimalTamanho();
                                JOptionPane.showMessageDialog(null, gerenciamentoAdocao.pesquisarAnimalPeloTamanho(tamanho));
                            } catch (AnimalNaoEncontradoException e) {
                                JOptionPane.showMessageDialog(null, "Lista vazia!");
                                e.printStackTrace();
                            } catch (ListaAnimalVaziaException e) {
                                JOptionPane.showMessageDialog(null, "Animal não encontrado");
                            }
                        }

                        case "3" -> {
                            try {
                                JOptionPane.showMessageDialog(null, obterTextoComListaDeAnimais(gerenciamentoAdocao.obterListaDeAnimais())); //Mostrar lista
                            } catch (ListaAnimalVaziaException e) {
                                JOptionPane.showMessageDialog(null, "A lista de animais está vazia!");
                            }
                        }

                        case "4" -> {//Opção: Deletar animal na lista animais
                            String nomeAnimalDeletar = perguntasAdocao.perguntaDeletarAnimal();
                            try {
                                boolean deletar = gerenciamentoAdocao.deletarAnimal(nomeAnimalDeletar);
                                if (deletar) {
                                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Falha ao deletar.");
                                }
                            } catch (AnimalNaoEncontradoException e) {
                                JOptionPane.showMessageDialog(null, "Animal não foi encontrado!");
                            }
                        }
                        case null -> continuar2 = false;

                        default -> JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
                    }
                } while (continuar2);

            } else if (opcao.equals("2")) {//SERVIÇOS
                boolean continuar3 = true;
                do {
                    UIManager.put("OptionPane.cancelButtonText", "Voltar");
                    try {
                        tipoMenu = Menu.exibirMenuServicos();
                    } catch (NumberFormatException | NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
                    }
                    switch (tipoMenu) {
                        case "1" -> {//Opção: Cadastrar agendamento
                            animalAgendamento = perguntasAgendamento.perguntaAgendamento();
                            try {
                                boolean cadastrar = gerenciamentoAgendamentos.cadastrarAgendamento(animalAgendamento);//Método para cadastra
                                if (cadastrar) {
                                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                                }
                            } catch (HorarioInformadoExisteException e) {
                                JOptionPane.showMessageDialog(null, "Horário informado já está sendo utilizado!");
                                e.printStackTrace();

                            } catch (HorarioNaoInformadoException e) {
                                JOptionPane.showMessageDialog(null, "O horário não foi informado!");
                                e.printStackTrace();
                            }
                        }
                        case "2" -> {//Opção: Pesquisar agendamento
                            try {
                                String diaVerificar = perguntasAgendamento.perguntaPesquisarBaseadoNoDia();//Pergunta para pesquisar
                                JOptionPane.showMessageDialog(null, gerenciamentoAgendamentos.pesquisarAgendamentoBaseadoNoDia(diaVerificar));//Metodo para pesquisar

                            } catch (ListaAgendamentoVaziaException e) {
                                JOptionPane.showMessageDialog(null, "Lista de agendamento está vazia!");
                            } catch (AgendamentoNaoEncontradoException e) {
                                JOptionPane.showMessageDialog(null, "Agendamento não foi encotrado!");
                            }
                        }
                        case "3" -> {//Opção: Listar agendamento
                            try {
                                JOptionPane.showMessageDialog(null, obterTextoComListaDeAgendamento(gerenciamentoAgendamentos.obterListaDeAgendamento()));//Método para listar
                            } catch (ListaAgendamentoVaziaException e) {
                                JOptionPane.showMessageDialog(null, "Lista de agendamento está vazia!");
                            }
                        }
                        case "4" -> {//Opção: Deletar agendamento
                            try {
                                String nomeAgendamentoDeletar = perguntasAgendamento.perguntaDeletarAgendamento();//Perguntas para deletar
                                boolean deletar = gerenciamentoAgendamentos.deletarAgendamento(nomeAgendamentoDeletar);//Método deletar
                                if(deletar) {
                                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                                }
                            } catch (ListaAgendamentoVaziaException e) {
                                JOptionPane.showMessageDialog(null, "Lista de agendamento está vazia!");
                            } catch (AgendamentoNaoEncontradoException e) {
                                JOptionPane.showMessageDialog(null, "Agendamento não encotrado!");
                            }
                        }

                        case null -> continuar3 = false;

                        default -> JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
                    }
                } while (continuar3);

            } else {
                JOptionPane.showMessageDialog(null, "Escreva uma das opções acima!");
            }
        }
    }

    public static String obterTextoComListaDeAnimais(List<Adocao> animais) {
        StringBuilder msg = new StringBuilder();
        for (Adocao a : animais) {
            msg.append(a.toString()).append("\n").append("=-=").append("\n");//varre a lista de animais e concatena o toString na variável msg
        }
        return msg.toString();
    }//Fim do método varrerListaAnimal
    public static String obterTextoComListaDeAgendamento(List<Agendamento> agendamentos) {
        StringBuilder msg = new StringBuilder();
        for (Agendamento a : agendamentos) {
            msg.append(a.toString()).append("\n").append("=-=").append("\n");//varre a lista de animais e concatena o toString na variável msg
        }
        return msg.toString();
    }//Fim do método varrerListaAnimal



}