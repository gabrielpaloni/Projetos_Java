package AULAS.Aula02;
import javax.swing.JOptionPane;

public class OrdemCrescente {
    public static void main(String[] args) {
        int numero1, numero2;

        numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número!"));
        numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro núumero"));

        if (numero1 > numero2 )
            JOptionPane.showMessageDialog(null, "Números em ordem crescente: "+ numero2 +", " + numero1);
        else
            JOptionPane.showMessageDialog(null, "Números em ordem crescente: "+ numero1+", " + numero2);
    }
}
