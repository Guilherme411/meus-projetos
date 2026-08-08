package LojadeCarros;

import java.util.Scanner;

public class Disponiveis {


    public void iniciar() {


        Scanner entrada = new Scanner(System.in);

        System.out.println("x= Marcas disponíveis =x");
        System.out.println("|1 - Honda             |");
        System.out.println("|2 - Toyota            |");
        System.out.println("|3 - Chevrolet         |");
        System.out.println("|4 - Nissan            |");
        System.out.println("|5 - Mitsubishi        |");
        System.out.println("|6 - Volkswagen        |");
        System.out.println("|0 - Voltar ao menu    |");
        System.out.println("|======================|");
        System.out.print("Escolha uma opcao: ");
        int opcao = entrada.nextInt();

switch (opcao) {
    case 1:
        Honda honda = new Honda();
        honda.iniciar();
        break;

    case 2:
        Toyota toyota = new Toyota();
        toyota.iniciar();
        break;

    case 3:
        Chevrolet chevrolet = new Chevrolet();
        chevrolet.iniciar();
        break;

    case 4:
        Nissan nissan = new Nissan();
        nissan.iniciar();
        break;

    case 5:
        Mitsubishi mitsubishi = new Mitsubishi();
        mitsubishi.iniciar();
        break;

    case 6:
        Volkswagen volkswagen = new Volkswagen();
        volkswagen.iniciar();
        break;

    case 0:
        Loja menu = new Loja();
        menu.iniciar();
        break;

    default:
        System.out.println("Opção inválida!");
        Loja Loja = new Loja();
        Loja.iniciar();

        break;
}
    }
}
