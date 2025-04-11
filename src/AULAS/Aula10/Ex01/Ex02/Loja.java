package AULAS.Aula10.Ex01.Ex02;
import javax.swing.*;
import java.text.DecimalFormat;

public class Loja {
    public static void main(String[] args) {
        int choice, codigo;
        Produto[] products = new Produto[3];
        String descricao;
        float preco;
        Produto goods;

        for (int i = 0; i < 3; i++) {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Escolha o produto que deseja cadastrar" + "\n" + "1. Livro" + "\n" + "2. Jogo"));
            switch (choice) {
                case 1:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual o código do livro?"));
                    descricao = JOptionPane.showInputDialog("Qual a descrição do livro?");
                    preco = Float.parseFloat(JOptionPane.showInputDialog("Qual o preço do livro?"));
                    String autor = JOptionPane.showInputDialog("Qual o nome do autor?");
                    goods = new Livro(codigo, preco, descricao, autor);
                    products[i] = goods;
                    break;

                case 2:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual o código do jogo?"));
                    descricao = JOptionPane.showInputDialog("Qual a descrição do jogo?");
                    preco = Float.parseFloat(JOptionPane.showInputDialog("Qual o preço do jogo?"));
                    goods = new Game(codigo, preco, descricao);
                    products[i] = goods;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida. Tente novamente!");
                    i--; // Decrementa i para repetir a iteração atual
                    break;
            }
        }
        imprime(products);
    }

    static void imprime(Produto[] products) {
        StringBuilder blocoDoToString = new StringBuilder();
        for (Produto goods : products) {
            blocoDoToString.append(goods.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, blocoDoToString.toString());
    }
}