class Volkswagen {

    iniciar() {

        document.getElementById("btnGol").addEventListener("click", () => {

            const gol = FabricaCarros.criarCarro(
                "Volkswagen",
                "Gol",
                "Branco",
                "R$ 82.000"
            );

            gol.exibirDescricao();

            const compra1 = new Compra(gol);
            compra1.iniciar();

        });

        document.getElementById("btnPolo").addEventListener("click", () => {

            const polo = FabricaCarros.criarCarro(
                "Volkswagen",
                "Polo",
                "Prata",
                "R$ 110.000"
            );

            polo.exibirDescricao();

            const compra2 = new Compra(polo);
            compra2.iniciar();

        });

        document.getElementById("btnJetta").addEventListener("click", () => {

            const jetta = FabricaCarros.criarCarro(
                "Volkswagen",
                "Jetta",
                "Preto",
                "R$ 235.000"
            );

            jetta.exibirDescricao();

            const compra3 = new Compra(jetta);
            compra3.iniciar();

        });

        document.getElementById("btnGolfGTI").addEventListener("click", () => {

            const golf = FabricaCarros.criarCarro(
                "Volkswagen",
                "Golf GTI",
                "Vermelho",
                "R$ 340.000"
            );

            golf.exibirDescricao();

            const compra4 = new Compra(golf);
            compra4.iniciar();

        });

        document.getElementById("btnSaveiro").addEventListener("click", () => {

            const saveiro = FabricaCarros.criarCarro(
                "Volkswagen",
                "Saveiro",
                "Branco",
                "R$ 120.000"
            );

            saveiro.exibirDescricao();

            const compra5 = new Compra(saveiro);
            compra5.iniciar();

        });

        document.getElementById("btnAmarok").addEventListener("click", () => {

            const amarok = FabricaCarros.criarCarro(
                "Volkswagen",
                "Amarok",
                "Cinza",
                "R$ 325.000"
            );

            amarok.exibirDescricao();

            const compra6 = new Compra(amarok);
            compra6.iniciar();

        });

        document.getElementById("btnVirtus").addEventListener("click", () => {

            const virtus = FabricaCarros.criarCarro(
                "Volkswagen",
                "Virtus",
                "Azul",
                "R$ 125.000"
            );

            virtus.exibirDescricao();

            const compra7 = new Compra(virtus);
            compra7.iniciar();

        });

        document.getElementById("btnNivus").addEventListener("click", () => {

            const nivus = FabricaCarros.criarCarro(
                "Volkswagen",
                "Nivus",
                "Cinza",
                "R$ 155.000"
            );

            nivus.exibirDescricao();

            const compra8 = new Compra(nivus);
            compra8.iniciar();

        });

        document.getElementById("btnTCross").addEventListener("click", () => {

            const tcross = FabricaCarros.criarCarro(
                "Volkswagen",
                "T-Cross",
                "Preto",
                "R$ 175.000"
            );

            tcross.exibirDescricao();

            const compra9 = new Compra(tcross);
            compra9.iniciar();

        });

        document.getElementById("btnPassat").addEventListener("click", () => {

            const passat = FabricaCarros.criarCarro(
                "Volkswagen",
                "Passat",
                "Prata",
                "R$ 185.000"
            );

            passat.exibirDescricao();

            const compra10 = new Compra(passat);
            compra10.iniciar();

        });

        document.getElementById("btnFusca").addEventListener("click", () => {

            const fusca = FabricaCarros.criarCarro(
                "Volkswagen",
                "Fusca",
                "Azul",
                "R$ 70.000"
            );

            fusca.exibirDescricao();

            const compra11 = new Compra(fusca);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}