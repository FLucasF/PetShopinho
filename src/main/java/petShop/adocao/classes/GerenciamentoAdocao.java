package petShop.adocao.classes;

import petShop.adocao.InterfaceAdocao;
import petShop.adocao.exceptions.AnimalInformadoIncorretamenteException;
import petShop.adocao.exceptions.AnimalNaoEncontradoException;
import petShop.adocao.exceptions.FalhaAoCadastrarAnimalException;
import petShop.adocao.exceptions.ListaAnimalVaziaException;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoAdocao implements InterfaceAdocao {
    private ArrayList<Adocao> animais;

    public GerenciamentoAdocao() {
        this.animais = new ArrayList<>();
    }

    @Override
    public boolean cadastrarAnimal (Adocao animalCadastrar) throws AnimalInformadoIncorretamenteException, FalhaAoCadastrarAnimalException{
        if (animalCadastrar.getNomeAnimal() == (null)) { //VERIFICAR COMO VERIFICAR SE TODOS SÃO NULOS
            throw new AnimalInformadoIncorretamenteException("Animal contem null como caracteristica.");
        } else {
            if (this.animais.add(animalCadastrar)) {
                return true;
            } else {
                throw new FalhaAoCadastrarAnimalException("Houve um erro na hora do cadastro de animal.");
            }
        }
    }
    @Override
    public String pesquisarAnimalPeloTamanho(String tamanhoDoAnimalVerificar) throws AnimalNaoEncontradoException, ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            String msg = "";
            for (Adocao a : this.animais) {
                if (a.getTamanhoAnimal().equals(tamanhoDoAnimalVerificar)) {
                    msg += a + "\n" + "==--==" + "\n";
                }
            }
            if (msg.equals("")) {
                throw new AnimalNaoEncontradoException("Animal do tamanho informado não foi encontrado na lista animais.");
            }
            return msg;
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    @Override
    public List<Adocao> obterListaDeAnimais() throws ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            return this.animais;
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    @Override
    public boolean deletarAnimal(String nomeDoAnimal) throws AnimalNaoEncontradoException {
        if (!this.animais.isEmpty()) {
            for (Adocao a : this.animais) {
                if (a.getNomeAnimal().equals(nomeDoAnimal)){
                    this.animais.remove(a);
                    return true;
                }
            }
            return false;
        }
        throw new AnimalNaoEncontradoException("Animal não encontrado na lista animais.");
    }





    public ArrayList<Adocao> getAnimais() {
        return this.animais;
    }
    public void setAnimais(ArrayList<Adocao> animais) {
        this.animais = animais;
    }
}
