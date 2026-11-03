package MidnightGarage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerenciadorLogs {
    private static final String ARQUIVO = "logs.txt";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void registrar(String acao, String responsavel, String descricao) {
        String linha = LocalDateTime.now().format(FORMATO) + ";" + acao + ";" +
                limpar(responsavel) + ";" + limpar(descricao);
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            escritor.write(linha);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o log: " + e.getMessage());
        }
    }

    public void listarLogs() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum log registrado ainda.");
            return;
        }
        System.out.println("\n========== HISTÓRICO DE LOGS ==========");
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler logs: " + e.getMessage());
        }
        System.out.println("=======================================\n");
    }

    private String limpar(String valor) {
        return valor == null ? "" : valor.replace(";", ",").replace("\n", " ").replace("\r", " ");
    }
}
