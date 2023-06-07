package petShop.adocao.classes;


import petShop.adocao.InterfaceAdocao;
import petShop.adocao.exceptions.AnimalInformadoIncorretamenteException;
import petShop.adocao.exceptions.AnimalNaoEncontradoException;
import petShop.adocao.exceptions.FalhaAoCadastrarAnimalException;
import petShop.adocao.exceptions.ListaAnimalVaziaException;
import java.util.ArrayList;
import java.util.List;

/***
 * Classe para metodos do tipo adocao, onde serão contidos, métodos para o mesmo.
 * @author Lucas Felipe
 */

public class GerenciamentoAdocao implements InterfaceAdocao {
    private ArrayList<Adocao> animais;

    public GerenciamentoAdocao() {
        this.animais = new ArrayList<>();
    }

    /**
     * Método utilizado para cadastrar o animal a ser adotado.
     * @param animalCadastrar
     * @return boolean, true caso consiga cadastrar e false caso não consiga cadastrar.
     * @throws AnimalInformadoIncorretamenteException
     * @throws FalhaAoCadastrarAnimalException
     */
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
    /**
     * Método utilizado para pesquisar animal pelo tamanho  na lista de adoção.
     * @param tamanhoDoAnimalVerificar
     * @return msg, que no caso, é uma String concatenada com todos os objetos que tem como atributo
     * o tamanho informado.
     * @throws AnimalNaoEncontradoException
     * @throws ListaAnimalVaziaException
     */
    @Override
    public String pesquisarAnimalPeloTamanho(String tamanhoDoAnimalVerificar) throws AnimalNaoEncontradoException, ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (Adocao a : this.animais) {
                if (a.getTamanhoAnimal().equals(tamanhoDoAnimalVerificar)) {
                    msg.append(a).append("\n").append("==--==").append("\n");
                }
            }
            if (msg.toString().equals("")) {
                throw new AnimalNaoEncontradoException("Animal do tamanho informado não foi encontrado na lista animais.");
            }
            return msg.toString();
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    /**
     * Método utilizado para obter a lista de todos os objetos contidos na lista animais.
     * @return List<Adocao>
     * @throws ListaAnimalVaziaException
     */

    @Override
    public List<Adocao> obterListaDeAnimais() throws ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            return this.animais;
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    /**
     * Método utilizado para deletar o animal cujo o nome seja igual ao do informado.
     * @param nomeDoAnimal
     * @return boolean, true caso consiga cadastrar e false caso não consiga cadastrar.
     * @throws AnimalNaoEncontradoException
     */
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
