package AULAS.Aula02;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class AlturaIdeal {
    public static void main(String[] args) {
        char sexo;
        float altura;
        double pesoIdeal;
        DecimalFormat df = new DecimalFormat("##0.00");

        altura = Float.parseFloat(JOptionPane.showInputDialog("Digite sua altura"));
        sexo = JOptionPane.showInputDialog("Digite seu gênero").charAt(0);

            if (sexo == 'm' || sexo == 'M') {
                pesoIdeal = (72.7 * altura) - 58;
                JOptionPane.showMessageDialog(null,"O peso ideal é: "+df.format(pesoIdeal) +" Kg");
            } else if (sexo == 'f' || sexo == 'F') {
                pesoIdeal = (62.1 * altura) - 44.7;
                JOptionPane.showMessageDialog(null,"O peso ideal é: "+df.format(pesoIdeal) +" Kg");
            } else {
                JOptionPane.showMessageDialog(null," Sexo inválido!");
            }
    }
}