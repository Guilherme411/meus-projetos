package br.org.edu.ifrn.MidnightGarage.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatusController {
    @GetMapping("/")
    public Map<String, String> inicio() {
        return Map.of(
                "mensagem", "API do Midnight Garage",
                "marcas", "/api/marcas",
                "carros", "/api/carros",
                "seminovos", "/api/carros/seminovos",
                "usuarios", "/api/usuarios",
                "logs", "/api/logs",
                "status", "online"
        );
    }
}
