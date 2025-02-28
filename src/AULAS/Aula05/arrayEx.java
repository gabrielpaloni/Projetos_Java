package AULAS.Aula05;
import javax.swing.*;

public class arrayEx {
    public static void main(String[] args) {
        String mostrar1 = "Valores do vetor 1:\n";
        String mostrar2 = "Valores do vetor 2:\n";
        int vetor1 [] = new int[10];
        for (int i = 0; i < vetor1.length; i++) {
            vetor1[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o "+(i+1)+ "º número"));
            mostrar1 +=" ["+ vetor1[i] + "] ";
        }
        int vetor2 [] = new int[10];
        for (int i = 0; i < vetor2.length; i++){
            vetor2[i] = vetor1[i] * i;
            mostrar2 += " ["+ vetor2[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, mostrar1+"\n"+mostrar2);
    }
}
