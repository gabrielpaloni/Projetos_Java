package AULAS.Aula07;

public class Vendedor {
    private int codigo;
    private String nome;
    private String endereco;
    private float totalVendas;
    private double comissao;

    public Vendedor(int codigo, String nome, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.totalVendas = 0;
        this.comissao = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getTotalVendas() {
        return totalVendas;
    }

    public double getComissao() {
        return comissao;
    }

    private void calcularComissao() {
        this.comissao = totalVendas * 0.10;
    }

    public void addVendas(float vendas) {
        if (vendas > 0) {
            totalVendas += vendas;
            calcularComissao();
        } else {
            System.out.println("Valor de vendas inválido.");
        }
    }
}
