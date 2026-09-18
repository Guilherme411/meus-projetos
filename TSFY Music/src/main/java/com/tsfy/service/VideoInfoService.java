package com.tsfy.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.tsfy.app.AppConfig;
import com.tsfy.model.VideoInfo;

public class VideoInfoService {

    public VideoInfo buscar(String url) {

        try {

            ProcessBuilder processo = new ProcessBuilder(
                AppConfig.YT_DLP,

                "--quiet",
                "--no-warnings",

                "--print",
                "%(title)s",

                "--print",
                "%(uploader)s",

                "--print",
                "%(duration_string)s",

                "--print",
                "%(thumbnail)s",

                "--skip-download",
                "--no-playlist",

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

            String titulo = leitor.readLine();
            String canal = leitor.readLine();
            String duracao = leitor.readLine();
            String thumbnail = leitor.readLine();

            executar.waitFor();

            if (
                titulo == null ||
                canal == null ||
                duracao == null ||
                thumbnail == null
            ) {

                return null;
            }

            return new VideoInfo(
                titulo,
                canal,
                duracao,
                thumbnail
            );

        } catch (Exception erro) {

            erro.printStackTrace();

            return null;
        }
    }
}