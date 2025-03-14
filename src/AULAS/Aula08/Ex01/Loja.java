package AULAS.Aula08.Ex01;

public class Loja {
    private int codigo;
    private String descricao;
    private int quantidade;

    public Loja(){
    }
    public Loja (int codigo, String descricao, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return "Código: " + codigo+ "\n"+
                "Descrição: " + descricao +"\n"+
                "Quantidade: " + quantidade;
    }
}
