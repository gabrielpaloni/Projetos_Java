package AULAS.Aula13;

public class Vendedor {
    private int codigo;
    private String nome;
    private Endereco endereco;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) throws Exception {
        if (codigo <= 0)
            throw new Exception("Código inválido" + codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws Exception {
        if (nome.isEmpty())
            throw new Exception("Digite o nome!");
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toString(){
        return "Código: "+codigo+ "\nNome: "+nome+ "\nEndereço: "+endereco+"\n";
    }
}
