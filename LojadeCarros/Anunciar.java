package LojadeCarros;

import java.util.Scanner;

public class Anunciar {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=== ANUNCIAR CARRO ===");
        
        System.out.print("Digite o nome do carro: ");
        String nome = entrada.nextLine();

        System.out.print("Digite a cor do carro: ");
        String cor = entrada.nextLine();

        System.out.print("Digite o preço do carro: ");
        String preco = entrada.nextLine();

        System.out.println("======================");

        System.out.print("\nCarregando ");

        try {
            for (int i = 0; i <= 10; i++) {
                System.out.print("█");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 100%");
    
       Carro carro = new Carro(nome, cor, preco);
        System.out.println();
        System.out.println("Cadastro feito com sucesso, veja abaixo!");
        carro.exibirDescricao();
        CentralAnuncios central = new CentralAnuncios();
        central.notificarObservadores(carro);

    }
}