package AULAS.Aula03;
import javax.swing.JOptionPane;

public class SomaEMedia {
    public static void main(String[] args) {
        int numero = 1, soma = 0, i = 0;
        double media;

        while (numero > 0){
            numero = Integer.parseInt((JOptionPane.showInputDialog("Digite um número")));
            if (numero > 0){
                soma += numero;
                i++;
            }
        }
        media = soma / i;
        JOptionPane.showMessageDialog(null, "A soma entre os números é: "+soma);
        JOptionPane.showMessageDialog(null,"A média entre a soma e os número é: "+media);
    }
}