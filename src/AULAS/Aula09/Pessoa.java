package AULAS.Aula09;

import java.text.DecimalFormat;

public class Pessoa {
    private String nome;
    private String endereco;
    private int idade;
    private double altura;
    private double peso;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Pessoa(){
    }
    public Pessoa (String nome, String endereco, int idade, double altura, double peso ){
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String toString(){
        return "Nome: "+ nome + "\n" +
                "Endereço: "+ endereco + "\n"+
                "Idade: "+idade + "\n" +
                "Altura: "+altura+ "\n" +
                "Peso: "+peso+"Kg"+"\n"+
                "IMC: "+df.format(calculaImc());
    }

    public void fazAniversário(int idadeMaisUm){
        idade += 1;
    }
    public double calculaImc(){
       double imc = peso / (altura * altura);
       return imc;
    }

    DecimalFormat df = new DecimalFormat("##0.00");
}
