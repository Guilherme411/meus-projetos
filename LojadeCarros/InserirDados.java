package LojadeCarros;

import java.util.Scanner;

public class InserirDados {

    public void iniciar(Carro carro) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("====== FICHA DE COMPRA ======");

        System.out.print("Digite seu nome completo: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("Digite sua data de nascimento: ");
        String dataNascimento = entrada.nextLine();

        System.out.print("Digite o método de pagamento: ");
        String metodoPagamento = entrada.nextLine();

        Comprador comprador = new Comprador(
                nome, cpf, dataNascimento, metodoPagamento);

        System.out.println();
        System.out.println("x==============================x");
        System.out.print("Carregando validação de dados... ");
        System.out.println();
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.print("█");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 100%");

        System.out.println();
        System.out.print("finalizando compra... ");
        System.out.println();
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.print("█");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 100%");

        System.out.println();
        System.out.println("==============================");
        System.out.println("|Validação feita com sucesso!|");
        System.out.println("|Compra concluída.           |");
        System.out.println("==============================");

        System.out.println();
        System.out.println("======= FICHA DE COMPRA =======");

        comprador.exibirDescricao();
        carro.exibirDescricao();

        boolean opcaoValida = false;

        while (!opcaoValida) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("| O que deseja fazer agora?        |");
            System.out.println("| voltar - Retornar ao menu        |");
            System.out.println("| sair    - Encerrar o sistema     |");
            System.out.println("====================================");
            System.out.print("Digite a opção: ");

            String opcao = entrada.nextLine().toLowerCase();

            switch (opcao) {

                case "voltar":
                    opcaoValida = true;
                    Loja loja = new Loja();
                    loja.iniciar();
                    break;

                case "sair":
                    opcaoValida = true;
                    System.out.println("Obrigado pela preferência!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
