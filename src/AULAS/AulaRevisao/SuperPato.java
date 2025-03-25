package AULAS.AulaRevisao;

public class SuperPato extends Pato{
    float poder;

    public SuperPato(){
    }

    public SuperPato(String nome, int ano, float poder){
        super(nome, ano);
        this.poder = poder;
    }

    public String voa() {
        return nome+" voa como um jato de poder "+poder;
    }

    public String nada() {
        return nome+" nada como um submarino de poder "+poder;
    }

    public String quack() {
        return "["+nome+"]: QUACK!!";
    }
}
