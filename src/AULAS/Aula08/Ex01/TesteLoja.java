package AULAS.Aula08.Ex01;

import javax.swing.*;

public class TesteLoja {
    public static void main(String[] args) {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor"));
        String descricao = (JOptionPane.showInputDialog("Digite a descrição do produto"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos"));

        Loja testeLoja = new Loja(codigo, descricao, quantidade);

        JOptionPane.showMessageDialog(null, testeLoja);
    }
}