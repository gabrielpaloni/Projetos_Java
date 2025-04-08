package AULAS.Aula10.Ex01;
import javax.swing.*;

public class Loja {
    public static void main(String[] args) {
        Produto [] produtos = new Produto[5];
        Produto prod;
        String nome;
        double preco;
        int choice;

        for(int i = 0; i < 5; i++){
            choice = Integer.parseInt(JOptionPane.showInputDialog("Escolha o produto que deseja adicionar:\n" +
                    "1. CD\n"+"2. DVD\n"+"3. Livro"));

            switch(choice){
                case 1:
                    nome = JOptionPane.showInputDialog("Digite o nome do CD");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do CD"));
                    int numeroDeFaixas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de faixas"));
                    prod = new Cds(nome, preco, numeroDeFaixas);
                    produtos[i] = prod;
                    break;
                case 2:
                    nome = JOptionPane.showInputDialog("Digite o nome do DVD");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do DVD"));
                    int duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração"));
                    prod = new Dvds(nome, preco, duracao);
                    produtos[i] = prod;
                    break;
                case 3:
                    nome = JOptionPane.showInputDialog("Digite o nome do Livro");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do Livro"));
                    String autor = JOptionPane.showInputDialog("Digite o nome do Autor");
                    prod = new Livros(nome, preco, autor);
                    produtos[i] = prod;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida, tente novamente!");
                    break;
            }
        }
        imprime(produtos);
    }
    static void imprime(Produto[] produtos){
        for(Produto prod: produtos){
            JOptionPane.showMessageDialog(null, prod);
        }
    }
}
