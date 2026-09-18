package com.tsfy.view;

import com.tsfy.model.VideoInfo;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class JarvisView {

    private final VBox root;

    private final TextField campoUrl;
    private final Button botaoConverter;

    private final Label mensagem;

    private final Label tituloVideo;
    private final Label canalVideo;
    private final Label formatoVideo;
    private final Label duracaoVideo;

    private final VBox dadosVideo;

    private final ImageView imagemVideo;
    private final Label visualInicial;


    public JarvisView() {

        /*
         * =====================================================
         * PAINEL PRINCIPAL
         * =====================================================
         */

        root = new VBox();

        root.setSpacing(12);

        root.getStyleClass().add(
            "jarvis"
        );


        /*
         * =====================================================
         * ÁREA PRINCIPAL
         * =====================================================
         */

        HBox areaPrincipal =
            new HBox();

        areaPrincipal.setSpacing(20);


        /*
         * =====================================================
         * ÁREA VISUAL
         *
         * Futuramente vamos colocar aqui o GIF
         * de códigos.
         * =====================================================
         */

        StackPane areaVisual =
            new StackPane();

        areaVisual.setPrefSize(
            380,
            250
        );

        areaVisual
            .getStyleClass()
            .add(
                "jarvis-visual"
            );


        /*
         * Texto temporário.
         *
         * Depois será substituído pelo GIF.
         */

        visualInicial =
            new Label(
                "J.A.R.V.I.S."
            );

        visualInicial
            .getStyleClass()
            .add(
                "jarvis-visual-text"
            );


        /*
         * =====================================================
         * IMAGEM DO VÍDEO
         *
         * Futuramente também poderá receber
         * a thumbnail do vídeo.
         * =====================================================
         */

        imagemVideo =
            new ImageView();

        imagemVideo.setFitWidth(
            360
        );

        imagemVideo.setFitHeight(
            220
        );

        imagemVideo.setPreserveRatio(
            true
        );

        imagemVideo.setVisible(
            false
        );


        areaVisual
            .getChildren()
            .addAll(
                visualInicial,
                imagemVideo
            );


        /*
         * =====================================================
         * ÁREA J.A.R.V.I.S.
         * =====================================================
         */

        VBox informacoes =
            new VBox();

        informacoes.setSpacing(
            10
        );

        informacoes
            .getStyleClass()
            .add(
                "jarvis-info"
            );


        /*
         * TÍTULO
         */

        Label tituloJarvis =
            new Label(
                "J.A.R.V.I.S."
            );

        tituloJarvis
            .getStyleClass()
            .add(
                "jarvis-titulo"
            );


        /*
         * =====================================================
         * MENSAGEM INICIAL
         * =====================================================
         */

        mensagem =
            new Label(
                "Pronto para baixar\nsua música, chefe."
            );

        mensagem
            .getStyleClass()
            .add(
                "jarvis-mensagem"
            );


        /*
         * =====================================================
         * INFORMAÇÕES DO VÍDEO
         *
         * Ficam escondidas até uma URL ser pesquisada.
         * =====================================================
         */

        dadosVideo =
            new VBox();

        dadosVideo.setSpacing(
            6
        );

        dadosVideo
            .getStyleClass()
            .add(
                "jarvis-dados"
            );


        tituloVideo =
            new Label(
                "Título: --"
            );

        canalVideo =
            new Label(
                "Canal: --"
            );

        formatoVideo =
            new Label(
                "Formato: MP3"
            );

        duracaoVideo =
            new Label(
                "Duração: --"
            );


        tituloVideo
            .getStyleClass()
            .add(
                "jarvis-dado"
            );

        canalVideo
            .getStyleClass()
            .add(
                "jarvis-dado"
            );

        formatoVideo
            .getStyleClass()
            .add(
                "jarvis-dado"
            );

        duracaoVideo
            .getStyleClass()
            .add(
                "jarvis-dado"
            );


        dadosVideo
            .getChildren()
            .addAll(
                tituloVideo,
                canalVideo,
                formatoVideo,
                duracaoVideo
            );

        dadosVideo.setVisible(
            false
        );


        /*
         * =====================================================
         * CAMPO DA URL
         * =====================================================
         */

        campoUrl =
            new TextField();

        campoUrl.setPromptText(
            "Cole o link do vídeo do YouTube..."
        );

        campoUrl
            .getStyleClass()
            .add(
                "jarvis-url"
            );


        /*
         * =====================================================
         * BOTÃO CONVERTER
         * =====================================================
         */

        botaoConverter =
            new Button(
                "▶  CONVERTER"
            );

        botaoConverter
            .getStyleClass()
            .add(
                "converter-button"
            );


        /*
         * =====================================================
         * MONTANDO O PAINEL J.A.R.V.I.S.
         * =====================================================
         */

        informacoes
            .getChildren()
            .addAll(
                tituloJarvis,
                mensagem,
                dadosVideo,
                campoUrl,
                botaoConverter
            );


        /*
         * =====================================================
         * DISTRIBUIÇÃO DO ESPAÇO
         * =====================================================
         */

        HBox.setHgrow(
            areaVisual,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            informacoes,
            Priority.ALWAYS
        );


        areaPrincipal
            .getChildren()
            .addAll(
                areaVisual,
                informacoes
            );


        /*
         * =====================================================
         * ADICIONA TUDO AO PAINEL PRINCIPAL
         * =====================================================
         */

        root
            .getChildren()
            .add(
                areaPrincipal
            );
    }


    /*
     * =========================================================
     * RETORNA A VIEW
     * =========================================================
     */

    public VBox getView() {

        return root;
    }


    /*
     * =========================================================
     * CAMPO DA URL
     * =========================================================
     */

    public TextField getCampoUrl() {

        return campoUrl;
    }


    /*
     * =========================================================
     * BOTÃO CONVERTER
     * =========================================================
     */

    public Button getBotaoConverter() {

        return botaoConverter;
    }


    /*
     * =========================================================
     * MOSTRA AS INFORMAÇÕES DO VÍDEO
     * =========================================================
     */

    public void mostrarVideo(
        VideoInfo info
    ) {

        /*
         * Esconde a mensagem inicial.
         */

        mensagem.setVisible(
            false
        );


        /*
         * Mostra as informações recebidas.
         */

        tituloVideo.setText(
            "Título: " +
            info.getTitulo()
        );

        canalVideo.setText(
            "Canal: " +
            info.getCanal()
        );

        formatoVideo.setText(
            "Formato: MP3"
        );

        duracaoVideo.setText(
            "Duração: " +
            info.getDuracao()
        );


        /*
         * Mostra o bloco de informações.
         */

        dadosVideo.setVisible(
            true
        );


        /*
         * =====================================================
         * THUMBNAIL
         * =====================================================
         */

        String urlThumbnail =
            info.getThumbnail();


        if (
            urlThumbnail == null ||
            urlThumbnail.isBlank()
        ) {

            return;
        }


        Image imagem =
            new Image(
                urlThumbnail,
                360,
                220,
                true,
                true,
                false
            );


        if (
            imagem.isError()
        ) {

            System.out.println(
                "[THUMBNAIL] Erro ao carregar imagem."
            );

            return;
        }


        imagemVideo.setImage(
            imagem
        );

        imagemVideo.setVisible(
            true
        );

        visualInicial.setVisible(
            false
        );
    }


    /*
     * =========================================================
     * LIMPA AS INFORMAÇÕES
     * =========================================================
     */

    public void limpar() {

        mensagem.setVisible(
            true
        );


        dadosVideo.setVisible(
            false
        );


        tituloVideo.setText(
            "Título: --"
        );

        canalVideo.setText(
            "Canal: --"
        );

        formatoVideo.setText(
            "Formato: MP3"
        );

        duracaoVideo.setText(
            "Duração: --"
        );


        imagemVideo.setImage(
            null
        );

        imagemVideo.setVisible(
            false
        );

        visualInicial.setVisible(
            true
        );
    }
}