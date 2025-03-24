package AULAS.Aula08_p2;

import java.util.InputMismatchException;

public class PessoaFisica extends Pessoa implements Validacao{
    private String rg;
    private String cpf;
    private int idade;

    public PessoaFisica(){
    }
    public PessoaFisica(String nome, String endereco, String rg, String cpf, int idade){
        super (nome, endereco);
        this.rg = rg;
        this.idade = idade;

        if(validaCPF(cpf))
            this.cpf = cpf;
        else
            System.out.println("CPF inválido.");
    }

    public PessoaFisica(String nome, String endereco){
        super(nome, endereco);
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getRg() {
        return rg;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        if(validaCPF(cpf))
            this.cpf = cpf;
        else
            System.out.println("CPF inválido.");

    }
    public String getCpf() {
        return cpf;
    }

    public String toString(){
        return super.toString()+
                "RG: "+rg+"\n"+
                "CPF: "+cpf+"\n"+
                "Idade: "+idade+" anos."+"\n";
    }

    public boolean validaCPF(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222")
                || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") ||
                CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() !=
                11))
            return (false);
        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}

