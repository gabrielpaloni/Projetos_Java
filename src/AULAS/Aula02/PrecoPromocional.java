package AULAS.Aula02;
import javax.swing.JOptionPane;

public class PrecoPromocional {
    public static void main(String[] args) {
        double precoProduto;
        double precoPromocional;

        precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto"));
        precoPromocional = precoProduto - precoProduto * 0.05f;

        JOptionPane.showMessageDialog(null,"O preço com desconto de 5% é: R$"+precoPromocional);
    }
}