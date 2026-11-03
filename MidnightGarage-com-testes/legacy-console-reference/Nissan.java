package MidnightGarage;

import java.util.Scanner;

public class Nissan {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("========== NISSAN ==========");
        System.out.println("|1 - Versa                 |");
        System.out.println("|2 - Sentra                |");
        System.out.println("|3 - Kicks                 |");
        System.out.println("|4 - Frontier              |");
        System.out.println("|5 - GT-R R35              |");
        System.out.println("|6 - 350Z                  |");
        System.out.println("|7 - 370Z                  |");
        System.out.println("|8 - Skyline GT-R R34      |");
        System.out.println("|9 - X-Trail               |");
        System.out.println("|10 - March                |");
        System.out.println("|11 - Altima               |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");

        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro versa = FabricaCarros.criarCarro(
                        "Nissan",
                        "Versa",
                        "Branco",
                        "R$ 118.000");
                versa.exibirDescricao();
                Compra compra1 = new Compra(versa);
                compra1.iniciar();
                break;

            case 2:
                Carro sentra = FabricaCarros.criarCarro(
                        "Nissan",
                        "Sentra",
                        "Cinza",
                        "R$ 178.000");
                sentra.exibirDescricao();
                Compra compra2 = new Compra(sentra);
                compra2.iniciar();
                break;

            case 3:
                Carro kicks = FabricaCarros.criarCarro(
                        "Nissan",
                        "Kicks",
                        "Vermelho",
                        "R$ 165.000");
                kicks.exibirDescricao();
                Compra compra3 = new Compra(kicks);
                compra3.iniciar();
                break;

            case 4:
                Carro frontier = FabricaCarros.criarCarro(
                        "Nissan",
                        "Frontier",
                        "Preto",
                        "R$ 315.000");
                frontier.exibirDescricao();
                Compra compra4 = new Compra(frontier);
                compra4.iniciar();
                break;

            case 5:
                Carro gtr = FabricaCarros.criarCarro(
                        "Nissan",
                        "GT-R R35",
                        "Cinza",
                        "R$ 1.200.000");
                gtr.exibirDescricao();
                Compra compra5 = new Compra(gtr);
                compra5.iniciar();
                break;

            case 6:
                Carro z350 = FabricaCarros.criarCarro(
                        "Nissan",
                        "350Z",
                        "Laranja",
                        "R$ 240.000");
                z350.exibirDescricao();
                Compra compra6 = new Compra(z350);
                compra6.iniciar();
                break;

            case 7:
                Carro z370 = FabricaCarros.criarCarro(
                        "Nissan",
                        "370Z",
                        "Branco",
                        "R$ 310.000");
                z370.exibirDescricao();
                Compra compra7 = new Compra(z370);
                compra7.iniciar();
                break;

            case 8:
                Carro skyline = FabricaCarros.criarCarro(
                        "Nissan",
                        "Skyline GT-R R34",
                        "Azul Bayside",
                        "R$ 2.000.000");
                skyline.exibirDescricao();
                Compra compra8 = new Compra(skyline);
                compra8.iniciar();
                break;

            case 9:
                Carro xtrail = FabricaCarros.criarCarro(
                        "Nissan",
                        "X-Trail",
                        "Prata",
                        "R$ 210.000");
                xtrail.exibirDescricao();
                Compra compra9 = new Compra(xtrail);
                compra9.iniciar();
                break;

            case 10:
                Carro march = FabricaCarros.criarCarro(
                        "Nissan",
                        "March",
                        "Vermelho",
                        "R$ 72.000");
                march.exibirDescricao();
                Compra compra10 = new Compra(march);
                compra10.iniciar();
                break;

            case 11:
                Carro altima = FabricaCarros.criarCarro(
                        "Nissan",
                        "Altima",
                        "Preto",
                        "R$ 220.000");
                altima.exibirDescricao();
                Compra compra11 = new Compra(altima);
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