package AULAS.Aula08_p2;
import javax.swing.*;
public class TesteGeral {
    public static void main(String[] args) {
        int opcao;

        opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite um número, sendo:"+"\n"+"1. Pessoa"+"\n"+"2. Pessoa Física"+"\n"+"3. Aluno"+"\n"+"4. Pessoa Jurídica"));

        switch (opcao){
            case 1:
                String nome = JOptionPane.showInputDialog("Digite seu nome");
                String endereco = JOptionPane.showInputDialog("Digite seu endereço");
                Pessoa testePessoa = new Pessoa(nome, endereco);
                JOptionPane.showMessageDialog(null, testePessoa);
                break;

            case 2:
                nome = JOptionPane.showInputDialog("Digite seu nome");
                endereco = JOptionPane.showInputDialog("Digite seu endereço");
                String rg = JOptionPane.showInputDialog("Digite seu RG");
                String cpf = JOptionPane.showInputDialog("Digite seu CPF");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade"));
                PessoaFisica testePessoaFisica = new PessoaFisica(nome, endereco, rg, cpf, idade);
                JOptionPane.showMessageDialog(null, testePessoaFisica);
                break;

            case 3:
                nome = JOptionPane.showInputDialog("Digite seu nome");
                endereco = JOptionPane.showInputDialog("Digite seu endereço");
                rg = JOptionPane.showInputDialog("Digite seu RG");
                cpf = JOptionPane.showInputDialog("Digite seu CPF");
                idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade"));
                String ra = JOptionPane.showInputDialog("Digite seu RA");
                String curso = JOptionPane.showInputDialog("Digite seu curso");
                Aluno testeAluno = new Aluno(nome, endereco, rg, cpf, idade, ra, curso);
                JOptionPane.showMessageDialog(null, testeAluno);
                break;

            case 4:
                nome = JOptionPane.showInputDialog("Digite seu nome");
                endereco = JOptionPane.showInputDialog("Digite seu endereço");
                String ie = JOptionPane.showInputDialog("Digite seu IE");
                String cnpj = JOptionPane.showInputDialog("Digite seu CNPJ");
                PessoaJuridica testePessoaJuridica = new PessoaJuridica(nome, endereco, ie, cnpj);
                JOptionPane.showMessageDialog(null, testePessoaJuridica);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Número inválido");
        }

    }
}
