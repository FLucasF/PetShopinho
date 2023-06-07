package petShop.agendamento.classes;

/***
 *Classe para objetos do tipo DonoAnimal, onde serão contidos, valores e métodos para o mesmo.
 *@author Lucas Felipe
 */

public class DonoAnimal {
    private String nomeDono;
    public DonoAnimal(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public DonoAnimal() {
        this(null);
    }

    @Override
    public String toString() {
        return "DONO: \nNome do Dono: " + this.nomeDono;
    }

    public String getNomeDono() {
        return this.nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
}
