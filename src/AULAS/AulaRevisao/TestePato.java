package AULAS.AulaRevisao;
import javax.swing.*;

public class TestePato {
    public static void main(String[] args) {
        int opcao;

        opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite um número, sendo:"+"\n"+"1. Pato"+"\n"+"2. Pato de Madeira"+"\n"+"3. Pato de Borracha"+"\n"+"4. Super Pato"));

        switch (opcao){
            case 1:
                String nome = JOptionPane.showInputDialog("Digite o nome do seu pato");
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do(a) "+nome));
                Pato testePato = new Pato(nome, ano);
                JOptionPane.showMessageDialog(null, testePato);
                break;
            case 2:
                nome = JOptionPane.showInputDialog("Digite o nome do seu pato");
                ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do(a) "+nome));
                PatoMadeira testePatoMadeira = new PatoMadeira(nome, ano);
                JOptionPane.showMessageDialog(null, testePatoMadeira);
                break;
            case 3:
                nome = JOptionPane.showInputDialog("Digite o nome do seu pato");
                ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do(a) "+nome));
                String cor = JOptionPane.showInputDialog("Digite a cor do(a) "+nome);
                PatoBorracha testePatoBorracha = new PatoBorracha(nome, ano, cor);
                JOptionPane.showMessageDialog(null, testePatoBorracha);
                break;
            case 4:
                nome = JOptionPane.showInputDialog("Digite o nome do seu pato");
                ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do(a) "+nome));
                float poder = Float.parseFloat(JOptionPane.showInputDialog("Digite nível de poder do(a) "+nome));
                SuperPato testeSuperPato = new SuperPato(nome, ano, poder);
                JOptionPane.showMessageDialog(null, testeSuperPato);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha inválida");
        }
    }
}
