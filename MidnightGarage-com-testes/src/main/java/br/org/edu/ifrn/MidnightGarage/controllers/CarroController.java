package br.org.edu.ifrn.MidnightGarage.controllers;

import br.org.edu.ifrn.MidnightGarage.model.Carro;
import br.org.edu.ifrn.MidnightGarage.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    private final CarroService service;
    public CarroController(CarroService service) { this.service = service; }

    @GetMapping
    public List<Carro> listar() { return service.listar(); }

    @GetMapping("/seminovos")
    public List<Carro> listarSeminovos() { return service.listarSeminovos(); }

    @GetMapping("/{id}")
    public Carro buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro cadastrar(@Valid @RequestBody Carro carro) { return service.cadastrar(carro); }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        return service.atualizar(id, carro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
