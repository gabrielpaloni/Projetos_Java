package AULAS.AulaRevisao2;
import javax.swing.*;

public class TesteTelefone {
    public static void main(String[] args) {
        int ligacoes = 1;
        int choice;
        char opcao;

        choice = Integer.parseInt(JOptionPane.showInputDialog("Digite um número, sendo:"+"\n"+"1. Conta de Telefone"+"\n"+"2. Conta de Celular"));

            switch (choice){
                case 1:
                    String numero = JOptionPane.showInputDialog("Digite seu número de telefone");
                    int minutos = Integer.parseInt(JOptionPane.showInputDialog("Quantos minutos durou sua "+ligacoes+"º ligação?"));
                    ContaTelefone testeContaTelefone = new ContaTelefone(numero, minutos);
                    do {
                        opcao = JOptionPane.showInputDialog("Deseja adicionar outra chamada?").charAt(0);
                        if (opcao == 's' || opcao == 'S') {
                            ligacoes += 1;
                            minutos = Integer.parseInt(JOptionPane.showInputDialog("Quantos minutos durou sua " + ligacoes + "º ligação?"));
                            testeContaTelefone.setTotalMinutos(minutos);
                            }
                        }
                    while (opcao != 'n' && opcao != 'N' );
                    JOptionPane.showMessageDialog(null, testeContaTelefone);
                    break;
                case 2:
                    numero = JOptionPane.showInputDialog("Digite seu número de Celular");
                    minutos = Integer.parseInt(JOptionPane.showInputDialog("Quantos minutos durou sua "+ligacoes+"º ligação?"));
                    ContaCelular testeContaCelular = new ContaCelular(numero, minutos);
                    do {
                        opcao = JOptionPane.showInputDialog("Deseja adicionar outra chamada?").charAt(0);
                        if (opcao == 's' || opcao == 'S') {
                            ligacoes += 1;
                            minutos = Integer.parseInt(JOptionPane.showInputDialog("Quantos minutos durou sua " + ligacoes + "º ligação?"));
                            testeContaCelular.setTotalMinutos(minutos);
                        }
                    }
                    while (opcao != 'n' && opcao != 'N' );
                    JOptionPane.showMessageDialog(null, testeContaCelular);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida.");

        }
    }
}
