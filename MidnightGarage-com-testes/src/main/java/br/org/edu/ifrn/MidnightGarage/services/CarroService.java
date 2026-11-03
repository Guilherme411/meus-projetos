package br.org.edu.ifrn.MidnightGarage.services;

import br.org.edu.ifrn.MidnightGarage.exception.RecursoNaoEncontradoException;
import br.org.edu.ifrn.MidnightGarage.model.Carro;
import br.org.edu.ifrn.MidnightGarage.model.Marca;
import br.org.edu.ifrn.MidnightGarage.repository.CarroRepository;
import br.org.edu.ifrn.MidnightGarage.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carros;
    private final MarcaRepository marcas;
    private final LogService logs;

    public CarroService(CarroRepository carros, MarcaRepository marcas, LogService logs) {
        this.carros = carros;
        this.marcas = marcas;
        this.logs = logs;
    }

    public List<Carro> listar() { return carros.listar(); }

    public List<Carro> listarSeminovos() {
        return carros.listar().stream().filter(Carro::isSeminovo).toList();
    }

    public Carro buscar(Long id) {
        return carros.buscar(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Carro " + id + " não encontrado."));
    }

    public Carro cadastrar(Carro carro) {
        validar(carro);
        carro.setId(null);
        carro.setMarca(marcaCanonica(carro.getMarca()));
        Carro salvo = carros.salvar(carro);
        logs.registrar("CADASTRO_CARRO", "Carro cadastrado: " + salvo.getMarca() + " " + salvo.getModelo());
        return salvo;
    }

    public Carro atualizar(Long id, Carro dados) {
        Carro atual = buscar(id);
        validar(dados);
        atual.setMarca(marcaCanonica(dados.getMarca()));
        atual.setModelo(dados.getModelo().trim());
        atual.setCor(dados.getCor().trim());
        atual.setPreco(dados.getPreco());
        atual.setAno(dados.getAno());
        atual.setSeminovo(dados.isSeminovo());
        carros.salvar(atual);
        logs.registrar("ATUALIZACAO_CARRO", "Carro atualizado: " + atual.getMarca() + " " + atual.getModelo());
        return atual;
    }

    public void excluir(Long id) {
        Carro carro = buscar(id);
        carros.excluir(id);
        logs.registrar("EXCLUSAO_CARRO", "Carro excluído: " + carro.getMarca() + " " + carro.getModelo());
    }

    private void validar(Carro carro) {
        if (carro.getMarca() == null || carro.getMarca().isBlank())
            throw new IllegalArgumentException("A marca do carro é obrigatória.");
        if (carro.getModelo() == null || carro.getModelo().isBlank())
            throw new IllegalArgumentException("O modelo do carro é obrigatório.");
        if (carro.getCor() == null || carro.getCor().isBlank())
            throw new IllegalArgumentException("A cor do carro é obrigatória.");
        if (carro.getPreco() < 0 || Double.isNaN(carro.getPreco()) || Double.isInfinite(carro.getPreco()))
            throw new IllegalArgumentException("O preço deve ser um número válido e não negativo.");
        if (carro.getAno() < 1886 || carro.getAno() > java.time.Year.now().getValue() + 1)
            throw new IllegalArgumentException("O ano informado é inválido.");
    }

    private String marcaCanonica(String nome) {
        Marca marca = marcas.listar().stream()
                .filter(m -> m.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "A marca '" + nome + "' não está cadastrada. Cadastre a marca primeiro."));
        return marca.getNome();
    }
}
