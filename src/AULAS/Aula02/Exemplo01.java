package AULAS.Aula02;
import java.util.Scanner;

public class Exemplo01 {
    public static void main(String[] args) {
        String nome;
        int idade;
        double altura;
        char sexo;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        nome = entrada.nextLine();
        System.out.print("Digite a idade: ");
        idade = entrada.nextInt();
        System.out.print("Digite sua altura: ");
        altura = entrada.nextDouble();
        System.out.print("Digite seu sexo: ");
        sexo = entrada.next().charAt(0);

        System.out.println("Nome: "+nome);
        System.out.println("Altura: "+altura);
        System.out.println("Idade: "+idade);
        System.out.println("Sexo: "+sexo);
    }
}
