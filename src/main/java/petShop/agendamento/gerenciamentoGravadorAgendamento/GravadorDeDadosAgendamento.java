package petShop.agendamento.gerenciamentoGravadorAgendamento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDadosAgendamento {

    /***
     * Método que recebe o nome do arquivo que vai ser lido, com o leitor pega o arquivo,
     * vai ler a linha, se a linha não for null, vai adicionar na array texto lido, depois de finalizar
     * ele vai retornar a lista com todas as strings.
     * @param nomeArquivo
     * @return
     * @throws IOException
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
     *
     * @param texto
     * @param nomeArquivo
     * @throws IOException
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

