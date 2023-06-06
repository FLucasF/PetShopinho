package petShop.adocao.gravadorAdocao;

import petShop.adocao.classes.Adocao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeAdocao {
    private final String arquivoAdocao = "adocao.txt";
    private final GravadorDeDadosAdocao gravadorAdocao;

    public GravadorDeAdocao() {
        this.gravadorAdocao = new GravadorDeDadosAdocao();
    }

    /***
     * Método que recebe uma List do tipo Animal, que enquanto for percorrida, pega todos os atributos
     * salva em uma string, usando # como separador, e transforma tudo em uma lista de string, logo
     * depois utiliza o metodo gravarTextoEmArquivo para gravar em txt.
     * @param animais
     * @throws IOException ;
     */
    public void gravaAdocao(List<Adocao> animais) throws IOException {
        List<String> textoAGravar = new ArrayList<>();
        for (Adocao a : animais) {
            String linha = a.getNomeAnimal() +"#"+ a.getTamanhoAnimal() +"#"+ a.getEspecie() +"#"+ a.getRaca() +"#"+
                    a.getComportamento() +"#"+ a.getDiaDeNascimentoDoAnimal() +"#"+ a.getMesDeNascimentoDoAnimal() +"#"+
                    a.getAnoDeNascimentoDoAnimal();
            textoAGravar.add(linha);
        }
        this.gravadorAdocao.gravaTextoEmArquivo(textoAGravar, this.arquivoAdocao);
    }

    /***
     * Método retorna uma arraylist do tipo Animal, que le a pasta txt e utilizando o separador, cria
     * um objeto do tipo animal e logo em seguida adiciona ele na lista animais.
     * @return ArrayList<Animal>
     * @throws IOException;
     */

    public ArrayList<Adocao> recuperarAdocao() throws IOException {
        List<String> dadosDosAnimais = this.gravadorAdocao.recuperaTextoDeArquivo(this.arquivoAdocao);
        ArrayList<Adocao> listaAnimais = new ArrayList<>();
        for(String s : dadosDosAnimais) {
            String[] dados = s.split("#");
            Adocao animal = new Adocao(dados[0], dados[1], dados[2], dados[3], dados[4], Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), Integer.parseInt(dados[7]));
            listaAnimais.add(animal);
        }
        return listaAnimais;
    }
}
