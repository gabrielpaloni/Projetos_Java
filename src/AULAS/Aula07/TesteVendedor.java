package AULAS.Aula07;

import javax.swing.*;

public class TesteVendedor {
    public static void main(String[] args) {
        // Criando o objeto vendedor com entrada de dados via JOptionPane
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor"));
        String nome = JOptionPane.showInputDialog("Digite o nome do vendedor");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do vendedor");

        // Criando o objeto vendedor com o construtor
        Vendedor vendedor = new Vendedor(codigo, nome, endereco);

        // Adicionando as vendas de forma segura
        float vendas = Float.parseFloat(JOptionPane.showInputDialog("Digite a quantidade total de vendas do(a) " + vendedor.getNome()));
        vendedor.addVendas(vendas);

        // Adicionando mais vendas (exemplo)
        vendedor.addVendas(0);

        // Exibindo os dados do vendedor de maneira encapsulada
        JOptionPane.showMessageDialog(null,
                "Código do vendedor: " + vendedor.getCodigo() +
                        "\nNome: " + vendedor.getNome() +
                        "\nEndereço: " + vendedor.getEndereco() +
                        "\nTotal de vendas: " + vendedor.getTotalVendas() +
                        "\nComissão: R$ " + vendedor.getComissao());
    }
}
