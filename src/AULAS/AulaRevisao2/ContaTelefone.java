package AULAS.AulaRevisao2;

public class ContaTelefone {
    String numero;
    int minutos;

    public ContaTelefone(){
    }
    public ContaTelefone(String numero, int minutos){
        this.numero = numero;
        this.minutos = minutos;
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int setTotalMinutos(int minutos){
        this.minutos += minutos;
        return minutos;
    }
    public int getTotalMinutos(){
        return minutos;
    }

    public double getValor(){
        if (getTotalMinutos() <= 30)
            return getTotalMinutos() * 0.6;
        else
            return getTotalMinutos() * 0.8;
    }

    public String toString(){
        return "Número de telefone: "+numero+"\n"+
                "Minutos totais: "+getTotalMinutos()+"\n"+
                "Valor total: R$"+getValor();
    }
}
