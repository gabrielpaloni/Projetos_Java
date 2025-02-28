package AULAS.Aula03;
import javax.swing.JOptionPane;

public class PotenciaESubtracao {
    public static void main(String[] args) {
        int numero1, numero2;

        numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        if (numero1 > numero2){
           int diferenca = numero1 - numero2;
           JOptionPane.showMessageDialog(null, "A diferença entre "+numero1+ " - "+numero2 +" é: "+diferenca);
           double potencia = Math.pow(numero1,numero2);
           JOptionPane.showMessageDialog(null, "A potêncialização de "+numero1+ " por "+numero2 +" é: "+potencia);
        } else {
            int diferenca = numero2 - numero1;
            JOptionPane.showMessageDialog(null, "A diferença entre "+numero2+ " - "+numero1 +" é: "+diferenca);
            double potencia = Math.pow(numero2,numero1);
            JOptionPane.showMessageDialog(null, "A potêncialização de "+numero2+ " por "+numero1 +" é: "+potencia);
        }
    }
}