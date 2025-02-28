package AULAS.Aula02;
import javax.swing.JOptionPane;

public class Hr_trabalhadas {
    public static void main(String[] args) {
        float hr_trabalhada, reais_por_hora, total_por_hora;

        hr_trabalhada = Float.parseFloat(JOptionPane.showInputDialog("Quantas horas foram trabalhadas no mês? "));
        reais_por_hora = Float.parseFloat(JOptionPane.showInputDialog("Quanto você ganha por hora?"));
        total_por_hora = hr_trabalhada * reais_por_hora;

        JOptionPane.showMessageDialog(null, "O valor a ser recebido é: R$" + total_por_hora);

    }
}

