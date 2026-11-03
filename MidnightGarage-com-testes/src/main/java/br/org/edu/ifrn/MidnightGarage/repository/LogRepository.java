package br.org.edu.ifrn.MidnightGarage.repository;

import br.org.edu.ifrn.MidnightGarage.model.Log;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LogRepository {
    private static final String ARQUIVO = "logs.txt";
    private final TxtDatabase db;
    private final AtomicLong sequencia = new AtomicLong(1);

    public LogRepository(TxtDatabase db) {
        this.db = db;
        long maior = listar().stream().mapToLong(Log::getId).max().orElse(0);
        sequencia.set(maior + 1);
    }

    public synchronized List<Log> listar() {
        List<Log> resultado = new ArrayList<>();
        for (String linha : db.ler(ARQUIVO)) {
            try {
                String[] p = linha.split("\\t", -1);
                resultado.add(new Log(Long.parseLong(p[0]), LocalDateTime.parse(p[1]),
                        db.decodificar(p[2]), db.decodificar(p[3])));
            } catch (Exception ignored) {}
        }
        resultado.sort(Comparator.comparing(Log::getHorario).reversed());
        return resultado;
    }

    public synchronized Log salvar(Log log) {
        if (log.getId() == null) log.setId(sequencia.getAndIncrement());
        if (log.getHorario() == null) log.setHorario(LocalDateTime.now());
        List<Log> lista = listar();
        lista.removeIf(l -> l.getId().equals(log.getId()));
        lista.add(log);
        db.gravar(ARQUIVO, lista.stream().map(l -> l.getId() + "\t" + l.getHorario()
                + "\t" + db.codificar(l.getOperacao()) + "\t" + db.codificar(l.getDetalhes())).toList());
        return log;
    }
}
