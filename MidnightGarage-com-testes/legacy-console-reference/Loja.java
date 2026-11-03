package MidnightGarage;

import java.util.List;
import java.util.Scanner;

public class Loja {
    private final Scanner entrada = new Scanner(System.in);
    private final GerenciadorLogs logs = new GerenciadorLogs();
    private final UsuarioCRUD usuarios = new UsuarioCRUD(logs);
    private final LojaFacade facade = new LojaFacade();

    public void iniciar() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n========== MIDNIGHT GARAGE ==========");
            System.out.println("1 - Menu de vendas");
            System.out.println("2 - Anunciar carro");
            System.out.println("3 - Gerenciar usuários (CRUD)");
            System.out.println("4 - Visualizar logs do sistema");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = entrada.nextLine().trim();
            switch (opcao) {
                case "1": facade.abrirMenuVendas(); break;
                case "2": facade.anunciarCarro(); break;
                case "3": menuUsuarios(); break;
                case "4": logs.listarLogs(); pausar(); break;
                case "0": logs.registrar("EXIT", "Sistema", "Aplicação encerrada"); System.out.println("Saindo da Midnight Garage!"); executando = false; break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void menuUsuarios() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n========== GERENCIAR USUÁRIOS ==========");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Editar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            String opcao = entrada.nextLine().trim();
            switch (opcao) {
                case "1": cadastrarUsuario(); break;
                case "2": listarUsuarios(); pausar(); break;
                case "3": editarUsuario(); break;
                case "4": excluirUsuario(); break;
                case "0": voltar = true; break;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarUsuario() {
        System.out.println("\n--- Cadastro de usuário ---");
        System.out.print("Nome: "); String nome = entrada.nextLine();
        System.out.print("E-mail: "); String email = entrada.nextLine();
        System.out.print("Senha (apenas demonstração): "); String senha = entrada.nextLine();
        System.out.print("Perfil (ADMIN ou CLIENTE): "); String perfil = entrada.nextLine();
        usuarios.cadastrar(nome, email, senha, perfil);
    }

    private void listarUsuarios() {
        List<Usuario> lista = usuarios.listar();
        System.out.println("\n--- Usuários cadastrados ---");
        if (lista.isEmpty()) { System.out.println("Nenhum usuário cadastrado."); return; }
        for (Usuario u : lista) System.out.println(u);
    }

    private void editarUsuario() {
        listarUsuarios();
        System.out.print("ID do usuário que deseja editar: "); int id = lerInteiro();
        System.out.print("Novo nome: "); String nome = entrada.nextLine();
        System.out.print("Novo e-mail: "); String email = entrada.nextLine();
        System.out.print("Nova senha: "); String senha = entrada.nextLine();
        System.out.print("Novo perfil (ADMIN ou CLIENTE): "); String perfil = entrada.nextLine();
        usuarios.atualizar(id, nome, email, senha, perfil);
    }

    private void excluirUsuario() {
        listarUsuarios();
        System.out.print("ID do usuário que deseja excluir: ");
        usuarios.excluir(lerInteiro());
    }

    private int lerInteiro() {
        while (true) {
            String valor = entrada.nextLine().trim();
            try { return Integer.parseInt(valor); }
            catch (NumberFormatException e) { System.out.print("Digite um número válido: "); }
        }
    }

    private void pausar() { System.out.println("Pressione ENTER para continuar..."); entrada.nextLine(); }
}
