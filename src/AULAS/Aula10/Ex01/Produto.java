package AULAS.Aula10.Ex01;

public class Produto {
    String nome;
    double preco;

    public Produto(){
    }
    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Nome: "+nome+"\n"+
                "Preço: "+preco+" Reais"+"\n";
    }
}
