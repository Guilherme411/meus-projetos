package br.org.edu.ifrn.MidnightGarage.repository;

import br.org.edu.ifrn.MidnightGarage.model.Marca;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MarcaRepository {
    private static final String ARQUIVO = "marcas.txt";
    private final TxtDatabase db;
    private final AtomicLong sequencia = new AtomicLong(1);

    public MarcaRepository(TxtDatabase db) {
        this.db = db;
        long maior = db.ler(ARQUIVO).stream().filter(l -> !l.isBlank())
                .map(this::parse).filter(Objects::nonNull).mapToLong(Marca::getId).max().orElse(0);
        sequencia.set(maior + 1);
    }

    public synchronized List<Marca> listar() {
        return db.ler(ARQUIVO).stream().filter(l -> !l.isBlank()).map(this::parse)
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    public synchronized Optional<Marca> buscar(Long id) {
        return listar().stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public synchronized Marca salvar(Marca marca) {
        List<Marca> lista = listar();
        if (marca.getId() == null) marca.setId(sequencia.getAndIncrement());
        lista.removeIf(m -> m.getId().equals(marca.getId()));
        lista.add(marca);
        gravar(lista);
        return marca;
    }

    public synchronized boolean excluir(Long id) {
        List<Marca> lista = listar();
        boolean removido = lista.removeIf(m -> m.getId().equals(id));
        if (removido) gravar(lista);
        return removido;
    }

    private Marca parse(String linha) {
        try {
            String[] p = linha.split("\\t", -1);
            return new Marca(Long.parseLong(p[0]), db.decodificar(p[1]));
        } catch (Exception e) { return null; }
    }

    private void gravar(List<Marca> lista) {
        db.gravar(ARQUIVO, lista.stream().map(m -> m.getId() + "\t" + db.codificar(m.getNome())).toList());
    }
}
