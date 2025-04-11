package AULAS.Aula10.Ex01.Ex02;

import java.text.DecimalFormat;

public class Game extends Produto implements Caixa {
    public Game() {
    }

    public Game(int codigo, float preco, String descricao) {
        super(codigo, preco, descricao);
    }

    public float calculaDesconto() {
        return preco - preco * 0.15f;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00"); // Formato para preços
        return "Tipo: Jogo\n"+
                super.toString() +
                "Preço com desconto: " + df.format(calculaDesconto());
    }
}
