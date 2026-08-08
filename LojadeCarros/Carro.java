package LojadeCarros;

public class Carro {
    private String nome;
    private String cor;
    private String preco;

    public Carro(String nome,
                 String cor,
                 String preco) {

        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getPreco() {
        return preco;
    }

    public void exibirDescricao() {

        System.out.println();
        System.out.println("======== VEÍCULO ========");
        System.out.println("Nome: " + nome);
        System.out.println("Cor: " + cor);
        System.out.println("Preço: " + preco);
        System.out.println("=========================");
    }
}
