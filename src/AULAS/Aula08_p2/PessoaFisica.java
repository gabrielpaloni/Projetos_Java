package AULAS.Aula08_p2;

public class PessoaFisica extends Pessoa {
    private String rg;
    private String cpf;
    private int idade;

    public PessoaFisica(){
    }
    public PessoaFisica(String nome, String endereco, String rg, String cpf, int idade){
        super (nome, endereco);
        this.rg = rg;
        this.cpf = cpf;
        this.idade = idade;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getRg() {
        return rg;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }

    public String toString(){
        return super.toString()+
                "RG: "+rg+"\n"+
                "CPF: "+cpf+"\n"+
                "Idade: "+idade+" anos."+"\n";
    }
}
