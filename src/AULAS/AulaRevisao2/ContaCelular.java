package AULAS.AulaRevisao2;

public class ContaCelular extends ContaTelefone {
    public ContaCelular(){
    }
    public ContaCelular(String numero, int minutos){
        super(numero, minutos);
    }

    public double getValor(){
        if (getTotalMinutos() <= 60)
            return getTotalMinutos() * 1.2;
        else
            return getTotalMinutos() * 1.4;
    }
}
