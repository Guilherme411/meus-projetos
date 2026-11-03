package br.org.edu.ifrn.MidnightGarage.controllers;

import br.org.edu.ifrn.MidnightGarage.model.Usuario;
import br.org.edu.ifrn.MidnightGarage.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping public List<Usuario> listar() { return service.listar(); }
    @GetMapping("/{id}") public Usuario buscar(@PathVariable Long id) { return service.buscar(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario) { return service.cadastrar(usuario); }
    @PutMapping("/{id}") public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
