package AULAS.Aula02;
import javax.swing.JOptionPane;

public class Exemplo02 {
    public static void main(String[] args) {
        String nome;
        int idade;
        double altura;
        char sexo;

        nome = JOptionPane.showInputDialog("Digite o nome: ");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura: "));
        sexo = JOptionPane.showInputDialog("Digite o sexo").charAt(0);

        JOptionPane.showMessageDialog(null, "Nome: "+ nome +"\nIdade: " + idade + "\nAltura: "+altura +"\nSexo: "+sexo);
    }
}
