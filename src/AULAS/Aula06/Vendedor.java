package AULAS.Aula06;

public class Vendedor {
    int codigo;
    String nome;
    String endereco;
    float totalVendas;
    double comissao;

    public void calcularComissao() {
        this.comissao = totalVendas * 0.10;
    }
    public void addVendas (float vendas){
        totalVendas+=vendas;
        calcularComissao();
    }
}
