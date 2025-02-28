package AULAS.Aula02;
import javax.swing.JOptionPane;

public class AreaPintada {
    public static void main(String[] args) {
        double largura, altura, area, quantidadeDeTinta;

        largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura da parede"));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura da parede"));
        area = largura * altura;
        quantidadeDeTinta = area / 2;

        int quantidadeFinal = (int) Math.ceil(quantidadeDeTinta);

        JOptionPane.showMessageDialog(null, "A área a ser pintada é: " + area);
        JOptionPane.showMessageDialog(null, "A quantidade total de tinta será: " + quantidadeFinal + " Litros");
    }
}
