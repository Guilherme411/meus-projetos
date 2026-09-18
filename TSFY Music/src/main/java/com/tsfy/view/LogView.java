package com.tsfy.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class LogView {

    private final VBox root;
    private final TextArea log;

    public LogView() {

        root = new VBox();

        root.setSpacing(10);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label("LOG DO SISTEMA");

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        log = new TextArea();

        log.setEditable(false);
        log.setWrapText(true);

        log.setText(
            "[SYSTEM] Aguardando URL..."
        );

        log.getStyleClass().add(
            "log"
        );

        root.getChildren().addAll(
            titulo,
            log
        );
    }

    public VBox getView() {
        return root;
    }

    public void adicionar(String mensagem) {

        if (log.getText().isBlank()) {

            log.setText(mensagem);

        } else {

            log.appendText(
                "\n" + mensagem
            );
        }
    }

    public void limpar() {
        log.clear();
    }
}