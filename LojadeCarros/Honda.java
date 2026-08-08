package LojadeCarros;

import java.util.Scanner;

public class Honda {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=========== HONDA ==========");
        System.out.println("|1 - Civic                 |");
        System.out.println("|2 - NSX                   |");
        System.out.println("|3 - City                  |");
        System.out.println("|4 - HR-V                  |");
        System.out.println("|5 - WR-V                  |");
        System.out.println("|6 - Fit                   |");
        System.out.println("|7 - Accord                |");
        System.out.println("|8 - CR-V                  |");
        System.out.println("|9 - Pilot                 |");
        System.out.println("|10 - ZR-V                 |");
        System.out.println("|11 - Civic Type R         |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");

        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro civic = FabricaCarros.criarCarro(
                        "Honda",
                        "Civic",
                        "Prata",
                        "R$ 150.000");

                civic.exibirDescricao();

                Compra compra1 = new Compra(civic);
                compra1.iniciar();
                break;

            case 2:
                Carro nsx = FabricaCarros.criarCarro(
                        "Honda",
                        "NSX",
                        "Vermelho",
                        "R$ 800.000");     
                nsx.exibirDescricao();
                Compra compra2 = new Compra(nsx);
                compra2.iniciar();
                break;

            case 3:
                Carro city = FabricaCarros.criarCarro(
                        "Honda",
                        "City",
                        "Branco",
                        "R$ 120.000");
                city.exibirDescricao();
                Compra compra3 = new Compra(city);
                compra3.iniciar();
                break;

            case 4:
                Carro hrv = FabricaCarros.criarCarro(
                        "Honda",
                        "HR-V",
                        "Cinza",
                        "R$ 165.000");
                hrv.exibirDescricao();
                Compra compra4 = new Compra(hrv);
                compra4.iniciar();
                break;

            case 5:
                Carro wrv = FabricaCarros.criarCarro(
                        "Honda",
                        "WR-V",
                        "Azul",
                        "R$ 135.000");
                wrv.exibirDescricao();
                Compra compra5 = new Compra(wrv);
                compra5.iniciar();
                break;

            case 6:
                Carro fit = FabricaCarros.criarCarro(
                        "Honda",
                        "Fit",
                        "Preto",
                        "R$ 95.000");
                fit.exibirDescricao();
                Compra compra6 = new Compra(fit);
                compra6.iniciar();
                break;

            case 7:
                Carro accord = FabricaCarros.criarCarro(
                        "Honda",
                        "Accord",
                        "Preto",
                        "R$ 320.000");
                accord.exibirDescricao();
                Compra compra7 = new Compra(accord);
                compra7.iniciar();
                break;

            case 8:
                Carro crv = FabricaCarros.criarCarro(
                        "Honda",
                        "CR-V",
                        "Branco Pérola",
                        "R$ 280.000");
                crv.exibirDescricao();
                Compra compra8 = new Compra(crv);
                compra8.iniciar();
                break;

            case 9:
                Carro pilot = FabricaCarros.criarCarro(
                        "Honda",
                        "Pilot",
                        "Cinza Grafite",
                        "R$ 410.000");
                pilot.exibirDescricao();
                Compra compra9 = new Compra(pilot);
                compra9.iniciar();
                break;

            case 10:
                Carro zrv = FabricaCarros.criarCarro(
                        "Honda",
                        "ZR-V",
                        "Azul Metálico",
                        "R$ 215.000");
                zrv.exibirDescricao();
                Compra compra10 = new Compra(zrv);
                compra10.iniciar();
                break;

            case 11:
                Carro typer = FabricaCarros.criarCarro(
                        "Honda",
                        "Civic Type R",
                        "Championship White",
                        "R$ 430.000");
                typer.exibirDescricao();
                Compra compra11 = new Compra(typer);
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