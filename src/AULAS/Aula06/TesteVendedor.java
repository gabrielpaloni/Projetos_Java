package AULAS.Aula06;
import javax.swing.*;

public class TesteVendedor {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor();
        vendedor.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor"));
        vendedor.nome = JOptionPane.showInputDialog("Digite o nome do vendedor");
        vendedor.endereco = JOptionPane.showInputDialog("Digite o endereço do vendedor");
        vendedor.totalVendas = Float.parseFloat(JOptionPane.showInputDialog("Digite a qualtidade total de vendas do(a) "+vendedor.nome));

        vendedor.calcularComissao();
        vendedor.addVendas(150);

        JOptionPane.showMessageDialog(null, "O código do vendedor é: "+vendedor.codigo+ "\nO nome do vendedor(a) é: "+vendedor.nome+
                "\nO endereço do vendedor(a) é: "+vendedor.endereco+"\n A quantidade total de vendas do vendedor(a) foi: "+vendedor.totalVendas);

    }
}
