package br.org.edu.ifrn.MidnightGarage.controllers;

import br.org.edu.ifrn.MidnightGarage.model.Marca;
import br.org.edu.ifrn.MidnightGarage.services.MarcaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    private final MarcaService service;
    public MarcaController(MarcaService service) { this.service = service; }

    @GetMapping
    public List<Marca> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Marca buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Marca cadastrar(@Valid @RequestBody Marca marca) { return service.cadastrar(marca); }

    @PutMapping("/{id}")
    public Marca atualizar(@PathVariable Long id, @Valid @RequestBody Marca marca) {
        return service.atualizar(id, marca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
