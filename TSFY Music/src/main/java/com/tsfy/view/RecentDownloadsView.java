package com.tsfy.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RecentDownloadsView {

    private final VBox root;
    private final VBox lista;

    private int quantidadeDownloads = 0;

    public RecentDownloadsView() {

        root = new VBox();

        root.setSpacing(12);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label(
                "DOWNLOADS RECENTES"
            );

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        lista = new VBox();

        lista.setSpacing(8);

        root.getChildren().addAll(
            titulo,
            lista
        );

        adicionarMensagemInicial();
    }

    private void adicionarMensagemInicial() {

        Label vazio =
            new Label(
                "Nenhum download realizado."
            );

        vazio.getStyleClass().add(
            "recente-vazio"
        );

        lista.getChildren().add(
            vazio
        );
    }

    public void adicionarDownload(
        String tituloVideo
    ) {

        quantidadeDownloads++;

        // Remove a mensagem inicial
        if (quantidadeDownloads == 1) {

            lista.getChildren().clear();
        }

        Label item =
            new Label(
                "♫  " + tituloVideo
            );

        item.setWrapText(true);

        item.setMaxWidth(
            Double.MAX_VALUE
        );

        item.setAlignment(
            Pos.CENTER_LEFT
        );

        item.getStyleClass().add(
            "download-recente"
        );

        // Coloca o mais recente no topo
        lista.getChildren().add(
            0,
            item
        );

        // Mantém somente os 5 mais recentes
        if (lista.getChildren().size() > 5) {

            lista.getChildren().remove(
                5
            );
        }
    }

    public VBox getView() {
        return root;
    }
}