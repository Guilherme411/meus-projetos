package com.tsfy.view;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class ProgressView {

    private final VBox root;
    private final ProgressBar progresso;
    private final Label resultado;

    public ProgressView() {

        root = new VBox();

        root.setSpacing(10);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label("PROGRESSO");

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        progresso =
            new ProgressBar(0);

        progresso.setMaxWidth(
            Double.MAX_VALUE
        );

        progresso.getStyleClass().add(
            "progress-bar"
        );

        resultado =
            new Label("SYSTEM READY");

        resultado.getStyleClass().add(
            "status"
        );

        root.getChildren().addAll(
            titulo,
            progresso,
            resultado
        );
    }

    public VBox getView() {
        return root;
    }

    public void resetar() {
        progresso.setProgress(0);
        resultado.setText(
            "SYSTEM READY"
        );
    }

    public void atualizar(
        double valor
    ) {

        progresso.setProgress(
            valor / 100
        );

        resultado.setText(
            String.format(
                "DOWNLOADING — %.1f%%",
                valor
            )
        );
    }

    public void status(
        String mensagem
    ) {
        resultado.setText(
            mensagem
        );
    }
}