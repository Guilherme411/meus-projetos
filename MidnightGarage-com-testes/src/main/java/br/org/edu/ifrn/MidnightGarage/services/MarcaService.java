package br.org.edu.ifrn.MidnightGarage.services;

import br.org.edu.ifrn.MidnightGarage.exception.RecursoNaoEncontradoException;
import br.org.edu.ifrn.MidnightGarage.model.Marca;
import br.org.edu.ifrn.MidnightGarage.repository.CarroRepository;
import br.org.edu.ifrn.MidnightGarage.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    private final MarcaRepository marcas;
    private final CarroRepository carros;
    private final LogService logs;

    public MarcaService(MarcaRepository marcas, CarroRepository carros, LogService logs) {
        this.marcas = marcas;
        this.carros = carros;
        this.logs = logs;
    }

    public List<Marca> listar() { return marcas.listar(); }

    public Marca buscar(Long id) {
        return marcas.buscar(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Marca " + id + " não encontrada."));
    }

    public Marca cadastrar(Marca marca) {
        validarNome(marca.getNome());
        boolean existe = marcas.listar().stream()
                .anyMatch(m -> m.getNome().equalsIgnoreCase(marca.getNome().trim()));
        if (existe) throw new IllegalArgumentException("Essa marca já está cadastrada.");
        marca.setId(null);
        marca.setNome(marca.getNome().trim());
        Marca salva = marcas.salvar(marca);
        logs.registrar("CADASTRO_MARCA", "Marca cadastrada: " + salva.getNome());
        return salva;
    }

    public Marca atualizar(Long id, Marca dados) {
        Marca atual = buscar(id);
        validarNome(dados.getNome());
        String nome = dados.getNome().trim();
        boolean duplicada = marcas.listar().stream()
                .anyMatch(m -> !m.getId().equals(id) && m.getNome().equalsIgnoreCase(nome));
        if (duplicada) throw new IllegalArgumentException("Já existe outra marca com esse nome.");
        String antigo = atual.getNome();
        atual.setNome(nome);
        marcas.salvar(atual);
        carros.listar().stream().filter(c -> c.getMarca().equalsIgnoreCase(antigo)).forEach(c -> {
            c.setMarca(nome);
            carros.salvar(c);
        });
        logs.registrar("ATUALIZACAO_MARCA", "Marca " + antigo + " renomeada para " + nome);
        return atual;
    }

    public void excluir(Long id) {
        Marca marca = buscar(id);
        boolean possuiCarros = carros.listar().stream()
                .anyMatch(c -> c.getMarca().equalsIgnoreCase(marca.getNome()));
        if (possuiCarros) throw new IllegalArgumentException(
                "Não é possível excluir a marca enquanto houver carros cadastrados nela.");
        marcas.excluir(id);
        logs.registrar("EXCLUSAO_MARCA", "Marca excluída: " + marca.getNome());
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da marca é obrigatório.");
        }
        if (nome.trim().length() > 60) {
            throw new IllegalArgumentException("O nome da marca deve ter até 60 caracteres.");
        }
    }
}
