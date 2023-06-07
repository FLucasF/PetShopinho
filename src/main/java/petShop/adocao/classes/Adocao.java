package petShop.adocao.classes;

/***
 * Classe para objetos do tipo Adocao, onde serão contidos, valores e métodos para o mesmo.
 * @author Lucas Felipe
 */

public class Adocao {
    private String nomeAnimal;
    private String tamanhoAnimal;
    private String especie;
    private String raca;
    private String comportamento;
    private Integer diaDeNascimentoDoAnimal;
    private Integer mesDeNascimentoDoAnimal;
    private Integer anoDeNascimentoDoAnimal;

    public Adocao(String nomeAnimal, String tamanhoAnimal, String especie, String raca, String comportamento, Integer diaDeNascimentoDoAnimal, Integer mesDeNascimentoDoAnimal, Integer anoDeNascimentoDoAnimal) {
        this.nomeAnimal = nomeAnimal;
        this.tamanhoAnimal = tamanhoAnimal;
        this.especie = especie;
        this.raca = raca;
        this.comportamento = comportamento;
        this.diaDeNascimentoDoAnimal = diaDeNascimentoDoAnimal;
        this.mesDeNascimentoDoAnimal = mesDeNascimentoDoAnimal;
        this.anoDeNascimentoDoAnimal = anoDeNascimentoDoAnimal;

    }

    public Adocao() {
        this(null, null, null, null, null, null, null, null);
    }

    public String toString() {
        return "Nome do Animal: " +this.nomeAnimal+ ", Tamanho: " +this.tamanhoAnimal+ ", Espécie: "+this.especie+
                ", Raça: " +this.raca+ ", Comportamento: " +this.comportamento+ ", que nasceu no dia: " +this.diaDeNascimentoDoAnimal+
                " do mês: " +this.mesDeNascimentoDoAnimal+ " do ano: " +this.anoDeNascimentoDoAnimal;
    }

    public String getNomeAnimal() {
        return this.nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTamanhoAnimal() {
        return this.tamanhoAnimal;
    }

    public void setTamanhoAnimal(String tamanhoAnimal) {
        this.tamanhoAnimal = tamanhoAnimal;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getComportamento() {
        return this.comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public Integer getDiaDeNascimentoDoAnimal() {
        return this.diaDeNascimentoDoAnimal;
    }

    public void setDiaDeNascimentoDoAnimal(Integer diaDeNascimentoDoAnimal) {
        this.diaDeNascimentoDoAnimal = diaDeNascimentoDoAnimal;
    }

    public Integer getMesDeNascimentoDoAnimal() {
        return this.mesDeNascimentoDoAnimal;
    }

    public void setMesDeNascimentoDoAnimal(Integer mesDeNascimentoDoAnimal) {
        this.mesDeNascimentoDoAnimal = mesDeNascimentoDoAnimal;
    }

    public Integer getAnoDeNascimentoDoAnimal() {
        return this.anoDeNascimentoDoAnimal;
    }

    public void setAnoDeNascimentoDoAnimal(Integer anoDeNascimentoDoAnimal) {
        this.anoDeNascimentoDoAnimal = anoDeNascimentoDoAnimal;
    }
}
