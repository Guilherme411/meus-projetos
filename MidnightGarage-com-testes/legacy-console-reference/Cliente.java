package MidnightGarage;

public class Cliente implements Observador {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Carro carro) {

        System.out.println();
        System.out.println("===== NOVO ANÚNCIO =====");
        System.out.println(nome + " recebeu o novo anúncio na loja!");
        System.out.println("Nome: " + carro.getNome());
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Preço: " + carro.getPreco());
        System.out.println("=========================");

    }

}