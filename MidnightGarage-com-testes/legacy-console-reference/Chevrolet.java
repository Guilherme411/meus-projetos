package MidnightGarage;

import java.util.Scanner;

public class Chevrolet {

    public void iniciar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("========= CHEVROLET ========");
        System.out.println("|1 - Onix                  |");
        System.out.println("|2 - Camaro                |");
        System.out.println("|3 - Cruze                 |");
        System.out.println("|4 - Tracker               |");
        System.out.println("|5 - S10                   |");
        System.out.println("|6 - Montana               |");
        System.out.println("|7 - Spin                  |");
        System.out.println("|8 - Equinox               |");
        System.out.println("|9 - Blazer                |");
        System.out.println("|10 - Cobalt               |");
        System.out.println("|11 - Astra                |");
        System.out.println("|0 - Voltar ao menu        |");
        System.out.println("|==========================|");
        System.out.print("| Escolha uma opçao: ");

        int carro = entrada.nextInt();

        switch (carro) {

            case 1:
                Carro onix = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Onix",
                        "Branco",
                        "R$ 95.000");
                onix.exibirDescricao();
                Compra compra1 = new Compra(onix);
                compra1.iniciar();
                break;

            case 2:
                Carro camaro = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Camaro",
                        "Amarelo",
                        "R$ 540.000");
                camaro.exibirDescricao();
                Compra compra2 = new Compra(camaro);
                compra2.iniciar();
                break;

            case 3:
                Carro cruze = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Cruze",
                        "Preto",
                        "R$ 145.000");      
                cruze.exibirDescricao();
                Compra compra3 = new Compra(cruze);
                compra3.iniciar();
                break;

            case 4:
                Carro tracker = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Tracker",
                        "Cinza",
                        "R$ 175.000");
                tracker.exibirDescricao();
                Compra compra4 = new Compra(tracker);
                compra4.iniciar();
                break;

            case 5:
                Carro s10 = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "S10",
                        "Branco",
                        "R$ 295.000");
                s10.exibirDescricao();
                Compra compra5 = new Compra(s10);
                compra5.iniciar();
                break;

            case 6:
                Carro montana = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Montana",
                        "Vermelho",
                        "R$ 145.000");
                montana.exibirDescricao();
                Compra compra6 = new Compra(montana);
                compra6.iniciar();
                break;

            case 7:
                Carro spin = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Spin",
                        "Prata",
                        "R$ 135.000");
                spin.exibirDescricao();
                Compra compra7 = new Compra(spin);
                compra7.iniciar();
                break;

            case 8:
                Carro equinox = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Equinox",
                        "Azul",
                        "R$ 275.000");
                equinox.exibirDescricao();
                Compra compra8 = new Compra(equinox);
                compra8.iniciar();
                break;

            case 9:
                Carro blazer = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Blazer",
                        "Preto",
                        "R$ 395.000");
                blazer.exibirDescricao();
                Compra compra9 = new Compra(blazer);
                compra9.iniciar();
                break;

            case 10:
                Carro cobalt = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Cobalt",
                        "Cinza",
                        "R$ 82.000");
                cobalt.exibirDescricao();
                Compra compra10 = new Compra(cobalt);
                compra10.iniciar();
                break;

            case 11:
                Carro astra = FabricaCarros.criarCarro(
                        "Chevrolet",
                        "Astra",
                        "Prata",
                        "R$ 68.000");
                astra.exibirDescricao();
                Compra compra11 = new Compra(astra);
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