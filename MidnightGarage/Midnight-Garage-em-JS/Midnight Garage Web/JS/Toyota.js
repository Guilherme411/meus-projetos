class Toyota {

    iniciar() {

        document.getElementById("btnCorolla").addEventListener("click", () => {

            const corolla = FabricaCarros.criarCarro(
                "Toyota",
                "Corolla",
                "Prata",
                "R$ 165.000"
            );

            corolla.exibirDescricao();

            const compra1 = new Compra(corolla);
            compra1.iniciar();

        });

        document.getElementById("btnSupra").addEventListener("click", () => {

            const supra = FabricaCarros.criarCarro(
                "Toyota",
                "Supra",
                "Amarelo",
                "R$ 620.000"
            );

            supra.exibirDescricao();

            const compra2 = new Compra(supra);
            compra2.iniciar();

        });

        document.getElementById("btnHilux").addEventListener("click", () => {

            const hilux = FabricaCarros.criarCarro(
                "Toyota",
                "Hilux",
                "Branco",
                "R$ 310.000"
            );

            hilux.exibirDescricao();

            const compra3 = new Compra(hilux);
            compra3.iniciar();

        });

        document.getElementById("btnSW4").addEventListener("click", () => {

            const sw4 = FabricaCarros.criarCarro(
                "Toyota",
                "SW4",
                "Preto",
                "R$ 430.000"
            );

            sw4.exibirDescricao();

            const compra4 = new Compra(sw4);
            compra4.iniciar();

        });

        document.getElementById("btnYaris").addEventListener("click", () => {

            const yaris = FabricaCarros.criarCarro(
                "Toyota",
                "Yaris",
                "Vermelho",
                "R$ 118.000"
            );

            yaris.exibirDescricao();

            const compra5 = new Compra(yaris);
            compra5.iniciar();

        });

        document.getElementById("btnCorollaCross").addEventListener("click", () => {

            const corollaCross = FabricaCarros.criarCarro(
                "Toyota",
                "Corolla Cross",
                "Cinza",
                "R$ 205.000"
            );

            corollaCross.exibirDescricao();

            const compra6 = new Compra(corollaCross);
            compra6.iniciar();

        });

        document.getElementById("btnCamry").addEventListener("click", () => {

            const camry = FabricaCarros.criarCarro(
                "Toyota",
                "Camry",
                "Branco Pérola",
                "R$ 360.000"
            );

            camry.exibirDescricao();

            const compra7 = new Compra(camry);
            compra7.iniciar();

        });

        document.getElementById("btnRAV4").addEventListener("click", () => {

            const rav4 = FabricaCarros.criarCarro(
                "Toyota",
                "RAV4",
                "Azul",
                "R$ 405.000"
            );

            rav4.exibirDescricao();

            const compra8 = new Compra(rav4);
            compra8.iniciar();

        });

        document.getElementById("btnEtios").addEventListener("click", () => {

            const etios = FabricaCarros.criarCarro(
                "Toyota",
                "Etios",
                "Prata",
                "R$ 85.000"
            );

            etios.exibirDescricao();

            const compra9 = new Compra(etios);
            compra9.iniciar();

        });

        document.getElementById("btnGR86").addEventListener("click", () => {

            const gr86 = FabricaCarros.criarCarro(
                "Toyota",
                "GR86",
                "Laranja",
                "R$ 320.000"
            );

            gr86.exibirDescricao();

            const compra10 = new Compra(gr86);
            compra10.iniciar();

        });

        document.getElementById("btnLandCruiser").addEventListener("click", () => {

            const landCruiser = FabricaCarros.criarCarro(
                "Toyota",
                "Land Cruiser",
                "Preto",
                "R$ 720.000"
            );

            landCruiser.exibirDescricao();

            const compra11 = new Compra(landCruiser);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}