package AULAS.AulaRevisao;

public class PatoBorracha extends Pato {
    String cor;

    public PatoBorracha(){
    }
    public PatoBorracha(String nome, int ano, String cor){
        super(nome, ano);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String voa() {
        return nome+" ["+cor+"] não voa.";
    }

    public String nada() {
        return nome+" ["+cor+"] boia.";
    }
}
