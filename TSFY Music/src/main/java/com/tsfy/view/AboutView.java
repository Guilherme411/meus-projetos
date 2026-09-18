package com.tsfy.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AboutView {

    private final VBox root;

    public AboutView() {

        root = new VBox();

        root.setSpacing(16);

        root.setAlignment(
            Pos.CENTER
        );

        root.getStyleClass().add(
            "about"
        );


        /*
         * =====================================================
         * TÍTULO
         * =====================================================
         */

        Label titulo =
            new Label(
                "TSFY"
            );

        titulo.getStyleClass().add(
            "about-titulo"
        );


        /*
         * =====================================================
         * SUBTÍTULO
         * =====================================================
         */

        Label subtitulo =
            new Label(
                "YOUTUBE AUDIO DOWNLOADER"
            );

        subtitulo.getStyleClass().add(
            "about-subtitulo"
        );


        /*
         * =====================================================
         * DESCRIÇÃO
         * =====================================================
         */

        Label descricao =
            new Label(
                "Aplicação desktop desenvolvida para\n" +
                "download e conversão de áudio a partir\n" +
                "de vídeos do YouTube."
            );

        descricao.setAlignment(
            Pos.CENTER
        );

        descricao.getStyleClass().add(
            "about-descricao"
        );


        /*
         * =====================================================
         * DESENVOLVEDOR
         * =====================================================
         */

        Label desenvolvedor =
            new Label(
                "DESENVOLVIDO POR\nGUILHERME"
            );

        desenvolvedor.setAlignment(
            Pos.CENTER
        );

        desenvolvedor.getStyleClass().add(
            "about-desenvolvedor"
        );


        /*
         * =====================================================
         * VERSÃO
         * =====================================================
         */

        Label versao =
            new Label(
                "TSFY v1.0"
            );

        versao.getStyleClass().add(
            "about-versao"
        );


        /*
         * =====================================================
         * BOTÃO FECHAR
         * =====================================================
         */

        Button fechar =
            new Button(
                "FECHAR"
            );

        fechar.getStyleClass().add(
            "about-button"
        );

        fechar.setOnAction(event -> {

            Stage janela =
                (Stage) fechar
                    .getScene()
                    .getWindow();

            janela.close();
        });


        /*
         * =====================================================
         * ADICIONA ELEMENTOS
         * =====================================================
         */

        root.getChildren().addAll(
            titulo,
            subtitulo,
            descricao,
            desenvolvedor,
            versao,
            fechar
        );
    }


    /*
     * =========================================================
     * RETORNA A INTERFACE
     * =========================================================
     */

    public VBox getView() {
        return root;
    }
}