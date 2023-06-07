package petShop.agendamento.gravadorAgendamento;

import petShop.adocao.classes.Adocao;
import petShop.agendamento.classes.Agendamento;
import petShop.agendamento.classes.DonoAnimal;
import petShop.agendamento.classes.Horario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeAgendamento {
    private final String arquivoAdocao = "agendamento.txt";
    private final GravadorDeDadosAgendamento gravadorAgendamento;

    public GravadorDeAgendamento() {
        this.gravadorAgendamento = new GravadorDeDadosAgendamento();
    }

    /***
     * Método que recebe uma List do tipo Agendamento, que enquanto for percorrida, pega todos os atributos
     * salva em uma string, usando # como separador, e transforma tudo em uma lista de string, logo
     * depois utiliza o metodo gravarTextoEmArquivo para gravar em txt.
     * @param agendamentos
     * @throws IOException
     */
    public void gravaAgendamento(List<Agendamento> agendamentos) throws IOException {
        List<String> textoAGravar = new ArrayList<>();
        for (Agendamento a : agendamentos) {
            String linha = a.getDonoAnimal().getNomeDono() + "#" + a.getAnimal().getNomeAnimal() + "#" + a.getAnimal().getTamanhoAnimal() + "#" + a.getAnimal().getEspecie() + "#" +
                    a.getAnimal().getRaca() + "#" + a.getAnimal().getComportamento() + "#" + a.getAnimal().getDiaDeNascimentoDoAnimal() + "#" +
                    a.getAnimal().getMesDeNascimentoDoAnimal() + "#" + a.getAnimal().getAnoDeNascimentoDoAnimal() + "#" + a.getHorario().getDia() + "#" +
                    a.getHorario().getHorario() + "#" + a.getTipoDeServico();
            textoAGravar.add(linha);
        }
        this.gravadorAgendamento.gravaTextoEmArquivo(textoAGravar, this.arquivoAdocao);
    }

    /***
     * Método retorna uma arraylist do tipo Agendamento, que le a pasta txt e utilizando o separador, cria
     * um objeto do tipo Agendamento e logo em seguida adiciona ele na lista agendamentos.
     * @return ArrayList<Agendamento> listaAgendamento
     * @throws IOException
     */
    public ArrayList<Agendamento> recuperarAgendamento() throws IOException {
        List<String> dadosDosAnimais = this.gravadorAgendamento.recuperaTextoDeArquivo(this.arquivoAdocao);
        ArrayList<Agendamento> listaAgendamento = new ArrayList<>();
        for (String s : dadosDosAnimais) {
            String[] dados = s.split("#");
            DonoAnimal donoAnimal = new DonoAnimal(dados[0]);
            Adocao animal = new Adocao(dados[1], dados[2], dados[3], dados[4], dados[5], Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), Integer.parseInt(dados[8]));
            Horario horario = new Horario(dados[9], dados[10]);
            String tipoDeServico = dados[11];
            Agendamento animalAgendado = new Agendamento(donoAnimal, animal, horario, tipoDeServico);
            listaAgendamento.add(animalAgendado);
        }
        return listaAgendamento;
    }
}

