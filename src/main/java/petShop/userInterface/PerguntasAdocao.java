package petShop.userInterface;

import petShop.adocao.classes.Adocao;
import petShop.adocao.enums.Comportamento;
import petShop.adocao.enums.TamanhoAnimal;
import javax.swing.*;

/***
 * Classe para métodos do tipo Perguntas adoção, onde serão contidos, todas as perguntas utilizdas
 * na hora de criar um objeto do tipo Adocao.
 * @author Lucas Felipe
 */

public class PerguntasAdocao {

    /**
     * Método que é utilizado para fazer as perguntas necessárias para criar
     * um objeto do tipo Adoção.
     * @return animal a ser cadastrado.
     */
    public Adocao perguntaCadastrarAnimal() {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        boolean continuar;
        boolean continuarPrincipal;
        Adocao animalCadastrado = null;
        do {
            continuarPrincipal = true;
            try {
                String nomeAnimal;
                do {
                    continuar = true;
                    nomeAnimal = JOptionPane.showInputDialog(null, "Digite o nome do animal: (ex.: Rex)", "Nome do animal", JOptionPane.QUESTION_MESSAGE);
                    if (nomeAnimal == null) {
                        return new Adocao();
                    } else if (nomeAnimal.equals("")) {
                        JOptionPane.showMessageDialog(null, "Nenhum nome foi informado, digite um nome!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                    } else {
                        continuar = false;
                    }
                } while (continuar);

                String especie;
                do {
                    continuar = true;
                    especie = JOptionPane.showInputDialog(null, "Digite a espécie do animal: (ex.: Cachorro)", "Espécie do Animal", JOptionPane.QUESTION_MESSAGE);
                    if (especie == null) {
                        return new Adocao();
                    } else if (especie.equals("")) {
                        JOptionPane.showMessageDialog(null, "Digite a espécie do animal!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                    } else {
                        continuar = false;
                    }
                } while (continuar);

                String raca;
                do {
                    continuar = true;
                    raca = JOptionPane.showInputDialog(null, "Digite a raça do animal: (ex.: Viralata)", "Raça do Animal", JOptionPane.QUESTION_MESSAGE);
                    if (raca == null) {
                        return new Adocao();
                    } else if (raca.equals("")) {
                        JOptionPane.showMessageDialog(null, "Digite a raça do animal!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                    } else {
                        continuar = false;
                    }
                } while (continuar);

                Integer diaDeNascimento = null;
                do {
                    continuar = true;
                    try {
                        diaDeNascimento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia de nascimento: (ex.: 01)", "Dia do Nascimento do Animal", JOptionPane.QUESTION_MESSAGE));
                        continuar = false;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Dia informado é inválido!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return new Adocao();
                    }
                } while (continuar);

                Integer mesDeNascimento = null;
                do {
                    continuar = true;
                    try {
                        mesDeNascimento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mês de nascimento: (ex.: 12)", "Mês de Nascimento do Animal", JOptionPane.QUESTION_MESSAGE));
                        continuar = false;

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Mês informado é inválido!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return new Adocao();
                    }
                } while (continuar);

                Integer anoDeNascimento = null;
                do {
                    continuar = true;
                    try {
                        anoDeNascimento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de nascimento: (ex.: 1999)", "Ano do Nascimento do Animal", JOptionPane.QUESTION_MESSAGE));
                        continuar = false;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ano informado é inválido!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return new Adocao();
                    }
                } while (continuar);

                String tamanhoAnimal = null;
                do {
                    continuar = true;
                    try {
                        tamanhoAnimal = perguntaPesquisarAnimalTamanho();
                        continuar = false;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Tamanho informado é inválido!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return new Adocao();
                    }
                } while (continuar);

                String comportamento;
                do {
                    continuar = true;
                    comportamento = "";
                    try {
                        String comp = JOptionPane.showInputDialog(null, """
                                Qual o comportamento do animal?
                                1 - Dócil
                                2 - Agressivo""", "Comportamento do Animal", JOptionPane.QUESTION_MESSAGE);
                        switch (comp) {
                            case "1" -> comportamento = Comportamento.DOCIL.toString();
                            case "2" -> comportamento = Comportamento.AGRESSIVO.toString();
                            default ->
                                    JOptionPane.showMessageDialog(null, "Digite uma das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Comportamento informado é inválido!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return new Adocao(null, null, null, null, null, null, null, null);
                    }
                    if (!comportamento.equals("")) {
                        continuar = false;
                    }
                } while (continuar);

                animalCadastrado = new Adocao(nomeAnimal, tamanhoAnimal, especie, raca, comportamento, diaDeNascimento, mesDeNascimento, anoDeNascimento);

                continuarPrincipal = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Verifique se digitou corretamente as informações!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
                return new Adocao();
            }
        } while (continuarPrincipal);

        return animalCadastrado;
    }

    /**
     * Método que é utilizado para fazer as perguntas necessárias para
     * pegar o tamanho a ser pesquisado e ser utilizado no método pesquisarAnimalPeloTamanho.
     * @return tamanho do animal.
     */
    public  String perguntaPesquisarAnimalTamanho() {
        boolean continuar;
        String tamanhoAnimal = "";
        do {
            continuar = true;
            try {
                String tam = JOptionPane.showInputDialog(null, """
                        Qual o tamanho do animal?
                        1 - Pequeno
                        2 - Médio
                        3 - Grande""", "Tamanho do Animal", JOptionPane.QUESTION_MESSAGE);

                switch (tam) {
                    case "1" -> tamanhoAnimal = TamanhoAnimal.PEQUENO.toString();
                    case "2" -> tamanhoAnimal = TamanhoAnimal.MEDIO.toString();
                    case "3" -> tamanhoAnimal = TamanhoAnimal.GRANDE.toString();
                    default ->
                            JOptionPane.showMessageDialog(null, "Digite umas das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite umas das opções informadas!", "Informação incorreta", JOptionPane.WARNING_MESSAGE);

            } catch (NullPointerException e) {
                e.printStackTrace();
                break;
            }
            if(!tamanhoAnimal.equals("")) {
                continuar = false;
            }
        } while (continuar);


        return tamanhoAnimal;
    }

    /**
     * Método que é utilizado para fazer a pergunta necessária para deletar
     * um objeto do tipo Adoção.
     * @return o nome do animal a ser deletado
     */
    public String perguntaDeletarAnimal() {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        return JOptionPane.showInputDialog(null, "Digite o nome do animal que deseja deletar: (ex.: Rex)", "Nome do Animal", JOptionPane.QUESTION_MESSAGE);

    }
}