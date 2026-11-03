package br.org.edu.ifrn.MidnightGarage.repository;

import br.org.edu.ifrn.MidnightGarage.model.Carro;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CarroRepository {
    private static final String ARQUIVO = "carros.txt";
    private final TxtDatabase db;
    private final AtomicLong sequencia = new AtomicLong(1);

    public CarroRepository(TxtDatabase db) {
        this.db = db;
        long maior = db.ler(ARQUIVO).stream().filter(l -> !l.isBlank())
                .map(this::parse).filter(Objects::nonNull).mapToLong(Carro::getId).max().orElse(0);
        sequencia.set(maior + 1);
    }

    public synchronized List<Carro> listar() {
        return db.ler(ARQUIVO).stream().filter(l -> !l.isBlank()).map(this::parse)
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    public synchronized Optional<Carro> buscar(Long id) {
        return listar().stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public synchronized Carro salvar(Carro carro) {
        List<Carro> lista = listar();
        if (carro.getId() == null) carro.setId(sequencia.getAndIncrement());
        lista.removeIf(c -> c.getId().equals(carro.getId()));
        lista.add(carro);
        gravar(lista);
        return carro;
    }

    public synchronized boolean excluir(Long id) {
        List<Carro> lista = listar();
        boolean removido = lista.removeIf(c -> c.getId().equals(id));
        if (removido) gravar(lista);
        return removido;
    }

    private Carro parse(String linha) {
        try {
            String[] p = linha.split("\\t", -1);
            return new Carro(Long.parseLong(p[0]), db.decodificar(p[1]), db.decodificar(p[2]),
                    db.decodificar(p[3]), Double.parseDouble(p[4]), Integer.parseInt(p[5]),
                    Boolean.parseBoolean(p[6]));
        } catch (Exception e) { return null; }
    }

    private void gravar(List<Carro> lista) {
        db.gravar(ARQUIVO, lista.stream().map(c -> c.getId() + "\t"
                + db.codificar(c.getMarca()) + "\t" + db.codificar(c.getModelo()) + "\t"
                + db.codificar(c.getCor()) + "\t" + c.getPreco() + "\t"
                + c.getAno() + "\t" + c.isSeminovo()).toList());
    }
}
