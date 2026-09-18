package com.tsfy.view;

import com.tsfy.model.VideoInfo;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VideoInfoView {

    private final VBox root;

    private final ImageView thumbnail;

    private final Label tituloVideo;
    private final Label canalVideo;
    private final Label duracaoVideo;

    public VideoInfoView() {

        root = new VBox();

        root.setSpacing(10);

        root.getStyleClass().add(
            "painel"
        );

        Label titulo =
            new Label("INFORMAÇÕES");

        titulo.getStyleClass().add(
            "titulo-painel"
        );

        thumbnail =
            new ImageView();

        thumbnail.setFitWidth(180);
        thumbnail.setFitHeight(100);

        thumbnail.setPreserveRatio(true);

        thumbnail.setVisible(false);

        tituloVideo =
            new Label("Título: --");

        canalVideo =
            new Label("Canal: --");

        duracaoVideo =
            new Label("Duração: --");

        tituloVideo.getStyleClass().add(
            "informacao"
        );

        canalVideo.getStyleClass().add(
            "informacao"
        );

        duracaoVideo.getStyleClass().add(
            "informacao"
        );

        root.getChildren().addAll(
            titulo,
            thumbnail,
            tituloVideo,
            canalVideo,
            duracaoVideo
        );
    }

    public VBox getView() {
        return root;
    }

    public void mostrarVideo(
        VideoInfo info
    ) {

        tituloVideo.setText(
            "Título: " +
            info.getTitulo()
        );

        canalVideo.setText(
            "Canal: " +
            info.getCanal()
        );

        duracaoVideo.setText(
            "Duração: " +
            info.getDuracao()
        );

        String urlThumbnail =
            info.getThumbnail();

        System.out.println(
            "[THUMBNAIL] " +
            urlThumbnail
        );

        if (
            urlThumbnail == null ||
            urlThumbnail.isBlank()
        ) {

            System.out.println(
                "[THUMBNAIL] URL vazia."
            );

            return;
        }

        Image imagem =
            new Image(
                urlThumbnail,
                320,
                180,
                true,
                true,
                false
            );

        if (imagem.isError()) {

            System.out.println(
                "[ERROR] JavaFX não conseguiu carregar a thumbnail."
            );

            return;
        }

        System.out.println(
            "[THUMBNAIL] Imagem carregada: " +
            imagem.getWidth() +
            "x" +
            imagem.getHeight()
        );

        thumbnail.setImage(
            imagem
        );

        thumbnail.setVisible(
            true
        );
    }

    public void limpar() {

        thumbnail.setImage(null);

        thumbnail.setVisible(false);

        tituloVideo.setText(
            "Título: --"
        );

        canalVideo.setText(
            "Canal: --"
        );

        duracaoVideo.setText(
            "Duração: --"
        );
    }
}