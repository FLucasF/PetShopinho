package petShop.agendamento.gravadorAgendamento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDadosAgendamento {

    /***
     * Método que recebe o nome do arquivo que vai ser lido, com o leitor pega o arquivo,
     * vai ler a linha, se a linha não for null, vai adicionar na array texto lido, depois de finalizar
     * ele vai retornar a lista com todas as strings.
     * @param nomeArquivo nom do arquivo para recuperar os dados.
     * @return List<String>
     * @throws IOException que é lançado quando algum sinal de entrada/saída falha ou é interrompido.
     */
    public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto;
            do {
                texto = leitor.readLine();
                if (texto != null) {
                    textoLido.add(texto);
                }
            } while (texto != null);
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;
    }

    /***
     * Método que grava os dados da agendamento
     * @param texto lista de dados a serem gravados.
     * @param nomeArquivo nome do arquivo a ser gravado.
     * @throws IOException que é lançado quando algum sinal de entrada/saída falha ou é interrompido.
     */
    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException {

        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (String s : texto) {
                gravador.write(s + "\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }
}

