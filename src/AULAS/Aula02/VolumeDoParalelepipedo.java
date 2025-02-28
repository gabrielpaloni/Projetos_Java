package AULAS.Aula02;
import javax.swing.JOptionPane;

public class VolumeDoParalelepipedo {
    public static void main(String[] args) {
        double comprimento;
        double largura;
        double altura;
        double volumeTotal;

        comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento: "));
        largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura: "));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));
        volumeTotal = comprimento * largura * altura;

        JOptionPane.showMessageDialog(null, "O volume total do parelelepípedo é: "+volumeTotal+"m³");

    }
}
