package br.org.edu.ifrn.MidnightGarage.controllers;

import br.org.edu.ifrn.MidnightGarage.model.Log;
import br.org.edu.ifrn.MidnightGarage.services.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    private final LogService service;
    public LogController(LogService service) { this.service = service; }

    @GetMapping
    public List<Log> listar() { return service.listar(); }
}
