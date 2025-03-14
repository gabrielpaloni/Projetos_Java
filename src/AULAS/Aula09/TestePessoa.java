package AULAS.Aula09;
import javax.swing.*;

public class TestePessoa {
    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Digite seu nome");
        String endereco = JOptionPane.showInputDialog ("Digite seu endereço");
        int idade= Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o seu peso atual em kg"));

        Pessoa testePessoa = new Pessoa(nome, endereco, idade, altura, peso);

        JOptionPane.showMessageDialog(null, testePessoa);
    }
}