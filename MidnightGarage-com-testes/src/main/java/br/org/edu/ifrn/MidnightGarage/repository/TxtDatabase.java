package br.org.edu.ifrn.MidnightGarage.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário compartilhado para persistência simples em TXT.
 * Cada campo é separado por tabulação e campos perigosos são codificados.
 */
@Component
public class TxtDatabase {
    private final Path dataDirectory;

    public TxtDatabase(@Value("${midnight-garage.data-dir:data}") String directory) {
        this.dataDirectory = Paths.get(directory);
        try {
            Files.createDirectories(dataDirectory);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível criar a pasta de dados.", e);
        }
    }

    public synchronized List<String> ler(String arquivo) {
        Path path = dataDirectory.resolve(arquivo);
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
                return new ArrayList<>();
            }
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao ler " + arquivo, e);
        }
    }

    public synchronized void gravar(String arquivo, List<String> linhas) {
        Path path = dataDirectory.resolve(arquivo);
        try {
            Files.createDirectories(dataDirectory);
            Files.write(path, linhas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao gravar " + arquivo, e);
        }
    }

    public String codificar(String valor) {
        if (valor == null) return "";
        return valor.replace("%", "%25").replace("\t", "%09")
                .replace("\r", "%0D").replace("\n", "%0A");
    }

    public String decodificar(String valor) {
        return valor.replace("%0A", "\n").replace("%0D", "\r")
                .replace("%09", "\t").replace("%25", "%");
    }
}
