package AULAS.AulaRevisao;

public class PatoMadeira extends Pato {

    public PatoMadeira(){
    }
    public PatoMadeira(String nome, int ano){
        super(nome, ano);
    }

    public String voa(){
        return nome+" não voa.";
    }
    public String nada(){
        return nome+" boia.";
    }
    public String quack(){
        return "["+nome+"]: ...";
    }
}
