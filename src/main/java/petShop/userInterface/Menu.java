package petShop.userInterface;

import javax.swing.*;

/***
 * Classe para métodos do tipo Menu, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public class Menu {
    public static String exibirMenu() { //Menu principal
        return JOptionPane.showInputDialog(null, """
                ================================
                MENU PRINCIPAL
                ================================
                Escolha uma das opções abaixo:
                        
                [1] Adoção de Animais
                [2] Serviços do PetShop
                        
                =================================
                Digite o número da opção desejada:
                =================================""", "Menu Principal", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String exibirMenuAdicionarAnimal() { //Menu quando for selecionado a parte de adoção
        return JOptionPane.showInputDialog(null, """
                ================================
                ADOÇÃO
                ================================
                Escolha uma das opções abaixo:
                        
                [1] Registrar Animal
                [2] Pesquisar Animais pelo Tamanho
                [3] Listar Animais
                [4] Deletar Animal
                        
                =================================
                Digite o número da opção desejada:
                =================================""", "Menu Adoção", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String exibirMenuServicos() { //Menu quando for selecionado a parte de serviços
        return JOptionPane.showInputDialog(null, """
                ================================
                SERVIÇOS
                ================================
                Escolha uma das opções abaixo:
                        
                [1] Registrar Agendamento
                [2] Pesquisar Agendamentos pelo Dia
                [3] Listar Agendamentos
                [4] Deletar Agendamento
                        
                =================================
                Digite o número da opção desejada:
                =================================""", "Menu Serviços", JOptionPane.INFORMATION_MESSAGE);
    }
}
