class Chevrolet {

    iniciar() {

        document.getElementById("btnOnix").addEventListener("click", () => {

            const onix = FabricaCarros.criarCarro(
                "Chevrolet",
                "Onix",
                "Branco",
                "R$ 95.000"
            );

            onix.exibirDescricao();

            const compra1 = new Compra(onix);
            compra1.iniciar();

        });

        document.getElementById("btnCamaro").addEventListener("click", () => {

            const camaro = FabricaCarros.criarCarro(
                "Chevrolet",
                "Camaro",
                "Amarelo",
                "R$ 540.000"
            );

            camaro.exibirDescricao();

            const compra2 = new Compra(camaro);
            compra2.iniciar();

        });

        document.getElementById("btnCruze").addEventListener("click", () => {

            const cruze = FabricaCarros.criarCarro(
                "Chevrolet",
                "Cruze",
                "Preto",
                "R$ 145.000"
            );

            cruze.exibirDescricao();

            const compra3 = new Compra(cruze);
            compra3.iniciar();

        });

        document.getElementById("btnTracker").addEventListener("click", () => {

            const tracker = FabricaCarros.criarCarro(
                "Chevrolet",
                "Tracker",
                "Cinza",
                "R$ 175.000"
            );

            tracker.exibirDescricao();

            const compra4 = new Compra(tracker);
            compra4.iniciar();

        });

        document.getElementById("btnS10").addEventListener("click", () => {

            const s10 = FabricaCarros.criarCarro(
                "Chevrolet",
                "S10",
                "Branco",
                "R$ 295.000"
            );

            s10.exibirDescricao();

            const compra5 = new Compra(s10);
            compra5.iniciar();

        });

        document.getElementById("btnMontana").addEventListener("click", () => {

            const montana = FabricaCarros.criarCarro(
                "Chevrolet",
                "Montana",
                "Vermelho",
                "R$ 145.000"
            );

            montana.exibirDescricao();

            const compra6 = new Compra(montana);
            compra6.iniciar();

        });

        document.getElementById("btnSpin").addEventListener("click", () => {

            const spin = FabricaCarros.criarCarro(
                "Chevrolet",
                "Spin",
                "Prata",
                "R$ 135.000"
            );

            spin.exibirDescricao();

            const compra7 = new Compra(spin);
            compra7.iniciar();

        });

        document.getElementById("btnEquinox").addEventListener("click", () => {

            const equinox = FabricaCarros.criarCarro(
                "Chevrolet",
                "Equinox",
                "Azul",
                "R$ 275.000"
            );

            equinox.exibirDescricao();

            const compra8 = new Compra(equinox);
            compra8.iniciar();

        });

        document.getElementById("btnBlazer").addEventListener("click", () => {

            const blazer = FabricaCarros.criarCarro(
                "Chevrolet",
                "Blazer",
                "Preto",
                "R$ 395.000"
            );

            blazer.exibirDescricao();

            const compra9 = new Compra(blazer);
            compra9.iniciar();

        });

        document.getElementById("btnCobalt").addEventListener("click", () => {

            const cobalt = FabricaCarros.criarCarro(
                "Chevrolet",
                "Cobalt",
                "Cinza",
                "R$ 82.000"
            );

            cobalt.exibirDescricao();

            const compra10 = new Compra(cobalt);
            compra10.iniciar();

        });

        document.getElementById("btnAstra").addEventListener("click", () => {

            const astra = FabricaCarros.criarCarro(
                "Chevrolet",
                "Astra",
                "Prata",
                "R$ 68.000"
            );

            astra.exibirDescricao();

            const compra11 = new Compra(astra);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}