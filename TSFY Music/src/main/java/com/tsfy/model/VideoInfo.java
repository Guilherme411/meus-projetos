package com.tsfy.model;

public class VideoInfo {

    private String titulo;
    private String canal;
    private String duracao;
    private String thumbnail;

    public VideoInfo(
        String titulo,
        String canal,
        String duracao,
        String thumbnail
    ) {
        this.titulo = titulo;
        this.canal = canal;
        this.duracao = duracao;
        this.thumbnail = thumbnail;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCanal() {
        return canal;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}