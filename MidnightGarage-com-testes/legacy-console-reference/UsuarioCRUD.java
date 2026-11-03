package MidnightGarage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCRUD {
    private static final String ARQUIVO = "usuarios.txt";
    private final GerenciadorLogs logs;

    public UsuarioCRUD(GerenciadorLogs logs) { this.logs = logs; }

    public boolean cadastrar(String nome, String email, String senha, String perfil) {
        if (nome.trim().isEmpty() || email.trim().isEmpty() || senha.trim().isEmpty() || perfil.trim().isEmpty()) {
            System.out.println("Todos os campos são obrigatórios.");
            return false;
        }
        for (Usuario u : listar()) {
            if (u.getEmail().equalsIgnoreCase(email.trim())) {
                System.out.println("Já existe um usuário com esse e-mail.");
                return false;
            }
        }
        Usuario usuario = new Usuario(proximoId(), nome.trim(), email.trim(), senha, perfil.trim().toUpperCase());
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            escritor.write(usuario.paraArquivo());
            escritor.newLine();
            logs.registrar("CREATE", usuario.getNome(), "Usuário cadastrado (ID " + usuario.getId() + ")");
            System.out.println("Usuário cadastrado com sucesso. ID: " + usuario.getId());
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) return usuarios;
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";", -1);
                if (dados.length == 5) {
                    try { usuarios.add(new Usuario(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4])); }
                    catch (NumberFormatException ignorado) { /* ignora linha inválida */ }
                }
            }
        } catch (IOException e) { System.out.println("Erro ao listar usuários: " + e.getMessage()); }
        return usuarios;
    }

    public boolean atualizar(int id, String nome, String email, String senha, String perfil) {
        List<Usuario> usuarios = listar();
        Usuario alvo = null;
        for (Usuario u : usuarios) if (u.getId() == id) alvo = u;
        if (alvo == null) { System.out.println("Usuário não encontrado."); return false; }
        for (Usuario u : usuarios) {
            if (u.getId() != id && u.getEmail().equalsIgnoreCase(email.trim())) {
                System.out.println("Outro usuário já utiliza esse e-mail."); return false;
            }
        }
        alvo.setNome(nome.trim()); alvo.setEmail(email.trim()); alvo.setSenha(senha); alvo.setPerfil(perfil.trim().toUpperCase());
        if (salvarTodos(usuarios)) {
            logs.registrar("UPDATE", alvo.getNome(), "Usuário atualizado (ID " + id + ")");
            System.out.println("Usuário atualizado com sucesso."); return true;
        }
        return false;
    }

    public boolean excluir(int id) {
        List<Usuario> usuarios = listar();
        Usuario removido = null;
        for (Usuario u : usuarios) if (u.getId() == id) { removido = u; break; }
        if (removido == null) { System.out.println("Usuário não encontrado."); return false; }
        usuarios.remove(removido);
        if (salvarTodos(usuarios)) {
            logs.registrar("DELETE", removido.getNome(), "Usuário excluído (ID " + id + ")");
            System.out.println("Usuário excluído com sucesso."); return true;
        }
        return false;
    }

    private int proximoId() {
        int maior = 0;
        for (Usuario u : listar()) if (u.getId() > maior) maior = u.getId();
        return maior + 1;
    }

    private boolean salvarTodos(List<Usuario> usuarios) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Usuario u : usuarios) { escritor.write(u.paraArquivo()); escritor.newLine(); }
            return true;
        } catch (IOException e) { System.out.println("Erro ao salvar arquivo: " + e.getMessage()); return false; }
    }
}
