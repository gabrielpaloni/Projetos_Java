package AULAS.Aula10.Ex01;

public class Cds extends Produto {
    int numeroDeFaixas;

    public Cds(){
    }
    public Cds(String nome, double preco, int numeroDeFaixas){
        super(nome, preco);
        this.numeroDeFaixas = numeroDeFaixas;
    }

    public int getNumeroDeFaixas() {
        return numeroDeFaixas;
    }
    public void setNumeroDeFaixas(int numeroDeFaixas) {
        this.numeroDeFaixas = numeroDeFaixas;
    }

    public String toString(){
        return super.toString()+
                "Número de faixas: "+numeroDeFaixas;
    }

}
