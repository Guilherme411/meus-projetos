package br.org.edu.ifrn.MidnightGarage.services;

import br.org.edu.ifrn.MidnightGarage.exception.RecursoNaoEncontradoException;
import br.org.edu.ifrn.MidnightGarage.model.Usuario;
import br.org.edu.ifrn.MidnightGarage.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final LogService logs;

    public UsuarioService(UsuarioRepository repository, LogService logs) {
        this.repository = repository; this.logs = logs;
    }

    public List<Usuario> listar() { return repository.listar(); }
    public Usuario buscar(Long id) {
        return repository.buscar(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Usuário " + id + " não encontrado."));
    }
    public Usuario cadastrar(Usuario u) {
        validar(u); u.setId(null);
        Usuario salvo = repository.salvar(u);
        logs.registrar("CADASTRO_USUARIO", "Usuário cadastrado: " + salvo.getNome());
        return salvo;
    }
    public Usuario atualizar(Long id, Usuario dados) {
        Usuario atual = buscar(id); validar(dados);
        atual.setNome(dados.getNome().trim());
        atual.setEmail(dados.getEmail().trim());
        atual.setPerfil(dados.getPerfil().trim());
        repository.salvar(atual);
        logs.registrar("ATUALIZACAO_USUARIO", "Usuário atualizado: " + atual.getNome());
        return atual;
    }
    public void excluir(Long id) {
        Usuario u = buscar(id); repository.excluir(id);
        logs.registrar("EXCLUSAO_USUARIO", "Usuário excluído: " + u.getNome());
    }
    private void validar(Usuario u) {
        if (u.getNome() == null || u.getNome().isBlank()) throw new IllegalArgumentException("O nome é obrigatório.");
        if (u.getEmail() == null || !u.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))
            throw new IllegalArgumentException("Informe um e-mail válido.");
        if (u.getPerfil() == null || u.getPerfil().isBlank()) u.setPerfil("VENDEDOR");
    }
}
