package br.org.edu.ifrn.MidnightGarage.services;

import br.org.edu.ifrn.MidnightGarage.model.Log;
import br.org.edu.ifrn.MidnightGarage.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    public Log registrar(String operacao, String detalhes) {
        return repository.salvar(new Log(null, null, operacao, detalhes));
    }

    public List<Log> listar() {
        return repository.listar();
    }
}
