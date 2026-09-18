package com.tsfy.view;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class HistoryView {

    private final VBox root;
    private final VBox lista;

    public HistoryView() {

        root = new VBox();

        root.setSpacing(12);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label(
                "HISTÓRICO DE DOWNLOADS"
            );

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        lista = new VBox();

        lista.setSpacing(8);

        Label vazio =
            new Label(
                "Nenhum download realizado."
            );

        vazio.getStyleClass().add(
            "historico-vazio"
        );

        lista.getChildren().add(
            vazio
        );

        ScrollPane scroll =
            new ScrollPane(
                lista
            );

        scroll.setFitToWidth(
            true
        );

        scroll.getStyleClass().add(
            "historico-scroll"
        );

        VBox.setVgrow(
            scroll,
            javafx.scene.layout.Priority.ALWAYS
        );

        root.getChildren().addAll(
            titulo,
            scroll
        );
    }

    public void adicionar(
        String tituloVideo
    ) {

        /*
         * Remove a mensagem inicial.
         */

        if (
            lista.getChildren().size() == 1 &&
            lista.getChildren()
                .get(0) instanceof Label
        ) {

            lista.getChildren().clear();
        }


        /*
         * Cria o item do histórico.
         */

        Label item =
            new Label(
                "♫  " + tituloVideo
            );

        item.setWrapText(
            true
        );

        item.setMaxWidth(
            Double.MAX_VALUE
        );

        item.getStyleClass().add(
            "historico-item"
        );


        /*
         * O download mais recente
         * aparece no topo.
         */

        lista.getChildren().add(
            0,
            item
        );
    }

    public VBox getView() {
        return root;
    }
}