class Honda {

    iniciar() {

        document.getElementById("btnCivic").addEventListener("click", () => {

            const civic = FabricaCarros.criarCarro(
                "Honda",
                "Civic",
                "Prata",
                "R$ 150.000"
            );

            civic.exibirDescricao();

            const compra1 = new Compra(civic);
            compra1.iniciar();

        });

        document.getElementById("btnNSX").addEventListener("click", () => {

            const nsx = FabricaCarros.criarCarro(
                "Honda",
                "NSX",
                "Vermelho",
                "R$ 800.000"
            );

            nsx.exibirDescricao();

            const compra2 = new Compra(nsx);
            compra2.iniciar();

        });

        document.getElementById("btnCity").addEventListener("click", () => {

            const city = FabricaCarros.criarCarro(
                "Honda",
                "City",
                "Branco",
                "R$ 120.000"
            );

            city.exibirDescricao();

            const compra3 = new Compra(city);
            compra3.iniciar();

        });

        document.getElementById("btnHRV").addEventListener("click", () => {

            const hrv = FabricaCarros.criarCarro(
                "Honda",
                "HR-V",
                "Cinza",
                "R$ 165.000"
            );

            hrv.exibirDescricao();

            const compra4 = new Compra(hrv);
            compra4.iniciar();

        });

        document.getElementById("btnWRV").addEventListener("click", () => {

            const wrv = FabricaCarros.criarCarro(
                "Honda",
                "WR-V",
                "Azul",
                "R$ 135.000"
            );

            wrv.exibirDescricao();

            const compra5 = new Compra(wrv);
            compra5.iniciar();

        });

        document.getElementById("btnFit").addEventListener("click", () => {

            const fit = FabricaCarros.criarCarro(
                "Honda",
                "Fit",
                "Preto",
                "R$ 95.000"
            );

            fit.exibirDescricao();

            const compra6 = new Compra(fit);
            compra6.iniciar();

        });

        document.getElementById("btnAccord").addEventListener("click", () => {

            const accord = FabricaCarros.criarCarro(
                "Honda",
                "Accord",
                "Preto",
                "R$ 320.000"
            );

            accord.exibirDescricao();

            const compra7 = new Compra(accord);
            compra7.iniciar();

        });

        document.getElementById("btnCRV").addEventListener("click", () => {

            const crv = FabricaCarros.criarCarro(
                "Honda",
                "CR-V",
                "Branco Pérola",
                "R$ 280.000"
            );

            crv.exibirDescricao();

            const compra8 = new Compra(crv);
            compra8.iniciar();

        });

        document.getElementById("btnPilot").addEventListener("click", () => {

            const pilot = FabricaCarros.criarCarro(
                "Honda",
                "Pilot",
                "Cinza Grafite",
                "R$ 410.000"
            );

            pilot.exibirDescricao();

            const compra9 = new Compra(pilot);
            compra9.iniciar();

        });

        document.getElementById("btnZRV").addEventListener("click", () => {

            const zrv = FabricaCarros.criarCarro(
                "Honda",
                "ZR-V",
                "Azul Metálico",
                "R$ 215.000"
            );

            zrv.exibirDescricao();

            const compra10 = new Compra(zrv);
            compra10.iniciar();

        });

        document.getElementById("btnCivicTypeR").addEventListener("click", () => {

            const typer = FabricaCarros.criarCarro(
                "Honda",
                "Civic Type R",
                "Championship White",
                "R$ 430.000"
            );

            typer.exibirDescricao();

            const compra11 = new Compra(typer);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}