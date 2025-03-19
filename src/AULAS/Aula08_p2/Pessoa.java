package AULAS.Aula08_p2;

public class Pessoa {
    protected String nome;
    protected String endereco;

    public Pessoa() {
    }
    public Pessoa(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }

    public String toString(){
        return "Nome: "+nome+"\n" +
                "Endereço: "+endereco+"\n";
    }
}
