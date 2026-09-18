package com.tsfy.view;

import java.awt.Desktop;
import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SidebarView {

    private final VBox root;

    private final Button inicio;
    private final Button downloads;
    private final Button historico;
    private final Button playlist;
    private final Button sobre;

    public SidebarView() {

        root = new VBox();

        root.setSpacing(12);

        root.getStyleClass().add(
            "menu"
        );


        /*
         * =====================================================
         * BOTÕES
         * =====================================================
         */

        inicio =
            new Button(
                "⌂   INÍCIO"
            );

        downloads =
            new Button(
                "↓   DOWNLOADS"
            );

        historico =
            new Button(
                "◷   HISTÓRICO"
            );

        playlist =
            new Button(
                "♫   PLAYLIST"
            );

        sobre =
            new Button(
                "ⓘ   SOBRE"
            );


        /*
         * =====================================================
         * ESTILOS
         * =====================================================
         */

        inicio.getStyleClass().addAll(
            "menu-button",
            "menu-button-ativo"
        );

        downloads.getStyleClass().add(
            "menu-button"
        );

        historico.getStyleClass().add(
            "menu-button"
        );

        playlist.getStyleClass().add(
            "menu-button"
        );

        sobre.getStyleClass().add(
            "menu-button"
        );


        /*
         * =====================================================
         * DOWNLOADS
         * =====================================================
         *
         * Por enquanto continua abrindo
         * a pasta diretamente.
         *
         * Depois vamos transformar isso
         * em uma tela própria.
         */

        downloads.setOnAction(event -> {

            try {

                File pasta =
                    new File("downloads");

                if (!pasta.exists()) {

                    pasta.mkdirs();
                }

                Desktop.getDesktop()
                    .open(pasta);

            } catch (Exception erro) {

                erro.printStackTrace();
            }
        });


        /*
         * =====================================================
         * SOBRE
         * =====================================================
         */

        sobre.setOnAction(event -> {

            AboutView about =
                new AboutView();

            Stage janelaSobre =
                new Stage();

            Scene cenaSobre =
                new Scene(
                    about.getView(),
                    500,
                    350
                );

            cenaSobre
                .getStylesheets()
                .add(
                    getClass()
                        .getResource(
                            "/style.css"
                        )
                        .toExternalForm()
                );

            janelaSobre.setTitle(
                "TSFY — Sobre"
            );

            janelaSobre.setScene(
                cenaSobre
            );

            janelaSobre.setResizable(
                false
            );

            janelaSobre.show();
        });


        /*
         * =====================================================
         * ADICIONA OS BOTÕES
         * =====================================================
         */

        root.getChildren().addAll(
            inicio,
            downloads,
            historico,
            playlist,
            sobre
        );
    }


    /*
     * =========================================================
     * ACESSO AOS BOTÕES
     * =========================================================
     */

    public Button getInicio() {
        return inicio;
    }

    public Button getDownloads() {
        return downloads;
    }

    public Button getHistorico() {
        return historico;
    }

    public Button getPlaylist() {
        return playlist;
    }

    public Button getSobre() {
        return sobre;
    }


    public VBox getView() {
        return root;
    }
}