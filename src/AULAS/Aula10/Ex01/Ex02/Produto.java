package AULAS.Aula10.Ex01.Ex02;

public class Produto {
    protected int codigo;
    protected float preco;
    protected String descricao;

    public Produto(){
    }
    public Produto(int codigo, float preco, String descricao){
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return "Código: "+codigo+"\n"+
                "Preço: R$"+preco+"\n"+
                "Descrição: "+descricao+"."+"\n";
    }
}
