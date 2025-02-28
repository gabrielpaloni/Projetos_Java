package AULAS.Aula03;
import javax.swing.JOptionPane;

public class MediaAritimetica {
    public static void main(String[] args) {
        String nome;
        double nota1, nota2, media = 0;

        for(int i = 0; i < 3; i++){
            nome = JOptionPane.showInputDialog("Escreva o nome do aluno");
            nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota"));
            nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota"));

            media = (nota1 + nota2) / 2;

            JOptionPane.showMessageDialog(null, "A média do(a) "+nome+" é: "+media);
        }
    }
}
