class Nissan {

    iniciar() {

        document.getElementById("btnVersa").addEventListener("click", () => {

            const versa = FabricaCarros.criarCarro(
                "Nissan",
                "Versa",
                "Branco",
                "R$ 118.000"
            );

            versa.exibirDescricao();

            const compra1 = new Compra(versa);
            compra1.iniciar();

        });

        document.getElementById("btnSentra").addEventListener("click", () => {

            const sentra = FabricaCarros.criarCarro(
                "Nissan",
                "Sentra",
                "Cinza",
                "R$ 178.000"
            );

            sentra.exibirDescricao();

            const compra2 = new Compra(sentra);
            compra2.iniciar();

        });

        document.getElementById("btnKicks").addEventListener("click", () => {

            const kicks = FabricaCarros.criarCarro(
                "Nissan",
                "Kicks",
                "Vermelho",
                "R$ 165.000"
            );

            kicks.exibirDescricao();

            const compra3 = new Compra(kicks);
            compra3.iniciar();

        });

        document.getElementById("btnFrontier").addEventListener("click", () => {

            const frontier = FabricaCarros.criarCarro(
                "Nissan",
                "Frontier",
                "Preto",
                "R$ 315.000"
            );

            frontier.exibirDescricao();

            const compra4 = new Compra(frontier);
            compra4.iniciar();

        });

        document.getElementById("btnGTRR35").addEventListener("click", () => {

            const gtr = FabricaCarros.criarCarro(
                "Nissan",
                "GT-R R35",
                "Cinza",
                "R$ 1.200.000"
            );

            gtr.exibirDescricao();

            const compra5 = new Compra(gtr);
            compra5.iniciar();

        });

        document.getElementById("btn350Z").addEventListener("click", () => {

            const z350 = FabricaCarros.criarCarro(
                "Nissan",
                "350Z",
                "Laranja",
                "R$ 240.000"
            );

            z350.exibirDescricao();

            const compra6 = new Compra(z350);
            compra6.iniciar();

        });

        document.getElementById("btn370Z").addEventListener("click", () => {

            const z370 = FabricaCarros.criarCarro(
                "Nissan",
                "370Z",
                "Branco",
                "R$ 310.000"
            );

            z370.exibirDescricao();

            const compra7 = new Compra(z370);
            compra7.iniciar();

        });

        document.getElementById("btnSkylineR34").addEventListener("click", () => {

            const skyline = FabricaCarros.criarCarro(
                "Nissan",
                "Skyline GT-R R34",
                "Azul Bayside",
                "R$ 2.000.000"
            );

            skyline.exibirDescricao();

            const compra8 = new Compra(skyline);
            compra8.iniciar();

        });

        document.getElementById("btnXTrail").addEventListener("click", () => {

            const xtrail = FabricaCarros.criarCarro(
                "Nissan",
                "X-Trail",
                "Prata",
                "R$ 210.000"
            );

            xtrail.exibirDescricao();

            const compra9 = new Compra(xtrail);
            compra9.iniciar();

        });

        document.getElementById("btnMarch").addEventListener("click", () => {

            const march = FabricaCarros.criarCarro(
                "Nissan",
                "March",
                "Vermelho",
                "R$ 72.000"
            );

            march.exibirDescricao();

            const compra10 = new Compra(march);
            compra10.iniciar();

        });

        document.getElementById("btnAltima").addEventListener("click", () => {

            const altima = FabricaCarros.criarCarro(
                "Nissan",
                "Altima",
                "Preto",
                "R$ 220.000"
            );

            altima.exibirDescricao();

            const compra11 = new Compra(altima);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}