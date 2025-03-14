package AULAS.Aula08.Ex01.Ex03;

import javax.swing.*;

public class TesteFuncionario {
    public static void main(String[] args) {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto"));
        String nome = JOptionPane.showInputDialog("Digite a descrição do produto");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto"));
        double umPorcento = Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem de aumento"));
        double umValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser aumentado"));

        Funcionario testeFunc = new Funcionario(id, nome, salario);

        testeFunc.aumentaSalarioPorcentagem(umPorcento);
        testeFunc.salarioAbstoluto(umValor);

        JOptionPane.showMessageDialog(null, testeFunc);
    }
}
