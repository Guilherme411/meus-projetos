package com.tsfy.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import com.tsfy.app.AppConfig;

public class DownloaderService {

    public String baixar(
        String url,
        Consumer<String> callback
    ) {

        try {

            ProcessBuilder processo = new ProcessBuilder(
                AppConfig.YT_DLP,
                "-f",
                "bestaudio",
                "-x",
                "--audio-format",
                "mp3",
                "-o",
                AppConfig.DOWNLOADS + "/%(title)s.%(ext)s",
                url
            );

            processo.redirectErrorStream(true);

            Process executar = processo.start();

            BufferedReader leitor =
                new BufferedReader(
                    new InputStreamReader(
                        executar.getInputStream()
                    )
                );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                if (callback != null) {
                    callback.accept(linha);
                }
            }

            int codigo = executar.waitFor();

            if (codigo == 0) {
                return "Download concluído!";
            }

            return "Erro ao realizar o download.";

        } catch (Exception erro) {

            erro.printStackTrace();

            return "Erro ao realizar o download.";
        }
    }
}