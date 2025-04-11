package AULAS.Aula10.Ex01.Ex02;

import java.text.DecimalFormat;

public class Livro extends Produto implements Caixa {
    String autor;

    public Livro() {
    }

    public Livro(int codigo, float preco, String descricao, String autor) {
        super(codigo, preco, descricao);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float calculaDesconto() {
        return preco - preco * 0.10f;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00"); // Formato para preços
        return "Tipo: Livro\n"+
                super.toString() +
                "Autor: " + autor + ".\n" +
                "Preço com desconto: " + df.format(calculaDesconto());
    }
}
