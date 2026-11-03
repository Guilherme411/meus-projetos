package br.org.edu.ifrn.MidnightGarage.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class Carro {
    private Long id;

    @NotBlank(message = "A marca é obrigatória.")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório.")
    private String modelo;

    @NotBlank(message = "A cor é obrigatória.")
    private String cor;

    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private double preco;

    @Min(value = 1886, message = "O ano deve ser 1886 ou posterior.")
    private int ano;

    private boolean seminovo;

    public Carro() {
    }

    public Carro(Long id, String marca, String modelo, String cor,
                 double preco, int ano, boolean seminovo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.ano = ano;
        this.seminovo = seminovo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public boolean isSeminovo() { return seminovo; }
    public void setSeminovo(boolean seminovo) { this.seminovo = seminovo; }
}
