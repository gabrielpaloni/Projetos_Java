package AULAS.Aula02;
import javax.swing.JOptionPane;

public class SalarioNovo15p {
    public static void main(String[] args){
    double salario;
    double salarioNovo;

    salario = Double.parseDouble(JOptionPane.showInputDialog("Digite seu salário atual: R$"));
    salarioNovo = salario + salario * 0.15;
    JOptionPane.showMessageDialog(null, "Seu salário com o reajuste é: R$"+salarioNovo);
    }
}
