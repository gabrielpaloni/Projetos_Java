package AULAS.AulaRevisao;

public class Pato {
    String nome;
    int ano;

    public Pato(){
    }
    public Pato(String nome, int ano){
        this.nome = nome;
        this.ano = ano;
    }


    public String voa(){
        return "O pato "+nome+" voa";
    }

    public String nada(){
        return "O pato "+nome+" nada";
    }

    public String quack(){
        return "["+nome+"]: quack!!";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString(){
        return  nome+" nasceu em "+ano+"."+"\n"+
                voa()+"\n"+
                nada()+"\n"+
                quack();
    }
}
