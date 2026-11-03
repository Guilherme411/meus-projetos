package br.org.edu.ifrn.MidnightGarage.repository;

import br.org.edu.ifrn.MidnightGarage.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsuarioRepository {
    private static final String ARQUIVO = "usuarios.txt";
    private final TxtDatabase db;
    private final AtomicLong sequencia = new AtomicLong(1);

    public UsuarioRepository(TxtDatabase db) {
        this.db = db;
        long maior = listar().stream().mapToLong(Usuario::getId).max().orElse(0);
        sequencia.set(maior + 1);
    }

    public synchronized List<Usuario> listar() {
        List<Usuario> resultado = new ArrayList<>();
        for (String linha : db.ler(ARQUIVO)) {
            try {
                String[] p = linha.split("\\t", -1);
                resultado.add(new Usuario(Long.parseLong(p[0]), db.decodificar(p[1]),
                        db.decodificar(p[2]), db.decodificar(p[3])));
            } catch (Exception ignored) {}
        }
        return resultado;
    }

    public synchronized Optional<Usuario> buscar(Long id) {
        return listar().stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public synchronized Usuario salvar(Usuario usuario) {
        List<Usuario> lista = listar();
        if (usuario.getId() == null) usuario.setId(sequencia.getAndIncrement());
        lista.removeIf(u -> u.getId().equals(usuario.getId()));
        lista.add(usuario);
        db.gravar(ARQUIVO, lista.stream().map(u -> u.getId() + "\t"
                + db.codificar(u.getNome()) + "\t" + db.codificar(u.getEmail()) + "\t"
                + db.codificar(u.getPerfil())).toList());
        return usuario;
    }

    public synchronized boolean excluir(Long id) {
        List<Usuario> lista = listar();
        boolean removido = lista.removeIf(u -> u.getId().equals(id));
        if (removido) db.gravar(ARQUIVO, lista.stream().map(u -> u.getId() + "\t"
                + db.codificar(u.getNome()) + "\t" + db.codificar(u.getEmail()) + "\t"
                + db.codificar(u.getPerfil())).toList());
        return removido;
    }
}
