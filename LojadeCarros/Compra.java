package LojadeCarros;

import java.util.Scanner;

public class Compra {

    private Carro carro;

    public Compra(Carro carro) {
        this.carro = carro;
    }

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("Deseja comprar este veículo?");
        System.out.println("[ SIM ]");
        System.out.println("[ NÃO ]");
        System.out.println();
        System.out.println("escolha uma opçao: ");

        String resposta = entrada.nextLine();

       switch (resposta.toLowerCase()) {

    case "s":
    case "sim":
        InserirDados inserirDados = new InserirDados();
        inserirDados.iniciar(carro);
        break;

    case "n":
    case "nao":
    case "não":
        Disponiveis menu = new Disponiveis();
        menu.iniciar();
        break;

    default:
        System.out.println("Resposta inválida! Digite apenas 'sim' ou 'não'.");
        iniciar();

        }
    }
}
