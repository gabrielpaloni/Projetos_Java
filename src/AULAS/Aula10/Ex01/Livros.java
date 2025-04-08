package AULAS.Aula10.Ex01;

public class Livros extends Produto {
    String autor;

    public Livros (){
    }
    public Livros (String nome, double preco, String autor){
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String toString(){
        return super.toString()+
                "Autor: "+autor;
    }
}
