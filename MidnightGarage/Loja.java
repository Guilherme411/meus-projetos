package MidnightGarage;

import java.util.Scanner;

public class Loja {


    public void iniciar() {


        Scanner entrada = new Scanner(System.in);

        System.out.println("=X=X= Midnight menu =X=X=");
        System.out.println("| 1 - menu de vendas    |");
        System.out.println("| 2 - anunciar carro    |");
        System.out.println("| 0 - sair              |");
        System.out.println("=x==========x==========x=");
        System.out.print("| Escolha uma opcao: ");
        int opcao = entrada.nextInt();

        LojaFacade facade = new LojaFacade();

        switch(opcao){

        case 1:
            facade.abrirMenuVendas();
            break;

        case 2:
            facade.anunciarCarro();
            break;

        case 0:
            facade.sair();
            break;
        
        default:
            Loja menu = new Loja();
            menu.iniciar();
            break;
        }
    }
}
