package estoque.projeto.fatec.elton.app;

import estoque.projeto.fatec.elton.model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

class EstoqueGerenciar {

private ArrayList<Produto> produtos = new ArrayList<>();


    private Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço unitário do produto:");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(codigo, nome, preco);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void realizarEntrada() {
        System.out.println("Digite o código do produto para entrada:");
        int codigo = scanner.nextInt();
        System.out.println("Digite a quantidade de entrada:");
        int quantidade = scanner.nextInt();

        Produto produto = encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            produto.entradaEstoque(quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void realizarSaida() {
        System.out.println("Digite o código do produto para saída:");
        int codigo = scanner.nextInt();
        System.out.println("Digite a quantidade de saída:");
        int quantidade = scanner.nextInt();

        Produto produto = encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            produto.saidaEstoque(quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void consultarProduto() {
        System.out.println("Digite o código do produto para consulta:");
        int codigo = scanner.nextInt();

        Produto produto = encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            System.out.println(produto.emitirRelatorio());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void mostrarRelatorio() {
        System.out.println("Relatório de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto.emitirRelatorio());
            System.out.println("------------------------------");
        }
    }

    private Produto encontrarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EstoqueGerenciar estoque = new EstoqueGerenciar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Realizar entrada de mercadoria");
            System.out.println("3. Realizar saída de mercadoria");
            System.out.println("4. Consultar informações de um produto");
            System.out.println("5. Mostrar o relatório de todos os produtos");
            System.out.println("6. Sair do programa");
            System.out.println("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    estoque.cadastrarProduto();
                    break;
                case 2:
                    estoque.realizarEntrada();
                    break;
                case 3:
                    estoque.realizarSaida();
                    break;
                case 4:
                    estoque.consultarProduto();
                    break;
                case 5:
                    estoque.mostrarRelatorio();
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
