package AULAS.Aula13;
import javax.swing.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class TesteVendedor {
    public static void main(String[] args) {
        Endereco endereco;
        List<Vendedor> sellers = new ArrayList<Vendedor>();
        try{
            int codigo, numero;
            String nome, rua, bairro, cidade;

            while(true){
                Vendedor vendedor = new Vendedor();
                endereco = new Endereco();
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor: Digite 0 para encerrar"));
                if (codigo == 0)
                    break;
                vendedor.setCodigo(codigo);
                nome = JOptionPane.showInputDialog("Digite o nome");
                vendedor.setNome(nome);
                rua = JOptionPane.showInputDialog("Digite o nome da rua");
                endereco.setRua(rua);
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da rua"));
                endereco.setNumero(numero);
                bairro = JOptionPane.showInputDialog("Digite o bairro");
                endereco.setBairro(bairro);
                cidade = JOptionPane.showInputDialog("Digite a cidade");
                endereco.setCidade(cidade);
                vendedor.setEndereco(endereco);
                JOptionPane.showMessageDialog(null, vendedor);
                sellers.add(vendedor);
            }
        }  catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro. Digite um número");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+e.getMessage());
            e.printStackTrace();
        }
        String vend = "Vendedores cadastrados:\n";
        for(Vendedor v: sellers) {
            vend += v +"\n";
        }
        JOptionPane.showMessageDialog(null, vend);
    }
}
