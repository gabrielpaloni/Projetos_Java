package AULAS.Aula08.Ex01.Ex02;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(){
    }
    public Produto(int codigo, String descricao, double preco, int quantidade){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return "Código: " + codigo +"\n" +
                "Descrição: " + descricao+"\n"+
                "Preço: R$" + preco+ "\n"+
                "Quantidade: " + quantidade+"\n"+
                "Valor Total: R$" + totaliza();
    }

    private double totaliza(){
        return preco * quantidade;
    }
}
