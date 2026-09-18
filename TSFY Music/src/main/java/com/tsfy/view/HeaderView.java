package com.tsfy.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HeaderView {

    private final HBox root;

    public HeaderView() {

        VBox logoArea = new VBox();

        Label logo = new Label("TSFY");
        logo.getStyleClass().add("logo");

        Label subtitulo = new Label(
            "YOUTUBE AUDIO DOWNLOADER"
        );

        subtitulo.getStyleClass().add("subtitulo");

        logoArea.getChildren().addAll(
            logo,
            subtitulo
        );

        Label sistema = new Label(
            "● SYSTEM ONLINE"
        );

        sistema.getStyleClass().add("sistema");

        root = new HBox();

        root.setAlignment(
            Pos.CENTER_LEFT
        );

        root.setSpacing(20);

        root.getChildren().addAll(
            logoArea,
            sistema
        );

        root.getStyleClass().add("header");
    }

    public HBox getView() {
        return root;
    }
}