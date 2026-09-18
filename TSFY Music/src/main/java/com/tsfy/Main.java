package com.tsfy;

import com.tsfy.controller.MainController;
import com.tsfy.model.VideoInfo;
import com.tsfy.view.FooterView;
import com.tsfy.view.HeaderView;
import com.tsfy.view.HistoryView;
import com.tsfy.view.JarvisView;
import com.tsfy.view.LogView;
import com.tsfy.view.ProgressView;
import com.tsfy.view.RecentDownloadsView;
import com.tsfy.view.SidebarView;
import com.tsfy.view.StatisticsView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private final MainController controller =
        new MainController();

    @Override
    public void start(Stage janela) {

        /*
         * =====================================================
         * LAYOUT PRINCIPAL
         * =====================================================
         */

        BorderPane layout =
            new BorderPane();

        layout.getStyleClass().add(
            "layout-principal"
        );


        /*
         * =====================================================
         * COMPONENTES
         * =====================================================
         */

        HeaderView header =
            new HeaderView();

        SidebarView sidebar =
            new SidebarView();

        JarvisView jarvis =
            new JarvisView();

        HistoryView historico =
            new HistoryView();

        LogView log =
            new LogView();

        ProgressView progress =
            new ProgressView();

        FooterView footer =
            new FooterView();

        RecentDownloadsView recentes =
            new RecentDownloadsView();

        StatisticsView estatisticas =
            new StatisticsView();


        /*
         * =====================================================
         * HEADER E SIDEBAR
         * =====================================================
         */

        layout.setTop(
            header.getView()
        );

        layout.setLeft(
            sidebar.getView()
        );


        /*
         * =====================================================
         * ÁREA CENTRAL
         * =====================================================
         */

        VBox areaCentral =
            new VBox();

        areaCentral.setSpacing(
            18
        );


        /*
         * J.A.R.V.I.S.
         *
         * Fica como tela inicial.
         */

        VBox.setVgrow(
            jarvis.getView(),
            Priority.ALWAYS
        );


        /*
         * =====================================================
         * ÁREA INFERIOR
         * =====================================================
         */

        HBox areaInferior =
            new HBox();

        areaInferior.setSpacing(
            18
        );

        HBox.setHgrow(
            log.getView(),
            Priority.ALWAYS
        );

        HBox.setHgrow(
            progress.getView(),
            Priority.ALWAYS
        );

        areaInferior
            .getChildren()
            .addAll(
                log.getView(),
                progress.getView()
            );


        /*
         * =====================================================
         * PAINEL DIREITO
         * =====================================================
         */

        VBox painelDireito =
            new VBox();

        painelDireito.setSpacing(
            18
        );

        painelDireito.setPrefWidth(
            280
        );


        VBox painelRecentes =
            recentes.getView();

        painelRecentes.setPrefHeight(
            350
        );


        VBox painelEstatisticas =
            estatisticas.getView();

        painelEstatisticas.setPrefHeight(
            180
        );


        painelDireito
            .getChildren()
            .addAll(
                painelRecentes,
                painelEstatisticas
            );


        /*
         * =====================================================
         * CONTEÚDO
         * =====================================================
         */

        VBox conteudo =
            new VBox();

        conteudo.setSpacing(
            18
        );

        conteudo.setPadding(
            new Insets(18)
        );

        conteudo.getStyleClass().add(
            "conteudo"
        );


        /*
         * =====================================================
         * CORPO
         * =====================================================
         */

        HBox corpo =
            new HBox();

        corpo.setSpacing(
            18
        );

        HBox.setHgrow(
            areaCentral,
            Priority.ALWAYS
        );


        corpo
            .getChildren()
            .addAll(
                areaCentral,
                painelDireito
            );

        conteudo
            .getChildren()
            .add(
                corpo
            );

        layout.setCenter(
            conteudo
        );

        layout.setBottom(
            footer.getView()
        );


        /*
         * =====================================================
         * TELA INICIAL
         * =====================================================
         */

        areaCentral
            .getChildren()
            .addAll(
                jarvis.getView(),
                areaInferior
            );


        /*
         * =====================================================
         * BOTÃO INÍCIO
         * =====================================================
         */

        sidebar
            .getInicio()
            .setOnAction(event -> {

                areaCentral
                    .getChildren()
                    .clear();

                areaCentral
                    .getChildren()
                    .addAll(
                        jarvis.getView(),
                        areaInferior
                    );

                sidebar
                    .getInicio()
                    .getStyleClass()
                    .add(
                        "menu-button-ativo"
                    );
            });


        /*
         * =====================================================
         * BOTÃO HISTÓRICO
         * =====================================================
         */

        sidebar
            .getHistorico()
            .setOnAction(event -> {

                areaCentral
                    .getChildren()
                    .clear();

                VBox.setVgrow(
                    historico.getView(),
                    Priority.ALWAYS
                );

                areaCentral
                    .getChildren()
                    .add(
                        historico.getView()
                    );

                sidebar
                    .getHistorico()
                    .getStyleClass()
                    .add(
                        "menu-button-ativo"
                    );
            });


        /*
         * =====================================================
         * BOTÃO CONVERTER
         * =====================================================
         */

        jarvis
            .getBotaoConverter()
            .setOnAction(event -> {

                String url =
                    jarvis
                        .getCampoUrl()
                        .getText()
                        .trim();


                /*
                 * Conta o download.
                 */

                estatisticas
                    .iniciarDownload();


                /*
                 * Reseta os elementos.
                 */

                progress.resetar();

                jarvis.limpar();


                /*
                 * Log.
                 */

                log.adicionar(
                    "[SYSTEM] Consultando informações do vídeo..."
                );


                /*
                 * Desabilita o botão.
                 */

                jarvis
                    .getBotaoConverter()
                    .setDisable(
                        true
                    );


                /*
                 * Guarda as informações
                 * do vídeo atual.
                 */

                final VideoInfo[] infoAtual =
                    new VideoInfo[1];


                /*
                 * Inicia o download.
                 */

                controller.iniciarDownload(
                    url,

                    new MainController.DownloadListener() {

                        @Override
                        public void onInfo(
                            VideoInfo info
                        ) {

                            infoAtual[0] =
                                info;

                            Platform.runLater(() -> {

                                jarvis
                                    .mostrarVideo(
                                        info
                                    );

                                progress.status(
                                    "INICIANDO DOWNLOAD..."
                                );

                                log.adicionar(
                                    "[SYSTEM] Informações obtidas. Iniciando download..."
                                );
                            });
                        }


                        @Override
                        public void onProgress(
                            double valor
                        ) {

                            Platform.runLater(() -> {

                                progress
                                    .atualizar(
                                        valor
                                    );

                                log.adicionar(
                                    String.format(
                                        "[DOWNLOAD] %.1f%% concluído",
                                        valor
                                    )
                                );
                            });
                        }


                        @Override
                        public void onStatus(
                            String mensagem
                        ) {

                            Platform.runLater(() -> {

                                progress
                                    .status(
                                        mensagem
                                    );
                            });
                        }


                        @Override
                        public void onComplete(
                            String mensagem
                        ) {

                            Platform.runLater(() -> {

                                progress
                                    .status(
                                        mensagem
                                    );

                                log.adicionar(
                                    "[SYSTEM] " +
                                    mensagem
                                );


                                /*
                                 * Adiciona aos
                                 * downloads recentes.
                                 */

                                if (
                                    infoAtual[0] != null
                                ) {

                                    String titulo =
                                        infoAtual[0]
                                            .getTitulo();

                                    recentes
                                        .adicionarDownload(
                                            titulo
                                        );


                                    /*
                                     * Adiciona ao
                                     * histórico.
                                     */

                                    historico
                                        .adicionar(
                                            titulo
                                        );
                                }


                                /*
                                 * Atualiza estatísticas.
                                 */

                                estatisticas
                                    .downloadConcluido();


                                /*
                                 * Libera o botão.
                                 */

                                jarvis
                                    .getBotaoConverter()
                                    .setDisable(
                                        false
                                    );
                            });
                        }


                        @Override
                        public void onError(
                            String mensagem
                        ) {

                            Platform.runLater(() -> {

                                progress
                                    .status(
                                        mensagem
                                    );

                                log.adicionar(
                                    "[ERROR] " +
                                    mensagem
                                );


                                /*
                                 * Registra erro.
                                 */

                                estatisticas
                                    .registrarErro();


                                /*
                                 * Libera botão.
                                 */

                                jarvis
                                    .getBotaoConverter()
                                    .setDisable(
                                        false
                                    );
                            });
                        }
                    }
                );
            });


        /*
         * =====================================================
         * CENA
         * =====================================================
         */

        Scene cena =
            new Scene(
                layout,
                1250,
                750
            );

        cena.getStylesheets().add(
            getClass()
                .getResource(
                    "/style.css"
                )
                .toExternalForm()
        );


        /*
         * =====================================================
         * JANELA
         * =====================================================
         */

        janela.setTitle(
            "TSFY"
        );

        janela.setScene(
            cena
        );

        janela.show();
    }


    public static void main(
        String[] args
    ) {

        launch(args);
    }
}