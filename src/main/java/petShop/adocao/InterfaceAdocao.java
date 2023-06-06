package petShop.adocao;


import petShop.adocao.classes.Adocao;
import petShop.adocao.exceptions.AnimalInformadoIncorretamenteException;
import petShop.adocao.exceptions.AnimalNaoEncontradoException;
import petShop.adocao.exceptions.FalhaAoCadastrarAnimalException;
import petShop.adocao.exceptions.ListaAnimalVaziaException;

import java.util.List;

public interface InterfaceAdocao {
    boolean cadastrarAnimal(Adocao animalCadastrar) throws AnimalInformadoIncorretamenteException, FalhaAoCadastrarAnimalException;
    String pesquisarAnimalPeloTamanho(String tamanho) throws AnimalNaoEncontradoException, ListaAnimalVaziaException;
    List<Adocao> obterListaDeAnimais() throws ListaAnimalVaziaException;
    boolean deletarAnimal(String nome) throws AnimalNaoEncontradoException;

}
