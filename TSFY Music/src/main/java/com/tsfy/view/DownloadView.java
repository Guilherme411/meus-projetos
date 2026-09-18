package com.tsfy.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DownloadView {

    private final VBox root;
    private final TextField campoUrl;
    private final Button botaoConverter;

    public DownloadView() {

        root = new VBox();

        root.setSpacing(12);

        root.getStyleClass().add("painel");

        Label titulo = new Label(
            "DOWNLOAD"
        );

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        campoUrl = new TextField();

        campoUrl.setPromptText(
            "Cole o link do vídeo do YouTube..."
        );

        campoUrl.getStyleClass().add(
            "url-field"
        );

        botaoConverter =
            new Button(
                "▶  CONVERTER"
            );

        botaoConverter.getStyleClass().add(
            "converter-button"
        );

        root.getChildren().addAll(
            titulo,
            campoUrl,
            botaoConverter
        );
    }

    public VBox getView() {
        return root;
    }

    public TextField getCampoUrl() {
        return campoUrl;
    }

    public Button getBotaoConverter() {
        return botaoConverter;
    }
}