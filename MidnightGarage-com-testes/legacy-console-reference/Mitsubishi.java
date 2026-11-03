package MidnightGarage;

import java.util.Scanner;

public class Mitsubishi {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("======== MITSUBISHI ========");
        System.out.println("|1 - Lancer                |");
        System.out.println("|2 - Lancer Evolution X    |");
        System.out.println("|3 - Eclipse Cross         |");
        System.out.println("|4 - Pajero Sport          |");
        System.out.println("|5 - Triton                |");
        System.out.println("|6 - ASX                   |");
        System.out.println("|7 - Outlander             |");
        System.out.println("|8 - Pajero Full           |");
        System.out.println("|9 - Airtrek               |");
        System.out.println("|10 - Eclipse GSX          |");
        System.out.println("|11 - 3000GT               |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");
        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro lancer = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Lancer",
                        "Prata",
                        "R$ 95.000");
                lancer.exibirDescricao();
                Compra compra1 = new Compra(lancer);
                compra1.iniciar();
                break;

            case 2:
                Carro evolution = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Lancer Evolution X",
                        "Branco",
                        "R$ 420.000");
                evolution.exibirDescricao();
                Compra compra2 = new Compra(evolution);
                compra2.iniciar();
                break;

            case 3:
                Carro eclipse = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Eclipse Cross",
                        "Cinza",
                        "R$ 230.000");
                eclipse.exibirDescricao();
                Compra compra3 = new Compra(eclipse);
                compra3.iniciar();
                break;

            case 4:
                Carro pajeroSport = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Pajero Sport",
                        "Preto",
                        "R$ 395.000");
                pajeroSport.exibirDescricao();
                Compra compra4 = new Compra(pajeroSport);
                compra4.iniciar();
                break;

            case 5:
                Carro triton = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Triton",
                        "Branco",
                        "R$ 310.000");
                triton.exibirDescricao();
                Compra compra5 = new Compra(triton);
                compra5.iniciar();
                break;

            case 6:
                Carro asx = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "ASX",
                        "Vermelho",
                        "R$ 155.000");
                asx.exibirDescricao();
                Compra compra6 = new Compra(asx);
                compra6.iniciar();
                break;

            case 7:
                Carro outlander = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Outlander",
                        "Azul",
                        "R$ 250.000");
                outlander.exibirDescricao();
                Compra compra7 = new Compra(outlander);
                compra7.iniciar();
                break;

            case 8:
                Carro pajeroFull = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Pajero Full",
                        "Cinza",
                        "R$ 320.000");
                pajeroFull.exibirDescricao();
                Compra compra8 = new Compra(pajeroFull);
                compra8.iniciar();
                break;

            case 9:
                Carro airtrek = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Airtrek",
                        "Prata",
                        "R$ 220.000");
                airtrek.exibirDescricao();
                Compra compra9 = new Compra(airtrek);
                compra9.iniciar();
                break;

            case 10:
                Carro eclipseGSX = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "Eclipse GSX",
                        "Preto",
                        "R$ 260.000");
                eclipseGSX.exibirDescricao();
                Compra compra10 = new Compra(eclipseGSX);
                compra10.iniciar();
                break;

            case 11:
                Carro gt3000 = FabricaCarros.criarCarro(
                        "Mitsubishi",
                        "3000GT",
                        "Vermelho",
                        "R$ 380.000");
                gt3000.exibirDescricao();
                Compra compra11 = new Compra(gt3000);
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