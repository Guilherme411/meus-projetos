package br.org.edu.ifrn.MidnightGarage.model;

import java.time.LocalDateTime;

public class Log {
    private Long id;
    private LocalDateTime horario;
    private String operacao;
    private String detalhes;

    public Log() {}
    public Log(Long id, LocalDateTime horario, String operacao, String detalhes) {
        this.id = id; this.horario = horario; this.operacao = operacao; this.detalhes = detalhes;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getHorario() { return horario; }
    public void setHorario(LocalDateTime horario) { this.horario = horario; }
    public String getOperacao() { return operacao; }
    public void setOperacao(String operacao) { this.operacao = operacao; }
    public String getDetalhes() { return detalhes; }
    public void setDetalhes(String detalhes) { this.detalhes = detalhes; }
}
