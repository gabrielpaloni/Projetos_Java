package AULAS.Aula08.Ex01.Ex03;

public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(){
    }
    public Funcionario(int id, String nome, double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Id do funcionário: "+ id + "\n" +
                "Nome do funcionário: "+ nome + "\n"+
                "Salário do funcionário: R$"+salario;
    }
    public void aumentaSalarioPorcentagem(double umPorcento){
        salario = salario + (salario * umPorcento/100);
    }
    public void salarioAbstoluto(double umValor){
        salario += umValor;
    }
}
