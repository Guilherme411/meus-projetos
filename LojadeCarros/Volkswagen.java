package LojadeCarros;

import java.util.Scanner;

public class Volkswagen {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("======== VOLKSWAGEN ========");
        System.out.println("|1 - Gol                   |");
        System.out.println("|2 - Polo                  |");
        System.out.println("|3 - Jetta                 |");
        System.out.println("|4 - Golf GTI              |");
        System.out.println("|5 - Saveiro               |");
        System.out.println("|6 - Amarok                |");
        System.out.println("|7 - Virtus                |");
        System.out.println("|8 - Nivus                 |");
        System.out.println("|9 - T-Cross               |");
        System.out.println("|10 - Passat               |");
        System.out.println("|11 - Fusca                |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");

        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro gol = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Gol",
                        "Branco",
                        "R$ 82.000");
                gol.exibirDescricao();
                Compra compra1 = new Compra(gol);
                compra1.iniciar();
                break;

            case 2:
                Carro polo = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Polo",
                        "Prata",
                        "R$ 110.000");
                polo.exibirDescricao();
                Compra compra2 = new Compra(polo);
                compra2.iniciar();
                break;

            case 3:
                Carro jetta = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Jetta",
                        "Preto",
                        "R$ 235.000");
                jetta.exibirDescricao();
                Compra compra3 = new Compra(jetta);
                compra3.iniciar();
                break;

            case 4:
                Carro golf = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Golf GTI",
                        "Vermelho",
                        "R$ 340.000");
                golf.exibirDescricao();
                Compra compra4 = new Compra(golf);
                compra4.iniciar();
                break;

            case 5:
                Carro saveiro = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Saveiro",
                        "Branco",
                        "R$ 120.000");
                saveiro.exibirDescricao();
                Compra compra5 = new Compra(saveiro);
                compra5.iniciar();
                break;

            case 6:
                Carro amarok = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Amarok",
                        "Cinza",
                        "R$ 325.000");
                amarok.exibirDescricao();
                Compra compra6 = new Compra(amarok);
                compra6.iniciar();
                break;

            case 7:
                Carro virtus = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Virtus",
                        "Azul",
                        "R$ 125.000");
                virtus.exibirDescricao();
                Compra compra7 = new Compra(virtus);
                compra7.iniciar();
                break;

            case 8:
                Carro nivus = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Nivus",
                        "Cinza",
                        "R$ 155.000");
                nivus.exibirDescricao();
                Compra compra8 = new Compra(nivus);
                compra8.iniciar();
                break;

            case 9:
                Carro tcross = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "T-Cross",
                        "Preto",
                        "R$ 175.000");
                tcross.exibirDescricao();
                Compra compra9 = new Compra(tcross);
                compra9.iniciar();
                break;

            case 10:
                Carro passat = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Passat",
                        "Prata",
                        "R$ 185.000");
                passat.exibirDescricao();
                Compra compra10 = new Compra(passat);
                compra10.iniciar();
                break;

            case 11:
                Carro fusca = FabricaCarros.criarCarro(
                        "Volkswagen",
                        "Fusca",
                        "Azul",
                        "R$ 70.000");
                fusca.exibirDescricao();
                Compra compra11 = new Compra(fusca);
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