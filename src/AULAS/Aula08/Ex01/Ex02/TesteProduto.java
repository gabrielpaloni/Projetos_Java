package AULAS.Aula08.Ex01.Ex02;
import javax.swing.*;

public class TesteProduto {
    public static void main(String[] args) {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto"));
        String descricao = JOptionPane.showInputDialog("Digite a descrição do produto");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto"));

        Produto testeProduto = new Produto(codigo, descricao, preco, quantidade);

        JOptionPane.showMessageDialog(null, testeProduto);
    }
}
