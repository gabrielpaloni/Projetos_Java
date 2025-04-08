package AULAS.Aula10.Ex01;

public class Dvds extends Produto{
    double duracao;

    public Dvds(){
    }
    public Dvds(String nome, double preco, double duracao){
        super(nome, preco);
        this.duracao = duracao;
    }

    public double getDuracao() {
        return duracao;
    }
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return super.toString()+
                "Duração: "+duracao+" Minutos";
    }

}
