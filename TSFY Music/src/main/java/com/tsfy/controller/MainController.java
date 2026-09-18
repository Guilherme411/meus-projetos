package com.tsfy.controller;

import java.util.function.Consumer;

import com.tsfy.model.VideoInfo;
import com.tsfy.service.DownloaderService;
import com.tsfy.service.VideoInfoService;

public class MainController {

    private final DownloaderService downloaderService;
    private final VideoInfoService videoInfoService;

    public MainController() {

        downloaderService = new DownloaderService();
        videoInfoService = new VideoInfoService();
    }

    public interface DownloadListener {

        void onInfo(VideoInfo info);

        void onProgress(double progresso);

        void onStatus(String mensagem);

        void onComplete(String mensagem);

        void onError(String mensagem);
    }

    public void iniciarDownload(
        String url,
        DownloadListener listener
    ) {

        if (url == null || url.isBlank()) {

            listener.onError(
                "DIGITE UMA URL DO YOUTUBE."
            );

            return;
        }

        Thread thread = new Thread(() -> {

            listener.onStatus(
                "BUSCANDO INFORMAÇÕES..."
            );

            VideoInfo info =
                videoInfoService.buscar(url);

            if (info == null) {

                listener.onError(
                    "ERRO AO BUSCAR INFORMAÇÕES."
                );

                return;
            }

            listener.onInfo(info);

            listener.onStatus(
                "INICIANDO DOWNLOAD..."
            );

            String mensagem =
                downloaderService.baixar(
                    url,
                    linha -> {

                        Double progresso =
                            extrairProgresso(linha);

                        if (progresso != null) {

                            listener.onProgress(
                                progresso
                            );
                        }
                    }
                );

            listener.onComplete(mensagem);

        });

        thread.setDaemon(true);
        thread.start();
    }

    private Double extrairProgresso(String linha) {

        if (linha == null || !linha.contains("%")) {
            return null;
        }

        try {

            String porcentagem =
                linha
                    .substring(
                        0,
                        linha.indexOf("%")
                    )
                    .replaceAll(
                        "[^0-9.]",
                        ""
                    );

            if (porcentagem.isBlank()) {
                return null;
            }

            return Double.parseDouble(
                porcentagem
            );

        } catch (Exception erro) {

            return null;
        }
    }
}