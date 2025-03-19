package AULAS.Aula08_p2;

public class PessoaJuridica extends Pessoa {
    private String ie;
    private String cnpj;

    public PessoaJuridica(){
    }
    public PessoaJuridica(String nome, String endereco, String ie, String cnpj){
        super(nome, endereco);
        this.ie = ie;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }
    public void setIe(String ie) {
        this.ie = ie;
    }

    public String toString(){
        return super.toString()+
                "IE: "+ie+"\n"+
                "CNPJ: "+cnpj+"\n";
    }
}
