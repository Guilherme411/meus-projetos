package LojadeCarros;

import java.util.Scanner;

public class Toyota {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("========== TOYOTA ==========");
        System.out.println("|1 - Corolla               |");
        System.out.println("|2 - Supra                 |");
        System.out.println("|3 - Hilux                 |");
        System.out.println("|4 - SW4                   |");
        System.out.println("|5 - Yaris                 |");
        System.out.println("|6 - Corolla Cross         |");
        System.out.println("|7 - Camry                 |");
        System.out.println("|8 - RAV4                  |");
        System.out.println("|9 - Etios                 |");
        System.out.println("|10 - GR86                 |");
        System.out.println("|11 - Land Cruiser         |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");

        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro corolla = FabricaCarros.criarCarro(
                        "Toyota",
                        "Corolla",
                        "Prata",
                        "R$ 165.000");
                corolla.exibirDescricao();
                Compra compra1 = new Compra(corolla);
                compra1.iniciar();
                break;

            case 2:
                Carro supra = FabricaCarros.criarCarro(
                        "Toyota",
                        "Supra",
                        "Amarelo",
                        "R$ 620.000");
                supra.exibirDescricao();
                Compra compra2 = new Compra(supra);
                compra2.iniciar();
                break;

            case 3:
                Carro hilux = FabricaCarros.criarCarro(
                        "Toyota",
                        "Hilux",
                        "Branco",
                        "R$ 310.000");
                hilux.exibirDescricao();
                Compra compra3 = new Compra(hilux);
                compra3.iniciar();
                break;

            case 4:
                Carro sw4 = FabricaCarros.criarCarro(
                        "Toyota",
                        "SW4",
                        "Preto",
                        "R$ 430.000");
                sw4.exibirDescricao();
                Compra compra4 = new Compra(sw4);
                compra4.iniciar();
                break;

            case 5:
                Carro yaris = FabricaCarros.criarCarro(
                        "Toyota",
                        "Yaris",
                        "Vermelho",
                        "R$ 118.000");
                yaris.exibirDescricao();
                Compra compra5 = new Compra(yaris);
                compra5.iniciar();
                break;

            case 6:
                Carro corollaCross = FabricaCarros.criarCarro(
                        "Toyota",
                        "Corolla Cross",
                        "Cinza",
                        "R$ 205.000");
                corollaCross.exibirDescricao();
                Compra compra6 = new Compra(corollaCross);
                compra6.iniciar();
                break;

            case 7:
                Carro camry = FabricaCarros.criarCarro(
                        "Toyota",
                        "Camry",
                        "Branco Pérola",
                        "R$ 360.000");
                camry.exibirDescricao();
                Compra compra7 = new Compra(camry);
                compra7.iniciar();
                break;

            case 8:
                Carro rav4 = FabricaCarros.criarCarro(
                        "Toyota",
                        "RAV4",
                        "Azul",
                        "R$ 405.000");
                rav4.exibirDescricao();
                Compra compra8 = new Compra(rav4);
                compra8.iniciar();
                break;

            case 9:
                Carro etios = FabricaCarros.criarCarro(
                        "Toyota",
                        "Etios",
                        "Prata",
                        "R$ 85.000");
                etios.exibirDescricao();
                Compra compra9 = new Compra(etios);
                compra9.iniciar();
                break;

            case 10:
                Carro gr86 = FabricaCarros.criarCarro(
                        "Toyota",
                        "GR86",
                        "Laranja",
                        "R$ 320.000");
                gr86.exibirDescricao();
                Compra compra10 = new Compra(gr86);
                compra10.iniciar();
                break;

            case 11:
                Carro landCruiser = FabricaCarros.criarCarro(
                        "Toyota",
                        "Land Cruiser",
                        "Preto",
                        "R$ 720.000");
                landCruiser.exibirDescricao();
                Compra compra11 = new Compra(landCruiser);
                compra11.iniciar();
                break;

            case 0:
                Disponiveis menu = new Disponiveis();
                menu.iniciar();
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}