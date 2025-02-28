package AULAS.Aula02;
import javax.swing.JOptionPane;

public class PermDirigir {
    public static void main(String[] args) {
        int idade;

        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade."));
        if (idade < 16)
            JOptionPane.showMessageDialog(null,"Não pode votar e nem dirigir.");
        else if (idade >= 16 && idade < 18)
            JOptionPane.showMessageDialog(null,"Pode votar mas não pode dirigir.");
        else
            JOptionPane.showMessageDialog(null,"Pode votar e dirigir.");
    }
}
