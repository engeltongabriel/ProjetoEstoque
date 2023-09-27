package estoque.projeto.fatec.elton.model;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void entradaEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
            System.out.println("Entrada de " + quantidade + " unidades do produto: " + nome);
        } else {
            System.out.println("Quantidade inválida para entrada em estoque.");
        }
    }

    public void saidaEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            System.out.println("Saída de " + quantidade + " unidades do produto: " + nome);
        } else {
            System.out.println("Quantidade inválida para saída em estoque.");
        }
    }

    public String emitirRelatorio() {
        return "Código: " + codigo + "\nNome: " + nome + "\nQuantidade em Estoque: " + quantidade + "\nPreço Unitário: R$" + preco;
    }
}
