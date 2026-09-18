package com.tsfy.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StatisticsView {

    private final VBox root;

    private final Label downloads;
    private final Label concluidos;
    private final Label erros;

    private int totalDownloads = 0;
    private int totalConcluidos = 0;
    private int totalErros = 0;

    public StatisticsView() {

        root = new VBox();

        root.setSpacing(8);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label(
                "ESTATÍSTICAS"
            );

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        downloads =
            criarNumero(
                "DOWNLOADS"
            );

        concluidos =
            criarNumero(
                "CONCLUÍDOS"
            );

        erros =
            criarNumero(
                "ERROS"
            );

        root.getChildren().addAll(
            titulo,
            downloads,
            concluidos,
            erros
        );
    }

    private Label criarNumero(
        String nome
    ) {

        Label label =
            new Label(
                nome + "    0"
            );

        label.setMaxWidth(
            Double.MAX_VALUE
        );

        label.setAlignment(
            Pos.CENTER_LEFT
        );

        label.getStyleClass().add(
            "estatistica"
        );

        return label;
    }

    public void iniciarDownload() {

        totalDownloads++;

        atualizar();
    }

    public void downloadConcluido() {

        totalConcluidos++;

        atualizar();
    }

    public void registrarErro() {

        totalErros++;

        atualizar();
    }

    private void atualizar() {

        downloads.setText(
            "DOWNLOADS    " +
            totalDownloads
        );

        concluidos.setText(
            "CONCLUÍDOS    " +
            totalConcluidos
        );

        erros.setText(
            "ERROS    " +
            totalErros
        );
    }

    public VBox getView() {
        return root;
    }
}