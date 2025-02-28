package AULAS.Aula02;
import javax.swing.JOptionPane;

public class ParImpar {
    public static void main(String[] args) {
        int numero;

        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

        if (numero % 2 == 0)
            JOptionPane.showMessageDialog(null, numero+ " é par.");
        else
            JOptionPane.showMessageDialog(null, numero + " é impar.");
    }
}
